package com.example.andrey.ponomarev;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivityLab9 extends AppCompatActivity {

    String[][] auto={
            {
            "Volvo",
            "Scania",
            "Man",
            "Setra",
            "Mercedes",
            "ISUZU",
            "BMW X4",
            "Ford Galaxy",
            "Toyota Yaris"
            },
            {
                "Швеция",
                "Швеция",
                "Германия",
                "Германия",
                "Германия",
                "Япония",
                "Германия",
                "США",
                "Япония"
            }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab9);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity_lab9,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i=-1;
        switch(item.getItemId()){
            case R.id.volvo:i=0;break;
            case R.id.scania:i=1;break;
            case R.id.man:i=2;break;
            case R.id.setra:i=3;break;
            case R.id.mercedes:i=4;break;
            case R.id.isuzu:i=5;break;
            case R.id.bmw:i=6;break;
            case R.id.ford:i=7;break;
            case R.id.toyota:i=8;break;
        }
        if(i!=-1) {
            TextView textView = (TextView) findViewById(R.id.description);
            ImageView imageView = (ImageView) findViewById(R.id.imageViewLab9);
            textView.setText(auto[0][i] + " " + auto[1][i]);
            InputStream inputStream = null;
            try {
                inputStream = getApplicationContext().getAssets().open("lab9/" + auto[0][i] + ".jpg");
                Drawable d = Drawable.createFromStream(inputStream, null);
                imageView.setImageDrawable(d);
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(inputStream != null)
                        inputStream.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }


        return super.onOptionsItemSelected(item);
    }
}
