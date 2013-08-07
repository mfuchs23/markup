/* 
 * $Id$
 *
 * ### Copyright (C) 2006 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbdoclet.progress.ProgressEvent;
import org.dbdoclet.progress.ProgressListener;
import org.dbdoclet.service.FileServices;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DInc {

	private static Log logger = LogFactory.getLog(DInc.class);

	private String includeMsg = "Including file {0}";
	private String relocateMsg = "Relocating file {0}";
	private String compPath;
	private ArrayList<String> midList;

	private final ProgressListener listener;

	public DInc(ProgressListener listener) {

		this.listener = listener;
	}

	public DInc() {
		this(null);
	}

	public void setIncludeMsg(String includeMsg) {
		this.includeMsg = includeMsg;
	}

	public String getIncludeMsg() {
		return includeMsg;
	}

	public void setRelocateMsg(String relocateMsg) {
		this.relocateMsg = relocateMsg;
	}

	public String getRelocateMsg() {
		return relocateMsg;
	}

	public void setCompPath(String compPath) {
		this.compPath = compPath;
	}

	public void merge(File xmlFile, File xmlBase, String sectionNode)
			throws IOException, SAXException, ParserConfigurationException {

		if (xmlFile == null) {
			throw new IllegalArgumentException(
					"The argument xmlFile must not be null!");
		}

		String path = xmlFile.getCanonicalPath();
		File xmlFileDir = new File(path);
		xmlFileDir = xmlFileDir.getParentFile();

		if (xmlBase == null || xmlBase.equals("")) {
			xmlBase = xmlFileDir;
		}

		if (sectionNode == null || sectionNode.equals("")) {
			sectionNode = "//sect1";
		}

		logger.debug("Mergin the xml file '" + xmlFile.getCanonicalPath()
				+ "'...");

		Document doc = XmlServices.parse(xmlFile, false);

		ArrayList<Node> dincList = XPathServices.getNodes(doc, "dodo",
				"http://www.dbdoclet.org/xml/ns/dodo", "//dodo:include");
		logger.debug("Number of dodo:include elements " + dincList.size() + ".");

		path = FileServices.appendPath(xmlFileDir, "data");
		FileServices.delete(path);
		FileServices.createPath(path);
		File dataDir = new File(path);

		Document incDoc;
		Element elem;
		Element parent;
		File file;
		Node newChild;
		Node refChild;
		Object obj;
		String fileName;
		ArrayList<Node> childList;
		Iterator<Node> iterator = dincList.iterator();

		midList = new ArrayList<String>();

		while (iterator.hasNext()) {

			obj = iterator.next();

			if (obj instanceof Element) {

				elem = (Element) obj;
				parent = (Element) elem.getParentNode();
				fileName = W3cServices.getText(elem);
				fileName = FileServices.appendFileName(xmlBase, fileName);
				file = new File(fileName);
				fileName = file.getCanonicalPath();
				file = new File(fileName);

				if (file.exists() == false) {
					logger.warn("The file " + fileName + " doesn't exist.");
					parent.removeChild(elem);
					continue;
				}

				logger.debug("including the file " + fileName);

				fireProgressEvent(fileName, includeMsg);
				incDoc = XmlServices.parse(file);
				childList = XPathServices.getNodes(incDoc, sectionNode);
				Collections.reverse(childList);

				if (childList.size() > 0) {
					refChild = W3cServices.copyNode(doc, childList.get(0));
					relocateImages(dataDir, file.getParentFile(), refChild);
					checkMids(refChild);
					parent.replaceChild(refChild, elem);

					for (int i = 1; i < childList.size(); i++) {
						newChild = W3cServices.copyNode(doc, childList.get(i));
						relocateImages(dataDir, file.getParentFile(), newChild);
						checkMids(newChild);
						parent.insertBefore(newChild, refChild);
						refChild = newChild;
					}
				} else {
					parent.removeChild(elem);
				}
			}
		}

		NodeSerializer serializer = new NodeSerializer();
		serializer.setEncoding("UTF-8");
		serializer.write(doc, xmlFile);
	}

	private void checkMids(Node node) {

		ArrayList<?> idAttrList = XPathServices.getNodes(node, "//@xml:id");
		for (Object idObj : idAttrList) {
			if (idObj instanceof Attr) {
				Attr idAttr = (Attr) idObj;
				String mid = idAttr.getValue();
				if (midList.contains(mid)) {
					int ind = 0;
					while (midList.contains(mid + "_" + ind)) {
						ind++;
					}
					idAttr.setValue(mid + "_" + ind);
					midList.add(mid + "_" + ind);
				} else {
					midList.add(mid);
				}
			}
		}
	}

	private void relocateImages(File destDir, File xmlBase, Node node)
			throws IOException {

		if (destDir == null) {
			throw new IllegalArgumentException(
					"The argument dataDir must not be null!");
		}

		if (xmlBase == null) {
			throw new IllegalArgumentException(
					"The argument xmlBase must not be null!");
		}

		ArrayList<Node> srcList = XPathServices.getNodes(node, "//imgdata");

		logger.debug("Number of elements with attribute fileref "
				+ srcList.size() + ".");

		File srcFile;
		File destFile;
		String path;
		String srcFileName;
		String destFileName;
		String extensionSrc;
		String extensionDest;

		for (Node imgDataNode : srcList) {

			Element imgData = (Element) imgDataNode;

			if (imgData.hasAttribute("fileref")) {
				String fileref = imgData.getAttribute("fileref");
				if (fileref.startsWith("../")) {
					fileref = fileref.substring(3);
				}

				srcFileName = xmlBase.getParentFile() + "/" + fileref;
				srcFileName = FileServices.correctPathSeperator(srcFileName);
				srcFile = new File(srcFileName);

				extensionDest = imgData.getAttribute("format").toLowerCase();
				if (srcFile.exists() == false) {
					path = FileServices.getFileBase(srcFile) + ".png";
					srcFile = new File(path);
					if (srcFile.exists() == false) {
						path = FileServices.getFileBase(srcFile) + ".gif";
						srcFile = new File(path);
						if (srcFile.exists() == false) {
							path = FileServices.getFileBase(srcFile) + ".eps";
							srcFile = new File(path);
							if (srcFile.exists() == false) {
								imgData.setAttribute("fileref", "");
								continue;
							}
						}
					}
				}

				extensionSrc = FileServices.getExtension(srcFileName)
						.toLowerCase();
				String tempFileName = fileref.substring(3,
						fileref.lastIndexOf("."));

				destFileName = createUuidFileName(compPath + tempFileName)
						+ "." + extensionDest;
				destFile = new File(FileServices.appendFileName(destDir,
						destFileName));
				fireProgressEvent(srcFileName + "\n    ------->\n"
						+ destFileName, relocateMsg);

				if (extensionSrc.equals(extensionDest)) {
					FileServices.copyFileToFile(srcFile, destFile);
				}

				if (extensionDest.equals("png")) {

					if (extensionSrc.equals("gif")) {
						destFile = ImageServices.giftopng(srcFile, destFile);
					}
				} else if (extensionDest.equals("eps")) {
					if (extensionSrc.equals("gif")) {
						destFile = ImageServices.giftopng(srcFile, destFile);
					}
					if (extensionSrc.equals("png")) {
						ImageServices.toEps(srcFile, destFile);
					}
				} else {
					// TODO: if more formats are needed
					path = "";
				}

				path = "data/" + destFileName;
				imgData.setAttribute("fileref", path);

			}
		}
	}

	private String createUuidFileName(String picPath) {
		UUID uuidModule = UUID
				.nameUUIDFromBytes(("http://unico-media.de/" + picPath)
						.getBytes());
		return uuidModule.toString();
	}

	private void fireProgressEvent(String fileName, String res) {

		if (listener != null) {

			String msg = fileName;

			if (res != null) {
				msg = MessageFormat.format(res, fileName);
			}

			listener.progress(new ProgressEvent(msg, false));
		}
	}
}
