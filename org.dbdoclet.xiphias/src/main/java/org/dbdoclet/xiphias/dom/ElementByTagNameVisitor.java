package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ElementByTagNameVisitor implements INodeVisitor {

    private final String tagName;
    private NodeListImpl elementList;
    
    public NodeListImpl getElementList() {
        return elementList;
    }
    
    public ElementByTagNameVisitor(String tagName) {
    
        this.tagName = tagName;
        elementList = new NodeListImpl();
    }
    

    public void accept(Node node) {

        if (node == null || node instanceof Element == false) {
            return;
        }

        Element element = (Element) node;
        String otherTagName = element.getTagName();
    
        if (tagName != null && otherTagName != null) {
            if (tagName.equals(otherTagName)) {
                elementList.add((NodeImpl) element);
            }
        }
    }

	@Override
	public void openTag(Node node) {
		// 
	}

	@Override
	public void closeTag(Node node) {
		// 
	} 

}
