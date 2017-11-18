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


public class ResetPassword extends AppCompatActivity {

    DatabaseHelp help = new DatabaseHelp(this);


    /*private EditText tFNewPassword;

    private EditText tFConfirmPassword;
    private TextView NewPassword;
    private TextView ConfirmPassword;
    private Button SavePassword;
    private TextView PassIncorrect;
    private TextView EmailAddress;

    private EditText tFEmailAddress;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        //NewPassword = (TextView) findViewById(R.id.tvComment1);
        //ConfirmPassword = (TextView) findViewById(R.id.tVConfirmPassword);
        //SavePassword = (Button) findViewById(R.id.btnSavePassword);
       // PassIncorrect = (TextView) findViewById(R.id.tVPassIncorrect);
       // EmailAddress = (TextView) findViewById(R.id.tVEmailAddress);

    }
    public void onCreateClick(View view)
    {
        EditText tFNewPassword = (EditText) findViewById(R.id.tfNewPassword);
        EditText tFConfirmPassword = (EditText) findViewById(R.id.tfConfirmPassword);
        EditText tFEmailAddress = (EditText) findViewById(R.id.tfEmailAddress);

        String npw = tFNewPassword.getText().toString();
        String cpw = tFConfirmPassword.getText().toString();
        String eml = tFEmailAddress.getText().toString();
       /*if(help.emailExist(eml)) {
            if (checkPassword(npw, cpw, eml)) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast error = Toast.makeText(ResetPassword.this, "Passwords do not match", Toast.LENGTH_SHORT);
                error.show();
            }
        }
        else
        {
            Toast error = Toast.makeText(ResetPassword.this,"Email does not exist, Please create an account",Toast.LENGTH_SHORT );
            error.show();
        }*/

    }

       // ResetPassword.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {

    private boolean checkPassword(String Password1, String Password2,String email){

        //EditText email = (EditText)findViewById(R.id.tfEmailAddress);


        //String emailst = email.getText().toString();



        //check if passwords are the same
        if(Password1 == Password2){

            help.UpdatePass(email, Password2);
            return true;



        } else
            {
                return false;


            }
    }
}
