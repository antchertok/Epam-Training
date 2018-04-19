package by.epam.task1.controller;

import by.epam.task1.model.entity.AccumulativeInsurance;
import by.epam.task1.model.entity.Obligation;
import by.epam.task1.view.View;
import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.Insurance;
import java.util.Comparator;

import static by.epam.task1.model.util.DerivativeMaker.DERIVATIVE_MAKER;

public class DerivativeTest {

    public static void main(String[] args) {
        Derivative derivative = DERIVATIVE_MAKER.makeDerivative(10, 2000, 100);

        View.print("TOTAL: " + derivative.calculateTotal());

        View.print(derivative.toString());
        derivative.addObligation(new AccumulativeInsurance(250, "business"));

        derivative.sortobligations(new Comparator<Obligation>() {
            @Override
            public int compare(Obligation o1, Obligation o2) {
                return -o1.compareTo(o2);
            }
        });

        View.print(derivative.toString());
        View.print(derivative.findobligations("Cost", 1200, 1700));
    }

}