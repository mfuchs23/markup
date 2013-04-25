/*
 * ### Copyright (C) 2001-2003 Michael Fuchs ###
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2,    or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not,    write to the
 * Free Software Foundation,    Inc.,    59 Temple Place - Suite 330,
 * Boston,    MA 02111-1307,    USA.
 *
 * Author: Michael Fuchs
 * E-Mail: mfuchs@unico-consulting.com
 *
 * RCS Information:
 * ---------------
 * Id.........: $Id: Linkplain.java,v 1.1.1.1 2004/12/21 14:01:00 mfuchs Exp $
 * Author.....: $Author: mfuchs $
 * Date.......: $Date: 2004/12/21 14:01:00 $
 * Revision...: $Revision: 1.1.1.1 $
 * State......: $State: Exp $
 */
package org.dbdoclet.tag.javadoc;


/**
 * The class <code>Linkplain</code> represents a javadoc linkplain tag.
 * 
 * <div id="example_javadoc_linkplain"> This is an examples for an embedded
 * javadoc linkplain tag: The type of the return code is a
 * {@linkplain org.dbdoclet.xiphias.dom.NodeImpl Node}. </div>
 * 
 * @author <a href="mailto:mfuchs@unico-consulting.com">Michael Fuchs</a>
 * @version 1.0
 */
public class Linkplain extends JavaDocElement {

    public Linkplain() {
	super();
	setNodeName("javadoc:linkplain");
	setFormatType(FORMAT_INLINE);
    }

    public String getName() {
	return getAttribute("name");
    }

    public String getRef() {
	return getAttribute("ref");
    }

    @Override
    public void init() {
    }

    @Override
    public boolean validate() {

	nodeStack.removeAllElements();
	nodeStack.push(this);
	return true;
    }
}
