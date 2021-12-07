package com.example.project5;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This is the Hawaiian pizza class
 * @author Ryan Pollack, Michael Kang
 */

public class Hawaiian extends Pizza{
    private static final double DEFAULT_PRICE = 10.99;
    private static final int ESSENTIAL_TOPPINGS = 2;

    /**
     * This is the default constructor for hawaiian pizza
     */
    public Hawaiian(){
        this.toppings = new ArrayList<Topping>();
        this.size = Size.Small;
    }

    /**
     * This is the constructor for hawaiian pizza
     * @param toppings
     * @param size
     */
    public Hawaiian(ArrayList<Topping> toppings, Size size){
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
        if(numToppings > 2){
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

        StringBuilder sb = new StringBuilder("Hawaiian pizza, ");

        for(Topping topping: toppings){
            sb.append(topping + ", ");
        }

        sb.append(money_Format.format(this.price()));
        return sb.toString();
    }

    @Override
    /**
     * This is the copy method, which creates a copy of a pizza
     * @retun clone
     */
    public Pizza copy() {
        Pizza clone = new Hawaiian(new ArrayList<Topping>(this.toppings), this.size);
        return clone;
    }
}
