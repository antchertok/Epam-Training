package by.epam.task1.model;

import by.epam.task1.model.entity.Obligation;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Derivative {

    private String derivativeTitle;
    private List<Obligation> obligationList;

    public Derivative(String derivativeTitle, List obligationList) {
        this.derivativeTitle = derivativeTitle;
        this.obligationList = obligationList;
    }

    public int calculateTotal() {
        int total = 0;

        for (Obligation obligation : obligationList) {
            total += obligation.getCost();
        }

        return total;
    }

    public void sortobligations() {
        Collections.sort(obligationList);
    }

    public void sortobligations(Comparator comparator) {
        Collections.sort(obligationList, comparator);
    }

    public List<Obligation> findobligations(String parameter, int min, int max) {
        List<Obligation> result = new LinkedList<>();

        switch (parameter.toLowerCase()) {
            case "cost":
                for (Obligation obligation : obligationList) {
                    if (obligation.getCost() >= min && obligation.getCost() <= max) {
                        result.add(obligation);
                    }
                }
                break;

            case "risk":
                for (Obligation obligation : obligationList) {
                    if (obligation.getRiskLevel() >= min && obligation.getRiskLevel() <= max) {
                        result.add(obligation);
                    }
                }
                break;
        }

        return result;
    }

    public String getDerivativeTitle() {
        return derivativeTitle;
    }

    public void setDerivativeTitle(String derivativeTitle) {
        this.derivativeTitle = derivativeTitle;
    }

    public List getObligationList() {
        return obligationList;
    }

    public void setObligationList(List obligationList) {
        this.obligationList = obligationList;
    }

    public int getSize(){
        return obligationList.size();
    }

    public void addObligation(Obligation obligation){
        obligationList.add(obligation);
    }

    @Override
    public String toString(){
        return getDerivativeTitle() + ": " + obligationList.toString();
    }

}
