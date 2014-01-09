package org.dbdoclet.test.svg;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;

import org.dbdoclet.svg.UmlClassDiagramCreator;
import org.dbdoclet.svg.shape.ClassBox;
import org.junit.Test;

public class UmlClassGeneratorTest {

    @Test
    public void testClass() {
     
        UmlClassDiagramCreator ucdc = new UmlClassDiagramCreator();
        ucdc.setFontSize(12);
        
        ucdc.addClassBox(0, 0, "UmlClassDiagramCreator");
        ucdc.drawImage();
        
        try {
            ucdc.saveAsPng(new File("build/ucdc.png"));
        } catch (Exception oops) {
            oops.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInterface() {
     
        UmlClassDiagramCreator ucdc = new UmlClassDiagramCreator();
        ucdc.setFontSize(12);
        
        ucdc.addClassBox(0, 0, "UmlClassDiagramCreator", "interface");
        ucdc.drawImage();
        
        try {
            ucdc.saveAsPng(new File("build/ucdc.png"));
        } catch (Exception oops) {
            oops.printStackTrace();
            fail();
        }
    }

    @Test
    public void testOperations() {
     
        UmlClassDiagramCreator ucdc = new UmlClassDiagramCreator();
        ucdc.setFontSize(12);
        
        ClassBox classBox = ucdc.addClassBox(0, 0, "UmlClassDiagramCreator");
        
        ucdc.addLine(classBox);
        ucdc.addAttribute(classBox, "name: String");
        ucdc.addLine(classBox);
        ucdc.addMethod(classBox, "+toString(): String");
        ucdc.addMethod(classBox, "+execute(arg0: String, arg1: String, arg2: String): void");
        ucdc.drawImage();
        
        try {
            ucdc.saveAsJpeg(new File("build/ucdc.jpg"));
        } catch (Exception oops) {
            oops.printStackTrace();
            fail();
        }
    }

    @Test
    public void testTemplateParameter() {
     
        UmlClassDiagramCreator ucdc = new UmlClassDiagramCreator();
        ucdc.setFontSize(12);
        
        ArrayList<String> typeParameters = new ArrayList<String>();
        typeParameters.add("E extends Comparable<? super E> & Serializable");
        typeParameters.add("F extends Serializable");
        ClassBox classBox = ucdc.addParameterizedClassBox(0, 0, "UmlClassDiagramCreator", typeParameters);
        
        ucdc.addLine(classBox);
        ucdc.addAttribute(classBox, "name: String");
        ucdc.addLine(classBox);
        ucdc.addMethod(classBox, "+toString(): String");
        ucdc.addMethod(classBox, "+execute(arg0: String, arg1: String, arg2: String): void");
        ucdc.scaleToWidth(800);
        ucdc.drawImage();
        
        try {
            ucdc.saveAsJpeg(new File("build/ucdc.jpg"));
        } catch (Exception oops) {
            oops.printStackTrace();
            fail();
        }
    }
}
