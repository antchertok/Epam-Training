package by.epam.task1.model.entity;

import by.epam.task1.util.ExtraMoneyCalculator;

import java.util.Objects;

/**
 * An instance of this class represents a single  accumulative insurance
 * Extends {@link Insurance Insurance}
 */

public class AccumulativeInsurance extends Insurance {
    private static final int RISK_LEVEL = 0;
    private int riskLevel;
    private int cost;
    private String insuranceSphere;
    private int percentsPerYear;
    private int yearsPassed;

    public AccumulativeInsurance(int cost, String type, int percentsPerYear, int yearsPassed) {
        super(RISK_LEVEL, cost, type);
        this.percentsPerYear = percentsPerYear;
        this.yearsPassed = yearsPassed;
    }

    @Override
    public String toString() {
        return getClass().getName() + "Accumulative insurance. Sphere: " + insuranceSphere 
                + ", persents per year:" + percentsPerYear + ", years passed:" 
                + yearsPassed + ", cost:" + getCost();
    }

    public int getYearsPassed() {
        return yearsPassed;
    }

    public void setYearsPassed(int years) {
        yearsPassed = years;
    }

    public int getPercentsPerYear() {
        return percentsPerYear;
    }

    @Override
    public int getCost() {
        return ExtraMoneyCalculator.calcExtraMoney(this, cost);
    }

    @Override
    public int hashCode() {
        return 17 * riskLevel + 13 * cost + 7 * percentsPerYear
                + 5 * yearsPassed + insuranceSphere.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;

        AccumulativeInsurance aInsurance = (AccumulativeInsurance) obj;
        return percentsPerYear == aInsurance.percentsPerYear
                && yearsPassed == aInsurance.yearsPassed;
    }

}
