package org.dbdoclet.html.parser;

import static org.junit.Assert.assertEquals;

import org.dbdoclet.tag.html.HtmlFragment;
import org.dbdoclet.xiphias.NodeSerializer;
import org.junit.Test;

public class TextTests extends AbstractTests {

    @Test
    public void pureShortText() {
       
    	HtmlFragment fragment = parseFragment("String");
    	String buffer = new NodeSerializer().toXML(fragment);
    	assertEquals("String", buffer);
    }
}
