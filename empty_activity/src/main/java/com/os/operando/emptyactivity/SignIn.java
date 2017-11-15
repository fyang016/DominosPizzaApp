package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    //DatabaseHelp help = new DatabaseHelp(this);

    /*private EditText Email;
    private EditText Password;
    private TextView Header;
    private TextView Comment1;
    private TextView PizzaProfile;
    private Button SignIn;
    private Button Profile;
    private Button ForgotPass;
    private CheckBox Keep;
    private TextView Info;
    private int counter = 3;*/


    //public SignIn() {
    //}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Header = (TextView)findViewById(R.id.tvHeader);
        Comment1 = (TextView)findViewById(R.id.tvComment1);
        PizzaProfile = (TextView)findViewById(R.id.tvPizzaProfile);
        SignIn = (Button)findViewById(R.id.btnSignIn);
        Profile = (Button)findViewById(R.id.btnProfile);
        ForgotPass = (Button)findViewById(R.id.btnForgotPass);
        Keep = (CheckBox)findViewById(R.id.cbKeep);
        Info = (TextView)findViewById(R.id.tvInfo);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());

            }
        });*/
    }
   /* public void onCreateClick(View view)
    {
        EditText email = (EditText)findViewById(R.id.etEmail);
        EditText pass = (EditText)findViewById(R.id.etPassword);

        String emailst = email.getText().toString();
        String pass2st = pass.getText().toString();

        if(!validate(emailst,pass2st))
        {
            Toast error = Toast.makeText(SignIn.this,"Password or Email do not match", Toast.LENGTH_SHORT);
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

        /*String password = help.searchPass(userEmail);

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


   // }

