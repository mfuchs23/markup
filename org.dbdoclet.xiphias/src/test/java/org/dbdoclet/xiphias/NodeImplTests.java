package org.dbdoclet.xiphias;

import java.io.IOException;

import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.junit.jupiter.api.Test;

public class NodeImplTests {

	@Test
	public void testReplaceChild() throws IOException {

		NodeImpl root = new ElementImpl("p");
		NodeImpl span = new ElementImpl("span");
		root.appendChild(span);
		
		NodeImpl em = new ElementImpl("em");
		root.replaceChild(em, span);
		
		String buffer = new NodeSerializer().toXML(root);
		System.out.println(buffer);
	}

}
