package com.example.project5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the order class, which holds all of the information for an order
 * @author Ryan Pollack, Michael Kang
 */
public class Order implements Serializable {
    protected ArrayList<Pizza> pizzas;
    String phoneNumber;
    double orderTotal;

    /**
     * This is the constructor for an order
     */
    public Order(){
        this.pizzas = new ArrayList<Pizza>();
        this.phoneNumber = "";
        this.orderTotal = 0;
    }

    /**
     * This it the addPizza method, which adds a pizza to the order
     * @param pizzaToAdd
     */
    public void addPizza(Pizza pizzaToAdd){
        this.pizzas.add(pizzaToAdd);
    }
}
