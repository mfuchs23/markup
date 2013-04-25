package org.dbdoclet.xiphias.dom;

import java.util.ArrayList;

import org.dbdoclet.progress.ProgressEvent;
import org.dbdoclet.progress.ProgressListener;
import org.dbdoclet.progress.ProgressManager;
import org.w3c.dom.Node;

public abstract class AbstractNodeVisitor implements INodeVisitor {

	protected final ArrayList<ProgressListener> listeners;
	private ProgressManager pm;

	public AbstractNodeVisitor() {
		this.listeners = new ArrayList<ProgressListener>();
		pm = new ProgressManager(listeners);
	}

	public AbstractNodeVisitor(ArrayList<ProgressListener> listeners) {
		this.listeners = listeners;
		pm = new ProgressManager(listeners);
	}

	protected void fireProgressEvent(String msg, int stage) {
		
		ProgressEvent event = new ProgressEvent(msg);
		event.setStage(stage);
		pm.fireProgressEvent(event);
	}

	public abstract void accept(Node node) throws Exception;

	protected void removeNodes(ArrayList<Node> nodeList) {
		
		for (Node node : nodeList) {
			
			Node parent = node.getParentNode();
			
			if (parent != null) {
				parent.removeChild(node);
			}
		}
	}

}