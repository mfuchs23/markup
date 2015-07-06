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


public class Varlistentry extends DocBookElement {

    Varlistentry() {
        super("varlistentry");
        setFormatType(FORMAT_BLOCK);
    }

    @Override
    public void closed() {

        if (hasChildNodes() == false) {

            appendChild(new Term());
            appendChild(new Listitem().appendChild(new Simpara()));
            return;
        }

        if (getNumberOfChildNodes() == 1) {

            NodeImpl node = (NodeImpl) getTrafoChildNodes().get(0);

            if (node instanceof Term) {

                appendChild(new Listitem().appendChild(new Simpara()));
                return;
            }

            if (node instanceof Listitem) {

                insertChild(0, new Term());
                return;
            }
        }
    }
}
