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
 * Id.........: $Id: ProgramElement.java,v 1.1.1.1 2004/12/21 14:00:25 mfuchs Exp $
 * Author.....: $Author: mfuchs $
 * Date.......: $Date: 2004/12/21 14:00:25 $
 * Revision...: $Revision: 1.1.1.1 $
 * State......: $State: Exp $
 */
package org.dbdoclet.tag.dbd;


public abstract class ProgramElement extends DbdElement {

    public ProgramElement(String name) {

        super(name);
        setFormatType(FORMAT_BLOCK);
    }

    public void setVisibility(String visibility) {
        setAttribute("visibility", visibility);
    }

    public void setAbstract(boolean isAbstract) {
        setAttribute("isAbstract", String.valueOf(isAbstract));
    }

    public void setStatic(boolean isStatic) {
        setAttribute("isStatic", String.valueOf(isStatic));
    }
}
