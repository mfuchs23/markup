/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

 
public class FieldSynopsis extends DocBookElement {

    private static final String tagName = "fieldsynopsis";

    FieldSynopsis() {

        super(tagName);

        setFormatType(FORMAT_BLOCK);
        isContentModel(true);

        setAttribute("language", "java");
    }

    public static String getTag() {
        return tagName;
    }
    
    public void setLanguage(String language) {
        setAttribute("language", language);
    }
}

