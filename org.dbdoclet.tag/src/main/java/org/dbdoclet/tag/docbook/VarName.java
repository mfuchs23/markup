/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class VarName extends DocBookElement {

    VarName() {
        super("varname");
    }

    VarName(String varname) {
        super("varname");
        appendChild(varname);
    }
}
