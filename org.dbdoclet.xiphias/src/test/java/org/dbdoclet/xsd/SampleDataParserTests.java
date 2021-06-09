package org.dbdoclet.xsd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.dbdoclet.xsd.sage.SampleData;
import org.junit.jupiter.api.Test;

public class SampleDataParserTests {

	@Test
	public void testParseUnique() {
	
		try {
			
			SampleData data = new SampleData("OPTIONS unique=true DATA data1\n data2\n");
			
			for (String value : data.getValues()) {
				System.out.println(value);
			}
			
		} catch (Throwable oops) {
			oops.printStackTrace();
			fail();
		}
	}

	@Test
	public void testParseFollows() {
	
		try {
			
			SampleData data = new SampleData("OPTIONS follows=NormierteID DATA data1\n data2\n");
			assertTrue(data.isFollowsEnabled());
			assertEquals("NormierteID", data.getOption("follows"));
			
		} catch (Throwable oops) {
			oops.printStackTrace();
			fail();
		}
	}
}
