package by.epam.task1.controller;

import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Insurance;
import by.epam.task1.model.Derivative;
import by.epam.task1.util.InsuranceFinder;
import by.epam.task1.util.parser.DerivativeDomParser;
import by.epam.task1.util.parser.Director;
import org.apache.log4j.Logger;

import java.util.Comparator;


public class DerivativeTest {
    private static final Logger LOGGER = Logger.getLogger(DerivativeTest.class.getName());
    private static final String PATH = "C:\\Users\\-\\IdeaProjects\\StartProjects\\src\\by\\epam\\task1\\data\\deriv.xml";

    public static void main(String[] args) {
        Derivative derivative = new Director(new DerivativeDomParser()).parse(PATH);

        LOGGER.info("TOTAL: " + derivative.calculateTotal());

        LOGGER.info(derivative.toString());
        derivative.addInsurance(new AccumulativeInsurance(1250, "business", 3, 5));


        derivative.sortInsurances(new Comparator<Insurance>() {
            @Override
            public int compare(Insurance o1, Insurance o2) {
                return -o1.compareTo(o2);
            }
        });

        LOGGER.info(derivative.toString());

        InsuranceFinder insuranceFinder = new InsuranceFinder();
        LOGGER.info(insuranceFinder.findInsurancesWithCost(derivative, 1200, 1700));
    }

}
