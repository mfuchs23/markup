/* 
 * $Id$
 *
 * ### Copyright (C) 2005 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 *
 * RCS Information
 * Author..........: $Author$
 * Date............: $Date$
 * Revision........: $Revision$
 * State...........: $State$
 */
package org.dbdoclet.xiphias;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathServices {

    public static Object getValue(Object contextBean, String query) {
        return getValue(contextBean, null, null, query);
    }

    /**
	 * Die Methode <code>getValue</code> liefert den Wert eines Kontent.
	 * 
	 * @param contextBean <code>Object</code>
	 * @param query       <code>String</code>
	 * @return <code>Object</code>
	 * @throws XPathExpressionException
	 */
    public static Object getValue(Object contextBean, String namespace, String namespaceUrl, String query) {

        Object obj = null;

        XPathExpression expression = createExpression(namespace, namespaceUrl, query);
        try {
			obj = expression.evaluate(contextBean, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return null;
		}

        return obj;
    }

	private static XPathExpression createExpression(String namespace, String namespaceUrl, String query) {
		
		XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        xp.setNamespaceContext(new NamespaceContext() {

			@Override
			public String getNamespaceURI(String prefix) {
				return namespaceUrl;
			}

			@Override
			public String getPrefix(String namespaceURI) {
				return namespace;
			}

			@Override
			public Iterator<String> getPrefixes(String namespaceURI) {
				ArrayList<String> ns = new ArrayList<>();
				ns.add(namespace);
				return ns.iterator();
			}
        	
        });

        XPathExpression expression = null;
		try {
			expression = xp.compile(query);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
		return expression;
	}

    public static ArrayList<String> getValues(Object contextBean, String query) {
        return getValues(contextBean, null, null, query);
    }

    public static ArrayList<String> getValues(Object contextBean, String namespace, String namespaceUrl, String query) {

        XPathExpression expression = createExpression(namespace, namespaceUrl, query);
        NodeList nodeList = null;
        ArrayList<String> list = new ArrayList<>();

        try {
			nodeList = (NodeList) expression.evaluate(contextBean, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return list;
		}
        
        for (int i=0; i<nodeList.getLength(); i++) {
        	list.add(nodeList.item(i).toString());
        }

        return list;
    }

    public static ArrayList<Node> getNodes(Object contextBean, String query) {

        return getNodes(contextBean, null, null, query);
    }

    public static ArrayList<Node> getNodes(Object contextBean, String namespace, String namespaceUrl, String query) {

    	ArrayList<Node> nodeArray = new ArrayList<Node>();

    	XPathExpression expression = createExpression(namespace, namespaceUrl, query);
        if (isNull(expression)) {
        	return nodeArray;
        }
        
    	NodeList nodeList;
		try {
			nodeList = (NodeList) expression.evaluate(contextBean, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
			return nodeArray;
		}


        for (int i=0; i<nodeList.getLength(); i++) {
        	nodeArray.add(nodeList.item(i));
        }

        return nodeArray;
    }

    public static Node getNode(Object contextBean, String query) {
        return getNode(contextBean, null, null, query);
    }

    public static Node getNode(Object contextBean, String namespace, String namespaceUrl, String query) {

        ArrayList<Node> list = getNodes(contextBean, namespace, namespaceUrl, query);

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
