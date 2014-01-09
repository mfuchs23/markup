/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg.shape;

import java.awt.Color;
import java.awt.Font;

import org.dbdoclet.svg.Area;
import org.dbdoclet.svg.Cell;

public abstract class Shape extends Element {

	private static Font defaultFont = new Font("SansSerif", Font.PLAIN, 11);

	private Area area;
	private String name;

	protected Cell cell;
	protected Color textColor = Color.black;
	protected Color strokeColor = Color.black;
	protected Color backgroundColor = new Color(255, 255, 224);
	protected Color foregroundColor = Color.black;

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract void draw(int x, int y);

	public Shape(String id, int row, int column) {

		super(id);

		if (row < 0) {
			throw new IllegalArgumentException(
					"The argument row must not be < 0!");
		}

		if (column < 0) {
			throw new IllegalArgumentException(
					"The argument column must not be < 0!");
		}

		cell = new Cell(row, column);
		name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Area getArea() {
		return area;
	}

	public void setDefaultFont(Font defaultFont) {
		Shape.defaultFont = defaultFont;
	}

	public Font getDefaultFont() {
		return defaultFont;
	}

	public int getColumn() {
		return cell.getColumn();
	}

	public void setColumn(int column) {
		cell.setColumn(column);
	}

	public int getRow() {
		return cell.getRow();
	}

	public Cell getCell() {
		return cell;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

	public void setBorderColor(Color borderColor) {
		this.strokeColor = borderColor;
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("Shape:=[");
		buffer.append("name=");
		buffer.append(getName());
		buffer.append("]");

		return buffer.toString();
	}

	public void moveRight() {
		cell.moveRight();
	}
}
