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

public class Emphasis extends DocBookElement {

    private static String tag = "emphasis";
    private static HashMap<String, HashMap<String, Object>> invalidParentMap;

    static {

        invalidParentMap = new HashMap<String, HashMap<String, Object>>();
        invalidParentMap.put(Address.getTag(), Address.getAttributeMap());
        invalidParentMap.put(Article.getTag(), Article.getAttributeMap());
        invalidParentMap.put(BlockQuote.getTag(), BlockQuote.getAttributeMap());
        invalidParentMap.put(Book.getTag(), Book.getAttributeMap());
        invalidParentMap.put(Chapter.getTag(), Chapter.getAttributeMap());
        invalidParentMap.put(ListItem.getTag(), ListItem.getAttributeMap());
        invalidParentMap.put(Sect1.getTag(), Sect1.getAttributeMap());
        invalidParentMap.put(Sect2.getTag(), Sect2.getAttributeMap());
        invalidParentMap.put(Sect3.getTag(), Sect3.getAttributeMap());
        invalidParentMap.put(Sect4.getTag(), Sect4.getAttributeMap());
        invalidParentMap.put(Sect5.getTag(), Sect5.getAttributeMap());
        invalidParentMap.put(Section.getTag(), Section.getAttributeMap());
        invalidParentMap.put(SimpleSect.getTag(), SimpleSect.getAttributeMap());
        invalidParentMap.put(Subscript.getTag(), Subscript.getAttributeMap());
        invalidParentMap.put(Superscript.getTag(), Superscript.getAttributeMap());
    }

    Emphasis() {

	super(tag);
        setFormatType(FORMAT_INLINE);
    }

    Emphasis(String text) {

	super(tag);
        appendChild(text);
        setFormatType(FORMAT_INLINE);
    }

    Emphasis(String text, String role) {

	super(tag);
        appendChild(text);
        setAttribute("role", role);
        setFormatType(FORMAT_INLINE);
    }

    Emphasis(DocBookElement elem) {

	super(tag);
        appendChild(elem);
        setFormatType(FORMAT_INLINE);
    }

    public static String getTag() {
        return tag;
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
