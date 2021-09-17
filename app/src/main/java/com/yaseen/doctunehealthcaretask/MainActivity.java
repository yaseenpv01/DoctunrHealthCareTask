package com.yaseen.doctunehealthcaretask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText userpassword;
    AppCompatButton btnsubmit;
    TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.user_name);
        userpassword=findViewById(R.id.passworduser);
        btnsubmit=findViewById(R.id.btnlogin);
        createAccount=findViewById(R.id.createaccount);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpPage.class);
            }
        });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attmptLogin();
            }
        });




    }

    private void attmptLogin() {

        username.setError(null);
        userpassword.setError(null);

        String usernamestring=username.getText().toString();
        String userpassstring=userpassword.getText().toString();

        boolean cancel=false;
        View focusView=null;

        if (!TextUtils.isEmpty(userpassstring) && !PasswordValid(userpassstring)){

            userpassword.setError(getString(R.string.error_invalid_password));
            focusView=userpassword;
            cancel=true;

        }

        if (!TextUtils.isEmpty(usernamestring) && !UserNameValid(usernamestring)){
            username.setError(getString(R.string.error_invalid_username));
            focusView=username;
            cancel=true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            startHomeActivity();

        }
    }

    private void startHomeActivity() {

        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean UserNameValid(String usernamestring) {

        return usernamestring.contains("@");



    }

    private boolean PasswordValid(String userpassstring) {

        return userpassstring.length()>4;


    }
}