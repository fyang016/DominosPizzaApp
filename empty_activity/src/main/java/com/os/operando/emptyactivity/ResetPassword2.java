package com.os.operando.emptyactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword2 extends AppCompatActivity {

    DatabaseHelp help = new DatabaseHelp(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password2);
    }
    public void onCreateClick(View view)
    {
        EditText tFNewPassword = (EditText) findViewById(R.id.tfNewPassword);
        EditText tFConfirmPassword = (EditText) findViewById(R.id.tfConfirmPassword);
        EditText tFEmailAddress = (EditText) findViewById(R.id.tfEmailAddress);

        String npw = tFNewPassword.getText().toString();
        String cpw = tFConfirmPassword.getText().toString();
        String eml = tFEmailAddress.getText().toString();

            if (checkPassword(npw, cpw, eml)) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast error = Toast.makeText(ResetPassword2.this, "Passwords do not match", Toast.LENGTH_SHORT);
                error.show();
            }

    }

    // ResetPassword.setOnClickListener(new View.OnClickListener() {
    //   @Override
    // public void onClick(View v) {
    private boolean checkPassword(String Password1, String Password2,String email){

        //EditText email = (EditText)findViewById(R.id.tfEmailAddress);


        //String emailst = email.getText().toString();


        //check if passwords are the same
        if(Password1.equals(Password2)){
            help.UpdatePass(email, Password2);
            return true;



        } else
        {
            return false;

        }
    }
}
