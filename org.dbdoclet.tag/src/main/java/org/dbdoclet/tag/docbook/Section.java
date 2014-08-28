/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Section extends SectionElement {

    private final static String tagName = "section";

    Section() {
        super(tagName);
        setFormatType(FORMAT_BLOCK);
    }
}
