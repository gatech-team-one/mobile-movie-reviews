package com.example.taitran.buzzmovie.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taitran.buzzmovie.model.UserAuthentication;
import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;

/**
 * Activity to register new users
 * Created by andie on 2/8/2016.
 */
public class RegisterActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /**
     * Method for when the register button is pressed
     * @param w reference to the register button when pressed
     */
    public void registerButtonPressed(View w) {
        String type = "User";
        Log.d("Register Activity", "Register button pressed");
        UserManagement manager = new UserManager(this);
        EditText username = (EditText) findViewById(R.id.regUserName);
        EditText password = (EditText) findViewById(R.id.regPass);
        EditText email = (EditText) findViewById(R.id.regEmail);
        CharSequence text = "Registration Success";

        try {
            manager.addUser(email.getText().toString(), username.getText().toString(), password.getText().toString(), type);
            UserAuthentication user = new UserManager(this);
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        } catch (IllegalArgumentException e) {
            text = e.getMessage();
        }



        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast message = Toast.makeText(context, text, duration);
        message.show();
    }

    /**
     * To cancel registering after starting
     * @param w reference to the cancel button when pressed while registering
     */
    public void regCancelButtonPressed (View w) {
        Log.d("Register Activity", "Cancel button pressed");
        ((EditText) findViewById(R.id.regUserName)).setText("");
        ((EditText) findViewById(R.id.regPass)).setText((""));
        ((EditText) findViewById(R.id.regEmail)).setText((""));
        finish();
        CharSequence text = "Canceled";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast message = Toast.makeText(context, text, duration);
        message.show();
    }

    /**
     * When text is clicked
     * @param v reference to the text when pressed
     */
    public void regTextOnClicked(View v) {
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
