package com.os.operando.emptyactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ImageButton androidImageButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        EmailGlobal emailg = ((EmailGlobal)getApplicationContext());
        emailg.setUemail("");
        /*
        androidImageButton = (ImageButton) findViewById(R.id.image_button_android);

        androidImageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count++;
                Toast.makeText(MainActivity.this, "It works! " + count, Toast.LENGTH_LONG).show();
                Intent intentLoadNewActivity = new Intent(MainActivity.this, OrderPizza.class);
                startActivity(intentLoadNewActivity);
            }
        });
        */
    }

    /*
    public void onClick(View view) {
        count++;
        TextView txt = (TextView) findViewById(R.id.text1);
        txt.setText("You tapped " + count + " time(s).");
    }
    */

    // Create a new account/profile
    public void gotoca(View view)
    {
        startActivity(new Intent(getApplicationContext(),CreateAccount.class));
    }

    public void gotoDeliveryMaps(View view)
    {
        startActivity(new Intent(getApplicationContext(),DeliveryMaps.class));
    }

    public void gotoSignIn2(View view)
    {
        startActivity(new Intent(getApplicationContext(),SignIn2.class));
    }

    public void gototc(View view)
    {
        startActivity(new Intent(getApplicationContext(),ToppingChoice.class));
    }
    public void gotoro(View view)
    {
        startActivity(new Intent(getApplicationContext(),RecentOrders.class));
    }
    public void gotosl(View view) {
        startActivity(new Intent(getApplicationContext(), StoreList.class));
    }
    public void gotoLocation(View view)
    {
        startActivity(new Intent(getApplicationContext(),Location.class));
    }
    public void gotoRecentOrders(View view)
    {
        startActivity(new Intent(getApplicationContext(),RecentOrders.class));
    }
}
