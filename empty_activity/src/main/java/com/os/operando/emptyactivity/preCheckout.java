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
    boolean ApplyCoupon = true;
    Map<String, Integer> items = new HashMap<String,Integer>() {
        {
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

        String StringPizza = "";
        Intent CurInt = getIntent();
        ArrayList<String> Pizzas = CurInt.getStringArrayListExtra("Pizzas");
        ArrayList<String> CouponUsed = null;
        ArrayList<String> CouponFive = CurInt.getStringArrayListExtra("MinusFive");
        if(Pizzas != null) {
            TotalOrder = Pizzas;
            Integer TotalPrice = 0;
            Integer ItemPrice = 0;
            for(int i = 0; i < Pizzas.size(); i++)
            {
                String Full_Order = Pizzas.get(i);
                Button OrderList = (Button) findViewById(R.id.Order);
                //how to print out order onto button uncomment
                //OrderList.setText(Full_Order);


                //Parsing Method
                String[] ParsedOrder = Full_Order.split(",");
                StringPizza = StringPizza + ParsedOrder[0];
                for(String Part : ParsedOrder)
                {
                    Part = Part.trim();
                    if(Part.contains("Light" ))
                    {
                        ItemPrice = ItemPrice+25;
                    }
                    else if(Part.contains("Normal"))
                    {
                        ItemPrice = ItemPrice+50;
                    }
                    else if(Part.contains("Extra"))
                    {
                        ItemPrice = ItemPrice+75;
                    }
                    else if(Part.contains("Double"))
                    {
                        ItemPrice = ItemPrice+100;
                    }
                    else if(items.containsKey(Part))
                    {
                        ItemPrice = ItemPrice+items.get(Part);
                    }
                    else if(items3.containsKey(Part))
                    {
                        ItemPrice = ItemPrice+items3.get(Part);
                    }
                    else if(Part.contains("Quantity"))
                    {
                        String[] temp = Part.split(":");
                        ArrayList<String> Fifty = CurInt.getStringArrayListExtra("Fifty");

                        if(ApplyCoupon && Fifty != null && CouponUsed == null )
                        {

                            CouponUsed = new ArrayList<String>();
                            CouponUsed.add("USED");

                            Integer SinglePrice = ItemPrice/2;
                            ItemPrice = ItemPrice * (Integer.parseInt(temp[1]) - 1 );
                            ItemPrice = ItemPrice + SinglePrice;
                            ApplyCoupon = false;
                        }
                        else
                        {
                            ItemPrice = ItemPrice * Integer.parseInt(temp[1]);
                        }


                    }

                }
                TotalPrice = TotalPrice + ItemPrice;
                ItemPrice = 0;

                // FOR TESTING CHECKING IF ORDER SIZE GOES UP
//                ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
//                OrderList.setText( UserInformation.get(0));
//                OrderList.setText( "Order SIZE:"+ Integer.toString(Pizzas.size()));
                OrderList.setText( StringPizza);
            }
            //COUPON~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//            CurInt = getIntent();

            if(ApplyCoupon && CouponFive != null && TotalPrice > 750 && CouponUsed == null)
            {
                TotalPrice = TotalPrice - 500;
                ApplyCoupon = false;
            }


            Integer  Dollar = TotalPrice / 100;
            Integer LeftOver = TotalPrice % 100;
            TextView FoodBev = (TextView)findViewById(R.id.textView6);
            String Holder = "";
            if(LeftOver < 10)
            {
                Holder = "0";
            }
            FoodBev.setText("Food/Bev: $" +  Integer.toString(Dollar)+"."+Holder + Integer.toString(LeftOver));

            TextView Tax = (TextView)findViewById(R.id.textView7);
            Integer TaxInt = (Integer)(int) ((double)((int)TotalPrice )* .10);
            Dollar = TaxInt / 100;
            LeftOver = TaxInt % 100;
            Holder = "";
            if(LeftOver < 10)
            {
                Holder = "0";
            }
            Tax.setText("Tax: $" +  Integer.toString(Dollar)+"."+Holder+Integer.toString(LeftOver));

            TotalPrice = TotalPrice + TaxInt;
            Dollar = TotalPrice / 100;
            LeftOver = TotalPrice % 100;
            TextView Total = (TextView)findViewById(R.id.textView8);
            Holder = "";
            if(LeftOver < 10)
            {
                Holder = "0";
            }
            Total.setText("Total: $" +  Integer.toString(Dollar)+"."+Holder+Integer.toString(LeftOver));

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
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        ArrayList<String>  CouponUsed =  CurInt.getStringArrayListExtra("CouponUsed");
        ArrayList<String> Minus = CurInt.getStringArrayListExtra("MinusFive");
        ArrayList<String> Percent = CurInt.getStringArrayListExtra("Fifty");
        if(!ApplyCoupon)
        {
            if(CouponUsed == null)
            {
                CouponUsed = new ArrayList<String>();
            }
            CouponUsed.add("Used");
        }
        Intent TC_intent = new Intent(getApplicationContext(),ToppingChoice.class);
        Bundle PizzaBundle =new Bundle();
        PizzaBundle.putSerializable("Pizzas", TotalOrder);
        PizzaBundle.putSerializable("UserInformation", UserInformation);
        PizzaBundle.putSerializable("CouponUsed", CouponUsed);
        PizzaBundle.putSerializable("Fifty", Percent);
        PizzaBundle.putSerializable("MinusFive", Minus);
        TC_intent.putExtras(PizzaBundle);
        startActivity(TC_intent);
        //startActivity(new Intent(getApplicationContext(),ToppingChoice.class));
    }

    public void gotoCoupons(View view)
    {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        ArrayList<String>  CouponUsed =  CurInt.getStringArrayListExtra("CouponUsed");
        if(!ApplyCoupon)
        {
            if(CouponUsed == null)
            {
                CouponUsed = new ArrayList<String>();
            }
            CouponUsed.add("Used");
        }


        Intent Coupon_intent = new Intent(getApplicationContext(),Coupons.class);
        Bundle CouponBundle =new Bundle();
        CouponBundle.putSerializable("Pizzas", TotalOrder);
        CouponBundle.putSerializable("UserInformation", UserInformation);
        CouponBundle.putSerializable("CouponUsed", CouponUsed);
        Coupon_intent.putExtras(CouponBundle);
        startActivity(Coupon_intent);

    }
    public void gotoTrack(View view)
    {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        ArrayList<String>  CouponUsed =  CurInt.getStringArrayListExtra("CouponUsed");
//        if(!ApplyCoupon)
//        {
//                if(CouponUsed == null)
//                {
//                    CouponUsed = new ArrayList<String>();
//                }
//            CouponUsed.add("Used");
//        }
        Bundle PurchaseBundle = new Bundle();
        PurchaseBundle.putSerializable("Pizzas", TotalOrder);
        PurchaseBundle.putSerializable("UserInformation", UserInformation);
        PurchaseBundle.putSerializable("CouponUsed", CouponUsed);

        Intent Purchase_intent = new Intent(getApplicationContext(),Tracking.class);
//        Purchase_intent.putExtras(PurchaseBundle);
        startActivity(Purchase_intent);
    }

    public void gotoOrderPizza(View view)
    {
        Intent CurInt = getIntent();
        String orderType = CurInt.getStringExtra("orderType");
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        ArrayList<String>  CouponUsed =  CurInt.getStringArrayListExtra("CouponUsed");
//        if(!ApplyCoupon)
//        {
//                if(CouponUsed == null)
//                {
//                    CouponUsed = new ArrayList<String>();
//                }
//            CouponUsed.add("Used");
//        }
        Bundle PurchaseBundle = new Bundle();
        PurchaseBundle.putSerializable("Pizzas", TotalOrder);
        PurchaseBundle.putSerializable("UserInformation", UserInformation);
        PurchaseBundle.putSerializable("CouponUsed", CouponUsed);

        Intent Purchase_intent = new Intent(getApplicationContext(),OrderPizza.class);
        Purchase_intent.putExtra("orderType", orderType);
//        Purchase_intent.putExtras(PurchaseBundle);
        startActivity(Purchase_intent);
    }
    public void gotorecent(View view){
        startActivity(new Intent(getApplicationContext(),MainPage2.class));
    }


}
