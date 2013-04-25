package org.dbdoclet.xiphias.dom;

import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTraverser {

	private ArrayList<INodeVisitor> visitors = new ArrayList<INodeVisitor>();

    public DOMTraverser(INodeVisitor visitor) {
    	addVisitor(visitor);
    }
    
    public void addVisitor(INodeVisitor visitor) {
        visitors.add(visitor);
    }

    public void traverse(Node node) throws Exception {

    	if (node.getNodeType() == Node.ELEMENT_NODE) {
    		openTag(node);
    	}
    	
    	accept(node);
    	
        if ((node.getNodeType() == Node.ELEMENT_NODE) && node.hasAttributes()) {

        	NamedNodeMap attrs = ((Element) node).getAttributes();

            for (int i = 0; i < attrs.getLength(); i++) {
                Node attr = attrs.item(i);
                accept(attr);
            }
        }

        if (node.hasChildNodes()) {

        	NodeList children = node.getChildNodes();

            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                traverse(child);
            }
        }

        if (node.getNodeType() == Node.ELEMENT_NODE) {
    		closeTag(node);
    	}
    	
    }

    private void openTag(Node node) throws Exception {

    	for (INodeVisitor visitor : visitors) {
    		visitor.openTag(node);
        }
    }

    private void accept(Node node) throws Exception {

    	for (INodeVisitor visitor : visitors) {
    		visitor.accept(node);
        }
    }
    
    private void closeTag(Node node) throws Exception {

    	for (INodeVisitor visitor : visitors) {
    		visitor.closeTag(node);
        }
    }
}
