/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.xml;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.svg.Area;
import org.dbdoclet.svg.SvgFontMetrics;
import org.dbdoclet.svg.shape.ClassBox;
import org.dbdoclet.svg.shape.Text;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextSeparator;
import org.w3c.dom.Document;

public class XmlClassBox extends ClassBox {

	private static Log logger = LogFactory.getLog(TextBox.class);
	private XmlRectangle paramRect;
	private XmlRectangle classRect;
	@SuppressWarnings("unused")
	private int drawX;
	private int drawY;

	public XmlClassBox(Document doc, String id, int x, int y) {

		super(id, x, y);

		if (doc == null) {
			throw new IllegalArgumentException(
					"The argument doc must not be null!");
		}

		setDocument(doc);
	}

	public void draw(int x, int y) {

		drawX = x;
		drawY = y;
		
		Document doc = getDocument();

		int width = getWidth();
		int height = getHeight();
		int roundedCorner = getRoundedCorner();

		logger.debug("Zeichne Textbox an Position: " + x + ", " + y
				+ ", Breite: " + width + ", Höhe: " + height);

		Area area = new Area();
		area.addCoords(x, y);
		area.addCoords(x + width, y + height);
		area.setName(getName());
		setArea(area);

		int classBoxWidth = getTextWidth() + getLeftPadding() + getRightPadding();
		int classBoxHeight = height - getTemplateParameterBoxHeight();
		int classBoxYpos = y + getTemplateParameterBoxHeight();
		
		classRect = new XmlRectangle(doc, x, classBoxYpos, classBoxWidth,
				classBoxHeight);
		classRect.setFill(getBackgroundColor());
		classRect.setStroke(getStrokeColor());
		classRect.setShadowEnabled(isShadowEnabled());

		if (roundedCorner > 0) {
			classRect.setRx(roundedCorner);
			classRect.setRy(roundedCorner);
		}

		classRect.draw();

		int ypos = classBoxYpos + getTopPadding();
		int xpos;
		int lineWidth;

		Iterator<Text> iterator = getLineList().iterator();

		Font defaultFont = getDefaultFont();

		while (iterator.hasNext()) {

			Text line = (Text) iterator.next();
			Font font = line.getFont();

			SvgFontMetrics fm;

			if (font != null) {
				fm = new SvgFontMetrics(font, line.getText());
			} else {
				fm = new SvgFontMetrics(defaultFont, line.getText());
			}

			lineWidth = fm.stringWidth();

			if (line instanceof TextSeparator) {

				ypos += fm.stringHeight() / 2;
				xpos = x;
				XmlLine separator = new XmlLine(doc, xpos, ypos, xpos + classBoxWidth,
						ypos);
				separator.setStrokeWidth(1);
				separator.draw();
				ypos += fm.stringHeight() / 2;

			} else {

				ypos += fm.getAscent();
				
				if (line.getFont().isBold() || line.getText().startsWith(STEREOTYPE_LEFT)) {
					xpos = x + ((classBoxWidth - lineWidth) / 2);
				} else {
					xpos = x + getLeftPadding() + line.getIndent();
				}
				
				XmlText text = new XmlText(doc, xpos, ypos, line.getText());
				text.setFont(line.getFont());
				text.setFill(getTextColor());
				text.draw();
				ypos += fm.getDescent() + fm.getLeading();
			}
		}

		if (getTypeParameterList() != null) {
			drawTypeParameterBox(doc, x, y, width, height, defaultFont);
		}
	}

	private void drawTypeParameterBox(Document doc, int x, int y, int width,
			int height, Font defaultFont) {

		int ypos;
		int xpos;

		ArrayList<Text> typeParameterList = getTypeParameterList();

		if (typeParameterList == null || typeParameterList.size() == 0) {
			return;
		}

		String maxLine = "";

		for (Text typeParameter : typeParameterList) {
			if (typeParameter.getText().length() > maxLine.length()) {
				maxLine = typeParameter.getText();
			}
		}

		int subboxWidth = getTemplateParameterBoxWidth();
		int subboxHeight = getTemplateParameterBoxHeight();
		int subboxXpos = x + width - getTemplateParameterBoxWidth();
		int subboxYpos = y + getTopPadding();

		if (getTopPadding() >= subboxHeight / 2) {
			subboxYpos = y + subboxHeight / 2;
		}
		
		paramRect = new XmlRectangle(doc, subboxXpos, subboxYpos, subboxWidth,
				subboxHeight);
		paramRect.setFill(getBackgroundColor());
		paramRect.setStroke(getStrokeColor());
		paramRect.setStrokeDashArray("5 3");
		paramRect.setShadowEnabled(isShadowEnabled());
		paramRect.draw();

		ypos = subboxYpos;
		xpos = subboxXpos + getLeftPadding();

		for (Text line : typeParameterList) {

			SvgFontMetrics fm = new SvgFontMetrics(line.getFont(), line.getText());
			ypos += fm.getAscent();
			XmlText text = new XmlText(doc, xpos, ypos, line.getText());
			text.setFont(line.getFont());
			text.setFill(getTextColor());
			text.draw();
		}

	}

	@Override
	public int getTopDistance(int xpos) {
		
		if (paramRect == null || classRect == null) {
			return super.getTopDistance(xpos);
		}
		
		int x = paramRect.getX();
	
		if (xpos > x) {
			return paramRect.getY() - drawY;
		} 
		
		return classRect.getY() - drawY;
	}
}
