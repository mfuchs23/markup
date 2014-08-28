/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

 
public class ClassSynopsis extends DocBookElement {

    private static final String tag = "classsynopsis";

    ClassSynopsis() {

        super(tag);
        setFormatType(FORMAT_BLOCK);
        setAttribute("class", "class");
        setAttribute("language", "java");
    }

    public void setLanguage(String language) {
        setAttribute("language", language);
    }
    
    public void setInterface(boolean value) {

        if (value == true) {
            setAttribute("class", "interface");
        } else {
            setAttribute("class", "class");
        }
    }
}

