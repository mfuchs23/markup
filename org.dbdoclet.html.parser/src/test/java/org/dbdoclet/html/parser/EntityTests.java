package org.dbdoclet.html.parser;

import org.junit.Test;

public class EntityTests extends AbstractTests {

	@Test
	public void testLe() {
		parseFragment("<p>Der Bereich ist &le; 10<p>");
	}
}
