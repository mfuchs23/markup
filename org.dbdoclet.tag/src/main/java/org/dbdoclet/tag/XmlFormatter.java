/* 
 * ### Copyright (C) 2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.dbdoclet.option.BooleanOption;
import org.dbdoclet.option.FileOption;
import org.dbdoclet.option.Option;
import org.dbdoclet.option.OptionException;
import org.dbdoclet.option.OptionList;
import org.dbdoclet.xiphias.NodeSerializer;
import org.dbdoclet.xiphias.XmlServices;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlFormatter {

	public static void main(String[] args) {

		OptionList options = null;

		try {

			Option<?> option;
			FileOption optFile;

			options = new OptionList(args);

			option = new BooleanOption("help", "h");
			options.add(option);

			optFile = new FileOption("file", "f");
			optFile.isRequired(true);
			options.add(optFile);

			if (options.validate() == false) {
				throw new OptionException(options.getError());
			}

			if (options.getFlag("help", false)) {
				usage();
				return;
			}

			XmlFormatter formatter = new XmlFormatter();

			String buffer = formatter.format(optFile.getValue());
			System.out.print(buffer);

		} catch (OptionException oops) {

			if ((options != null) && (options.getFlag("help", false) == false)) {
				System.out.println(oops.getMessage());
			}

			usage();

		} catch (Throwable oops) {

			oops.printStackTrace();
		}
	}

	public static void usage() {

		System.out.println("Syntax: ");
	}

	public String format(File file) throws IOException, SAXException,
			ParserConfigurationException {

		Document doc = XmlServices.parse(file);
		return NodeSerializer.toXML(doc);
	}

}
