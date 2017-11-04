package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String txt = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.editTextE);
        DatabaseHelp dbs = new DatabaseHelp(this);

        /*dbs.addUsers(new LoginInfo("kjue001", "1235"));

        List<LoginInfo> logininfo = dbs.allUsers();

        for(LoginInfo l: logininfo)
        {
            String log = "Email " + l.getEmail() + "Password " + l.getPassword() + "\n";
            txt = txt +log;
        }*/
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
