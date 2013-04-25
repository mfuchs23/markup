/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;


public class InformalTable extends Table {

    private static final String tag = "informaltable";
    
    InformalTable() {

        super(tag);
        setFormatType(FORMAT_BLOCK);
        setFrame("none");
    }

    public static String getTag() {
        return tag;
    }
}
