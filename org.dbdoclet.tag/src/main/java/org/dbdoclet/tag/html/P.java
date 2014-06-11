/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;


public class P extends Inline2Element {

    private static String tag = "p";

    public static String getTag() {
    	return tag;
    }

    public P() {

    	setNodeName(tag);
    	setFormatType(FORMAT_CONTENT);
    }
}
