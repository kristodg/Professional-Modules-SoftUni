package EncapsulationExercise.PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.toppingType));
        }
        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        if (!ToppingsModifiers.contains(toppingType.toUpperCase())) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
        this.toppingType = toppingType;
    }

    public double calculateCalories() {
        return 2 * this.weight * ToppingsModifiers.valueOf(this.toppingType.toUpperCase()).getValue();
    }
}
