/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextUnit;

public class GridDiagramCreator {

    private SvgCanvas canvas;
    private String fontFamily = "SansSerif";
    private int fontSize = 12;
    private Font sansSerif;
    private Font sansSerifBold;
    private ShapeFactory shapeFactory;

    public GridDiagramCreator() {

	canvas = new SvgXmlCanvas();
	canvas.setCellPadding(20);

	shapeFactory = new ShapeXmlFactory(canvas.getDocument());

	sansSerif = new Font(fontFamily, Font.PLAIN, fontSize);
	sansSerifBold = new Font(fontFamily, Font.BOLD, fontSize);
    }

    public static void main(String[] args) {

	try {

	    // GridDiagramCreator ucdc = new GridDiagramCreator();

	} catch (Throwable oops) {

	    oops.printStackTrace();
	}
    }

    public static void usage() {

	System.out.println("Syntax: ");
    }

    public Shape addCell(int row, int column, String title, String type) {

	TextBox tbox = shapeFactory.createTextBox("c", row, column);
	tbox.setMinTextWidth(50);
	
	TextUnit lineType = new TextUnit("«" + type + "»", sansSerif);
	
	TextUnit lineTitle = new TextUnit(title, sansSerifBold);

	tbox.addText(lineType);
	tbox.addText(lineTitle);
	tbox.setShadowEnabled(true);
	canvas.addShape(tbox);

	return tbox;
    }

    public void addConnection(Shape from, Shape to) {

	Arrow arrow = shapeFactory.createArrow("a", from, to);
	arrow.setDirectMode(false);
	arrow.setEndArrowHeadEnabled(false);
	canvas.addArrow(arrow);
    }

    public void drawImage() {
	canvas.drawImage();
    }

    public void save(File file) throws IOException, SvgException {

	if (file == null) {
	    throw new IllegalArgumentException("The argument file must not be null!");
	}

	canvas.save(file);
    }

    public void saveAsPng(File file) throws IOException, SvgException {

	if (file == null) {
	    throw new IllegalArgumentException("The argument file must not be null!");
	}

	canvas.saveAsPng(file);
    }

    public void scaleToWidth(int width) {
	canvas.scaleToWidth(width);
    }

}
