package org.dbdoclet.html.parser;

import org.junit.Test;

public class TtTests extends AbstractTests {

    @Test
    public void test_1()  {
       parseFragment("<tt>Literal</tt>s with trailing text.");
    }
}
