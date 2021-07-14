package br.com.designpattern.strategy.insurance.impl;

import br.com.designpattern.strategy.insurance.InsuranceCalculator;
import br.com.designpattern.strategy.insurance.age.AgeRange;
import br.com.designpattern.strategy.model.Customer;
import br.com.designpattern.strategy.model.Gender;

public class MotorcycleInsuranceCalculator implements InsuranceCalculator {

    @Override
    public double calculate(Customer customer, double propertyValue) {
        AgeRange ageRange = AgeRange.getAgeRange(customer.getAge());
        double motorcycleFixedRateValue = 150;
        return motorcycleFixedRateValue + calculatePrizeValue(ageRange, customer.getGender(), propertyValue);
    }

}
