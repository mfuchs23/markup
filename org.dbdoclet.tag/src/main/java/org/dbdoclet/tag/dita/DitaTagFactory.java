package org.dbdoclet.tag.dita;

import org.dbdoclet.tag.TagFactory;
import org.dbdoclet.tag.docbook.DocBookElement;
import org.dbdoclet.xiphias.dom.TextImpl;
import org.w3c.dom.Element;

public class DitaTagFactory extends TagFactory {

	public Abstract createAbstract() {

		Abstract _abstract = new Abstract();
		return _abstract;
	}

	public B createB() {
		return new B();
	}
	
	public Body createBody() {
		return new Body();
	}

	public P createP() {
		return new P();
	}

	public P createP(String text) {
		P p = new P();
		p.appendChild(new TextImpl(text));
		return p;
	}

	public Prolog createProlog() {
		return new Prolog();
	}

	public Section createSection() {
		return new Section();
	}

	public Title createTitle() {

		Title title = new Title();
		return title;
	}

	public Title createTitle(String str) {

		Title title = new Title(str);
		return title;
	}

	public Topic createTopic() {
		return new Topic();
	}

	public Tt createTt() {
		return new Tt();
	}

	public U createU() {
		return new U();
	}

	@Override
	public Element createElement(String mapTo) {
		return null;
	}

	@Override
	protected void initialize(DocBookElement elem) {
	}
}
