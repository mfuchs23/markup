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

public class Title extends DocBookElement {

    private static final String tag = "title";

    private static final HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

	invalidParentMap = new HashMap<String, HashMap<String, Object>>();
        invalidParentMap.put(InformalExample.getTag(), InformalExample.getAttributeMap());
	invalidParentMap.put(InformalFigure.getTag(), InformalFigure.getAttributeMap());
	invalidParentMap.put(InformalTable.getTag(), InformalTable.getAttributeMap());
	invalidParentMap.put(Para.getTag(), Para.getAttributeMap());
    }

    public static HashMap<String, Object> getAttributeMap() {
	return new HashMap<String, Object>();
    }

    public static String getTag() {
	return tag;
    }

    Title() {

	super(tag);
    }

    Title(String title) {

	super(tag);

	if (title != null) {
	    appendChild(XmlServices.textToXml(title));
	}
    }

    @Override
    public boolean validate() {
	return validate(invalidParentMap);
    }
}
