/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class Programlisting extends DocBookElement {

    private static final String tag = "programlisting";

    Programlisting() {

        super(tag);

        setFormatType(FORMAT_CONTENT);
        isLiteral(true);
    }

    Programlisting(String text) {
        this();

        appendChild(text);
    }

    Programlisting setWidth(int width) {

        setAttribute("width", Integer.valueOf(width));

        return this;
    }

    public static String getTag() {

        return tag;
    }

    public void setLinenumberingEnabled(boolean linenumbering) {

        if (linenumbering == true) {
            setAttribute("linenumbering", "numbered");
        } else {
            setAttribute("linenumbering", "unnumbered");
        }
    }
}
