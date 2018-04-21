package by.epam.task1.controller;

import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Insurance;
import by.epam.task1.view.View;
import by.epam.task1.model.Derivative;

import java.util.Comparator;

import static by.epam.task1.model.util.DerivativeMaker.DERIVATIVE_MAKER;

public class DerivativeTest {

    public static void main(String[] args) {
        Derivative derivative = DERIVATIVE_MAKER.makeDerivative(10, 2000, 100);

        View.print("TOTAL: " + derivative.calculateTotal());

        View.print(derivative.toString());
        derivative.addInsurance(new AccumulativeInsurance(1250, "business", 3, 5));

        derivative.sortInsurances(new Comparator<Insurance>() {
            @Override
            public int compare(Insurance o1, Insurance o2) {
                return -o1.compareTo(o2);
            }
        });

        View.print(derivative.toString());
        View.print(derivative.findInsurances("Cost", 1200, 1700));
    }

}
