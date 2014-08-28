/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Appendix extends SectionElement {

    private static final String tagName = "appendix";

    Appendix() {
        super(tagName);
        setFormatType(FORMAT_BLOCK);
     }

     public static String getTag() {
        return tagName;
    }
}