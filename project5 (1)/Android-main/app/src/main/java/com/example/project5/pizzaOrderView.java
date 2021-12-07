package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

/**
 * This is the pizzaOrderView class
 * @author Ryan Pollack, Michael Kang
 */
public class pizzaOrderView extends AppCompatActivity {

    Button addToOrder;
    Spinner pizzaSize;
    CheckBox chicken;
    CheckBox beef;
    CheckBox ham;
    CheckBox pineapples;
    CheckBox cheese;
    CheckBox sausage;
    CheckBox greenPepper;
    CheckBox pepperoni;
    CheckBox mushrooms;
    TextView pizzaLabel;
    ImageView pizzaImage;
    Pizza pizza;

    final int MAX_TOPPINGS = 7;

    @Override
    /**
     * This is the onCreate method
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order_view);

        addToOrder = findViewById(R.id.addToOrder);
        pizzaSize = findViewById(R.id.pizzaSize);
        chicken = findViewById(R.id.chicken);
        beef = findViewById(R.id.beef);
        ham = findViewById(R.id.ham);
        pineapples = findViewById(R.id.pineapples);
        cheese = findViewById(R.id.cheese);
        ham = findViewById(R.id.ham);
        sausage = findViewById(R.id.sausage);
        greenPepper = findViewById(R.id.greenPeppers);
        pepperoni = findViewById(R.id.pepperoni);
        mushrooms = findViewById(R.id.mushrooms);
        pizzaLabel = findViewById(R.id.pizzaLabel);
        pizzaImage = findViewById(R.id.pizzaPicture);

        Intent intent = getIntent();
        String pizzaType = intent.getExtras().get("pizza type").toString();
        pizza = PizzaMaker.createPizza(pizzaType);
        pizzaLabel.setText(pizzaType);

        addToOrder.setOnClickListener(this::addToOrder);
    }

    /**
     * This is the addToOrder method, which adds to the order
     * @param view
     */
    public void addToOrder(View view) {
        pizza.toppings.clear();
        checkToppings(pizza);
        checkSize(pizza);
        MainActivity.currentOrder.addPizza(pizza.copy());
    }

    /**
     * This is the checkToppings method, which makes sure the number of toppings is valid
     * @param pizza
     */
    private void checkToppings(Pizza pizza){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Maximum number of toppings is 7", Toast.LENGTH_SHORT);

        if (chicken.isChecked()){
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Chicken);
            else
                toast.show();
        }
        if (beef.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Beef);
            else
                toast.show();
        if (ham.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Ham);
            else
                toast.show();
        if (pineapples.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Pineapple);
            else
                toast.show();
        if (cheese.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Cheese);
            else
                toast.show();
        if (sausage.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Sausage);
            else
                toast.show();
        if (greenPepper.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.GreenPepper);
            else
                toast.show();
        if (pepperoni.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Pepperoni);
            else
                toast.show();
        if (mushrooms.isChecked())
            if (pizza.toppings.size() <= MAX_TOPPINGS)
                pizza.toppings.add(Topping.Mushroom);
            else
                toast.show();
    }

    /**
     * This is the checkSize method, which checks the size of the pizza
     * @param pizza
     */
    private void checkSize(Pizza pizza){
        if (pizzaSize.getSelectedItem().toString().equals("Small")){
            pizza.size = Size.Small;
        }
        if (pizzaSize.getSelectedItem().toString().equals("Medium")){
            pizza.size = Size.Medium;
        }
        if (pizzaSize.getSelectedItem().toString().equals("Large")){
            pizza.size = Size.Large;
        }
    }

}