/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class Sect4 extends SectionElement {

    private final static String tag = "sect4";

    Sect4() {

        super(tag);
        isContentModel(true);
    }

    Sect4(String title) {

        super(tag);
        appendChild(new Title(title));
        isContentModel(true);
    }

    public static String getTag() {
        return tag;
    }
}
