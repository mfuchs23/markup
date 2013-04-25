/* 
 * $Id$
 *
 * ### Copyright (C) 2005 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 *
 * RCS Information
 * Author..........: $Author$
 * Date............: $Date$
 * Revision........: $Revision$
 * State...........: $State$
 */
package org.dbdoclet.tag.dbd;

import org.dbdoclet.xiphias.dom.TextImpl;


public class Return extends DbdElement {

    public Return() {
        super("return");
    }

    public Return(String description) {
        super("return");
        appendChild(new TextImpl(description));
    }
}
/*
 * $Log$
 */
