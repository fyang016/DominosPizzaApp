package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderPizza extends AppCompatActivity {

    String orderTypes2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);

        Intent CurInt = getIntent();
        String orderTypes1 = CurInt.getStringExtra("orderType");
        String pH = new String("delivery");
        View trackButton = findViewById(R.id.trackbutton);
        if(orderTypes1 != null && !orderTypes1.equals(pH)) {
            trackButton.setVisibility(View.GONE);
        }

        orderTypes2 = orderTypes1;
    }

    public void gotoTracking(View view)
    {


        Intent intent = new Intent(getApplicationContext(), Tracking.class);
        intent.putExtra("orderType",orderTypes2);
        startActivity(intent);
    }
}
