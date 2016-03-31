package com.example.taitran.buzzmovie.controller;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.taitran.buzzmovie.model.FragmentAdapter;
import com.example.taitran.buzzmovie.model.UserManagement;
import com.example.taitran.buzzmovie.model.UserManager;

public class NewDashboard extends AppCompatActivity {

    private Toolbar mtoolbar;
    private FragmentAdapter myadapter;
    private ViewPager mpager;
    private TabLayout mTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dashboard);
        myadapter = new FragmentAdapter(getSupportFragmentManager());
        // add the fragment object to the adapter and attached it to the activity
        myadapter.addFragment(new Frag1(), "Pinkish");
        myadapter.addFragment(new Frag2(), "Orangeish Red");
        myadapter.addFragment(new Frag3(), "Purple");
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
            UserManagement user = new UserManager();
            user.logOut();
            finish();
            startActivity(new Intent(this, WelcomeActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
