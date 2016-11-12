package com.example.mike.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    Button Bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bt1 = (Button) findViewById(R.id.button);
        Bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });

    }

}