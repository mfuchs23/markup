/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.dom.ElementImpl;

public class Entry extends DocBookElement {

    private static String tag = "entry";

    public static String getTag() {
	return tag;
    }

    Entry() {
	super(tag);
    }

    Entry(String text) {
	super(tag);
	appendChild(new Para(text).setFormatType(ElementImpl.FORMAT_INLINE));
    }

    public Entry setAlign(String align) {

	if (align != null) {
	    align = align.toLowerCase();
	}

	setAttribute("align", align);
	return this;
    }

    public Entry setChar(String charAttr) {

	setAttribute("char", charAttr);
	return this;
    }

    public Entry setCharOff(String charOff) {

	setAttribute("charOff", charOff);

	return this;
    }

    public Entry setMorerows(int mr) {

	setAttribute("morerows", new Integer(mr));
	return this;
    }

    public Entry setNameEnd(String s) {

	setAttribute("nameend", s);
	return this;
    }

    public Entry setNameSt(String s) {

	setAttribute("namest", s);
	return this;
    }

    Entry setSpanname(String sn) {

	setAttribute("spanname", sn);
	return this;
    }

    public Entry setVAlign(String valign) {

	if (valign != null) {
	    valign = valign.toLowerCase();
	}

	setAttribute("valign", valign);
	return this;
    }

    @Override
    protected boolean validateAttributes() {

	String attr;

	attr = getAttribute("align");

	if ((attr != null) && (attr.equalsIgnoreCase("left") == false)
		&& (attr.equalsIgnoreCase("right") == false)
		&& (attr.equalsIgnoreCase("center") == false)
		&& (attr.equalsIgnoreCase("justify") == false)
		&& (attr.equalsIgnoreCase("char") == false)) {

	    setAttribute("align", "center");
	}

	attr = getAttribute("valign");

	if ((attr != null) && (attr.equalsIgnoreCase("top") == false)
		&& (attr.equalsIgnoreCase("middle") == false)
		&& (attr.equalsIgnoreCase("baseline") == false)
		&& (attr.equalsIgnoreCase("bottom") == false)) {

	    setAttribute("valign", "middle");
	}

	return true;
    }
}
