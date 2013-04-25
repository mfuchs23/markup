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

public class Literal extends DocBookElement {

    private static String tag = "literal";
    private static HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

	invalidParentMap = new HashMap<String, HashMap<String, Object>>();
	invalidParentMap.put(Abbrev.getTag(), Abbrev.getAttributeMap());
	invalidParentMap.put(Acronym.getTag(), Acronym.getAttributeMap());
	invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
	invalidParentMap.put(ExceptionName.getTag(), ExceptionName.getAttributeMap());
	invalidParentMap.put(Literal.getTag(), Literal.getAttributeMap());
	invalidParentMap.put(Section.getTag(), Section.getAttributeMap());
	invalidParentMap.put(Subscript.getTag(), Subscript.getAttributeMap());
	invalidParentMap.put(Superscript.getTag(), Superscript.getAttributeMap());
    }

    public static String getTag() {

	return tag;
    }

    Literal() {
	super(tag);
	setFormatType(FORMAT_INLINE);
    }

    Literal(String text) {
	super(tag);
	appendChild(text);
	setFormatType(FORMAT_INLINE);
    }

    @Override
    public boolean validate() {
	return validate(invalidParentMap);
    }

    @Override
    public boolean isValidParent(DocBookElement elem) {

        if (elem == null) {
            throw new IllegalArgumentException("Parameter elem is null!");
        }

        if (invalidParentMap.get(elem.getNodeName()) != null) {
            return false;
        }

        return true;
    }
}
