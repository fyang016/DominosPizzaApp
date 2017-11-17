package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RecentOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_orders);
        TextView txt = (TextView) findViewById(R.id.textView2);
        txt.setText("coolio this is your order");

        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        String UserEmail = UserInformation.get(0);
    }

    public void gotoPC(View view)
    {
        Intent PC_intent = new Intent(getApplicationContext(),preCheckout.class);
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle PizzaBundle =new Bundle();
        PizzaBundle.putSerializable("UserInformation", UserInformation);
        PC_intent.putExtras(PizzaBundle);
        startActivity(PC_intent);
//        Topping.add(CurTopping);
//        Bundle PizzaBundle =CurInt.getExtras();
//        PizzaBundle.remove("Pizzas");
//
//        PizzaBundle.putSerializable("Pizzas", Topping);
//        PC_intent.putExtras(PizzaBundle);
//        startActivity(PC_intent);

    }

}
