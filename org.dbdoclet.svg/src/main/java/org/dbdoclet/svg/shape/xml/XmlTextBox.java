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
import java.util.Iterator;

import org.dbdoclet.svg.Area;
import org.dbdoclet.svg.SvgFontMetrics;
import org.dbdoclet.svg.shape.Text;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextSeparator;
import org.w3c.dom.Document;

public class XmlTextBox extends TextBox {

	public XmlTextBox(Document doc, String id, int x, int y) {

		super(id, x, y);

		if (doc == null) {
			throw new IllegalArgumentException(
					"The argument doc must not be null!");
		}

		setDocument(doc);
	}

	public void draw(int x, int y) {

		Document doc = getDocument();

		int width = getWidth();
		int height = getHeight();
		int roundedCorner = getRoundedCorner();

		Area area = new Area();
		area.addCoords(x, y);
		area.addCoords(x + width, y + height);
		area.setName(getName());
		setArea(area);

		XmlRectangle rect = new XmlRectangle(doc, x, y, width, height);
		rect.setFill(getBackgroundColor());
		rect.setStroke(getStrokeColor());
		rect.setShadowEnabled(isShadowEnabled());

		if (roundedCorner > 0) {
			rect.setRx(roundedCorner);
			rect.setRy(roundedCorner);
		}

		rect.draw();

		int ypos = y + getTopPadding();
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
				XmlLine separator = new XmlLine(doc, xpos, ypos, xpos + width,
						ypos);
				separator.setStrokeWidth(1);
				separator.draw();
				ypos += fm.stringHeight() / 2;

			} else {

				ypos += fm.getAscent();
				xpos = x + ((width - lineWidth) / 2);

				XmlText text = new XmlText(doc, xpos, ypos, line.getText());
				text.setFont(line.getFont());
				text.setFill(getTextColor());
				text.draw();
				ypos += fm.getDescent() + fm.getLeading();
			}
		}
	}
}
