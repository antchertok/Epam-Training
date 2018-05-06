package by.epam.task1.util;

import by.epam.task1.model.Derivative;
import by.epam.task1.model.InsuranceSphere;
import by.epam.task1.model.entity.Insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class DerivativeMaker {
    private static final int MIN_COST = 100;

    /**
     * Makes derivative for testing business-logic
     *
     * @param amountOfInsurances how many insurances should has derivative
     * @param possibleCost how expensive each insurance can be
     * @param possibleRisk how risky each insurance can be
     * @return created derivative
     */
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
