/* 
 * $Id$
 *
 * ### Copyright (C) 2006 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 *
 * Author..........: mfuchs
 * Created at......: 2006-12-21
 * Last change.....: ((WRITESTAMP))
 */
package org.dbdoclet.tag;

import java.io.File;
import java.util.Locale;

import org.dbdoclet.option.BooleanOption;
import org.dbdoclet.option.FileOption;
import org.dbdoclet.option.OptionList;
import org.dbdoclet.option.StringOption;
import org.dbdoclet.xiphias.DInc;

public class Dine {

    public static void main(String[] args) {

	OptionList options = new OptionList(args);

	BooleanOption optHelp = new BooleanOption("help", "h");
	optHelp.setMediumName("help");
	options.add(optHelp);

	FileOption optFile = new FileOption("file", "f");
	optFile.setMediumName("file");
	optFile.isRequired(true);
	optFile.isExisting(true);
	options.add(optFile);

	StringOption optLanguage = new StringOption("language", "lang");
	optLanguage.setMediumName("lang");
	options.add(optLanguage);

	boolean valid = options.validate();

	if (options.getFlag("help", false)) {
	    usage(options.getError());
	    return;
	}

	if (valid == false) {
	    usage(options.getError());
	    return;
	}

	Locale.getDefault();

	if (optLanguage.isValid()) {

	    String lang = options.getString("language");
	    lang = lang.toLowerCase();
	    new Locale(lang);
	}

	File file = optFile.getValue();

	try {

	    DInc dinc = new DInc();
	    dinc.merge(file, null, null);

	} catch (Throwable oops) {

	    oops.printStackTrace();
	}
    }

    public static void usage(String msg) {

	if (msg != null && msg.length() > 0) {
	    System.out.println(msg);
	}

	System.out.println("Syntax: Dine");
    }
}
