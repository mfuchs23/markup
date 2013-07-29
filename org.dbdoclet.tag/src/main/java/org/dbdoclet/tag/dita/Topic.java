package org.dbdoclet.tag.dita;

public class Topic extends DitaElement {

	private static int topicCounter = 1;
	
	Topic() {
		super("topic");
		setId(String.format("topic_%d", topicCounter++));
	}
}
