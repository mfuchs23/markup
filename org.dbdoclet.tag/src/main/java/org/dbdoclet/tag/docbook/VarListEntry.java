/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.xiphias.dom.NodeImpl;


public class VarListEntry extends DocBookElement {

    VarListEntry() {
        super("varlistentry");
        setFormatType(FORMAT_BLOCK);
    }

    @Override
    public void closed() {

        if (hasChildNodes() == false) {

            appendChild(new Term());
            appendChild(new ListItem().appendChild(new SimPara()));
            return;
        }

        if (getNumberOfChildNodes() == 1) {

            NodeImpl node = (NodeImpl) getTrafoChildNodes().get(0);

            if (node instanceof Term) {

                appendChild(new ListItem().appendChild(new SimPara()));
                return;
            }

            if (node instanceof ListItem) {

                insertChild(0, new Term());
                return;
            }
        }
    }
}
