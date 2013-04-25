package org.dbdoclet.test.svg;

import static org.junit.Assert.fail;

import java.io.File;

import org.dbdoclet.svg.UmlClassDiagramCreator;
import org.junit.Test;

public class UmlClassGeneratorTest {

    @Test
    public void testScale_1() {
     
        UmlClassDiagramCreator ucdc = new UmlClassDiagramCreator();
        ucdc.setFontSize(12);
        
        ucdc.addClassBox(0, 0, "UmlClassDiagramCreator");
        ucdc.scaleToWidth(400);
        ucdc.drawImage();
        
        try {
            ucdc.saveAsPng(new File("build/ucdc.png"));
        } catch (Exception oops) {
            oops.printStackTrace();
            fail();
        }
    }
}
