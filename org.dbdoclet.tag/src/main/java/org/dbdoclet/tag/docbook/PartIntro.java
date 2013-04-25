/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;



public class PartIntro extends SectionElement {

    private static final String tagName = "partintro";

    PartIntro() {

        super(tagName);

        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    PartIntro(String title) {

        this();
        appendChild(new Title(title));
    }

    public static String getTag() {
        return tagName;
    }
}
