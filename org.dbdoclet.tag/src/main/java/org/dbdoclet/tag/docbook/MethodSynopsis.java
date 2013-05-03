/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class MethodSynopsis extends DocBookElement {

    private static final String tagName = "methodsynopsis";

    MethodSynopsis() {

	super(tagName);

	setFormatType(FORMAT_BLOCK);
	isContentModel(true);

	setAttribute("language", "java");
    }

    public void setLanguage(String language) {
	setAttribute("language", language);
    }
}