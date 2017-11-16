package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreDetails extends AppCompatActivity {
    ImageView imageView;
    TextView tx_address,tx_phone,tx_hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        imageView = (ImageView) findViewById(R.id.store_image_details);
        tx_address = (TextView) findViewById(R.id.store_address_details);
        tx_phone = (TextView) findViewById(R.id.store_phone_details);
        tx_hours = (TextView) findViewById(R.id.store_hours_details);
        imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        tx_address.setText(getIntent().getStringExtra("address"));
        tx_phone.setText(getIntent().getStringExtra("phone"));
        tx_hours.setText(getIntent().getStringExtra("hours"));
    }

    public void gotoPC(View view)
    {
        startActivity(new Intent(getApplicationContext(),preCheckout.class));
    }
}
