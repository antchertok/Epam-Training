package by.epam.task1.controller;

import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Insurance;
import by.epam.task1.model.Derivative;
import by.epam.task1.util.DerivativeMaker;
import by.epam.task1.util.InsuranceFinder;
import org.apache.log4j.Logger;

import java.util.Comparator;


public class DerivativeTest {
    private static final Logger logger = Logger.getLogger(DerivativeTest.class.getName());

    public static void main(String[] args) {
        DerivativeMaker derivativeMaker = new DerivativeMaker();
        Derivative derivative = derivativeMaker.makeDerivative(10, 2000, 100);

        logger.info("TOTAL: " + derivative.calculateTotal());

        logger.info(derivative.toString());
        derivative.addInsurance(new AccumulativeInsurance(1250, "business", 3, 5));


        derivative.sortInsurances(new Comparator<Insurance>() {
            @Override
            public int compare(Insurance o1, Insurance o2) {
                return -o1.compareTo(o2);
            }
        });

        logger.info(derivative.toString());

        InsuranceFinder insuranceFinder = new InsuranceFinder();
        logger.info(insuranceFinder.findInsurancesWithCost(derivative, 1200, 1700));
    }

}
