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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.Sfv;
import org.dbdoclet.option.FileOption;
import org.dbdoclet.option.OptionList;
import org.dbdoclet.service.ExecServices;
import org.dbdoclet.service.FileServices;
import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.Connector;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextBox;
import org.dbdoclet.svg.shape.TextCircle;
import org.dbdoclet.svg.shape.TextUnit;

/**
 * Die Klasse <code>ProcessDiagramCreator</code> erstellt Ablaufdiagramme zur
 * Visualisierung von Prozessen.
 * 
 * @author mfuchs
 */
public class ProcessDiagramCreator extends AbstractDiagrammCreator {

	private final static Color DARK_GREEN = new Color(0, 100, 0);

	private static Log logger = LogFactory.getLog(
			ProcessDiagramCreator.class);

	private final static Color UNICO_BLUE = new Color(0, 45, 113);

	private Color activityBackgroundColor = Color.LIGHT_GRAY;
	private Color activityBorderColor = Color.DARK_GRAY;

	private HashMap<String, Shape> activityMap;
	private Color activityTextColor = Color.BLACK;

	private SvgCanvas canvas;
	private HashMap<String, Connection> connectionMap;
	private boolean directArrowMode = false;
	private Color endBackgroundColor = DARK_GREEN;
	private Color endBorderColor = DARK_GREEN;
	private Color endTextColor = Color.WHITE;
	private String fontFamily = "Arial";
	private int fontSize = 12;
	private LinkedHashMap<String, ArrayList<Activity>> pathMap;
	private Color referenceBackgroundColor = Color.LIGHT_GRAY;
	private Color referenceBorderColor = Color.DARK_GRAY;
	private Color referenceTextColor = Color.BLACK;
	private Font sansSerif;
	private Font sansSerifBold;
	private Color selectedBackgroundColor = UNICO_BLUE;
	private Color selectedBorderColor = UNICO_BLUE;
	private Color selectedTextColor = Color.white;
	private ShapeFactory shapeFactory;

	private HashMap<String, Shape> shapeMap;
	private Color startBackgroundColor = DARK_GREEN;
	private Color startBorderColor = DARK_GREEN;
	private Color startTextColor = Color.WHITE;
	private StringBuilder traceBuffer;
	private boolean traceEnabled = false;

	public ProcessDiagramCreator() {

		canvas = new SvgXmlCanvas();
		shapeFactory = new ShapeXmlFactory(canvas.getDocument());

		canvas.setCellPadding(20);

		sansSerif = new Font(fontFamily, Font.PLAIN, fontSize);
		sansSerifBold = new Font(fontFamily, Font.BOLD, fontSize);

		activityMap = new HashMap<String, Shape>();
		pathMap = new LinkedHashMap<String, ArrayList<Activity>>();
		shapeMap = new HashMap<String, Shape>();
		connectionMap = new HashMap<String, Connection>();

		ArrayList<Activity> trunkList = new ArrayList<Activity>();
		pathMap.put("trunk", trunkList);
	}

	/**
	 * Erstellt ein Testdiagramm zu Entwicklungszwecken.
	 */
	public static void main(String[] args) {

		try {

			logger.debug("ProcessDiagramCreator");

			OptionList options = new OptionList(args);

			FileOption optFile = new FileOption("file", "f");
			optFile.isRequired(true);
			optFile.isExisting(true);
			options.add(optFile);

			if (options.validate() == false) {
				System.err.println(options.getError());
				return;
			}

			File file = optFile.getValue();
			BufferedReader reader = new BufferedReader(new FileReader(file));

			ProcessDiagramCreator pdc = new ProcessDiagramCreator();
			pdc.setTraceEnabled(true);

			// pdc.setActivityBackgroundColor(Color.orange);
			// pdc.setActivityBorderColor(Color.RED);
			// pdc.setActivityTextColor(Color.BLUE);
			// pdc.setStartBackgroundColor(Color.orange);
			// pdc.setStartBorderColor(Color.RED);
			// pdc.setStartTextColor(Color.BLUE);
			// pdc.setEndBackgroundColor(Color.orange);
			// pdc.setEndBorderColor(Color.RED);
			// pdc.setEndTextColor(Color.BLUE);
			//
			Activity activity;
			String line = reader.readLine();

			HashMap<String, Activity> amap = new HashMap<String, Activity>();

			while (line != null) {

				line = line.trim();

				if (line.startsWith("#") || line.length() == 0) {

					line = reader.readLine();
					continue;
				}

				String[] tokens = line.split("~");

				logger.debug("tokens[01]=" + tokens[0] + ", tokens[1]="
						+ tokens[1]);

				if (tokens[0].equals("s")) {
					activity = pdc.setStart(tokens[1], tokens[2]);
					amap.put(tokens[1], activity);
				}

				if (tokens[0].equals("a")) {

					if (tokens.length == 4) {
						activity = pdc.addActivity(tokens[1], tokens[2],
								tokens[3]);
						amap.put(tokens[1], activity);
					} else {
						activity = pdc.addActivity(tokens[1], tokens[2]);
						amap.put(tokens[1], activity);
					}
				}

				if (tokens[0].equals("b")) {

					activity = pdc.addAlternative(tokens[1], tokens[2],
							tokens[3], tokens[4]);
					amap.put(tokens[2], activity);

					if (tokens.length == 6) {
						activity.setCondition(tokens[5]);
					}
				}

				if (tokens[0].equals("be")) {
					activity = amap.get(tokens[1]);
					activity.setEnd(tokens[2]);
				}

				if (tokens[0].equals("c")) {
					pdc.addConnection(tokens[1], tokens[2], tokens[3],
							tokens[4]);
				}

				if (tokens[0].equals("r")) {
					activity = pdc
							.addReference(tokens[1], tokens[2], tokens[3]);
				}

				if (tokens[0].equals("e")) {
					activity = pdc.addEnd(tokens[1], tokens[2]);
					amap.put(tokens[1], activity);
				}

				line = reader.readLine();
			}

			reader.close();

			pdc.setTraceEnabled(true);
			pdc.drawImage("a11");
			// System.out.println(pdc.getTraceLog());

			FileServices.writeFromString("build/pdc.dump", pdc.getTraceLog());
			pdc.save(new File("build/pdc.svg"));
			pdc.saveAsPng(new File("build/pdc.png"));

			PrintWriter writer = new PrintWriter(new FileWriter(
					"/tmp/areas.txt"));

			HashMap<String, Area> areaMap = pdc.getAreaMap();

			for (String key : areaMap.keySet()) {
				Area area = areaMap.get(key);
				writer.println("Area " + key + " " + area.getCoordsAsText()
						+ " " + area.getName());
			}

			writer.close();

			ExecServices.exec("gnome-open build/pdc.png");

		} catch (Throwable oops) {

			oops.printStackTrace();
		}
	}

	public static void usage() {
		System.out.println("Syntax: ");
	}

	/**
	 * Fügt dem Hauptast eine neue Aktivität hinzu. Die Id der neuen Aktivität
	 * muß innerhalb des Diagramms eindeutig gewählt werden.
	 * 
	 * @param id
	 *            Die Id der neuen Aktivität.
	 * @param text
	 *            Der Text der neuen Aktivität.
	 * @return Referenz auf die erzeugte Aktivität.
	 */
	public Activity addActivity(String id, String text) {
		return addActivity(id, "trunk", text);
	}

	/**
	 * <p>
	 * Fügt dem Seitenast mitr der Id <code>pathId</code> eine neue Aktivität
	 * hinzu. Die Aktivität wird an das Ende des Astes angefügt und erhält die
	 * Farben schwarz auf hellgrau mit dunkelgrauem Rand.
	 * </p>
	 * 
	 * <img align="center" src="doc-files/activity-standard.png"/>
	 * 
	 * @param id
	 *            Die Id der neuen Aktivität.
	 * @param pathId
	 *            Die Id des Seitenzweiges.
	 * @param text
	 *            Der Text der neuen Aktivität.
	 * @return Referenz auf die erzeugte Aktivität.
	 */
	public Activity addActivity(String id, String pathId, String text) {

		Activity activity = new Activity(id, text);
		activity.setPathId(pathId);
		activity.setTextColor(activityTextColor);
		activity.setBackgroundColor(activityBackgroundColor);
		activity.setBorderColor(activityBorderColor);

		ArrayList<Activity> list = pathMap.get(pathId);

		if (list != null) {
			list.add(activity);
		}

		traceln("addActivity: " + activity.toString());
		return activity;
	}

	/**
	 * Die Methode startet einen neuen möglichen Seitenpfad durch das
	 * Ablaufdiagramm. Das Ende eines Seitenzweiges wird für die letzte
	 * Aktivität innerhalb des Zweiges mit der Methode
	 * {@link Activity#setEnd(String)} gesetzt.
	 * 
	 * @param id
	 *            Die Id des alternativen Pfades. Diese Id wird benötigt um neue
	 *            Aktivitäten in den Pfad einzufügen.
	 * @param aid
	 *            Die Id der ersten Aktivität.
	 * @param pid
	 *            Die Id des Vorgängers dieses Seitenzweiges. Von der hier
	 *            angegebenen Aktivität wird der Seitenzweig abgespaltet.
	 * @param text
	 *            Der Text der ersten Aktivität.
	 * @return Die erste Aktivität des Seitenzweiges.
	 */
	public Activity addAlternative(String id, String aid, String pid,
			String text) {

		ArrayList<Activity> list = new ArrayList<Activity>();
		Activity activity = new Activity(aid, pid, text);
		activity.setPathId(id);
		activity.setTextColor(activityTextColor);
		activity.setBackgroundColor(activityBackgroundColor);
		activity.setBorderColor(activityBorderColor);
		list.add(activity);
		pathMap.put(id, list);

		traceln("addAlternative: " + activity.toString());
		return activity;
	}

	/**
	 * Erzeugt eine direkte Verbindung zwischen zwei Aktivitäten. Die
	 * Aktivitäten
	 * 
	 * @param id
	 * @param fromId
	 * @param toId
	 * @param text
	 */
	public void addConnection(String id, String fromId, String toId, String text) {

		// Connection conn = new Connection(id, from, to, text);
		// connectionMap.put(id, conn);
		Activity activity = addAlternative(id, "c" + id, fromId, text);
		activity.setEnd(toId);

		activity.setType(Activity.LABEL);
		activity.setBorderColor(Color.white);
		activity.setBackgroundColor(Color.white);
		activity.setShadowEnabled(false);

		traceln("addConnection: " + activity.toString());
	}

	/**
	 * <p>
	 * Erzeugt einen Endpunkt. Ein Endpunkt enthält den gewünschten Endzustand
	 * eines Prozesses. Die Aktivität wird an das Ende des Hauptastes angefügt
	 * und erhält die Farben weiß auf grün.
	 * </p>
	 * 
	 * <img align="center" src="doc-files/end.png"/>
	 * 
	 * @param id
	 * @param text
	 */
	public Activity addEnd(String id, String text) {

		Activity activity = new Activity(id, text);
		activity.setTextColor(endTextColor);
		activity.setBackgroundColor(endBackgroundColor);
		activity.setBorderColor(endBorderColor);

		ArrayList<Activity> list = pathMap.get("trunk");
		list.add(activity);

		traceln("addEnd: " + activity.toString());
		return activity;
	}

	/**
	 * Erstellt eine Referenz aus dem Hauptast auf einen anderen Prozess. Die
	 * Referenz wird als Kugel dargestellt.
	 * 
	 * @param id
	 * @param text
	 * @return Activity
	 */
	public Activity addReference(String id, String text) {
		return addReference(id, "trunk", text);
	}

	/**
	 * Erstellt eine Referenz auf einen anderen Prozess. Die Referenz wird als
	 * Kugel dargestellt.
	 * 
	 * @param id
	 * @param pathId
	 * @param text
	 * @return Activity
	 */
	public Activity addReference(String id, String pathId, String text) {

		Activity activity = new Activity(id, text);
		activity.setTextColor(referenceTextColor);
		activity.setBackgroundColor(referenceBackgroundColor);
		activity.setBorderColor(referenceBorderColor);
		activity.setType(Activity.REFERENCE);

		ArrayList<Activity> list = pathMap.get(pathId);

		if (list != null) {
			list.add(activity);
		}

		traceln("addReference: " + activity.toString());
		return activity;
	}

	/**
	 * Ermittelt den Index der nächsten freien Zeile. Eine Zeile gilt als frei,
	 * wenn an der angegebenen Spalte kein Element gefunden wird. Nachfolgende
	 * Spalten werden nicht überprüft.
	 * 
	 * @param trunkRow
	 * @param column
	 * @return
	 */
	private int calculateNextFreeRowIndex(int trunkRow, int column) {

		boolean foundFreeRow = false;
		int index = 1;
		int row = 0;
		String key;

		while (foundFreeRow == false) {

			row = trunkRow - index;
			key = String.valueOf(row) + "_" + String.valueOf(column);

			if (shapeMap.get(key) == null) {
				return row;
			}

			row = trunkRow + index;
			key = String.valueOf(row) + "_" + String.valueOf(column);

			if (shapeMap.get(key) == null) {
				return row;
			}

			index++;
		}

		return trunkRow - 1;
	}

	private Shape createTextBox(String id, int row, int col, String text,
			Color textColor, Color strokeColor, Color backgroundColor,
			boolean shadowEnabled) {

		TextBox textBox = shapeFactory.createTextBox(id, row, col);
		TextUnit textUnit = new TextUnit(text, sansSerifBold);
		textBox.addText(textUnit);
		textBox.setRoundedCorner(5);
		textBox.setTextColor(textColor);
		textBox.setStrokeColor(strokeColor);
		textBox.setBackgroundColor(backgroundColor);
		textBox.setShadowEnabled(shadowEnabled);
		textBox.setName(id);

		shapeMap.put(String.valueOf(row) + "_" + String.valueOf(col), textBox);
		return textBox;
	}

	private Shape createTextCircle(String id, int row, int col, String text,
			Color textColor, Color strokeColor, Color backgroundColor) {

		TextCircle textCircle = shapeFactory.createTextCircle(id, row, col);
		TextUnit textUnit = new TextUnit(text, sansSerifBold);
		textCircle.addText(textUnit);
		textCircle.setTextColor(textColor);
		textCircle.setStrokeColor(strokeColor);
		textCircle.setBackgroundColor(backgroundColor);
		textCircle.setShadowEnabled(true);
		textCircle.setName("reference");

		shapeMap.put(String.valueOf(row) + "_" + String.valueOf(col),
				textCircle);
		return textCircle;
	}

	public void drawImage() {
		drawImage("");
	}

	/**
	 * Berechnet die Positionen der grafischen Elemente auf der Bildfläche.
	 * 
	 * @param selected
	 *            Die ID derjenigen Aktivität, die hervorgehoben dargestellt
	 *            werden soll.
	 */
	public void drawImage(String selected) {

		int trunkRow = 0;

		Shape shape;
		Shape previousShape = null;
		Activity activity;
		Arrow arrow;
		Color textColor;
		Color strokeColor;
		Color backgroundColor;

		ArrayList<Transition> connectorList = new ArrayList<Transition>();

		if (pathMap.size() > 1) {
			trunkRow = pathMap.size() / 2;
		}

		/* Bearbeitung der Aktivitäten des Hauptastes */

		ArrayList<Activity> trunkList = pathMap.get("trunk");

		for (int i = 0; i < trunkList.size(); i++) {

			activity = trunkList.get(i);
			traceln("drawImage: " + activity);

			if (selected.equals(activity.getId())) {

				textColor = selectedTextColor;
				strokeColor = selectedBorderColor;
				backgroundColor = selectedBackgroundColor;

			} else {

				textColor = activity.getTextColor();
				strokeColor = activity.getBorderColor();
				backgroundColor = activity.getBackgroundColor();
			}

			if (activity.getType() == Activity.REFERENCE) {

				shape = createTextCircle(activity.getId(), trunkRow, i,
						activity.getText(), textColor, strokeColor,
						backgroundColor);

			} else {

				shape = createTextBox(activity.getId(), trunkRow, i, activity
						.getText(), textColor, strokeColor, backgroundColor,
						activity.isShadowEnabled());
			}

			canvas.addShape(shape);
			activityMap.put(activity.getId(), shape);

			if (previousShape != null) {

				Transition transition = new Transition(previousShape, shape);

				if (activity.hasCondition()) {
					transition.setCondition(activity.getCondition());
				}

				connectorList.add(transition);
			}

			previousShape = shape;
		}

		int rowIndex = 0;
		int colIndex = 0;

		/* Bearbeitung der Nebenzweige. */

		Iterator<String> iterator = pathMap.keySet().iterator();

		while (iterator.hasNext()) {

			String pathId = (String) iterator.next();

			if (pathId.equalsIgnoreCase("trunk") == true) {
				continue;
			}

			colIndex = 0;

			ArrayList<Activity> pathList = pathMap.get(pathId);

			for (int i = 0; i < pathList.size(); i++) {

				activity = pathList.get(i);
				traceln("drawImage: " + activity);

				if (selected.equals(activity.getId())) {

					textColor = selectedTextColor;
					strokeColor = selectedBorderColor;
					backgroundColor = selectedBackgroundColor;

				} else {

					textColor = activity.getTextColor();
					strokeColor = activity.getBorderColor();
					backgroundColor = activity.getBackgroundColor();
				}

				// Die erste Aktivität innerhalb des Pfades
				if (i == 0) {

					previousShape = activityMap.get(activity.getParentId());

					if (previousShape != null) {
						colIndex = previousShape.getColumn() + 1;
					}

					rowIndex = calculateNextFreeRowIndex(trunkRow, colIndex);
				}

				if (activity.getType() == Activity.REFERENCE) {

					shape = createTextCircle(activity.getId(), rowIndex,
							colIndex + i, activity.getText(), textColor,
							strokeColor, backgroundColor);
					canvas.addShape(shape);

				} else {

					shape = createTextBox(activity.getId(), rowIndex, colIndex
							+ i, activity.getText(), textColor, strokeColor,
							backgroundColor, activity.isShadowEnabled());
					canvas.addShape(shape);
				}

				activityMap.put(activity.getId(), shape);

				if (previousShape != null) {

					// logger.debug("arrow: fromColumn=" +
					// previousTextBox.getColumn() + " toRow=" +
					// textBox.getRow());
					Transition transition = new Transition(previousShape, shape);

					if (activity.getType() == Activity.LABEL) {
						transition.setEndArrowheadEnabled(false);
					}

					if (activity.hasCondition()) {
						transition.setCondition(activity.getCondition());
					}

					connectorList.add(transition);
				}

				if (activity.getEnd() != null) {

					// logger.debug("merge");
					Shape nextTextBox = activityMap.get(activity.getEnd());

					if (nextTextBox == null) {

						logger.error("Unbekannte Aktivität "
								+ activity.getEnd());

					} else {

						if (nextTextBox.getColumn() <= shape.getColumn()) {
							// nextTextBox.setColumn(shape.getColumn() + 1);
							canvas.moveRight(nextTextBox);
						}

						Transition transition = new Transition(shape,
								nextTextBox);
						transition.setStartAnchor(Connector.ANCHOR_EAST);

						connectorList.add(transition);
					}
				}

				previousShape = shape;
			}

		}

		for (String id : connectionMap.keySet()) {

			Connection conn = connectionMap.get(id);
			traceln("drawImage: " + conn.toString());

			Shape from = activityMap.get(conn.getFrom().getId());
			Shape to = activityMap.get(conn.getTo().getId());

			Transition transition = new Transition(from, to);
			transition.setCondition(conn.getText());

			connectorList.add(transition);
		}

		for (Transition transition : connectorList) {

			traceln("drawImage: " + transition.toString());

			arrow = shapeFactory.createArrow("at", transition.getStartShape(),
					transition.getEndShape());
			arrow.setFont(sansSerif);
			arrow.setFillEnabled(true);

			arrow.setStartAnchor(transition.getStartAnchor());
			arrow.setEndAnchor(transition.getEndAnchor());
			arrow.setDirectMode(directArrowMode);
			arrow.setEndArrowHeadEnabled(transition.isEndArrowheadEnabled());

			if (transition.hasCondition()) {
				arrow.setText(transition.getCondition());
			}

			canvas.addArrow(arrow);
		}

		canvas.drawImage();
	}

	public Color getActivityBackgroundColor() {
		return activityBackgroundColor;
	}

	public Color getActivityBorderColor() {
		return activityBorderColor;
	}

	public Color getActivityTextColor() {
		return activityTextColor;
	}

	public Activity getNextSibling(Activity activity) {
	
		if (activity == null) {
			return null;
		}
		
		ArrayList<Activity> list = pathMap.get(activity.getPathId());
		
		if (list == null) {
			return null;
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			Activity a = list.get(i);
			
			if (activity == a && i < list.size() - 1) { 
				return list.get(i + 1);
			}
		}
		
		return null;
	}
	
	public HashMap<String, Area> getAreaMap() {

		HashMap<String, Area> areaMap = new HashMap<String, Area>();

		Area area;
		Shape shape;
		String id;

		Iterator<String> iterator = activityMap.keySet().iterator();

		while (iterator.hasNext()) {

			id = (String) iterator.next();
			shape = activityMap.get(id);

			if (shape != null) {
				area = shape.getArea();
				if (area != null) {
					areaMap.put(id, area);
				}
			}
		}

		return areaMap;
	}

	public Color getEndBackgroundColor() {
		return endBackgroundColor;
	}

	public Color getEndBorderColor() {
		return endBorderColor;
	}

	public Color getEndTextColor() {
		return endTextColor;
	}

	public Color getReferenceBackgroundColor() {
		return referenceBackgroundColor;
	}

	public Color getReferenceBorderColor() {
		return referenceBorderColor;
	}

	public Color getReferenceTextColor() {
		return referenceTextColor;
	}

	public Color getSelectedBackgroundColor() {
		return selectedBackgroundColor;
	}

	public Color getSelectedBorderColor() {
		return selectedBorderColor;
	}

	public Color getSelectedTextColor() {
		return selectedTextColor;
	}

	public Color getStartBackgroundColor() {
		return startBackgroundColor;
	}

	public Color getStartBorderColor() {
		return startBorderColor;
	}

	public Color getStartTextColor() {
		return startTextColor;
	}

	public String getTraceLog() {

		if (traceBuffer != null) {
			return traceBuffer.toString();
		}

		return "TraceLog not found!";
	}

	public boolean isTraceEnabled() {
		return traceEnabled;
	}

	public void save(File file) throws IOException, SvgException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		canvas.save(file);
	}

	public void saveAsPng(File file) throws IOException, SvgException {

		if (file == null) {
			throw new IllegalArgumentException(
					"The argument file must not be null!");
		}

		canvas.saveAsPng(file);
	}

	public void scaleToWidth(int width) {
		canvas.scaleToWidth(width);
	}

	public void setActivityBackgroundColor(Color activityBackgroundColor) {
		this.activityBackgroundColor = activityBackgroundColor;
	}

	public void setActivityBorderColor(Color activityBorderColor) {
		this.activityBorderColor = activityBorderColor;
	}

	public void setActivityTextColor(Color activityTextColor) {
		this.activityTextColor = activityTextColor;
	}

	public void setEndBackgroundColor(Color endBackgroundColor) {
		this.endBackgroundColor = endBackgroundColor;
	}

	public void setEndBorderColor(Color endBorderColor) {
		this.endBorderColor = endBorderColor;
	}

	public void setEndTextColor(Color endTextColor) {
		this.endTextColor = endTextColor;
	}

	public void setReferenceBackgroundColor(Color referenceBackgroundColor) {
		this.referenceBackgroundColor = referenceBackgroundColor;
	}

	public void setReferenceBorderColor(Color referenceBorderColor) {
		this.referenceBorderColor = referenceBorderColor;
	}

	public void setReferenceTextColor(Color referenceTextColor) {
		this.referenceTextColor = referenceTextColor;
	}

	public void setSelectedBackgroundColor(Color selectedBackgroundColor) {
		this.selectedBackgroundColor = selectedBackgroundColor;
	}

	public void setSelectedBorderColor(Color selectedBorderColor) {
		this.selectedBorderColor = selectedBorderColor;
	}

	public void setSelectedTextColor(Color secletedTextColor) {
		this.selectedTextColor = secletedTextColor;
	}

	/**
	 * Erzeugt den Startpunkt eines Prozessdiagrammes im Haupast. Der Startpunkt
	 * wird am Anfang des Hauptastes eingefügt. Ist bereits ein Startpunkt
	 * vorhanden, so wird dieser nach rechts verschoben.
	 * 
	 * <p>
	 * Der Startpunkt wird farblich markiert und erhält die Farben weiß auf
	 * grün.
	 * </p>
	 * 
	 * <img align="center" src="doc-files/start.png"/>
	 * 
	 * @param id
	 *            Die Id der Aktivität
	 * @param text
	 *            Der Text der Aktivität
	 */
	public Activity setStart(String id, String text) {

		Activity activity = new Activity(id, text);
		activity.setType(Activity.START);
		activity.setTextColor(startTextColor);
		activity.setBackgroundColor(startBackgroundColor);
		activity.setBorderColor(startBorderColor);

		ArrayList<Activity> list = pathMap.get("trunk");

		if (list.size() == 0) {
			list.add(activity);
		} else {
			list.add(0, activity);
		}

		traceln("setStart: " + activity.toString());
		return activity;
	}

	public void setStartBackgroundColor(Color startBackgroundColor) {
		this.startBackgroundColor = startBackgroundColor;
	}

	public void setStartBorderColor(Color startBorderColor) {
		this.startBorderColor = startBorderColor;
	}

	public void setStartTextColor(Color startTextColor) {
		this.startTextColor = startTextColor;
	}

	public void setTraceEnabled(boolean traceEnabled) {

		this.traceEnabled = traceEnabled;

		if (traceEnabled == true && traceBuffer == null) {
			traceBuffer = new StringBuilder();
		}
	}

	private void traceln(String line) {

		if (traceEnabled == true) {

			traceBuffer.append(line);
			traceBuffer.append(Sfv.LSEP);
		}
	}
}
