package com.example.project5;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This is the pepperoni pizza class
 * @author Ryan Pollack, Michael Kang
 */
public class Pepperoni extends Pizza{
    private static final double DEFAULT_PRICE = 8.99;
    private static final double ESSENTIAL_TOPPINGS = 1;

    /**
     * This is the default constructor for a pepperoni pizza
     */
    public Pepperoni(){
        this.toppings = new ArrayList<Topping>();
        this.size = Size.Small;
    }

    /**
     * This is the constructor for a pepperoni pizza
     * @param toppings
     * @param size
     */
    public Pepperoni(ArrayList<Topping> toppings, Size size){
        this.toppings = toppings;
        this.size = size;
    }

    @Override
    /**
     * This is the price method, which returns the price
     * @return totalPrice
     */
    public double price(){
        double totalPrice = DEFAULT_PRICE;
        int numToppings = this.toppings.size();

        // accounting for pizza size
        if(this.size == Size.Medium){
            totalPrice += MEDIUM_UPCHARGE;
        }else if(this.size == Size.Large){
            totalPrice += LARGE_UPCHARGE;
        }

        // accounting for number of toppings
        if(numToppings > 1){
            totalPrice += EXTRA_TOPPINGS_CHARGE * (numToppings - ESSENTIAL_TOPPINGS);
        }

        return totalPrice;
    }

    /**
     * This is the toString method, which returns the pizza as a string
     * @return sb
     */
    @Override
    public String toString() {
        // setting formatter to print to two decimal places
        DecimalFormat money_Format = new DecimalFormat("###,###.00");
        money_Format.setMinimumFractionDigits(NUM_DECIMAL_PLACES);
        money_Format.setMinimumIntegerDigits(NUM_INT_PLACES);

        StringBuilder sb = new StringBuilder("Pepperoni pizza, ");

        for(Topping topping: toppings){
            sb.append(topping + ", ");
        }

        sb.append(money_Format.format(this.price()));
        return sb.toString();
    }

    /**
     * This is the copy method, which makes a copy of a pizza
     * @return clone
     */
    @Override
    public Pizza copy() {
        Pizza clone = new Pepperoni(new ArrayList<Topping>(this.toppings), this.size);
        return clone;
    }
}
