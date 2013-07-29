package org.dbdoclet.tag.dita;

import org.dbdoclet.xiphias.dom.TextImpl;

public class DitaTagFactory {

	public Abstract createAbstract() {

		Abstract _abstract = new Abstract();
		return _abstract;
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

	public B createB() {
		return new B();
	}

	public U createU() {
		return new U();
	}

	public Tt createTt() {
		return new Tt();
	}

	public Body createBody() {
		return new Body();
	}

}
