/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class MethodName extends DocBookElement {

    private static final String tagName = "methodname";

    public static String getTag() {
	return tagName;
    }

    MethodName() {

	super(tagName);
    }

    MethodName(String methodname) {

	this();
	appendChild(methodname);
    }

}
