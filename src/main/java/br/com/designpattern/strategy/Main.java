package br.com.designpattern.strategy;

import br.com.designpattern.strategy.insurance.InsuranceCalculator;
import br.com.designpattern.strategy.insurance.InsuranceProposal;
import br.com.designpattern.strategy.insurance.impl.CarInsuranceCalculator;
import br.com.designpattern.strategy.insurance.impl.MotorcycleInsuranceCalculator;
import br.com.designpattern.strategy.model.Customer;
import br.com.designpattern.strategy.model.Gender;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nInform customer name: ");
        String customerName = sc.nextLine();
        System.out.println("\nInform customer age: ");
        int customerAge = Integer.parseInt(sc.nextLine());
        System.out.println("\nInform customer gender (0) Male (1) Female: ");
        Gender customerGender = Gender.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.println("\nInform vehicle type (0) Car (1) Motorcycle: ");
        VehicleType vehicleType = VehicleType.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.println("\nInform vehicle value: ");
        double propertyValue = Double.parseDouble(sc.nextLine());

        Customer customer = new Customer(customerName, customerAge, customerGender);
        InsuranceProposal proposal = new InsuranceProposal(customer, vehicleType.getCalculator(), propertyValue);

        System.out.println();
        System.out.println(proposal.generate());
    }

    public enum VehicleType {
        CAR {
            @Override
            InsuranceCalculator getCalculator() {
                return new CarInsuranceCalculator();
            }
        },
        MOTORCYCLE {
            @Override
            InsuranceCalculator getCalculator() {
                return new MotorcycleInsuranceCalculator();
            }
        };

        public static VehicleType valueOf(int value) {
            return Arrays.stream(values())
                    .filter(vehicleType -> vehicleType.ordinal() == value)
                    .findFirst()
                    .get();
        }

        abstract InsuranceCalculator getCalculator();
    }

}
