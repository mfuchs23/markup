module org.dbdoclet.xiphias {

	requires transitive jdk.xml.dom;
	requires transitive java.desktop;
	requires transitive org.dbdoclet.commons;
	requires org.dbdoclet.getopts;
	requires org.junit.jupiter.api;
	requires org.apache.xml.resolver;
	requires java.xml;
	
	exports org.dbdoclet.xiphias;
	exports org.dbdoclet.xiphias.annotation;
	exports org.dbdoclet.xiphias.dom;
}