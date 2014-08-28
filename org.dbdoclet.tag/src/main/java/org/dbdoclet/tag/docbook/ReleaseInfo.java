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

public class ReleaseInfo extends DocBookElement {

    private static String tagName = "releaseinfo";

    ReleaseInfo() {

        super(tagName);
        setFormatType(FORMAT_INLINE);
    }

    ReleaseInfo(String text) {

        this();
        appendChild(XmlServices.textToXml(text));
    }
}
