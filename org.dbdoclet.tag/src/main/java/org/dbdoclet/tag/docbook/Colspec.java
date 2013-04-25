/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class Colspec extends DocBookElement {

    Colspec() {
        super("colspec");
        isEmpty(true);
    }

    Colspec(String name, String width) {
        super("colspec");
        setAttribute("colname", name);
        setAttribute("colwidth", width);
        isEmpty(true);
    }
}
