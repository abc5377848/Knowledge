package com.example.mike.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class SecondActivity extends Activity {

    private ArrayList<Integer> questions = new ArrayList<Integer>();
    protected Random ran = new Random();
    protected long reciprocal;
    protected int Number;
    protected String answer;
    protected TextView questionTitle;
    protected TextView timeCount;
    protected Button answerA;
    protected Button answerB;
    protected Button answerC;
    protected Button answerD;
    protected Button backHome;
    protected MyDBHelper myDB;
    protected SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timeCount = (TextView)findViewById(R.id.timeCount);
        questionTitle = (TextView)findViewById(R.id.questionTitle);
        answerA = (Button) findViewById(R.id.answerA);
        answerB = (Button) findViewById(R.id.answerB);
        answerC = (Button) findViewById(R.id.answerC);
        answerD = (Button) findViewById(R.id.answerD);
        backHome = (Button) findViewById(R.id.backHome);
        backHome.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                SecondActivity.this.finish();
            }
        });
        timerCount();
        myDB = new MyDBHelper(this, "MyDB", null, 1);
        db = myDB.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT TopicNum FROM Exam", null); //看資料庫題號
        while (cursor.moveToNext()) {
            int num = cursor.getInt(0);
            questions.add(num);
        }
        random();
        printOption(Number);



<<<<<<< HEAD
/*          while(!questions.isEmpty()){
=======

    /*     while(!questions.isEmpty()){
>>>>>>> 9dc770693e1a63da6a50a1b83801a47eef5f2973
            Question q = new Question();
            try{
                random(q);
                printOption(q);
            }catch (Exception e){
                e.printStackTrace();
            }

        }*/
    }

    protected void timerCount(){

        new CountDownTimer(15000, 1000){

            @Override
            public void onFinish() {

                dialog();
            }

            @Override
            public void onTick(long millisUntilFinished)
            {
                reciprocal = millisUntilFinished/1000;
                timeCount.setText(reciprocal + "");
            }
        }.start();

    }

    protected void dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
        builder.setTitle("時間到了");
        builder.setMessage("Game Over");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setClass(SecondActivity.this, MainActivity.class);
                        startActivity(intent);
                        SecondActivity.this.finish();
                    }
                }
        ).show();

    }

    protected void random(){
        int RandomNum = ran.nextInt(questions.size());
        Number = questions.get(RandomNum);
        questions.remove(RandomNum);
    }
    protected void printOption(int q){
        Cursor cursor = db.rawQuery("SELECT Topic, A, B, C, D, Answer FROM Exam WHERE TopicNum = " + q, null); //看資料庫題號
        while (cursor.moveToNext()) {
            questionTitle.setText(cursor.getString(0) + "");
            answerA.setText(cursor.getString(1) + "");
            answerB.setText(cursor.getString(2) + "");
            answerC.setText(cursor.getString(3) + "");
            answerD.setText(cursor.getString(4) + "");
            answer = cursor.getString(5) + "";
        }
    }
}