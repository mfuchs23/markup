package org.dbdoclet.html.parser;

import org.dbdoclet.tag.html.HtmlFragment;
import org.dbdoclet.xiphias.NodeSerializer;
import org.junit.Test;

public class QuoteTests extends AbstractTests {

    @Test
    public void testQuote_1()  {
       HtmlFragment frag = parseFragment("<p>Da \"<b>Fett</b>\"</p><p>WEG!!!</p>");
       System.out.println(frag.treeView());
    }

    @Test
    public void testQuote_2() {
       HtmlFragment frag = parseFragment("<p>Nach Hochkomma ' kann mit dem Zeichen</p>");
       System.out.println(frag.treeView());
       System.out.println(NodeSerializer.toXML(frag));
    }

    @Test
    public void testLt_1()  {
       HtmlFragment frag = parseFragment("<p a='2>1'>Test</p>");
       System.out.println(frag.treeView());
    }

    @Test
    public void testLt_2()  {
       HtmlFragment frag = parseFragment("Adresse <Name, Vorname>");
       System.out.println(frag.treeView());
    }

    @Test
    public void testLt_3()  {
       HtmlFragment frag = parseFragment("Adresse 2<5 <b>Fett</b>");
       System.out.println(frag.treeView());
    }

}
