/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Preface extends SectionElement {

    private static final String tag = "preface";

    Preface() {
        super(tag);
        setFormatType(FORMAT_BLOCK);
    }
}
