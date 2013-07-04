package org.dbdoclet.html.parser;

import org.junit.Test;

public class EmTests extends AbstractTests {

    @Test
    public void testSubscript_1()  {
       parseFragment("<sub><em>i</em></sub>");
    }

    @Test
    public void test_2() {
       parseFragment("<em>emphasis</em> ist toll!");
    }
}
