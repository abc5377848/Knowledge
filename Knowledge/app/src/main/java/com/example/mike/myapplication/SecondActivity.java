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
    protected CountDownTimer CDT;                                               // 11/20新增一個倒數計時器的物件，這是為了在backHome那裏關掉倒數



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

        answerA.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                CDT.cancel();
                if(answerA.getText().equals(answer)){
                    chooseAnswer("恭喜你", "答對了~~!好棒棒喔^^", "不玩了");
                }
                else{
                    chooseAnswer("好可惜喔~!", "答錯囉~~!真是笨阿", "在猜一次");
                }
            }
        });

        answerB.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                CDT.cancel();
                if(answerB.getText().equals(answer)){
                    chooseAnswer("恭喜你", "答對了~~!好棒棒喔^^", "不玩了");
                }
                else{
                    chooseAnswer("好可惜喔~!", "答錯囉~~!真是笨阿", "在猜一次");
                }
            }
        });

        answerC.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                CDT.cancel();
                if(answerC.getText().equals(answer)){
                    chooseAnswer("恭喜你", "答對了~~!好棒棒喔^^", "不玩了");
                }
                else{
                    chooseAnswer("好可惜喔~!", "答錯囉~~!真是笨阿", "在猜一次");
                }
            }
        });

        answerD.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                CDT.cancel();
                if(answerD.getText().equals(answer)){
                    chooseAnswer("恭喜你", "答對了~~!好棒棒喔^^", "不玩了");
                }
                else{
                    chooseAnswer("好可惜喔~!", "答錯囉~~!真是笨阿", "在猜一次");
                }
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                backHome();
            }
        });

    }

    protected void timerCount(){                                      // 計時

        CDT =  new CountDownTimer(15000, 1000){

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

    protected void dialog(){                                          // 時間到了
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
                    }
                }
        ).show();

    }

    protected void random(){                                          // 隨機抽取
        int RandomNum = ran.nextInt(questions.size());
        Number = questions.get(RandomNum);
        questions.remove(RandomNum);
    }
    protected void printOption(int q){                                // 顯示題目及選項
        Cursor cursor = db.rawQuery("SELECT Topic, A, B, C, D, Answer FROM Exam WHERE TopicNum = " + q, null); //看資料庫題號
        while (cursor.moveToNext()) {
            questionTitle.setText(cursor.getString(0));
            answerA.setText(cursor.getString(1));
            answerB.setText(cursor.getString(2));
            answerC.setText(cursor.getString(3));
            answerD.setText(cursor.getString(4));
            answer = cursor.getString(5) + "";
        }
    }

    protected void backHome(){                                        // 回到首頁
        Intent intent = new Intent();
        intent.setClass(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        SecondActivity.this.finish();
        CDT.cancel();                                                 // 11/20就在這裡
    }

    protected void chooseAnswer(String A, String B, String C){        //選完答案根據選項還出現不同的對話框
        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
        builder.setTitle(A);
        builder.setMessage(B);
        builder.setPositiveButton(C,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            backHome();
                    }
                }
        );
        builder.setNegativeButton("下一題",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        timerCount();
                        random();
                        printOption(Number);
                    }
                }
        ).show();
    }
}