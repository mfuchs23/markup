/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class RefPurpose extends DocBookElement {

    private static String tagName = "refpurpose";

    RefPurpose() {

        super(tagName);
    }

    RefPurpose(String refpurpose) {

        this();
        appendChild(refpurpose);
    }

    public static String getTag() {

        return tagName;
    }
}
