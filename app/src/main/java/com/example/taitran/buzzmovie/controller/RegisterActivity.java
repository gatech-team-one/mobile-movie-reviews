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

import com.example.taitran.buzzmovie.model.UserAuthentication;
import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;

/**
 * Created by andie on 2/8/2016.
 */
public class RegisterActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerButtonPressed(View w) {
        Log.d("Login Activity", "Register button pressed");
        UserManagement manager = new UserManager();
        EditText username = (EditText) findViewById(R.id.regUserName);
        EditText password = (EditText) findViewById(R.id.regPass);
        EditText email = (EditText) findViewById(R.id.regEmail);

        CharSequence text = "Registration Success";

        try {
            manager.addUser(email.getText().toString(), username.getText().toString(), password.getText().toString());
        } catch (IllegalArgumentException e) {
            text = e.getMessage();
        }
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast message = Toast.makeText(context, text, duration);
        message.show();
    }
}