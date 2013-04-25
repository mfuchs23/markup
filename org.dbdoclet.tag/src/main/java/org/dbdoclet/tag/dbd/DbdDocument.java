package org.dbdoclet.tag.dbd;

import org.dbdoclet.xiphias.dom.DocumentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
 
public class DbdDocument extends DocumentImpl {

    private Dodo root;

    public DbdDocument() {
        root = new Dodo();
    }

    @Override
    public void setDocumentElement(ElementImpl root) {

        if (root == null) {
            throw new IllegalArgumentException("The argument root must not be null!");
        }

        if (root instanceof Dodo == false) {
            throw new IllegalArgumentException("The document element must be a dodo element!");
        }

        if (this.root != null) {
            replaceChild(this.root, root);
        } else {
            appendChild(root);
        }

        this.root = (Dodo) root;
    }

    @Override
    public ElementImpl getDocumentElement() {
        return root;
    }
}

