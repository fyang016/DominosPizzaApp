package com.os.operando.emptyactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Se Hoon Bang on 11/14/2017.
 */

public class OrderDetail extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
    }

    public void gotood(View view)
    {
        startActivity(new Intent(getApplicationContext(),OrderDetail.class));
    }

}
