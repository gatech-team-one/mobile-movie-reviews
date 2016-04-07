package com.example.taitran.buzzmovie.controller;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.taitran.buzzmovie.model.Database;
import com.example.taitran.buzzmovie.model.FragmentAdapter;
import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;

public class AdminActivity extends AppCompatActivity {
    /**
     * The toolbar for the admin.
     */
    private Toolbar mtoolbar;
    /**
     * The fragment adapter.
     */
    private FragmentAdapter myadapter;
    /**
     * The view pager.
     */
    private ViewPager mpager;
    /**
     * The tab layout.
     */
    private TabLayout mTab;
    /**
     * The database.
     */
    private Database db;
    /**
     * User management for the admin.
     */
    private UserManagement userMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        db = new Database(this);
        userMan = new UserManager(this);
        myadapter = new FragmentAdapter(getSupportFragmentManager());
        // add the fragment object to the adapter and attached it to the activity
        myadapter.addFragment(new UsersActivity(), "Users");
        myadapter.addFragment(new AddUser(), "Add Account");
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mpager = (ViewPager) findViewById(R.id.pager);
        mTab = (TabLayout) findViewById(R.id.tab_layout);
        mpager.setAdapter(myadapter);
        mTab.setupWithViewPager(mpager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            Intent welcomePage = new Intent(this, WelcomeActivity.class);
            welcomePage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            welcomePage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(welcomePage);
            db.logUserOut(userMan.getActiveUser());
            CharSequence text = "Successfully Logged Out";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast message = Toast.makeText(context, text, duration);
            message.show();
        }
        return super.onOptionsItemSelected(item);
    }

}