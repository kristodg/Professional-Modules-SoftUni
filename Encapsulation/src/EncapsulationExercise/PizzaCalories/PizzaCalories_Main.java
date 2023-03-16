package EncapsulationExercise.PizzaCalories;

import java.util.Scanner;

public class PizzaCalories_Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] pizzaInfo = scan.nextLine().split("\\s+");
        String name = pizzaInfo[1];
        int countOfToppings = Integer.parseInt(pizzaInfo[2]);

        try {
            Pizza pizza = new Pizza(name, countOfToppings);

            String[] doughInfo = scan.nextLine().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            double weight = Double.parseDouble(doughInfo[3]);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String input;

            while (!"END".equals(input=scan.nextLine())) {

                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }

            System.out.println(pizza.toString());

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
