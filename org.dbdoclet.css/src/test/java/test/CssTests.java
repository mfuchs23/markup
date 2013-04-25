package test;

import org.dbdoclet.css.CssRuleMap;
import org.dbdoclet.service.ResourceServices;
import org.junit.Test;

public class CssTests {

    @Test
    public void test_1() {
        
        try {
            CssRuleMap ruleMap = CssRuleMap.parse(ResourceServices.getResourceAsString("/css/DocBook5_1.css"));
            System.out.println(ruleMap.printRuleMap());
        } catch (Exception oops) {
            oops.printStackTrace();
        }
    }
}
