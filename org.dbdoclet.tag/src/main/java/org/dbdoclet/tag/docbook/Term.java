/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class Term extends DocBookElement {

    Term() {
        super("term");
    }

    Term(String text) {
        super("term");
        appendChild(text);
    }
}
