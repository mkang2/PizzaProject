package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This is the current order view class, which shows the current order
 * @author Ryan Pollack, Michael Kang
 */
public class currentOrderView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Button remove, placeOrderButton;
    TextView phoneNumber, subtotal, salesTax, orderTotal;
    ArrayList<Pizza> pizzas;
    StoreOrders storeOrders;
    ListView listView;
    ArrayAdapter adapter;
    int selectedIndex;

    private final double TAX_RATE = 0.06625;
    private final double TOTAL_RATE = 1 + TAX_RATE;

    @Override
    /**
     * This is the on create method
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order_view);

        Intent intent = getIntent();
        pizzas = MainActivity.currentOrder.pizzas;

        storeOrders = (StoreOrders) intent.getExtras().get("store orders");

        listView = findViewById(R.id.cart);
        phoneNumber = findViewById(R.id.customerPhoneNumber);
        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        orderTotal = findViewById(R.id.orderTotal);
        remove = findViewById(R.id.button);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        remove.setOnClickListener(this::remove);

        selectedIndex = 0;
        ArrayList<String> pizzaList = new ArrayList<String>();
        for(Pizza pizza: pizzas){
            pizzaList.add(pizza.toString());
        }

        listView.setOnItemClickListener(this);
        placeOrderButton.setOnClickListener(this::placeOrder);
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, pizzaList);
        listView.setAdapter(adapter);
        // set the values of all the textviews
        subtotal.setText("" + subTotalPrice(pizzas));
        salesTax.setText("" + (subTotalPrice(pizzas) * TAX_RATE));
        orderTotal.setText("" + (subTotalPrice(pizzas) * TOTAL_RATE));
        phoneNumber.setText("Customer phone number: " + intent.getExtras().get("phone"));
    }

    /**
     * This is the remove method, which removes an order
     * @param view
     */
    public void remove(View view){
        MainActivity.currentOrder.pizzas.remove(selectedIndex);
        adapter.remove(selectedIndex);
    }

    @Override
    /**
     * This is the onItemClick method
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedIndex = position;
    }

    /**
     * This is the placeOrder method, which is used to place an order
     * @param view
     */
    public void placeOrder(View view){
        Order order = new Order();
        order.pizzas = new ArrayList<Pizza>(MainActivity.currentOrder.pizzas);
        order.phoneNumber = new String(MainActivity.currentOrder.phoneNumber);

        MainActivity.storeOrders.orders.add(order);
    }

    /**
     * This is the subTotalPrice method, which returns the subtotal price of the pizza order
     * @param pizzas
     * @return subTotal
     */
    private double subTotalPrice(ArrayList<Pizza> pizzas){
        double subTotal = 0.0;
        for (int i = 0; i < pizzas.size(); i++){
            subTotal += pizzas.get(i).price();
        }
        return subTotal;
    }
}