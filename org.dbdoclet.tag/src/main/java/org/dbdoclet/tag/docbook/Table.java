/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class Table extends DocBookElement {

    Table() {

        super("table");
        setFormatType(FORMAT_BLOCK);
        setFrame("none");
    }

    Table(String tagname) {

        super(tagname);
        setFormatType(FORMAT_BLOCK);
        setFrame("none");
    }

    public DocBookElement setFrame(String frame) {

        setAttribute("frame", frame);
        return this;
    }
}
