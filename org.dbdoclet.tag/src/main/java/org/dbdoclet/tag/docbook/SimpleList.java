/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class SimpleList extends DocBookElement {

    final static public int FORMAT_INLINE = 1;

    SimpleList() {
        super("simplelist");
    }

    SimpleList setType(int type) {

        if (type == FORMAT_INLINE) {

            setAttribute("type", "inline");
        }

        return this;
    }
}
