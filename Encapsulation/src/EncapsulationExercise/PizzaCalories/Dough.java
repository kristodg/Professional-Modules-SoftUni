package EncapsulationExercise.PizzaCalories;

import java.util.Map;

public class Dough {

    private static final Map<String, Double>
            FLOUR_TYPE = Map.of("White", 1.5, "Wholegrain", 1.0);
    private static final Map<String, Double>
            BAKING_TECHNIQUE = Map.of("Crispy", 0.9, "Chewy", 1.1, "Homemade", 1.0);

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!BakingTechnique.contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType) {
        if (!FlourType.contains(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public double calculateCalories() {
        return 2 * this.weight * FlourType.valueOf(this.flourType.toUpperCase()).getValue()
                * BakingTechnique.valueOf(this.bakingTechnique.toUpperCase()).getValue();
    }
}
