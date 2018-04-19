package by.epam.task1.model.util;


import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.Insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum DerivativeMaker {
    DERIVATIVE_MAKER;

    private static final int MIN_COST = 100;

    public Derivative makeDerivative(int amountOfInsurances, int possibleCost, int possibleRisk) {
        List<Insurance> insurances = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amountOfInsurances; i++) {
            insurances.add(new var.Insurance(random.nextInt(possibleRisk),
                    random.nextInt(possibleCost) + MIN_COST, getInsuranceType()));
        }

        return new Derivative("Insurances", insurances);
    }

    private String getInsuranceType(){
        Random random = new Random();
        return InsuranceSphere.values()[random.nextInt(InsuranceSphere.values().length)].toString();
    }
}
