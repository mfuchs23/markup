package org.dbdoclet.xiphias.dom;

import java.util.ArrayList;

import org.dbdoclet.progress.ProgressEvent;
import org.dbdoclet.progress.ProgressListener;
import org.w3c.dom.Node;

public class NodeCountVisitor extends AbstractNodeVisitor implements INodeVisitor {

	private int counter = 0;
	
	public NodeCountVisitor(ArrayList<ProgressListener> listeners) {
		super(listeners);
	}
	
	public int getNumberOfNodes() {
		return counter;
	}
	
	public void accept(Node node) {

		counter++;
		fireProgressEvent(String.valueOf(counter), ProgressEvent.STAGE_PREPARE);
	}

	public INodeVisitor reset() {
		counter = 0;
		return this;
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
