/* 
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import org.dbdoclet.service.StringServices;

public class Imagedata extends DocBookElement {

	Imagedata() {

		super("imagedata");
		isEmpty(true);
		setFormatType(FORMAT_BLOCK);
	}

	public DocBookElement setAlign(String align) {

		if (align == null) {

			throw new IllegalArgumentException("Parameter align is null!");
		}

		setAttribute("align", align);
		return this;
	}

	public DocBookElement setContentDepth(String depth) {

		if (depth == null || depth.trim().length() == 0) {
			removeAttribute("contentdepth");
		}

		setAttribute("contentdepth", depth);
		return this;
	}

	public DocBookElement setContentWidth(String width) {

		if (width == null || width.trim().length() == 0) {
			removeAttribute("contentwidth");
		}

		setAttribute("contentwidth", width);
		return this;
	}

	public DocBookElement setDepth(String depth) {

		if (depth == null || depth.trim().length() == 0) {
			removeAttribute("depth");
		}

		setAttribute("depth", depth);
		return this;
	}

	public DocBookElement setFileRef(String fileref) {

		if (fileref == null) {
			throw new IllegalArgumentException("Parameter fileref is null!");
		}

		fileref = StringServices.replace(fileref, "\\", "/");
		setAttribute("fileref", fileref);

		return this;
	}

	public DocBookElement setFormat(String format) {

		if (format == null) {

			throw new IllegalArgumentException("Parameter format is null!");
		}

		setAttribute("format", format.toUpperCase());

		return this;
	}

	public DocBookElement setScale(int scale) {

		setAttribute("scale", String.valueOf(scale));

		return this;
	}

	public DocBookElement setScaleFit(boolean scalefit) {

		if (scalefit == true) {
			setAttribute("scalefit", "1");
		} else {
			setAttribute("scalefit", "0");
		}

		return this;
	}

	public DocBookElement setWidth(String width) {

		if (width == null) {
			throw new IllegalArgumentException("Parameter width is null!");
		}

		setAttribute("width", width);

		return this;
	}
}
