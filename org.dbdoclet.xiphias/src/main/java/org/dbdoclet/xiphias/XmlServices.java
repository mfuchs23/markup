/* 
+ * $Id$
 *
 * ### Copyright (C) 2003-2007 Michael Fuchs ###
 * ### All Rights
 Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.resolver.tools.CatalogResolver;
import org.dbdoclet.service.FileServices;
import org.dbdoclet.service.ReplaceServices;
import org.dbdoclet.service.StringServices;
import org.dbdoclet.service.UnicodeServices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Die Klasse <code>XmlServices</code> stellt eine Sammlung statischer Methoden
 * zur Bearbeitung von XML zur Verfügung.
 * 
 * @author <a href="mailto:michael.fuchs@unico-group.com">Michael Fuchs</a>
 * @version 1.0
 */
public class XmlServices {

	public enum HyphenationChar {
		SOFT_HYPHEN, ZERO_WIDTH_SPACE
	}

	public static HyphenationChar hyphenationChar = HyphenationChar.ZERO_WIDTH_SPACE;
	public static final String test = "&nbsp;";
	private static final Pattern encPattern = Pattern
			.compile("^(?i).*<\\?xml\\s*.*encoding=['\"](.*)['\"].*\\?>.*$");

	private static Log logger = LogFactory.getLog(XmlServices.class);
	private static final Pattern startsWithDigitPattern = Pattern
			.compile("^[0-9].*$");

	static {
		System.setProperty("xml.catalog.ignoreMissing", "yes");
	}

	/**
	 * Die Methode <code>findDocBookTextLength</code> liefert die Textposition
	 * innerhalb eines DocBook XML-Zeichenpuffers ohne Berücksichtigung der Tags
	 * und Entities(!). Ebenso wird alles innerhalb von indexterm-Tags
	 * ignoriert.
	 * 
	 * @param buffer
	 *            <code>String</code>
	 * @param index
	 *            <code>int</code>
	 * @return <code>int</code>
	 */
	public static int findDocBookTextIndex(String buffer, int index) {

		char c;
		int length = 0;

		Stack<String> blocked = new Stack<String>();
		StringBuffer tagName;
		String openTag;
		String closingTag;

		for (int i = 0; i < buffer.length(); i++) {

			c = buffer.charAt(i);

			if (c == '<') {

				tagName = new StringBuffer();

				while (c != '>' && i < buffer.length()) {
					c = buffer.charAt(i++);
					tagName.append(c);
				}

				if (tagName.toString().startsWith("</")) {

					closingTag = tagName.toString();

					if (closingTag.equals("</indexterm>")) {

						if (blocked.empty() == false) {
							blocked.pop();
						}
					}

				} else {

					openTag = tagName.toString();

					if (openTag.equals("<indexterm>")) {
						blocked.push(openTag);
					}
				}

				i--;

				continue;
			}

			if (c == '&') {

				c = buffer.charAt(i++);

				while (c != ';' && c != ' ' && c != '\t' && c != '\r'
						&& c != '\n' && i < buffer.length()) {

					c = buffer.charAt(i++);
				}

				i--;

				continue;
			}

			if (length == index) {
				return i;
			}

			if (blocked.size() == 0) {
				length++;
			}

		}

		return -1;
	}

	/**
	 * Die Methode <code>findXmlTextLength</code> liefert die Textposition
	 * innerhalb eines XML-Zeichenpuffers ohne Berücksichtigung der Tags und
	 * Entities(!).
	 * 
	 * @param buffer
	 *            <code>String</code>
	 * @param index
	 *            <code>int</code>
	 * @return <code>int</code>
	 */
	public static int findXmlTextIndex(String buffer, int index) {

		char c;
		int length = 0;

		for (int i = 0; i < buffer.length(); i++) {

			c = buffer.charAt(i);

			if (c == '<') {

				while (c != '>' && i < buffer.length()) {
					c = buffer.charAt(i++);
				}

				i--;

				continue;
			}

			if (c == '&') {

				c = buffer.charAt(i++);

				while (c != ';' && c != ' ' && c != '\t' && c != '\r'
						&& c != '\n' && i < buffer.length()) {

					c = buffer.charAt(i++);
				}

				i--;

				continue;
			}

			if (length == index) {
				return i;
			}

			length++;

		}

		return -1;
	}

	/**
	 * Die Methode <code>getDocBookTextLength</code> liefert die reine Textlänge
	 * eines DocBook XML-Zeichenpuffers.
	 * 
	 * Tags und Entities(!) gehen nicht in die Berechnung der Länge ein. Ebenso
	 * wird alles innerhalb eines indexterm-Tags ignoriert.
	 * 
	 * @param buffer
	 *            <code>String</code>
	 * @return <code>int</code>
	 */
	public static int getDocBookTextLength(String buffer) {

		return getDocBookTextLength(new StringBuffer(buffer));
	}

	/**
	 * Die Methode <code>getDocBookTextLength</code> liefert die reine Textlänge
	 * eines DocBook XML-Zeichenpuffers.
	 * 
	 * Tags und Entities(!) gehen nicht in die Berechnung der Länge ein. Ebenso
	 * wird alles innerhalb von indexterm-Tags ignoriert.
	 * 
	 * @param buffer
	 *            <code>StringBuffer</code>
	 * @return <code>int</code>
	 */
	public static int getDocBookTextLength(StringBuffer buffer) {

		char c;
		int length = 0;
		Stack<String> blocked = new Stack<String>();
		StringBuffer tagName;
		String openTag;
		String closingTag;

		for (int i = 0; i < buffer.length(); i++) {

			c = buffer.charAt(i);

			if (c == '<') {

				tagName = new StringBuffer();

				while (c != '>' && i < buffer.length()) {
					c = buffer.charAt(i++);
					tagName.append(c);
				}

				// System.out.println("tag=" + tagName.toString());

				if (tagName.toString().startsWith("</")) {

					closingTag = tagName.toString();

					if (closingTag.equals("</indexterm>")) {

						if (blocked.empty() == false) {
							blocked.pop();
						}
					}

				} else {

					openTag = tagName.toString();

					if (openTag.equals("<indexterm>")) {
						blocked.push(openTag);
					}
				}

				i--;

				continue;
			}

			if (c == '&') {

				c = buffer.charAt(i++);

				while (c != ';' && c != ' ' && c != '\t' && c != '\r'
						&& c != '\n' && i < buffer.length()) {

					c = buffer.charAt(i++);
				}

				i--;

				continue;
			}

			if (blocked.size() == 0) {
				length++;
			}
		}

		return length;
	}

	public static String getEncoding(File source) throws IOException {

		if (source == null) {
			throw new IllegalArgumentException(
					"The argument source must not be null!");
		}

		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(source));
			String line;

			Matcher matcher;

			while ((line = reader.readLine()) != null) {

				logger.debug("line=" + line);

				matcher = encPattern.matcher(line);

				if (matcher.matches()) {
					return matcher.group(1);
				}
			}

		} finally {

			if (reader != null) {
				reader.close();
			}
		}

		return "UTF-8";
	}

	public static String getEncoding(String source) throws IOException {

		if (source == null) {
			throw new IllegalArgumentException(
					"The argument source must not be null!");
		}

		BufferedReader reader = new BufferedReader(new StringReader(source));
		String line;

		Matcher matcher;

		while ((line = reader.readLine()) != null) {

			matcher = encPattern.matcher(line);

			if (matcher.matches()) {
				return matcher.group(1);
			}
		}

		return "UTF-8";
	}

	/**
	 * Erstellt den Pfadnamen des Elements vom Wurzelelement ab. Die einzelnen
	 * Elemente werden durch einen Schrägstrich voneinander getrennt, z.B.
	 * /Dokument/Kapitel/Absatz.
	 * 
	 * @param element
	 * @return String
	 */
	public static String getFullyQualifiedElementName(Element element) {

		if (element == null) {
			return null;
		}

		Stack<String> stack = new Stack<String>();

		Element parent = element;

		while (parent != null) {
			stack.push(parent.getTagName());
			parent = (Element) parent.getParentNode();
		}

		StringBuilder buffer = new StringBuilder();
		buffer.append('/');

		while (stack.isEmpty() == false) {

			buffer.append(stack.pop());

			if (stack.isEmpty() == false) {
				buffer.append('/');
			}
		}

		return buffer.toString();
	}

	/**
	 * Die Methode <code>getXmlTextLength</code> liefert die reine Textlänge
	 * eines XML-Zeichenpuffers.
	 * 
	 * Tags und Entities(!) gehen nicht in die Berechnung der Länge ien.
	 * 
	 * @param buffer
	 *            <code>String</code>
	 * @return <code>int</code>
	 */
	public static int getXmlTextLength(String buffer) {

		return getXmlTextLength(new StringBuffer(buffer));
	}

	/**
	 * Die Methode <code>getXmlTextLength</code> liefert die reine Textlänge
	 * eines XML-Zeichenpuffers.
	 * 
	 * Tags und Entities(!) gehen nicht in die Berechnung der Länge ien.
	 * 
	 * @param buffer
	 *            <code>StringBuffer</code>
	 * @return <code>int</code>
	 */
	public static int getXmlTextLength(StringBuffer buffer) {

		char c;
		int length = 0;

		for (int i = 0; i < buffer.length(); i++) {

			c = buffer.charAt(i);

			if (c == '<') {

				while (c != '>' && i < buffer.length()) {
					c = buffer.charAt(i++);
				}

				i--;

				continue;
			}

			if (c == '&') {

				c = buffer.charAt(i++);

				while (c != ';' && c != ' ' && c != '\t' && c != '\r'
						&& c != '\n' && i < buffer.length()) {

					c = buffer.charAt(i++);
				}

				i--;

				continue;
			}

			length++;

		}

		return length;
	}

	public static boolean isEntity(StringBuffer word) {

		if (word == null) {
			throw new IllegalArgumentException(
					"The argument word must not be null!");
		}

		char c;
		int length = word.length();
		int max = length - 1;

		for (int i = 0; i < word.length(); i++) {

			c = word.charAt(i);

			if (i == 0 && c != '&') {
				return false;
			}

			if (i == max && c != ';') {
				return false;
			}

			if (Character.isWhitespace(c) == true) {
				return false;
			}
		}

		String buffer = word.toString();

		buffer = StringServices.cutPrefix(buffer, "&");
		buffer = StringServices.cutSuffix(buffer, ";");

		Matcher matcher;

		matcher = startsWithDigitPattern.matcher(buffer);

		if (matcher.matches() == true) {
			return false;
		}

		return true;
	}

	public static String makeWrapable(String buffer, String token) {
		return makeWrapable(buffer, token, hyphenationChar);
	}

	public static String makeWrapable(String buffer, String token,
			HyphenationChar hyphenChar) {

		if (buffer == null || buffer.length() == 0) {
			return buffer;
		}

		if (token == null || token.length() == 0) {
			return buffer;
		}

		String[] tokens = { token };

		return makeWrapable(buffer, tokens, hyphenChar);
	}

	public static String makeWrapable(String buffer, String[] tokens) {
		return makeWrapable(buffer, tokens, hyphenationChar);
	}

	public static String makeWrapable(String buffer, String[] tokens,
			HyphenationChar hyphenChar) {

		if (buffer == null || buffer.length() == 0) {
			return buffer;
		}

		if (tokens == null || tokens.length == 0) {
			return buffer;
		}

		String wrapable = buffer;
		String token;

		for (int i = 0; i < tokens.length; i++) {

			token = tokens[i];

			if (token == null || token.length() == 0) {
				continue;
			}

			if (hyphenChar == HyphenationChar.SOFT_HYPHEN) {
				wrapable = StringServices.replace(wrapable, token, token
						+ "&#x00ad;");
			} else {
				wrapable = StringServices.replace(wrapable, token, token
						+ "&#x200b;");
			}
		}

		return wrapable;
	}

	public static String normalizeText(String text) {

		if (text == null) {
			return null;
		}

		return text.replaceAll("\\s+", " ");
	}

	public static Document parse(File source) throws IOException, SAXException,
			ParserConfigurationException {

		return parse(source, true, null);
	}

	public static Document parse(File source, boolean validate)
			throws IOException, SAXException, ParserConfigurationException {

		return parse(source, validate, null);
	}

	public static Document parse(File source, boolean validate, URL schemaUrl)
			throws IOException, SAXException, ParserConfigurationException {

		if (source == null) {
			throw new IllegalArgumentException(
					"The argument source may not be null!");
		}

		System.setProperty("xml.catalog.ignoreMissing", "yes");

		DocumentBuilderFactory factory;
		DocumentBuilder parser;

		if (schemaUrl != null) {

			factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(validate);
			factory.setXIncludeAware(true);

			Schema schema = SchemaFactory.newInstance(
					XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaUrl);
			factory.setNamespaceAware(true);
			factory.setSchema(schema);

			parser = factory.newDocumentBuilder();

		} else {

			factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(validate);
			factory.setXIncludeAware(true);
			parser = factory.newDocumentBuilder();
			parser.setEntityResolver(new CatalogResolver());
		}

		XmlValidationResult result = new XmlValidationResult(source,
				Locale.getDefault());
		parser.setErrorHandler(result);

		Document doc = parser.parse(source);
		return doc;
	}

	/**
	 * Einlesen einer XML-Datei in einen DOM-Tree. Die XML-Daten müssen nur wohl
	 * geformt sein. Es wird keinerlei Validierung vorgenommen.
	 * 
	 * @param file
	 * @return Document
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static Document loadDocument(File file) throws SAXException,
			IOException, ParserConfigurationException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument source may not be null!");
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		DocumentBuilder parser = factory.newDocumentBuilder();
		parser.setEntityResolver(new EntityResolver() {
			@Override
			public InputSource resolveEntity(String publicId, String systemId)
					throws SAXException, IOException {
				return new InputSource(new ByteArrayInputStream(
						"<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
			}
		});

		XmlValidationResult result = new XmlValidationResult(file,
				Locale.getDefault());
		parser.setErrorHandler(result);

		Document doc = parser.parse(file);
		return doc;
	}

	public static Document parse(File source, URL schemaUrl)
			throws IOException, SAXException, ParserConfigurationException {

		return parse(source, true, schemaUrl);
	}

	public static void recode(File file, String to, URL schemaUrl)
			throws IOException, SAXException, ParserConfigurationException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		if (to == null) {
			throw new IllegalArgumentException(
					"The argument to must not be null!");
		}

		String from = getEncoding(file);

		if (from == null) {
			from = "UTF-8";
		}

		if (from.toLowerCase().equals(to.toLowerCase())) {
			return;
		}

		Document doc = parse(file, false, schemaUrl);
		NodeSerializer serializer = new NodeSerializer();
		serializer.write(doc, file, to);
	}

	public static String replaceAmpersand(String text, boolean isHtml) {

		char c;

		String entity;
		StringBuffer source = new StringBuffer(text);
		StringBuffer dest = new StringBuffer();
		StringBuffer word;

		int max = source.length() - 1;

		for (int i = 0; i <= max; i++) {

			c = source.charAt(i);

			if (c == '&') {

				word = new StringBuffer();

				if (i == max) {

					dest.append("&amp;");
					continue;

				} else {

					if (source.charAt(i + 1) == ';') {

						i++;
						dest.append("&amp;;");
						continue;

					} else {

						word.append('&');
					}
				}

				while (i < max) {

					c = source.charAt(++i);

					if (Character.isWhitespace(c) || (c == '&') || (c == ';')
							|| (i == max)) {

						if (c == ';') {
							word.append(c);
						}

						if (isEntity(word)) {

							entity = word.toString();

							if (isHtml) {
								entity = resolveHtmlEntity(entity);
							}

							entity = resolveNumericEntity(entity);
							dest.append(entity);

							if (Character.isWhitespace(c)) {
								dest.append(c);
							}

							break;

						} else {

							dest.append("&amp;");
							dest.append(word.substring(1));

							if (Character.isWhitespace(c)) {
								dest.append(c);
							}

							if (i == max) {

								if (c == '&') {
									dest.append("&amp;");
								} else if (c != ';') {
									dest.append(c);
								}
							}

							logger.debug("dest: " + dest.toString());

							if (c == '&') {

								word = new StringBuffer();
								word.append('&');

							} else {

								break;
							}
						}

					} else {
						word.append(c);
					}
				}

			} else {

				dest.append(c);
			}
		}

		return dest.toString();
	}

	public static String resolveHtmlEntity(String entity) {

		if (entity == null || entity.length() == 0) {
			return "";
		}

		if (entity.startsWith("&") == false || entity.endsWith(";") == false) {
			return entity;
		}

		if (entity.equals("&nbsp;")) {
			return resolveNumericEntity("&#160;");
		}

		if (entity.equals("&iexcl;")) {
			return resolveNumericEntity("&#161;");
		}

		if (entity.equals("&curren;")) {
			return resolveNumericEntity("&#164;");
		}

		if (entity.equals("&cent;")) {
			return resolveNumericEntity("&#162;");
		}

		if (entity.equals("&pound;")) {
			return resolveNumericEntity("&#163;");
		}

		if (entity.equals("&yen;")) {
			return resolveNumericEntity("&#165;");
		}

		if (entity.equals("&brvbar;")) {
			return resolveNumericEntity("&#166;");
		}

		if (entity.equals("&sect;")) {
			return resolveNumericEntity("&#167;");
		}

		if (entity.equals("&uml;")) {
			return resolveNumericEntity("&#168;");
		}

		if (entity.equals("&copy;")) {
			return resolveNumericEntity("&#169;");
		}

		if (entity.equals("&ordf;")) {
			return resolveNumericEntity("&#170;");
		}

		if (entity.equals("&laquo;")) {
			return resolveNumericEntity("&#171;");
		}

		if (entity.equals("&not;")) {
			return resolveNumericEntity("&#172;");
		}

		if (entity.equals("&shy;")) {
			return resolveNumericEntity("&#173;");
		}

		if (entity.equals("&reg;")) {
			return resolveNumericEntity("&#174;");
		}

		if (entity.equals("&trade;")) {
			return resolveNumericEntity("&#8482;");
		}

		if (entity.equals("&macr;")) {
			return resolveNumericEntity("&#175;");
		}

		if (entity.equals("&deg;")) {
			return resolveNumericEntity("&#176;");
		}

		if (entity.equals("&plusmn;")) {
			return resolveNumericEntity("&#177;");
		}

		if (entity.equals("&sup2;")) {
			return resolveNumericEntity("&#178;");
		}

		if (entity.equals("&sup3;")) {
			return resolveNumericEntity("&#179;");
		}

		if (entity.equals("&acute;")) {
			return resolveNumericEntity("&#180;");
		}

		if (entity.equals("&micro;")) {
			return resolveNumericEntity("&#181;");
		}

		if (entity.equals("&para;")) {
			return resolveNumericEntity("&#182;");
		}

		if (entity.equals("&middot;")) {
			return resolveNumericEntity("&#183;");
		}

		if (entity.equals("&cedil;")) {
			return resolveNumericEntity("&#184;");
		}

		if (entity.equals("&sup1;")) {
			return resolveNumericEntity("&#185;");
		}

		if (entity.equals("&ordm;")) {
			return resolveNumericEntity("&#186;");
		}

		if (entity.equals("&raquo;")) {
			return resolveNumericEntity("&#187;");
		}

		if (entity.equals("&frac14;")) {
			return resolveNumericEntity("&#188;");
		}

		if (entity.equals("&frac12;")) {
			return resolveNumericEntity("&#189;");
		}

		if (entity.equals("&frac34;")) {
			return resolveNumericEntity("&#190;");
		}

		if (entity.equals("&iquest;")) {
			return resolveNumericEntity("&#191;");
		}

		if (entity.equals("&times;")) {
			return resolveNumericEntity("&#215;");
		}

		if (entity.equals("&divide;")) {
			return resolveNumericEntity("&#247;");
		}

		if (entity.equals("&Agrave;")) {
			return resolveNumericEntity("&#192;");
		}

		if (entity.equals("&Aacute;")) {
			return resolveNumericEntity("&#193;");
		}

		if (entity.equals("&Acirc;")) {
			return resolveNumericEntity("&#194;");
		}

		if (entity.equals("&Atilde;")) {
			return resolveNumericEntity("&#195;");
		}

		if (entity.equals("&Auml;")) {
			return resolveNumericEntity("&#196;");
		}

		if (entity.equals("&Aring;")) {
			return resolveNumericEntity("&#197;");
		}

		if (entity.equals("&AElig;")) {
			return resolveNumericEntity("&#198;");
		}

		if (entity.equals("&Ccedil;")) {
			return resolveNumericEntity("&#199;");
		}

		if (entity.equals("&Egrave;")) {
			return resolveNumericEntity("&#200;");
		}

		if (entity.equals("&Eacute;")) {
			return resolveNumericEntity("&#201;");
		}

		if (entity.equals("&Ecirc;")) {
			return resolveNumericEntity("&#202;");
		}

		if (entity.equals("&Euml;")) {
			return resolveNumericEntity("&#203;");
		}

		if (entity.equals("&Igrave;")) {
			return resolveNumericEntity("&#204;");
		}

		if (entity.equals("&Iacute;")) {
			return resolveNumericEntity("&#205;");
		}

		if (entity.equals("&Icirc;")) {
			return resolveNumericEntity("&#206;");
		}

		if (entity.equals("&Iuml;")) {
			return resolveNumericEntity("&#207;");
		}

		if (entity.equals("&ETH;")) {
			return resolveNumericEntity("&#208;");
		}

		if (entity.equals("&Ntilde;")) {
			return resolveNumericEntity("&#209;");
		}

		if (entity.equals("&Ograve;")) {
			return resolveNumericEntity("&#210;");
		}

		if (entity.equals("&Oacute;")) {
			return resolveNumericEntity("&#211;");
		}

		if (entity.equals("&Ocirc;")) {
			return resolveNumericEntity("&#212;");
		}

		if (entity.equals("&Otilde;")) {
			return resolveNumericEntity("&#213;");
		}

		if (entity.equals("&Ouml;")) {
			return resolveNumericEntity("&#214;");
		}

		if (entity.equals("&Oslash;")) {
			return resolveNumericEntity("&#216;");
		}

		if (entity.equals("&Ugrave;")) {
			return resolveNumericEntity("&#217;");
		}

		if (entity.equals("&Uacute;")) {
			return resolveNumericEntity("&#218;");
		}

		if (entity.equals("&Ucirc;")) {
			return resolveNumericEntity("&#219;");
		}

		if (entity.equals("&Uuml;")) {
			return resolveNumericEntity("&#220;");
		}

		if (entity.equals("&Yacute;")) {
			return resolveNumericEntity("&#221;");
		}

		if (entity.equals("&THORN;")) {
			return resolveNumericEntity("&#222;");
		}

		if (entity.equals("&szlig;")) {
			return resolveNumericEntity("&#223;");
		}

		if (entity.equals("&agrave;")) {
			return resolveNumericEntity("&#224;");
		}

		if (entity.equals("&aacute;")) {
			return resolveNumericEntity("&#225;");
		}

		if (entity.equals("&acirc;")) {
			return resolveNumericEntity("&#226;");
		}

		if (entity.equals("&atilde;")) {
			return resolveNumericEntity("&#227;");
		}

		if (entity.equals("&auml;")) {
			return resolveNumericEntity("&#228;");
		}

		if (entity.equals("&aring;")) {
			return resolveNumericEntity("&#229;");
		}

		if (entity.equals("&aelig;")) {
			return resolveNumericEntity("&#230;");
		}

		if (entity.equals("&ccedil;")) {
			return resolveNumericEntity("&#231;");
		}

		if (entity.equals("&egrave;")) {
			return resolveNumericEntity("&#232;");
		}

		if (entity.equals("&eacute;")) {
			return resolveNumericEntity("&#233;");
		}

		if (entity.equals("&ecirc;")) {
			return resolveNumericEntity("&#234;");
		}

		if (entity.equals("&euml;")) {
			return resolveNumericEntity("&#235;");
		}

		if (entity.equals("&igrave;")) {
			return resolveNumericEntity("&#236;");
		}

		if (entity.equals("&iacute;")) {
			return resolveNumericEntity("&#237;");
		}

		if (entity.equals("&icirc;")) {
			return resolveNumericEntity("&#238;");
		}

		if (entity.equals("&iuml;")) {
			return resolveNumericEntity("&#239;");
		}

		if (entity.equals("&eth;")) {
			return resolveNumericEntity("&#240;");
		}

		if (entity.equals("&ntilde;")) {
			return resolveNumericEntity("&#241;");
		}

		if (entity.equals("&ograve;")) {
			return resolveNumericEntity("&#242;");
		}

		if (entity.equals("&oacute;")) {
			return resolveNumericEntity("&#243;");
		}

		if (entity.equals("&ocirc;")) {
			return resolveNumericEntity("&#244;");
		}

		if (entity.equals("&otilde;")) {
			return resolveNumericEntity("&#245;");
		}

		if (entity.equals("&ouml;")) {
			return resolveNumericEntity("&#246;");
		}

		if (entity.equals("&oslash;")) {
			return resolveNumericEntity("&#248;");
		}

		if (entity.equals("&ugrave;")) {
			return resolveNumericEntity("&#249;");
		}

		if (entity.equals("&uacute;")) {
			return resolveNumericEntity("&#250;");
		}

		if (entity.equals("&ucirc;")) {
			return resolveNumericEntity("&#251;");
		}

		if (entity.equals("&uuml;")) {
			return resolveNumericEntity("&#252;");
		}

		if (entity.equals("&yacute;")) {
			return resolveNumericEntity("&#253;");
		}

		if (entity.equals("&thorn;")) {
			return resolveNumericEntity("&#254;");
		}

		if (entity.equals("&yuml;")) {
			return resolveNumericEntity("&#255;");
		}

		if (entity.equals("&OElig;")) {
			return resolveNumericEntity("&#338;");
		}

		if (entity.equals("&oelig;")) {
			return resolveNumericEntity("&#339;");
		}

		if (entity.equals("&Scaron;")) {
			return resolveNumericEntity("&#352;");
		}

		if (entity.equals("&scaron;")) {
			return resolveNumericEntity("&#353;");
		}

		if (entity.equals("&Yuml;")) {
			return resolveNumericEntity("&#376;");
		}

		if (entity.equals("&circ;")) {
			return resolveNumericEntity("&#710;");
		}

		if (entity.equals("&tilde;")) {
			return resolveNumericEntity("&#732;");
		}

		if (entity.equals("&ensp;")) {
			return resolveNumericEntity("&#8194;");
		}

		if (entity.equals("&emsp;")) {
			return resolveNumericEntity("&#8195;");
		}

		if (entity.equals("&thinsp;")) {
			return resolveNumericEntity("&#8201;");
		}

		if (entity.equals("&zwnj;")) {
			return resolveNumericEntity("&#8204;");
		}

		if (entity.equals("&zwj;")) {
			return resolveNumericEntity("&#8205;");
		}

		if (entity.equals("&lrm;")) {
			return resolveNumericEntity("&#8206;");
		}

		if (entity.equals("&rlm;")) {
			return resolveNumericEntity("&#8207;");
		}

		if (entity.equals("&ndash;")) {
			return resolveNumericEntity("&#8211;");
		}

		if (entity.equals("&mdash;")) {
			return resolveNumericEntity("&#8212;");
		}

		if (entity.equals("&lsquo;")) {
			return resolveNumericEntity("&#8216;");
		}

		if (entity.equals("&rsquo;")) {
			return resolveNumericEntity("&#8217;");
		}

		if (entity.equals("&sbquo;")) {
			return resolveNumericEntity("&#8218;");
		}

		if (entity.equals("&ldquo;")) {
			return resolveNumericEntity("&#8220;");
		}

		if (entity.equals("&rdquo;")) {
			return resolveNumericEntity("&#8221;");
		}

		if (entity.equals("&bdquo;")) {
			return resolveNumericEntity("&#8222;");
		}

		if (entity.equals("&dagger;")) {
			return resolveNumericEntity("&#8224;");
		}

		if (entity.equals("&Dagger;")) {
			return resolveNumericEntity("&#8225;");
		}

		if (entity.equals("&hellip;")) {
			return resolveNumericEntity("&#8230;");
		}

		if (entity.equals("&permil;")) {
			return resolveNumericEntity("&#8240;");
		}

		if (entity.equals("&lsaquo;")) {
			return resolveNumericEntity("&#8249;");
		}

		if (entity.equals("&rsaquo;")) {
			return resolveNumericEntity("&#8250;");
		}

		if (entity.equals("&euro;")) {
			return resolveNumericEntity("&#8364;");
		}

		return entity;
	}

	public static String resolveNumericEntity(String entity) {

		if (entity == null || entity.length() == 0) {
			return "";
		}

		if (entity.startsWith("&#") == false || entity.endsWith(";") == false) {
			return entity;
		}

		String str = entity;

		str = StringServices.cutPrefix(str, "&#");
		str = StringServices.cutSuffix(str, ";");

		int code = -1;
		int radix = 10;

		if (str.startsWith("x")) {
			str = StringServices.cutPrefix(str, "x");
			radix = 16;
		}

		try {
			code = Integer.parseInt(str, radix);
		} catch (NumberFormatException oops) {
			return entity;
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append((char) code);

		return buffer.toString();
	}

	public static String textToHtml(String text) {

		if (text == null) {
			return null;
		}

		text = textToXml(text, true);
		return text;
	}

	/**
	 * Die Methode <code>textToXml</code> wandelt Text in XML-Text um.
	 * 
	 * Dazu werden die von XML reservierter Zeichen "kleiner als", "größer als"
	 * und das kaufmännische Und durch ihre entsprechenden Entities ersetzt.
	 * 
	 * @param text
	 *            <code>String</code>
	 * @return <code>String</code>
	 */
	public static String textToXml(String text) {
		return textToXml(text, false);
	}

	/**
	 * Die Methode <code>textToXml</code> wandelt Text in XML-Text um.
	 * 
	 * Dazu werden die von XML reservierter Zeichen "kleiner als", "größer als"
	 * und das kaufmännische Und durch ihre entsprechenden Entities ersetzt.
	 * 
	 * @param text
	 *            <code>String</code>
	 * @return <code>String</code>
	 */
	public static String textToXml(String text, boolean isHtml) {

		logger.debug("Argument text: \"" + text + "\"");
		logger.debug("Argument isHtml: \"" + isHtml + "\"");

		if (text == null) {
			return null;
		}

		text = StringServices.replace(text, "&lt;", "<");
		text = StringServices.replace(text, "&gt;", ">");
		text = StringServices.replace(text, "&quot;", "\"");
		text = StringServices.replace(text, "&apos;", "'");
		text = StringServices.replace(text, "&#39;", "'");

		text = StringServices.replace(text, "<", "&lt;");
		text = StringServices.replace(text, ">", "&gt;");
		text = StringServices.replace(text, "\"", "&quot;");
		text = StringServices.replace(text, "\uF0E0",
				"<img class=\"arrowImage\" src=\"../../../img/uF0E0.png\">");

		if (isHtml == true) {
			text = StringServices.replace(text, "'", "&#39;");
		} else {
			text = StringServices.replace(text, "'", "&apos;");
		}

		text = replaceAmpersand(text, isHtml);
		text = UnicodeServices.removeUndefinedCharacters(text);

		logger.debug("Return: \"" + text + "\"");
		return text;
	}

	/**
	 * Die Methode <code>validate</code> validiert die angegebene XML-Datei.
	 * 
	 * @param file
	 *            <code>File</code>
	 * @exception ParserConfigurationException
	 *                ParserConfigurationException
	 * @exception SAXException
	 *                SAXException
	 * @exception IOException
	 *                IOException public static int validate(File source) throws
	 *                ParserConfigurationException, SAXException, IOException {
	 * 
	 *                XmlValidationResult result = validate(source);
	 * 
	 *                return result.getNumOfErrors(); }
	 */

	public static XmlValidationResult validate(File file)
			throws ParserConfigurationException, SAXException, IOException {

		return validate(file, null, Locale.getDefault());
	}

	public static XmlValidationResult validate(File file, Locale locale)
			throws ParserConfigurationException, SAXException, IOException {

		return validate(file, null, locale);
	}

	public static XmlValidationResult validate(File file, URL schemaUrl)
			throws ParserConfigurationException, SAXException, IOException {

		return validate(file, schemaUrl, Locale.getDefault());
	}

	public static XmlValidationResult validate(File file, URL schemaUrl,
			Locale locale) throws ParserConfigurationException, SAXException,
			IOException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file may not be null!");
		}

		if (locale == null) {
			throw new IllegalArgumentException(
					"The argument locale must not be null!");
		}

		XmlValidationResult result = new XmlValidationResult(file, locale);

		if (file.exists() == false) {
			result.setFileNotFound(true);
			return result;
		}

		if (file.canRead() == false) {
			result.setCanNotRead(true);
			return result;
		}

		System.setProperty("xml.catalog.ignoreMissing", "yes");

		DocumentBuilderFactory factory;
		DocumentBuilder parser;

		if (schemaUrl != null) {

			Schema schema = SchemaFactory.newInstance(
					XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaUrl);
			
			factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setSchema(schema);
			factory.setXIncludeAware(true);

			parser = factory.newDocumentBuilder();
			parser.setEntityResolver(new CatalogResolver());
			

		} else {

			factory = DocumentBuilderFactory.newInstance();
			parser = factory.newDocumentBuilder();
			parser.setEntityResolver(new CatalogResolver());
		}

		factory.setValidating(true);
		parser.setErrorHandler(result);

		try {
			parser.parse(file);
		} catch (SAXParseException oops) {
			// Wird von XmlValidationResult verarbeitet
		} catch (Throwable oops) {
			result.setThrowable(oops);
		}

		return result;
	}

	public static XmlValidationResult validate(String source)
			throws ParserConfigurationException, SAXException, IOException {

		if (source == null) {
			throw new IllegalArgumentException(
					"The argument source may not be null!");
		}

		return validate(new File(source));
	}

	/**
	 * Die Methode <code>validate</code> validiert die angegebene Zeichekette.
	 * 
	 * Vor der Konvertierung wird die Zeichenkette in die angegebene Kodierung
	 * umgewandelt.
	 * 
	 * @param xmlCode
	 *            <code>String</code>
	 * @param encoding
	 *            <code>String</code>
	 * @return <code>byte[]</code>
	 * @exception CharacterCodingException
	 *                CharacterCodingException
	 * @exception ParserConfigurationException
	 *                ParserConfigurationException
	 * @exception SAXException
	 *                SAXException
	 * @exception IOException
	 *                IOException
	 */
	public static byte[] validate(String xmlCode, String encoding)
			throws CharacterCodingException, ParserConfigurationException,
			SAXException, IOException {

		return validate(xmlCode, encoding, null);
	}

	public static byte[] validate(String xmlCode, String encoding, URL schemaUrl)
			throws CharacterCodingException, ParserConfigurationException,
			SAXException, IOException {

		if (xmlCode == null) {
			throw new IllegalArgumentException(
					"The argument xmlCode may not be null!");
		}

		if (encoding == null) {
			throw new IllegalArgumentException(
					"The argument encoding may not be null!");
		}

		System.setProperty("xml.catalog.ignoreMissing", "yes");

		Charset charset = Charset.forName(encoding);
		CharsetEncoder encoder = charset.newEncoder();

		CharBuffer inBuffer = CharBuffer.wrap(xmlCode);
		ByteBuffer byteBuffer = encoder.encode(inBuffer);

		int limit = byteBuffer.limit();
		byte[] data = new byte[limit];
		byteBuffer.get(data, 0, limit);

		ByteArrayInputStream stream = new ByteArrayInputStream(data);

		DocumentBuilderFactory factory;
		DocumentBuilder parser;

		if (schemaUrl != null) {

			Schema schema = SchemaFactory.newInstance(
					XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaUrl);
			factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setSchema(schema);
			factory.setXIncludeAware(true);
			parser = factory.newDocumentBuilder();

		} else {

			factory = DocumentBuilderFactory.newInstance();
			parser = factory.newDocumentBuilder();
			parser.setEntityResolver(new CatalogResolver());
		}

		factory.setValidating(true);
		parser.parse(stream);

		return data;
	}

	public static boolean isNewline(Node node) {

		if (node != null && node instanceof Text) {

			String text = ((Text) node).getData();

			if (text != null && text.trim().length() == 0
					&& text.indexOf('\n') != -1) {
				return true;
			}
		}
		return false;
	}

	public static String normalizeText(Text text) {

		String data = text.getData();
		data = ReplaceServices.replaceAll(data, "\\s+", " ");
		return data;
	}

	public static String xmlToText(String text) {

		if (text == null) {
			return null;
		}

		text = StringServices.replace(text, "&apos;", "'");
		text = StringServices.replace(text, "&#39;", "'");
		text = StringServices.replace(text, "&quot;", "\"");
		text = StringServices.replace(text, "&lt;", "<");
		text = StringServices.replace(text, "&gt;", ">");
		text = StringServices.replace(text, "&amp;", "&");

		return text;
	}

	/**
	 * Die Methode <code>xslt</code> führt eine XSL-Transformation durch.
	 */
	public static void xslt(File in, String xsl,
			HashMap<String, String> params, File out, String encoding,
			boolean validate) throws IOException, SAXException,
			TransformerConfigurationException, TransformerException,
			UnsupportedEncodingException {

		xslt(in.getCanonicalPath(), xsl, params, out.getCanonicalPath(),
				encoding, validate, null);
	}

	public static void xslt(File in, String xsl,
			HashMap<String, String> params, File out, String encoding,
			boolean validate, ErrorListener listener) throws IOException,
			SAXException, TransformerConfigurationException,
			TransformerException, UnsupportedEncodingException {

		xslt(in.getCanonicalPath(), xsl, params, out.getCanonicalPath(),
				encoding, validate, listener);
	}

	public static void xslt(String in, String xsl,
			HashMap<String, String> params, String out) throws IOException,
			SAXException, TransformerConfigurationException,
			TransformerException, UnsupportedEncodingException {

		xslt(in, xsl, params, out, "UTF-8", false, null);
	}

	public static void xslt(String in, String xsl,
			HashMap<String, String> params, String out, String encoding,
			boolean validate) throws IOException, SAXException,
			TransformerConfigurationException, TransformerException,
			UnsupportedEncodingException {

		xslt(in, xsl, params, out, encoding, validate, null);
	}

	/**
	 * Die Methode <code>xslt</code> führt eine XSL-Transformation durch.
	 */
	public static void xslt(String in, String xsl,
			HashMap<String, String> params, String out, String encoding,
			boolean validate, ErrorListener listener) throws IOException,
			SAXException, TransformerConfigurationException,
			TransformerException, UnsupportedEncodingException {

		if (in == null) {
			throw new IllegalArgumentException("Parameter in is null!");
		}

		if (xsl == null) {
			throw new IllegalArgumentException("Parameter xsl is null!");
		}

		if (out == null) {
			throw new IllegalArgumentException("Parameter out is null!");
		}

		if (encoding == null) {
			throw new IllegalArgumentException(
					"The argument encoding may not be null!");
		}

		System.setProperty("xml.catalog.ignoreMissing", "yes");

		FileInputStream fis = null;
		FileOutputStream fos = null;

		logger.debug("validate=" + validate);

		String spf = System.getProperty("javax.xml.parsers.SAXParserFactory");
		String dbf = System
				.getProperty("javax.xml.parsers.DocumentBuilderFactory");
		String tf = System
				.getProperty("javax.xml.transform.TransformerFactory");

		try {

			System.setProperty("javax.xml.parsers.SAXParserFactory",
					"org.apache.xerces.jaxp.SAXParserFactoryImpl");
			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
					"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
			System.setProperty("javax.xml.transform.TransformerFactory",
					"org.apache.xalan.processor.TransformerFactoryImpl");

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			if (listener != null) {
				transformerFactory.setErrorListener(listener);
			}

			if (validate == true) {
				transformerFactory.setURIResolver(new CatalogResolver());
			}

			Transformer transformer = transformerFactory
					.newTransformer(new StreamSource(xsl));

			if (transformer == null) {
				throw new TransformerException(
						"Can't create transformer for stylesheet " + xsl
								+ ". Working directory is "
								+ new File(".").getAbsolutePath());
			}

			if (listener != null) {
				transformer.setErrorListener(listener);
			}

			if (validate == true) {
				transformer.setURIResolver(new CatalogResolver());
			}

			if (params != null) {

				Iterator<String> iterator = params.keySet().iterator();

				String param;
				String value;

				while (iterator.hasNext()) {

					param = iterator.next();
					value = params.get(param);

					transformer.setParameter(param, value);
				}
			}

			fis = new FileInputStream(in);
			fos = new FileOutputStream(out);

			try {

				XMLReader reader = XMLReaderFactory.createXMLReader();

				if (validate == true) {
					reader.setEntityResolver(new CatalogResolver());
				}

				transformer
						.transform(new SAXSource(reader, new InputSource(in)),
								new StreamResult(new OutputStreamWriter(fos,
										encoding)));

			} catch (Exception oops) {

				logger.fatal("XmlServices.xslt", oops);

			}

		} finally {

			if (fis != null) {
				fis.close();
			}

			if (fos != null) {
				fos.close();
			}

			if (spf != null) {
				System.setProperty("javax.xml.parsers.SAXParserFactory", spf);
			}

			if (dbf != null) {
				System.setProperty("javax.xml.parsers.DocumentBuilderFactor",
						dbf);
			}

			if (tf != null) {
				System.setProperty("javax.xml.transform.TransformerFactory", tf);
			}
		}
	}

	public static void xslt(String in, String xsl,
			HashMap<String, String> params, String out, String encoding,
			ErrorListener listener) throws IOException, SAXException,
			TransformerConfigurationException, TransformerException,
			UnsupportedEncodingException {

		xslt(in, xsl, params, out, encoding, false, listener);
	}

	/**
	 * Führt eine XSLT-Transformation durch.
	 * 
	 * @param in
	 *            XML-Eingabedatei
	 * @param xsl
	 *            XSLT-Datei
	 * @param out
	 *            Ausgabedatei
	 * @throws IOException
	 * @throws SAXException
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 * @throws UnsupportedEncodingException
	 */
	public static void xslt(String in, String xsl, String out)
			throws IOException, SAXException,
			TransformerConfigurationException, TransformerException,
			UnsupportedEncodingException {

		xslt(in, xsl, new HashMap<String, String>(), out, "UTF-8", false, null);
	}

	public static void xslt(String in, String xsl, String out,
			ErrorListener listener) throws IOException, SAXException,
			TransformerConfigurationException, TransformerException,
			UnsupportedEncodingException {

		xslt(in, xsl, new HashMap<String, String>(), out, "UTF-8", false,
				listener);
	}

	/**
	 * Die Methode <code>relocateSrc</code> kopiert die Bilder der lokalen
	 * Bildreferenzen einer HTML-Datei in das angegebene Zeilverzeichnis und
	 * passt die Referenzen entsprechend an.
	 * 
	 * @param file
	 * @param imgDir
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void relocateSrc(File file, File imgDir) throws IOException,
			SAXException, ParserConfigurationException {

		Document doc = loadDocument(file);

		ArrayList<Node> imgNodeList = XPathServices.getNodes(doc, "xhtml",
				"http://www.w3.org/1999/xhtml", "//xhtml:img");

		for (Node node : imgNodeList) {

			Element img = (Element) node;
			String srcAttr = img.getAttribute("src");

			if (srcAttr == null || srcAttr.trim().length() == 0) {
				continue;
			}

			File fromFile;

			if (srcAttr.startsWith("file:")) {
				URL srcUrl = new URL(srcAttr);
				fromFile = new File(srcUrl.getPath());
			} else {
				fromFile = new File(srcAttr);
			}

			if (fromFile.exists() == false) {
				logger.warn("Image file doesn't exist: "
						+ fromFile.getAbsolutePath());
				continue;
			}

			String toFileName = FileServices.appendPath(imgDir,
					fromFile.getName());
			File toFile = FileServices.createUniqueFile(new File(toFileName));
			FileServices.copyFileToFile(fromFile, toFile);

			img.setAttribute("src", FileServices.relativePath(file, toFile));
		}

		NodeSerializer serializer = new NodeSerializer();
		serializer.write(doc, file);
	}

	public static String printPath(Node node) {

		if (node == null) {
			return "Path: null";
		}

		StringBuilder buffer = new StringBuilder();

		Node parent = node;

		while (parent != null) {
			buffer.insert(0, " -> ");
			buffer.insert(0, parent.getNodeName());
			parent = parent.getParentNode();
		}

		String text = buffer.toString();
		text = StringServices.cutPrefix(text, " -> ");
		return "Path: " + text;
	}
}
