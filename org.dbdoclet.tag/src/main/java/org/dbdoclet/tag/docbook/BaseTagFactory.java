package org.dbdoclet.tag.docbook;

import java.text.SimpleDateFormat;

import org.dbdoclet.tag.TagFactory;
import org.w3c.dom.Element;

public abstract class BaseTagFactory extends TagFactory {

	public Abbrev createAbbrev() {
	
		Abbrev abbrev = new Abbrev();
		initialize(abbrev);
		return abbrev;
	}

	public Abstract createAbstract() {
	
		Abstract _abstract = new Abstract();
		initialize(_abstract);
		return _abstract;
	}

	public Accel createAccel() {
	
		Accel accel = new Accel();
		initialize(accel);
		return accel;
	}

	public Acknowledgements createAcknowledgements() {
	
		Acknowledgements acknowledgements = new Acknowledgements();
		initialize(acknowledgements);
		return acknowledgements;
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

	public Alt createAlt() {
	
		Alt alt = new Alt();
		initialize(alt);
		return alt;
	}

	public Anchor createAnchor() {
	
		Anchor anchor = new Anchor();
		initialize(anchor);
		return anchor;
	}

	public Annotation createAnnotation() {
	
		Annotation annotation = new Annotation();
		initialize(annotation);
		return annotation;
	}

	public Answer createAnswer() {
	
		Answer answer = new Answer();
		initialize(answer);
		return answer;
	}

	public Appendix createAppendix() {
	
		Appendix appendix = new Appendix();
		initialize(appendix);
		return appendix;
	}

	public Application createApplication() {
	
		Application application = new Application();
		initialize(application);
		return application;
	}

	public Arc createArc() {
	
		Arc arc = new Arc();
		initialize(arc);
		return arc;
	}

	public Area createArea() {
	
		Area area = new Area();
		initialize(area);
		return area;
	}

	public Areaset createAreaset() {
	
		Areaset areaset = new Areaset();
		initialize(areaset);
		return areaset;
	}

	public Areaspec createAreaspec() {
	
		Areaspec areaspec = new Areaspec();
		initialize(areaspec);
		return areaspec;
	}

	public Arg createArg() {
	
		Arg arg = new Arg();
		initialize(arg);
		return arg;
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

	public Artpagenums createArtpagenums() {
	
		Artpagenums artpagenums = new Artpagenums();
		initialize(artpagenums);
		return artpagenums;
	}

	public Attribution createAttribution() {
	
		Attribution attribution = new Attribution();
		initialize(attribution);
		return attribution;
	}

	public Audiodata createAudiodata() {
	
		Audiodata audiodata = new Audiodata();
		initialize(audiodata);
		return audiodata;
	}

	public Audioobject createAudioobject() {
	
		Audioobject audioobject = new Audioobject();
		initialize(audioobject);
		return audioobject;
	}

	public Author createAuthor() {
	
		Author author = new Author();
		initialize(author);
		return author;
	}

	public Authorgroup createAuthorgroup() {
	
		Authorgroup authorgroup = new Authorgroup();
		initialize(authorgroup);
		return authorgroup;
	}

	public Authorinitials createAuthorinitials() {
	
		Authorinitials authorinitials = new Authorinitials();
		initialize(authorinitials);
		return authorinitials;
	}

	public Bibliocoverage createBibliocoverage() {
	
		Bibliocoverage bibliocoverage = new Bibliocoverage();
		initialize(bibliocoverage);
		return bibliocoverage;
	}

	public Bibliodiv createBibliodiv() {
	
		Bibliodiv bibliodiv = new Bibliodiv();
		initialize(bibliodiv);
		return bibliodiv;
	}

	public Biblioentry createBiblioentry() {
	
		Biblioentry biblioentry = new Biblioentry();
		initialize(biblioentry);
		return biblioentry;
	}

	public Bibliography createBibliography() {
	
		Bibliography bibliography = new Bibliography();
		initialize(bibliography);
		return bibliography;
	}

	public Biblioid createBiblioid() {
	
		Biblioid biblioid = new Biblioid();
		initialize(biblioid);
		return biblioid;
	}

	public Bibliolist createBibliolist() {
	
		Bibliolist bibliolist = new Bibliolist();
		initialize(bibliolist);
		return bibliolist;
	}

	public Bibliomisc createBibliomisc() {
	
		Bibliomisc bibliomisc = new Bibliomisc();
		initialize(bibliomisc);
		return bibliomisc;
	}

	public Bibliomixed createBibliomixed() {
	
		Bibliomixed bibliomixed = new Bibliomixed();
		initialize(bibliomixed);
		return bibliomixed;
	}

	public Bibliomset createBibliomset() {
	
		Bibliomset bibliomset = new Bibliomset();
		initialize(bibliomset);
		return bibliomset;
	}

	public Biblioref createBiblioref() {
	
		Biblioref biblioref = new Biblioref();
		initialize(biblioref);
		return biblioref;
	}

	public Bibliorelation createBibliorelation() {
	
		Bibliorelation bibliorelation = new Bibliorelation();
		initialize(bibliorelation);
		return bibliorelation;
	}

	public Biblioset createBiblioset() {
	
		Biblioset biblioset = new Biblioset();
		initialize(biblioset);
		return biblioset;
	}

	public Bibliosource createBibliosource() {
	
		Bibliosource bibliosource = new Bibliosource();
		initialize(bibliosource);
		return bibliosource;
	}

	public Blockquote createBlockquote() {
	
		Blockquote blockquote = new Blockquote();
		initialize(blockquote);
		return blockquote;
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

	public Bridgehead createBridgehead() {
	
		Bridgehead Bridgehead = new Bridgehead();
		initialize(Bridgehead);
		return Bridgehead;
	}

	public Callout createCallout() {
	
		Callout callout = new Callout();
		initialize(callout);
		return callout;
	}

	public Calloutlist createCalloutlist() {
	
		Calloutlist calloutlist = new Calloutlist();
		initialize(calloutlist);
		return calloutlist;
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

	public Citation createCitation() {
	
		Citation citation = new Citation();
		initialize(citation);
		return citation;
	}

	public Citebiblioid createCitebiblioid() {
	
		Citebiblioid citebiblioid = new Citebiblioid();
		initialize(citebiblioid);
		return citebiblioid;
	}

	public Citerefentry createCiterefentry() {
	
		Citerefentry citerefentry = new Citerefentry();
		initialize(citerefentry);
		return citerefentry;
	}

	public Citetitle createCitetitle() {
	
		Citetitle citetitle = new Citetitle();
		initialize(citetitle);
		return citetitle;
	}

	public City createCity() {
	
		City city = new City();
		initialize(city);
		return city;
	}

	public Classname createClassname() {
	
		Classname classname = new Classname();
		initialize(classname);
		return classname;
	}

	public Classsynopsis createClasssynopsis() {
	
		Classsynopsis classsynopsis = new Classsynopsis();
		initialize(classsynopsis);
		return classsynopsis;
	}

	public Classsynopsisinfo createClasssynopsisinfo() {
	
		Classsynopsisinfo classsynopsisinfo = new Classsynopsisinfo();
		initialize(classsynopsisinfo);
		return classsynopsisinfo;
	}

	public Cmdsynopsis createCmdsynopsis() {
	
		Cmdsynopsis cmdsynopsis = new Cmdsynopsis();
		initialize(cmdsynopsis);
		return cmdsynopsis;
	}

	public Co createCo() {
	
		Co co = new Co();
		initialize(co);
		return co;
	}

	public Code createCode() {
	
		Code code = new Code();
		initialize(code);
		return code;
	}

	public Col createCol() {
	
		Col col = new Col();
		initialize(col);
		return col;
	}

	public Colgroup createColgroup() {
	
		Colgroup colgroup = new Colgroup();
		initialize(colgroup);
		return colgroup;
	}

	public Collab createCollab() {
	
		Collab collab = new Collab();
		initialize(collab);
		return collab;
	}

	public Colophon createColophon() {
	
		Colophon colophon = new Colophon();
		initialize(colophon);
		return colophon;
	}

	public Colspec createColspec() {
	
		Colspec colspec = new Colspec();
		initialize(colspec);
		return colspec;
	}

	public Command createCommand() {
	
		Command command = new Command();
		initialize(command);
		return command;
	}

	public Computeroutput createComputeroutput() {
	
		Computeroutput computeroutput = new Computeroutput();
		initialize(computeroutput);
		return computeroutput;
	}

	public Confdates createConfdates() {
	
		Confdates confdates = new Confdates();
		initialize(confdates);
		return confdates;
	}

	public Confgroup createConfgroup() {
	
		Confgroup confgroup = new Confgroup();
		initialize(confgroup);
		return confgroup;
	}

	public Confnum createConfnum() {
	
		Confnum confnum = new Confnum();
		initialize(confnum);
		return confnum;
	}

	public Confsponsor createConfsponsor() {
	
		Confsponsor confsponsor = new Confsponsor();
		initialize(confsponsor);
		return confsponsor;
	}

	public Conftitle createConftitle() {
	
		Conftitle conftitle = new Conftitle();
		initialize(conftitle);
		return conftitle;
	}

	public Constant createConstant() {
	
		Constant constant = new Constant();
		initialize(constant);
		return constant;
	}

	public Constraint createConstraint() {
	
		Constraint constraint = new Constraint();
		initialize(constraint);
		return constraint;
	}

	public Constraintdef createConstraintdef() {
	
		Constraintdef constraintdef = new Constraintdef();
		initialize(constraintdef);
		return constraintdef;
	}

	public Constructorsynopsis createConstructorsynopsis() {
	
		Constructorsynopsis constructorsynopsis = new Constructorsynopsis();
		initialize(constructorsynopsis);
		return constructorsynopsis;
	}

	public Contractnum createContractnum() {
	
		Contractnum contractnum = new Contractnum();
		initialize(contractnum);
		return contractnum;
	}

	public Contractsponsor createContractsponsor() {
	
		Contractsponsor contractsponsor = new Contractsponsor();
		initialize(contractsponsor);
		return contractsponsor;
	}

	public Contrib createContrib() {
	
		Contrib contrib = new Contrib();
		initialize(contrib);
		return contrib;
	}

	public Copyright createCopyright() {
	
		Copyright copyright = new Copyright();
		initialize(copyright);
		return copyright;
	}

	public Coref createCoref() {
	
		Coref coref = new Coref();
		initialize(coref);
		return coref;
	}

	public Country createCountry() {
	
		Country country = new Country();
		initialize(country);
		return country;
	}

	public Cover createCover() {
	
		Cover cover = new Cover();
		initialize(cover);
		return cover;
	}

	public Database createDatabase() {
	
		Database database = new Database();
		initialize(database);
		return database;
	}

	public Date createDate() {
	
		java.util.Date today = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		Date date = new Date(sdf.format(today));
		initialize(date);
		return date;
	}

	public Dedication createDedication() {
	
		Dedication dedication = new Dedication();
		initialize(dedication);
		return dedication;
	}

	public Destructorsynopsis createDestructorsynopsis() {
	
		Destructorsynopsis destructorsynopsis = new Destructorsynopsis();
		initialize(destructorsynopsis);
		return destructorsynopsis;
	}

	public Edition createEdition() {
	
		Edition edition = new Edition();
		initialize(edition);
		return edition;
	}

	public Editor createEditor() {
	
		Editor editor = new Editor();
		initialize(editor);
		return editor;
	}

	public Element createElement(String elementName) {
	
		if (elementName == null || elementName.trim().length() == 0) {
			return null;
		}
	
		switch (elementName) {
		case "abbrev":
			return createAbbrev();
		case "abstract":
			return createAbstract();
		case "accel":
			return createAccel();
		case "acknowledgements":
			return createAcknowledgements();
		case "acronym":
			return createAcronym();
		case "address":
			return createAddress();
		case "affiliation":
			return createAffiliation();
		case "alt":
			return createAlt();
		case "anchor":
			return createAnchor();
		case "annotation":
			return createAnnotation();
		case "answer":
			return createAnswer();
		case "appendix":
			return createAppendix();
		case "application":
			return createApplication();
		case "arc":
			return createArc();
		case "area":
			return createArea();
		case "areaset":
			return createAreaset();
		case "areaspec":
			return createAreaspec();
		case "arg":
			return createArg();
		case "article":
			return createArticle();
		case "artpagenums":
			return createArtpagenums();
		case "attribution":
			return createAttribution();
		case "audiodata":
			return createAudiodata();
		case "audioobject":
			return createAudioobject();
		case "author":
			return createAuthor();
		case "authorgroup":
			return createAuthorgroup();
		case "authorinitials":
			return createAuthorinitials();
		case "bibliocoverage":
			return createBibliocoverage();
		case "bibliodiv":
			return createBibliodiv();
		case "biblioentry":
			return createBiblioentry();
		case "bibliography":
			return createBibliography();
		case "biblioid":
			return createBiblioid();
		case "bibliolist":
			return createBibliolist();
		case "bibliomisc":
			return createBibliomisc();
		case "bibliomixed":
			return createBibliomixed();
		case "bibliomset":
			return createBibliomset();
		case "biblioref":
			return createBiblioref();
		case "bibliorelation":
			return createBibliorelation();
		case "biblioset":
			return createBiblioset();
		case "bibliosource":
			return createBibliosource();
		case "blockquote":
			return createBlockquote();
		case "book":
			return createBook();
		case "Bridgehead":
			return createBridgehead();
		case "callout":
			return createCallout();
		case "calloutlist":
			return createCalloutlist();
		case "caption":
			return createCaption();
		case "caution":
			return createCaution();
		case "chapter":
			return createChapter();
		case "citation":
			return createCitation();
		case "citebiblioid":
			return createCitebiblioid();
		case "citerefentry":
			return createCiterefentry();
		case "citetitle":
			return createCitetitle();
		case "city":
			return createCity();
		case "classname":
			return createClassname();
		case "classsynopsis":
			return createClasssynopsis();
		case "classsynopsisinfo":
			return createClasssynopsisinfo();
		case "cmdsynopsis":
			return createCmdsynopsis();
		case "co":
			return createCo();
		case "code":
			return createCode();
		case "col":
			return createCol();
		case "colgroup":
			return createColgroup();
		case "collab":
			return createCollab();
		case "colophon":
			return createColophon();
		case "colspec":
			return createColspec();
		case "command":
			return createCommand();
		case "computeroutput":
			return createComputeroutput();
		case "confdates":
			return createConfdates();
		case "confgroup":
			return createConfgroup();
		case "confnum":
			return createConfnum();
		case "confsponsor":
			return createConfsponsor();
		case "conftitle":
			return createConftitle();
		case "constant":
			return createConstant();
		case "constraint":
			return createConstraint();
		case "constraintdef":
			return createConstraintdef();
		case "constructorsynopsis":
			return createConstructorsynopsis();
		case "contractnum":
			return createContractnum();
		case "contractsponsor":
			return createContractsponsor();
		case "contrib":
			return createContrib();
		case "copyright":
			return createCopyright();
		case "coref":
			return createCoref();
		case "country":
			return createCountry();
		case "cover":
			return createCover();
		case "database":
			return createDatabase();
		case "date":
			return createDate();
		case "dedication":
			return createDedication();
		case "destructorsynopsis":
			return createDestructorsynopsis();
		case "edition":
			return createEdition();
		case "editor":
			return createEditor();
		case "email":
			return createEmail();
		case "emphasis":
			return createEmphasis();
		case "entry":
			return createEntry();
		case "entrytbl":
			return createEntrytbl();
		case "envar":
			return createEnvar();
		case "epigraph":
			return createEpigraph();
		case "equation":
			return createEquation();
		case "errorcode":
			return createErrorcode();
		case "errorname":
			return createErrorname();
		case "errortext":
			return createErrortext();
		case "errortype":
			return createErrortype();
		case "example":
			return createExample();
		case "exceptionname":
			return createExceptionname();
		case "extendedlink":
			return createExtendedlink();
		case "fax":
			return createFax();
		case "fieldsynopsis":
			return createFieldsynopsis();
		case "figure":
			return createFigure();
		case "filename":
			return createFilename();
		case "firstname":
			return createFirstname();
		case "firstterm":
			return createFirstterm();
		case "footnote":
			return createFootnote();
		case "footnoteref":
			return createFootnoteref();
		case "foreignphrase":
			return createForeignphrase();
		case "formalpara":
			return createFormalpara();
		case "funcdef":
			return createFuncdef();
		case "funcparams":
			return createFuncparams();
		case "funcprototype":
			return createFuncprototype();
		case "funcsynopsis":
			return createFuncsynopsis();
		case "funcsynopsisinfo":
			return createFuncsynopsisinfo();
		case "function":
			return createFunction();
		case "glossary":
			return createGlossary();
		case "glossdef":
			return createGlossdef();
		case "glossdiv":
			return createGlossdiv();
		case "glossentry":
			return createGlossentry();
		case "glosslist":
			return createGlosslist();
		case "glosssee":
			return createGlosssee();
		case "glossseealso":
			return createGlossseealso();
		case "glossterm":
			return createGlossterm();
		case "group":
			return createGroup();
		case "guibutton":
			return createGuibutton();
		case "guiicon":
			return createGuiicon();
		case "guilabel":
			return createGuilabel();
		case "guimenu":
			return createGuimenu();
		case "guimenuitem":
			return createGuimenuitem();
		case "guisubmenu":
			return createGuisubmenu();
		case "hardware":
			return createHardware();
		case "holder":
			return createHolder();
		case "honorific":
			return createHonorific();
		case "imagedata":
			return createImagedata();
		case "imageobject":
			return createImageobject();
		case "imageobjectco":
			return createImageobjectco();
		case "important":
			return createImportant();
		case "index":
			return createIndex();
		case "indexdiv":
			return createIndexdiv();
		case "indexentry":
			return createIndexentry();
		case "indexterm":
			return createIndexterm();
		case "info":
			return createInfo();
		case "informalequation":
			return createInformalequation();
		case "informalexample":
			return createInformalexample();
		case "informalfigure":
			return createInformalfigure();
		case "informaltable":
			return createInformaltable();
		case "initializer":
			return createInitializer();
		case "inlineequation":
			return createInlineequation();
		case "inlinemediaobject":
			return createInlinemediaobject();
		case "interfacename":
			return createInterfacename();
		case "issuenum":
			return createIssuenum();
		case "itemizedlist":
			return createItemizedlist();
		case "itermset":
			return createItermset();
		case "jobtitle":
			return createJobtitle();
		case "keycap":
			return createKeycap();
		case "keycode":
			return createKeycode();
		case "keycombo":
			return createKeycombo();
		case "keysym":
			return createKeysym();
		case "keyword":
			return createKeyword();
		case "keywordset":
			return createKeywordset();
		case "label":
			return createLabel();
		case "legalnotice":
			return createLegalnotice();
		case "lhs":
			return createLhs();
		case "lineage":
			return createLineage();
		case "lineannotation":
			return createLineannotation();
		case "link":
			return createLink();
		case "listitem":
			return createListitem();
		case "literal":
			return createLiteral();
		case "literallayout":
			return createLiterallayout();
		case "locator":
			return createLocator();
		case "manvolnum":
			return createManvolnum();
		case "markup":
			return createMarkup();
		case "mathphrase":
			return createMathphrase();
		case "mediaobject":
			return createMediaobject();
		case "member":
			return createMember();
		case "menuchoice":
			return createMenuchoice();
		case "methodname":
			return createMethodname();
		case "methodparam":
			return createMethodparam();
		case "methodsynopsis":
			return createMethodsynopsis();
		case "modifier":
			return createModifier();
		case "mousebutton":
			return createMousebutton();
		case "msg":
			return createMsg();
		case "msgaud":
			return createMsgaud();
		case "msgentry":
			return createMsgentry();
		case "msgexplan":
			return createMsgexplan();
		case "msginfo":
			return createMsginfo();
		case "msglevel":
			return createMsglevel();
		case "msgmain":
			return createMsgmain();
		case "msgorig":
			return createMsgorig();
		case "msgrel":
			return createMsgrel();
		case "msgset":
			return createMsgset();
		case "msgsub":
			return createMsgsub();
		case "msgtext":
			return createMsgtext();
		case "nonterminal":
			return createNonterminal();
		case "note":
			return createNote();
		case "olink":
			return createOlink();
		case "ooclass":
			return createOoclass();
		case "ooexception":
			return createOoexception();
		case "oointerface":
			return createOointerface();
		case "option":
			return createOption();
		case "optional":
			return createOptional();
		case "orderedlist":
			return createOrderedlist();
		case "org":
			return createOrg();
		case "orgdiv":
			return createOrgdiv();
		case "orgname":
			return createOrgname();
		case "otheraddr":
			return createOtheraddr();
		case "othercredit":
			return createOthercredit();
		case "othername":
			return createOthername();
		case "package":
			return createPackage();
		case "pagenums":
			return createPagenums();
		case "para":
			return createPara();
		case "paramdef":
			return createParamdef();
		case "parameter":
			return createParameter();
		case "part":
			return createPart();
		case "partintro":
			return createPartintro();
		case "person":
			return createPerson();
		case "personblurb":
			return createPersonblurb();
		case "personname":
			return createPersonname();
		case "phone":
			return createPhone();
		case "phrase":
			return createPhrase();
		case "pob":
			return createPob();
		case "postcode":
			return createPostcode();
		case "preface":
			return createPreface();
		case "primary":
			return createPrimary();
		case "primaryie":
			return createPrimaryie();
		case "printhistory":
			return createPrinthistory();
		case "procedure":
			return createProcedure();
		case "production":
			return createProduction();
		case "productionrecap":
			return createProductionrecap();
		case "productionset":
			return createProductionset();
		case "productname":
			return createProductname();
		case "productnumber":
			return createProductnumber();
		case "programlisting":
			return createProgramlisting();
		case "programlistingco":
			return createProgramlistingco();
		case "prompt":
			return createPrompt();
		case "property":
			return createProperty();
		case "pubdate":
			return createPubdate();
		case "publisher":
			return createPublisher();
		case "publishername":
			return createPublishername();
		case "qandadiv":
			return createQandadiv();
		case "qandaentry":
			return createQandaentry();
		case "qandaset":
			return createQandaset();
		case "question":
			return createQuestion();
		case "quote":
			return createQuote();
		case "refclass":
			return createRefclass();
		case "refdescriptor":
			return createRefdescriptor();
		case "refentry":
			return createRefentry();
		case "refentrytitle":
			return createRefentrytitle();
		case "reference":
			return createReference();
		case "refmeta":
			return createRefmeta();
		case "refmiscinfo":
			return createRefmiscinfo();
		case "refname":
			return createRefname();
		case "refnamediv":
			return createRefnamediv();
		case "refpurpose":
			return createRefpurpose();
		case "refsect1":
			return createRefsect1();
		case "refsect2":
			return createRefsect2();
		case "refsect3":
			return createRefsect3();
		case "refsection":
			return createRefsection();
		case "refsynopsisdiv":
			return createRefsynopsisdiv();
		case "releaseinfo":
			return createReleaseinfo();
		case "remark":
			return createRemark();
		case "replaceable":
			return createReplaceable();
		case "returnvalue":
			return createReturnvalue();
		case "revdescription":
			return createRevdescription();
		case "revhistory":
			return createRevhistory();
		case "revision":
			return createRevision();
		case "revnumber":
			return createRevnumber();
		case "revremark":
			return createRevremark();
		case "rhs":
			return createRhs();
		case "row":
			return createRow();
		case "sbr":
			return createSbr();
		case "screen":
			return createScreen();
		case "screenco":
			return createScreenco();
		case "screenshot":
			return createScreenshot();
		case "secondary":
			return createSecondary();
		case "secondaryie":
			return createSecondaryie();
		case "sect1":
			return createSect1();
		case "sect2":
			return createSect2();
		case "sect3":
			return createSect3();
		case "sect4":
			return createSect4();
		case "sect5":
			return createSect5();
		case "section":
			return createSection();
		case "see":
			return createSee();
		case "seealso":
			return createSeealso();
		case "seealsoie":
			return createSeealsoie();
		case "seeie":
			return createSeeie();
		case "seg":
			return createSeg();
		case "seglistitem":
			return createSeglistitem();
		case "segmentedlist":
			return createSegmentedlist();
		case "segtitle":
			return createSegtitle();
		case "seriesvolnums":
			return createSeriesvolnums();
		case "set":
			return createSet();
		case "setindex":
			return createSetindex();
		case "shortaffil":
			return createShortaffil();
		case "shortcut":
			return createShortcut();
		case "sidebar":
			return createSidebar();
		case "simpara":
			return createSimpara();
		case "simplelist":
			return createSimplelist();
		case "simplemsgentry":
			return createSimplemsgentry();
		case "simplesect":
			return createSimplesect();
		case "spanspec":
			return createSpanspec();
		case "state":
			return createState();
		case "step":
			return createStep();
		case "stepalternatives":
			return createStepalternatives();
		case "street":
			return createStreet();
		case "subject":
			return createSubject();
		case "subjectset":
			return createSubjectset();
		case "subjectterm":
			return createSubjectterm();
		case "subscript":
			return createSubscript();
		case "substeps":
			return createSubsteps();
		case "subtitle":
			return createSubtitle();
		case "superscript":
			return createSuperscript();
		case "surname":
			return createSurname();
		case "symbol":
			return createSymbol();
		case "synopfragment":
			return createSynopfragment();
		case "synopfragmentref":
			return createSynopfragmentref();
		case "synopsis":
			return createSynopsis();
		case "systemitem":
			return createSystemitem();
		case "table":
			return createTable();
		case "tag":
			return createTag();
		case "task":
			return createTask();
		case "taskprerequisites":
			return createTaskprerequisites();
		case "taskrelated":
			return createTaskrelated();
		case "tasksummary":
			return createTasksummary();
		case "tbody":
			return createTbody();
		case "td":
			return createTd();
		case "term":
			return createTerm();
		case "termdef":
			return createTermdef();
		case "tertiary":
			return createTertiary();
		case "tertiaryie":
			return createTertiaryie();
		case "textdata":
			return createTextdata();
		case "textobject":
			return createTextobject();
		case "tfoot":
			return createTfoot();
		case "tgroup":
			return createTgroup();
		case "th":
			return createTh();
		case "thead":
			return createThead();
		case "tip":
			return createTip();
		case "title":
			return createTitle();
		case "titleabbrev":
			return createTitleabbrev();
		case "toc":
			return createToc();
		case "tocdiv":
			return createTocdiv();
		case "tocentry":
			return createTocentry();
		case "token":
			return createToken();
		case "tr":
			return createTr();
		case "trademark":
			return createTrademark();
		case "type":
			return createType();
		case "uri":
			return createUri();
		case "userinput":
			return createUserinput();
		case "varargs":
			return createVarargs();
		case "variablelist":
			return createVariablelist();
		case "varlistentry":
			return createVarlistentry();
		case "varname":
			return createVarname();
		case "videodata":
			return createVideodata();
		case "videoobject":
			return createVideoobject();
		case "void":
			return createVoid();
		case "volumenum":
			return createVolumenum();
		case "warning":
			return createWarning();
		case "wordasword":
			return createWordasword();
		case "xref":
			return createXref();
		case "year":
			return createYear();
		}
	
		return null;
	}

	public Email createEmail() {
	
		Email email = new Email();
		initialize(email);
		return email;
	}

	public Emphasis createEmphasis() {
	
		Emphasis emphasis = new Emphasis();
		initialize(emphasis);
		return emphasis;
	}

	public Entry createEntry() {
	
		Entry entry = new Entry();
		initialize(entry);
		return entry;
	}

	public Entrytbl createEntrytbl() {
	
		Entrytbl entrytbl = new Entrytbl();
		initialize(entrytbl);
		return entrytbl;
	}

	public Envar createEnvar() {
	
		Envar envar = new Envar();
		initialize(envar);
		return envar;
	}

	public Epigraph createEpigraph() {
	
		Epigraph epigraph = new Epigraph();
		initialize(epigraph);
		return epigraph;
	}

	public Equation createEquation() {
	
		Equation equation = new Equation();
		initialize(equation);
		return equation;
	}

	public Errorcode createErrorcode() {
	
		Errorcode errorcode = new Errorcode();
		initialize(errorcode);
		return errorcode;
	}

	public Errorname createErrorname() {
	
		Errorname errorname = new Errorname();
		initialize(errorname);
		return errorname;
	}

	public Errortext createErrortext() {
	
		Errortext errortext = new Errortext();
		initialize(errortext);
		return errortext;
	}

	public Errortype createErrortype() {
	
		Errortype errortype = new Errortype();
		initialize(errortype);
		return errortype;
	}

	public Example createExample() {
	
		Example example = new Example();
		initialize(example);
		return example;
	}

	public Exceptionname createExceptionname() {
	
		Exceptionname exceptionname = new Exceptionname();
		initialize(exceptionname);
		return exceptionname;
	}

	public Extendedlink createExtendedlink() {
	
		Extendedlink extendedlink = new Extendedlink();
		initialize(extendedlink);
		return extendedlink;
	}

	public Fax createFax() {
	
		Fax fax = new Fax();
		initialize(fax);
		return fax;
	}

	public Fieldsynopsis createFieldsynopsis() {
	
		Fieldsynopsis fieldsynopsis = new Fieldsynopsis();
		initialize(fieldsynopsis);
		return fieldsynopsis;
	}

	public Figure createFigure() {
	
		Figure figure = new Figure();
		initialize(figure);
		return figure;
	}

	public Filename createFilename() {
	
		Filename filename = new Filename();
		initialize(filename);
		return filename;
	}

	public Firstname createFirstname() {
	
		Firstname firstname = new Firstname();
		initialize(firstname);
		return firstname;
	}

	public Firstterm createFirstterm() {
	
		Firstterm firstterm = new Firstterm();
		initialize(firstterm);
		return firstterm;
	}

	public Footnote createFootnote() {
	
		Footnote footnote = new Footnote();
		initialize(footnote);
		return footnote;
	}

	public Footnoteref createFootnoteref() {
	
		Footnoteref footnoteref = new Footnoteref();
		initialize(footnoteref);
		return footnoteref;
	}

	public Foreignphrase createForeignphrase() {
	
		Foreignphrase foreignphrase = new Foreignphrase();
		initialize(foreignphrase);
		return foreignphrase;
	}

	public Formalpara createFormalpara() {
	
		Formalpara formalpara = new Formalpara();
		initialize(formalpara);
		return formalpara;
	}

	public Funcdef createFuncdef() {
	
		Funcdef funcdef = new Funcdef();
		initialize(funcdef);
		return funcdef;
	}

	public Funcparams createFuncparams() {
	
		Funcparams funcparams = new Funcparams();
		initialize(funcparams);
		return funcparams;
	}

	public Funcprototype createFuncprototype() {
	
		Funcprototype funcprototype = new Funcprototype();
		initialize(funcprototype);
		return funcprototype;
	}

	public Funcsynopsis createFuncsynopsis() {
	
		Funcsynopsis funcsynopsis = new Funcsynopsis();
		initialize(funcsynopsis);
		return funcsynopsis;
	}

	public Funcsynopsisinfo createFuncsynopsisinfo() {
	
		Funcsynopsisinfo funcsynopsisinfo = new Funcsynopsisinfo();
		initialize(funcsynopsisinfo);
		return funcsynopsisinfo;
	}

	public Function createFunction() {
	
		Function function = new Function();
		initialize(function);
		return function;
	}

	public Glossary createGlossary() {
	
		Glossary glossary = new Glossary();
		initialize(glossary);
		return glossary;
	}

	public Glossdef createGlossdef() {
	
		Glossdef glossdef = new Glossdef();
		initialize(glossdef);
		return glossdef;
	}

	public Glossdiv createGlossdiv() {
	
		Glossdiv glossdiv = new Glossdiv();
		initialize(glossdiv);
		return glossdiv;
	}

	public Glossentry createGlossentry() {
	
		Glossentry glossentry = new Glossentry();
		initialize(glossentry);
		return glossentry;
	}

	public Glosslist createGlosslist() {
	
		Glosslist glosslist = new Glosslist();
		initialize(glosslist);
		return glosslist;
	}

	public Glosssee createGlosssee() {
	
		Glosssee glosssee = new Glosssee();
		initialize(glosssee);
		return glosssee;
	}

	public Glossseealso createGlossseealso() {
	
		Glossseealso glossseealso = new Glossseealso();
		initialize(glossseealso);
		return glossseealso;
	}

	public Glossterm createGlossterm() {
	
		Glossterm glossterm = new Glossterm();
		initialize(glossterm);
		return glossterm;
	}

	public Group createGroup() {
	
		Group group = new Group();
		initialize(group);
		return group;
	}

	public Guibutton createGuibutton() {
	
		Guibutton guibutton = new Guibutton();
		initialize(guibutton);
		return guibutton;
	}

	public Guiicon createGuiicon() {
	
		Guiicon guiicon = new Guiicon();
		initialize(guiicon);
		return guiicon;
	}

	public Guilabel createGuilabel() {
	
		Guilabel guilabel = new Guilabel();
		initialize(guilabel);
		return guilabel;
	}

	public Guimenu createGuimenu() {
	
		Guimenu guimenu = new Guimenu();
		initialize(guimenu);
		return guimenu;
	}

	public Guimenuitem createGuimenuitem() {
	
		Guimenuitem guimenuitem = new Guimenuitem();
		initialize(guimenuitem);
		return guimenuitem;
	}

	public Guisubmenu createGuisubmenu() {
	
		Guisubmenu guisubmenu = new Guisubmenu();
		initialize(guisubmenu);
		return guisubmenu;
	}

	public Hardware createHardware() {
	
		Hardware hardware = new Hardware();
		initialize(hardware);
		return hardware;
	}

	public Holder createHolder() {
	
		Holder holder = new Holder();
		initialize(holder);
		return holder;
	}

	public Honorific createHonorific() {
	
		Honorific honorific = new Honorific();
		initialize(honorific);
		return honorific;
	}

	public Imagedata createImagedata() {
	
		Imagedata imagedata = new Imagedata();
		initialize(imagedata);
		return imagedata;
	}

	public Imageobject createImageobject() {
	
		Imageobject imageobject = new Imageobject();
		initialize(imageobject);
		return imageobject;
	}

	public Imageobjectco createImageobjectco() {
	
		Imageobjectco imageobjectco = new Imageobjectco();
		initialize(imageobjectco);
		return imageobjectco;
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

	public Indexdiv createIndexdiv() {
	
		Indexdiv indexdiv = new Indexdiv();
		initialize(indexdiv);
		return indexdiv;
	}

	public Indexentry createIndexentry() {
	
		Indexentry indexentry = new Indexentry();
		initialize(indexentry);
		return indexentry;
	}

	public Indexterm createIndexterm() {
	
		Indexterm indexterm = new Indexterm();
		initialize(indexterm);
		return indexterm;
	}

	public Info createInfo() {
	
		Info info = new Info();
		initialize(info);
		return info;
	}

	public Informalequation createInformalequation() {
	
		Informalequation informalequation = new Informalequation();
		initialize(informalequation);
		return informalequation;
	}

	public Informalexample createInformalexample() {
	
		Informalexample informalexample = new Informalexample();
		initialize(informalexample);
		return informalexample;
	}

	public Informalfigure createInformalfigure() {
	
		Informalfigure informalfigure = new Informalfigure();
		initialize(informalfigure);
		return informalfigure;
	}

	public Informaltable createInformaltable() {
	
		Informaltable informaltable = new Informaltable();
		initialize(informaltable);
		return informaltable;
	}

	public Initializer createInitializer() {
	
		Initializer initializer = new Initializer();
		initialize(initializer);
		return initializer;
	}

	public Inlineequation createInlineequation() {
	
		Inlineequation inlineequation = new Inlineequation();
		initialize(inlineequation);
		return inlineequation;
	}

	public Inlinemediaobject createInlinemediaobject() {
	
		Inlinemediaobject inlinemediaobject = new Inlinemediaobject();
		initialize(inlinemediaobject);
		return inlinemediaobject;
	}

	public Interfacename createInterfacename() {
	
		Interfacename interfacename = new Interfacename();
		initialize(interfacename);
		return interfacename;
	}

	public Issuenum createIssuenum() {
	
		Issuenum issuenum = new Issuenum();
		initialize(issuenum);
		return issuenum;
	}

	public Itemizedlist createItemizedlist() {
	
		Itemizedlist itemizedlist = new Itemizedlist();
		initialize(itemizedlist);
		return itemizedlist;
	}

	public Itermset createItermset() {
	
		Itermset itermset = new Itermset();
		initialize(itermset);
		return itermset;
	}

	public Jobtitle createJobtitle() {
	
		Jobtitle jobtitle = new Jobtitle();
		initialize(jobtitle);
		return jobtitle;
	}

	public Keycap createKeycap() {
	
		Keycap keycap = new Keycap();
		initialize(keycap);
		return keycap;
	}

	public Keycode createKeycode() {
	
		Keycode keycode = new Keycode();
		initialize(keycode);
		return keycode;
	}

	public Keycombo createKeycombo() {
	
		Keycombo keycombo = new Keycombo();
		initialize(keycombo);
		return keycombo;
	}

	public Keysym createKeysym() {
	
		Keysym keysym = new Keysym();
		initialize(keysym);
		return keysym;
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

	public Label createLabel() {
	
		Label label = new Label();
		initialize(label);
		return label;
	}

	public Legalnotice createLegalnotice() {
	
		Legalnotice legalnotice = new Legalnotice();
		initialize(legalnotice);
		return legalnotice;
	}

	public Lhs createLhs() {
	
		Lhs lhs = new Lhs();
		initialize(lhs);
		return lhs;
	}

	public Lineage createLineage() {
	
		Lineage lineage = new Lineage();
		initialize(lineage);
		return lineage;
	}

	public Lineannotation createLineannotation() {
	
		Lineannotation lineannotation = new Lineannotation();
		initialize(lineannotation);
		return lineannotation;
	}

	public Link createLink() {
	
		Link link = new Link();
		initialize(link);
		return link;
	}

	public Listitem createListitem() {
	
		Listitem listitem = new Listitem();
		initialize(listitem);
		return listitem;
	}

	public Literal createLiteral() {
	
		Literal literal = new Literal();
		initialize(literal);
		return literal;
	}

	public Literallayout createLiterallayout() {
	
		Literallayout literallayout = new Literallayout();
		initialize(literallayout);
		return literallayout;
	}

	public Locator createLocator() {
	
		Locator locator = new Locator();
		initialize(locator);
		return locator;
	}

	public Manvolnum createManvolnum() {
	
		Manvolnum manvolnum = new Manvolnum();
		initialize(manvolnum);
		return manvolnum;
	}

	public Markup createMarkup() {
	
		Markup markup = new Markup();
		initialize(markup);
		return markup;
	}

	public Mathphrase createMathphrase() {
	
		Mathphrase mathphrase = new Mathphrase();
		initialize(mathphrase);
		return mathphrase;
	}

	public Mediaobject createMediaobject() {
	
		Mediaobject mediaobject = new Mediaobject();
		initialize(mediaobject);
		return mediaobject;
	}

	public Member createMember() {
	
		Member member = new Member();
		initialize(member);
		return member;
	}

	public Menuchoice createMenuchoice() {
	
		Menuchoice menuchoice = new Menuchoice();
		initialize(menuchoice);
		return menuchoice;
	}

	public Methodname createMethodname() {
	
		Methodname methodname = new Methodname();
		initialize(methodname);
		return methodname;
	}

	public Methodparam createMethodparam() {
	
		Methodparam methodparam = new Methodparam();
		initialize(methodparam);
		return methodparam;
	}

	public Methodsynopsis createMethodsynopsis() {
	
		Methodsynopsis methodsynopsis = new Methodsynopsis();
		initialize(methodsynopsis);
		return methodsynopsis;
	}

	public Modifier createModifier() {
	
		Modifier modifier = new Modifier();
		initialize(modifier);
		return modifier;
	}

	public Mousebutton createMousebutton() {
	
		Mousebutton mousebutton = new Mousebutton();
		initialize(mousebutton);
		return mousebutton;
	}

	public Msg createMsg() {
	
		Msg msg = new Msg();
		initialize(msg);
		return msg;
	}

	public Msgaud createMsgaud() {
	
		Msgaud msgaud = new Msgaud();
		initialize(msgaud);
		return msgaud;
	}

	public Msgentry createMsgentry() {
	
		Msgentry msgentry = new Msgentry();
		initialize(msgentry);
		return msgentry;
	}

	public Msgexplan createMsgexplan() {
	
		Msgexplan msgexplan = new Msgexplan();
		initialize(msgexplan);
		return msgexplan;
	}

	public Msginfo createMsginfo() {
	
		Msginfo msginfo = new Msginfo();
		initialize(msginfo);
		return msginfo;
	}

	public Msglevel createMsglevel() {
	
		Msglevel msglevel = new Msglevel();
		initialize(msglevel);
		return msglevel;
	}

	public Msgmain createMsgmain() {
	
		Msgmain msgmain = new Msgmain();
		initialize(msgmain);
		return msgmain;
	}

	public Msgorig createMsgorig() {
	
		Msgorig msgorig = new Msgorig();
		initialize(msgorig);
		return msgorig;
	}

	public Msgrel createMsgrel() {
	
		Msgrel msgrel = new Msgrel();
		initialize(msgrel);
		return msgrel;
	}

	public Msgset createMsgset() {
	
		Msgset msgset = new Msgset();
		initialize(msgset);
		return msgset;
	}

	public Msgsub createMsgsub() {
	
		Msgsub msgsub = new Msgsub();
		initialize(msgsub);
		return msgsub;
	}

	public Msgtext createMsgtext() {
	
		Msgtext msgtext = new Msgtext();
		initialize(msgtext);
		return msgtext;
	}

	public Nonterminal createNonterminal() {
	
		Nonterminal nonterminal = new Nonterminal();
		initialize(nonterminal);
		return nonterminal;
	}

	public Note createNote() {
	
		Note note = new Note();
		initialize(note);
		return note;
	}

	public Olink createOlink() {
	
		Olink olink = new Olink();
		initialize(olink);
		return olink;
	}

	public Ooclass createOoclass() {
	
		Ooclass ooClass = new Ooclass();
		initialize(ooClass);
		return ooClass;
	}

	public Ooexception createOoexception() {
	
		Ooexception ooexception = new Ooexception();
		initialize(ooexception);
		return ooexception;
	}

	public Ooexception createOoException() {
	
		Ooexception ooException = new Ooexception();
		initialize(ooException);
		return ooException;
	}

	public Oointerface createOointerface() {
	
		Oointerface oointerface = new Oointerface();
		initialize(oointerface);
		return oointerface;
	}

	public Option createOption() {
	
		Option option = new Option();
		initialize(option);
		return option;
	}

	public Optional createOptional() {
	
		Optional optional = new Optional();
		initialize(optional);
		return optional;
	}

	public Orderedlist createOrderedlist() {
	
		Orderedlist orderedlist = new Orderedlist();
		initialize(orderedlist);
		return orderedlist;
	}

	public Org createOrg() {
	
		Org org = new Org();
		initialize(org);
		return org;
	}

	public Orgdiv createOrgdiv() {
	
		Orgdiv orgdiv = new Orgdiv();
		initialize(orgdiv);
		return orgdiv;
	}

	public Orgname createOrgname() {
	
		Orgname orgname = new Orgname();
		initialize(orgname);
		return orgname;
	}

	public Otheraddr createOtheraddr() {
	
		Otheraddr otheraddr = new Otheraddr();
		initialize(otheraddr);
		return otheraddr;
	}

	public Othercredit createOthercredit() {
	
		Othercredit othercredit = new Othercredit();
		initialize(othercredit);
		return othercredit;
	}

	public Othername createOthername() {
	
		Othername othername = new Othername();
		initialize(othername);
		return othername;
	}

	public Package createPackage() {
	
		Package _package = new Package();
		initialize(_package);
		return _package;
	}

	public Pagenums createPagenums() {
	
		Pagenums pagenums = new Pagenums();
		initialize(pagenums);
		return pagenums;
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

	public Paramdef createParamdef() {
	
		Paramdef paramdef = new Paramdef();
		initialize(paramdef);
		return paramdef;
	}

	public Parameter createParameter() {
	
		Parameter parameter = new Parameter();
		initialize(parameter);
		return parameter;
	}

	public Part createPart() {
	
		Part part = new Part();
		initialize(part);
		return part;
	}

	public Partinfo createPartinfo() {
	
		Partinfo partInfo = new Partinfo();
		initialize(partInfo);
		return partInfo;
	}

	public Partintro createPartintro() {
	
		Partintro partintro = new Partintro();
		initialize(partintro);
		return partintro;
	}

	public Person createPerson() {
	
		Person person = new Person();
		initialize(person);
		return person;
	}

	public Personblurb createPersonblurb() {
	
		Personblurb personblurb = new Personblurb();
		initialize(personblurb);
		return personblurb;
	}

	public Personname createPersonname() {
	
		Personname personname = new Personname();
		initialize(personname);
		return personname;
	}

	public Phone createPhone() {
	
		Phone phone = new Phone();
		initialize(phone);
		return phone;
	}

	public Phrase createPhrase() {
	
		Phrase phrase = new Phrase();
		initialize(phrase);
		return phrase;
	}

	public Pob createPob() {
	
		Pob pob = new Pob();
		initialize(pob);
		return pob;
	}

	public Postcode createPostcode() {
	
		Postcode postcode = new Postcode();
		initialize(postcode);
		return postcode;
	}

	public Preface createPreface() {
	
		Preface preface = new Preface();
		initialize(preface);
		return preface;
	}

	public Primary createPrimary() {
	
		Primary primary = new Primary();
		initialize(primary);
		return primary;
	}

	public Primaryie createPrimaryie() {
	
		Primaryie primaryie = new Primaryie();
		initialize(primaryie);
		return primaryie;
	}

	public Printhistory createPrinthistory() {
	
		Printhistory printhistory = new Printhistory();
		initialize(printhistory);
		return printhistory;
	}

	public Procedure createProcedure() {
	
		Procedure procedure = new Procedure();
		initialize(procedure);
		return procedure;
	}

	public Production createProduction() {
	
		Production production = new Production();
		initialize(production);
		return production;
	}

	public Productionrecap createProductionrecap() {
	
		Productionrecap productionrecap = new Productionrecap();
		initialize(productionrecap);
		return productionrecap;
	}

	public Productionset createProductionset() {
	
		Productionset productionset = new Productionset();
		initialize(productionset);
		return productionset;
	}

	public Productname createProductname() {
	
		Productname productname = new Productname();
		initialize(productname);
		return productname;
	}

	public Productnumber createProductnumber() {
	
		Productnumber productnumber = new Productnumber();
		initialize(productnumber);
		return productnumber;
	}

	public Programlisting createProgramlisting() {
	
		Programlisting programlisting = new Programlisting();
		initialize(programlisting);
		return programlisting;
	}

	public Programlistingco createProgramlistingco() {
	
		Programlistingco programlistingco = new Programlistingco();
		initialize(programlistingco);
		return programlistingco;
	}

	public Prompt createPrompt() {
	
		Prompt prompt = new Prompt();
		initialize(prompt);
		return prompt;
	}

	public Property createProperty() {
	
		Property property = new Property();
		initialize(property);
		return property;
	}

	public Pubdate createPubdate() {
	
		Pubdate pubdate = new Pubdate();
		initialize(pubdate);
		return pubdate;
	}

	public Publisher createPublisher() {
	
		Publisher publisher = new Publisher();
		initialize(publisher);
		return publisher;
	}

	public Publishername createPublishername() {
	
		Publishername publishername = new Publishername();
		initialize(publishername);
		return publishername;
	}

	public Qandadiv createQandadiv() {
	
		Qandadiv qandadiv = new Qandadiv();
		initialize(qandadiv);
		return qandadiv;
	}

	public Qandaentry createQandaentry() {
	
		Qandaentry qandaentry = new Qandaentry();
		initialize(qandaentry);
		return qandaentry;
	}

	public Qandaset createQandaset() {
	
		Qandaset qandaset = new Qandaset();
		initialize(qandaset);
		return qandaset;
	}

	public Question createQuestion() {
	
		Question question = new Question();
		initialize(question);
		return question;
	}

	public Quote createQuote() {
	
		Quote quote = new Quote();
		initialize(quote);
		return quote;
	}

	public Refclass createRefclass() {
	
		Refclass refclass = new Refclass();
		initialize(refclass);
		return refclass;
	}

	public Refdescriptor createRefdescriptor() {
	
		Refdescriptor refdescriptor = new Refdescriptor();
		initialize(refdescriptor);
		return refdescriptor;
	}

	public Refentry createRefentry() {
	
		Refentry refentry = new Refentry();
		initialize(refentry);
		return refentry;
	}

	public Refentryinfo createRefentryinfo() {
	
		Refentryinfo refEntryInfo = new Refentryinfo();
		initialize(refEntryInfo);
		return refEntryInfo;
	}

	public Refentrytitle createRefentrytitle() {
	
		Refentrytitle refentrytitle = new Refentrytitle();
		initialize(refentrytitle);
		return refentrytitle;
	}

	public Reference createReference() {
	
		Reference reference = new Reference();
		initialize(reference);
		return reference;
	}

	public Refmeta createRefmeta() {
	
		Refmeta refmeta = new Refmeta();
		initialize(refmeta);
		return refmeta;
	}

	public Refmiscinfo createRefmiscinfo() {
	
		Refmiscinfo refmiscinfo = new Refmiscinfo();
		initialize(refmiscinfo);
		return refmiscinfo;
	}

	public Refname createRefname() {
	
		Refname refname = new Refname();
		initialize(refname);
		return refname;
	}

	public Refnamediv createRefnamediv() {
	
		Refnamediv refnamediv = new Refnamediv();
		initialize(refnamediv);
		return refnamediv;
	}

	public Refpurpose createRefpurpose() {
	
		Refpurpose refpurpose = new Refpurpose();
		initialize(refpurpose);
		return refpurpose;
	}

	public Refsect1 createRefsect1() {
	
		Refsect1 refsect1 = new Refsect1();
		initialize(refsect1);
		return refsect1;
	}

	public Refsect2 createRefsect2() {
	
		Refsect2 refsect2 = new Refsect2();
		initialize(refsect2);
		return refsect2;
	}

	public Refsect3 createRefsect3() {
	
		Refsect3 refsect3 = new Refsect3();
		initialize(refsect3);
		return refsect3;
	}

	public Refsect4 createRefsect4() {
	
		Refsect4 refSect4 = new Refsect4();
		initialize(refSect4);
		return refSect4;
	}

	public Refsect5 createRefsect5() {
	
		Refsect5 refSect5 = new Refsect5();
		initialize(refSect5);
		return refSect5;
	}

	public Refsection createRefsection() {
	
		Refsection refSection = new Refsection();
		initialize(refSection);
		return refSection;
	}

	public Refsynopsisdiv createRefsynopsisdiv() {
	
		Refsynopsisdiv refsynopsisdiv = new Refsynopsisdiv();
		initialize(refsynopsisdiv);
		return refsynopsisdiv;
	}

	public Releaseinfo createReleaseinfo() {
	
		Releaseinfo releaseinfo = new Releaseinfo();
		initialize(releaseinfo);
		return releaseinfo;
	}

	public Remark createRemark() {
	
		Remark remark = new Remark();
		initialize(remark);
		return remark;
	}

	public Replaceable createReplaceable() {
	
		Replaceable replaceable = new Replaceable();
		initialize(replaceable);
		return replaceable;
	}

	public Returnvalue createReturnvalue() {
	
		Returnvalue returnvalue = new Returnvalue();
		initialize(returnvalue);
		return returnvalue;
	}

	public Revdescription createRevdescription() {
	
		Revdescription revdescription = new Revdescription();
		initialize(revdescription);
		return revdescription;
	}

	public Revhistory createRevhistory() {
	
		Revhistory revhistory = new Revhistory();
		initialize(revhistory);
		return revhistory;
	}

	public Revision createRevision() {
	
		Revision revision = new Revision();
		initialize(revision);
		return revision;
	}

	public Revnumber createRevnumber() {
	
		Revnumber revnumber = new Revnumber();
		initialize(revnumber);
		return revnumber;
	}

	public Revremark createRevremark() {
	
		Revremark revremark = new Revremark();
		initialize(revremark);
		return revremark;
	}

	public Rhs createRhs() {
	
		Rhs rhs = new Rhs();
		initialize(rhs);
		return rhs;
	}

	public Row createRow() {
	
		Row row = new Row();
		initialize(row);
		return row;
	}

	public Sbr createSbr() {
	
		Sbr sbr = new Sbr();
		initialize(sbr);
		return sbr;
	}

	public Screen createScreen() {
	
		Screen screen = new Screen();
		initialize(screen);
		return screen;
	}

	public Screenco createScreenco() {
	
		Screenco screenco = new Screenco();
		initialize(screenco);
		return screenco;
	}

	public Screenshot createScreenshot() {
	
		Screenshot screenshot = new Screenshot();
		initialize(screenshot);
		return screenshot;
	}

	public Secondary createSecondary() {
	
		Secondary secondary = new Secondary();
		initialize(secondary);
		return secondary;
	}

	public Secondaryie createSecondaryie() {
	
		Secondaryie secondaryie = new Secondaryie();
		initialize(secondaryie);
		return secondaryie;
	}

	public Sect1 createSect1() {
	
		Sect1 sect1 = new Sect1();
		initialize(sect1);
		return sect1;
	}

	public Sect2 createSect2() {
	
		Sect2 sect2 = new Sect2();
		initialize(sect2);
		return sect2;
	}

	public Sect3 createSect3() {
	
		Sect3 sect3 = new Sect3();
		initialize(sect3);
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

	public See createSee() {
	
		See see = new See();
		initialize(see);
		return see;
	}

	public Seealso createSeealso() {
	
		Seealso seealso = new Seealso();
		initialize(seealso);
		return seealso;
	}

	public Seealsoie createSeealsoie() {
	
		Seealsoie seealsoie = new Seealsoie();
		initialize(seealsoie);
		return seealsoie;
	}

	public Seeie createSeeie() {
	
		Seeie seeie = new Seeie();
		initialize(seeie);
		return seeie;
	}

	public Seg createSeg() {
	
		Seg seg = new Seg();
		initialize(seg);
		return seg;
	}

	public Seglistitem createSeglistitem() {
	
		Seglistitem seglistitem = new Seglistitem();
		initialize(seglistitem);
		return seglistitem;
	}

	public Segmentedlist createSegmentedlist() {
	
		Segmentedlist segmentedlist = new Segmentedlist();
		initialize(segmentedlist);
		return segmentedlist;
	}

	public Segtitle createSegtitle() {
	
		Segtitle segtitle = new Segtitle();
		initialize(segtitle);
		return segtitle;
	}

	public Seriesvolnums createSeriesvolnums() {
	
		Seriesvolnums seriesvolnums = new Seriesvolnums();
		initialize(seriesvolnums);
		return seriesvolnums;
	}

	public Set createSet() {
	
		Set set = new Set();
		initialize(set);
		return set;
	}

	public Setindex createSetindex() {
	
		Setindex setindex = new Setindex();
		initialize(setindex);
		return setindex;
	}

	public Shortaffil createShortaffil() {
	
		Shortaffil shortaffil = new Shortaffil();
		initialize(shortaffil);
		return shortaffil;
	}

	public Shortcut createShortcut() {
	
		Shortcut shortcut = new Shortcut();
		initialize(shortcut);
		return shortcut;
	}

	public Sidebar createSidebar() {
	
		Sidebar sidebar = new Sidebar();
		initialize(sidebar);
		return sidebar;
	}

	public Simpara createSimpara() {
	
		Simpara simpara = new Simpara();
		initialize(simpara);
		return simpara;
	}

	public Simplelist createSimplelist() {
	
		Simplelist simplelist = new Simplelist();
		initialize(simplelist);
		return simplelist;
	}

	public Simplemsgentry createSimplemsgentry() {
	
		Simplemsgentry simplemsgentry = new Simplemsgentry();
		initialize(simplemsgentry);
		return simplemsgentry;
	}

	public Simplesect createSimplesect() {
	
		Simplesect simpleSect = new Simplesect();
		initialize(simpleSect);
		return simpleSect;
	}

	public Spanspec createSpanspec() {
	
		Spanspec spanspec = new Spanspec();
		initialize(spanspec);
		return spanspec;
	}

	public State createState() {
	
		State state = new State();
		initialize(state);
		return state;
	}

	public Step createStep() {
	
		Step step = new Step();
		initialize(step);
		return step;
	}

	public Stepalternatives createStepalternatives() {
	
		Stepalternatives stepalternatives = new Stepalternatives();
		initialize(stepalternatives);
		return stepalternatives;
	}

	public Street createStreet() {
	
		Street street = new Street();
		initialize(street);
		return street;
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

	public Substeps createSubsteps() {
	
		Substeps substeps = new Substeps();
		initialize(substeps);
		return substeps;
	}

	public Subtitle createSubtitle() {
	
		Subtitle subtitle = new Subtitle();
		initialize(subtitle);
		return subtitle;
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

	public Symbol createSymbol() {
	
		Symbol symbol = new Symbol();
		initialize(symbol);
		return symbol;
	}

	public Synopfragment createSynopfragment() {
	
		Synopfragment synopfragment = new Synopfragment();
		initialize(synopfragment);
		return synopfragment;
	}

	public Synopfragmentref createSynopfragmentref() {
	
		Synopfragmentref synopfragmentref = new Synopfragmentref();
		initialize(synopfragmentref);
		return synopfragmentref;
	}

	public Synopsis createSynopsis() {
	
		Synopsis synopsis = new Synopsis();
		initialize(synopsis);
		return synopsis;
	}

	public Systemitem createSystemitem() {
	
		Systemitem systemitem = new Systemitem();
		initialize(systemitem);
		return systemitem;
	}

	public Table createTable() {
	
		Table table = new Table();
		initialize(table);
		return table;
	}

	public Tag createTag() {
	
		Tag tag = new Tag();
		initialize(tag);
		return tag;
	}

	public Task createTask() {
	
		Task task = new Task();
		initialize(task);
		return task;
	}

	public Taskprerequisites createTaskprerequisites() {
	
		Taskprerequisites taskprerequisites = new Taskprerequisites();
		initialize(taskprerequisites);
		return taskprerequisites;
	}

	public Taskrelated createTaskrelated() {
	
		Taskrelated taskrelated = new Taskrelated();
		initialize(taskrelated);
		return taskrelated;
	}

	public Tasksummary createTasksummary() {
	
		Tasksummary tasksummary = new Tasksummary();
		initialize(tasksummary);
		return tasksummary;
	}

	public Tbody createTbody() {
	
		Tbody tbody = new Tbody();
		initialize(tbody);
		return tbody;
	}

	public Td createTd() {
	
		Td td = new Td();
		initialize(td);
		return td;
	}

	public Term createTerm() {
	
		Term term = new Term();
		initialize(term);
		return term;
	}

	public Termdef createTermdef() {
	
		Termdef termdef = new Termdef();
		initialize(termdef);
		return termdef;
	}

	public Tertiary createTertiary() {
	
		Tertiary tertiary = new Tertiary();
		initialize(tertiary);
		return tertiary;
	}

	public Tertiaryie createTertiaryie() {
	
		Tertiaryie tertiaryie = new Tertiaryie();
		initialize(tertiaryie);
		return tertiaryie;
	}

	public Textdata createTextdata() {
	
		Textdata textdata = new Textdata();
		initialize(textdata);
		return textdata;
	}

	public Textobject createTextobject() {
	
		Textobject textobject = new Textobject();
		initialize(textobject);
		return textobject;
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

	public Th createTh() {
	
		Th th = new Th();
		initialize(th);
		return th;
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

	public Titleabbrev createTitleabbrev() {
	
		Titleabbrev titleabbrev = new Titleabbrev();
		initialize(titleabbrev);
		return titleabbrev;
	}

	public Toc createToc() {
	
		Toc toc = new Toc();
		initialize(toc);
		return toc;
	}

	public Tocdiv createTocdiv() {
	
		Tocdiv tocdiv = new Tocdiv();
		initialize(tocdiv);
		return tocdiv;
	}

	public Tocentry createTocentry() {
	
		Tocentry tocentry = new Tocentry();
		initialize(tocentry);
		return tocentry;
	}

	public Token createToken() {
	
		Token token = new Token();
		initialize(token);
		return token;
	}

	public Tr createTr() {
	
		Tr tr = new Tr();
		initialize(tr);
		return tr;
	}

	public Trademark createTrademark() {
	
		Trademark trademark = new Trademark();
		initialize(trademark);
		return trademark;
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

	public Uri createUri() {
	
		Uri uri = new Uri();
		initialize(uri);
		return uri;
	}

	public Userinput createUserinput() {
	
		Userinput userinput = new Userinput();
		initialize(userinput);
		return userinput;
	}

	public Varargs createVarargs() {
	
		Varargs varargs = new Varargs();
		initialize(varargs);
		return varargs;
	}

	public Variablelist createVariablelist() {
	
		Variablelist variablelist = new Variablelist();
		initialize(variablelist);
		return variablelist;
	}

	public Varlistentry createVarlistentry() {
	
		Varlistentry varlistentry = new Varlistentry();
		initialize(varlistentry);
		return varlistentry;
	}

	public Varname createVarname() {
	
		Varname varname = new Varname();
		initialize(varname);
		return varname;
	}

	public Videodata createVideodata() {
	
		Videodata videodata = new Videodata();
		initialize(videodata);
		return videodata;
	}

	public Videoobject createVideoobject() {
	
		Videoobject videoobject = new Videoobject();
		initialize(videoobject);
		return videoobject;
	}

	public Void createVoid() {
	
		Void _void = new Void();
		initialize(_void);
		return _void;
	}

	public Volumenum createVolumenum() {
	
		Volumenum volumenum = new Volumenum();
		initialize(volumenum);
		return volumenum;
	}

	public Warning createWarning() {
	
		Warning warning = new Warning();
		initialize(warning);
		return warning;
	}

	public Wordasword createWordasword() {
	
		Wordasword wordasword = new Wordasword();
		initialize(wordasword);
		return wordasword;
	}

	public Xref createXref() {
	
		Xref xref = new Xref();
		initialize(xref);
		return xref;
	}

	public Year createYear() {
	
		Year year = new Year();
		initialize(year);
		return year;
	}

}
