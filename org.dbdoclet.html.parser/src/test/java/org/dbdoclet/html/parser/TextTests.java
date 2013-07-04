package org.dbdoclet.html.parser;

import static org.junit.Assert.*;

import org.dbdoclet.tag.html.HtmlFragment;
import org.dbdoclet.xiphias.NodeSerializer;
import org.junit.Test;

public class TextTests extends AbstractTests {

    @Test
    public void pureShortText() {
       
    	HtmlFragment fragment = parseFragment("String");
    	String buffer = NodeSerializer.toXML(fragment);
    	assertEquals("String", buffer);
    }
}
