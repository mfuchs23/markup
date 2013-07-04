package org.dbdoclet.html.parser;

import java.io.IOException;

import org.dbdoclet.service.ResourceServices;
import org.junit.Ignore;
import org.junit.Test;

public class CommentTests extends AbstractTests {

	@Test
	public void testComment_1()  {
		parseFragment("<!-- Kommentar -->");
	}

	@Test
	@Ignore
	public void testComment_2()  {
		parseFragment("<!---------- -->");
	}

	@Test
	public void testInvalidEscapeCharacter() throws IOException {

		String buffer = ResourceServices
				.getResourceAsString("html/InvalidEscapeCharacterInComment.html");
		parseFragment(buffer);
	}
}
