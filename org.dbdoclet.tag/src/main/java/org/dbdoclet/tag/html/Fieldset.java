/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.TextImpl;


public class Fieldset extends ReplaceElement {

    private static final String tag = "fieldset";

    public Fieldset() {

        setNodeName(tag);
        setFormatType(FORMAT_BLOCK);
    }

    @Override
	public void closed() {

        NodeImpl child = getFirstChild();

        if (!(child instanceof Legend)) {
            insertChild(0, new Legend().appendChild(new TextImpl("Legend")));
        }
    }
}
