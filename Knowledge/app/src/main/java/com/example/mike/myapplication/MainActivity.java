package com.example.mike.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    protected MyDBHelper myDB;
    protected SQLiteDatabase db;
    protected ArrayList<String[]> UserAccPass = new ArrayList<String[]>();

    protected Button Bt1;
    protected EditText Et1;
    protected EditText Et2;
    protected static boolean LOGIN = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = (EditText) findViewById(R.id.editText1);
        Et2 = (EditText) findViewById(R.id.editText2);

        myDB = new MyDBHelper(this, "MyDB", null, 1);
        db = myDB.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User", null); //等入畫面，輸入帳號密碼
        while(cursor.moveToNext()){
            String[] AccPass = new String[2];
            AccPass[0] = cursor.getString(1);
            AccPass[1] = cursor.getString(2);
            UserAccPass.add(AccPass);
        }
        Bt1 = (Button) findViewById(R.id.button);
        Bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){

                for(int i = 0; i < UserAccPass.size(); i++){
                    if(Et1.getText().toString().equals(UserAccPass.get(i)[0]) && Et2.getText().toString().equals(UserAccPass.get(i)[1])){
                        LOGIN = true;
                        break;
                    }
                }

                if(LOGIN){
                    LOGIN = false;
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            }
        });

    }
}


