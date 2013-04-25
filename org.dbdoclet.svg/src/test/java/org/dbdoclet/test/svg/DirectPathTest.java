package org.dbdoclet.test.svg;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.svg.Activity;
import org.dbdoclet.svg.ProcessDiagramCreator;
import org.dbdoclet.svg.SvgException;
import org.junit.Before;
import org.junit.Test;

public class DirectPathTest {

	private ProcessDiagramCreator pdc;

	@Before
	public void setUp() throws Exception {

		pdc = new ProcessDiagramCreator();
		FileServices.createPath("build/test");
	}

	@Test
	public void testDirectPath_1() {

		pdc.setStart("start", "Kaffee kochen");
		Activity a1 = pdc.addActivity("a1", "Kaffee einfüllen");
		pdc.addActivity("a2", "Kaffeemaschine einschalten");
		Activity a3 = pdc.addActivity("a3", "Kaffee trinken");
		pdc.addConnection("d1", a1.getId(), a3.getId(),
				"Gerät bereits eingeschalten");
		Activity ende = pdc.addEnd("ende", "Ende");

		pdc.addConnection("d2", a3.getId(), ende.getId(), "Ende");

		pdc.drawImage();

		File pngFile = new File("build/test/TestDirectPath_1.png");
		System.out.print(pngFile.getAbsolutePath());

		try {
			pdc.saveAsPng(pngFile);
		} catch (IOException oops) {
			oops.printStackTrace();
			fail();
		} catch (SvgException oops) {
			oops.printStackTrace();
			fail();
		}
	}

	@Test
	public void testDirectPath_2() {

		pdc.setStart("start", "Start");
		
		Activity a1 = pdc.addActivity("a1", "Aktivität #1");
		Activity ende = pdc.addEnd("ende", "Ende");
		
		pdc.addConnection("d1", a1.getId(), ende.getId(),
				"Gerät bereits eingeschalten");
		
		pdc.drawImage();

		File pngFile = new File("build/test/TestDirectPath_2.png");
		
		System.out.print(pngFile.getAbsolutePath());
		try {
			pdc.saveAsPng(pngFile);
		} catch (IOException oops) {
			oops.printStackTrace();
			fail();
		} catch (SvgException oops) {
			oops.printStackTrace();
			fail();
		}
	}
}
