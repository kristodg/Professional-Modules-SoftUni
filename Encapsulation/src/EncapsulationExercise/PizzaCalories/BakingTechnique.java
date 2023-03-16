package EncapsulationExercise.PizzaCalories;

import java.util.Arrays;

public enum BakingTechnique {

    CRISPY(0.9),CHEWY(1.1)  ,HOMEMADE(1.0);

    private final double value;

    BakingTechnique(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public static boolean contains(String name){
        return Arrays.stream(BakingTechnique.values()).anyMatch(e->e.name().equals(name.toUpperCase()));
    }
}
