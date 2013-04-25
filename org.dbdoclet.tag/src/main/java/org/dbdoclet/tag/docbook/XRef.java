/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class XRef extends DocBookElement {

    XRef(String linkend) {

        super("xref");
        setAttribute("linkend", hardenId(linkend));
        setFormatType(FORMAT_INLINE);
        isEmpty(true);
        needsPadding(false);
    }
}
