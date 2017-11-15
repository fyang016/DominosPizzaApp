package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn2 extends AppCompatActivity {

    DatabaseHelp help = new DatabaseHelp(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);
    }
    public void onCreateClick(View view)
    {
        EditText email = (EditText)findViewById(R.id.etEmail);
        EditText pass = (EditText)findViewById(R.id.etPassword);

        String emailst = email.getText().toString();
        String pass2st = pass.getText().toString();

        if(!validate(emailst,pass2st))
        {
            Toast error = Toast.makeText(SignIn2.this,"Password or Email do not match", Toast.LENGTH_SHORT);
            error.show();
        }
        else
        {
            LoginInfo account = new LoginInfo();
            Intent intent = new Intent(this, OrderPizza.class);
            startActivity(intent);
            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }


    }
    private boolean validate(String userEmail, String userPassword){
        /*
        check user name and password
        if((userEmail == "Admin") && (userPassword == "1234"))
        pass the username
        */

        String password = help.searchPass(userEmail);

        if(userPassword.equals(password))
        {
            return true;
            //Intent intent = new Intent(this, OrderPizza.class);
           // startActivity(intent);

        }
        return false;

        /*else
        {
            counter--;
            Info.setText("No of attmepts reamaing: " + String.valueOf(counter));
            if (counter == 0) {
                SignIn.setEnabled(false);


            }
        }*/


         }

    }
