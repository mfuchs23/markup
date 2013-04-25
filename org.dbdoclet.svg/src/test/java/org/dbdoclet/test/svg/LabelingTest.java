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

public class LabelingTest {

	private ProcessDiagramCreator pdc;

	@Before
	public void setUp() throws Exception {
		pdc = new ProcessDiagramCreator();
		FileServices.createPath("build/test");
	}

	@Test
	public void testLabel_1() {

		Activity start = pdc.setStart("start", "Start");
		start.setCondition("Ja start");
		
		Activity a1 = pdc.addActivity("a_1", "Aktivität 1");
		a1.setCondition("Ja a_1");
		
		Activity a_1_1 = pdc.addAlternative("b1", "a_1_1", "start", "Alternative 1");
		a_1_1.setCondition("Ja a_1_1");
		
		pdc.drawImage();
		File pngFile = new File("build/test/TestLabel_1.png");
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
