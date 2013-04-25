package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Node;

public interface INodeVisitor {

    public void openTag(Node node) throws Exception;
    public void accept(Node node) throws Exception;
    public void closeTag(Node node) throws Exception;
}
