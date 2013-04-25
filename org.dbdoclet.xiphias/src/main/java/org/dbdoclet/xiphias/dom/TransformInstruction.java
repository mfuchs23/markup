package org.dbdoclet.xiphias.dom;

import org.w3c.dom.Node;

/**
 * TransformInstruction is used by a Node to tell a transformation engine, by
 * which node or subtree it wants to be replaced and wich node is new parent in
 * the resulting tree for future appends.
 * 
 * @author michael
 * 
 */
public class TransformInstruction {

	private Node replacement;
	private Node newParent;

	public Node getReplacement() {
		return replacement;
	}

	public void setReplacement(NodeImpl replacement) {
		this.replacement = replacement;
	}

	public Node getNewParent() {
		return newParent;
	}

	public void setNewParent(NodeImpl newParent) {
		this.newParent = newParent;
	}
}
