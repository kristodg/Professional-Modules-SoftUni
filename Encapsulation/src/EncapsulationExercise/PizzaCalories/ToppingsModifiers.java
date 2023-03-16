package EncapsulationExercise.PizzaCalories;

import java.util.Arrays;

public enum ToppingsModifiers {

    MEAT( 1.2), VEGGIES (0.8),CHEESE(1.1),SAUCE(0.9);

    private final double value;

    ToppingsModifiers(double value) {
        this.value=value;
    }

    public double getValue() {
        return value;
    }

    public static boolean contains(String name){
        return Arrays.stream(ToppingsModifiers.values()).anyMatch(e->e.name().equals(name.toUpperCase()));
    }
}
