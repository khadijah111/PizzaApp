package com.example.khadijahsalim.pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view)
    {
        CheckBox cheeseCheckBox = (CheckBox) findViewById(R.id.more_cheese_chbox);
        boolean hasCheese = cheeseCheckBox.isChecked();

        CheckBox sauseCheckBox = (CheckBox) findViewById(R.id.more_sause_chbox);
        boolean hasSause = sauseCheckBox.isChecked();

        int totalPrice = calculate(hasCheese, hasSause);
        displayPrice(totalPrice);
    }

    private int calculate(boolean hascheese, boolean hasSause)
    {
        int basePrice = 5;

        if(hascheese == true)
        { basePrice = basePrice + 3;}

        if(hasSause ==true)
        { basePrice = basePrice + 4;}

        return qty * basePrice;
    }

    public void displayQuantity(int number)
    {
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_textview);
        quantityTextview.setText("" + number);
    }
    public void displayPrice(int number)
    {
        //total price
        TextView priceTextview = (TextView) findViewById(R.id.price_textview);
        priceTextview.setText("total is: " + number);
    }

    public void plusButton(View view)
    {
        qty = qty + 1;
        displayQuantity(qty);
    }

    public void minusButton(View view)
    {
        qty = qty -1;
        displayQuantity(qty);
    }

}
