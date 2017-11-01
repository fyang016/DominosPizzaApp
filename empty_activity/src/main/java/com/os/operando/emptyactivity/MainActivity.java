package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        count++;
        TextView txt = (TextView) findViewById(R.id.text1);
        txt.setText("You tapped " + count + " time(s).");
    }
    public void gotoca(View view)
    {
        startActivity(new Intent(getApplicationContext(),CreateAccount.class));
    }
}
