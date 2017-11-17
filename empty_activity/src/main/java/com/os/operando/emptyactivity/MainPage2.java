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

import java.util.ArrayList;

public class MainPage2 extends Activity {

    ImageButton androidImageButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_page2);
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), CreateAccount.class);
        S2intent.putExtras(UserBundle);
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
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), CreateAccount.class);
        S2intent.putExtras(UserBundle);
        startActivity(S2intent);

//        startActivity(new Intent(getApplicationContext(),CreateAccount.class));
    }

    public void gotoSignIn2(View view)
    {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), SignIn2.class);
        S2intent.putExtras(UserBundle);
        startActivity(S2intent);
//        startActivity(new Intent(getApplicationContext(),SignIn2.class));
    }

    public void gototc(View view)
    {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), ToppingChoice.class);
        S2intent.putExtras(UserBundle);
        startActivity(S2intent);
//        startActivity(new Intent(getApplicationContext(),ToppingChoice.class));
    }

    public void gotosl(View view) {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), StoreList.class);
        S2intent.putExtras(UserBundle);
        startActivity(S2intent);
//        startActivity(new Intent(getApplicationContext(), StoreList.class));
    }
    public void gotoLocation(View view)
    {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), Location.class);
        S2intent.putExtras(UserBundle);
        startActivity(S2intent);
//        startActivity(new Intent(getApplicationContext(),Location.class));
    }
    public void gotoRecentOrders(View view)
    {
        Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        Bundle UserBundle =new Bundle();
        UserBundle.putSerializable("UserInformation", UserInformation);
        Intent S2intent = new Intent(getApplicationContext(), RecentOrders.class);
        S2intent.putExtras(UserBundle);
        startActivity(S2intent);
//        startActivity(new Intent(getApplicationContext(),RecentOrders.class));
    }
}
