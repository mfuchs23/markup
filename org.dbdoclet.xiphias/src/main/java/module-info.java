module org.dbdoclet.xiphias {

	requires transitive jdk.xml.dom;

	requires java.xml;
	requires transitive java.desktop;

	requires org.apache.xml.resolver;

	requires transitive org.dbdoclet.commons;
	requires org.dbdoclet.getopts;
	
	exports org.dbdoclet.xiphias;
	exports org.dbdoclet.xiphias.annotation;
	exports org.dbdoclet.xiphias.dom;
}
