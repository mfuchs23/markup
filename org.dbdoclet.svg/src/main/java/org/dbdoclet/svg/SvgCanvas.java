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
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.svg.shape.Arrow;
import org.dbdoclet.svg.shape.Connector;
import org.dbdoclet.svg.shape.DefaultShape;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.xiphias.NodeSerializer;
import org.w3c.dom.Document;

public abstract class SvgCanvas {

    private static Log logger = LogFactory.getLog(SvgCanvas.class);

    public final static String SVGNS = SVGDOMImplementation.SVG_NAMESPACE_URI;

    protected ArrayList<Connector> connectorList;
    protected ArrayList<Shape> shapeList;
    protected Color backgroundColor = Color.white;
    protected Color boxBackgroundColor = Color.lightGray;
    protected Color foregroundColor = Color.black;
    protected Document doc;
    protected Font font;
    protected int arrowPadding = 10;
    protected int cellPadding = 10;

    private int scaleWidth = 0;

    protected abstract void setImageSize(int imageWidth, int imageHeight,
            int scaledWidth, int scaledHeight);

    public Document getDocument() {
        return doc;
    }

    public void setCellPadding(int cellPadding) {
        this.cellPadding = cellPadding;
    }

    public int getCellPadding() {
        return cellPadding;
    }

    public int getArrowPadding() {
        return arrowPadding;
    }

    public void setArrowPadding(int arrowPadding) {
        this.arrowPadding = arrowPadding;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public Color getBoxBackgroundColor() {
        return boxBackgroundColor;
    }

    public void setBoxBackgroundColor(Color boxBackgroundColor) {
        this.boxBackgroundColor = boxBackgroundColor;
    }

    public void addShape(Shape shape) {

        shapeList.add(shape);
    }

    public void addArrow(Arrow arrow) {

        if (arrow == null) {
            throw new IllegalArgumentException(
                    "The argument arrow must not be null!");
        }

        connectorList.add(arrow);
    }

    public void scaleToWidth(int scaleWidth) {

        scaleWidth /= 0.33;
        this.scaleWidth = scaleWidth;
    }

    public void save(File file) throws IOException, SvgException {

        if (file == null) {
            throw new IllegalArgumentException(
                    "The argument file must not be null!");
        }

        NodeSerializer serializer = new NodeSerializer();
        serializer.write(doc, file);
    }

    public void saveAsPng(File file) throws IOException, SvgException {

        // drawImage();

        File tempFile = File.createTempFile("svgImage", "svg");
        NodeSerializer serializer = new NodeSerializer();
        serializer.write(doc, tempFile);

        PNGTranscoder transcoder = new PNGTranscoder();
        TranscoderInput input = new TranscoderInput(tempFile.toURI().toURL()
                .toString());

        OutputStream ostream = new FileOutputStream(file);
        TranscoderOutput output = new TranscoderOutput(ostream);

        try {
            transcoder.transcode(input, output);
        } catch (TranscoderException oops) {
            throw new SvgException(oops);
        }

        ostream.flush();
        ostream.close();

        tempFile.delete();
    }

    public void saveAsJpeg(File file) throws IOException, SvgException {

        // drawImage();

        File tempFile = File.createTempFile("svgImage", "svg");
        NodeSerializer serializer = new NodeSerializer();
        serializer.write(doc, tempFile);

        JPEGTranscoder transcoder = new JPEGTranscoder();
        TranscoderInput input = new TranscoderInput(tempFile.toURI().toURL()
                .toString());

        OutputStream ostream = new FileOutputStream(file);
        TranscoderOutput output = new TranscoderOutput(ostream);

        try {
            transcoder.transcode(input, output);
        } catch (TranscoderException oops) {
            throw new SvgException(oops);
        }

        ostream.flush();
        ostream.close();

        tempFile.delete();
    }

    public void drawImage() {

        logger.debug("drawImage");

        Iterator<Shape> iterator;

        iterator = shapeList.iterator();

        int maxRow = 0;
        int maxColumn = 0;

        while (iterator.hasNext()) {

            Shape shape = (Shape) iterator.next();

            if (shape.getRow() > maxRow) {
                maxRow = shape.getRow();
            }

            if (shape.getColumn() > maxColumn) {
                maxColumn = shape.getColumn();
            }
        }

        Shape[][] shapeMatrix = new Shape[maxRow + 1][maxColumn + 1];

        iterator = shapeList.iterator();

        while (iterator.hasNext()) {
            Shape shape = (Shape) iterator.next();
            shapeMatrix[shape.getRow()][shape.getColumn()] = shape;
        }

        for (int i = 0; i < shapeMatrix.length; i++) {
            for (int j = 0; j < shapeMatrix[i].length; j++) {
                if (shapeMatrix[i][j] == null) {
                    shapeMatrix[i][j] = new DefaultShape("ds_" + i + "." + j,
                            i, j);
                }
            }
        }

        RowInfo[] rowInfos = new RowInfo[maxRow + 1];

        for (int i = 0; i < rowInfos.length; i++) {
            rowInfos[i] = new RowInfo();
        }

        ColumnInfo[] colInfos = new ColumnInfo[maxColumn + 1];

        for (int i = 0; i < colInfos.length; i++) {
            colInfos[i] = new ColumnInfo();
        }

        for (int i = 0; i < shapeMatrix.length; i++) {
            for (int j = 0; j < shapeMatrix[i].length; j++) {
                rowInfos[i].setMaxHeight(shapeMatrix[i][j].getHeight()
                        + (cellPadding * 2));
                colInfos[j].setMaxWidth(shapeMatrix[i][j].getWidth()
                        + (cellPadding * 2));
            }
        }

        int imageWidth = 0;

        for (int i = 0; i < colInfos.length; i++) {
            imageWidth += colInfos[i].getWidth();
        }

        int imageHeight = 0;

        for (int i = 0; i < rowInfos.length; i++) {
            imageHeight += rowInfos[i].getHeight();
        }

        double factor = (double) scaleWidth / (double) imageWidth;
        int scaleHeight = (int) (imageHeight * factor);
        logger.debug("Bildgröße: " + imageWidth + "x" + imageHeight);
        logger.debug("scaleWidth=" + scaleWidth + ", imageWidth=" + imageWidth);
        logger.debug("scaleWidth=" + scaleWidth + ", scaleHeight="
                + scaleHeight + ", factor=" + factor);

        setImageSize(imageWidth, imageHeight, scaleWidth, scaleHeight);

        for (int i = 0; i < shapeMatrix.length; i++) {

            for (int j = 0; j < shapeMatrix[i].length; j++) {

                int xpos = 0;
                int ypos = 0;
                int leftBound = 0;
                int rightBound = 0;
                int topBound = 0;
                int bottomBound = 0;

                for (int c = 0; c < j; c++) {
                    xpos += colInfos[c].getWidth();
                }

                leftBound = xpos;
                rightBound = xpos + colInfos[j].getWidth();

                xpos += (colInfos[j].getWidth() - shapeMatrix[i][j].getWidth()) / 2;

                for (int r = 0; r < i; r++) {
                    ypos += rowInfos[r].getHeight();
                }

                topBound = ypos;
                bottomBound = ypos + rowInfos[i].getHeight();

                ypos += (rowInfos[i].getHeight() - shapeMatrix[i][j]
                        .getHeight()) / 2;

                shapeMatrix[i][j].getCell().setBounds(leftBound, topBound,
                        rightBound, bottomBound);
                shapeMatrix[i][j].draw(xpos, ypos);
            }
        }

        for (Connector connector : connectorList) {

            Cell from = connector.getFrom().getCell();
            Cell to = connector.getTo().getCell();

            logger.debug("from=" + from + ", to=" + to);

            Point start = calculateStartPoint(connector, from, to, rowInfos,
                    colInfos, shapeMatrix);
            Point end = calculateEndPoint(connector, from, to, rowInfos,
                    colInfos, shapeMatrix);

            connector.draw(start.x, start.y, end.x, end.y);
        }
    }

    private Point calculateStartPoint(Connector connector, Cell from, Cell to,
            RowInfo[] rowInfos, ColumnInfo[] colInfos, Shape[][] shapeMatrix) {

        int xpos1 = 0;
        int ypos1 = 0;

        for (int i = 0; i < from.getColumn(); i++) {
            xpos1 += colInfos[i].getWidth();
        }

        for (int i = 0; i < from.getRow(); i++) {
            ypos1 += rowInfos[i].getHeight();
        }

        int fromRow = from.getRow();
        int fromColumn = from.getColumn();
        int toRow = to.getRow();
        int toColumn = to.getColumn();

        int fromWidth = colInfos[fromColumn].getWidth();
        Shape fromShape = shapeMatrix[fromRow][fromColumn];

        int anchor = connector.getStartAnchor();

        if (anchor == Connector.ANCHOR_NONE) {

            // Von unten nach oben
            if (fromRow > toRow && fromColumn == toColumn) {
                anchor = Connector.ANCHOR_NORTH;
            }

            // Von oben nach unten
            if (toRow > fromRow && fromColumn == toColumn) {
                anchor = Connector.ANCHOR_SOUTH;
            }

            // Von links nach rechts
            if (toColumn > fromColumn && fromRow == toRow) {
                anchor = Connector.ANCHOR_EAST;
            }

            // Von rechts nach links
            if (fromColumn > toColumn && fromRow == toRow) {
                anchor = Connector.ANCHOR_WEST;
            }

            // Von links unten nach rechts oben
            if (toColumn > fromColumn && toRow < fromRow) {

                /*
                 * int xdist = toColumn - fromColumn;
                 * 
                 * switch (xdist) { case 1: anchor =
                 * Connector.ANCHOR_NORTH_BY_EAST; break; case 2: anchor =
                 * Connector.ANCHOR_NORTH_NORTHEAST; break; case 3: anchor =
                 * Connector.ANCHOR_NORTHEAST_BY_NORTH; break; default: anchor =
                 * Connector.ANCHOR_NORTHEAST; break; }
                 */

                anchor = Connector.ANCHOR_NORTH_BY_EAST;
            }

            // Von links oben nach rechts unten
            if (toColumn > fromColumn && toRow > fromRow) {
                anchor = Connector.ANCHOR_SOUTH_SOUTHEAST;
            }

            // Von rechts unten nach links oben
            if (toColumn < fromColumn && toRow < fromRow) {

                /*
                 * int xdist = fromColumn - toColumn;
                 * 
                 * switch (xdist) { case 1: anchor =
                 * Connector.ANCHOR_NORTH_BY_WEST; break; case 2: anchor =
                 * Connector.ANCHOR_NORTH_NORTHWEST; break; case 3: anchor =
                 * Connector.ANCHOR_NORTHWEST_BY_NORTH; break; default: anchor =
                 * Connector.ANCHOR_NORTHWEST; break; }
                 */

                anchor = Connector.ANCHOR_NORTH_BY_WEST;
            }

            // Von rechts oben nach links unten
            if (toColumn < fromColumn && toRow > fromRow) {
                anchor = Connector.ANCHOR_SOUTH_SOUTHWEST;
            }

            connector.setStartAnchor(anchor);
        }

        // Die Windrose im Uhrzeigersinn

        // Nord
        if (anchor == Connector.ANCHOR_NORTH) {
            xpos1 += colInfos[from.getColumn()].getWidth() / 2;
            ypos1 += (rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2;
        }

        // Nord zu Ost
        if (anchor == Connector.ANCHOR_NORTH_BY_EAST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2) + arrowPadding;
            ypos1 += (rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2;
        }

        // Nord-Nordost
        if (anchor == Connector.ANCHOR_NORTH_NORTHEAST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2)
                    + (2 * arrowPadding);
            ypos1 += (rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2;
        }

        // Nordost zu Nord
        if (anchor == Connector.ANCHOR_NORTHEAST_BY_NORTH) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2)
                    + (3 * arrowPadding);
            ypos1 += (rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2;
        }

        // Nordost
        if (anchor == Connector.ANCHOR_NORTHEAST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2)
                    + (4 * arrowPadding);
            ypos1 += (rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2;
        }

        if (anchor == Connector.ANCHOR_EAST) {
            xpos1 += fromWidth - ((fromWidth - fromShape.getWidth()) / 2);
            ypos1 += rowInfos[fromRow].getHeight() / 2;
        }

        if (anchor == Connector.ANCHOR_SOUTH_SOUTHEAST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2) + arrowPadding;
            ypos1 += rowInfos[from.getRow()].getHeight() - cellPadding;
        }

        if (anchor == Connector.ANCHOR_SOUTH) {
            xpos1 += colInfos[fromColumn].getWidth() / 2;
            ypos1 += rowInfos[fromRow].getHeight()
                    - ((rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2);
        }

        if (anchor == Connector.ANCHOR_SOUTH_SOUTHWEST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2) + arrowPadding;
            ypos1 += rowInfos[from.getRow()].getHeight() - cellPadding;
        }

        if (anchor == Connector.ANCHOR_WEST) {
            xpos1 += (fromWidth - fromShape.getWidth()) / 2;
            ypos1 += rowInfos[fromRow].getHeight() / 2;
        }

        if (anchor == Connector.ANCHOR_NORTHWEST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2)
                    - (4 * arrowPadding);
            ypos1 += cellPadding;
        }

        if (anchor == Connector.ANCHOR_NORTHWEST_BY_NORTH) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2)
                    - (3 * arrowPadding);
            ypos1 += cellPadding;
        }

        if (anchor == Connector.ANCHOR_NORTH_NORTHWEST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2)
                    - (2 * arrowPadding);
            ypos1 += cellPadding;
        }

        if (anchor == Connector.ANCHOR_NORTH_BY_WEST) {
            xpos1 += (colInfos[from.getColumn()].getWidth() / 2) - arrowPadding;
            ypos1 += (rowInfos[fromRow].getHeight() - fromShape.getHeight()) / 2;
        }

        logger.debug("fromRow=" + fromRow + ", rowColum=" + fromColumn
                + ", toRow=" + toRow + ",toColumn=" + toColumn + ", anchor="
                + anchor);

        return new Point(xpos1, ypos1);
    }

    private Point calculateEndPoint(Connector connector, Cell from, Cell to,
            RowInfo[] rowInfos, ColumnInfo[] colInfos, Shape[][] shapeMatrix) {

        int ypos2 = 0;
        int xpos2 = 0;

        for (int i = 0; i < to.getColumn(); i++) {
            xpos2 += colInfos[i].getWidth();
        }

        for (int i = 0; i < to.getRow(); i++) {
            ypos2 += rowInfos[i].getHeight();
        }

        int fromRow = from.getRow();
        int fromColumn = from.getColumn();
        int toRow = to.getRow();
        int toColumn = to.getColumn();

        int toWidth = colInfos[toColumn].getWidth();
        Shape toShape = shapeMatrix[toRow][toColumn];

        int anchor = connector.getEndAnchor();

        if (anchor == Connector.ANCHOR_NONE) {

            // Von unten nach oben
            if (fromRow > toRow && fromColumn == toColumn) {
                anchor = Connector.ANCHOR_SOUTH;
            }

            // Von oben nach unten
            if (toRow > fromRow && fromColumn == toColumn) {
                anchor = Connector.ANCHOR_NORTH;
            }

            // Von links nach rechts
            if (toColumn > fromColumn && fromRow == toRow) {
                anchor = Connector.ANCHOR_WEST;
            }

            // Von rechts nach links
            if (fromColumn > toColumn && fromRow == toRow) {
                anchor = Connector.ANCHOR_EAST;
            }

            // Von links unten nach rechts oben
            if (toColumn > fromColumn && toRow < fromRow) {
                anchor = Connector.ANCHOR_SOUTH;
            }

            // Von links oben nach rechts unten
            if (toColumn > fromColumn && toRow > fromRow) {
                anchor = Connector.ANCHOR_NORTH;
            }

            // Von rechts unten nach links oben
            if (toColumn < fromColumn && toRow < fromRow) {
                anchor = Connector.ANCHOR_SOUTH;
            }

            // Von rechts oben nach links unten
            if (toColumn < fromColumn && toRow > fromRow) {
                anchor = Connector.ANCHOR_NORTH;
            }

            connector.setEndAnchor(anchor);
        }

        if (anchor == Connector.ANCHOR_SOUTH) {
            xpos2 += colInfos[toColumn].getWidth() / 2;
            ypos2 += rowInfos[toRow].getHeight()
                    - ((rowInfos[toRow].getHeight() - toShape.getHeight()) / 2);
        }

        if (anchor == Connector.ANCHOR_NORTH) {
            xpos2 += colInfos[to.getColumn()].getWidth() / 2;
            ypos2 += (rowInfos[toRow].getHeight() - toShape.getHeight()) / 2;
        }

        if (anchor == Connector.ANCHOR_WEST) {
            xpos2 += (toWidth - toShape.getWidth()) / 2;
            ypos2 += rowInfos[to.getRow()].getHeight() / 2;
        }

        if (anchor == Connector.ANCHOR_EAST) {
            xpos2 += toWidth - ((toWidth - toShape.getWidth()) / 2);
            ypos2 += rowInfos[to.getRow()].getHeight() / 2;
        }

        if (anchor == Connector.ANCHOR_SOUTH_SOUTHWEST) {
            xpos2 += (toWidth - toShape.getWidth()) / 2;
            ypos2 += (rowInfos[to.getRow()].getHeight() / 2) + arrowPadding;
        }

        if (anchor == Connector.ANCHOR_NORTH_NORTHWEST) {
            xpos2 += (toWidth - toShape.getWidth()) / 2;
            ypos2 += (rowInfos[to.getRow()].getHeight() / 2) + arrowPadding;
        }

        if (anchor == Connector.ANCHOR_SOUTH_SOUTHEAST) {
            xpos2 += toShape.getWidth() + ((toWidth - toShape.getWidth()) / 2);
            ypos2 += (rowInfos[to.getRow()].getHeight() / 2) + arrowPadding;
        }

        if (anchor == Connector.ANCHOR_NORTH_NORTHEAST) {
            xpos2 += toShape.getWidth() + ((toWidth - toShape.getWidth()) / 2);
            ypos2 += (rowInfos[to.getRow()].getHeight() / 2) + arrowPadding;
        }

        return new Point(xpos2, ypos2);
    }

    public void moveRight(Shape shape) {

        int row = shape.getRow();
        int column = shape.getColumn();
        
        for (Shape s : shapeList) {
            
            if (s.getRow() == row && s.getColumn() >= column) {
                s.moveRight();
            }
        }
    }
}
