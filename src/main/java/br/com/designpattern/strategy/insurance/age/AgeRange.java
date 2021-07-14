package br.com.designpattern.strategy.insurance.age;

import java.util.Arrays;
import java.util.List;

public class AgeRange {

    private static final List<AgeRange> rangeList = Arrays.asList(
            new AgeRange(0, 18, 3),
            new AgeRange(18, 24, 3.5),
            new AgeRange(25, 29, 2),
            new AgeRange(30, 39, 2.5),
            new AgeRange(40, 0, 1.5)
    );

    private final int minAge;
    private final int maxAge;
    private final double percentRisk;

    public AgeRange(int minAge, int maxAge, double percentRisk) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.percentRisk = percentRisk;
    }

    public double getPercentRisk() {
        return percentRisk;
    }

    public static AgeRange getAgeRange(int age) {
        return rangeList.stream()
                .filter(ageRange -> ageRange.isValidRange(age))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Invalid age to define range of risk"));
    }

    private boolean isValidRange(int age) {
        if (minAge == 0 && age <= maxAge) {
            return true;
        }

        if (maxAge == 0 && age >= minAge) {
            return true;
        }

        return age >= minAge && age <= maxAge;
    }

}
