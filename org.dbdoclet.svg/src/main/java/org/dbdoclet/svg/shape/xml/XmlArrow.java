/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape.xml;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Polygon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.svg.Cell;
import org.dbdoclet.svg.SvgFontMetrics;
import org.dbdoclet.svg.SvgServices;
import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.Shape;
import org.w3c.dom.Document;

public class XmlArrow extends Arrow {

	private static Log logger = LogFactory.getLog(Arrow.class);

	public XmlArrow(Document doc, String id, Shape from, Shape to) {

		super(id, from, to);

		if (doc == null) {
			throw new IllegalArgumentException(
					"The argument doc must not be null!");
		}

		setDocument(doc);

		setFillEnabled(true);
		setStyle(STYLE_SOLID);
	}

	public void draw(int xpos1, int ypos1, int xpos2, int ypos2) {

		if (getDirectMode() == true) {
			drawDirect(xpos1, ypos1, xpos2, ypos2);
		} else {
			drawRightAngled(xpos1, ypos1, xpos2, ypos2);
		}
	}

	public void drawRightAngled(int xpos1, int ypos1, int xpos2, int ypos2) {

		Document doc = getDocument();

		int ymid = 0;

		// Von links oben nach rechts unten
		if (ypos1 < ypos2 && xpos1 < xpos2) {
			drawRightAngledTopLeft2BottomRight(xpos1, ypos1, xpos2, ypos2);
			return;
		}

		// Von links unten nach rechts oben
		if (ypos1 > ypos2 && xpos1 < xpos2) {
			drawRightAngledBottomLeft2TopRight(xpos1, ypos1, xpos2, ypos2);
			return;
		}

		// Von rechts unten nach links oben
		if (ypos1 > ypos2 && xpos1 > xpos2) {
			drawRightAngledBottomRight2TopLeft(xpos1, ypos1, xpos2, ypos2);
			return;
		}

		// Von unten nach oben
		if (ypos2 < ypos1) {

			ymid = ypos2 + ((ypos1 - ypos2) * 2 / 3);

			int[] xlist = new int[4];
			int[] ylist = new int[4];

			xlist[0] = xpos1;
			xlist[1] = xpos1;
			xlist[2] = xpos2;
			xlist[3] = xpos2;

			ylist[0] = ypos1;
			ylist[1] = ymid;
			ylist[2] = ymid;
			ylist[3] = ypos2;

			Point neck = drawArrowHead(xlist[2], ylist[2], xlist[3], ylist[3]);

			xlist[3] = neck.x;
			ylist[3] = neck.y;

			SvgServices.drawPolyline(doc, xlist, ylist, 4, Color.black,
					getStyle());
		}

		// Von oben nach unten
		if (ypos2 > ypos1) {

			ymid = ypos1 + ((ypos2 - ypos1) * 1 / 3);

			int[] xlist = new int[4];
			int[] ylist = new int[4];

			xlist[0] = xpos1;
			xlist[1] = xpos1;
			xlist[2] = xpos2;
			xlist[3] = xpos2;

			ylist[0] = ypos1;
			ylist[1] = ymid;
			ylist[2] = ymid;
			ylist[3] = ypos2;

			Point neck = drawArrowHead(xlist[2], ylist[2], xlist[3], ylist[3]);

			xlist[3] = neck.x;
			ylist[3] = neck.y;

			SvgServices.drawPolyline(doc, xlist, ylist, 4, Color.black,
					getStyle());
		}

		// Von links nach rechts
		if (ypos1 == ypos2 && xpos1 < xpos2) {
			drawLeftToRightArrow(xpos1, ypos1, xpos2, ypos2, doc);
		}
	}

	private void drawLeftToRightArrow(int xpos1, int ypos1, int xpos2,
			int ypos2, Document doc) {

		Point neck = drawArrowHead(xpos1, ypos1, xpos2, ypos2);
		XmlLine line = new XmlLine(doc, xpos1, ypos1, neck.x, neck.y);
		line.draw();

		if (hasText()) {

			Font font = getFont();
			SvgFontMetrics fontMetrics = new SvgFontMetrics(font, getText());

			int indent = fontMetrics.stringWidth() / 2;

			XmlText text = new XmlText(doc, xpos1 + (((xpos2 - xpos1) * 3) / 4) - indent, ypos1 - fontMetrics.stringHeight() - 5, getText());
			text.setFont(font);
			text.draw();
		}
	}

	public void drawDirect(int xpos1, int ypos1, int xpos2, int ypos2) {

		logger.debug("Zeichne Pfeil von (" + xpos1 + "," + ypos1 + ") nach ("
				+ xpos2 + "," + ypos2 + ")");

		// Point neck = drawArrowHead(xpos1, ypos1, xpos2, ypos2);
		drawArrowHead(xpos1, ypos1, xpos2, ypos2);

		if (getStyle() == STYLE_DASHED) {
			// g2d.setStroke(new BasicStroke(1.0F, BasicStroke.CAP_SQUARE,
			// BasicStroke.JOIN_MITER, 10.0F, new float[] { 4.0F, 4.0F}, 2.0F));
		} else {
			// g2d.setStroke(new BasicStroke());
		}

		// g2d.drawLine(xpos1, ypos1, neck.x, neck.y);

	}

	private void drawRightAngledTopLeft2BottomRight(int xpos1, int ypos1,
			int xpos2, int ypos2) {

		Cell fromCell = getFrom().getCell();
		Cell toCell = getTo().getCell();

		int startAnchor = getStartAnchor();
		int endAnchor = getEndAnchor();

		if (startAnchor == ANCHOR_NONE) {
			startAnchor = ANCHOR_SOUTH;
		}

		if (endAnchor == ANCHOR_NONE) {
			endAnchor = ANCHOR_NORTH;
		}

		if (startAnchor == ANCHOR_EAST && endAnchor == ANCHOR_NORTH) {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 1);
			return;
		}

		int rowDistance = toCell.getRow() - fromCell.getRow();

		if (rowDistance > 1) {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 4);
		} else {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 2);
		}
	}

	private void drawRightAngledBottomLeft2TopRight(int xpos1, int ypos1,
			int xpos2, int ypos2) {

		Cell fromCell = getFrom().getCell();
		Cell toCell = getTo().getCell();

		int startAnchor = getStartAnchor();
		int endAnchor = getEndAnchor();

		if (startAnchor == ANCHOR_NONE) {
			startAnchor = ANCHOR_NORTH;
		}

		if (endAnchor == ANCHOR_NONE) {
			endAnchor = ANCHOR_SOUTH;
		}

		if (startAnchor == ANCHOR_EAST && endAnchor == ANCHOR_SOUTH) {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 1);
			return;
		}

		int rowDistance = fromCell.getRow() - toCell.getRow();

		if (rowDistance > 1) {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 4);
		} else {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 2);
		}
	}

	private void drawRightAngledBottomRight2TopLeft(int xpos1, int ypos1,
			int xpos2, int ypos2) {

		Cell fromCell = getFrom().getCell();
		Cell toCell = getTo().getCell();

		int startAnchor = getStartAnchor();
		int endAnchor = getEndAnchor();

		if (startAnchor == ANCHOR_NONE) {
			startAnchor = ANCHOR_NORTH;
		}

		if (endAnchor == ANCHOR_NONE) {
			endAnchor = ANCHOR_SOUTH;
		}

		if (startAnchor == ANCHOR_WEST && endAnchor == ANCHOR_SOUTH) {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 1);
			return;
		}

		int rowDistance = fromCell.getRow() - toCell.getRow();

		if (rowDistance > 1) {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 4);
		} else {
			drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, 2);
		}
	}

	private void drawRightAngledArrow(int xpos1, int ypos1, int xpos2,
			int ypos2, int angleCount) {

		drawRightAngledArrow(xpos1, ypos1, xpos2, ypos2, angleCount, 0);
	}

	private void drawRightAngledArrow(int xpos1, int ypos1, int xpos2,
			int ypos2, int angleCount, int yoffset) {

		XmlText text;

		Document doc = getDocument();
		Shape fromShape = getFrom();
		Shape toShape = getTo();

		if (angleCount == 4) {

			int ymid1 = 0;
			int ymid2 = 0;
			int xmid1 = 0;

			// Von oben nach unten
			if (ypos2 > ypos1) {
				ymid1 = fromShape.getCell().getBottomBound();
				ymid2 = toShape.getCell().getTopBound();
			} else {
				ymid1 = fromShape.getCell().getTopBound();
				ymid2 = toShape.getCell().getBottomBound();
			}

			int[] xlist = new int[6];
			int[] ylist = new int[6];

			xlist[4] = xpos2;
			xlist[5] = xpos2;

			ylist[4] = ymid2;
			ylist[5] = ypos2;

			Point neck = drawArrowHead(xlist[4], ylist[4], xlist[5], ylist[5]);

			if (ypos2 > ypos1) {
				ymid2 = neck.y - getLinePadding();
			} else {
				ymid2 = neck.y + getLinePadding();
			}

			if (xpos1 < xpos2) {
				xmid1 = fromShape.getCell().getRightBound();
			} else {
				xmid1 = fromShape.getCell().getLeftBound();
			}

			xlist[0] = xpos1;
			xlist[1] = xpos1;
			xlist[2] = xmid1;
			xlist[3] = xmid1;
			xlist[4] = xpos2;
			xlist[5] = neck.x;

			ylist[0] = ypos1;
			ylist[1] = ymid1;
			ylist[2] = ymid1;
			ylist[3] = ymid2;
			ylist[4] = ymid2;
			ylist[5] = neck.y;

			SvgServices.drawPolyline(doc, xlist, ylist, 6, Color.black,
					getStyle());

			if (hasText()) {

				// Von oben nach unten
				Font font = getFont();
				SvgFontMetrics fontMetrics = new SvgFontMetrics(font, getText());
				int indent = fontMetrics.stringWidth() / 2;

				if (ypos2 > ypos1) {
					text = new XmlText(doc, xlist[3] - indent, ylist[3]
							+ fontMetrics.stringHeight(), getText());
				} else {
					text = new XmlText(doc, xlist[3] - indent, ylist[3]
							- (((int) fontMetrics.getDescent()) + 1), getText());
				}

				text.setFont(font);
				text.draw();
			}

			return;
		}

		if (angleCount == 2) {

			int ymid = 0;

			if (ypos2 > ypos1) {
				ymid = fromShape.getCell().getBottomBound();
			} else {
				ymid = fromShape.getCell().getTopBound();
			}

			int[] xlist = new int[4];
			int[] ylist = new int[4];

			xlist[0] = xpos1;
			xlist[1] = xpos1;
			xlist[2] = xpos2;
			xlist[3] = xpos2;

			ylist[0] = ypos1;
			ylist[1] = ymid;
			ylist[2] = ymid;
			ylist[3] = ypos2;

			Point neck = drawArrowHead(xlist[2], ylist[2], xlist[3], ylist[3]);

			xlist[3] = neck.x;
			ylist[3] = neck.y;

			SvgServices.drawPolyline(doc, xlist, ylist, 4, Color.black,
					getStyle());

			if (hasText()) {

				// Von oben nach unten
				Font font = getFont();
				SvgFontMetrics fontMetrics = new SvgFontMetrics(font, getText());
				int indent = fontMetrics.stringWidth() / 2;

				if (ypos2 > ypos1) {
					text = new XmlText(doc, xlist[1] - indent, ylist[1]
							+ fontMetrics.stringHeight(), getText());
				} else {
					text = new XmlText(doc, xlist[1] - indent, ylist[1]
							- (((int) fontMetrics.getDescent()) + 1), getText());
				}

				text.setFont(getFont());
				text.draw();
			}

			return;
		}

		int[] xlist = new int[3];
		int[] ylist = new int[3];

		xlist[0] = xpos1;
		xlist[1] = xpos2;
		xlist[2] = xpos2;

		ylist[0] = ypos1;
		ylist[1] = ypos1;
		ylist[2] = ypos2;

		Point neck = drawArrowHead(xlist[1], ylist[1], xlist[2], ylist[2]);

		xlist[2] = neck.x;
		ylist[2] = neck.y;

		SvgServices.drawPolyline(doc, xlist, ylist, 3, Color.black, getStyle());
	}

	private Point drawArrowHead(int xpos1, int ypos1, int xpos2, int ypos2) {

		if (isEndArrowHeadEnabled() == false) {
			return new Point(xpos2, ypos2);
		}

		Document doc = getDocument();

		double a = Math.abs(xpos2 - xpos1);
		// logger.debug("a = " + a);
		double b = Math.abs(ypos2 - ypos1);
		// logger.debug("b = " + b);
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		// logger.debug("c = " + c);

		double sin1 = 0;
		double cos1 = 1;

		if (c != 0) {
			sin1 = b / c;
			// logger.debug("sin1 = " + sin1);
			cos1 = a / c;
			// logger.debug("cos1 = " + cos1);
		}

		double c0 = arrowHeadLength;
		double a0 = cos1 * c0;
		// logger.debug("a0 = " + a0);
		double b0 = sin1 * c0;
		// logger.debug("b0 = " + b0);

		double x0;
		double y0;

		if (xpos2 > xpos1) {
			x0 = xpos2 - a0;
		} else {
			x0 = xpos2 + a0;
		}

		if (ypos2 > ypos1) {
			y0 = ypos2 - b0;
		} else {
			y0 = ypos2 + b0;
		}

		// logger.debug("x0 = " + x0 + ", y0 = " + y0);

		double cl = arrowHeadWidth;
		double al = cos1 * cl;
		double bl = sin1 * cl;

		// logger.debug("al = " + al + ", bl = " + bl);

		double xl, yl, xr, yr;

		if (xpos2 > xpos1) {
			xl = x0 - bl;
			xr = x0 + bl;
		} else {
			xl = x0 + bl;
			xr = x0 - bl;
		}

		if (ypos2 > ypos1) {
			yl = y0 + al;
			yr = y0 - al;
		} else {
			yl = y0 - al;
			yr = y0 + al;
		}

		// logger.debug("xl = " + xl + ", yl = " + yl);
		// logger.debug("xr = " + xr + ", yr = " + yr);

		Polygon p = new Polygon();
		p.addPoint(xpos2, ypos2);
		p.addPoint((int) xl, (int) yl);
		p.addPoint((int) xr, (int) yr);

		XmlPolygon polygon = new XmlPolygon(doc, p);

		if (isFillEnabled() == true) {
			polygon.setFill(Color.black);
		}

		polygon.draw();

		return new Point((int) x0, (int) y0);
	}
}
