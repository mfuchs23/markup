/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

public class ColumnInfo {

    int maxWidth = 0;

    public void setMaxWidth(int width) {
        
        if (width > maxWidth) {
            maxWidth = width;
        }
    }

    public int getWidth() {
        return maxWidth;
    }
}
