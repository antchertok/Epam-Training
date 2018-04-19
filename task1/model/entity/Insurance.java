package by.epam.task1.model.entity;

public class Insurance extends Obligation {

    public Insurance(int riskLevel, int cost, String type) {
        super(riskLevel, cost, type);
    }

    @Override
    public String toString() {
        return "Insurance. Sphere: " + obligationSphere + ", risk level:"
                + riskLevel + ", cost:" + cost;
    }
}
