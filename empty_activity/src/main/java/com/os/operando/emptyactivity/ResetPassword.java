package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ResetPassword extends AppCompatActivity {

    DatabaseHelp help = new DatabaseHelp(this);

    private EditText tFNewPassword;
    private EditText tFConfirmPassword;
    private TextView NewPassword;
    private TextView ConfirmPassword;
    private Button SavePassword;
    private TextView PassIncorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        tFNewPassword = (EditText) findViewById(R.id.tfNewPassword);
        tFConfirmPassword = (EditText) findViewById(R.id.tfConfirmPassword);
        NewPassword = (TextView) findViewById(R.id.tvComment1);
        ConfirmPassword = (TextView) findViewById(R.id.tVConfirmPassword);
        SavePassword = (Button) findViewById(R.id.btnSavePassword);
        PassIncorrect = (TextView) findViewById(R.id.tVPassIncorrect);
    }

       // ResetPassword.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
    private void checkPassword(String Password1, String Password2){

        //check if passwords are the same
        if(Password1 == Password2)

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


        }  //   validate(Email.getText().toString(), Password.getText().toString());

    }
}
