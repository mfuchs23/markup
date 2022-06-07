/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 *
 * Author..........: mfuchs
 * Created at......: 2008-04-02
 * Last change.....: ((WRITESTAMP))
 */
package org.dbdoclet.svg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.dbdoclet.service.FileServices;
import org.dbdoclet.svg.shape.Connector;
import org.dbdoclet.svg.shape.Shape;
import org.dbdoclet.svg.shape.TextUnit;
import org.dbdoclet.svg.shape.g2d.Arrow2D;
import org.dbdoclet.svg.shape.g2d.ProcessArrow;
import org.dbdoclet.svg.shape.g2d.ProcessEndArrow;
import org.dbdoclet.svg.shape.g2d.ProcessStartArrow;
import org.dbdoclet.svg.shape.g2d.TextBox2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

public class Svg2DCanvas extends SvgCanvas {

    private SVGGraphics2D g2d;

    public Svg2DCanvas() {

        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document document = domImpl.createDocument(SvgConstants.SVGNS, "svg", null);

        g2d = new SVGGraphics2D(document);
        g2d.setBackground(Color.white);

        font = new Font("SansSerif", Font.BOLD, 12);
        g2d.setFont(font);
        g2d.getFontMetrics();

        shapeList = new ArrayList<Shape>();
        connectorList = new ArrayList<Connector>();
    }

    public Graphics2D getGraphics2D() {
        return g2d;
    }

    public void setImageSize(int imageWidth, int imageHeight, int scaledWidth, int scaledHeight) {

        if (scaledWidth > 0 && scaledWidth < imageWidth) {

            double factor = (double) scaledWidth / (double) imageWidth;
            
            g2d.scale(factor, factor);
            
            g2d.setSVGCanvasSize(new Dimension(scaledWidth, scaledHeight));
            g2d.clearRect(0, 0, imageWidth, imageHeight);
            
        } else {
            
            g2d.setSVGCanvasSize(new Dimension(imageWidth, imageHeight));
            g2d.clearRect(0, 0, imageWidth, imageHeight);
        }
    }
    
    public void addTextBox(String id, int row, int col, String text) {

        shapeList.add(new TextBox2D(g2d, id, row, col, new TextUnit(text)));
    }

    public void addArrow(String id, Shape from, Shape to) {
        connectorList.add(new Arrow2D(g2d, id, from, to));
    }

    public void addProcessStartArrow(String id, int row, int col, String text) {

        ProcessStartArrow psa = new ProcessStartArrow(g2d, id, row, col, text);
        psa.setBackgroundColor(boxBackgroundColor);
        psa.setForegroundColor(foregroundColor);

        shapeList.add(psa);
    }

    public void addProcessArrow(String id, int row, int col, String text) {

        Shape pa = new ProcessArrow(g2d, id, row, col, text);
        pa.setBackgroundColor(boxBackgroundColor);
        pa.setForegroundColor(foregroundColor);

        shapeList.add(pa);
    }

    public void addProcessArrow(Shape pa) {
   
        pa.setGraphics2D(g2d);
        shapeList.add(pa);
    }

    public void addProcessEndArrow(String id, int row, int col, String text) {

        ProcessEndArrow pea = new ProcessEndArrow(g2d, id, row, col, text);
        pea.setBackgroundColor(boxBackgroundColor);
        pea.setForegroundColor(foregroundColor);

        shapeList.add(pea);
    }

    public void save(File file) throws IOException {

        drawImage();

        boolean useCSS = true;

        FileOutputStream fos = new FileOutputStream(file);
        Writer out = new OutputStreamWriter(fos, "UTF-8");
        g2d.stream(out, useCSS);
        fos.close();
    }

    public void saveAsPng(File file) throws IOException, SvgException {

        drawImage();

        boolean useCSS = true;

        File tempFile = File.createTempFile("svgImage", "svg");

        FileOutputStream fos = new FileOutputStream(tempFile);
        Writer out = new OutputStreamWriter(fos, "UTF-8");
        g2d.stream(out, useCSS);
        fos.close();

        PNGTranscoder transcoder = new PNGTranscoder();
        TranscoderInput input = new TranscoderInput(tempFile.toURI().toURL().toString());

        OutputStream ostream = new FileOutputStream(file);
        TranscoderOutput output = new TranscoderOutput(ostream);

        try {
            transcoder.transcode(input, output);
        } catch (TranscoderException oops) {
            throw new SvgException(oops);
        } finally {
            FileServices.delete(tempFile);
        }

        ostream.flush();
        ostream.close();
    }
}
