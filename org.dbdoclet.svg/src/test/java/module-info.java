module org.dbdoclet.svg {
  
	exports org.dbdoclet.svg;

	requires jdk.xml.dom;
	requires transitive java.desktop;
	requires org.apache.commons.logging;
	requires org.dbdoclet.getopts;
	requires org.dbdoclet.commons;
	requires batik.svggen;
	requires batik.dom;
	requires org.dbdoclet.xiphias;
	requires batik.transcoder;
	requires junit;
}