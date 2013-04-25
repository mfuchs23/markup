/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Article extends SectionElement {

    private static final String tag = "article";

    Article() {

        super(tag);
        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    Article(String title) {

        this();
        appendChild(new Title(title));
    }

    public static String getTag() {

        return tag;
    }
}
