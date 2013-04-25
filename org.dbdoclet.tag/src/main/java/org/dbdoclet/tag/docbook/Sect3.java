/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;



public class Sect3 extends SectionElement {

    private final static String tag = "sect3";

    Sect3() {

        super(tag);

        setFormatType(FORMAT_BLOCK);
        isContentModel(true);
    }

    Sect3(String title) {

        super(tag);

        setFormatType(FORMAT_BLOCK);
        appendChild(new Title(title));
        isContentModel(true);
    }

    public static String getTag() {
        return tag;
    }
}
