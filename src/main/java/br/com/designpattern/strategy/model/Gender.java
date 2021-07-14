package br.com.designpattern.strategy.model;

import java.util.Arrays;

public enum Gender {

    MALE(1.5),
    FEMALE(2);

    private final double percentRisk;

    Gender(double percentRisk) {
        this.percentRisk = percentRisk;
    }

    public double getPercentRisk() {
        return percentRisk;
    }

    public static Gender valueOf(int value) {
        return Arrays.stream(values())
                .filter(gender -> gender.ordinal() == value)
                .findFirst()
                .get();
    }

}
