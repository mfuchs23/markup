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
import java.text.SimpleDateFormat;
import java.util.List;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.tag.html.Img;
import org.dbdoclet.xiphias.ImageServices;
import org.dbdoclet.xiphias.NodeSerializer;

public class DocBookTagFactory {

	private DocBookVersion docBookVersion = DocBookVersion.V5_0;

	public DocBookTagFactory() {
		this(DocBookVersion.V5_0);
	}

	public DocBookTagFactory(DocBookVersion docBookVersion) {

		this.docBookVersion = docBookVersion;
	}

	public Abbrev createAbbrev() {

		Abbrev abbrev = new Abbrev();
		abbrev.setDocBookVersion(docBookVersion);
		return abbrev;
	}

	public Abstract createAbstract() {

		Abstract _abstract = new Abstract();
		_abstract.setDocBookVersion(docBookVersion);
		return _abstract;
	}

	public Acronym createAcronym() {

		Acronym acronym = new Acronym();
		acronym.setDocBookVersion(docBookVersion);
		return acronym;
	}

	public Address createAddress() {

		Address address = new Address();
		address.setDocBookVersion(docBookVersion);
		return address;
	}

	public Affiliation createAffiliation() {

		Affiliation affiliation = new Affiliation();
		affiliation.setDocBookVersion(docBookVersion);
		return affiliation;
	}

	public Anchor createAnchor() {

		Anchor anchor = new Anchor();
		anchor.setDocBookVersion(docBookVersion);
		return anchor;
	}

	public Appendix createAppendix() {

		Appendix appendix = new Appendix();
		appendix.setDocBookVersion(docBookVersion);
		return appendix;
	}

	public Article createArticle() {

		Article article = new Article();
		article.setDocBookVersion(docBookVersion);
		return article;
	}

	public ArticleInfo createArticleInfo() {

		ArticleInfo articleInfo = new ArticleInfo();
		articleInfo.setDocBookVersion(docBookVersion);
		return articleInfo;
	}

	public Author createAuthor() {

		Author author = new Author();
		author.setDocBookVersion(docBookVersion);
		return author;
	}

	public BlockQuote createBlockQuote() {

		BlockQuote blockQuote = new BlockQuote();
		blockQuote.setDocBookVersion(docBookVersion);
		return blockQuote;
	}

	public Book createBook() {

		Book book = new Book();
		book.setDocBookVersion(docBookVersion);
		return book;
	}

	public BookInfo createBookInfo() {

		BookInfo bookInfo = new BookInfo();
		bookInfo.setDocBookVersion(docBookVersion);
		return bookInfo;
	}

	public BridgeHead createBridgeHead() {

		BridgeHead bridgeHead = new BridgeHead();
		bridgeHead.setDocBookVersion(docBookVersion);
		return bridgeHead;
	}

	public Caption createCaption() {

		Caption caption = new Caption();
		caption.setDocBookVersion(docBookVersion);
		return caption;
	}

	public Caution createCaution() {

		Caution caution = new Caution();
		caution.setDocBookVersion(docBookVersion);
		return caution;
	}

	public Chapter createChapter() {

		Chapter chapter = new Chapter();
		chapter.setDocBookVersion(docBookVersion);
		return chapter;
	}

	public Chapter createChapter(String titleText) {

		Chapter chapter = new Chapter();
		chapter.setDocBookVersion(docBookVersion);

		Info info = new Info();
		chapter.appendChild(info);

		Title title = new Title(titleText);
		info.appendChild(title);

		return chapter;
	}

	public ClassName createClassName() {

		ClassName className = new ClassName();
		className.setDocBookVersion(docBookVersion);
		return className;
	}

	public ClassName createClassName(String name) {

		ClassName className = new ClassName(name);
		className.setDocBookVersion(docBookVersion);
		return className;
	}

	public ClassSynopsis createClassSynopsis() {

		ClassSynopsis classSynopsis = new ClassSynopsis();
		classSynopsis.setDocBookVersion(docBookVersion);
		return classSynopsis;
	}

	public ClassSynopsisInfo createClassSynopsisInfo() {

		ClassSynopsisInfo classSynopsisInfo = new ClassSynopsisInfo();
		classSynopsisInfo.setDocBookVersion(docBookVersion);
		return classSynopsisInfo;
	}

	public ClassSynopsisInfo createClassSynopsisInfo(String text) {

		ClassSynopsisInfo classSynopsisInfo = new ClassSynopsisInfo(text);
		classSynopsisInfo.setDocBookVersion(docBookVersion);
		return classSynopsisInfo;
	}

	public Code createCode() {

		Code code = new Code();
		code.setDocBookVersion(docBookVersion);
		return code;
	}

	public Colspec createColspec() {

		Colspec colspec = new Colspec();
		colspec.setDocBookVersion(docBookVersion);
		return colspec;
	}

	public Colspec createColspec(String string, String width) {

		Colspec colspec = new Colspec(string, width);
		colspec.setDocBookVersion(docBookVersion);
		return colspec;
	}

	public ComputerOutput createComputerOutput() {

		ComputerOutput computerOutput = new ComputerOutput();
		computerOutput.setDocBookVersion(docBookVersion);
		return computerOutput;
	}

	public ComputerOutput createComputerOutput(String text) {

		ComputerOutput computerOutput = new ComputerOutput(text);
		computerOutput.setDocBookVersion(docBookVersion);
		return computerOutput;
	}

	public ConstructorSynopsis createConstructorSynopsis() {

		ConstructorSynopsis constructorSynopsis = new ConstructorSynopsis();
		constructorSynopsis.setDocBookVersion(docBookVersion);
		return constructorSynopsis;
	}

	public Copyright createCopyright() {

		Copyright copyright = new Copyright();
		copyright.setDocBookVersion(docBookVersion);
		return copyright;
	}

	public Date createDate() {

		java.util.Date today = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date(sdf.format(today));
		date.setDocBookVersion(docBookVersion);
		return date;
	}

	public Date createDate(String text) {

		Date date = new Date(text);
		date.setDocBookVersion(docBookVersion);
		return date;
	}

	public Email createEmail() {

		Email email = new Email();
		email.setDocBookVersion(docBookVersion);
		return email;
	}

	public Email createEmail(String address) {

		Email email = new Email();
		email.appendChild(address);
		email.setDocBookVersion(docBookVersion);
		return email;
	}

	public Emphasis createEmphasis() {

		Emphasis emphasis = new Emphasis();
		emphasis.setDocBookVersion(docBookVersion);
		return emphasis;
	}

	public Emphasis createEmphasis(String str) {

		Emphasis emphasis = new Emphasis(str);
		emphasis.setDocBookVersion(docBookVersion);
		return emphasis;
	}

	public Emphasis createEmphasis(String str, String role) {

		Emphasis emphasis = createEmphasis(str);
		emphasis.setRole(role);
		return emphasis;
	}

	public Entry createEntry() {

		Entry entry = new Entry();
		entry.setDocBookVersion(docBookVersion);
		return entry;
	}

	public Entry createEntry(String text) {

		Entry entry = new Entry(text);
		entry.setDocBookVersion(docBookVersion);
		return entry;
	}

	public EntryTbl createEntryTbl() {

		EntryTbl entryTbl = new EntryTbl();
		entryTbl.setDocBookVersion(docBookVersion);
		return entryTbl;
	}

	public Example createExample(String title) {

		Example example = new Example(title);
		example.setDocBookVersion(docBookVersion);
		return example;
	}

	public ExceptionName createExceptionName() {

		ExceptionName exceptionName = new ExceptionName();
		exceptionName.setDocBookVersion(docBookVersion);
		return exceptionName;
	}

	public ExceptionName createExceptionName(String text) {

		ExceptionName exceptionName = new ExceptionName(text);
		exceptionName.setDocBookVersion(docBookVersion);
		return exceptionName;
	}

	public FieldSynopsis createFieldSynopsis() {

		FieldSynopsis fieldSynopsis = new FieldSynopsis();
		fieldSynopsis.setDocBookVersion(docBookVersion);
		return fieldSynopsis;
	}

	public Figure createFigure(String title) {

		Figure figure = new Figure(title);
		figure.setDocBookVersion(docBookVersion);
		return figure;
	}

	public FirstName createFirstName() {

		FirstName firstName = new FirstName();
		firstName.setDocBookVersion(docBookVersion);
		return firstName;
	}

	public FirstName createFirstName(String name) {

		FirstName firstName = new FirstName();
		firstName.appendChild(name);
		firstName.setDocBookVersion(docBookVersion);
		return firstName;
	}

	public FormalPara createFormalPara() {

		FormalPara formalPara = new FormalPara();
		formalPara.setDocBookVersion(docBookVersion);
		return formalPara;
	}

	public DocBookElement createFormalPara(String title) {

		FormalPara formalPara = new FormalPara(title);
		formalPara.setDocBookVersion(docBookVersion);
		return formalPara;
	}

	public FuncDef createFuncDef() {

		FuncDef funcDef = new FuncDef();
		funcDef.setDocBookVersion(docBookVersion);
		return funcDef;
	}

	public FuncPrototype createFuncPrototype() {

		FuncPrototype funcPrototype = new FuncPrototype();
		funcPrototype.setDocBookVersion(docBookVersion);
		return funcPrototype;
	}

	public FuncSynopsis createFuncSynopsis() {

		FuncSynopsis funcSynopsis = new FuncSynopsis();
		funcSynopsis.setDocBookVersion(docBookVersion);
		return funcSynopsis;
	}

	public Function createFunction(String func) {

		Function function = new Function(func);
		function.setDocBookVersion(docBookVersion);
		return function;
	}

	public Holder createHolder() {

		Holder holder = new Holder();
		holder.setDocBookVersion(docBookVersion);
		return holder;
	}

	public Holder createHolder(String text) {

		Holder holder = new Holder();
		holder.appendChild(text);
		holder.setDocBookVersion(docBookVersion);
		return holder;
	}

	public MediaObject createImage(String image) {
		return createImage(image, null, null);
	}

	public MediaObject createImage(String image, String width, String height) {

		MediaObject mediaObject = new MediaObject();
		mediaObject.setDocBookVersion(docBookVersion);

		ImageObject imageObject = new ImageObject();
		imageObject.setDocBookVersion(docBookVersion);
		mediaObject.appendChild(imageObject);

		ImageData imageData = new ImageData();
		imageData.setDocBookVersion(docBookVersion);
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

	public ImageData createImageData() {

		ImageData imageData = new ImageData();
		imageData.setDocBookVersion(docBookVersion);
		return imageData;
	}

	public ImageObject createImageObject() {

		ImageObject imageObject = new ImageObject();
		imageObject.setDocBookVersion(docBookVersion);
		return imageObject;
	}

	public Important createImportant() {

		Important important = new Important();
		important.setDocBookVersion(docBookVersion);
		return important;
	}

	public Index createIndex() {

		Index index = new Index();
		index.setDocBookVersion(docBookVersion);
		return index;
	}

	public IndexTerm createIndexTerm() {

		IndexTerm indexTerm = new IndexTerm();
		indexTerm.setDocBookVersion(docBookVersion);
		return indexTerm;
	}

	public Info createInfo() {

		Info info = new Info();
		info.setDocBookVersion(docBookVersion);
		return info;
	}

	public InformalExample createInformalExample() {

		InformalExample informalExample = new InformalExample();
		informalExample.setDocBookVersion(docBookVersion);
		return informalExample;
	}

	public InformalFigure createInformalFigure() {

		InformalFigure informalFigure = new InformalFigure();
		informalFigure.setDocBookVersion(docBookVersion);
		return informalFigure;
	}

	public InformalTable createInformalTable() {

		InformalTable informalTable = new InformalTable();
		informalTable.setDocBookVersion(docBookVersion);
		return informalTable;
	}

	public Initializer createInitializer() {

		Initializer initializer = new Initializer();
		initializer.setDocBookVersion(docBookVersion);
		return initializer;
	}

	public Initializer createInitializer(String text) {

		Initializer initializer = new Initializer(text);
		initializer.setDocBookVersion(docBookVersion);
		return initializer;
	}

	public InlineMediaObject createInlineMediaObject() {
		InlineMediaObject inlineMediaObject = new InlineMediaObject();
		inlineMediaObject.setDocBookVersion(docBookVersion);
		return inlineMediaObject;
	}

	public InterfaceName createInterfaceName() {

		InterfaceName interfaceName = new InterfaceName();
		interfaceName.setDocBookVersion(docBookVersion);
		return interfaceName;
	}

	public InterfaceName createInterfaceName(String name) {

		InterfaceName interfaceName = new InterfaceName(name);
		interfaceName.setDocBookVersion(docBookVersion);
		return interfaceName;
	}

	public ItemizedList createItemizedList() {

		ItemizedList itemizedList = new ItemizedList();
		itemizedList.setDocBookVersion(docBookVersion);
		return itemizedList;
	}

	public Keyword createKeyword() {
		Keyword keyword = new Keyword();
		keyword.setDocBookVersion(docBookVersion);
		return keyword;
	}

	public Keywordset createKeywordset() {
		Keywordset keywordset = new Keywordset();
		keywordset.setDocBookVersion(docBookVersion);
		return keywordset;
	}

	public LegalNotice createLegalNotice() {

		LegalNotice legalNotice = new LegalNotice();
		legalNotice.setDocBookVersion(docBookVersion);
		return legalNotice;
	}

	public Link createLink() {

		Link link = new Link();
		link.setDocBookVersion(docBookVersion);
		return link;
	}

	public Link createLink(Literal literal, String ref) {

		Link link = new Link(literal, ref);
		link.setDocBookVersion(docBookVersion);
		return link;
	}

	public Link createLink(String href) {

		Link link = new Link(href);
		link.setDocBookVersion(docBookVersion);
		return link;
	}

	public Link createLink(String label, String ref) {

		Link link = new Link(label, ref);
		link.setDocBookVersion(docBookVersion);
		return link;
	}

	public Link createLink(VarName varName, String ref) {

		Link link = new Link(varName, ref);
		link.setDocBookVersion(docBookVersion);
		return link;
	}

	public String createLinkAsString(String label, String ref)
			throws IOException {

		Link link = new Link(label, ref);
		link.setDocBookVersion(docBookVersion);
		return NodeSerializer.toXML(link);
	}

	public ListItem createListItem() {

		ListItem listItem = new ListItem();
		listItem.setDocBookVersion(docBookVersion);
		return listItem;
	}

	public Literal createLiteral() {

		Literal literal = new Literal();
		literal.setDocBookVersion(docBookVersion);
		return literal;
	}

	public Literal createLiteral(String text) {

		Literal literal = new Literal(text);
		literal.setDocBookVersion(docBookVersion);
		return literal;
	}

	public ManVolNum createManVolNum(String num) {

		ManVolNum manVolNum = new ManVolNum(num);
		manVolNum.setDocBookVersion(docBookVersion);
		return manVolNum;
	}

	public MediaObject createMediaObject() {

		MediaObject mediaObject = new MediaObject();
		mediaObject.setDocBookVersion(docBookVersion);
		return mediaObject;
	}

	public Member createMember() {

		Member member = new Member();
		member.setDocBookVersion(docBookVersion);
		return member;
	}

	public MethodName createMethodName() {

		MethodName methodName = new MethodName();
		methodName.setDocBookVersion(docBookVersion);
		return methodName;
	}

	public MethodName createMethodName(String text) {

		MethodName methodName = new MethodName(text);
		methodName.setDocBookVersion(docBookVersion);
		return methodName;
	}

	public MethodParam createMethodParam() {

		MethodParam methodParam = new MethodParam();
		methodParam.setDocBookVersion(docBookVersion);
		return methodParam;
	}

	public MethodSynopsis createMethodSynopsis() {

		MethodSynopsis methodSynopsis = new MethodSynopsis();
		methodSynopsis.setDocBookVersion(docBookVersion);
		return methodSynopsis;
	}

	public Modifier createModifier() {

		Modifier modifier = new Modifier();
		modifier.setDocBookVersion(docBookVersion);
		return modifier;
	}

	public Modifier createModifier(String text) {

		Modifier modifier = new Modifier();
		modifier.appendChild(text);
		modifier.setDocBookVersion(docBookVersion);
		return modifier;
	}

	public Note createNote() {

		Note note = new Note();
		note.setDocBookVersion(docBookVersion);
		return note;
	}

	public Olink createOlink(String label, String targetdoc, String targetptr) {

		Olink olink = new Olink(label, targetdoc, targetptr);
		olink.setDocBookVersion(docBookVersion);
		return olink;
	}

	public OoClass createOoClass() {

		OoClass ooClass = new OoClass();
		ooClass.setDocBookVersion(docBookVersion);
		return ooClass;
	}

	public OoException createOoException() {

		OoException ooException = new OoException();
		ooException.setDocBookVersion(docBookVersion);
		return ooException;
	}

	public OoInterface createOoInterface() {

		OoInterface ooInterface = new OoInterface();
		ooInterface.setDocBookVersion(docBookVersion);
		return ooInterface;
	}

	public OrderedList createOrderedList() {

		OrderedList orderedList = new OrderedList();
		orderedList.setDocBookVersion(docBookVersion);
		return orderedList;
	}

	public Para createPara() {

		Para para = new Para();
		para.setDocBookVersion(docBookVersion);
		return para;
	}

	public Para createPara(String text) {

		Para para = new Para(text);
		para.setDocBookVersion(docBookVersion);
		return para;
	}

	public ParamDef createParamDef() {

		ParamDef paramDef = new ParamDef();
		paramDef.setDocBookVersion(docBookVersion);
		return paramDef;
	}

	public Parameter createParameter(String name) {

		Parameter parameter = new Parameter(name);
		parameter.setDocBookVersion(docBookVersion);
		return parameter;
	}

	public Part createPart() {

		Part part = new Part();
		part.setDocBookVersion(docBookVersion);
		return part;
	}

	public PartInfo createPartInfo() {

		PartInfo partInfo = new PartInfo();
		partInfo.setDocBookVersion(docBookVersion);
		return partInfo;
	}

	public PartIntro createPartIntro() {

		PartIntro partIntro = new PartIntro();
		partIntro.setDocBookVersion(docBookVersion);
		return partIntro;
	}

	public Personname createPersonname() {

		Personname personname = new Personname();
		personname.setDocBookVersion(docBookVersion);
		return personname;
	}

	public Phrase createPhrase() {

		Phrase phrase = new Phrase();
		phrase.setDocBookVersion(docBookVersion);
		return phrase;
	}

	public Primary createPrimary(String key) {

		Primary primary = new Primary(key);
		primary.setDocBookVersion(docBookVersion);
		return primary;
	}

	public ProgramListing createProgramListing() {

		ProgramListing programListing = new ProgramListing();
		programListing.setDocBookVersion(docBookVersion);
		return programListing;
	}

	public ProgramListing createProgramListing(String str) {

		ProgramListing programListing = new ProgramListing(str);
		programListing.setDocBookVersion(docBookVersion);
		return programListing;
	}

	public Quote createQuote() {

		Quote quote = new Quote();
		quote.setDocBookVersion(docBookVersion);
		return quote;
	}

	public RefEntry createRefEntry() {

		RefEntry refEntry = new RefEntry();
		refEntry.setDocBookVersion(docBookVersion);
		return refEntry;
	}

	public RefEntryInfo createRefEntryInfo() {

		RefEntryInfo refEntryInfo = new RefEntryInfo();
		refEntryInfo.setDocBookVersion(docBookVersion);
		return refEntryInfo;
	}

	public Reference createReference() {

		Reference reference = new Reference();
		reference.setDocBookVersion(docBookVersion);
		return reference;
	}

	public RefMeta createRefMeta() {

		RefMeta refMeta = new RefMeta();
		refMeta.setDocBookVersion(docBookVersion);
		return refMeta;
	}

	public RefMiscInfo createRefMiscInfo(String clazz, String info) {

		RefMiscInfo refMiscInfo = new RefMiscInfo(clazz, info);
		refMiscInfo.setDocBookVersion(docBookVersion);
		return refMiscInfo;
	}

	public RefName createRefName(String name) {

		RefName refName = new RefName(name);
		refName.setDocBookVersion(docBookVersion);
		return refName;
	}

	public RefNameDiv createRefNameDiv() {

		RefNameDiv refNameDiv = new RefNameDiv();
		refNameDiv.setDocBookVersion(docBookVersion);
		return refNameDiv;
	}

	public RefPurpose createRefPurpose() {

		RefPurpose refPurpose = new RefPurpose();
		refPurpose.setDocBookVersion(docBookVersion);
		return refPurpose;
	}

	public RefSect1 createRefSect1() {

		RefSect1 refSect1 = new RefSect1();
		refSect1.setDocBookVersion(docBookVersion);
		return refSect1;
	}

	public RefSect1 createRefSect1(String title) {

		RefSect1 refSect1 = new RefSect1(title);
		refSect1.setDocBookVersion(docBookVersion);
		return refSect1;
	}

	public RefSect2 createRefSect2() {

		RefSect2 refSect2 = new RefSect2();
		refSect2.setDocBookVersion(docBookVersion);
		return refSect2;
	}

	public RefSect2 createRefSect2(String title) {

		RefSect2 refSect2 = new RefSect2(title);
		refSect2.setDocBookVersion(docBookVersion);
		return refSect2;
	}

	public RefSect3 createRefSect3() {

		RefSect3 refSect3 = new RefSect3();
		refSect3.setDocBookVersion(docBookVersion);
		return refSect3;
	}

	public RefSect4 createRefSect4() {

		RefSect4 refSect4 = new RefSect4();
		refSect4.setDocBookVersion(docBookVersion);
		return refSect4;
	}

	public RefSect5 createRefSect5() {

		RefSect5 refSect5 = new RefSect5();
		refSect5.setDocBookVersion(docBookVersion);
		return refSect5;
	}

	public RefSection createRefSection() {

		RefSection refSection = new RefSection();
		refSection.setDocBookVersion(docBookVersion);
		return refSection;
	}

	public RefSection createRefSection(String title) {

		RefSection refSection = new RefSection(title);
		refSection.setDocBookVersion(docBookVersion);
		return refSection;
	}

	public RefSynopsisDiv createRefSynopsisDiv() {

		RefSynopsisDiv refSynopsisDiv = new RefSynopsisDiv();
		refSynopsisDiv.setDocBookVersion(docBookVersion);
		return refSynopsisDiv;
	}

	public ReleaseInfo createReleaseInfo() {

		ReleaseInfo releaseInfo = new ReleaseInfo();
		releaseInfo.setDocBookVersion(docBookVersion);
		return releaseInfo;
	}

	public ReleaseInfo createReleaseInfo(String text) {

		ReleaseInfo releaseInfo = new ReleaseInfo();
		releaseInfo.appendChild(text);
		releaseInfo.setDocBookVersion(docBookVersion);
		return releaseInfo;
	}

	public Row createRow() {

		Row row = new Row();
		row.setDocBookVersion(docBookVersion);
		return row;
	}

	public Screen createScreen() {

		Screen screen = new Screen();
		screen.setDocBookVersion(docBookVersion);
		return screen;
	}

	public Secondary createSecondary(String key) {

		Secondary secondary = new Secondary(key);
		secondary.setDocBookVersion(docBookVersion);
		return secondary;
	}

	public Sect1 createSect1() {

		Sect1 sect1 = new Sect1();
		sect1.setDocBookVersion(docBookVersion);
		return sect1;
	}

	public Sect1 createSect1(String title) {

		Sect1 sect1 = new Sect1(title);
		sect1.setDocBookVersion(docBookVersion);
		return sect1;
	}

	public Sect2 createSect2() {

		Sect2 sect2 = new Sect2();
		sect2.setDocBookVersion(docBookVersion);
		return sect2;
	}

	public Sect2 createSect2(String str) {

		Sect2 sect2 = new Sect2(str);
		sect2.setDocBookVersion(docBookVersion);
		return sect2;
	}

	public Sect3 createSect3() {

		Sect3 sect3 = new Sect3();
		sect3.setDocBookVersion(docBookVersion);
		return sect3;
	}

	public Sect3 createSect3(String str) {

		Sect3 sect3 = new Sect3(str);
		sect3.setDocBookVersion(docBookVersion);
		return sect3;
	}

	public Sect4 createSect4() {

		Sect4 sect4 = new Sect4();
		sect4.setDocBookVersion(docBookVersion);
		return sect4;
	}

	public Sect5 createSect5() {
		Sect5 sect5 = new Sect5();

		sect5.setDocBookVersion(docBookVersion);
		return sect5;
	}

	public Section createSection() {

		Section section = new Section();
		section.setDocBookVersion(docBookVersion);
		return section;
	}

	public Section createSection(String title) {

		Section section = new Section(title);
		section.setDocBookVersion(docBookVersion);
		return section;
	}

	public SimPara createSimPara() {

		SimPara simPara = new SimPara();
		simPara.setDocBookVersion(docBookVersion);
		return simPara;
	}

	public SimPara createSimPara(String text) {

		SimPara simPara = new SimPara();
		simPara.appendChild(text);
		simPara.setDocBookVersion(docBookVersion);
		return simPara;
	}

	public SimpleList createSimpleList() {

		SimpleList simpleList = new SimpleList();
		simpleList.setDocBookVersion(docBookVersion);
		return simpleList;
	}

	public SimpleList createSimpleList(int type) {

		SimpleList simpleList = createSimpleList();
		simpleList.setType(type);
		return simpleList;
	}

	public SimpleSect createSimpleSect() {

		SimpleSect simpleSect = new SimpleSect();
		simpleSect.setDocBookVersion(docBookVersion);
		return simpleSect;
	}

	public Spanspec createSpanspec() {

		Spanspec spanspec = new Spanspec();
		spanspec.setDocBookVersion(docBookVersion);
		return spanspec;
	}

	public Subject createSubject() {
		Subject subject = new Subject();
		subject.setDocBookVersion(docBookVersion);
		return subject;
	}

	public Subjectset createSubjectset() {
		Subjectset subjectset = new Subjectset();
		subjectset.setDocBookVersion(docBookVersion);
		return subjectset;
	}

	public Subjectterm createSubjectterm() {
		Subjectterm subjectterm = new Subjectterm();
		subjectterm.setDocBookVersion(docBookVersion);
		return subjectterm;
	}

	public Subscript createSubscript() {
		Subscript subscript = new Subscript();
		subscript.setDocBookVersion(docBookVersion);
		return subscript;
	}

	public Superscript createSuperscript() {

		Superscript superscript = new Superscript();
		superscript.setDocBookVersion(docBookVersion);
		return superscript;
	}

	public Surname createSurname() {

		Surname surname = new Surname();
		surname.setDocBookVersion(docBookVersion);
		return surname;
	}

	public Surname createSurname(String name) {

		Surname surname = new Surname();
		surname.appendChild(name);
		surname.setDocBookVersion(docBookVersion);
		return surname;
	}

	public Synopsis createSynopsis() {

		Synopsis synopsis = new Synopsis();
		synopsis.setDocBookVersion(docBookVersion);
		return synopsis;
	}

	public Table createTable() {

		Table table = new Table();
		table.setDocBookVersion(docBookVersion);
		return table;
	}

	public DocBookElement createTag(String name)
			throws DocBookTagFactoryException {

		DocBookElement docBookElement = new DocBookElement(name);
		docBookElement.setDocBookVersion(docBookVersion);
		return docBookElement;
	}

	public Tbody createTbody() {

		Tbody tbody = new Tbody();
		tbody.setDocBookVersion(docBookVersion);
		return tbody;
	}

	public Term createTerm() {

		Term term = new Term();
		term.setDocBookVersion(docBookVersion);
		return term;
	}

	public TextObject createTextObject() {

		TextObject textObject = new TextObject();
		textObject.setDocBookVersion(docBookVersion);
		return textObject;
	}

	public Tfoot createTfoot() {

		Tfoot tfoot = new Tfoot();
		tfoot.setDocBookVersion(docBookVersion);
		return tfoot;
	}

	public Tgroup createTgroup() {

		Tgroup tgroup = new Tgroup();
		tgroup.setDocBookVersion(docBookVersion);
		return tgroup;
	}

	public Tgroup createTgroup(int cols) {

		Tgroup tgroup = new Tgroup();
		tgroup.setDocBookVersion(docBookVersion);
		tgroup.setCols(2);
		tgroup.appendChild(new Colspec("c1", "1*"));
		tgroup.appendChild(new Colspec("c2", "1*"));

		return tgroup;
	}

	public Thead createThead() {

		Thead thead = new Thead();
		thead.setDocBookVersion(docBookVersion);
		return thead;
	}

	public Tip createTip() {

		Tip tip = new Tip();
		tip.setDocBookVersion(docBookVersion);
		return tip;
	}

	public Title createTitle() {

		Title title = new Title();
		title.setDocBookVersion(docBookVersion);
		return title;
	}

	public Title createTitle(String str) {

		Title title = new Title(str);
		title.setDocBookVersion(docBookVersion);
		return title;
	}

	public Type createType() {

		Type type = new Type();
		type.setDocBookVersion(docBookVersion);
		return type;
	}

	public ULink createULink() {

		ULink uLink = new ULink();
		uLink.setDocBookVersion(docBookVersion);
		return uLink;
	}

	public VariableList createVariableList() {

		VariableList variableList = new VariableList();
		variableList.setDocBookVersion(docBookVersion);
		return variableList;
	}

	public VarListEntry createVarListEntry() {

		VarListEntry varListEntry = new VarListEntry();
		varListEntry.setDocBookVersion(docBookVersion);
		return varListEntry;
	}

	public VarName createVarName() {

		VarName varName = new VarName();
		varName.setDocBookVersion(docBookVersion);
		return varName;
	}

	public VarName createVarName(String text) {

		VarName varName = new VarName(text);
		varName.setDocBookVersion(docBookVersion);
		return varName;
	}

	public Void createVoid() {

		Void _void = new Void();
		_void.setDocBookVersion(docBookVersion);
		return _void;
	}

	public Warning createWarning() {

		Warning warning = new Warning();
		warning.setDocBookVersion(docBookVersion);
		return warning;
	}

	public Warning createWarning(String text) {

		Warning warning = new Warning(text);
		warning.setDocBookVersion(docBookVersion);
		return warning;
	}

	public XRef createXRef(String linkend) {

		XRef xref = new XRef(linkend);
		xref.setDocBookVersion(docBookVersion);
		return xref;
	}

	public Year createYear() {

		Year year = new Year();
		year.setDocBookVersion(docBookVersion);
		return year;
	}

	public Year createYear(String text) {

		Year year = new Year();
		year.appendChild(text);
		year.setDocBookVersion(docBookVersion);
		return year;
	}

	public DocBookVersion getDocBookVersion() {
		return docBookVersion;
	}

	public boolean isDocBook5() {

		if (docBookVersion != null && docBookVersion == DocBookVersion.V5_0) {
			return true;
		}

		return false;
	}
	public void createFoImageData(DocBookElement parent,
			DocBookTagFactory dbfactory, List<String> imageDataFormats,
			Img img, File file) throws IOException {

		String fileRef = FileServices.normalizePath(file.getPath());
		fileRef = FileServices.getFileBase(fileRef);

		if (FileServices.isAbsolutePath(fileRef)) {

			fileRef = FileServices.normalizePath(fileRef);

			if (fileRef.startsWith("/")) {
				fileRef = "file://" + fileRef;
			} else {
				fileRef = "file:///" + fileRef;
			}
		}

		int index = 0;

		for (String format : imageDataFormats) {

			ImageObject image = dbfactory.createImageObject();

			if (index == 0) {
				image.setRole("fo");
			} else {
				image.setRole("fo-" + format.toLowerCase());
			}

			String align = img.getAlign();

			ImageData data = dbfactory.createImageData();

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
			index++;
		}
	}

	public void createHtmlImageData(DocBookElement parent,
			DocBookTagFactory dbfactory, List<String> imageDataFormats,
			Img img, File file) throws IOException {

		String fileRef = FileServices.normalizePath(file.getPath());

		if (FileServices.isAbsolutePath(fileRef)) {

			fileRef = FileServices.normalizePath(fileRef);

			if (fileRef.startsWith("/")) {
				fileRef = "file://" + fileRef;
			} else {
				fileRef = "file:///" + fileRef;
			}
		}

		fileRef = FileServices.getFileBase(fileRef);
		int index = 0;

		for (String format : imageDataFormats) {

			String width = img.getWidth();
			String height = img.getHeight();
			String align = img.getAlign();

			ImageObject image = dbfactory.createImageObject();

			if (index == 0) {
				image.setRole("html");
			} else {
				image.setRole("html-" + format.toLowerCase());
			}

			ImageData data = dbfactory.createImageData();
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
			index++;
		}
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

}