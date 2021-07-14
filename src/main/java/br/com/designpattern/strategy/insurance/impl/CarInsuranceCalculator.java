package br.com.designpattern.strategy.insurance.impl;

import br.com.designpattern.strategy.insurance.InsuranceCalculator;
import br.com.designpattern.strategy.insurance.age.AgeRange;
import br.com.designpattern.strategy.model.Customer;

public class CarInsuranceCalculator implements InsuranceCalculator {

    @Override
    public double calculate(Customer customer, double propertyValue) {
        AgeRange ageRange = AgeRange.getAgeRange(customer.getAge());
        double carFixedRateValue = 250;
        return carFixedRateValue + calculatePrizeValue(ageRange, customer.getGender(), propertyValue);
    }

}
