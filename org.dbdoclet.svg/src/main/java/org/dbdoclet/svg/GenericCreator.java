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

public class GenericCreator {

    private Svg2DCanvas img;
    
    public GenericCreator() {

        img = new Svg2DCanvas();
        img.setCellPadding (20);

        new Font("SansSerif", Font.PLAIN, 9);
        new Font("SansSerif", Font.BOLD, 9);
    }

    public void drawImage() {
        img.drawImage();
    }
    
    public void scaleToWidth(int width) {
        img.scaleToWidth(width);
    }
    
    public void save(File file) 
        throws IOException, 
               SvgException {

        if (file == null) {
            throw new IllegalArgumentException("The argument file must not be null!");
        }

        img.save(file);
    }

    public void saveAsPng(File file) 
        throws IOException, 
               SvgException {

        if (file == null) {
            throw new IllegalArgumentException("The argument file must not be null!");
        }

        img.saveAsPng(file);
    }

    public static void main(String[] args)
        throws Exception {

        GenericCreator gc = new GenericCreator();
        gc.saveAsPng(new File("/home/mfuchs/tmp/tag.png"));
    }
}
