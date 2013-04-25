/*
 * ### Copyright (C) 2008 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@dbdoclet.org
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.tag.docbook;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.dbdoclet.xiphias.NodeSerializer;

public class TagFactory {

    private DocBookVersion docBookVersion = DocBookVersion.V5_0;

    public TagFactory() {
        this(DocBookVersion.V5_0);
    }

    public TagFactory(DocBookVersion docBookVersion) {

        this.docBookVersion = docBookVersion;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAbbrev()
	 */
    public Abbrev createAbbrev() {

        Abbrev abbrev = new Abbrev();
        abbrev.setDocBookVersion(docBookVersion);
        return abbrev;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAbstract()
	 */
    public Abstract createAbstract() {

        Abstract _abstract = new Abstract();
        _abstract.setDocBookVersion(docBookVersion);
        return _abstract;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAcronym()
	 */
    public Acronym createAcronym() {

        Acronym acronym = new Acronym();
        acronym.setDocBookVersion(docBookVersion);
        return acronym;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAddress()
	 */
    public Address createAddress() {

        Address address = new Address();
        address.setDocBookVersion(docBookVersion);
        return address;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAffiliation()
	 */
    public Affiliation createAffiliation() {

        Affiliation affiliation = new Affiliation();
        affiliation.setDocBookVersion(docBookVersion);
        return affiliation;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAnchor()
	 */
    public Anchor createAnchor() {

        Anchor anchor = new Anchor();
        anchor.setDocBookVersion(docBookVersion);
        return anchor;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAppendix()
	 */
    public Appendix createAppendix() {

        Appendix appendix = new Appendix();
        appendix.setDocBookVersion(docBookVersion);
        return appendix;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createArticle()
	 */
    public Article createArticle() {

        Article article = new Article();
        article.setDocBookVersion(docBookVersion);
        return article;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createArticleInfo()
	 */
    public ArticleInfo createArticleInfo() {

        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setDocBookVersion(docBookVersion);
        return articleInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createAuthor()
	 */
    public Author createAuthor() {

        Author author = new Author();
        author.setDocBookVersion(docBookVersion);
        return author;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createBlockQuote()
	 */
    public BlockQuote createBlockQuote() {

        BlockQuote blockQuote = new BlockQuote();
        blockQuote.setDocBookVersion(docBookVersion);
        return blockQuote;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createBook()
	 */
    public Book createBook() {

        Book book = new Book();
        book.setDocBookVersion(docBookVersion);
        return book;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createBookInfo()
	 */
    public BookInfo createBookInfo() {

        BookInfo bookInfo = new BookInfo();
        bookInfo.setDocBookVersion(docBookVersion);
        return bookInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createBridgeHead()
	 */
    public BridgeHead createBridgeHead() {

        BridgeHead bridgeHead = new BridgeHead();
        bridgeHead.setDocBookVersion(docBookVersion);
        return bridgeHead;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createCaption()
	 */
    public Caption createCaption() {

        Caption caption = new Caption();
        caption.setDocBookVersion(docBookVersion);
        return caption;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createCaution()
	 */
    public Caution createCaution() {

        Caution caution = new Caution();
        caution.setDocBookVersion(docBookVersion);
        return caution;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createChapter()
	 */
    public Chapter createChapter() {

        Chapter chapter = new Chapter();
        chapter.setDocBookVersion(docBookVersion);
        return chapter;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createClassName()
	 */
    public ClassName createClassName() {

        ClassName className = new ClassName();
        className.setDocBookVersion(docBookVersion);
        return className;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createClassName(java.lang.String)
	 */
    public ClassName createClassName(String name) {

        ClassName className = new ClassName(name);
        className.setDocBookVersion(docBookVersion);
        return className;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createClassSynopsis()
	 */
    public ClassSynopsis createClassSynopsis() {

        ClassSynopsis classSynopsis = new ClassSynopsis();
        classSynopsis.setDocBookVersion(docBookVersion);
        return classSynopsis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createClassSynopsisInfo()
	 */
    public ClassSynopsisInfo createClassSynopsisInfo() {

        ClassSynopsisInfo classSynopsisInfo = new ClassSynopsisInfo();
        classSynopsisInfo.setDocBookVersion(docBookVersion);
        return classSynopsisInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createClassSynopsisInfo(java.lang.String)
	 */
    public ClassSynopsisInfo createClassSynopsisInfo(String text) {

        ClassSynopsisInfo classSynopsisInfo = new ClassSynopsisInfo(text);
        classSynopsisInfo.setDocBookVersion(docBookVersion);
        return classSynopsisInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createCode()
	 */
    public Code createCode() {

        Code code = new Code();
        code.setDocBookVersion(docBookVersion);
        return code;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createColspec()
	 */
    public Colspec createColspec() {

        Colspec colspec = new Colspec();
        colspec.setDocBookVersion(docBookVersion);
        return colspec;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createColspec(java.lang.String, java.lang.String)
	 */
    public Colspec createColspec(String string, String width) {

        Colspec colspec = new Colspec(string, width);
        colspec.setDocBookVersion(docBookVersion);
        return colspec;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createComputerOutput()
	 */
    public ComputerOutput createComputerOutput() {

        ComputerOutput computerOutput = new ComputerOutput();
        computerOutput.setDocBookVersion(docBookVersion);
        return computerOutput;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createComputerOutput(java.lang.String)
	 */
    public ComputerOutput createComputerOutput(String text) {

        ComputerOutput computerOutput = new ComputerOutput(text);
        computerOutput.setDocBookVersion(docBookVersion);
        return computerOutput;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createConstructorSynopsis()
	 */
    public ConstructorSynopsis createConstructorSynopsis() {

        ConstructorSynopsis constructorSynopsis = new ConstructorSynopsis();
        constructorSynopsis.setDocBookVersion(docBookVersion);
        return constructorSynopsis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createCopyright()
	 */
    public Copyright createCopyright() {

        Copyright copyright = new Copyright();
        copyright.setDocBookVersion(docBookVersion);
        return copyright;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createDate()
	 */
    public Date createDate() {

        java.util.Date today = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date(sdf.format(today));
        date.setDocBookVersion(docBookVersion);
        return date;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createDate(java.lang.String)
	 */
    public Date createDate(String text) {

        Date date = new Date(text);
        date.setDocBookVersion(docBookVersion);
        return date;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEmail()
	 */
    public Email createEmail() {

        Email email = new Email();
        email.setDocBookVersion(docBookVersion);
        return email;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEmail(java.lang.String)
	 */
    public Email createEmail(String address) {

        Email email = new Email();
        email.appendChild(address);
        email.setDocBookVersion(docBookVersion);
        return email;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEmphasis()
	 */
    public Emphasis createEmphasis() {

        Emphasis emphasis = new Emphasis();
        emphasis.setDocBookVersion(docBookVersion);
        return emphasis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEmphasis(java.lang.String)
	 */
    public Emphasis createEmphasis(String str) {

        Emphasis emphasis = new Emphasis(str);
        emphasis.setDocBookVersion(docBookVersion);
        return emphasis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEmphasis(java.lang.String, java.lang.String)
	 */
    public Emphasis createEmphasis(String str, String role) {

        Emphasis emphasis = createEmphasis(str);
        emphasis.setRole(role);
        return emphasis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEntry()
	 */
    public Entry createEntry() {

        Entry entry = new Entry();
        entry.setDocBookVersion(docBookVersion);
        return entry;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEntry(java.lang.String)
	 */
    public Entry createEntry(String text) {

        Entry entry = new Entry(text);
        entry.setDocBookVersion(docBookVersion);
        return entry;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createEntryTbl()
	 */
    public EntryTbl createEntryTbl() {

        EntryTbl entryTbl = new EntryTbl();
        entryTbl.setDocBookVersion(docBookVersion);
        return entryTbl;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createExample(java.lang.String)
	 */
    public Example createExample(String title) {

        Example example = new Example(title);
        example.setDocBookVersion(docBookVersion);
        return example;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createExceptionName()
	 */
    public ExceptionName createExceptionName() {

        ExceptionName exceptionName = new ExceptionName();
        exceptionName.setDocBookVersion(docBookVersion);
        return exceptionName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createExceptionName(java.lang.String)
	 */
    public ExceptionName createExceptionName(String text) {

        ExceptionName exceptionName = new ExceptionName(text);
        exceptionName.setDocBookVersion(docBookVersion);
        return exceptionName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFieldSynopsis()
	 */
    public FieldSynopsis createFieldSynopsis() {

        FieldSynopsis fieldSynopsis = new FieldSynopsis();
        fieldSynopsis.setDocBookVersion(docBookVersion);
        return fieldSynopsis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFigure(java.lang.String)
	 */
    public Figure createFigure(String title) {

        Figure figure = new Figure(title);
        figure.setDocBookVersion(docBookVersion);
        return figure;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFirstName()
	 */
    public FirstName createFirstName() {

        FirstName firstName = new FirstName();
        firstName.setDocBookVersion(docBookVersion);
        return firstName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFirstName(java.lang.String)
	 */
    public FirstName createFirstName(String name) {

        FirstName firstName = new FirstName();
        firstName.appendChild(name);
        firstName.setDocBookVersion(docBookVersion);
        return firstName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFormalPara()
	 */
    public FormalPara createFormalPara() {

        FormalPara formalPara = new FormalPara();
        formalPara.setDocBookVersion(docBookVersion);
        return formalPara;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFormalPara(java.lang.String)
	 */
    public DocBookElement createFormalPara(String title) {

        FormalPara formalPara = new FormalPara(title);
        formalPara.setDocBookVersion(docBookVersion);
        return formalPara;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFuncDef()
	 */
    public FuncDef createFuncDef() {

        FuncDef funcDef = new FuncDef();
        funcDef.setDocBookVersion(docBookVersion);
        return funcDef;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFuncPrototype()
	 */
    public FuncPrototype createFuncPrototype() {

        FuncPrototype funcPrototype = new FuncPrototype();
        funcPrototype.setDocBookVersion(docBookVersion);
        return funcPrototype;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFuncSynopsis()
	 */
    public FuncSynopsis createFuncSynopsis() {

        FuncSynopsis funcSynopsis = new FuncSynopsis();
        funcSynopsis.setDocBookVersion(docBookVersion);
        return funcSynopsis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createFunction(java.lang.String)
	 */
    public Function createFunction(String func) {

        Function function = new Function(func);
        function.setDocBookVersion(docBookVersion);
        return function;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createHolder()
	 */
    public Holder createHolder() {

        Holder holder = new Holder();
        holder.setDocBookVersion(docBookVersion);
        return holder;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createHolder(java.lang.String)
	 */
    public Holder createHolder(String text) {

        Holder holder = new Holder();
        holder.appendChild(text);
        holder.setDocBookVersion(docBookVersion);
        return holder;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createImage(java.lang.String, java.lang.String, java.lang.String)
	 */
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

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createImage(java.lang.String)
	 */
    public MediaObject createImage(String image) {
        return createImage(image, null, null);
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createImageData()
	 */
    public ImageData createImageData() {

        ImageData imageData = new ImageData();
        imageData.setDocBookVersion(docBookVersion);
        return imageData;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createImageObject()
	 */
    public ImageObject createImageObject() {

        ImageObject imageObject = new ImageObject();
        imageObject.setDocBookVersion(docBookVersion);
        return imageObject;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createImportant()
	 */
    public Important createImportant() {

        Important important = new Important();
        important.setDocBookVersion(docBookVersion);
        return important;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createIndex()
	 */
    public Index createIndex() {

        Index index = new Index();
        index.setDocBookVersion(docBookVersion);
        return index;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createIndexTerm()
	 */
    public IndexTerm createIndexTerm() {

        IndexTerm indexTerm = new IndexTerm();
        indexTerm.setDocBookVersion(docBookVersion);
        return indexTerm;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInfo()
	 */
    public Info createInfo() {

        Info info = new Info();
        info.setDocBookVersion(docBookVersion);
        return info;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPersonname()
	 */
    public Personname createPersonname() {

        Personname personname = new Personname();
        personname.setDocBookVersion(docBookVersion);
        return personname;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInformalExample()
	 */
    public InformalExample createInformalExample() {

        InformalExample informalExample = new InformalExample();
        informalExample.setDocBookVersion(docBookVersion);
        return informalExample;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInformalFigure()
	 */
    public InformalFigure createInformalFigure() {

        InformalFigure informalFigure = new InformalFigure();
        informalFigure.setDocBookVersion(docBookVersion);
        return informalFigure;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInformalTable()
	 */
    public InformalTable createInformalTable() {

        InformalTable informalTable = new InformalTable();
        informalTable.setDocBookVersion(docBookVersion);
        return informalTable;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInitializer()
	 */
    public Initializer createInitializer() {

        Initializer initializer = new Initializer();
        initializer.setDocBookVersion(docBookVersion);
        return initializer;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInitializer(java.lang.String)
	 */
    public Initializer createInitializer(String text) {

        Initializer initializer = new Initializer(text);
        initializer.setDocBookVersion(docBookVersion);
        return initializer;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInlineMediaObject()
	 */
    public InlineMediaObject createInlineMediaObject() {
        InlineMediaObject inlineMediaObject = new InlineMediaObject();
        inlineMediaObject.setDocBookVersion(docBookVersion);
        return inlineMediaObject;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInterfaceName()
	 */
    public InterfaceName createInterfaceName() {

        InterfaceName interfaceName = new InterfaceName();
        interfaceName.setDocBookVersion(docBookVersion);
        return interfaceName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createInterfaceName(java.lang.String)
	 */
    public InterfaceName createInterfaceName(String name) {

        InterfaceName interfaceName = new InterfaceName(name);
        interfaceName.setDocBookVersion(docBookVersion);
        return interfaceName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createItemizedList()
	 */
    public ItemizedList createItemizedList() {

        ItemizedList itemizedList = new ItemizedList();
        itemizedList.setDocBookVersion(docBookVersion);
        return itemizedList;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLegalNotice()
	 */
    public LegalNotice createLegalNotice() {

        LegalNotice legalNotice = new LegalNotice();
        legalNotice.setDocBookVersion(docBookVersion);
        return legalNotice;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLink()
	 */
    public Link createLink() {

        Link link = new Link();
        link.setDocBookVersion(docBookVersion);
        return link;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLink(org.dbdoclet.trafo.tag.docbook.Literal, java.lang.String)
	 */
    public Link createLink(Literal literal, String ref) {

        Link link = new Link(literal, ref);
        link.setDocBookVersion(docBookVersion);
        return link;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLink(org.dbdoclet.trafo.tag.docbook.VarName, java.lang.String)
	 */
    public Link createLink(VarName varName, String ref) {

        Link link = new Link(varName, ref);
        link.setDocBookVersion(docBookVersion);
        return link;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLink(java.lang.String)
	 */
    public Link createLink(String href) {

        Link link = new Link(href);
        link.setDocBookVersion(docBookVersion);
        return link;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLink(java.lang.String, java.lang.String)
	 */
    public Link createLink(String label, String ref) {

        Link link = new Link(label, ref);
        link.setDocBookVersion(docBookVersion);
        return link;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLinkAsString(java.lang.String, java.lang.String)
	 */
    public String createLinkAsString(String label, String ref) throws IOException {

        Link link = new Link(label, ref);
        link.setDocBookVersion(docBookVersion);
        return NodeSerializer.toXML(link);
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createListItem()
	 */
    public ListItem createListItem() {

        ListItem listItem = new ListItem();
        listItem.setDocBookVersion(docBookVersion);
        return listItem;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLiteral()
	 */
    public Literal createLiteral() {

        Literal literal = new Literal();
        literal.setDocBookVersion(docBookVersion);
        return literal;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createLiteral(java.lang.String)
	 */
    public Literal createLiteral(String text) {

        Literal literal = new Literal(text);
        literal.setDocBookVersion(docBookVersion);
        return literal;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createManVolNum(java.lang.String)
	 */
    public ManVolNum createManVolNum(String num) {

        ManVolNum manVolNum = new ManVolNum(num);
        manVolNum.setDocBookVersion(docBookVersion);
        return manVolNum;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createMediaObject()
	 */
    public MediaObject createMediaObject() {

        MediaObject mediaObject = new MediaObject();
        mediaObject.setDocBookVersion(docBookVersion);
        return mediaObject;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createMember()
	 */
    public Member createMember() {

        Member member = new Member();
        member.setDocBookVersion(docBookVersion);
        return member;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createMethodName()
	 */
    public MethodName createMethodName() {

        MethodName methodName = new MethodName();
        methodName.setDocBookVersion(docBookVersion);
        return methodName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createMethodName(java.lang.String)
	 */
    public MethodName createMethodName(String text) {

        MethodName methodName = new MethodName(text);
        methodName.setDocBookVersion(docBookVersion);
        return methodName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createMethodParam()
	 */
    public MethodParam createMethodParam() {

        MethodParam methodParam = new MethodParam();
        methodParam.setDocBookVersion(docBookVersion);
        return methodParam;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createMethodSynopsis()
	 */
    public MethodSynopsis createMethodSynopsis() {

        MethodSynopsis methodSynopsis = new MethodSynopsis();
        methodSynopsis.setDocBookVersion(docBookVersion);
        return methodSynopsis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createModifier()
	 */
    public Modifier createModifier() {

        Modifier modifier = new Modifier();
        modifier.setDocBookVersion(docBookVersion);
        return modifier;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createModifier(java.lang.String)
	 */
    public Modifier createModifier(String text) {

        Modifier modifier = new Modifier();
        modifier.appendChild(text);
        modifier.setDocBookVersion(docBookVersion);
        return modifier;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createNote()
	 */
    public Note createNote() {

        Note note = new Note();
        note.setDocBookVersion(docBookVersion);
        return note;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createOoClass()
	 */
    public OoClass createOoClass() {

        OoClass ooClass = new OoClass();
        ooClass.setDocBookVersion(docBookVersion);
        return ooClass;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createOoException()
	 */
    public OoException createOoException() {

        OoException ooException = new OoException();
        ooException.setDocBookVersion(docBookVersion);
        return ooException;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createOoInterface()
	 */
    public OoInterface createOoInterface() {

        OoInterface ooInterface = new OoInterface();
        ooInterface.setDocBookVersion(docBookVersion);
        return ooInterface;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createOrderedList()
	 */
    public OrderedList createOrderedList() {

        OrderedList orderedList = new OrderedList();
        orderedList.setDocBookVersion(docBookVersion);
        return orderedList;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createOlink(java.lang.String, java.lang.String, java.lang.String)
	 */
    public Olink createOlink(String label, String targetdoc, String targetptr) {

        Olink olink = new Olink(label, targetdoc, targetptr);
        olink.setDocBookVersion(docBookVersion);
        return olink;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPara()
	 */
    public Para createPara() {

        Para para = new Para();
        para.setDocBookVersion(docBookVersion);
        return para;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPara(java.lang.String)
	 */
    public Para createPara(String text) {

        Para para = new Para(text);
        para.setDocBookVersion(docBookVersion);
        return para;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createParamDef()
	 */
    public ParamDef createParamDef() {

        ParamDef paramDef = new ParamDef();
        paramDef.setDocBookVersion(docBookVersion);
        return paramDef;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createParameter(java.lang.String)
	 */
    public Parameter createParameter(String name) {

        Parameter parameter = new Parameter(name);
        parameter.setDocBookVersion(docBookVersion);
        return parameter;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPart()
	 */
    public Part createPart() {

        Part part = new Part();
        part.setDocBookVersion(docBookVersion);
        return part;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPartInfo()
	 */
    public PartInfo createPartInfo() {

        PartInfo partInfo = new PartInfo();
        partInfo.setDocBookVersion(docBookVersion);
        return partInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPartIntro()
	 */
    public PartIntro createPartIntro() {

        PartIntro partIntro = new PartIntro();
        partIntro.setDocBookVersion(docBookVersion);
        return partIntro;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPhrase()
	 */
    public Phrase createPhrase() {

        Phrase phrase = new Phrase();
        phrase.setDocBookVersion(docBookVersion);
        return phrase;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createPrimary(java.lang.String)
	 */
    public Primary createPrimary(String key) {

        Primary primary = new Primary(key);
        primary.setDocBookVersion(docBookVersion);
        return primary;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createProgramListing()
	 */
    public ProgramListing createProgramListing() {

        ProgramListing programListing = new ProgramListing();
        programListing.setDocBookVersion(docBookVersion);
        return programListing;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createProgramListing(java.lang.String)
	 */
    public ProgramListing createProgramListing(String str) {

        ProgramListing programListing = new ProgramListing(str);
        programListing.setDocBookVersion(docBookVersion);
        return programListing;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createQuote()
	 */
    public Quote createQuote() {

        Quote quote = new Quote();
        quote.setDocBookVersion(docBookVersion);
        return quote;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefEntry()
	 */
    public RefEntry createRefEntry() {

        RefEntry refEntry = new RefEntry();
        refEntry.setDocBookVersion(docBookVersion);
        return refEntry;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefEntryInfo()
	 */
    public RefEntryInfo createRefEntryInfo() {

        RefEntryInfo refEntryInfo = new RefEntryInfo();
        refEntryInfo.setDocBookVersion(docBookVersion);
        return refEntryInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createReference()
	 */
    public Reference createReference() {

        Reference reference = new Reference();
        reference.setDocBookVersion(docBookVersion);
        return reference;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefMeta()
	 */
    public RefMeta createRefMeta() {

        RefMeta refMeta = new RefMeta();
        refMeta.setDocBookVersion(docBookVersion);
        return refMeta;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefMiscInfo(java.lang.String, java.lang.String)
	 */
    public RefMiscInfo createRefMiscInfo(String clazz, String info) {

        RefMiscInfo refMiscInfo = new RefMiscInfo(clazz, info);
        refMiscInfo.setDocBookVersion(docBookVersion);
        return refMiscInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefName(java.lang.String)
	 */
    public RefName createRefName(String name) {

        RefName refName = new RefName(name);
        refName.setDocBookVersion(docBookVersion);
        return refName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefNameDiv()
	 */
    public RefNameDiv createRefNameDiv() {

        RefNameDiv refNameDiv = new RefNameDiv();
        refNameDiv.setDocBookVersion(docBookVersion);
        return refNameDiv;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefPurpose()
	 */
    public RefPurpose createRefPurpose() {

        RefPurpose refPurpose = new RefPurpose();
        refPurpose.setDocBookVersion(docBookVersion);
        return refPurpose;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect1()
	 */
    public RefSect1 createRefSect1() {

        RefSect1 refSect1 = new RefSect1();
        refSect1.setDocBookVersion(docBookVersion);
        return refSect1;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect1(java.lang.String)
	 */
    public RefSect1 createRefSect1(String title) {

        RefSect1 refSect1 = new RefSect1(title);
        refSect1.setDocBookVersion(docBookVersion);
        return refSect1;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect2()
	 */
    public RefSect2 createRefSect2() {

        RefSect2 refSect2 = new RefSect2();
        refSect2.setDocBookVersion(docBookVersion);
        return refSect2;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect2(java.lang.String)
	 */
    public RefSect2 createRefSect2(String title) {

        RefSect2 refSect2 = new RefSect2(title);
        refSect2.setDocBookVersion(docBookVersion);
        return refSect2;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect3()
	 */
    public RefSect3 createRefSect3() {

        RefSect3 refSect3 = new RefSect3();
        refSect3.setDocBookVersion(docBookVersion);
        return refSect3;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect4()
	 */
    public RefSect4 createRefSect4() {

        RefSect4 refSect4 = new RefSect4();
        refSect4.setDocBookVersion(docBookVersion);
        return refSect4;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSect5()
	 */
    public RefSect5 createRefSect5() {

        RefSect5 refSect5 = new RefSect5();
        refSect5.setDocBookVersion(docBookVersion);
        return refSect5;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRefSynopsisDiv()
	 */
    public RefSynopsisDiv createRefSynopsisDiv() {

        RefSynopsisDiv refSynopsisDiv = new RefSynopsisDiv();
        refSynopsisDiv.setDocBookVersion(docBookVersion);
        return refSynopsisDiv;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createReleaseInfo()
	 */
    public ReleaseInfo createReleaseInfo() {

        ReleaseInfo releaseInfo = new ReleaseInfo();
        releaseInfo.setDocBookVersion(docBookVersion);
        return releaseInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createReleaseInfo(java.lang.String)
	 */
    public ReleaseInfo createReleaseInfo(String text) {

        ReleaseInfo releaseInfo = new ReleaseInfo();
        releaseInfo.appendChild(text);
        releaseInfo.setDocBookVersion(docBookVersion);
        return releaseInfo;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createRow()
	 */
    public Row createRow() {

        Row row = new Row();
        row.setDocBookVersion(docBookVersion);
        return row;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createScreen()
	 */
    public Screen createScreen() {

        Screen screen = new Screen();
        screen.setDocBookVersion(docBookVersion);
        return screen;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSecondary(java.lang.String)
	 */
    public Secondary createSecondary(String key) {

        Secondary secondary = new Secondary(key);
        secondary.setDocBookVersion(docBookVersion);
        return secondary;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect1()
	 */
    public Sect1 createSect1() {

        Sect1 sect1 = new Sect1();
        sect1.setDocBookVersion(docBookVersion);
        return sect1;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect1(java.lang.String)
	 */
    public Sect1 createSect1(String title) {

        Sect1 sect1 = new Sect1(title);
        sect1.setDocBookVersion(docBookVersion);
        return sect1;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect2()
	 */
    public Sect2 createSect2() {

        Sect2 sect2 = new Sect2();
        sect2.setDocBookVersion(docBookVersion);
        return sect2;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect2(java.lang.String)
	 */
    public Sect2 createSect2(String str) {

        Sect2 sect2 = new Sect2(str);
        sect2.setDocBookVersion(docBookVersion);
        return sect2;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect3()
	 */
    public Sect3 createSect3() {

        Sect3 sect3 = new Sect3();
        sect3.setDocBookVersion(docBookVersion);
        return sect3;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect3(java.lang.String)
	 */
    public Sect3 createSect3(String str) {

        Sect3 sect3 = new Sect3(str);
        sect3.setDocBookVersion(docBookVersion);
        return sect3;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect4()
	 */
    public Sect4 createSect4() {

        Sect4 sect4 = new Sect4();
        sect4.setDocBookVersion(docBookVersion);
        return sect4;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSect5()
	 */
    public Sect5 createSect5() {
        Sect5 sect5 = new Sect5();

        sect5.setDocBookVersion(docBookVersion);
        return sect5;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSection()
	 */
    public Section createSection() {

        Section section = new Section();
        section.setDocBookVersion(docBookVersion);
        return section;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSection(java.lang.String)
	 */
    public Section createSection(String title) {

        Section section = new Section(title);
        section.setDocBookVersion(docBookVersion);
        return section;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSimPara()
	 */
    public SimPara createSimPara() {

        SimPara simPara = new SimPara();
        simPara.setDocBookVersion(docBookVersion);
        return simPara;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSimPara(java.lang.String)
	 */
    public SimPara createSimPara(String text) {

        SimPara simPara = new SimPara();
        simPara.appendChild(text);
        simPara.setDocBookVersion(docBookVersion);
        return simPara;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSimpleList()
	 */
    public SimpleList createSimpleList() {

        SimpleList simpleList = new SimpleList();
        simpleList.setDocBookVersion(docBookVersion);
        return simpleList;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSimpleList(int)
	 */
    public SimpleList createSimpleList(int type) {

        SimpleList simpleList = createSimpleList();
        simpleList.setType(type);
        return simpleList;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSimpleSect()
	 */
    public SimpleSect createSimpleSect() {

        SimpleSect simpleSect = new SimpleSect();
        simpleSect.setDocBookVersion(docBookVersion);
        return simpleSect;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSpanspec()
	 */
    public Spanspec createSpanspec() {

        Spanspec spanspec = new Spanspec();
        spanspec.setDocBookVersion(docBookVersion);
        return spanspec;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSubscript()
	 */
    public Subscript createSubscript() {

        Subscript subscript = new Subscript();
        subscript.setDocBookVersion(docBookVersion);
        return subscript;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSuperscript()
	 */
    public Superscript createSuperscript() {

        Superscript superscript = new Superscript();
        superscript.setDocBookVersion(docBookVersion);
        return superscript;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSurname()
	 */
    public Surname createSurname() {

        Surname surname = new Surname();
        surname.setDocBookVersion(docBookVersion);
        return surname;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSurname(java.lang.String)
	 */
    public Surname createSurname(String name) {

        Surname surname = new Surname();
        surname.appendChild(name);
        surname.setDocBookVersion(docBookVersion);
        return surname;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createSynopsis()
	 */
    public Synopsis createSynopsis() {

        Synopsis synopsis = new Synopsis();
        synopsis.setDocBookVersion(docBookVersion);
        return synopsis;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTable()
	 */
    public Table createTable() {

        Table table = new Table();
        table.setDocBookVersion(docBookVersion);
        return table;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTag(java.lang.String)
	 */
    public DocBookElement createTag(String name) throws DocBookTagFactoryException {

        DocBookElement docBookElement = new DocBookElement(name);
        docBookElement.setDocBookVersion(docBookVersion);
        return docBookElement;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTbody()
	 */
    public Tbody createTbody() {

        Tbody tbody = new Tbody();
        tbody.setDocBookVersion(docBookVersion);
        return tbody;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTerm()
	 */
    public Term createTerm() {

        Term term = new Term();
        term.setDocBookVersion(docBookVersion);
        return term;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTextObject()
	 */
    public TextObject createTextObject() {

        TextObject textObject = new TextObject();
        textObject.setDocBookVersion(docBookVersion);
        return textObject;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTfoot()
	 */
    public Tfoot createTfoot() {

        Tfoot tfoot = new Tfoot();
        tfoot.setDocBookVersion(docBookVersion);
        return tfoot;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTgroup()
	 */
    public Tgroup createTgroup() {

        Tgroup tgroup = new Tgroup();
        tgroup.setDocBookVersion(docBookVersion);
        return tgroup;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTgroup(int)
	 */
    public Tgroup createTgroup(int cols) {

        Tgroup tgroup = new Tgroup();
        tgroup.setDocBookVersion(docBookVersion);
        tgroup.setCols(2);
        tgroup.appendChild(new Colspec("c1", "1*"));
        tgroup.appendChild(new Colspec("c2", "1*"));

        return tgroup;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createThead()
	 */
    public Thead createThead() {

        Thead thead = new Thead();
        thead.setDocBookVersion(docBookVersion);
        return thead;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTip()
	 */
    public Tip createTip() {

        Tip tip = new Tip();
        tip.setDocBookVersion(docBookVersion);
        return tip;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTitle()
	 */
    public Title createTitle() {

        Title title = new Title();
        title.setDocBookVersion(docBookVersion);
        return title;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createTitle(java.lang.String)
	 */
    public Title createTitle(String str) {

        Title title = new Title(str);
        title.setDocBookVersion(docBookVersion);
        return title;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createType()
	 */
    public Type createType() {

        Type type = new Type();
        type.setDocBookVersion(docBookVersion);
        return type;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createULink()
	 */
    public ULink createULink() {

        ULink uLink = new ULink();
        uLink.setDocBookVersion(docBookVersion);
        return uLink;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createVariableList()
	 */
    public VariableList createVariableList() {

        VariableList variableList = new VariableList();
        variableList.setDocBookVersion(docBookVersion);
        return variableList;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createVarListEntry()
	 */
    public VarListEntry createVarListEntry() {

        VarListEntry varListEntry = new VarListEntry();
        varListEntry.setDocBookVersion(docBookVersion);
        return varListEntry;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createVarName()
	 */
    public VarName createVarName() {

        VarName varName = new VarName();
        varName.setDocBookVersion(docBookVersion);
        return varName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createVarName(java.lang.String)
	 */
    public VarName createVarName(String text) {

        VarName varName = new VarName(text);
        varName.setDocBookVersion(docBookVersion);
        return varName;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createVoid()
	 */
    public Void createVoid() {

        Void _void = new Void();
        _void.setDocBookVersion(docBookVersion);
        return _void;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createWarning()
	 */
    public Warning createWarning() {

        Warning warning = new Warning();
        warning.setDocBookVersion(docBookVersion);
        return warning;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createWarning(java.lang.String)
	 */
    public Warning createWarning(String text) {

        Warning warning = new Warning(text);
        warning.setDocBookVersion(docBookVersion);
        return warning;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createXRef(java.lang.String)
	 */
    public XRef createXRef(String linkend) {

        XRef xref = new XRef(linkend);
        xref.setDocBookVersion(docBookVersion);
        return xref;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createYear()
	 */
    public Year createYear() {

        Year year = new Year();
        year.setDocBookVersion(docBookVersion);
        return year;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#createYear(java.lang.String)
	 */
    public Year createYear(String text) {

        Year year = new Year();
        year.appendChild(text);
        year.setDocBookVersion(docBookVersion);
        return year;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#getDocBookVersion()
	 */
    public DocBookVersion getDocBookVersion() {
        return docBookVersion;
    }

    /* (non-Javadoc)
	 * @see org.dbdoclet.trafo.tag.docbook.TagFactory#isDocBook5()
	 */
    public boolean isDocBook5() {

        if (docBookVersion != null && docBookVersion == DocBookVersion.V5_0) {
            return true;
        }

        return false;
    }
}