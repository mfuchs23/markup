package org.dbdoclet.css.parser.jjt;

import java.util.ArrayList;
import java.util.HashMap;

import org.dbdoclet.css.CssDisplay;
import org.dbdoclet.css.CssFontSize;
import org.dbdoclet.css.CssFontWeight;
import org.dbdoclet.css.CssMarginBottom;
import org.dbdoclet.css.CssMarginTop;
import org.dbdoclet.css.CssProperty;
import org.dbdoclet.css.CssSelector;
import org.dbdoclet.css.CssTextAlign;

public class CssParserVisitorImpl implements CssParserVisitor {

    private static HashMap<String, Class<?>> RULE_CLASS_MAP = new HashMap<String, Class<?>>() {
        private static final long serialVersionUID = 1L;
        {
            put("display", CssDisplay.class);
            put("font-size", CssFontSize.class);
            put("font-weight", CssFontWeight.class);
            put("margin-bottom", CssMarginBottom.class);
            put("margin-top", CssMarginTop.class);
            put("text-align", CssTextAlign.class);
        }
    };
    
    private HashMap<CssSelector, ArrayList<CssProperty<?>>> ruleMap;
    private ArrayList<CssProperty<?>> ruleList;
    private CssProperty<?> rule;

    public CssParserVisitorImpl() {
        ruleMap = new HashMap<CssSelector, ArrayList<CssProperty<?>>>();
    }

    public HashMap<CssSelector, ArrayList<CssProperty<?>>> getRuleMap() {
        return ruleMap;
    }

    public void traverse(SimpleNode node) {

        for (int i = 0; i < node.jjtGetNumChildren(); i++) {

            SimpleNode sn = (SimpleNode) node.jjtGetChild(i);
            sn.jjtAccept(this, null);
            traverse(sn);
        }
    }

    public Object visit(NodeRuleName node, Object data) {

        String name = node.getValue();

        Class<?> ruleClass = RULE_CLASS_MAP.get(name);
        
        if (ruleClass != null) {
            try {
                rule = (CssProperty<?>) ruleClass.newInstance();
                return rule;
            } catch (InstantiationException oops) {
                oops.printStackTrace();
            } catch (IllegalAccessException oops) {
                oops.printStackTrace();
            }
        }

        rule = null;
        return rule;
    }

    public Object visit(NodeRuleValue node, Object data) {

        if (rule != null) {
            rule.appendValue(node.getValue());
            ruleList.add(rule);
        }
        
        return null;
    }

    public Object visit(NodeSelector node, Object data) {

        CssSelector selector = new CssSelector(node.getValue());
        ruleList = new ArrayList<CssProperty<?>>();
        ruleMap.put(selector, ruleList);

        return null;
    }

    public Object visit(NodeStart node, Object data) {
        return null;
    }

    public Object visit(SimpleNode node, Object data) {
        return null;
    }

}
