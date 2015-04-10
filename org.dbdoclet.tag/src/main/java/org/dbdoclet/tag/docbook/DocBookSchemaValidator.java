package org.dbdoclet.tag.docbook;

import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.dbdoclet.ValidationResult;
import org.dbdoclet.service.ResourceServices;
import org.dbdoclet.service.StringServices;
import org.dbdoclet.tag.ITransformPosition;
import org.dbdoclet.xiphias.NodeSerializer;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DocBookSchemaValidator {

	// private static Log logger = LogFactory.getLog(DocBookSchemaValidator.class);

	private static DocBookSchemaValidator singleton;
	private Validator validator;

	private DocBookSchemaValidator() throws SAXException {

		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		URL schemaUrl = ResourceServices
				.getResourceAsUrl("/xsd/docbook/docbook.xsd");
		Schema schema = schemaFactory.newSchema(schemaUrl);
		validator = schema.newValidator();
		validator.setErrorHandler(new DocBookSchemaValidatorErrorHandler());
	}

	public ValidationResult validate(ITransformPosition pos, Node node) {

		ValidationResult result = new ValidationResult();
		
		try {
			
			validator.validate(new DOMSource(node));
			result.setValid(true);
			return result;
			
		} catch (SAXException | IOException oops) {
			
			result.setMessage(String.format("[%s] %s:\nXML::%s::\n%s\n", pos.getDescription(), oops.getClass()
					.getSimpleName(), new NodeSerializer().toXML(node),
					StringServices.splitAt(oops.getMessage(), " ")));
			result.setValid(false);
			return result;
		}
	}

	public static DocBookSchemaValidator getInstance() throws SAXException {

		if (singleton == null) {
			singleton = new DocBookSchemaValidator();
		}

		return singleton;
	}
}

class DocBookSchemaValidatorErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		throw(exception);
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		
		String msg = exception.getMessage();
		
		if (msg != null) {
			if (msg.startsWith("cvc-id")) {
				return;
			}
		}
		
		throw(exception);
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		throw(exception);		
	}
}