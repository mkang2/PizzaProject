package com.example.project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the store orders class
 * @author Ryan Pollack, Michael Kang
 */
public class StoreOrders implements Serializable {
    protected ArrayList<Order> orders;

    /**
     * This is the constructor for store orders
     */
    public StoreOrders(){
        this.orders = new ArrayList<>();
    }
}
