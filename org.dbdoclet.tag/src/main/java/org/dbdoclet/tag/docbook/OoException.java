/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class OoException extends DocBookElement {

    private static String tagName = "ooexception";

    OoException() {

	super(tagName);

	setFormatType(FORMAT_BLOCK);
	isContentModel(true);
    }
}