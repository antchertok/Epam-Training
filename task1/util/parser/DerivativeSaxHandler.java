package by.epam.task1.util.parser;

import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Insurance;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class DerivativeSaxHandler extends DefaultHandler
        implements DerivativeParser{
    private static final Logger LOGGER = Logger.getLogger(DerivativeSaxHandler.class.getName());
    private StringBuilder text;
    private Insurance insurance;
    private Derivative derivative = new Derivative("Insurances");

    @Override
    public void startDocument() throws SAXException {
        LOGGER.debug("Parsing started");
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.debug("Parsing finished");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        LOGGER.debug("startElement -> " + (!uri.isEmpty() ? "uri: " + uri + ", " : "")
                + "localName: " + localName + ", qName: " + qName);
        text = new StringBuilder();

        if (qName.equals("insurance")) {
            if (attributes.getValue("isAccumulative").equals("yes")) {
                insurance = new AccumulativeInsurance();
            } else {
                insurance = new Insurance();
            }
        }
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        DerivativeTagName tagName = DerivativeTagName.valueOf(qName.toUpperCase());
        switch (tagName) {
            case COST:
                insurance.setCost(Integer.parseInt(text.toString()));
                break;
            case RISK:
                insurance.setRiskLevel(Integer.parseInt(text.toString()));
                break;
            case SPHERE:
                insurance.setInsuranceSphere(text.toString());
                break;
            case INSURANCE:
                derivative.addInsurance(insurance);
                insurance = null;
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) {
        LOGGER.error("WARNING: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        LOGGER.error("ERROR: line " + e.getLineNumber() + ": " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        LOGGER.fatal("ERROR: line " + e.getLineNumber() + ": " + e.getMessage());
        throw e;
    }

    public Derivative parse(String path) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(path);
        } catch (SAXException | IOException e) {
            LOGGER.error("ERROR: " + e.getMessage());
        }
        return getDerivative();
    }

    public Derivative getDerivative() {
        return derivative;
    }
}
