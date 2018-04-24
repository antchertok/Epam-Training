package by.epam.task1.model;

import by.epam.task1.model.entity.Insurance;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Derivative {

    private String derivativeTitle;
    private List<Insurance> insuranceList;

    public Derivative(String derivativeTitle, List insuranceList) {
        this.derivativeTitle = derivativeTitle;
        this.insuranceList = insuranceList;
    }

    public int calculateTotal() {
        int total = 0;

        for (Insurance insurance : insuranceList) {
            total += insurance.getCost();
        }

        return total;
    }

    public void sortInsurances() {
        Collections.sort(insuranceList);
    }

    public void sortInsurances(Comparator comparator) {
        Collections.sort(insuranceList, comparator);
    }

    public String getDerivativeTitle() {
        return derivativeTitle;
    }

    public void setDerivativeTitle(String derivativeTitle) {
        this.derivativeTitle = derivativeTitle;
    }

    public List getInsuranceList() {
        return insuranceList;
    }

    public int getSize(){
        return insuranceList.size();
    }

    public void addInsurance(Insurance insurance){
        insuranceList.add(insurance);
    }

    @Override
    public String toString(){
        return getDerivativeTitle() + ": " + insuranceList.toString();
    }

}
