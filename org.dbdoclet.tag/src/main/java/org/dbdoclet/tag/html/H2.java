/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;



public class H2 extends HeaderElement {

    protected static final int level = 2;
    private static final String tag = "h2";
    public H2() {

        setNodeName(tag);
    }

    @Override
	public int getLevel() {

        return level;
    }
}
