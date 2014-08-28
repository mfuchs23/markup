/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.XmlServices;

public class Code extends DocBookElement {

    private static String tag = "code";

    Code() {

        super(tag);
        setFormatType(FORMAT_INLINE);
    }

    Code(String text) {

        this();
        appendChild(XmlServices.textToXml(text));
    }
}
