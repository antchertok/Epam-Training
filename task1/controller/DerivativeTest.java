package by.epam.task1.controller;

import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Insurance;
import by.epam.task1.model.Derivative;
import by.epam.task1.util.DerivativeMaker;
import by.epam.task1.util.InsuranceFinder;

import java.util.Comparator;



public class DerivativeTest {

    public static void main(String[] args) {
        DerivativeMaker derivativeMaker = new DerivativeMaker();
        Derivative derivative = derivativeMaker.makeDerivative(10, 2000, 100);

        System.out.println("TOTAL: " + derivative.calculateTotal());

        System.out.println(derivative.toString());
        derivative.addInsurance(new AccumulativeInsurance(1250, "business", 3, 5));


        derivative.sortInsurances(new Comparator<Insurance>() {
            @Override
            public int compare(Insurance o1, Insurance o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println(derivative.toString());

        InsuranceFinder insuranceFinder = new InsuranceFinder();
        System.out.println(insuranceFinder.findInsurancesWithCost(derivative, 1200, 1700));
    }

}
