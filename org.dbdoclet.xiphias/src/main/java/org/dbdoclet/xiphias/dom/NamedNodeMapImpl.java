package org.dbdoclet.xiphias.dom;

import java.util.LinkedHashMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class NamedNodeMapImpl extends LinkedHashMap<String, Node> implements NamedNodeMap {

    private static final long serialVersionUID = 1L;

    public int getLength() {
        return size();
    }

    public Node getNamedItem(String name) {
        return get(name);
    }

    public Node getNamedItemNS(String namespaceURI, String localName) throws DOMException {
        return get(namespaceURI + ":" + localName);
    }

    public Node item(int index) {

        Node[] nodes = values().toArray(new Node[0]);
        
        if (nodes == null || index >= nodes.length || index < 0) {
            return null;
        }
        
        return nodes[index];
    }

    public Node removeNamedItem(String name) throws DOMException {
        return remove(name);
    }

    public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
        return remove(namespaceURI + ":" + localName);
    }

    public Node setNamedItem(Node node) throws DOMException {

        put(node.getLocalName(), node);
        return node;
    }

    public Node setNamedItemNS(Node node) throws DOMException {

        String namespace = node.getNamespaceURI();
        put(namespace + ":" + node.getLocalName(), node);

        return node;
    }

}
