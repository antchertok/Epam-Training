package by.epam.task1.model.entity;

import java.util.Objects;

/**
 * An instance of this class represents a single insurance 
 */
public class Insurance implements Comparable{
    private int riskLevel;
    private int cost;
    private String insuranceSphere;

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
    public int hashCode() {
        return 41 * riskLevel + 13 * cost + insuranceSphere.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return false;

        Insurance insurance = (Insurance) obj;
        return riskLevel == insurance.riskLevel
                && cost == insurance.cost
                && insuranceSphere.equals(insurance.insuranceSphere);
    }

    @Override
    public String toString() {
        return "Insurance. Sphere: " + insuranceSphere + ", risk level:" + riskLevel + ", cost:" + cost;
    }
}
