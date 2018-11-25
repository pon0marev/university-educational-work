package com.example.andrey.ponomarev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityLab5_2Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_2_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getIntExtra("position",1);
        MainActivityLab5_2 mainActivityLab5_2= new MainActivityLab5_2();

        ImageView imageView= (ImageView)findViewById(R.id.lab5SImage);
        imageView.setImageResource(mainActivityLab5_2.autoImage[position]);

        TextView textView= (TextView)findViewById(R.id.lab5SText);
        textView.setText(mainActivityLab5_2.auto[position]+"");
    }
}
