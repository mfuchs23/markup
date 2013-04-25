package org.dbdoclet.css;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.dbdoclet.css.parser.antlr.CSSLexer;
import org.dbdoclet.css.parser.antlr.CSSParser;
import org.dbdoclet.css.parser.antlr.CSSWalker;
import org.w3c.dom.Element;

public class CssRuleMap {

	private final HashMap<CssSelector, ArrayList<CssProperty<?>>> ruleMap;

	public CssRuleMap(HashMap<CssSelector, ArrayList<CssProperty<?>>> ruleMap) {
		this.ruleMap = ruleMap;
	}

	public String printRuleMap() {

		StringBuilder buffer = new StringBuilder();

		for (CssSelector selector : ruleMap.keySet()) {

			buffer.append(selector);
			buffer.append('\n');

			ArrayList<CssProperty<?>> propertyList = ruleMap.get(selector);

			if (propertyList != null) {
				for (CssProperty<?> property : propertyList) {

					buffer.append('\t');
					buffer.append(property);
					buffer.append('\n');
				}
			}
		}

		return buffer.toString();
	}

	public static CssRuleMap parse(String cssCode)
			throws UnsupportedEncodingException, RecognitionException {

		if (cssCode == null) {
			return new CssRuleMap(
					new HashMap<CssSelector, ArrayList<CssProperty<?>>>());
		}

		CSSLexer lexer = new CSSLexer(new ANTLRStringStream(cssCode));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CSSParser parser = new CSSParser(tokens);
		CommonTree tree = (CommonTree) parser.parse().getTree();
		System.out.println(tree.toStringTree());
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
		CSSWalker walker = new CSSWalker(nodes);
		HashMap<CssSelector, ArrayList<CssProperty<?>>> map = walker.parse();

		return new CssRuleMap(map);
	}

	public ArrayList<CssProperty<?>> getRules(Element element) {

		HashMap<String, CssProperty<?>> elemRuleMap = new HashMap<String, CssProperty<?>>();

		ArrayList<CssProperty<?>> ruleList = ruleMap.get(new CssSelector("*"));
		loadRules(elemRuleMap, ruleList);

		ruleList = ruleMap.get(new CssSelector(element.getTagName()));
		loadRules(elemRuleMap, ruleList);

		ruleList = new ArrayList<CssProperty<?>>();

		for (CssProperty<?> rule : elemRuleMap.values()) {
			ruleList.add(rule);
		}

		return ruleList;
	}

	private void loadRules(HashMap<String, CssProperty<?>> elemRuleMap,
			ArrayList<CssProperty<?>> ruleList) {
		if (ruleList != null) {
			for (CssProperty<?> rule : ruleList) {
				elemRuleMap.put(rule.getName(), rule);
			}
		}
	}
}
