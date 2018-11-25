package com.example.andrey.ponomarev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int countTapAddApp=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lab1) {
            startActivity(new Intent(MainActivity.this, MainActivityLab1.class));
        } else if (id == R.id.nav_lab2) {
            startActivity(new Intent(MainActivity.this, MainActivityLab2.class));
        } else if (id == R.id.nav_lab3) {
            startActivity(new Intent(MainActivity.this, MainActivityLab3.class));
        } else if (id == R.id.nav_lab4) {
            startActivity(new Intent(MainActivity.this, MainActivityLab4.class));
        } else if (id == R.id.nav_lab5) {
            startActivity(new Intent(MainActivity.this, MainActivityLab5.class));
        }else if (id == R.id.nav_lab6) {
            startActivity(new Intent(MainActivity.this, MainActivityLab6.class));
        }else if (id == R.id.nav_lab7) {
            startActivity(new Intent(MainActivity.this, MainActivityLab7.class));
        } else if (id == R.id.nav_lab8) {
            startActivity(new Intent(MainActivity.this, MainActivityLab8.class));
        } else if (id == R.id.nav_lab9) {
            startActivity(new Intent(MainActivity.this, MainActivityLab9.class));
        }else if (id == R.id.nav_lab10) {
            startActivity(new Intent(MainActivity.this, MainActivityLab10.class));
        }else if (id == R.id.nav_lab11) {
            startActivity(new Intent(MainActivity.this, MainActivityLab11.class));
        } else if (id == R.id.nav_help) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    public void AppAdd(View view) {
        countTapAddApp++;
        if(countTapAddApp<5) Toast.makeText(this, "Nothing)", Toast.LENGTH_SHORT).show();
        else if(countTapAddApp<10) Toast.makeText(this, "Open the menu, please....", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "Нажми на три полосы сверху!", Toast.LENGTH_SHORT).show();
    }

}
