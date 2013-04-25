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

/**
 * Die Klasse <code>Activity</code> realisiert eine Aktivität innerhalb eines
 * Prozess-Diagrammes.
 * <p>
 * Eine Aktivität wird durch eine eindeutige ID bestimmt. Die Position im
 * Diagramm wird durch eine weitere ID einer bereits vorhandenen Aktivität (
 * <code>parentId</code>) definiert. Besitzt das Feld <code>parentId</code> den
 * Wert <code>null</code>, so ist die Aktivität ein Startpunkt und wird am
 * Anfang eines Diagrammes platziert.
 * <p>
 * Befindet sich die Aktivität am Ende einer Verzweigung und sie möchte zurück
 * zum Hauptast verweisen, muß die Methode {@link #setEnd(String)} aufgerufen
 * werden. Als Parameter bekommt diese Methode die ID derjenigen Aktivität des
 * Hauptastes, die als Ziel verwendet werden soll.
 * <p>
 * Zusätzlich zur ID muß jede Aktivität einen Text besitzen, der sie beschreibt.
 * Optional kann auch eine Bedingung für die Aktivität angegeben werden. Diese
 * wird über dem Pfeil platziert der vom Vorgänger auf sie verweist.
 * 
 * @author mfuchs
 */
public class Activity {

	public final static int STANDARD = 1;
	public final static int START = 2;
	public final static int END = 3;
	public final static int REFERENCE = 4;
	public final static int LABEL = 5;

	private String id;
	private String parentId;
	private String text;
	private String condition;
	private String endId;
	private int type = STANDARD;
	private Color backgroundColor;
	private Color borderColor;
	private Color textColor;
	private boolean shadowEnabled = true;
	private String pathId;

	public Activity(String id, String text) {
		this(id, null, text);
	}

	public Activity(String id, String parentId, String text) {

		if (id == null) {
			throw new IllegalArgumentException(
					"The parameter id must not be null!");
		}

		if (text == null) {
			throw new IllegalArgumentException(
					"The parameter text must not be null!");
		}

		this.id = id;
		this.text = text;
		this.parentId = parentId;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public String getCondition() {
		return condition;
	}

	public String getEnd() {

		if (endId == null) {
			return "";
		}

		return endId;
	}

	public String getId() {
		return id;
	}

	public String getParentId() {

		if (parentId == null) {
			return "";
		}

		return parentId;
	}

	public String getPathId() {

		if (pathId == null) {
			return "";
		}

		return pathId;
	}

	public String getText() {
		return text;
	}

	public Color getTextColor() {
		return textColor;
	}

	public int getType() {
		return type;
	}

	public String getTypeAsText() {

		switch (type) {
		case STANDARD:
			return "standard";
		case START:
			return "start";
		case END:
			return "end";
		case LABEL:
			return "label";
		case REFERENCE:
			return "reference";
		default:
			break;
		}

		return "?";
	}

	public boolean hasCondition() {

		if (condition != null && condition.trim().length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isShadowEnabled() {
		return shadowEnabled;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	/**
	 * Setzt den Text für die Bedingung.
	 * 
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setEnd(String endId) {
		this.endId = endId;
	}

	public void setPathId(String pathId) {

		this.pathId = pathId;
	}

	public void setShadowEnabled(boolean shadowEnabled) {
		this.shadowEnabled = shadowEnabled;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String toString() {

		String delim = ",";

		StringBuilder buffer = new StringBuilder();

		buffer.append("Actitvity:=[");
		buffer.append("type=");
		buffer.append(getTypeAsText());
		buffer.append(delim);
		buffer.append("id=");
		buffer.append(getId());
		buffer.append(delim);
		buffer.append("pid=");
		buffer.append(getParentId());
		buffer.append(delim);
		buffer.append("eid=");
		buffer.append(getEnd());
		buffer.append(delim);
		buffer.append("text=");
		buffer.append(getText());
		buffer.append(delim);
		buffer.append("path=");
		buffer.append(getPathId());
		buffer.append("]");

		return buffer.toString();
	}
}
