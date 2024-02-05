/* 
 * ### Copyright (C) 2008-2024 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

public class Simplelist extends DocBookElement {

    public static enum Type { HORIZ, VERT, INLINE };

    Simplelist() {
        super("simplelist");
    }

    Simplelist setType(Type type) {
    	setAttribute("type", type.toString().toLowerCase());
        return this;
    }
}
