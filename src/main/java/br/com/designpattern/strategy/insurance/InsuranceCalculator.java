package br.com.designpattern.strategy.insurance;

import br.com.designpattern.strategy.insurance.age.AgeRange;
import br.com.designpattern.strategy.model.Customer;
import br.com.designpattern.strategy.model.Gender;

public interface InsuranceCalculator {

    double calculate(Customer customer, double propertyValue);

    default double calculatePrizeValue(AgeRange ageRange, Gender gender, double propertyValue) {
        return calculateGenderRiskValue(propertyValue, gender.getPercentRisk()) +
                calculateAgeRiskValue(propertyValue, ageRange.getPercentRisk());
    }

    default double calculateGenderRiskValue(double propertyValue, double percentRisk) {
        return (propertyValue * percentRisk) / 100;
    }

    default double calculateAgeRiskValue(double propertyValue, double percentRisk) {
        return (propertyValue * percentRisk) / 100;
    }

}
