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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.jxpath.CompiledExpression;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;

public class XPathServices {

    private static Log logger = LogFactory.getLog(XPathServices.class);

    public static Object getValue(Object contextBean, String query) {
        return getValue(contextBean, null, null, query);
    }

    /**
     * Die Methode <code>getValue</code> liefert den Wert eines Kontent.
     * 
     * @param contextBean
     *            <code>Object</code>
     * @param query
     *            <code>String</code>
     * @return <code>Object</code>
     */
    public static Object getValue(Object contextBean, String namespace, String namespaceUrl, String query) {

        Object obj = null;

        JXPathContext context = JXPathContext.newContext(contextBean);

        if (namespace != null && namespaceUrl != null) {
            context.registerNamespace(namespace, namespaceUrl);
        }

        CompiledExpression expr = JXPathContext.compile(query);

        try {

            obj = expr.getValue(context);

        } catch (JXPathException oops) {

            logger.debug("JXPathException: " + oops.getMessage());
            obj = null;
        }

        return obj;
    }

    public static ArrayList<String> getValues(Object contextBean, String query) {
        return getValues(contextBean, null, null, query);
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<String> getValues(Object contextBean, String namespace, String namespaceUrl, String query) {

        Object obj = null;

        JXPathContext context = JXPathContext.newContext(contextBean);

        if (namespace != null && namespaceUrl != null) {
            context.registerNamespace(namespace, namespaceUrl);
        }

        CompiledExpression expr = JXPathContext.compile(query);

        Iterator<Object> iterator;
        ArrayList<String> list = new ArrayList<String>();

        try {

            // Unchecked iterator
            iterator = expr.iterate(context);

            while (iterator.hasNext()) {

                obj = iterator.next();

                if (obj != null) {
                    list.add(obj.toString());
                }
            }

        } catch (JXPathException oops) {

            oops.printStackTrace();
        }

        return list;
    }

    public static ArrayList<Node> getNodes(Object contextBean, String query) {

        return getNodes(contextBean, null, null, query);
    }

    public static ArrayList<Node> getNodes(Object contextBean, String namespace, String namespaceUrl, String query) {

        JXPathContext context = JXPathContext.newContext(contextBean);

        if (namespace != null && namespaceUrl != null) {
            context.registerNamespace(namespace, namespaceUrl);
        }

        List<?> list = context.selectNodes(query);

        ArrayList<Node> nodeList = new ArrayList<Node>();

        for (Object obj : list) {

            if (obj instanceof Node) {
                nodeList.add((Node) obj);
            }
        }

        return nodeList;
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
