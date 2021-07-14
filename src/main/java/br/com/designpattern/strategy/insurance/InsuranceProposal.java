package br.com.designpattern.strategy.insurance;

import br.com.designpattern.strategy.model.Customer;

import java.util.UUID;

public class InsuranceProposal {

    private final Customer customer;
    private final InsuranceCalculator insuranceCalculator;
    private final double propertyValue;

    public InsuranceProposal(Customer customer, InsuranceCalculator insuranceCalculator, double propertyValue) {
        this.customer = customer;
        this.insuranceCalculator = insuranceCalculator;
        this.propertyValue = propertyValue;
    }

    public String generate() {
        String proposal = "Proposal: " + UUID.randomUUID() + "\n" +
                "Customer: " + customer.getName() + "\n" +
                "Age: " + customer.getAge() + "\n" +
                "Insurance Proposal: R$ " + insuranceCalculator.calculate(customer, propertyValue);
        return proposal;
    }

}
