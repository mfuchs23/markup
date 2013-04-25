package org.dbdoclet.svg.shape.xml;

import java.awt.Font;
import java.util.Iterator;

import org.dbdoclet.svg.Area;
import org.dbdoclet.svg.SvgFontMetrics;
import org.dbdoclet.svg.shape.Text;
import org.dbdoclet.svg.shape.TextCircle;
import org.w3c.dom.Document;

public class XmlTextCircle extends TextCircle {

    private Document doc;
    private boolean shadowEnabled = true;

    public XmlTextCircle(Document doc, String id, int row, int column) {

	super(id, row, column);
	this.doc = doc;
    }

    public void draw(int x, int y) {

	int radius = 17;

	Area area = new Area();
	area.addCoords(x, y);
	area.addCoords(x + (2 * radius), y + (2 * radius));
	area.setName(getName());
	setArea(area);

	XmlCircle circle = new XmlCircle(doc, x + radius, y + radius, radius);
	circle.setGradient("grad1");
	circle.setShadowEnabled(shadowEnabled);
	circle.draw();

	int xpos = x + (radius * 2) + 5;
	int ypos = y + radius + 4;

	Iterator<Text> iterator = getLineList().iterator();

	while (iterator.hasNext()) {

	    Text line = (Text) iterator.next();
	    Font font = line.getFont();

	    SvgFontMetrics fm;

	    if (font != null) {
		fm = new SvgFontMetrics(font, line.getText());
	    } else {
		fm = new SvgFontMetrics(getDefaultFont(), line.getText());
	    }

	    XmlText text = new XmlText(doc, xpos, ypos, line.getText());
	    text.setFont(line.getFont());
	    text.setFill(getTextColor());
	    text.draw();

	    // SvgServices.drawString(doc, xpos, ypos, line.getText(),
	    // line.getFont());

	    ypos += fm.getDescent() + fm.getLeading();
	}
    }
}
