/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

public class RowInfo {

    int maxHeight = 0;
    
    public void setMaxHeight(int height) {
        
        if (height > maxHeight) {
            maxHeight = height;
        }
    }

    public int getHeight() {
        return maxHeight;
    }
}
