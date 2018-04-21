package by.epam.task1.model.entity;

public class AccumulativeInsurance extends Insurance {
    private static final int RISK_LEVEL = 0;
    private int percentsPerYear;
    private int yearsPassed;

    public AccumulativeInsurance(int cost, String type, int percentsPerYear, int yearsPassed) {
        super(RISK_LEVEL, cost, type);
        this.percentsPerYear = percentsPerYear;
        this.yearsPassed = yearsPassed;
    }

    @Override
    public String toString() {
        return "Accumulative insurance. Sphere: " + insuranceSphere + ", risk level:"
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
        return calcExtraMoney();
    }

    private int calcExtraMoney() {
        double formerCost = cost;
        double multiplier = 1 + yearsPassed / 100.;

        for (int i = 0; i < yearsPassed; i++) {
            formerCost *= multiplier;
        }
        return (int) formerCost;
    }
}
