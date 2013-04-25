package org.dbdoclet.xiphias.dom;

import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

public class EntityReferenceImpl extends NodeImpl implements EntityReference {

	public EntityReferenceImpl() {
		setNodeType(Node.ENTITY_REFERENCE_NODE);
	}
}
