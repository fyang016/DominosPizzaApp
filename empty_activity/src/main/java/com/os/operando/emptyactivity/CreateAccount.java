package com.os.operando.emptyactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    DatabaseHelp databasehelp = new DatabaseHelp(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }
    public void gotoca(View view)
    {
        startActivity(new Intent(getApplicationContext(),CreateAccount.class));
    }
    public void gotomain(View view)
    {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    public void onCreateClick(View view)
    {

            EditText firstname = (EditText)findViewById(R.id.editTextFN);
            EditText lastname = (EditText)findViewById(R.id.editTextLN);
            EditText phonenumber = (EditText)findViewById(R.id.editTextPN);
            EditText email = (EditText)findViewById(R.id.editTextE);
            EditText email2 = (EditText)findViewById(R.id.editTextE2);
            EditText pass1 = (EditText)findViewById(R.id.editTextPW);
            EditText pass2 = (EditText)findViewById(R.id.editTextPW2);

            String fname = firstname.getText().toString();
            String lname = lastname.getText().toString();
            String pnstr = phonenumber.getText().toString();
            String emailst = email.getText().toString();
            String emailst2 = email2.getText().toString();
            String pass1st = pass1.getText().toString();
            String pass2st = pass2.getText().toString();
            if(fname.equals("") || lname.equals("") || pnstr.equals("") || emailst.equals("") ||
                    emailst2.equals("")||pass1st.equals("")|| pass2st.equals(""))
            {
                Toast empty = Toast.makeText(CreateAccount.this,"All fields are required", Toast.LENGTH_SHORT);
                empty.show();
            }
           else {
                if(!pass1st.equals(pass2st))
                {
                    Toast pass = Toast.makeText(CreateAccount.this, "passwords don't match", Toast.LENGTH_SHORT);
                    pass.show();
                }

                if (!emailst.equals(emailst2)) {
                    Toast mail = Toast.makeText(CreateAccount.this, "emails don't match", Toast.LENGTH_SHORT);
                    mail.show();
                } else {
                    LoginInfo account = new LoginInfo();
                    account.setPassword(pass1st);
                    account.setEmail(emailst);
                    account.setFirstName(fname);
                    account.setLastName(lname);
                    account.setPhoneNumber(pnstr);
                    databasehelp.addUsers(account);
                    databasehelp.allUsers();

                    Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(startIntent);
                    //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }

    }

}
