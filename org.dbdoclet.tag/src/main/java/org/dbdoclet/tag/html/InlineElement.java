/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.html;

import java.util.HashMap;

import org.dbdoclet.xiphias.dom.TextImpl;
import org.w3c.dom.Node;

abstract public class InlineElement extends HtmlElement {

    @Override
	protected boolean validate(HashMap<String, HashMap<String, String>> validParentMap) {

	if (validParentMap == null) {

	    throw new IllegalArgumentException("Parameter validParentMap is null!");
	}

	if (getParentNode() == null) {

	    throw new NullPointerException("Variable getParent() is null!");
	}

	if (nodeStack == null) {

	    throw new NullPointerException("Variable nodeStack is null!");
	}

	nodeStack.removeAllElements();
	nodeStack.push(this);

	if (validParentMap.get(getParentNode().getNodeName()) != null) {
	    return true;
	}

	if (getParentNode() instanceof Fieldset) {

	    Node child = getParentNode().getFirstChild();

	    if ((child == null) || !(child instanceof Legend)) {

		Legend legend = new Legend();
		getParentNode().appendChild(legend);

		legend.appendChild(new TextImpl("Legend", legend));
	    }

	    return true;
	}

	if (getParentNode() instanceof Select) {

	    nodeStack.removeAllElements();

	    Option option = new Option();
	    nodeStack.push(option);

	    return true;
	}

	if (getParentNode() instanceof Optgroup) {

	    nodeStack.removeAllElements();

	    Option option = new Option();
	    nodeStack.push(option);

	    return true;
	}

	if (getParentNode() instanceof Dl) {

	    Dd dd = new Dd();
	    dd.appendChild(this);

	    nodeStack.push(dd);

	    return true;
	}

	if (getParentNode() instanceof Dir || getParentNode() instanceof Menu || getParentNode() instanceof Ol
	    || getParentNode() instanceof Ul) {

	    Li li = new Li();
	    li.appendChild(this);

	    nodeStack.push(li);

	    return true;
	}

	if (getParentNode() instanceof Table) {

	    Tr tr = new Tr();
	    Td td = new Td();
	    tr.appendChild(td);
	    td.appendChild(this);

	    nodeStack.push(td);
	    nodeStack.push(tr);

	    return true;
	}

	if (getParentNode() instanceof Tbody || getParentNode() instanceof Tfoot
	    || getParentNode() instanceof Thead) {

	    Tr tr = new Tr();
	    Td td = new Td();
	    tr.appendChild(td);
	    td.appendChild(this);

	    nodeStack.push(td);
	    nodeStack.push(tr);

	    return true;
	}

	if (getParentNode() instanceof Tr) {

	    Td td = new Td();
	    td.appendChild(this);

	    nodeStack.push(td);

	    return true;
	}

	if (getParentNode() instanceof Map) {

	    Div div = new Div();
	    div.appendChild(this);

	    nodeStack.push(div);

	    return true;
	}

	return false;
    }
}
