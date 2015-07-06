/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Methodparam extends DocBookElement {

    private static String tagName = "methodparam";

    public static String getTag() {
	return tagName;
    }

    Methodparam() {

	super(tagName);
	setFormatType(FORMAT_INLINE);
    }
}
