package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class preCheckout extends AppCompatActivity {

    ArrayList<String> TotalOrder = null;


    Map<String, Integer> items = new HashMap<String,Integer>() {
        {/*
            put(200,"Hand Tossed - Small (10\")");
            put(300,"Hand Tossed - Medium (12\")");
            put(400,"Hand Tossed - Large (14\")");
            put(200,"Handmade Pan - Small (10\")");
            put(300,"Handmade Pan - Medium (12\")");
            put(400,"Handmade Pan - Large (14\")");
            put(200,"Crunchy Thin Crust - Small(10\')");
            put(300,"Crunchy Thin Crust - Medium(12\')");
            put(400,"Crunchy Thin Crust - Large(14\')");
            put(300,"Brooklyn Style - Small (10\")");
            put(400,"Brooklyn Style - Medium (12\")");
            put(500,"Brooklyn Style - Large (14\")");
            put(400,"Gluten Free Crust -Small (10\')");
            put(500,"Gluten Free Crust -Medium (12\')");
            put(600,"Gluten Free Crust -Large (14\')");
            */


            put("Hand Tossed - Small (10\")", 200);
            put("Hand Tossed - Medium (12\")",300);
            put("Hand Tossed - Large (14\")", 400);
            put("Handmade Pan - Small (10\")", 200);
            put("Handmade Pan - Medium (12\")",300);
            put("Handmade Pan - Large (14\")",400);
            put("Crunchy Thin Crust - Small(10\')",200);
            put("Crunchy Thin Crust - Medium(12\')",300);
            put("Crunchy Thin Crust - Large(14\')", 400);
            put("Brooklyn Style - Small (10\")", 300);
            put("Brooklyn Style - Medium (12\")",400);
            put("Brooklyn Style - Large (14\")",500);
            put("Gluten Free Crust -Small (10\')",400);
            put("Gluten Free Crust -Medium (12\')",500);
            put("Gluten Free Crust -Large (14\')",600);


        }};
    Map<String, Integer> items3 = new HashMap<String, Integer>(){
        {
            put("No Garlic-Seasoned Crust", 0);
            put("Garlic-Seasoned Crust",50);
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_checkout);
        Intent CurInt = getIntent();
        ArrayList<String> Pizzas = CurInt.getStringArrayListExtra("Pizzas");
        if(Pizzas != null) {
            TotalOrder = Pizzas;
            Integer TotalPrice = 0;
            for(int i = 0; i < Pizzas.size(); i++) {
                String Full_Order = Pizzas.get(i);
                Button OrderList = (Button) findViewById(R.id.Order);
                //how to print out order onto button uncomment
                //OrderList.setText(Full_Order);


                //Parsing Method
                String[] ParsedOrder = Full_Order.split(",");
                for(String Part : ParsedOrder)
                {
                    Part = Part.trim();
                    if(Part.contains("Light" ))
                    {
                        TotalPrice = TotalPrice+25;
                    }
                    else if(Part.contains("Normal"))
                    {
                        TotalPrice = TotalPrice+50;
                    }
                    else if(Part.contains("Extra"))
                    {
                        TotalPrice = TotalPrice+75;
                    }
                    else if(Part.contains("Double"))
                    {
                        TotalPrice = TotalPrice+100;
                    }
                    else if(items.containsKey(Part))
                    {
                        TotalPrice = TotalPrice+items.get(Part);
                    }
                    else if(items3.containsKey(Part))
                    {
                        TotalPrice = TotalPrice+items3.get(Part);
                    }
                }

                // FOR TESTING CHECKING IF ORDER SIZE GOES UP
                OrderList.setText( "Order SIZE:"+ Integer.toString(Pizzas.size()));
            }
            Integer  Dollar = TotalPrice / 100;
            Integer LeftOver = TotalPrice % 100;
            TextView FoodBev = (TextView)findViewById(R.id.textView6);
            FoodBev.setText("Food/Bev: " +  Integer.toString(Dollar)+"."+Integer.toString(LeftOver));

            TextView Tax = (TextView)findViewById(R.id.textView7);
            Integer TaxInt = (Integer)(int) ((double)((int)TotalPrice )* .10);
            Dollar = TaxInt / 100;
            LeftOver = TaxInt % 100;
            Tax.setText("Tax: " +  Integer.toString(Dollar)+"."+Integer.toString(LeftOver));

            TotalPrice = TotalPrice + TaxInt;
            Dollar = TotalPrice / 100;
            LeftOver = TotalPrice % 100;
            TextView Total = (TextView)findViewById(R.id.textView8);
            Total.setText("Total: " +  Integer.toString(Dollar)+"."+Integer.toString(LeftOver));

        }
        else
        {
            Button OrderList = (Button)findViewById(R.id.Order);
            OrderList.setText("None");
            TextView FoodBev = (TextView)findViewById(R.id.textView6);
            FoodBev.setText("Food/Bev: $0.00");
            TextView Tax = (TextView)findViewById(R.id.textView7);
            Tax.setText("Tax: $0.00");
            TextView Total = (TextView)findViewById(R.id.textView8);
            Total.setText("Total: $0.00");
        }

        //TextView 6 = FOOD/Bev     7 = TAX         8 = TOTAL

    }

    public void gototc(View view)
    {
        Intent TC_intent = new Intent(getApplicationContext(),ToppingChoice.class);
        Bundle PizzaBundle =new Bundle();
        PizzaBundle.putSerializable("Pizzas", TotalOrder);
        TC_intent.putExtras(PizzaBundle);
        startActivity(TC_intent);
        //startActivity(new Intent(getApplicationContext(),ToppingChoice.class));
    }


    public void gotoPC(View view)
    {
        startActivity(new Intent(getApplicationContext(),preCheckout.class));
    }
}
