/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;



public abstract class TableColumnElement extends StrictElement {

    private int index = -1;
    public String getWidth() {

        String width = getAttribute("width");

        if ((width == null) || (width.length() == 0)) {

            return "";
        } else {

            return width;
        }
    }

    public int getColspan() {

        String str = getAttribute("colspan");

        if ((str == null) || (str.length() == 0)) {
            return 1;
        }

        int colspan;

        try {
            colspan = Integer.parseInt(str);
        } catch (NumberFormatException oops) {
            colspan = 1;
        }

        return colspan;
    }

    public int getRowspan() {

        String str = getAttribute("rowspan");

        if ((str == null) || (str.length() == 0)) {

            return 0;
        }

        int rowspan;

        try {

            rowspan = Integer.parseInt(str);
            rowspan--;
        } catch (NumberFormatException oops) {

            rowspan = 0;
        } // end of catch

        if (rowspan < 0) {
            rowspan = 0;
        }

        return rowspan;
    }

    public String getAlign() {

        return getAttribute("align");
    }

    public String getVAlign() {

        String valign = getAttribute("valign");

        if ((valign == null) || (valign.length() == 0)) {

            return null;
        }

        if (valign.equalsIgnoreCase("top") ||
            valign.equalsIgnoreCase("middle") ||
            valign.equalsIgnoreCase("bottom") ||
            valign.equalsIgnoreCase("baseline")) {

            return valign;
        }

        if (valign.equalsIgnoreCase("head")) {
            return "top";
        }

        return "middle";
    }

    public String getChar() {
        return getAttribute("char");
    }

    public String getCharOff() {
        return getAttribute("charoff");
    }

    public void setIndex(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    @Override
	public boolean validateAttributes() {

        String valign = getVAlign();

        if (valign != null) {

            setAttribute("valign", valign);
        }

        return true;
    }
}
