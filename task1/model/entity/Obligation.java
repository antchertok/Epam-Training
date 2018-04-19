package by.epam.task1.model.entity;

public class Obligation implements Comparable{
    int riskLevel;
    int cost;
    String obligationSphere;

    public Obligation(){
        this(100, 0, "none");
    }

    public Obligation(int riskLevel, int cost, String obligationSphere) {
        this.riskLevel = riskLevel;
        this.cost = cost;
        this.obligationSphere = obligationSphere.toUpperCase().intern();
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Object o) {
        Insurance insurance = (Insurance) o;

        if (this.riskLevel > insurance.riskLevel) {
            return 1;
        }
        if (this.riskLevel < insurance.riskLevel) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode(){
        return 41 * riskLevel + 13 * cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insurance)) return false;
        Insurance insurance = (Insurance) o;
        return riskLevel == insurance.riskLevel &&
                cost == insurance.cost &&
                obligationSphere == insurance.obligationSphere;
    }

    @Override
    public String toString() {
        return "Obligation. Sphere: " + obligationSphere + ", risk level:" + riskLevel + ", cost:" + cost;
    }
}
