package org.dbdoclet.svg;

import org.dbdoclet.svg.shape.Connector;
import org.dbdoclet.svg.shape.Shape;

/**
 * Die Klasse <code>Transition</code> beschreibt den Übergang von einer
 * Aktivität zur nächsten innerhalb eines Proessdiagrammes.
 * 
 * @author mfuchs
 */
public class Transition {

	private Shape startShape;
	private Shape endShape;
	private int startAnchor = Connector.ANCHOR_NONE;
	private int endAnchor = Connector.ANCHOR_NONE;
	private String condition;
	private boolean endArrowheadEnabled = true;

	public boolean isEndArrowheadEnabled() {
		return endArrowheadEnabled;
	}

	public void setEndArrowheadEnabled(boolean endArrowheadEnabled) {
		this.endArrowheadEnabled = endArrowheadEnabled;
	}

	public Transition(Shape startShape, Shape endShape, int startAnchor,
			int endAnchor) {

		this.startShape = startShape;
		this.endShape = endShape;
		this.startAnchor = startAnchor;
		this.endAnchor = endAnchor;
	}

	public Transition(Shape startShape, Shape endShape) {

		this(startShape, endShape, Connector.ANCHOR_NONE, Connector.ANCHOR_NONE);
	}

	public Shape getStartShape() {
		return startShape;
	}

	public void setStartShape(Shape startShape) {
		this.startShape = startShape;
	}

	public Shape getEndShape() {
		return endShape;
	}

	public void setEndShape(Shape endShape) {
		this.endShape = endShape;
	}

	public int getStartAnchor() {
		return startAnchor;
	}

	public void setStartAnchor(int startAnchor) {
		this.startAnchor = startAnchor;
	}

	public int getEndAnchor() {
		return endAnchor;
	}

	public void setEndAnchor(int endAnchor) {
		this.endAnchor = endAnchor;
	}

	public boolean hasCondition() {

		if (condition != null && condition.trim().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}
	
	@Override
	public boolean equals(Object other) {
	
		if (other.getClass() != getClass()) {
			return false;
		}
		
		return equals((Transition) other);
	}
	
	public boolean equals(Transition other) {
		
		if (other == null) {
			return false;
		}
		
		Cell otherStartCell = other.getStartShape().getCell();
		Cell otherEndCell = other.getEndShape().getCell();
		Cell startCell = startShape.getCell();
		Cell endCell = endShape.getCell();
 
		if (otherStartCell.equals(startCell) && otherEndCell.equals(endCell)) {
			return true;
		}
		
		return false;
	}

	public String toString() {

		String delim = ",";

		StringBuilder buffer = new StringBuilder();

		buffer.append("Transition:=[");
		buffer.append("startShape=");
		buffer.append(getStartShape());
		buffer.append(delim);
		buffer.append("endShape=");
		buffer.append(getEndShape());
		buffer.append("]");

		return buffer.toString();
	}

}
