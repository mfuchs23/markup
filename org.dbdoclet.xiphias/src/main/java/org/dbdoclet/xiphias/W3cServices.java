package org.dbdoclet.xiphias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class W3cServices {

    public static Element getChildElement(Element parent, String childName) {

        if (parent == null) {
            throw new IllegalArgumentException("The argument parent may not be null!");
        }

        if (childName == null) {
            throw new IllegalArgumentException("The argument childName may not be null!");
        }

        Element element = null;
        String nodeName = null;

        NodeList childNodes = parent.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            if (childNodes.item(i) instanceof Element) {

                element = (Element) childNodes.item(i);
                nodeName = element.getNodeName();

                if (nodeName != null && nodeName.equals(childName)) {
                    return element;
                }
            }
        }

        return null;
    }

    public static List<Element> getChildElements(Element parent, String childName) {

        if (parent == null) {
            throw new IllegalArgumentException("The argument parent may not be null!");
        }

        if (childName == null) {
            throw new IllegalArgumentException("The argument childName may not be null!");
        }

        Element element = null;
        String nodeName = null;

        ArrayList<Element> children = new ArrayList<Element>();

        NodeList childNodes = parent.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            if (childNodes.item(i) instanceof Element) {

                element = (Element) childNodes.item(i);
                nodeName = element.getNodeName();

                if (nodeName != null && nodeName.equals(childName)) {
                    children.add(element);
                }
            }
        }

        return children;
    }

    public static Element[] getElementPath(Element elem) {
        
        if (elem == null) {
            throw new IllegalArgumentException("The argument elem must not be null!");
        }

        ArrayList<Node> elementList = new ArrayList<Node>();
        elementList.add(elem);
        
        Node parent = elem.getParentNode();
        
        while (parent != null) {

            if (parent instanceof Element) {
                elementList.add(parent);
            }
            
            parent = parent.getParentNode();
        }

        Collections.reverse(elementList);
        
        Element[] path = new Element[elementList.size()];

        for (int i = 0; i < elementList.size(); i++) {

            elem = (Element) elementList.get(i);
            path[i] = elem;
        }

        return path;
    }
    
    public static Element getFirstElement(Element parent) {

        if (parent == null) {
            throw new IllegalArgumentException("The argument parent may not be null!");
        }

        NodeList childNodes = parent.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {

            if (childNodes.item(i) instanceof Element) {
                return (Element) childNodes.item(i);
            }
        }

        return null;
    }

    public static void setText(Element parent, String text) {

        if (parent == null) {
            throw new IllegalArgumentException("The argument parent must not be null!");
        }

        NodeList childNodes = parent.getChildNodes();

        if (childNodes != null && childNodes.getLength() > 0) {

            Node childNode;
            
            for (int i = 0; i < childNodes.getLength(); i++) {

                childNode = childNodes.item(i);
                parent.removeChild(childNode);
            }
        }
        
        Document doc = parent.getOwnerDocument();
        
        if (doc == null) {
            throw new NullPointerException("Owner document of element must not be null!");
        }

        Text textNode = doc.createTextNode(XmlServices.textToXml(text));
        parent.appendChild(textNode);
    }

    public static String getText(Node parent) {

        if (parent == null) {
            throw new IllegalArgumentException("The argument parent must not be null!");
        }

        String buffer = "";

        NodeList childNodes = parent.getChildNodes();

        if (childNodes == null || childNodes.getLength() == 0) {
            return buffer;
        }

        Node childNode;
        Text textNode;

        for (int i = 0; i < childNodes.getLength(); i++) {

            childNode = childNodes.item(i);

            if (childNode instanceof Text) {

                textNode = (Text) childNode;
                buffer += textNode.getNodeValue();

            } else if (childNode instanceof Element) {

                buffer += W3cServices.getText(childNode);
            }
        }

        return buffer;
    }

    /**
     * Die Methode <code>insertAfter</code> fügt ein neues Element nach dem
     * angegebenen Referenzelement ein.
     *
     * @param node <code>Element</code>
     * @param refNode <code>Element</code>
     */
    public static void insertElementAfter(Element newNode, Element refNode) {

        if (newNode == null) {
            throw new IllegalArgumentException("The argument newNode must not be null!");
        }

        if (refNode == null) {
            throw new IllegalArgumentException("The argument refNode must not be null!");
        }

        Element parentNode = (Element) refNode.getParentNode();

        if (parentNode == null) {
            throw new IllegalStateException("The parent node of the destination node must not be null!");
        }

        Element siblingNode = null;
        Node node = refNode.getNextSibling();
        
        while (node != null && node instanceof Element == false) {
            node = node.getNextSibling();
        }
        
        if (node != null && node instanceof Element) {
            siblingNode = (Element) node;
        }

        if (siblingNode != null) {
            parentNode.insertBefore(newNode, siblingNode);
        } else {
            parentNode.appendChild(newNode);
        }
    }
    
    public static void setElementText(Element elem, String text) {

        if (elem == null) {
            throw new IllegalArgumentException("The argument elem must not be null!");
        }

        if (text == null) {
            text = "";
        }

        Document doc = elem.getOwnerDocument();

        if (doc == null) {
            return;
        }

        if (elem.hasChildNodes()) {

            Node childNode;
            
            NodeList childNodes = elem.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                
                childNode = childNodes.item(i);
                elem.removeChild(childNode);
            }
        }

        Text textNode = doc.createTextNode(text);
        elem.appendChild(textNode);
    }

    /**
     * Die Methode <code>copyNode</code> kopiert den Baum mit dem Wurzelelement
     * <code>oNode</code> in den Kontext des Dokumentes <code>doc</code> und
     * gibt den Wurzelknoten des neu erzeugten Baumes <code>nNode</code> zurück.
     * Diese Methode wird benötigt um Knoten aus einem Dokument in den Baum
     * eines anderen Dokumentes zu kopieren.
     *
     * <p>Wird versucht Knoten eines Dokumentes in ein zweites zu einzuhängen,
     * erhält man die Fehlermeldung : <code>WRONG_DOCUMENT_ERR: A node is used
     * in a different document than the one that created it.</code></p>
     *
     * <p>Beispiel:</p>
     * <pre>
     * Document resourceDoc = XmlServices.parse(file);
     * elem = resourceDoc.getDocumentElement();
     * parent.appendChild(W3cServices.copyNode(manifestDoc, elem));
     * </pre>
     *
     * @param doc <code>Document</code>
     * @param oNode <code>Node</code>
     * @return <code>Node</code>
     */
    public static Node copyNode(Document doc, Node oNode) {

        if (doc == null) {
            throw new IllegalArgumentException("The argument doc must not be null!");
        }

        if (oNode == null) {
            throw new IllegalArgumentException("The argument oNode must not be null!");
        }

        Node nNode = null;
        Node nChild;
        int nodeType;
        
        switch (oNode.getNodeType()) {

        case Node.ELEMENT_NODE: 
            nNode = doc.createElement(oNode.getNodeName());

            NamedNodeMap attrMap = oNode.getAttributes();
            Node attrNode;
        
            for (int i = 0; i < attrMap.getLength(); i++) {
                attrNode = attrMap.item(i);
                ((Element) nNode).setAttribute(attrNode.getNodeName(), attrNode.getNodeValue());
            }

            break;
            
        case Node.TEXT_NODE: 
            nNode = doc.createTextNode(oNode.getNodeValue());
            break;
            
        case Node.ENTITY_NODE: 
            nNode = doc.createTextNode(oNode.getNodeName());
            break;
            
        case Node.ENTITY_REFERENCE_NODE: 
            nNode = doc.createEntityReference(oNode.getNodeName());
            break;
            
        case Node.COMMENT_NODE: 
            nNode = doc.createComment(oNode.getNodeValue());
            break;
            
        case Node.CDATA_SECTION_NODE: 
            nNode = doc.createCDATASection(oNode.getNodeValue());
            break;
            
        case Node.PROCESSING_INSTRUCTION_NODE: 
            nNode = doc.createProcessingInstruction(oNode.getNodeName(), oNode.getNodeValue());
            break;
            
        }

        if (nNode == null) {
            return null;
        }

        NodeList childNodes = oNode.getChildNodes();
        
        if (childNodes != null && childNodes.getLength() > 0) {

            for (int i = 0; i < childNodes.getLength(); i++) {

                nodeType = childNodes.item(i).getNodeType();
                
                if (nodeType != Node.ATTRIBUTE_NODE) {

                    nChild = copyNode(doc, childNodes.item(i));

                    if (nChild != null) {
                        nNode.appendChild(nChild);
                    }
                }
            }
        }
        
        return nNode;
    }

    public static String getAttributesAsText(Element elem) {

        String buffer = "";

        NamedNodeMap attributes = elem.getAttributes();

        if (attributes != null) {
        	
        	for (int i = 0; i < attributes.getLength(); i++) {

        		Node attr = attributes.item(i);
        		buffer += " " + attr.getNodeName() + "=\"" + XmlServices.textToXml(attr.getNodeValue()) + "\"";
            }
        }

        return buffer;
    }
}
