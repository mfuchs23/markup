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

import java.io.PrintWriter;
import java.io.StringWriter;

import org.dbdoclet.service.StringServices;

public class HtmlServices {

	public static boolean isEntity(StringBuffer word) {
		return XmlServices.isEntity(word);
	}

	public static String textToHtml(String text) {

		if (text == null) {
			return null;
		}

		text = XmlServices.textToXml(text, true);
		return text;
	}

	public static String htmlToText(String text) {

		if (text == null) {
			return null;
		}

		text = XmlServices.xmlToText(text);

		text = StringServices.replace(text, "&auml;", "ä");
		text = StringServices.replace(text, "&Ouml;", "Ö");
		text = StringServices.replace(text, "&ouml;", "ö");
		text = StringServices.replace(text, "&Uuml;", "Ü");
		text = StringServices.replace(text, "&uuml;", "ü");

		return text;
	}

	public static String createExceptionBox(String title, String msg,
			Throwable oops) {

		String name = "exception";

		StringBuffer buffer = new StringBuffer();

		buffer.append("<div class='" + name + "-box'>\n");
		buffer.append("  <div class='" + name + "-box-title'>");
		buffer.append(title);
		buffer.append("  </div>\n");
		buffer.append("  <div class='" + name + "-box-message'>\n");
		buffer.append(msg);
		buffer.append("  </div>\n");
		buffer.append("  <div class='" + name + "-box-stacktrace'><pre>\n");

		StringWriter stb = new StringWriter();
		oops.printStackTrace(new PrintWriter(stb));
		buffer.append(stb.toString());

		buffer.append("  </pre></div>\n");
		buffer.append("</div>\n");

		return buffer.toString();
	}

	public static String createErrorBox(String title, String msg) {
		return createBox("error", title, msg);
	}

	public static String createWarningBox(String title, String msg) {
		return createBox("warning", title, msg);
	}

	public static String createInfoBox(String title, String msg) {
		return createBox("info", title, msg);
	}

	public static String createBox(String name, String title, String msg) {

		StringBuffer buffer = new StringBuffer();

		buffer.append("<div class='" + name + "-box'>\n");
		buffer.append("  <div class='" + name + "-box-title'>");
		buffer.append("<p class='" + name + "-box-title'>" + title + "</p>");
		buffer.append("</div>\n");
		buffer.append("  <div class='" + name + "-box-message'>\n");
		buffer.append(msg);
		buffer.append("  </div>\n");
		buffer.append("</div>\n");

		return buffer.toString();
	}

	public static String replaceEntities(String htmlCode) {

		String buffer = new String(htmlCode);

		buffer = StringServices.replace(buffer, "&nbsp;",
				XmlServices.resolveNumericEntity("&#160;"));
		buffer = StringServices.replace(buffer, "&iexcl;",
				XmlServices.resolveNumericEntity("&#161;"));
		buffer = StringServices.replace(buffer, "&cent;",
				XmlServices.resolveNumericEntity("&#162;"));
		buffer = StringServices.replace(buffer, "&pound;",
				XmlServices.resolveNumericEntity("&#163;"));
		buffer = StringServices.replace(buffer, "&curren;",
				XmlServices.resolveNumericEntity("&#164;"));
		buffer = StringServices.replace(buffer, "&yen;",
				XmlServices.resolveNumericEntity("&#165;"));
		buffer = StringServices.replace(buffer, "&brvbar;",
				XmlServices.resolveNumericEntity("&#166;"));
		buffer = StringServices.replace(buffer, "&sect;",
				XmlServices.resolveNumericEntity("&#167;"));
		buffer = StringServices.replace(buffer, "&uml;",
				XmlServices.resolveNumericEntity("&#168;"));
		buffer = StringServices.replace(buffer, "&copy;",
				XmlServices.resolveNumericEntity("&#169;"));
		buffer = StringServices.replace(buffer, "&ordf;",
				XmlServices.resolveNumericEntity("&#170;"));
		buffer = StringServices.replace(buffer, "&laquo;",
				XmlServices.resolveNumericEntity("&#171;"));
		buffer = StringServices.replace(buffer, "&not;",
				XmlServices.resolveNumericEntity("&#172;"));
		buffer = StringServices.replace(buffer, "&shy;",
				XmlServices.resolveNumericEntity("&#173;"));
		buffer = StringServices.replace(buffer, "&reg;",
				XmlServices.resolveNumericEntity("&#174;"));
		buffer = StringServices.replace(buffer, "&macr;",
				XmlServices.resolveNumericEntity("&#175;"));
		buffer = StringServices.replace(buffer, "&deg;",
				XmlServices.resolveNumericEntity("&#176;"));
		buffer = StringServices.replace(buffer, "&plusmn;",
				XmlServices.resolveNumericEntity("&#177;"));
		buffer = StringServices.replace(buffer, "&sup2;",
				XmlServices.resolveNumericEntity("&#178;"));
		buffer = StringServices.replace(buffer, "&sup3;",
				XmlServices.resolveNumericEntity("&#179;"));
		buffer = StringServices.replace(buffer, "&acute;",
				XmlServices.resolveNumericEntity("&#180;"));
		buffer = StringServices.replace(buffer, "&micro;",
				XmlServices.resolveNumericEntity("&#181;"));
		buffer = StringServices.replace(buffer, "&para;",
				XmlServices.resolveNumericEntity("&#182;"));
		buffer = StringServices.replace(buffer, "&middot;",
				XmlServices.resolveNumericEntity("&#183;"));
		buffer = StringServices.replace(buffer, "&cedil;",
				XmlServices.resolveNumericEntity("&#184;"));
		buffer = StringServices.replace(buffer, "&sup1;",
				XmlServices.resolveNumericEntity("&#185;"));
		buffer = StringServices.replace(buffer, "&ordm;",
				XmlServices.resolveNumericEntity("&#186;"));
		buffer = StringServices.replace(buffer, "&raquo;",
				XmlServices.resolveNumericEntity("&#187;"));
		buffer = StringServices.replace(buffer, "&frac14;",
				XmlServices.resolveNumericEntity("&#188;"));
		buffer = StringServices.replace(buffer, "&frac12;",
				XmlServices.resolveNumericEntity("&#189;"));
		buffer = StringServices.replace(buffer, "&frac34;",
				XmlServices.resolveNumericEntity("&#190;"));
		buffer = StringServices.replace(buffer, "&iquest;",
				XmlServices.resolveNumericEntity("&#191;"));
		buffer = StringServices.replace(buffer, "&Agrave;",
				XmlServices.resolveNumericEntity("&#192;"));
		buffer = StringServices.replace(buffer, "&Aacute;",
				XmlServices.resolveNumericEntity("&#193;"));
		buffer = StringServices.replace(buffer, "&Acirc;",
				XmlServices.resolveNumericEntity("&#194;"));
		buffer = StringServices.replace(buffer, "&Atilde;",
				XmlServices.resolveNumericEntity("&#195;"));
		buffer = StringServices.replace(buffer, "&Auml;",
				XmlServices.resolveNumericEntity("&#196;"));
		buffer = StringServices.replace(buffer, "&Aring;",
				XmlServices.resolveNumericEntity("&#197;"));
		buffer = StringServices.replace(buffer, "&AElig;",
				XmlServices.resolveNumericEntity("&#198;"));
		buffer = StringServices.replace(buffer, "&Ccedil;",
				XmlServices.resolveNumericEntity("&#199;"));
		buffer = StringServices.replace(buffer, "&Egrave;",
				XmlServices.resolveNumericEntity("&#200;"));
		buffer = StringServices.replace(buffer, "&Eacute;",
				XmlServices.resolveNumericEntity("&#201;"));
		buffer = StringServices.replace(buffer, "&Ecirc;",
				XmlServices.resolveNumericEntity("&#202;"));
		buffer = StringServices.replace(buffer, "&Euml;",
				XmlServices.resolveNumericEntity("&#203;"));
		buffer = StringServices.replace(buffer, "&Igrave;",
				XmlServices.resolveNumericEntity("&#204;"));
		buffer = StringServices.replace(buffer, "&Iacute;",
				XmlServices.resolveNumericEntity("&#205;"));
		buffer = StringServices.replace(buffer, "&Icirc;",
				XmlServices.resolveNumericEntity("&#206;"));
		buffer = StringServices.replace(buffer, "&Iuml;",
				XmlServices.resolveNumericEntity("&#207;"));
		buffer = StringServices.replace(buffer, "&ETH;",
				XmlServices.resolveNumericEntity("&#208;"));
		buffer = StringServices.replace(buffer, "&Ntilde;",
				XmlServices.resolveNumericEntity("&#209;"));
		buffer = StringServices.replace(buffer, "&Ograve;",
				XmlServices.resolveNumericEntity("&#210;"));
		buffer = StringServices.replace(buffer, "&Oacute;",
				XmlServices.resolveNumericEntity("&#211;"));
		buffer = StringServices.replace(buffer, "&Ocirc;",
				XmlServices.resolveNumericEntity("&#212;"));
		buffer = StringServices.replace(buffer, "&Otilde;",
				XmlServices.resolveNumericEntity("&#213;"));
		buffer = StringServices.replace(buffer, "&Ouml;",
				XmlServices.resolveNumericEntity("&#214;"));
		buffer = StringServices.replace(buffer, "&times;",
				XmlServices.resolveNumericEntity("&#215;"));
		buffer = StringServices.replace(buffer, "&Oslash;",
				XmlServices.resolveNumericEntity("&#216;"));
		buffer = StringServices.replace(buffer, "&Ugrave;",
				XmlServices.resolveNumericEntity("&#217;"));
		buffer = StringServices.replace(buffer, "&Uacute;",
				XmlServices.resolveNumericEntity("&#218;"));
		buffer = StringServices.replace(buffer, "&Ucirc;",
				XmlServices.resolveNumericEntity("&#219;"));
		buffer = StringServices.replace(buffer, "&Uuml;",
				XmlServices.resolveNumericEntity("&#220;"));
		buffer = StringServices.replace(buffer, "&Yacute;",
				XmlServices.resolveNumericEntity("&#221;"));
		buffer = StringServices.replace(buffer, "&THORN;",
				XmlServices.resolveNumericEntity("&#222;"));
		buffer = StringServices.replace(buffer, "&szlig;",
				XmlServices.resolveNumericEntity("&#223;"));
		buffer = StringServices.replace(buffer, "&agrave;",
				XmlServices.resolveNumericEntity("&#224;"));
		buffer = StringServices.replace(buffer, "&aacute;",
				XmlServices.resolveNumericEntity("&#225;"));
		buffer = StringServices.replace(buffer, "&acirc;",
				XmlServices.resolveNumericEntity("&#226;"));
		buffer = StringServices.replace(buffer, "&atilde;",
				XmlServices.resolveNumericEntity("&#227;"));
		buffer = StringServices.replace(buffer, "&auml;",
				XmlServices.resolveNumericEntity("&#228;"));
		buffer = StringServices.replace(buffer, "&aring;",
				XmlServices.resolveNumericEntity("&#229;"));
		buffer = StringServices.replace(buffer, "&aelig;",
				XmlServices.resolveNumericEntity("&#230;"));
		buffer = StringServices.replace(buffer, "&ccedil;",
				XmlServices.resolveNumericEntity("&#231;"));
		buffer = StringServices.replace(buffer, "&egrave;",
				XmlServices.resolveNumericEntity("&#232;"));
		buffer = StringServices.replace(buffer, "&eacute;",
				XmlServices.resolveNumericEntity("&#233;"));
		buffer = StringServices.replace(buffer, "&ecirc;",
				XmlServices.resolveNumericEntity("&#234;"));
		buffer = StringServices.replace(buffer, "&euml;",
				XmlServices.resolveNumericEntity("&#235;"));
		buffer = StringServices.replace(buffer, "&igrave;",
				XmlServices.resolveNumericEntity("&#236;"));
		buffer = StringServices.replace(buffer, "&iacute;",
				XmlServices.resolveNumericEntity("&#237;"));
		buffer = StringServices.replace(buffer, "&icirc;",
				XmlServices.resolveNumericEntity("&#238;"));
		buffer = StringServices.replace(buffer, "&iuml;",
				XmlServices.resolveNumericEntity("&#239;"));
		buffer = StringServices.replace(buffer, "&eth;",
				XmlServices.resolveNumericEntity("&#240;"));
		buffer = StringServices.replace(buffer, "&ntilde;",
				XmlServices.resolveNumericEntity("&#241;"));
		buffer = StringServices.replace(buffer, "&ograve;",
				XmlServices.resolveNumericEntity("&#242;"));
		buffer = StringServices.replace(buffer, "&oacute;",
				XmlServices.resolveNumericEntity("&#243;"));
		buffer = StringServices.replace(buffer, "&ocirc;",
				XmlServices.resolveNumericEntity("&#244;"));
		buffer = StringServices.replace(buffer, "&otilde;",
				XmlServices.resolveNumericEntity("&#245;"));
		buffer = StringServices.replace(buffer, "&ouml;",
				XmlServices.resolveNumericEntity("&#246;"));
		buffer = StringServices.replace(buffer, "&divide;",
				XmlServices.resolveNumericEntity("&#247;"));
		buffer = StringServices.replace(buffer, "&oslash;",
				XmlServices.resolveNumericEntity("&#248;"));
		buffer = StringServices.replace(buffer, "&ugrave;",
				XmlServices.resolveNumericEntity("&#249;"));
		buffer = StringServices.replace(buffer, "&uacute;",
				XmlServices.resolveNumericEntity("&#250;"));
		buffer = StringServices.replace(buffer, "&ucirc;",
				XmlServices.resolveNumericEntity("&#251;"));
		buffer = StringServices.replace(buffer, "&uuml;",
				XmlServices.resolveNumericEntity("&#252;"));
		buffer = StringServices.replace(buffer, "&yacute;",
				XmlServices.resolveNumericEntity("&#253;"));
		buffer = StringServices.replace(buffer, "&thorn;",
				XmlServices.resolveNumericEntity("&#254;"));
		buffer = StringServices.replace(buffer, "&yuml;",
				XmlServices.resolveNumericEntity("&#255;"));
		buffer = StringServices.replace(buffer, "&Alpha;",
				XmlServices.resolveNumericEntity("&#913;"));
		buffer = StringServices.replace(buffer, "&alpha;",
				XmlServices.resolveNumericEntity("&#945;"));
		buffer = StringServices.replace(buffer, "&Beta;",
				XmlServices.resolveNumericEntity("&#914;"));
		buffer = StringServices.replace(buffer, "&beta;",
				XmlServices.resolveNumericEntity("&#946;"));
		buffer = StringServices.replace(buffer, "&Gamma;",
				XmlServices.resolveNumericEntity("&#915;"));
		buffer = StringServices.replace(buffer, "&gamma;",
				XmlServices.resolveNumericEntity("&#947;"));
		buffer = StringServices.replace(buffer, "&Delta;",
				XmlServices.resolveNumericEntity("&#916;"));
		buffer = StringServices.replace(buffer, "&delta;",
				XmlServices.resolveNumericEntity("&#948;"));
		buffer = StringServices.replace(buffer, "&Epsilon;",
				XmlServices.resolveNumericEntity("&#917;"));
		buffer = StringServices.replace(buffer, "&epsilon;",
				XmlServices.resolveNumericEntity("&#949;"));
		buffer = StringServices.replace(buffer, "&Zeta;",
				XmlServices.resolveNumericEntity("&#918;"));
		buffer = StringServices.replace(buffer, "&zeta;",
				XmlServices.resolveNumericEntity("&#950;"));
		buffer = StringServices.replace(buffer, "&Eta;",
				XmlServices.resolveNumericEntity("&#919;"));
		buffer = StringServices.replace(buffer, "&eta;",
				XmlServices.resolveNumericEntity("&#951;"));
		buffer = StringServices.replace(buffer, "&Theta;",
				XmlServices.resolveNumericEntity("&#920;"));
		buffer = StringServices.replace(buffer, "&theta;",
				XmlServices.resolveNumericEntity("&#952;"));
		buffer = StringServices.replace(buffer, "&Iota;",
				XmlServices.resolveNumericEntity("&#921;"));
		buffer = StringServices.replace(buffer, "&iota;",
				XmlServices.resolveNumericEntity("&#953;"));
		buffer = StringServices.replace(buffer, "&Kappa;",
				XmlServices.resolveNumericEntity("&#922;"));
		buffer = StringServices.replace(buffer, "&kappa;",
				XmlServices.resolveNumericEntity("&#954;"));
		buffer = StringServices.replace(buffer, "&Lambda;",
				XmlServices.resolveNumericEntity("&#923;"));
		buffer = StringServices.replace(buffer, "&lambda;",
				XmlServices.resolveNumericEntity("&#955;"));
		buffer = StringServices.replace(buffer, "&Mu;",
				XmlServices.resolveNumericEntity("&#924;"));
		buffer = StringServices.replace(buffer, "&mu;",
				XmlServices.resolveNumericEntity("&#956;"));
		buffer = StringServices.replace(buffer, "&Nu;",
				XmlServices.resolveNumericEntity("&#925;"));
		buffer = StringServices.replace(buffer, "&nu;",
				XmlServices.resolveNumericEntity("&#957;"));
		buffer = StringServices.replace(buffer, "&Xi;",
				XmlServices.resolveNumericEntity("&#926;"));
		buffer = StringServices.replace(buffer, "&xi;",
				XmlServices.resolveNumericEntity("&#958;"));
		buffer = StringServices.replace(buffer, "&Omicron;",
				XmlServices.resolveNumericEntity("&#927;"));
		buffer = StringServices.replace(buffer, "&omicron;",
				XmlServices.resolveNumericEntity("&#959;"));
		buffer = StringServices.replace(buffer, "&Pi;",
				XmlServices.resolveNumericEntity("&#928;"));
		buffer = StringServices.replace(buffer, "&pi;",
				XmlServices.resolveNumericEntity("&#960;"));
		buffer = StringServices.replace(buffer, "&Rho;",
				XmlServices.resolveNumericEntity("&#929;"));
		buffer = StringServices.replace(buffer, "&rho;",
				XmlServices.resolveNumericEntity("&#961;"));
		buffer = StringServices.replace(buffer, "&Sigma;",
				XmlServices.resolveNumericEntity("&#931;"));
		buffer = StringServices.replace(buffer, "&sigmaf;",
				XmlServices.resolveNumericEntity("&#962;"));
		buffer = StringServices.replace(buffer, "&sigma;",
				XmlServices.resolveNumericEntity("&#963;"));
		buffer = StringServices.replace(buffer, "&Tau;",
				XmlServices.resolveNumericEntity("&#932;"));
		buffer = StringServices.replace(buffer, "&tau;",
				XmlServices.resolveNumericEntity("&#964;"));
		buffer = StringServices.replace(buffer, "&Upsilon;",
				XmlServices.resolveNumericEntity("&#933;"));
		buffer = StringServices.replace(buffer, "&upsilon;",
				XmlServices.resolveNumericEntity("&#965;"));
		buffer = StringServices.replace(buffer, "&Phi;",
				XmlServices.resolveNumericEntity("&#934;"));
		buffer = StringServices.replace(buffer, "&phi;",
				XmlServices.resolveNumericEntity("&#966;"));
		buffer = StringServices.replace(buffer, "&Chi;",
				XmlServices.resolveNumericEntity("&#935;"));
		buffer = StringServices.replace(buffer, "&chi;",
				XmlServices.resolveNumericEntity("&#967;"));
		buffer = StringServices.replace(buffer, "&Psi;",
				XmlServices.resolveNumericEntity("&#936;"));
		buffer = StringServices.replace(buffer, "&psi;",
				XmlServices.resolveNumericEntity("&#968;"));
		buffer = StringServices.replace(buffer, "&Omega;",
				XmlServices.resolveNumericEntity("&#937;"));
		buffer = StringServices.replace(buffer, "&omega;",
				XmlServices.resolveNumericEntity("&#969;"));
		buffer = StringServices.replace(buffer, "&thetasym;",
				XmlServices.resolveNumericEntity("&#977;"));
		buffer = StringServices.replace(buffer, "&upsih;",
				XmlServices.resolveNumericEntity("&#978;"));
		buffer = StringServices.replace(buffer, "&piv;",
				XmlServices.resolveNumericEntity("&#982;"));
		buffer = StringServices.replace(buffer, "&forall;",
				XmlServices.resolveNumericEntity("&#8704;"));
		buffer = StringServices.replace(buffer, "&part;",
				XmlServices.resolveNumericEntity("&#8706;"));
		buffer = StringServices.replace(buffer, "&exist;",
				XmlServices.resolveNumericEntity("&#8707;"));
		buffer = StringServices.replace(buffer, "&empty;",
				XmlServices.resolveNumericEntity("&#8709;"));
		buffer = StringServices.replace(buffer, "&nabla;",
				XmlServices.resolveNumericEntity("&#8711;"));
		buffer = StringServices.replace(buffer, "&isin;",
				XmlServices.resolveNumericEntity("&#8712;"));
		buffer = StringServices.replace(buffer, "&notin;",
				XmlServices.resolveNumericEntity("&#8713;"));
		buffer = StringServices.replace(buffer, "&ni;",
				XmlServices.resolveNumericEntity("&#8715;"));
		buffer = StringServices.replace(buffer, "&prod;",
				XmlServices.resolveNumericEntity("&#8719;"));
		buffer = StringServices.replace(buffer, "&sum;",
				XmlServices.resolveNumericEntity("&#8721;"));
		buffer = StringServices.replace(buffer, "&minus;",
				XmlServices.resolveNumericEntity("&#8722;"));
		buffer = StringServices.replace(buffer, "&lowast;",
				XmlServices.resolveNumericEntity("&#8727;"));
		buffer = StringServices.replace(buffer, "&radic;",
				XmlServices.resolveNumericEntity("&#8730;"));
		buffer = StringServices.replace(buffer, "&prop;",
				XmlServices.resolveNumericEntity("&#8733;"));
		buffer = StringServices.replace(buffer, "&infin;",
				XmlServices.resolveNumericEntity("&#8734;"));
		buffer = StringServices.replace(buffer, "&ang;",
				XmlServices.resolveNumericEntity("&#8736;"));
		buffer = StringServices.replace(buffer, "&and;",
				XmlServices.resolveNumericEntity("&#8743;"));
		buffer = StringServices.replace(buffer, "&or;",
				XmlServices.resolveNumericEntity("&#8744;"));
		buffer = StringServices.replace(buffer, "&cap;",
				XmlServices.resolveNumericEntity("&#8745;"));
		buffer = StringServices.replace(buffer, "&cup;",
				XmlServices.resolveNumericEntity("&#8746;"));
		buffer = StringServices.replace(buffer, "&int;",
				XmlServices.resolveNumericEntity("&#8747;"));
		buffer = StringServices.replace(buffer, "&there4;",
				XmlServices.resolveNumericEntity("&#8756;"));
		buffer = StringServices.replace(buffer, "&sim;",
				XmlServices.resolveNumericEntity("&#8764;"));
		buffer = StringServices.replace(buffer, "&cong;",
				XmlServices.resolveNumericEntity("&#8773;"));
		buffer = StringServices.replace(buffer, "&asymp;",
				XmlServices.resolveNumericEntity("&#8776;"));
		buffer = StringServices.replace(buffer, "&ne;",
				XmlServices.resolveNumericEntity("&#8800;"));
		buffer = StringServices.replace(buffer, "&equiv;",
				XmlServices.resolveNumericEntity("&#8801;"));
		buffer = StringServices.replace(buffer, "&le;",
				XmlServices.resolveNumericEntity("&#8804;"));
		buffer = StringServices.replace(buffer, "&ge;",
				XmlServices.resolveNumericEntity("&#8805;"));
		buffer = StringServices.replace(buffer, "&sub;",
				XmlServices.resolveNumericEntity("&#8834;"));
		buffer = StringServices.replace(buffer, "&sup;",
				XmlServices.resolveNumericEntity("&#8835;"));
		buffer = StringServices.replace(buffer, "&nsub;",
				XmlServices.resolveNumericEntity("&#8836;"));
		buffer = StringServices.replace(buffer, "&sube;",
				XmlServices.resolveNumericEntity("&#8838;"));
		buffer = StringServices.replace(buffer, "&supe;",
				XmlServices.resolveNumericEntity("&#8839;"));
		buffer = StringServices.replace(buffer, "&oplus;",
				XmlServices.resolveNumericEntity("&#8853;"));
		buffer = StringServices.replace(buffer, "&otimes;",
				XmlServices.resolveNumericEntity("&#8855;"));
		buffer = StringServices.replace(buffer, "&perp;",
				XmlServices.resolveNumericEntity("&#8869;"));
		buffer = StringServices.replace(buffer, "&sdot;",
				XmlServices.resolveNumericEntity("&#8901;"));
		buffer = StringServices.replace(buffer, "&loz;",
				XmlServices.resolveNumericEntity("&#9674;"));
		buffer = StringServices.replace(buffer, "&lceil;",
				XmlServices.resolveNumericEntity("&#8968;"));
		buffer = StringServices.replace(buffer, "&rceil;",
				XmlServices.resolveNumericEntity("&#8969;"));
		buffer = StringServices.replace(buffer, "&lfloor;",
				XmlServices.resolveNumericEntity("&#8970;"));
		buffer = StringServices.replace(buffer, "&rfloor;",
				XmlServices.resolveNumericEntity("&#8971;"));
		buffer = StringServices.replace(buffer, "&lang;",
				XmlServices.resolveNumericEntity("&#9001;"));
		buffer = StringServices.replace(buffer, "&rang;",
				XmlServices.resolveNumericEntity("&#9002;"));
		buffer = StringServices.replace(buffer, "&larr;",
				XmlServices.resolveNumericEntity("&#8592;"));
		buffer = StringServices.replace(buffer, "&uarr;",
				XmlServices.resolveNumericEntity("&#8593;"));
		buffer = StringServices.replace(buffer, "&rarr;",
				XmlServices.resolveNumericEntity("&#8594;"));
		buffer = StringServices.replace(buffer, "&darr;",
				XmlServices.resolveNumericEntity("&#8595;"));
		buffer = StringServices.replace(buffer, "&harr;",
				XmlServices.resolveNumericEntity("&#8596;"));
		buffer = StringServices.replace(buffer, "&crarr;",
				XmlServices.resolveNumericEntity("&#8629;"));
		buffer = StringServices.replace(buffer, "&lArr;",
				XmlServices.resolveNumericEntity("&#8656;"));
		buffer = StringServices.replace(buffer, "&uArr;",
				XmlServices.resolveNumericEntity("&#8657;"));
		buffer = StringServices.replace(buffer, "&rArr;",
				XmlServices.resolveNumericEntity("&#8658;"));
		buffer = StringServices.replace(buffer, "&dArr;",
				XmlServices.resolveNumericEntity("&#8659;"));
		buffer = StringServices.replace(buffer, "&hArr;",
				XmlServices.resolveNumericEntity("&#8660;"));
		buffer = StringServices.replace(buffer, "&bull;",
				XmlServices.resolveNumericEntity("&#8226;"));
		buffer = StringServices.replace(buffer, "&prime;",
				XmlServices.resolveNumericEntity("&#8242;"));
		buffer = StringServices.replace(buffer, "&Prime;",
				XmlServices.resolveNumericEntity("&#8243;"));
		buffer = StringServices.replace(buffer, "&oline;",
				XmlServices.resolveNumericEntity("&#8254;"));
		buffer = StringServices.replace(buffer, "&frasl;",
				XmlServices.resolveNumericEntity("&#8260;"));
		buffer = StringServices.replace(buffer, "&weierp;",
				XmlServices.resolveNumericEntity("&#8472;"));
		buffer = StringServices.replace(buffer, "&image;",
				XmlServices.resolveNumericEntity("&#8465;"));
		buffer = StringServices.replace(buffer, "&real;",
				XmlServices.resolveNumericEntity("&#8476;"));
		buffer = StringServices.replace(buffer, "&trade;",
				XmlServices.resolveNumericEntity("&#8482;"));
		buffer = StringServices.replace(buffer, "&euro;",
				XmlServices.resolveNumericEntity("&#8364;"));
		buffer = StringServices.replace(buffer, "&alefsym;",
				XmlServices.resolveNumericEntity("&#8501;"));
		buffer = StringServices.replace(buffer, "&spades;",
				XmlServices.resolveNumericEntity("&#9824;"));
		buffer = StringServices.replace(buffer, "&clubs;",
				XmlServices.resolveNumericEntity("&#9827;"));
		buffer = StringServices.replace(buffer, "&hearts;",
				XmlServices.resolveNumericEntity("&#9829;"));
		buffer = StringServices.replace(buffer, "&diams;",
				XmlServices.resolveNumericEntity("&#9830;"));
		buffer = StringServices.replace(buffer, "&OElig;",
				XmlServices.resolveNumericEntity("&#338;"));
		buffer = StringServices.replace(buffer, "&oelig;",
				XmlServices.resolveNumericEntity("&#339;"));
		buffer = StringServices.replace(buffer, "&Scaron;",
				XmlServices.resolveNumericEntity("&#352;"));
		buffer = StringServices.replace(buffer, "&scaron;",
				XmlServices.resolveNumericEntity("&#353;"));
		buffer = StringServices.replace(buffer, "&Yuml;",
				XmlServices.resolveNumericEntity("&#376;"));
		buffer = StringServices.replace(buffer, "&fnof;",
				XmlServices.resolveNumericEntity("&#402;"));
		buffer = StringServices.replace(buffer, "&ensp;",
				XmlServices.resolveNumericEntity("&#8194;"));
		buffer = StringServices.replace(buffer, "&emsp;",
				XmlServices.resolveNumericEntity("&#8195;"));
		buffer = StringServices.replace(buffer, "&thinsp;",
				XmlServices.resolveNumericEntity("&#8201;"));
		buffer = StringServices.replace(buffer, "&zwnj;",
				XmlServices.resolveNumericEntity("&#8204;"));
		buffer = StringServices.replace(buffer, "&zwj;",
				XmlServices.resolveNumericEntity("&#8205;"));
		buffer = StringServices.replace(buffer, "&lrm;",
				XmlServices.resolveNumericEntity("&#8206;"));
		buffer = StringServices.replace(buffer, "&rlm;",
				XmlServices.resolveNumericEntity("&#8207;"));
		buffer = StringServices.replace(buffer, "&ndash;",
				XmlServices.resolveNumericEntity("&#8211;"));
		buffer = StringServices.replace(buffer, "&mdash;",
				XmlServices.resolveNumericEntity("&#8212;"));
		buffer = StringServices.replace(buffer, "&lsquo;",
				XmlServices.resolveNumericEntity("&#8216;"));
		buffer = StringServices.replace(buffer, "&rsquo;",
				XmlServices.resolveNumericEntity("&#8217;"));
		buffer = StringServices.replace(buffer, "&sbquo;",
				XmlServices.resolveNumericEntity("&#8218;"));
		buffer = StringServices.replace(buffer, "&ldquo;",
				XmlServices.resolveNumericEntity("&#8220;"));
		buffer = StringServices.replace(buffer, "&rdquo;",
				XmlServices.resolveNumericEntity("&#8221;"));
		buffer = StringServices.replace(buffer, "&bdquo;",
				XmlServices.resolveNumericEntity("&#8222;"));
		buffer = StringServices.replace(buffer, "&dagger;",
				XmlServices.resolveNumericEntity("&#8224;"));
		buffer = StringServices.replace(buffer, "&Dagger;",
				XmlServices.resolveNumericEntity("&#8225;"));
		buffer = StringServices.replace(buffer, "&hellip;",
				XmlServices.resolveNumericEntity("&#8230;"));
		buffer = StringServices.replace(buffer, "&permil;",
				XmlServices.resolveNumericEntity("&#8240;"));
		buffer = StringServices.replace(buffer, "&lsaquo;",
				XmlServices.resolveNumericEntity("&#8249;"));
		buffer = StringServices.replace(buffer, "&rsaquo;",
				XmlServices.resolveNumericEntity("&#8250;"));
		buffer = StringServices.replace(buffer, "&circ;",
				XmlServices.resolveNumericEntity("&#710;"));
		buffer = StringServices.replace(buffer, "&tilde;",
				XmlServices.resolveNumericEntity("&#732;"));

		return buffer;
	}
}
