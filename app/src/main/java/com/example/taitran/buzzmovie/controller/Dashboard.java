package com.example.taitran.buzzmovie.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.example.taitran.buzzmovie.model.UserAuthentication;
import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void logoutButtonPressed(View V) {
        UserManagement logOut = new UserManager();
        Intent welcomePage = new Intent(this, WelcomeActivity.class);
        startActivity(welcomePage);
        CharSequence text = "Successfully Logged Out";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast message = Toast.makeText(context, text, duration);
        message.show();
    }

}