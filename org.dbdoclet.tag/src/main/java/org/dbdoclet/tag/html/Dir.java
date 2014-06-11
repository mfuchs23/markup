/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;



public class Dir extends Inline2Element {

    private static final String tag = "dir";

    public Dir() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }

    @Override
	public void closed() {

        if ((hasChildNodes() == false) || (getNumberOfChildNodes() == 0)) {
            appendChild(new Li());
        }
    }
}
