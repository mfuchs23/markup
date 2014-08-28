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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.dbdoclet.service.FileServices;
import org.dbdoclet.tag.html.Img;
import org.dbdoclet.xiphias.ImageServices;
import org.dbdoclet.xiphias.NodeSerializer;
import org.dbdoclet.xiphias.XmlConstants;

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
		initialize(abbrev);
		return abbrev;
	}

	private void initialize(DocBookElement elem) {
		elem.setDocBookVersion(docBookVersion);
		elem.setNamespaceURI(XmlConstants.NAMESPACE_DOCBOOK);
	}

	public Abstract createAbstract() {

		Abstract _abstract = new Abstract();
		initialize(_abstract);
		return _abstract;
	}

	public Acronym createAcronym() {

		Acronym acronym = new Acronym();
		initialize(acronym);
		return acronym;
	}

	public Address createAddress() {

		Address address = new Address();
		initialize(address);
		return address;
	}

	public Affiliation createAffiliation() {

		Affiliation affiliation = new Affiliation();
		initialize(affiliation);
		return affiliation;
	}

	public Anchor createAnchor() {

		Anchor anchor = new Anchor();
		initialize(anchor);
		return anchor;
	}

	public Appendix createAppendix() {

		Appendix appendix = new Appendix();
		initialize(appendix);
		return appendix;
	}

	public Article createArticle() {

		Article article = new Article();
		initialize(article);
		return article;
	}

	public ArticleInfo createArticleInfo() {

		ArticleInfo articleInfo = new ArticleInfo();
		initialize(articleInfo);
		return articleInfo;
	}

	public Author createAuthor() {

		Author author = new Author();
		initialize(author);
		return author;
	}

	public BlockQuote createBlockQuote() {

		BlockQuote blockQuote = new BlockQuote();
		initialize(blockQuote);
		return blockQuote;
	}

	public Book createBook() {

		Book book = new Book();
		initialize(book);
		return book;
	}

	public BookInfo createBookInfo() {

		BookInfo bookInfo = new BookInfo();
		initialize(bookInfo);
		return bookInfo;
	}

	public BridgeHead createBridgeHead() {

		BridgeHead bridgeHead = new BridgeHead();
		initialize(bridgeHead);
		return bridgeHead;
	}

	public Caption createCaption() {

		Caption caption = new Caption();
		initialize(caption);
		return caption;
	}

	public Caution createCaution() {

		Caution caution = new Caution();
		initialize(caution);
		return caution;
	}

	public Chapter createChapter() {

		Chapter chapter = new Chapter();
		initialize(chapter);
		return chapter;
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

	public ClassName createClassName() {

		ClassName className = new ClassName();
		initialize(className);
		return className;
	}

	public ClassName createClassName(String name) {

		ClassName className = new ClassName(name);
		initialize(className);
		return className;
	}

	public ClassSynopsis createClassSynopsis() {

		ClassSynopsis classSynopsis = new ClassSynopsis();
		initialize(classSynopsis);
		return classSynopsis;
	}

	public ClassSynopsisInfo createClassSynopsisInfo() {

		ClassSynopsisInfo classSynopsisInfo = new ClassSynopsisInfo();
		initialize(classSynopsisInfo);
		return classSynopsisInfo;
	}

	public ClassSynopsisInfo createClassSynopsisInfo(String text) {

		ClassSynopsisInfo classSynopsisInfo = new ClassSynopsisInfo(text);
		initialize(classSynopsisInfo);
		return classSynopsisInfo;
	}

	public Code createCode() {

		Code code = new Code();
		initialize(code);
		return code;
	}

	public Colspec createColspec() {

		Colspec colspec = new Colspec();
		initialize(colspec);
		return colspec;
	}

	public Colspec createColspec(String string, String width) {

		Colspec colspec = new Colspec(string, width);
		initialize(colspec);
		return colspec;
	}

	public ComputerOutput createComputerOutput() {

		ComputerOutput computerOutput = new ComputerOutput();
		initialize(computerOutput);
		return computerOutput;
	}

	public ComputerOutput createComputerOutput(String text) {

		ComputerOutput computerOutput = new ComputerOutput(text);
		initialize(computerOutput);
		return computerOutput;
	}

	public ConstructorSynopsis createConstructorSynopsis() {

		ConstructorSynopsis constructorSynopsis = new ConstructorSynopsis();
		initialize(constructorSynopsis);
		return constructorSynopsis;
	}

	public Copyright createCopyright() {

		Copyright copyright = new Copyright();
		initialize(copyright);
		return copyright;
	}

	public Date createDate() {

		java.util.Date today = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date(sdf.format(today));
		initialize(date);
		return date;
	}

	public Date createDate(String text) {

		Date date = new Date(text);
		initialize(date);
		return date;
	}

	public Email createEmail() {

		Email email = new Email();
		initialize(email);
		return email;
	}

	public Email createEmail(String address) {

		Email email = createEmail();
		email.appendChild(address);
		return email;
	}

	public Emphasis createEmphasis() {

		Emphasis emphasis = new Emphasis();
		initialize(emphasis);
		return emphasis;
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

	public Entry createEntry() {

		Entry entry = new Entry();
		initialize(entry);
		return entry;
	}

	public Entry createEntry(String text) {

		Entry entry = new Entry(text);
		initialize(entry);
		return entry;
	}

	public EntryTbl createEntryTbl() {

		EntryTbl entryTbl = new EntryTbl();
		initialize(entryTbl);
		return entryTbl;
	}

	public Example createExample(String title) {

		Example example = new Example();
		initialize(example);
		example.appendChild(createTitle(title));
		return example;
	}

	public ExceptionName createExceptionName() {

		ExceptionName exceptionName = new ExceptionName();
		initialize(exceptionName);
		return exceptionName;
	}

	public ExceptionName createExceptionName(String text) {

		ExceptionName exceptionName = new ExceptionName(text);
		initialize(exceptionName);
		return exceptionName;
	}

	public FieldSynopsis createFieldSynopsis() {

		FieldSynopsis fieldSynopsis = new FieldSynopsis();
		initialize(fieldSynopsis);
		return fieldSynopsis;
	}

	public Figure createFigure(String title) {

		Figure figure = new Figure();
		initialize(figure);
		figure.appendChild(createTitle(title));
		return figure;
	}

	public FirstName createFirstName() {

		FirstName firstName = new FirstName();
		initialize(firstName);
		return firstName;
	}

	public FirstName createFirstName(String name) {

		FirstName firstName = createFirstName();
		firstName.appendChild(name);
		return firstName;
	}

	public FormalPara createFormalPara() {

		FormalPara formalPara = new FormalPara();
		initialize(formalPara);
		return formalPara;
	}

	public DocBookElement createFormalPara(String text) {

		FormalPara formalPara = createFormalPara();
		formalPara.appendChild(text);
		return formalPara;
	}

	public FuncDef createFuncDef() {

		FuncDef funcDef = new FuncDef();
		initialize(funcDef);
		return funcDef;
	}

	public FuncPrototype createFuncPrototype() {

		FuncPrototype funcPrototype = new FuncPrototype();
		initialize(funcPrototype);
		return funcPrototype;
	}

	public FuncSynopsis createFuncSynopsis() {

		FuncSynopsis funcSynopsis = new FuncSynopsis();
		initialize(funcSynopsis);
		return funcSynopsis;
	}

	public Function createFunction(String func) {

		Function function = new Function(func);
		initialize(function);
		return function;
	}

	public Holder createHolder() {

		Holder holder = new Holder();
		initialize(holder);
		return holder;
	}

	public Holder createHolder(String text) {

		Holder holder = new Holder();
		holder.appendChild(text);
		initialize(holder);
		return holder;
	}

	public MediaObject createImage(String image) {
		return createImage(image, null, null);
	}

	public MediaObject createImage(String image, String width, String height) {

		MediaObject mediaObject = createMediaObject();

		ImageObject imageObject = createImageObject();
		mediaObject.appendChild(imageObject);

		ImageData imageData = createImageData();
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
		initialize(imageData);
		return imageData;
	}

	public ImageObject createImageObject() {

		ImageObject imageObject = new ImageObject();
		initialize(imageObject);
		return imageObject;
	}

	public Important createImportant() {

		Important important = new Important();
		initialize(important);
		return important;
	}

	public Index createIndex() {

		Index index = new Index();
		initialize(index);
		return index;
	}

	public IndexTerm createIndexTerm() {

		IndexTerm indexTerm = new IndexTerm();
		initialize(indexTerm);
		return indexTerm;
	}

	public Info createInfo() {

		Info info = new Info();
		initialize(info);
		return info;
	}

	public InformalExample createInformalExample() {

		InformalExample informalExample = new InformalExample();
		initialize(informalExample);
		return informalExample;
	}

	public InformalFigure createInformalFigure() {

		InformalFigure informalFigure = new InformalFigure();
		initialize(informalFigure);
		return informalFigure;
	}

	public InformalTable createInformalTable() {

		InformalTable informalTable = new InformalTable();
		initialize(informalTable);
		return informalTable;
	}

	public Initializer createInitializer() {

		Initializer initializer = new Initializer();
		initialize(initializer);
		return initializer;
	}

	public Initializer createInitializer(String text) {

		Initializer initializer = new Initializer(text);
		initialize(initializer);
		return initializer;
	}

	public InlineMediaObject createInlineMediaObject() {
		InlineMediaObject inlineMediaObject = new InlineMediaObject();
		initialize(inlineMediaObject);
		return inlineMediaObject;
	}

	public InterfaceName createInterfaceName() {

		InterfaceName interfaceName = new InterfaceName();
		initialize(interfaceName);
		return interfaceName;
	}

	public InterfaceName createInterfaceName(String name) {

		InterfaceName interfaceName = new InterfaceName(name);
		initialize(interfaceName);
		return interfaceName;
	}

	public ItemizedList createItemizedList() {

		ItemizedList itemizedList = new ItemizedList();
		initialize(itemizedList);
		return itemizedList;
	}

	public Keyword createKeyword() {
		Keyword keyword = new Keyword();
		initialize(keyword);
		return keyword;
	}

	public Keywordset createKeywordset() {
		Keywordset keywordset = new Keywordset();
		initialize(keywordset);
		return keywordset;
	}

	public LegalNotice createLegalNotice() {

		LegalNotice legalNotice = new LegalNotice();
		initialize(legalNotice);
		return legalNotice;
	}

	public Link createLink() {

		Link link = new Link();
		initialize(link);
		return link;
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

	public Link createLink(VarName varName, String ref) {

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

	public ListItem createListItem() {

		ListItem listItem = new ListItem();
		initialize(listItem);
		return listItem;
	}

	public Literal createLiteral() {

		Literal literal = new Literal();
		initialize(literal);
		return literal;
	}

	public Literal createLiteral(String text) {

		Literal literal = new Literal(text);
		initialize(literal);
		return literal;
	}

	public ManVolNum createManVolNum(String num) {

		ManVolNum manVolNum = new ManVolNum(num);
		initialize(manVolNum);
		return manVolNum;
	}

	public MediaObject createMediaObject() {

		MediaObject mediaObject = new MediaObject();
		initialize(mediaObject);
		return mediaObject;
	}

	public Member createMember() {

		Member member = new Member();
		initialize(member);
		return member;
	}

	public MethodName createMethodName() {

		MethodName methodName = new MethodName();
		initialize(methodName);
		return methodName;
	}

	public MethodName createMethodName(String text) {

		MethodName methodName = new MethodName(text);
		initialize(methodName);
		return methodName;
	}

	public MethodParam createMethodParam() {

		MethodParam methodParam = new MethodParam();
		initialize(methodParam);
		return methodParam;
	}

	public MethodSynopsis createMethodSynopsis() {

		MethodSynopsis methodSynopsis = new MethodSynopsis();
		initialize(methodSynopsis);
		return methodSynopsis;
	}

	public Modifier createModifier() {

		Modifier modifier = new Modifier();
		initialize(modifier);
		return modifier;
	}

	public Modifier createModifier(String text) {

		Modifier modifier = new Modifier();
		modifier.appendChild(text);
		initialize(modifier);
		return modifier;
	}

	public Note createNote() {

		Note note = new Note();
		initialize(note);
		return note;
	}

	public Olink createOlink(String label, String targetdoc, String targetptr) {

		Olink olink = new Olink(label, targetdoc, targetptr);
		initialize(olink);
		return olink;
	}

	public OoClass createOoClass() {

		OoClass ooClass = new OoClass();
		initialize(ooClass);
		return ooClass;
	}

	public OoException createOoException() {

		OoException ooException = new OoException();
		initialize(ooException);
		return ooException;
	}

	public OoInterface createOoInterface() {

		OoInterface ooInterface = new OoInterface();
		initialize(ooInterface);
		return ooInterface;
	}

	public OrderedList createOrderedList() {

		OrderedList orderedList = new OrderedList();
		initialize(orderedList);
		return orderedList;
	}

	public Para createPara() {

		Para para = new Para();
		initialize(para);
		return para;
	}

	public Para createPara(String text) {

		Para para = new Para(text);
		initialize(para);
		return para;
	}

	public ParamDef createParamDef() {

		ParamDef paramDef = new ParamDef();
		initialize(paramDef);
		return paramDef;
	}

	public Parameter createParameter(String name) {

		Parameter parameter = new Parameter(name);
		initialize(parameter);
		return parameter;
	}

	public Part createPart() {

		Part part = new Part();
		initialize(part);
		return part;
	}

	public PartInfo createPartInfo() {

		PartInfo partInfo = new PartInfo();
		initialize(partInfo);
		return partInfo;
	}

	public PartIntro createPartIntro() {

		PartIntro partIntro = new PartIntro();
		initialize(partIntro);
		return partIntro;
	}

	public Personname createPersonname() {

		Personname personname = new Personname();
		initialize(personname);
		return personname;
	}

	public Phrase createPhrase() {

		Phrase phrase = new Phrase();
		initialize(phrase);
		return phrase;
	}

	public Primary createPrimary(String key) {

		Primary primary = new Primary(key);
		initialize(primary);
		return primary;
	}

	public ProgramListing createProgramListing() {

		ProgramListing programListing = new ProgramListing();
		initialize(programListing);
		return programListing;
	}

	public ProgramListing createProgramListing(String str) {

		ProgramListing programListing = new ProgramListing(str);
		initialize(programListing);
		return programListing;
	}

	public Quote createQuote() {

		Quote quote = new Quote();
		initialize(quote);
		return quote;
	}

	public RefEntry createRefEntry() {

		RefEntry refEntry = new RefEntry();
		initialize(refEntry);
		return refEntry;
	}

	public RefEntryInfo createRefEntryInfo() {

		RefEntryInfo refEntryInfo = new RefEntryInfo();
		initialize(refEntryInfo);
		return refEntryInfo;
	}

	public Reference createReference() {

		Reference reference = new Reference();
		initialize(reference);
		return reference;
	}

	public RefMeta createRefMeta() {

		RefMeta refMeta = new RefMeta();
		initialize(refMeta);
		return refMeta;
	}

	public RefMiscInfo createRefMiscInfo(String clazz, String info) {

		RefMiscInfo refMiscInfo = new RefMiscInfo(clazz, info);
		initialize(refMiscInfo);
		return refMiscInfo;
	}

	public RefName createRefName(String name) {

		RefName refName = new RefName(name);
		initialize(refName);
		return refName;
	}

	public RefNameDiv createRefNameDiv() {

		RefNameDiv refNameDiv = new RefNameDiv();
		initialize(refNameDiv);
		return refNameDiv;
	}

	public RefPurpose createRefPurpose() {

		RefPurpose refPurpose = new RefPurpose();
		initialize(refPurpose);
		return refPurpose;
	}

	public RefSect1 createRefSect1() {

		RefSect1 refSect1 = new RefSect1();
		initialize(refSect1);
		return refSect1;
	}

	public RefSect1 createRefSect1(String title) {

		RefSect1 refSect1 = createRefSect1();
		refSect1.appendChild(createTitle(title));
		return refSect1;
	}

	public RefSect2 createRefSect2() {

		RefSect2 refSect2 = new RefSect2();
		initialize(refSect2);
		return refSect2;
	}

	public RefSect2 createRefSect2(String title) {

		RefSect2 refSect2 = createRefSect2();
		refSect2.appendChild(createTitle(title));
		initialize(refSect2);
		return refSect2;
	}

	public RefSect3 createRefSect3() {

		RefSect3 refSect3 = new RefSect3();
		initialize(refSect3);
		return refSect3;
	}

	public RefSect4 createRefSect4() {

		RefSect4 refSect4 = new RefSect4();
		initialize(refSect4);
		return refSect4;
	}

	public RefSect5 createRefSect5() {

		RefSect5 refSect5 = new RefSect5();
		initialize(refSect5);
		return refSect5;
	}

	public RefSection createRefSection() {

		RefSection refSection = new RefSection();
		initialize(refSection);
		return refSection;
	}

	public RefSection createRefSection(String title) {

		RefSection refSection = createRefSection();
		refSection.appendChild(createTitle(title));
		return refSection;
	}

	public RefSynopsisDiv createRefSynopsisDiv() {

		RefSynopsisDiv refSynopsisDiv = new RefSynopsisDiv();
		initialize(refSynopsisDiv);
		return refSynopsisDiv;
	}

	public ReleaseInfo createReleaseInfo() {

		ReleaseInfo releaseInfo = new ReleaseInfo();
		initialize(releaseInfo);
		return releaseInfo;
	}

	public ReleaseInfo createReleaseInfo(String text) {

		ReleaseInfo releaseInfo = new ReleaseInfo();
		releaseInfo.appendChild(text);
		initialize(releaseInfo);
		return releaseInfo;
	}

	public Row createRow() {

		Row row = new Row();
		initialize(row);
		return row;
	}

	public Screen createScreen() {

		Screen screen = new Screen();
		initialize(screen);
		return screen;
	}

	public Secondary createSecondary(String key) {

		Secondary secondary = new Secondary(key);
		initialize(secondary);
		return secondary;
	}

	public Sect1 createSect1() {

		Sect1 sect1 = new Sect1();
		initialize(sect1);
		return sect1;
	}

	public Sect1 createSect1(String title) {

		Sect1 sect1 = createSect1();
		sect1.appendChild(createTitle(title));
		return sect1;
	}

	public Sect2 createSect2() {

		Sect2 sect2 = new Sect2();
		initialize(sect2);
		return sect2;
	}

	public Sect2 createSect2(String str) {

		Sect2 sect2 = createSect2();
		sect2.appendChild(createTitle(str));
		return sect2;
	}

	public Sect3 createSect3() {

		Sect3 sect3 = new Sect3();
		initialize(sect3);
		return sect3;
	}

	public Sect3 createSect3(String str) {

		Sect3 sect3 = createSect3();
		sect3.appendChild(createTitle(str));
		return sect3;
	}

	public Sect4 createSect4() {

		Sect4 sect4 = new Sect4();
		initialize(sect4);
		return sect4;
	}

	public Sect5 createSect5() {
		Sect5 sect5 = new Sect5();
		initialize(sect5);
		return sect5;
	}

	public Section createSection() {

		Section section = new Section();
		initialize(section);
		return section;
	}

	public Section createSection(String title) {

		Section section = createSection();
		section.appendChild(createTitle(title));
		return section;
	}

	public SimPara createSimPara() {

		SimPara simPara = new SimPara();
		initialize(simPara);
		return simPara;
	}

	public SimPara createSimPara(String text) {

		SimPara simPara = new SimPara();
		simPara.appendChild(text);
		initialize(simPara);
		return simPara;
	}

	public SimpleList createSimpleList() {

		SimpleList simpleList = new SimpleList();
		initialize(simpleList);
		return simpleList;
	}

	public SimpleList createSimpleList(int type) {

		SimpleList simpleList = createSimpleList();
		simpleList.setType(type);
		return simpleList;
	}

	public SimpleSect createSimpleSect() {

		SimpleSect simpleSect = new SimpleSect();
		initialize(simpleSect);
		return simpleSect;
	}

	public Spanspec createSpanspec() {

		Spanspec spanspec = new Spanspec();
		initialize(spanspec);
		return spanspec;
	}

	public Subject createSubject() {
		Subject subject = new Subject();
		initialize(subject);
		return subject;
	}

	public Subjectset createSubjectset() {
		Subjectset subjectset = new Subjectset();
		initialize(subjectset);
		return subjectset;
	}

	public Subjectterm createSubjectterm() {
		Subjectterm subjectterm = new Subjectterm();
		initialize(subjectterm);
		return subjectterm;
	}

	public Subscript createSubscript() {
		Subscript subscript = new Subscript();
		initialize(subscript);
		return subscript;
	}

	public Superscript createSuperscript() {

		Superscript superscript = new Superscript();
		initialize(superscript);
		return superscript;
	}

	public Surname createSurname() {

		Surname surname = new Surname();
		initialize(surname);
		return surname;
	}

	public Surname createSurname(String name) {

		Surname surname = new Surname();
		surname.appendChild(name);
		initialize(surname);
		return surname;
	}

	public Synopsis createSynopsis() {

		Synopsis synopsis = new Synopsis();
		initialize(synopsis);
		return synopsis;
	}

	public Table createTable() {

		Table table = new Table();
		initialize(table);
		return table;
	}

	public DocBookElement createTag(String name)
			throws DocBookTagFactoryException {

		DocBookElement docBookElement = new DocBookElement(name);
		initialize(docBookElement);
		return docBookElement;
	}

	public Tbody createTbody() {

		Tbody tbody = new Tbody();
		initialize(tbody);
		return tbody;
	}

	public Term createTerm() {

		Term term = new Term();
		initialize(term);
		return term;
	}

	public TextObject createTextObject() {

		TextObject textObject = new TextObject();
		initialize(textObject);
		return textObject;
	}

	public Tfoot createTfoot() {

		Tfoot tfoot = new Tfoot();
		initialize(tfoot);
		return tfoot;
	}

	public Tgroup createTgroup() {

		Tgroup tgroup = new Tgroup();
		initialize(tgroup);
		return tgroup;
	}

	public Tgroup createTgroup(int cols) {

		Tgroup tgroup = new Tgroup();
		initialize(tgroup);
		tgroup.setCols(2);
		tgroup.appendChild(createColspec("c1", "1*"));
		tgroup.appendChild(createColspec("c2", "1*"));

		return tgroup;
	}

	public Thead createThead() {

		Thead thead = new Thead();
		initialize(thead);
		return thead;
	}

	public Tip createTip() {

		Tip tip = new Tip();
		initialize(tip);
		return tip;
	}

	public Title createTitle() {

		Title title = new Title();
		initialize(title);
		return title;
	}

	public Title createTitle(String str) {

		Title title = new Title(str);
		initialize(title);
		return title;
	}

	public Type createType() {

		Type type = new Type();
		initialize(type);
		return type;
	}

	public ULink createULink() {

		ULink uLink = new ULink();
		initialize(uLink);
		return uLink;
	}

	public VariableList createVariableList() {

		VariableList variableList = new VariableList();
		initialize(variableList);
		return variableList;
	}

	public VarListEntry createVarListEntry() {

		VarListEntry varListEntry = new VarListEntry();
		initialize(varListEntry);
		return varListEntry;
	}

	public VarName createVarName() {

		VarName varName = new VarName();
		initialize(varName);
		return varName;
	}

	public VarName createVarName(String text) {

		VarName varName = new VarName(text);
		initialize(varName);
		return varName;
	}

	public Void createVoid() {

		Void _void = new Void();
		initialize(_void);
		return _void;
	}

	public Warning createWarning() {

		Warning warning = new Warning();
		initialize(warning);
		return warning;
	}

	public Warning createWarning(String text) {

		Warning warning = new Warning(text);
		initialize(warning);
		return warning;
	}

	public XRef createXRef(String linkend) {

		XRef xref = new XRef(linkend);
		initialize(xref);
		return xref;
	}

	public Year createYear() {

		Year year = new Year();
		initialize(year);
		return year;
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

	public boolean isDocBook5() {

		if (docBookVersion != null && docBookVersion == DocBookVersion.V5_0) {
			return true;
		}

		return false;
	}

	public String getImageDataFormat(String src) {

		if (src != null) {

			String value = FileServices.getExtension(src);

			if (value != null && value.trim().length() > 0) {
				return value.toUpperCase();
			}
		}

		return null;
	}

	public void createFoImageData(DocBookElement parent,
			DocBookTagFactory dbfactory, Img img, File file, List<String> additionalFormats) throws IOException {

		String fileRef = FileServices.normalizePath(file.getPath());
		String imgFormat = getImageDataFormat(fileRef);
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

			ImageObject image = dbfactory.createImageObject();
		
			if (format.equals(imgFormat)) {
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
		}
	}

	public void createHtmlImageData(DocBookElement parent,
			DocBookTagFactory dbfactory, Img img, File file,
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

		String imgFormat = getImageDataFormat(fileRef);
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

			ImageObject image = dbfactory.createImageObject();

			if (format.equals(imgFormat)) {
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

	private String upcase(String lowerCase, int... indices) {

		char[] chars = lowerCase.toCharArray();

		for (int index : indices) {
			chars[index] = Character.toUpperCase(chars[index]);
		}

		return new String(chars);
	}

}