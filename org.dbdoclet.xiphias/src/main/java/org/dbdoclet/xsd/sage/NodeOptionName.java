/* Generated By:JJTree: Do not edit this line. NodeOptionName.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=Node,NODE_EXTENDS=SampleDataNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.dbdoclet.xsd.sage;

public
class NodeOptionName extends SimpleNode {
  public NodeOptionName(int id) {
    super(id);
  }

  public NodeOptionName(SampleDataParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SampleDataParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=1e0caf328aa1051cefd79a3b7ba41cdb (do not edit this line) */
