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
        DatabaseHelp databaseHelp = new DatabaseHelp(this);
        EmailGlobal emailg = ((EmailGlobal)getApplicationContext());
        String emaillglobe = emailg.getUemail();
        String text = databaseHelp.searchTopp(emaillglobe.toString());
        txt.setText(text);

        /*Intent CurInt = getIntent();
        ArrayList<String> UserInformation = CurInt.getStringArrayListExtra("UserInformation");
        String UserEmail = UserInformation.get(0);*/
    }
    public void gotoPC(View view)
    {
        EmailGlobal emailg = ((EmailGlobal)getApplicationContext());
        String emaillglobe = emailg.getUemail();
        if(emaillglobe != "") {
            Intent startIntent = new Intent(getApplicationContext(), MainPage2.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        }
        else
        {
            Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        }
    }

}
