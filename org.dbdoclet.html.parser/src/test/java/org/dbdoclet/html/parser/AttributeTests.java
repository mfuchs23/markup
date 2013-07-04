package org.dbdoclet.html.parser;

import org.dbdoclet.tag.html.HtmlFragment;
import org.junit.Test;

public class AttributeTests extends AbstractTests {

    @Test
    public void testAttributeNoQuotes() {
       parseFragment("<h1 align=center>Titel</h1>");
    }
    @Test
    public void testAttributeTrHeightZero()  {
       HtmlFragment fragment = parseFragment("<table><tr height=0><td>A</td></tr></table>");
    }
}
