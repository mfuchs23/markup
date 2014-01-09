/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

import java.util.ArrayList;

import org.dbdoclet.svg.SvgFontMetrics;

public abstract class ClassBox extends TextShape {

	public static final String STEREOTYPE_RIGHT = "»";
	public static final String STEREOTYPE_LEFT = "«";

	private int roundedCorner = 0;
    private int subboxWidth = 0;
    private boolean shadowEnabled = false;
	private ArrayList<Text> typeParameterList;

    public ClassBox(String id, int row, int column) {
        super(id, row, column);
        typeParameterList = new ArrayList<Text>();
    }

   	public void addTemplateParameter(Text typeParameter) {
		typeParameterList.add(typeParameter);

		SvgFontMetrics fm = new SvgFontMetrics(typeParameter.getFont(), typeParameter.getText());
        int width = getLeftPadding() + fm.stringWidth() + getRightPadding();
        
        if (width > subboxWidth) {
            subboxWidth = width;
        }
	}

   	public abstract void draw(int x, int y);

	@Override
	public int getHeight() {
		return super.getHeight() + getTemplateParameterBoxHeight();
	}
    
    public int getRoundedCorner() {
        return roundedCorner;
    }

	public int getTemplateParameterBoxHeight() {

		
		int subboxHeight = 0;
		
		for (Text line : typeParameterList) {
			SvgFontMetrics fm = new SvgFontMetrics(line.getFont(), line.getText());
			subboxHeight += fm.stringHeight();
		}
		
		return subboxHeight;
	}

	public int getTemplateParameterBoxWidth() {
		
		if (typeParameterList == null || typeParameterList.size() == 0) {
			return 0;
		}
		
		return subboxWidth;
	}
    
    public ArrayList<Text> getTypeParameterList() {
		return typeParameterList;
	}
    
    @Override
	public int getWidth() {
		return super.getWidth() + getTemplateParameterBoxWidth() / 2;
	}

    public boolean isShadowEnabled() {
        return shadowEnabled;
    }
    
    public void setRoundedCorner(int roundedCorner) {
        this.roundedCorner = roundedCorner;
    }

	public void setShadowEnabled(boolean shadowEnabled) {
        this.shadowEnabled = shadowEnabled;
    }
}
