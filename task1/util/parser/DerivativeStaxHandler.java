package by.epam.task1.util.parser;

import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Insurance;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DerivativeStaxHandler implements DerivativeParser{
    private static final Logger LOGGER = Logger.getLogger(DerivativeStaxHandler.class.getName());

    public Derivative parse(String path) {
        Derivative derivative = new Derivative("Insuranses");
        Insurance insurance = null;
        DerivativeTagName tagName = null;

        try {
            InputStream xml = new FileInputStream(path);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xml);

            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        tagName = DerivativeTagName.valueOf(reader.getLocalName().toUpperCase());
                        switch (tagName) {
                            case INSURANCE:
                                if (reader.getAttributeValue(null, "isAccumulative").equals("yes")) {
                                    insurance = new AccumulativeInsurance();
                                } else {
                                    insurance = new Insurance();
                                }
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();

                        if (text.isEmpty()) {
                            break;
                        }
                        switch (tagName) {
                            case RISK:
                                insurance.setRiskLevel(Integer.parseInt(text));
                                break;
                            case COST:
                                insurance.setCost(Integer.parseInt(text));
                                break;
                            case SPHERE:
                                insurance.setInsuranceSphere(text);
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tagName = DerivativeTagName.valueOf(reader.getLocalName().toUpperCase());
                        switch (tagName) {
                            case INSURANCE:
                                derivative.addInsurance(insurance);
                        }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("Unexpected processing error: " + e);
        } catch (FileNotFoundException e) {
            LOGGER.error("Failed to find file. " + e);
        }

        return derivative;
    }

    public static void main(String[] args) {
        DerivativeSaxHandler dsh = new DerivativeSaxHandler();


            Derivative derivative = dsh.parse("C:\\Users\\-\\IdeaProjects\\StartProjects\\src\\by\\epam\\task1\\data\\deriv.xml");
            System.out.println(derivative.toString());

        DerivativeDomParser domParser = new DerivativeDomParser();
//            InputStream xml = new FileInputStream("C:\\Users\\-\\IdeaProjects\\StartProjects\\src");
//            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
//            XMLStreamReader reader = inputFactory.createXMLStreamReader(xml);
        derivative = domParser.parse("C:\\Users\\-\\IdeaProjects\\StartProjects\\src\\by\\epam\\task1\\data\\deriv.xml");
        System.out.println(derivative.toString());


            derivative = new DerivativeStaxHandler().parse("C:\\Users\\-\\IdeaProjects\\StartProjects\\src\\by\\epam\\task1\\data\\deriv.xml");
            System.out.println(derivative.toString());




    }

}
