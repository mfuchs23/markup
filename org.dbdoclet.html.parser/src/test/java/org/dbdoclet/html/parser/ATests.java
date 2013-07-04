package org.dbdoclet.html.parser;

import static org.junit.Assert.*;

import org.dbdoclet.tag.html.HtmlFragment;
import org.dbdoclet.xiphias.NodeSerializer;
import org.junit.Test;

public class ATests extends AbstractTests {

    @Test
    public void anchorWithDoubleQuotes() {
        HtmlFragment fragment = parseFragment("<a href=\"href\"/>");
        String buffer = NodeSerializer.toXML(fragment);
        assertEquals("<a href=\"href\"/>", buffer);
    }

    @Test
    public void anchorWithQuotes() {
        HtmlFragment fragment = parseFragment("<a href=\"href'\"/>");
        String buffer = NodeSerializer.toXML(fragment);
        assertEquals("<a href=\"href&apos;\"/>", buffer);
    }

    @Test
    public void embeddedAnchor() {
        HtmlFragment fragment = parseFragment("<p>Link <a href='href'/> nach...");
        String buffer = NodeSerializer.toXML(fragment);
        assertEquals("<p>Link <a href=\"href\"/> nach...</p>\n", buffer);
    }

    @Test
    public void anchorWithQuery() {
        parseFragment("<a href=http://www.dbdoclet.org?arg1=x&arg2=y />");
    }
}
