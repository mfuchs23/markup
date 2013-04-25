/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;




public class Quote extends DocBookElement {

    Quote() {
        super("quote");
        setFormatType(FORMAT_INLINE);
    }

    Quote(String text) {
        super("quote");
        appendChild(text);
        setFormatType(FORMAT_INLINE);
    }
}
