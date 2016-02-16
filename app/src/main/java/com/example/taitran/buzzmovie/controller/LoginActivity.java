package com.example.taitran.buzzmovie.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;
import android.content.Intent;

import com.example.taitran.buzzmovie.model.User;
import com.example.taitran.buzzmovie.model.UserAuthentication;
import com.example.taitran.buzzmovie.model.UserManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginButtonPressed(View v) {
<<<<<<< HEAD
            Intent intent = new Intent(this, EditPasswordActivity.class);
            startActivity(intent);
        }
        /*
=======
>>>>>>> origin/change-password
        Log.d("Login Activity", "Login button pressed");
        UserAuthentication user = new UserManager();
        EditText username = (EditText) findViewById(R.id.userName);
        EditText password = (EditText) findViewById(R.id.Pass);
        CharSequence text;

        text = "Login Success";

        try {
            user.loginRequest(username.getText().toString(), password.getText().toString());
            Intent dashboard = new Intent(this, Dashboard.class);
            startActivity(dashboard);
        } catch (IllegalArgumentException e) {
            text = e.getMessage();
            //this is where you would increment an attempted login
            //if the message is "incorrect password"
            //see UserManager -> loginRequest for more
        }
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast message = Toast.makeText(context, text, duration);
        message.show();
    }


    public void cancelButtonPressed(View V) {
        Log.d("Login Activity", "Cancel button pressed");
        ((EditText) findViewById(R.id.userName)).setText("");
        ((EditText) findViewById(R.id.Pass)).setText((""));
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        CharSequence text = "Canceled";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast message = Toast.makeText(context, text, duration);
        message.show();
    }

}
