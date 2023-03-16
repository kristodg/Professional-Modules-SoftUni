package EncapsulationExercise.PizzaCalories;

import java.util.Arrays;

public enum FlourType {
    WHITE(1.5), WHOLEGRAIN(1.0);

    private final double value;

    FlourType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static boolean contains(String name){
        return Arrays.stream(FlourType.values()).anyMatch(e->e.name().equals(name.toUpperCase()));
    }
}
