/* Generated By:JJTree: Do not edit this line. NodeStart.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=CssNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.dbdoclet.css.parser.jjt;

public
class NodeStart extends SimpleNode {
  public NodeStart(int id) {
    super(id);
  }

  public NodeStart(CssParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(CssParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c6b18998af6b08a894f8ceeddfc25567 (do not edit this line) */