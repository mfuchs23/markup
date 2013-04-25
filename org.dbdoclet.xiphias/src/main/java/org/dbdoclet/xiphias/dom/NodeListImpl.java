/*
 * ### Copyright (C) 2001-2003 Michael Fuchs ###
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * Author: Michael Fuchs
 * E-Mail: mfuchs@unico-consulting.com
 *
 * RCS Information:
 * ---------------
 * Id.........: $Id: NodeList.java,v 1.1.1.1 2004/12/21 14:00:21 mfuchs Exp $
 * Author.....: $Author: mfuchs $
 * Date.......: $Date: 2004/12/21 14:00:21 $
 * Revision...: $Revision: 1.1.1.1 $
 * State......: $State: Exp $
 */
package org.dbdoclet.xiphias.dom;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListImpl extends ArrayList<NodeImpl> implements NodeList {

	private static final long serialVersionUID = 1L;

	public int getLength() {
		return size();
	}

	public Node item(int index) {

		if ((index < 0) || (index >= size())) {
			return null;
		}

		Object obj = get(index);

		if (obj instanceof Node) {
			return (Node) obj;
		} else {
			throw new IllegalStateException(
					"Object in NodeList is not of type Node but of type " + obj);
		}
	}

	@Override
	public Iterator<NodeImpl> iterator() {

		Iterator<NodeImpl> iterator = super.iterator();
		return iterator;
	}
}
