package by.epam.task1.util;

import by.epam.task1.model.entity.AccumulativeInsurance;

public class ExtraMoneyCalculator {

    public static int calcExtraMoney(AccumulativeInsurance aInsurance, double firstCost) {
        int yearsPassed = aInsurance.getYearsPassed();
        double multiplier = 1 + yearsPassed / 100.;

        for (int i = 0; i < yearsPassed; i++) {
            firstCost *= multiplier;
        }
        return (int) firstCost;
    }
}
