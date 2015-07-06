/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Varname extends DocBookElement {

    Varname() {
        super("varname");
    }

    Varname(String varname) {
        super("varname");
        appendChild(varname);
    }
}
