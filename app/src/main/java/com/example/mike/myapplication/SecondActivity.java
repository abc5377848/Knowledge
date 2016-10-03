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
    long reciprocal;
    Random ran = new Random();
    int firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        while(questions.isEmpty()){
            Question q = new Question();
            random(q);

        }

        timerCount();

    }

    protected void timerCount(){

        new CountDownTimer(15000, 1000){

            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished) {
                reciprocal = millisUntilFinished/1000;
            }
        }.start();
    }

    protected void random(Question q){

        firstNumber = ran.nextInt(questions.size());
        q = questions.get(firstNumber);
        questions.remove(firstNumber);

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
