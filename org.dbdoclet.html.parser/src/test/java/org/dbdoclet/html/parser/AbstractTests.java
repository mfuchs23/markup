package org.dbdoclet.html.parser;

import static org.junit.Assert.fail;

import org.dbdoclet.tag.html.HtmlFragment;

public class AbstractTests {

	protected HtmlFragment parseFragment(String htmlCode) {
		
		try {
		
			HtmlParser parser = new HtmlParser();
			return parser.parseFragment(htmlCode);
		
		} catch (Exception oops) {
			oops.printStackTrace();
			fail("HTML parser failed");
		}
		
		return null;
	}
}
