/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class Spanspec extends DocBookElement {

    Spanspec() {
        super("spanspec");
        isEmpty(true);
    }

    Spanspec(String name, String start, String end, String align) {
        super("spanspec");
        setAttribute("spanname", name);
        setAttribute("namest", start);
        setAttribute("nameend", end);
        setAttribute("align", align);
        isEmpty(true);
    }
}
