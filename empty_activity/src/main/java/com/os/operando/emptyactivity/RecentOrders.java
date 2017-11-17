package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

}
