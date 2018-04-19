package by.epam.task1.model.entity;

public class AccumulativeInsurance extends Obligation {

    private static final int RISK_LEVEL = 0;

    public AccumulativeInsurance(int cost, String type) {
        super(RISK_LEVEL, cost, type);
    }

    @Override
    public String toString() {
        return "Accumulative insurance. Sphere: " + obligationSphere + ", risk level:"
                + RISK_LEVEL + ", cost:" + cost;
    }
}
