/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.svg;

public class Cell {

	public int row;
	public int column;
	private int leftBound;
	private int topBound;
	private int rightBound;
	private int bottomBound;

	public Cell(int row, int column) {

		this.row = row;
		this.column = column;
	}

	public int getBottomBound() {
		return bottomBound;
	}

	public int getColumn() {
		return column;
	}

	public int getLeftBound() {
		return leftBound;
	}

	public int getRightBound() {
		return rightBound;
	}

	public int getRow() {
		return row;
	}

	public int getTopBound() {
		return topBound;
	}

	public void moveRight() {
		column++;
	}

	public void setBounds(int leftBound, int topBound, int rightBound,
			int bottomBound) {

		this.leftBound = leftBound;
		this.topBound = topBound;
		this.rightBound = rightBound;
		this.bottomBound = bottomBound;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public boolean equals(Object other) {
	
		if (other.getClass() != getClass()) {
			return false;
		}
		
		return equals((Cell) other);
	}
	
	public boolean equals(Cell other) {

		if (this == other) {
			return true;
		}

		if (other == null) {
			return false;
		}

		if (other.column == column && other.row == row) {
			return true;
		}

		return false;
	}

	public int hashCode() {
		
		int hc = 17;
		int m = 59;

		hc = hc * m + row;
		hc = hc * m + column;

		return hc;
	}

	public String toString() {
		return "(" + row + ", " + column + ")";
	}

}
