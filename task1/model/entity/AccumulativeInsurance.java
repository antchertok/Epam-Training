package by.epam.task1.model.entity;

import by.epam.task1.util.ExtraMoneyCalculator;

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
        return getClass().getName()+ "Accumulative insurance. Sphere: " + insuranceSphere + ", risk level:"
                + RISK_LEVEL + ", cost:" + getCost();
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

}
