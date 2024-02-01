/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.ClassBox;
import org.dbdoclet.svg.shape.Connector;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextSeparator;
import org.dbdoclet.svg.shape.TextUnit;

public class UmlClassDiagramCreator {

	private static final int MAX_PARAMETER_BEFORE_SPLIT = 4;
	private static final int MAX_METHOD_LENGTH = 80;
	private SvgCanvas canvas;
	private boolean directArrowMode = false;
	private String fontFamily = "SansSerif";
	private int fontSize = 8;
	private Color interfaceBackgroundColor = Color.orange;
	private Color interfaceTextColor = Color.black;
	private Color interfaceBorderColor = Color.black;
	private Font sansSerif;
	private Font sansSerifBold;
	private ShapeFactory shapeFactory;

	/**
	 * Die Methode <code>main</code> erstellt zu Testzwecken ein kleines
	 * Klassendiagramm.
	 * 
	 * @param args
	 * @author Michael Fuchs
	 */
	public static void main(String[] args) {

		try {

			UmlClassDiagramCreator ucdc = new UmlClassDiagramCreator();
			Shape i_0_2 = ucdc.addClassBox(0, 2, "java.lang.Serializable",
					"Interface");
			Shape c1 = ucdc.addClassBox(0, 3, "java.lang.Object");
			Shape i1 = ucdc.addClassBox(0, 4, "java.lang.Serializable",
					"Interface");
			Shape c2 = ucdc.addClassBox(1, 3,
					"org.dbdoclet.svg.extralongpackage.shapeShape");
			Shape i2 = ucdc.addClassBox(1, 0, "Serializable", "Interface");
			Shape i3 = ucdc.addClassBox(1, 1, "Action", "Interface");
			Shape i4 = ucdc.addClassBox(1, 2, "Drinkable", "Interface");
			Shape c3 = ucdc
					.addClassBox(2, 3, "org.dbdoclet.svg.shape.ClassBox");
			Shape c4 = ucdc.addClassBox(3, 3,
					"org.dbdoclet.svg.shape.SecretClassBox");
			Shape i5 = ucdc.addClassBox(1, 4, "Singable", "Interface");
			Shape i6 = ucdc.addClassBox(1, 5, "Sortable", "Interface");
			Shape i7 = ucdc.addClassBox(1, 6, "ActionListener", "Interface");
			Shape i8 = ucdc.addClassBox(1, 7, "ActionListener", "Interface");
			Shape i9 = ucdc.addClassBox(1, 8, "ActionListener", "Interface");
			ucdc.addInheritance(c4, c3);
			ucdc.addInheritance(c3, c2);
			ucdc.addInheritance(c2, c1);
			ucdc.addRealization(c3, i_0_2);
			ucdc.addRealization(c3, i1);
			ucdc.addRealization(c3, i2);
			ucdc.addRealization(c3, i3);
			ucdc.addRealization(c3, i4);
			ucdc.addRealization(c3, i5);
			ucdc.addRealization(c3, i6);
			ucdc.addRealization(c3, i7);
			ucdc.addRealization(c3, i8);
			ucdc.addRealization(c3, i9);
			// ucdc.scaleToWidth(160);
			ucdc.drawImage();
			ucdc.save(new File("/home/mfuchs/tmp/ucdc.svg"));
			ucdc.saveAsPng(new File("/home/mfuchs/tmp/ucdc.png"));

		} catch (Throwable oops) {

			oops.printStackTrace();
		}
	}

	public static void usage() {

		System.out.println("Syntax: ");
	}

	/**
	 * Die Klasse <code>UmlClassDiagramCreator</code> dient der Erstellung von
	 * UML Klassendiagrammen.
	 * 
	 * Das Diagramm wird in Zeilen und Spalten aufgeteilt. Jeweils eine Klasse
	 * oder Schnittstelle wird in einer Zelle plaziert. Pfeile (Connector)
	 * werden dazu verwendet um Zellen zu verbinden.
	 */
	public UmlClassDiagramCreator() {

		canvas = new SvgXmlCanvas();
		canvas.setCellPadding(20);

		shapeFactory = new ShapeXmlFactory(canvas.getDocument());

		sansSerif = new Font(fontFamily, Font.PLAIN, getFontSize());
		sansSerifBold = new Font(fontFamily, Font.BOLD, getFontSize());
	}

	public void addAttribute(ClassBox classBox, String string) {
		classBox.addText(new TextUnit(string, sansSerif));
	}

	/**
	 * Die Methode <code>addClassBox</code> fügt ein neue Klasse in das Diagramm
	 * ein.
	 * 
	 * @param row
	 * @param column
	 * @param className
	 */
	public ClassBox addClassBox(int row, int column, String className) {

		ClassBox tbox = shapeFactory.createClassBox("c", row, column);
		TextUnit lineClassName = new TextUnit(className, sansSerifBold);
		tbox.addText(lineClassName);
		tbox.setShadowEnabled(true);
		canvas.addShape(tbox);

		return tbox;
	}

	public ClassBox addClassBox(int row, int column, String className,
			String stereotype) {

		ClassBox tbox = shapeFactory.createClassBox("c", row, column);

		if (stereotype.equalsIgnoreCase("interface")) {
			tbox.setTextColor(interfaceTextColor);
			tbox.setBorderColor(interfaceBorderColor);
			tbox.setBackgroundColor(interfaceBackgroundColor);
		}

		TextUnit lineStereotype = new TextUnit(ClassBox.STEREOTYPE_LEFT
				+ stereotype + ClassBox.STEREOTYPE_RIGHT, sansSerif);
		TextUnit lineClassName = new TextUnit(className, sansSerifBold);

		tbox.addText(lineStereotype);
		tbox.addText(lineClassName);
		tbox.setShadowEnabled(true);
		canvas.addShape(tbox);

		return tbox;
	}

	public void addInheritance(Shape from, Shape to) {

		Arrow arrow = shapeFactory.createArrow("i", from, to);
		arrow.setFillEnabled(false);
		arrow.setDirectMode(directArrowMode);
		canvas.addArrow(arrow);
	}

	public void addLine(ClassBox classBox) {
		classBox.addText(new TextSeparator());
	}

	public void addMethod(ClassBox classBox, String method) {
		
		String[] tokens = method.split("\n");
		
		if (tokens.length < MAX_PARAMETER_BEFORE_SPLIT && method.length() < MAX_METHOD_LENGTH) {
			
			method = method.replace('\n', ' ');
			classBox.addText(new TextUnit(method, sansSerif));
			
		} else {
			
			int indentWidth = computeParameterIndentWidth(method);
			
			int index = method.indexOf('\n');
			if (index < 0) {
				classBox.addText(new TextUnit(method, sansSerif));
				return;
			}
			
			String methodName = method.substring(0, index + 1);
			classBox.addText(new TextUnit(methodName.trim(), sansSerif));
			
			int indexStart = index + 1;
			int indexEnd = method.indexOf('\n', indexStart);
			
			while (indexEnd != -1) {
				
				TextUnit textUnit = new TextUnit(method.substring(indexStart, indexEnd + 1).trim(), sansSerif);
				textUnit.setIndent(indentWidth);
				classBox.addText(textUnit);
				
				indexStart = indexEnd + 1;
				indexEnd = method.indexOf('\n', indexStart);
			}
			
			TextUnit textUnit = new TextUnit(method.substring(indexStart), sansSerif);
			textUnit.setIndent(indentWidth);
			classBox.addText(textUnit);
		}
	}

	private int computeParameterIndentWidth(String method) {
		
		int indexWidth = 0;
		int index = method.indexOf('(');
		
		if (index > 0) {
			
			String methodName = method.substring(0, index + 1);
			SvgFontMetrics fm = new SvgFontMetrics(sansSerif, methodName.trim());
			return fm.stringWidth();
		}
		
		return indexWidth;
	}

	public ClassBox addParameterizedClassBox(int row, int column,
			String className, ArrayList<String> templateParameters) {

		ClassBox tbox = shapeFactory.createClassBox("c", row, column);
		TextUnit lineClassName = new TextUnit(className, sansSerifBold);
		tbox.addText(lineClassName);
		tbox.setShadowEnabled(true);

		for (String templateParameter : templateParameters) {
			tbox.addTemplateParameter(new TextUnit(templateParameter, sansSerif));
		}

		canvas.addShape(tbox);

		return tbox;
	}

	public void addRealization(Shape from, Shape to) {

		Arrow arrow = shapeFactory.createArrow("i", from, to);
		arrow.setFillEnabled(false);
		arrow.setStyle(Connector.STYLE_DASHED);
		arrow.setDirectMode(directArrowMode);
		canvas.addArrow(arrow);
	}

	public void drawImage() {
		canvas.drawImage();
	}

	public int getFontSize() {
		return fontSize;
	}

	public Color getInterfaceBackgroundColor() {
		return interfaceBackgroundColor;
	}

	public Color getInterfaceBorderColor() {
		return interfaceBorderColor;
	}

	public Color getInterfaceTextColor() {
		return interfaceTextColor;
	}

	public void save(File file) throws IOException, SvgException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		canvas.save(file);
	}

	public void saveAsJpeg(File file) throws IOException, SvgException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		canvas.saveAsJpeg(file);
	}

	public void saveAsPng(File file) throws IOException, SvgException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		canvas.saveAsPng(file);
	}

	public void setMaxWidth(int width) {
		canvas.setMaxWidth(width);
	}

	public void setMaxHeight(int height) {
		canvas.setMaxHeight(height);
	}

	public void setFont(String fontFamily, int fontSize) {

		this.fontSize = fontSize;
		this.fontFamily = fontFamily;
		
		sansSerif = new Font(fontFamily, Font.PLAIN, fontSize);
		sansSerifBold = new Font(fontFamily, Font.BOLD, fontSize);
	}

	public void setFontSize(int fontSize) {

		this.fontSize = fontSize;

		sansSerif = new Font(fontFamily, Font.PLAIN, fontSize);
		sansSerifBold = new Font(fontFamily, Font.BOLD, fontSize);
	}

	public void setInterfaceBackgroundColor(Color color) {
		interfaceBackgroundColor = color;
	}

	public void setInterfaceBorderColor(Color interfaceBorderColor) {
		this.interfaceBorderColor = interfaceBorderColor;
	}

	public void setInterfaceTextColor(Color interfaceTextColor) {
		this.interfaceTextColor = interfaceTextColor;
	}
}
