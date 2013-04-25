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

public class InformalFigure extends DocBookElement {

    private static final String TAG = "informalfigure";
    private static final HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

	invalidParentMap = new HashMap<String, HashMap<String, Object>>();
	invalidParentMap.put(Abbrev.getTag(), Abbrev.getAttributeMap());
	invalidParentMap.put(Acronym.getTag(), Acronym.getAttributeMap());
	invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
	invalidParentMap.put(Subscript.getTag(), Subscript.getAttributeMap());
	invalidParentMap.put(Superscript.getTag(), Superscript.getAttributeMap());
	invalidParentMap.put(Title.getTag(), Title.getAttributeMap());
	invalidParentMap.put(ProgramListing.getTag(), ProgramListing.getAttributeMap());
    }

    public static String getTag() {

	return TAG;
    }

    InformalFigure() {
	super("informalfigure");
	setFormatType(FORMAT_BLOCK);
    }

    @Override
    public boolean validate() {

	return validate(invalidParentMap);
    }
}
