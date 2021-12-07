package com.example.project5;

import java.util.ArrayList;

/**
 * Pizza class
 * @author Ryan Pollack, Michael Kang
 */
public abstract class Pizza {
    public static final double MEDIUM_UPCHARGE = 2.00;
    public static final double LARGE_UPCHARGE = 4.00;
    public static final double EXTRA_TOPPINGS_CHARGE = 1.49;
    public static final int NUM_DECIMAL_PLACES = 2;
    public static final int NUM_INT_PLACES = 1;

    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    /**
     * This is the price method, which return the price
     * @return price
     */
    public abstract double price();

    /**
     * This is the copy method, which creates a copy of a pizza
     * @return copy
     */
    public abstract Pizza copy();
}
