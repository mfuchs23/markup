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
 * Id.........: $Id: NodeStack.java,v 1.1.1.1 2004/12/21 14:00:23 mfuchs Exp $
 * Author.....: $Author: mfuchs $
 * Date.......: $Date: 2004/12/21 14:00:23 $
 * Revision...: $Revision: 1.1.1.1 $
 * State......: $State: Exp $
 */
package org.dbdoclet.xiphias.dom;

import java.util.Stack;


public class NodeStack extends Stack<Object> {

    private static final long serialVersionUID = 1L;

    public int searchNearest(String[] nodes) {

        if (nodes == null) {

            throw new IllegalArgumentException("Variable nodes is null!");
        }

        int min = -1;
        int index;

        for (int i = 0; i < nodes.length; i++) {

            index = search(nodes[i]);

            if (index != -1) {

                if ((min == -1) || (index < min)) {
                    min = index;
                }
            } // end of if ()
        } // end of for ()

        return min;
    }
}
