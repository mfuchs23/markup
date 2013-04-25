package org.dbdoclet.svg.shape;

import java.util.ArrayList;

import org.dbdoclet.svg.SvgFontMetrics;

public abstract class TextShape extends Shape {

    protected int textWidth = 0;

    protected int textHeight = 0;

    protected int minTextWidth = 100;
    protected ArrayList<Text> lineList;
    protected int bottomPadding = 10;
    protected int leftPadding = 10;
    protected int rightPadding = 10;
    protected int topPadding = 10;
    
    public TextShape(String id, int row, int column) {
	super(id, row, column);
    }
    public void addText(Text text) {
    
        if (text == null) {
            throw new IllegalArgumentException("The argument text must not be null!");
        }
    
        SvgFontMetrics fm = new SvgFontMetrics(text.getFont(), text.getText());
        int width = leftPadding + fm.stringWidth() + rightPadding;
        
        if (width > textWidth) {
            textWidth = width;
        }
    
        textHeight += fm.stringHeight();
        lineList.add(text);
    }

    public int getHeight() {
        return textHeight;
    }

    public ArrayList<Text> getLineList() {
        return lineList;
    }

    public int getMinTextWidth() {
        return minTextWidth;
    }

    public int getTopPadding() {
        return topPadding;
    }

    public int getWidth() {
    
        if (textWidth < minTextWidth) {
            textWidth = minTextWidth;
        }
    
        return textWidth;
    }

    public void setMinTextWidth(int minTextWidth) {
        this.minTextWidth = minTextWidth;
    }

    public void setText(Text text) {
    
        lineList.clear();
        textHeight = topPadding + bottomPadding;
        textWidth = 0;
        
        addText(text);
    }

    public void setTopPadding(int topPadding) {
        this.topPadding = topPadding;
    }
}
