package by.epam.task1.util.parser;

import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.Insurance;
import org.apache.log4j.Logger;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DerivativeDomParser implements DerivativeParser{
    private static final Logger LOGGER = Logger.getLogger(DerivativeDomParser.class.getName());

    public Derivative parse(String path) {
        Derivative derivative = new Derivative("DOMInsurances");
        try {
            DOMParser dom = new DOMParser();
            dom.parse(path);
            Document document = dom.getDocument();
            Element derivativeRoot = document.getDocumentElement();
            NodeList insurances = derivativeRoot.getElementsByTagName("insurance");
            Insurance insurance = null;
            for (int i = 0; i < insurances.getLength(); i++) {
                insurance = new Insurance();
                Element insuranceElement = (Element) insurances.item(i);
                insurance.setCost(Integer.parseInt(getElementByTag(insuranceElement, "cost").getTextContent().trim()));
                insurance.setRiskLevel(Integer.parseInt(getElementByTag(insuranceElement, "risk").getTextContent().trim()));
                insurance.setInsuranceSphere(getElementByTag(insuranceElement, "sphere").getTextContent().trim());
                derivative.addInsurance(insurance);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return derivative;
    }

    private Element getElementByTag(Element parentElement, String tag) {
        NodeList nodeList = parentElement.getElementsByTagName(tag);
        return (Element) nodeList.item(0);
    }
}
