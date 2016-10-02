package com.example.mike.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;

import android.view.View;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {

    ArrayList<Question> questions = new ArrayList<Question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random ran = new Random();
        int firstNumber = ran.nextInt(questions.size());
        Question q = new Question();
        q = questions.get(firstNumber);
        questions.remove(firstNumber);

        while(questions.isEmpty()){

        }

        new CountDownTimer(15000, 1000){

            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }


    protected void gamesStart(){

    }
}

class Question {
    String question;
    String A;
    String B;
    String C;
    String D;
    String correctAnswer;
}
