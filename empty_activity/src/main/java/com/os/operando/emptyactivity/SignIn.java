package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    DatabaseHelp help = new DatabaseHelp(this);

    private EditText Email;
    private EditText Password;
    private TextView Header;
    private TextView Comment1;
    private TextView PizzaProfile;
    private Button SignIn;
    private Button Profile;
    private Button ForgotPass;
    private CheckBox Keep;
    private TextView Info;
    private int counter = 3;


    public SignIn() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        });
    }
    private void validate(String userEmail, String userPassword){
        /*
        check user name and password
        if((userEmail == "Admin") && (userPassword == "1234"))
        pass the username
        */

        String password = help.searchPass(userEmail);

        if(userPassword.equals(password))
        {
            Intent intent = new Intent(this, OrderPizza.class);
            startActivity(intent);

        }

        else
        {
            counter--;
            Info.setText("No of attmepts reamaing: " + String.valueOf(counter));
            if (counter == 0) {
                SignIn.setEnabled(false);


            }
        }


    }
}
