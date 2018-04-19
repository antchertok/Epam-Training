package by.epam.task1.model.util;


import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.Insurance;
import by.epam.task1.model.entity.Obligation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum DerivativeMaker {
    DERIVATIVE_MAKER;

    private static final int MIN_COST = 100;

    public Derivative makeDerivative(int amountOfObligations, int possibleCost, int possibleRisk) {
        List<Obligation> obligations = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amountOfObligations; i++) {
            obligations.add(new Insurance(random.nextInt(possibleRisk),
                    random.nextInt(possibleCost) + MIN_COST, getObligationType()));
        }

        return new Derivative("Insurances", obligations);
    }

    private String getObligationType(){
        Random random = new Random();
        return ObligationSphere.values()[random.nextInt(ObligationSphere.values().length)].toString();
    }
}
