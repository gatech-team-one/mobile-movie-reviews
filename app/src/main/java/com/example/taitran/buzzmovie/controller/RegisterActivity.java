package com.example.taitran.buzzmovie.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;

import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;


public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /**
     * Register button pressed
     * @param w reference to the register button
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
            finish();
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
     * Cancel button pressed
     * @param w reference to the cancel button
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
     * Regulate text clicked
     * @param v reference to the text
     */
    public void regTextOnClicked(View v) {
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
