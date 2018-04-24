package by.epam.task1.util;

import by.epam.task1.model.Derivative;
import by.epam.task1.model.entity.Insurance;

import java.util.LinkedList;
import java.util.List;

public class InsuranceFinder {

    public List<Insurance> findInsurancesWithRisk(Derivative derivative, int min, int max) {
        List<Insurance> result = new LinkedList<>();
        List<Insurance> insuranceList = derivative.getInsuranceList();

        for (Insurance insurance : insuranceList) {
            if (insurance.getCost() >= min && insurance.getCost() <= max) {
                result.add(insurance);
            }
        }

        return result;
    }

    public List<Insurance> findInsurancesWithCost(Derivative derivative, int min, int max) {
        List<Insurance> result = new LinkedList<>();
        List<Insurance> insuranceList = derivative.getInsuranceList();

        for (Insurance insurance : insuranceList) {
            if (insurance.getCost() >= min && insurance.getCost() <= max) {
                result.add(insurance);
            }
        }

        return result;
    }
}
