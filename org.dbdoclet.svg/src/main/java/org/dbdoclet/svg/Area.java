/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import java.util.ArrayList;
import java.util.Iterator;

import org.dbdoclet.service.StringServices;

public class Area {

    public final static int RECT = 1;
    
    private ArrayList<String> coordsList;
    private int type = RECT;
    private String name;
    
    public Area() {

        coordsList = new ArrayList<String>();
    }
    
    public void addCoords(int x, int y) {
        coordsList.add(String.valueOf(x));
        coordsList.add(String.valueOf(y));
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(int type) {
        this.type = type;
    }
    
    public int getType() {
        return type;
    }

    public String getCoordsAsText() {
        
        StringBuffer buffer = new StringBuffer();
        
        String coord;
        Iterator<String> iterator = coordsList.iterator();
        
        while (iterator.hasNext()) {
            
            coord = iterator.next();
            buffer.append(coord);
            buffer.append(",");
        }
        
        String text = buffer.toString();
        text = StringServices.trim(text, ',');
        return text;
    }
}
