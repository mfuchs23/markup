/* 
 * $Id$
 *
 * ### Copyright (C) 2006 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias;

import java.io.File;
import java.io.StringReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import org.dbdoclet.service.ResourceServices;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 * Die Klasse <code>XmlValidationResult</code> wird benachrichtigt falls beim
 * Parsen einer XML-Datei ein Fehler auftritt.
 * 
 * Die Fehlermeldungen werden formatiert und auf <code>System.err</code> über
 * die Konsole ausgegeben.
 * 
 * @author <a href="mailto:michael.fuchs@unico-group.com">Michael Fuchs</a>
 * @version 1.0
 */
public class XmlValidationResult implements ErrorHandler, LSResourceResolver {

	private boolean hasErrors = false;
	private boolean fileNotFound = false;
	private boolean canNotRead = false;

	private int errorCounter = 0;
	private final ArrayList<String> errorList;
	private final ArrayList<String> warningList;
	private final ArrayList<Throwable> exceptionList;
	private Throwable throwable;

	private final File xmlFile;
	private final ResourceBundle res;
	private String systemId;

	public XmlValidationResult(File xmlFile, Locale locale) {

		if (locale == null) {
			throw new IllegalArgumentException(
					"The argument locale must not be null!");
		}

		this.xmlFile = xmlFile;
		res = ResourceBundle
				.getBundle("org/dbdoclet/xiphias/Resources", locale);

		errorList = new ArrayList<String>();
		warningList = new ArrayList<String>();
		exceptionList = new ArrayList<Throwable>();
	}

	public XmlValidationResult(File xmlFile) {

		this(xmlFile, Locale.getDefault());
	}

	public XmlValidationResult(String systemId) {

		this(null, Locale.getDefault());
		this.systemId = systemId;
	}

	public File getXmlFile() {
		return xmlFile;
	}

	public String getSourceDescription() {

		if (xmlFile != null) {
			return xmlFile.getAbsolutePath();
		} else {

			if (systemId == null || systemId.length() == 0) {
				return "Anonymous InputStream";
			} else {
				return systemId;
			}
		}
	}

	public boolean failed() {
		return hasErrors;
	}

	public void setFileNotFound(boolean fileNotFound) {

		this.fileNotFound = fileNotFound;

		String msg = MessageFormat.format(ResourceServices.getString(res,
				"C_XML_VALIDATION_ERROR_FILE_NOT_FOUND"),
				getSourceDescription());
		errorList.add(msg);
		hasErrors = true;
		errorCounter++;
	}

	public boolean getFileNotFound() {
		return fileNotFound;
	}

	public void setCanNotRead(boolean canNotRead) {

		this.canNotRead = canNotRead;

		String msg = MessageFormat.format(
				res.getString("C_XML_VALIDATION_ERROR_FILE_CAN_NOT_READ"),
				getSourceDescription());
		errorList.add(msg);
		hasErrors = true;
		errorCounter++;
	}

	public boolean getCanNotRead() {
		return canNotRead;
	}

	public int getNumOfErrors() {
		return errorCounter;
	}

	public void setThrowable(Throwable throwable) {

		if (throwable == null) {
			throw new IllegalArgumentException(
					"The argument throwable must not be null!");
		}

		this.throwable = throwable;

		String msg = "(" + throwable.getClass().getName() + ") "
				+ throwable.getMessage();

		if (msg == null || msg.length() == 0) {
			msg = throwable.getClass().getName();
		}

		msg = getSourceDescription() + ": " + msg;
		errorList.add(msg);
		hasErrors = true;
		errorCounter++;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * Die Methode <code>fatalError</code> wird bei Auftreten eines fatalen
	 * Fehlers vom Sax-Parser aufgerufen.
	 * 
	 * @param oops
	 *            <code>SAXParseException</code>
	 */
	@Override
	public void fatalError(SAXParseException oops) {

		errorCounter++;

		String msg = MessageFormat.format(
				ResourceServices.getString(res, "C_XML_VALIDATION_FATAL"),
				getSourceDescription(), String.valueOf(oops.getLineNumber()),
				String.valueOf(oops.getColumnNumber()), oops.getMessage());

		errorList.add(msg);
		exceptionList.add(oops);

		hasErrors = true;
	}

	/**
	 * Die Methode <code>error</code> wird bei Auftreten eines Fehlers vom
	 * Sax-Parser aufgerufen.
	 * 
	 * @param oops
	 *            <code>SAXParseException</code>
	 */
	@Override
	public void error(SAXParseException oops) {

		errorCounter++;

		String msg = MessageFormat.format(
				ResourceServices.getString(res, "C_XML_VALIDATION_ERROR"),
				getSourceDescription(), String.valueOf(oops.getLineNumber()),
				String.valueOf(oops.getColumnNumber()), oops.getMessage());

		errorList.add(msg);
		exceptionList.add(oops);

		hasErrors = true;
	}

	/**
	 * Die Methode <code>warning</code> wird bei Auftreten einer Warnung vom
	 * SAX-Parser aufgerufen.
	 * 
	 * @param oops
	 *            <code>SAXParseException</code>
	 */
	@Override
	public void warning(SAXParseException oops) {

		String msg = MessageFormat.format(
				ResourceServices.getString(res, "C_XML_VALIDATION_WARNING"),
				getSourceDescription(), String.valueOf(oops.getLineNumber()),
				String.valueOf(oops.getColumnNumber()), oops.getMessage());

		warningList.add(msg);
		// exceptionList.add(oops);
	}

	public String createTextReport() {
		return createReport(false);
	}

	public String createHtmlReport() {
		return createReport(true);
	}

	public String createReport(boolean isHtml) {

		String msg;

		StringBuffer buffer = new StringBuffer();

		buffer.append('\n');

		if (isHtml) {
			buffer.append("<p>");
		}

		msg = MessageFormat.format(
				ResourceServices.getString(res, "C_XML_VALIDATION_OF_FILE"),
				getSourceDescription());
		buffer.append(msg);

		if (isHtml) {
			buffer.append("</p>");
		}

		Iterator<String> iterator = warningList.iterator();

		while (iterator.hasNext()) {

			if (isHtml) {
				buffer.append("<pre>");
			}

			buffer.append('\n');

			msg = iterator.next();
			buffer.append(msg);

			if (isHtml) {
				buffer.append("</pre>");
			}

			buffer.append('\n');
		}

		buffer.append('\n');

		if (failed() == false) {

			if (isHtml) {
				buffer.append("<p><b>");
				buffer.append(ResourceServices.getString(res,
						"C_XML_VALIDATION_SUCCESSFUL"));
				buffer.append("</b></p>");
			} else {
				buffer.append(ResourceServices.getString(res,
						"C_XML_VALIDATION_SUCCESSFUL"));
			}

			buffer.append('\n');

		} else {

			iterator = errorList.iterator();

			while (iterator.hasNext()) {

				if (isHtml) {
					buffer.append("<pre>");
				}

				buffer.append('\n');

				msg = iterator.next();
				buffer.append(msg);

				if (isHtml) {
					buffer.append("</pre>");
				}

				buffer.append('\n');
			}

			buffer.append('\n');
			msg = MessageFormat.format(ResourceServices.getString(res,
					"C_XML_VALIDATION_NUMBER_OF_ERRORS"), String
					.valueOf(errorCounter));
			buffer.append(msg);
			buffer.append('\n');

			if (isHtml) {
				buffer.append("<p><b>");
				buffer.append(ResourceServices.getString(res,
						"C_XML_VALIDATION_FAILED"));
				buffer.append("</b></p>");
			} else {
				buffer.append(ResourceServices.getString(res,
						"C_XML_VALIDATION_FAILED"));
			}

			buffer.append('\n');
		}

		return buffer.toString();
	}

	@Override
	public LSInput resolveResource(String type, String namespaceURI,
			String publicId, String systemId, String baseURI) {

		// System.out.println("XMLValidationResult: Resolving resource [type=" +
		// type
		// + ", namespaceURI=" + namespaceURI + ", publicId=" + publicId +
		// ", systemId="
		// + systemId + ", baseURI=" + baseURI);

		if (systemId != null && systemId.length() > 0) {

			if (systemId.startsWith("http://")) {

				try {

					DOMImplementationRegistry registry = DOMImplementationRegistry
							.newInstance();
					DOMImplementationLS domImpl = (DOMImplementationLS) registry
							.getDOMImplementation("LS");
					LSInput input = domImpl.createLSInput();
					input.setCharacterStream(new StringReader(""));
					return input;

				} catch (Exception oops) {
					oops.printStackTrace();
				}

			}
		}

		return null;
	}
}
