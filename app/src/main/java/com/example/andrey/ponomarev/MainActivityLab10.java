package com.example.andrey.ponomarev;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivityLab10 extends AppCompatActivity implements FragmentLab10list.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab10);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    @Override
    public void onFragmentInteraction(Uri uri) {
        FragmentLab10Image fragmentLab10Image=(FragmentLab10Image)getSupportFragmentManager().findFragmentById((R.id.fragment2));
        if(fragmentLab10Image!=null&&fragmentLab10Image.isInLayout())
            fragmentLab10Image.setImage(String.valueOf(uri));
    }
}
