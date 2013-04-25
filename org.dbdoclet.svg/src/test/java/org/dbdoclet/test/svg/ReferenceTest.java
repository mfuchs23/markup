package org.dbdoclet.test.svg;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.svg.Activity;
import org.dbdoclet.svg.ProcessDiagramCreator;
import org.dbdoclet.svg.SvgException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests der Referenz auf andere Prozessdiagramme.
 * 
 * @author michael
 */
public class ReferenceTest {

	private ProcessDiagramCreator pdc;
	private File pngFile;

	@Before
	public void setUp() throws Exception {
		pdc = new ProcessDiagramCreator();
		pdc.setTraceEnabled(true);
		FileServices.createPath("build/test");
	}

	@After
	public void tearDown() {
		
		pdc.drawImage();
		try {
			pdc.saveAsPng(pngFile);
		} catch (IOException oops) {
			oops.printStackTrace();
			fail();
		} catch (SvgException oops) {
			oops.printStackTrace();
			fail();
		}

		System.out.println(pdc.getTraceLog());
	}
	
	/**
	 * Einfacher Test einer Referenz im Hauptast.
	 */
	@Test
	public void testReference_1() {

		pngFile = new File("build/test/Reference_1.png");
		pdc.setStart("start", "Start");
		pdc.addActivity("a_1", "Aktivität 1");
		pdc.addReference("r_1", "Referenz");

	}
	
	@Test
	public void testReference_2() {
		
		pngFile = new File("build/test/Reference_2.png");
		Activity activity = pdc.setStart("1", "1");
		activity = pdc.addActivity("2.1", "2.1");
		activity = pdc.addActivity("3", "3");
		activity = pdc.addActivity("4", "4");
	}
}
