package com.example.project5;

/**
 * This is the pizza maker class, which is used to make pizzas
 * @author Ryan Pollack, Michael Kang
 */
public class PizzaMaker {

    /**
     * This is the createPizza method
     * @param flavor
     * @return pizza
     */
    public static Pizza createPizza(String flavor) {
        if (flavor.equals("Hawaiian")) {
            return new Hawaiian();
        }

        if (flavor.equals("Deluxe")) {
            return new Deluxe();
        }

        if (flavor.equals("Pepperoni")) {
            return new Pepperoni();
        }

        return null;
    }
}
