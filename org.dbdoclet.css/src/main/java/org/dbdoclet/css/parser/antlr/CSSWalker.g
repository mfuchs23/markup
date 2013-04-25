tree grammar CSSWalker;

options {
	tokenVocab = CSS;
	ASTLabelType = CommonTree;	
}

@header {
package org.dbdoclet.css.parser.antlr;

import java.util.*;
import org.antlr.runtime.BitSet;
import org.dbdoclet.css.*;
}

@members {
	HashMap<CssSelector, ArrayList<CssProperty<?>>> ruleMap = new HashMap<CssSelector, ArrayList<CssProperty<?>>>();
}

parse returns [HashMap<CssSelector, ArrayList<CssProperty<?>>> map]
: rule+ EOF
{
	$map = ruleMap;
};

rule
@init {
	ArrayList<CssProperty<?>> propertyList = new ArrayList<CssProperty<?>>();
}
: ^(RULE s=selector (p=property { propertyList.add($p.property); })*) 
{
	ruleMap.put($s.selector, propertyList);
};

selector returns [CssSelector selector]
	: ^(SELECTOR (s+=(WORD|UNIVERSAL_SELECTOR))+)
	{ $selector = new CssSelector($s); };
	
property returns [CssProperty property]
	:  ^(PROPERTY (p+=WORD)+) { $property = CssProperty.newInstance($p); };
	
	