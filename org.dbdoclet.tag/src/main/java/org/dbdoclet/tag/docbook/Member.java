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

public class Member extends DocBookElement {

    private static HashMap<String, HashMap<String, Object>> invalidParentMap;
    private static String tag = "member";

    static {
	invalidParentMap = new HashMap<String, HashMap<String, Object>>();
    }

    public static String getTag() {
	return tag;
    }

    Member() {
	super(tag);
	setFormatType(FORMAT_CONTENT);
    }

    Member(String text) {
	this();
	appendChild(text);
    }

    @Override
    public boolean validate() {
	return validate(invalidParentMap);
    }
}
