package org.dbdoclet.svg.shape;

import java.util.ArrayList;

import org.dbdoclet.svg.SvgFontMetrics;

public abstract class TextShape extends Shape {

    protected int textWidth = 0;
    protected int textHeight = 0;
    protected int minTextWidth = 100;
	protected ArrayList<Text> lineList;
    private int bottomPadding = 10;
    private int leftPadding = 10;
    private int rightPadding = 10;
    private int topPadding = 10;
    
    public TextShape(String id, int row, int column) {
    	
    	super(id, row, column);
    	        
		textHeight = topPadding + bottomPadding;
        textWidth = leftPadding + rightPadding;
        
        lineList = new ArrayList<Text>();
    }

	public void addText(Text text) {
    
        if (text == null) {
            throw new IllegalArgumentException("The argument text must not be null!");
        }
    
        SvgFontMetrics fm = new SvgFontMetrics(text.getFont(), text.getText());
        int width = text.getIndent() + fm.stringWidth();
        
        if (width > textWidth) {
            textWidth = width;
        }
    
        textHeight += fm.stringHeight();
        lineList.add(text);
    }

	public int getBottomPadding() {
		return bottomPadding;
	}

	@Override
    public int getHeight() {
        return textHeight;
    }

	public int getLeftPadding() {
		return leftPadding;
	}

	public ArrayList<Text> getLineList() {
        return lineList;
    }

	public int getMinTextWidth() {
        return minTextWidth;
    }
    
    public int getRightPadding() {
		return rightPadding;
	}

    public int getTextWidth() {
    
        if (textWidth < minTextWidth) {
            textWidth = minTextWidth;
        }
    
        return textWidth;
    }

    public int getTopPadding() {
        return topPadding;
    }

    @Override
    public int getWidth() {
        return getTextWidth() + getLeftPadding() + getRightPadding();
    }

    public void setBottomPadding(int bottomPadding) {
		this.bottomPadding = bottomPadding;
	}

    public void setLeftPadding(int leftPadding) {
		this.leftPadding = leftPadding;
	}

    public void setMinTextWidth(int minTextWidth) {
        this.minTextWidth = minTextWidth;
    }

    public void setRightPadding(int rightPadding) {
		this.rightPadding = rightPadding;
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
