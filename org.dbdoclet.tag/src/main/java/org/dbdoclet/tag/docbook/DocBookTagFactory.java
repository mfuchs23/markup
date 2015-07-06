/*
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.tag.html.Img;
import org.dbdoclet.xiphias.ImageServices;
import org.dbdoclet.xiphias.NodeSerializer;
import org.dbdoclet.xiphias.XmlConstants;
import org.dbdoclet.xiphias.dom.ElementImpl;

public class DocBookTagFactory extends BaseTagFactory {

	// private static Log log = LogFactory.getLog(DocBookTagFactory.class);

	protected DocBookVersion docBookVersion = DocBookVersion.V5_0;

	public DocBookTagFactory() {
		this(DocBookVersion.V5_0);
	}

	public DocBookTagFactory(DocBookVersion docBookVersion) {
		this.docBookVersion = docBookVersion;
	}

	public Chapter createChapter(String titleText) {

		Chapter chapter = new Chapter();
		initialize(chapter);

		Info info = createInfo();
		chapter.appendChild(info);

		Title title = createTitle(titleText);
		info.appendChild(title);

		return chapter;
	}

	public Classname createClassName(String name) {

		Classname className = new Classname(name);
		initialize(className);
		return className;
	}

	public Classsynopsisinfo createClasssynopsisinfo(String text) {

		Classsynopsisinfo classSynopsisInfo = new Classsynopsisinfo(text);
		initialize(classSynopsisInfo);
		return classSynopsisInfo;
	}

	public Colspec createColspec(String string, String width) {

		Colspec colspec = new Colspec(string, width);
		initialize(colspec);
		return colspec;
	}

	public Computeroutput createComputeroutput(String text) {

		Computeroutput computeroutput = new Computeroutput(text);
		initialize(computeroutput);
		return computeroutput;
	}

	public Date createDate(String text) {

		Date date = new Date(text);
		initialize(date);
		return date;
	}

	public DocBookElement createElementByName(String tagName) {

		String pkg = "org.dbdoclet.tag.docbook.";
		String lowerCase = tagName.toLowerCase();
		DocBookElement elem = null;

		Class<?> clazz = null;

		for (int i = 0; i < lowerCase.length(); i++) {

			String name = upcase(lowerCase, 0, i);

			try {
				clazz = Class.forName(pkg + name);
				if (clazz != null) {
					elem = (DocBookElement) clazz.newInstance();
					if (elem != null) {
						break;
					}
				}
			} catch (Throwable e) {
			}
		}

		return elem;
	}

	public Email createEmail(String address) {

		Email email = createEmail();
		email.appendChild(address);
		return email;
	}

	public Emphasis createEmphasis(String str) {

		Emphasis emphasis = new Emphasis(str);
		initialize(emphasis);
		return emphasis;
	}

	public Emphasis createEmphasis(String str, String role) {

		Emphasis emphasis = createEmphasis(str);
		emphasis.setRole(role);
		return emphasis;
	}

	public Entry createEntry(String text) {

		Entry entry = new Entry(text);
		initialize(entry);
		return entry;
	}

	public Example createExample(String title) {

		Example example = new Example();
		initialize(example);
		example.appendChild(createTitle(title));
		return example;
	}

	public Exceptionname createExceptionname(String text) {

		Exceptionname exceptionName = new Exceptionname(text);
		initialize(exceptionName);
		return exceptionName;
	}

	public Figure createFigure(String title) {

		Figure figure = new Figure();
		initialize(figure);
		figure.appendChild(createTitle(title));
		return figure;
	}

	public Firstname createFirstname(String name) {

		Firstname firstName = createFirstname();
		firstName.appendChild(name);
		return firstName;
	}

	public void createFoImageData(DocBookElement parent,
			BaseTagFactory dbfactory, Img img, File file,
			List<String> additionalFormats) throws IOException {

		String fileRef = FileServices.normalizePath(file.getPath());
		String imgFormat = getImagedataFormat(fileRef);
		fileRef = FileServices.getFileBase(fileRef);

		if (FileServices.isAbsolutePath(fileRef)) {

			fileRef = FileServices.normalizePath(fileRef);

			if (fileRef.startsWith("/")) {
				fileRef = "file://" + fileRef;
			} else {
				fileRef = "file:///" + fileRef;
			}
		}

		HashSet<String> formatList = new HashSet<>();
		formatList.add(imgFormat);

		if (additionalFormats != null) {
			additionalFormats.forEach(f -> formatList.add(f.toUpperCase()));
		}

		for (String format : formatList) {

			Imageobject image = dbfactory.createImageobject();

			if (format.equals(imgFormat)) {
				image.setRole("fo");
			} else {
				image.setRole("fo-" + format.toLowerCase());
			}

			String align = img.getAlign();

			Imagedata data = dbfactory.createImagedata();

			data.setScaleFit(true);
			data.setWidth("100%");
			data.setContentDepth("100%");
			data.setFormat(format);

			if (align != null && align.length() > 0) {
				data.setAlign(validateAlign(align));
			}

			data.setFileRef(fileRef + "." + format.toLowerCase());

			image.appendChild(data);
			parent.appendChild(image);
		}
	}

	public DocBookElement createFormalpara(String text) {

		Formalpara formalPara = createFormalpara();
		formalPara.appendChild(text);
		return formalPara;
	}

	public Function createFunction(String func) {

		Function function = new Function();
		function.appendChild(func);
		initialize(function);
		return function;
	}

	public Holder createHolder(String text) {

		Holder holder = new Holder();
		holder.appendChild(text);
		initialize(holder);
		return holder;
	}

	public void createHtmlImageData(DocBookElement parent,
			BaseTagFactory dbfactory, Img img, File file,
			List<String> additionalFormats) throws IOException {

		String fileRef = FileServices.normalizePath(file.getPath());

		if (FileServices.isAbsolutePath(fileRef)) {

			fileRef = FileServices.normalizePath(fileRef);

			if (fileRef.startsWith("/")) {
				fileRef = "file://" + fileRef;
			} else {
				fileRef = "file:///" + fileRef;
			}
		}

		String imgFormat = getImagedataFormat(fileRef);
		fileRef = FileServices.getFileBase(fileRef);

		if (imgFormat == null) {
			return;
		}

		String width = img.getWidth();
		String height = img.getHeight();
		String align = img.getAlign();

		HashSet<String> formatList = new HashSet<>();
		formatList.add(imgFormat);

		if (additionalFormats != null) {
			additionalFormats.forEach(f -> formatList.add(f.toUpperCase()));
		}

		for (String format : formatList) {

			Imageobject image = dbfactory.createImageobject();

			if (format.equals(imgFormat)) {
				image.setRole("html");
			} else {
				image.setRole("html-" + format.toLowerCase());
			}

			Imagedata data = dbfactory.createImagedata();
			data.setScaleFit(true);

			if (width != null && width.length() > 0) {
				data.setContentWidth(width);
			}

			if (height != null && height.length() > 0) {
				data.setContentDepth(height);
			}

			if (file.exists() && format.equalsIgnoreCase("BASE64")) {

				String fileName = FileServices.getFileBase(file) + ".base64";
				FileServices.writeFromString(new File(fileName),
						ImageServices.toXml(file));
			}

			data.setFormat(format);

			if (align != null && align.length() > 0) {
				data.setAlign(validateAlign(align));
			}

			String attr = fileRef + "." + format.toLowerCase();
			data.setFileRef(attr);
			image.appendChild(data);
			parent.appendChild(image);
		}
	}

	public Mediaobject createImage(String image) {
		return createImage(image, null, null);
	}

	public Mediaobject createImage(String image, String width, String height) {

		Mediaobject mediaObject = createMediaobject();

		Imageobject imageObject = createImageobject();
		mediaObject.appendChild(imageObject);

		Imagedata imageData = createImagedata();
		imageObject.appendChild(imageData);

		imageData.setFileRef(image);

		if (width != null && width.trim().length() > 0) {
			imageData.setWidth(String.valueOf(width));
		}

		if (height != null && height.trim().length() > 0) {
			imageData.setDepth(String.valueOf(height));
		}

		return mediaObject;
	}

	public Initializer createInitializer(String text) {

		Initializer initializer = new Initializer(text);
		initialize(initializer);
		return initializer;
	}

	public Interfacename createInterfacename(String name) {

		Interfacename interfaceName = new Interfacename(name);
		initialize(interfaceName);
		return interfaceName;
	}

	public Link createLink(Literal literal, String ref) {

		Link link = new Link(literal, ref);
		initialize(link);
		return link;
	}

	public Link createLink(String linkend) {

		Link link = new Link(linkend);
		initialize(link);
		return link;
	}

	public Link createLink(String label, String ref) {

		Link link = new Link(label, ref);
		initialize(link);
		return link;
	}

	public Link createLink(Varname varName, String ref) {

		Link link = new Link(varName, ref);
		initialize(link);
		return link;
	}

	public String createLinkAsString(String label, String ref)
			throws IOException {

		Link link = new Link(label, ref);
		initialize(link);
		return new NodeSerializer().toXML(link);
	}

	public Literal createLiteral(String text) {

		Literal literal = new Literal(text);
		initialize(literal);
		return literal;
	}

	public Manvolnum createManvolnum(String num) {

		Manvolnum manVolNum = new Manvolnum();
		initialize(manVolNum);
		manVolNum.appendChild(num);
		return manVolNum;
	}

	public Modifier createModifier(String text) {

		Modifier modifier = new Modifier();
		modifier.appendChild(text);
		initialize(modifier);
		return modifier;
	}

	public Olink createOlink(String label, String targetdoc, String targetptr) {

		Olink olink = new Olink(label, targetdoc, targetptr);
		initialize(olink);
		return olink;
	}

	public Parameter createParameter(String name) {

		Parameter parameter = new Parameter();
		initialize(parameter);
		parameter.appendChild(name);
		return parameter;
	}

	public Primary createPrimary(String key) {

		Primary primary = new Primary();
		initialize(primary);
		primary.appendChild(key);
		return primary;
	}

	public Programlisting createProgramListing(String str) {

		Programlisting programListing = new Programlisting(str);
		initialize(programListing);
		return programListing;
	}

	public Refmiscinfo createRefmiscinfo(String clazz, String info) {

		Refmiscinfo refMiscInfo = new Refmiscinfo();
		initialize(refMiscInfo);
		refMiscInfo.setAttribute("class", clazz);
		refMiscInfo.appendChild(refMiscInfo);
		return refMiscInfo;
	}

	public Refname createRefname(String name) {

		Refname refname = createRefname();
		refname.appendChild(name);
		return refname;
	}

	public Refsect1 createRefsect1(String title) {

		Refsect1 refSect1 = createRefsect1();
		refSect1.appendChild(createTitle(title));
		return refSect1;
	}

	public Refsect2 createRefsect2(String title) {

		Refsect2 refSect2 = createRefsect2();
		refSect2.appendChild(createTitle(title));
		initialize(refSect2);
		return refSect2;
	}

	public Refsection createRefsection(String title) {

		Refsection refSection = createRefsection();
		refSection.appendChild(createTitle(title));
		return refSection;
	}

	public Releaseinfo createReleaseinfo(String text) {

		Releaseinfo releaseInfo = new Releaseinfo();
		releaseInfo.appendChild(text);
		initialize(releaseInfo);
		return releaseInfo;
	}

	public Secondary createSecondary(String key) {

		Secondary secondary = new Secondary();
		initialize(secondary);
		secondary.appendChild(key);
		return secondary;
	}

	public Sect1 createSect1(String title) {
	
		Sect1 sect1 = createSect1();
		sect1.appendChild(createTitle(title));
		return sect1;
	}

	public Sect2 createSect2(String str) {

		Sect2 sect2 = createSect2();
		sect2.appendChild(createTitle(str));
		return sect2;
	}

	public Sect3 createSect3(String str) {

		Sect3 sect3 = createSect3();
		sect3.appendChild(createTitle(str));
		return sect3;
	}

	public Section createSection(String title) {

		Section section = createSection();
		section.appendChild(createTitle(title));
		return section;
	}

	public Simpara createSimpara(String text) {

		Simpara simPara = new Simpara();
		initialize(simPara);
		simPara.appendChild(text);
		return simPara;
	}

	public Surname createSurname(String name) {

		Surname surname = new Surname();
		surname.appendChild(name);
		initialize(surname);
		return surname;
	}

	public DocBookElement createTag(String name)
			throws DocBookTagFactoryException {

		DocBookElement docBookElement = new DocBookElement(name);
		initialize(docBookElement);
		return docBookElement;
	}

	public Tgroup createTgroup(int cols) {

		Tgroup tgroup = new Tgroup();
		initialize(tgroup);
		tgroup.setCols(2);
		tgroup.appendChild(createColspec("c1", "1*"));
		tgroup.appendChild(createColspec("c2", "1*"));

		return tgroup;
	}

	public Title createTitle(String str) {

		Title title = new Title(str);
		initialize(title);
		return title;
	}

	public Varname createVarname(String text) {

		Varname varName = new Varname(text);
		initialize(varName);
		return varName;
	}

	public Warning createWarning(String text) {

		Warning warning = new Warning(text);
		initialize(warning);
		return warning;
	}

	public Xref createXref(String linkend) {

		Xref xref = new Xref();
		initialize(xref);
		xref.setAttribute("linkend", ElementImpl.hardenId(linkend));
		xref.isEmpty(true);
		xref.needsPadding(false);
		return xref;
	}

	public Year createYear(String text) {

		Year year = new Year();
		year.appendChild(text);
		initialize(year);
		return year;
	}

	public DocBookVersion getDocBookVersion() {
		return docBookVersion;
	}

	public String getImagedataFormat(String src) {

		if (src != null) {

			String value = FileServices.getExtension(src);

			if (value != null && value.trim().length() > 0) {
				return value.toUpperCase();
			}
		}

		return null;
	}

	public boolean isDocBook5() {

		if (docBookVersion != null && docBookVersion == DocBookVersion.V5_0) {
			return true;
		}

		return false;
	}

	public String validateAlign(String align) {

		if (align == null) {
			return align;
		}

		align = align.toLowerCase();

		try {
			AttributeAlign.valueOf(align.toUpperCase());
		} catch (IllegalArgumentException oops) {
			return AttributeAlign.CENTER.toString().toLowerCase();
		}

		return align;
	}

	private String upcase(String lowerCase, int... indices) {

		char[] chars = lowerCase.toCharArray();

		for (int index : indices) {
			chars[index] = Character.toUpperCase(chars[index]);
		}

		return new String(chars);
	}

	protected void initialize(DocBookElement elem) {

		elem.setDocBookVersion(docBookVersion);
		elem.setNamespaceURI(XmlConstants.NAMESPACE_DOCBOOK);
	}

}