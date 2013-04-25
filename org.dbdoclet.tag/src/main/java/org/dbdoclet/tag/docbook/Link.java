/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.util.HashMap;

import org.dbdoclet.xiphias.XmlServices;

public class Link extends DocBookElement {

    private static final HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

	invalidParentMap = new HashMap<String, HashMap<String, Object>>();
	invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
    }

    Link() {
	super("link");
    }

    Link(DocBookElement label, String linkend) {

	this(linkend);
	appendChild(label);
    }

    Link(String linkend) {

	this();

	setAttribute("linkend", hardenId(linkend));
	setFormatType(FORMAT_INLINE);
    }

    Link(String label, String linkend) {

	this(linkend);
	appendChild(XmlServices.textToXml(label));
    }

    public void setHref(String href) {

	if (isDocBook5() == true) {
	    setAttribute("xl:href", href);
	} else {
	    setAttribute("linkend", href);
	}
    }

    @Override
    public boolean validate() {
	return validate(invalidParentMap);
    }
}
