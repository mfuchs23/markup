/*
 * ### Copyright (C) 2001-2013 Michael Fuchs ###
 * ### All Rights Reserved.                  ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.html.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.html.tokenizer.Token;
import org.dbdoclet.html.tokenizer.Tokenizer;
import org.dbdoclet.html.tokenizer.TokenizerException;
import org.dbdoclet.progress.ProgressEvent;
import org.dbdoclet.progress.ProgressListener;
import org.dbdoclet.progress.ProgressManager;
import org.dbdoclet.service.FileServices;
import org.dbdoclet.service.ReplaceServices;
import org.dbdoclet.service.StringServices;
import org.dbdoclet.tag.html.A;
import org.dbdoclet.tag.html.Body;
import org.dbdoclet.tag.html.Frameset;
import org.dbdoclet.tag.html.Head;
import org.dbdoclet.tag.html.HeaderElement;
import org.dbdoclet.tag.html.Html;
import org.dbdoclet.tag.html.HtmlDocument;
import org.dbdoclet.tag.html.HtmlElement;
import org.dbdoclet.tag.html.HtmlFragment;
import org.dbdoclet.tag.html.Li;
import org.dbdoclet.tag.html.P;
import org.dbdoclet.tag.html.Pre;
import org.dbdoclet.tag.html.Title;
import org.dbdoclet.xiphias.HtmlServices;
import org.dbdoclet.xiphias.dom.CommentImpl;
import org.dbdoclet.xiphias.dom.ElementImpl;
import org.dbdoclet.xiphias.dom.NodeImpl;
import org.dbdoclet.xiphias.dom.NodeListImpl;
import org.dbdoclet.xiphias.dom.NodeStack;
import org.dbdoclet.xiphias.dom.TextImpl;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>
 * The class <code>HTMLParser</code> parses HTML code and creates a tree of
 * HTMLElement nodes.
 * </p>
 * 
 * @author <a href="mailto:mfuchs@unico-consulting.com">Michael Fuchs</a>
 */
public class HtmlParser {

	private static final String HTML = "html";
	public final static int CONTEXT_HTML = 1;
	public final static int CONTEXT_BODY = 2;

	private static Log logger = LogFactory.getLog(HtmlParser.class);

	private int treeSize = 0;

	private final ArrayList<ProgressListener> listeners = new ArrayList<ProgressListener>();
	private final HashMap<String, String> unsupportedTags = new HashMap<String, String>();

	private final NodeStack openTags = new NodeStack();
	private final NodeStack openElements = new NodeStack();
	private int codeContext = CONTEXT_HTML;
	private final String title = "";

	public static int computeSize(Node node) {

		NodeList childNodes = node.getChildNodes();
		int elemCounter = 1;

		for (int i = 0; i < childNodes.getLength(); i++) {

			Node child = childNodes.item(i);
			elemCounter += computeSize(child);
		}

		return elemCounter;
	}

	/**
	 * The method <code>addProgressListener</code> adds a progress listener.
	 * 
	 * @param listener
	 *            a <code>ProgressListener</code> value
	 */
	public void addProgressListener(ProgressListener listener) {

		if (listener == null) {

			throw new IllegalArgumentException("Parameter listener is null!");
		}

		listeners.add(listener);
	}

	public String getTitle() {
		return title;
	}

	public int getTreeSize() {
		return treeSize;
	}

	public HtmlDocument parseDocument(File file) throws IOException,
			ParserException, TokenizerException {

		String htmlCode = FileServices.readToString(file);
		return parseDocument(htmlCode);
	}

	public HtmlDocument parseDocument(String htmlCode) throws ParserException,
			TokenizerException {

		HtmlDocument doc = new HtmlDocument();

		if (parseInternal(htmlCode, doc, null)) {
			return doc;
		}

		doc = new HtmlDocument();
		setCodeContext(CONTEXT_BODY);
		parseInternal(htmlCode, doc, null);
		return doc;
	}

	public HtmlFragment parseFragment(String htmlCode) throws ParserException,
			TokenizerException {

		HtmlFragment fragment = new HtmlFragment();
		setCodeContext(CONTEXT_BODY);
		parseInternal(htmlCode, fragment, null);
		return fragment;
	}

	public HtmlFragment parseFragment(String htmlCode, String skipTo)
			throws ParserException, TokenizerException {

		HtmlFragment fragment = new HtmlFragment();
		setCodeContext(CONTEXT_BODY);
		parseInternal(htmlCode, fragment, skipTo);
		return fragment;
	}

	/* ======================================================================== */
	/* PRIVATE METHODS */
	/* ======================================================================== */
	public void postparse(NodeImpl root, NodeImpl node) {

		NodeListImpl childNodes = node.getTrafoChildNodes();

		for (NodeImpl child : new ArrayList<NodeImpl>(childNodes)) {

			NodeImpl parent = child.getTrafoParentNode();

			if (parent != null) {

				if (child instanceof HeaderElement && parent instanceof A) {

					/*
					 * Falls ein Header Tag in einem A Tag enthalten ist, stellt
					 * dies eine ungültige Schachtelung dar, die erst innerhalb
					 * der Nachbearbeitung behoben werden kann. Der
					 * Header-Knoten tauscht seinen Platz mit seinem
					 * Vaterknoten.
					 */
					child.swapWithParent();
				}
			}

			if (child.getNodeType() == NodeImpl.ELEMENT_NODE) {

				postparse(root, child);
			}
		}
	}

	/**
	 * The method <code>setCodeContext</code> sets the context for the HTML code
	 * to parse.
	 * 
	 * The context can be CONTEXT_HTML, which means the code is a complete HTML
	 * page, or CONTEXT_BODY, which means the code is a snippet inside a body
	 * region.
	 * 
	 * @param context
	 *            an <code>int</code> value
	 */
	public void setCodeContext(int context) {

		switch (context) {

		case CONTEXT_HTML:
			break;

		case CONTEXT_BODY:
			break;

		default:
			throw new IllegalArgumentException("Invalid code context '"
					+ context + "'.");
		}

		codeContext = context;
	}

	public boolean isFragment(String htmlCode) throws TokenizerException {
		
		if (htmlCode == null) {
			throw new IllegalArgumentException("The argument htmlCode must not be null!");
		}
	
		Tokenizer tokenizer = new Tokenizer(htmlCode);
		tokenizer.tokenize();
		
		Token token = null;
		
		while (tokenizer.hasNext()) {
			
			token = tokenizer.next();
			
			if (token.isTag()) {
				if (HTML.equalsIgnoreCase(token.getTagName())) {
					return false;
				} else {
					return true;
				}
			}
		}
		
		return true;
	}
	
	private void addOpenTag(NodeImpl elem) {

		String tag = elem.getNodeName();
		openElements.push(elem);
		openTags.push(tag.toLowerCase());
	}

	/**
	 * The method <code>capFirstLetter</code> lowers all letters of a string
	 * except the first one, which is made an upper case letters.
	 * 
	 * The code:
	 * 
	 * <pre>
	 * s = s.toLowerCase();
	 * StringBuffer b = new StringBuffer(s);
	 * b.setCharAt(0, Character.toUpperCase(b.charAt(0)));
	 * </pre>
	 * 
	 * 
	 * @param s
	 *            a <code>String</code> value
	 * @return a <code>String</code> value
	 */
	private String capFirstLetter(String s) {

		if ((s != null) && (s.length() > 0)) {

			s = s.toLowerCase();

			StringBuffer b = new StringBuffer(s);
			b.setCharAt(0, Character.toUpperCase(b.charAt(0)));

			return b.toString();
		} else {

			return s;
		} // end of else
	}

	private boolean checkCodeContext(NodeImpl candidate) {

		if (codeContext == CONTEXT_BODY) {

			if (candidate instanceof Head || candidate instanceof Title
					|| candidate instanceof Html
					|| candidate instanceof Frameset) {

				return false;
			}
		}

		return true;
	}

	private int closeClosingTag(String tag, NodeImpl currentNode) {

		if (currentNode == null || currentNode instanceof HtmlElement == false) {
			return 0;
		}

		Node elem = currentNode;

		String tagName = elem.getNodeName();

		if (tagName == null) {
			return 0;
		}

		// First of all. Look if there is a corresponding open tag at all!
		while ((elem != null) && !elem.getNodeName().equalsIgnoreCase(tag)) {
			elem = elem.getParentNode();
		}

		if (elem == null) {

			logger.debug("Tag <" + tag + "> has no corresponding opening tag!");
			return 0;
		}

		int nesting = 0;
		int depth = openTags.search(tag);

		logger.debug("Open tag stack = '" + openTags + "'");

		for (int i = 0; i < depth; i++) {

			removeOpenTag();
			nesting++;
		} // end of while ()

		return nesting;
	}

	private int closeOpenTag(String tag, NodeImpl currentNode) {

		String search = "";
		logger.debug("Testing tag \"" + tag + "\". The current node is "
				+ currentNode + ".");

		// Close any open p tags, if the tag is a ol, ul, dl, address,
		// div, pre or table tag and no opening tag can be found.
		if (tag.equalsIgnoreCase("address") || tag.equalsIgnoreCase("div")
				|| tag.equalsIgnoreCase("dl") || tag.equalsIgnoreCase("menu")
				|| tag.equalsIgnoreCase("ol") || tag.equalsIgnoreCase("p")
				|| tag.equalsIgnoreCase("pre") || tag.equalsIgnoreCase("table")
				|| tag.equalsIgnoreCase("ul")) {

			if (openTags.search("p") != -1) {
				search = "p";
			}
		} // end of if ()

		if (tag.equalsIgnoreCase("h1") || tag.equalsIgnoreCase("h2")
				|| tag.equalsIgnoreCase("h3") || tag.equalsIgnoreCase("h4")
				|| tag.equalsIgnoreCase("h5") || tag.equalsIgnoreCase("h6")) {

			search = "p";

			/*
			 * String[] nodes = { "ul", "ol", "menu", "dl" }; index1 =
			 * searchNearset();
			 * 
			 * if ( ( index1 != -1 ) { openTags.search("ul")) != -1 ) {
			 * 
			 * index2 = openTags.search("li");
			 * 
			 * if ( index2 > index1 ) search = "ul";
			 * 
			 * } else if ( openTags.search("ol") != -1 && openTags.search("li")
			 * == -1) search = "ol"; else if ( openTags.search("menu") != -1 )
			 * search = "menu"; else if ( openTags.search("dl") != -1 &&
			 * openTags.search("dd") == -1) search = "dl";
			 */
		}

		if (tag.equalsIgnoreCase("td")) {

			int tdDepth = openTags.search("td");

			if (tdDepth != -1) {

				int depth = openTags.search("tr");

				if ((depth != -1) && (depth > tdDepth)) {
					search = "td";
				}
			}
		}

		if (tag.equalsIgnoreCase("tr")) {

			int trDepth = openTags.search("tr");

			if (trDepth != -1) {

				int depth = openTags.search("table");

				if ((depth != -1) && (depth > trDepth)) {
					search = "tr";
				}
			}
		}

		if (tag.equalsIgnoreCase("li")) {

			// if an open li tag is found, test first if it is in the
			// same list or not.
			int liDepth = openTags.search("li");

			if (liDepth != -1) {

				int uldepth = openTags.search("ul");
				int oldepth = openTags.search("ol");

				int depth = -1;

				if ((oldepth == -1) && (uldepth != -1)) {
					depth = uldepth;
				}

				if ((oldepth != -1) && (uldepth == -1)) {
					depth = oldepth;
				}

				if ((oldepth != -1) && (uldepth != -1) && (oldepth < uldepth)) {
					depth = oldepth;
				}

				if ((oldepth != -1) && (uldepth != -1) && (uldepth < oldepth)) {
					depth = uldepth;
				}

				if ((depth != -1) && (depth > liDepth)) {
					search = "li";
				}

				if ((depth != -1) && (depth > liDepth)) {
					search = "li";
				}
			}
		}

		// Close any open dt tags if the tag is a dd.
		if (tag.equalsIgnoreCase("dd")) {

			int dtDepth = openTags.search("dt");

			if (dtDepth != -1) {

				search = "dt";
			}
		} // end of if ()

		// Close any open dd tags if the tag is a dt.
		if (tag.equalsIgnoreCase("dt")) {

			int dddepth = openTags.search("dd");
			int dldepth = openTags.search("dl");

			// System.out.println("dddepth: " + dddepth + " dldepth: " +
			// dldepth);
			if ((dddepth != -1) && (dldepth > dddepth)) {
				search = "dd";
			}

			if ((dddepth != -1) && (dldepth != -1) && (dldepth < dddepth)) {
				search = "";
			}
		} // end of if ()

		int depth = openTags.search(search);

		return depth;
	}

	private HtmlElement createElement(Token token, NodeImpl parent) {

		String className;
		HtmlElement node = null;

		String tagName = token.getTagName().toLowerCase();

		logger.debug("tagName=" + tagName);

		if (token.isJavadoc()) {

			tagName = tagName.substring("javadoc:".length());
			className = "org.dbdoclet.tag.javadoc."
					+ capFirstLetter(tagName);
			logger.debug("Javadoc classname = '" + className + "'.");

		} else {

			className = "org.dbdoclet.tag.html."
					+ capFirstLetter(tagName);
		}

		try {

			Class<?> tagClass = Class.forName(className);
			node = (HtmlElement) tagClass.newInstance();

			node.setParentNode(parent);
			node.setTrafoStringAttributes(token.getAttributes());
			node.setLine(token.getLine());
			node.setColumn(token.getColumn());

		} catch (ClassNotFoundException oops) {

			if (unsupportedTags.get(tagName) == null) {

				logger.debug("Tag " + tagName + " is not supported! ("
						+ className + ")");
				unsupportedTags.put(tagName, className);
			}

		} catch (Exception oops) {

			logger.error("Exception: " + oops.getClass().getName() + " "
					+ oops.getMessage());
		}

		return node;
	}

	private boolean parseInternal(String htmlCode, NodeImpl root, String skipTo)
			throws ParserException, TokenizerException {

		ProgressManager pm = new ProgressManager(listeners);

		treeSize = 1;

		String errorBuffer = "";
		boolean firstElement = true;
		boolean rc = true;
		int index = 0;
		int nesting = 0;

		if ((htmlCode == null) || htmlCode.equals("")) {
			return false;
		}

		boolean skip = false;

		if (skipTo != null) {
			skip = true;
		}

		Tokenizer tokenizer = new Tokenizer(htmlCode);
		tokenizer.setProgressListeners(listeners);
		tokenizer.tokenize();

		Token token = null;
		NodeImpl currentNode = root;
		HtmlElement candidate = null;
		String title = "";

		while (tokenizer.hasNext()) {

			token = tokenizer.next();

			ProgressEvent event = new ProgressEvent(tokenizer.size(),
					tokenizer.position());
			event.setAction("HTML Parser: " + token.toString());
			event.setStage(ProgressEvent.STAGE_PREPARE);
			pm.fireProgressEvent(event);

			logger.debug(String.format("++++++ PROCESSING NEXT TOKEN %s",
					token.getTagName()));
			logger.debug("token=" + token.toString());
			logger.debug("currentNode=" + currentNode);

			if (token.isDoctype() && (currentNode == root)) {
				continue;
			}

			if ((codeContext == CONTEXT_HTML) && (firstElement == true)) {

				String tagName = token.getTagName();

				if (tagName != null) {
					tagName = tagName.toLowerCase();
				}

				if ((tagName != null) && tagName.equals(HTML)) {

					firstElement = false;

				} else if ((tagName != null) && tagName.equals("body")) {

					logger.debug("Missing html tag.");
					firstElement = false;

				} else {

					if (token.isTag()) {

						logger.debug("Found tag before html tag: "
								+ token.toString());

						if (errorBuffer.length() < 16832) {
							errorBuffer += "Found tag before html tag:  "
									+ token.toString() + ".\n";
						} else {
							if (errorBuffer.endsWith("More...\n") == false) {
								errorBuffer += "More...\n";
							}
						}
						
						rc = false;
					}

					continue;
				}
			}

			if (token.isComment()) {

				currentNode.appendChild(new CommentImpl("\n" + token.getValue()
						+ "\n", currentNode));
				treeSize++;
				continue;
			}

			if (token.isText()) {

				/*
				 * Falls der letzte Kandidat der Title-Tag des Dokumentes war,
				 * wird er in dem Attribut title abgelegt. Der Titel des
				 * Dokuments kann nach der Transformation, mit Hilfe der Methode
				 * getTitle() vom Aufrufer ermittelt werden.
				 */
				if (candidate instanceof Title) {

					title += token.getValue();
					title = StringServices.replace(title, "\n", " ");
					title = title.trim();
				}

				if (skip == true) {

					continue;
				}

				if ((currentNode instanceof Body || currentNode instanceof Li)
						&& (token.isWhitespace() == false)) {

					P para = new P();
					para.setParentNode(currentNode);
					currentNode.appendChild(para);
					treeSize++;
					currentNode = para;
					addOpenTag(para);
				}

				if (currentNode instanceof Pre
						|| (currentNode.findParent(Pre.class) != null)) {

					String value = token.getValue();
					value = HtmlServices.textToHtml(value);

					logger.debug("Adding text to literal environment.\n'"
							+ value + "'.");
					currentNode.appendChild(new TextImpl(value, currentNode));
					treeSize++;

				} else {

					if (token.isWhitespace() == false) {

						String value = token.getValue();

						value = ReplaceServices.replaceAll(value, "[\\t ]+",
								" ");
						value = ReplaceServices.replaceAll(value, "\\s+$", " ");

						currentNode.appendChild(new TextImpl(HtmlServices
								.textToHtml(value), currentNode));
						treeSize++;
					}
				}
			}

			if (token.isOpeningTag()) {

				String tagName = token.getTagName();

				if (tagName == null) {
					continue;
				}

				tagName = tagName.toLowerCase();

				if ((skip == true) && skipTo.equals(tagName)) {

					logger.debug("Setting skip to false. Found tag " + tagName
							+ ".");
					skip = false;
				}

				nesting = closeOpenTag(tagName, currentNode);
				NodeImpl node = currentNode;

				for (int i = 0; i < nesting; i++) {

					if (node != null) {

						NodeImpl parent = node.getTrafoParentNode();

						if (parent != null) {

							logger.debug("Closing node = " + node);
							logger.debug("New current node = " + parent);
							node = parent;
						}
					}
				}

				candidate = createElement(token, node);

				if (candidate == null) {
					continue;
				}

				logger.debug("Created candidate = " + candidate);

				if (!checkCodeContext(candidate)) {
					logger.debug("Candidate is not allowed in this code context("
							+ codeContext + ") '" + candidate + "'!");
					continue;
				}

				logger.debug("Candidate is valid: " + candidate);

				// Commit changes
				if (skip == false) {

					for (int i = 0; i < nesting; i++) {

						removeOpenTag();

						if (currentNode != null) {

							NodeImpl parent = currentNode.getTrafoParentNode();

							if (parent != null) {
								currentNode = parent;
							}
						}
					}

					if (currentNode instanceof HtmlDocument) {
						((HtmlDocument) currentNode)
						.setDocumentElement((ElementImpl) candidate);
					}
					
					currentNode.appendChild(candidate);								
					treeSize++;

					if (candidate.isEmpty() == false) {

						addOpenTag(candidate);
						currentNode = candidate;
					}

				} else {

					logger.debug("Skipped candidate.");

				} // end of else
			} // end of if ()

			if (token.isClosingTag() && (skip == false)) {

				if (currentNode != null) {

					nesting = closeClosingTag(token.getTagName().toLowerCase(),
							currentNode);
					logger.debug("Nesting = " + nesting);

					for (int j = 0; j < nesting; j++) {

						if ((currentNode != null)
								&& (currentNode.getParentNode() != null)) {
							currentNode = currentNode.getTrafoParentNode();
						}
					}
				}
			}
		}

		postparse(root, root);

		/*
		 * --------------------------------------------------------------- try {
		 * 
		 * PrintWriter out = new PrintWriter(new FileWriter("dbdoclet-" + new
		 * Date().getTime() + ".html")); out.println(root.toHTML());
		 * out.close();
		 * 
		 * } catch (Exception oops) {
		 * 
		 * logger.error("Can't save intermediate HTML file: " +
		 * oops.getMessage()); }
		 * ---------------------------------------------------------------
		 */

		if ((errorBuffer != null) && (errorBuffer.length() > 0)) {
			root.appendChild(new CommentImpl("ERRORS:\n" + errorBuffer));
			treeSize++;
		}
		
		return rc;
	}

	private ElementImpl removeOpenTag() {

		openTags.pop();

		HtmlElement node = (HtmlElement) openElements.pop();
		node.closed();

		return node;
	}
}
