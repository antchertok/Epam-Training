package by.epam.task1.model.entity;

import java.util.Objects;

public class Insurance implements Comparable{
    int riskLevel;
    int cost;
    String insuranceSphere;

    public Insurance(){
        this(100, 0, "none");
    }

    public Insurance(int riskLevel, int cost, String insuranceSphere) {
        this.riskLevel = riskLevel;
        this.cost = cost;
        this.insuranceSphere = insuranceSphere.toUpperCase().intern();
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
                Objects.equals(insuranceSphere, insurance.insuranceSphere);
    }

    @Override
    public String toString() {
        return "Insurance. Sphere: " + insuranceSphere + ", risk level:" + riskLevel + ", cost:" + cost;
    }
}
