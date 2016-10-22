package com.example.mike.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private ArrayList<Question> questions = new ArrayList<Question>();
    protected Random ran = new Random();
    protected long reciprocal;
    protected int firstNumber;
<<<<<<< HEAD
=======
    protected TextView questionName;
    protected TextView answerTA;
    protected RadioButton answerRA;
    protected TextView answerTB;
    protected RadioButton answerRB;
    protected TextView answerTC;
    protected RadioButton answerRC;
    protected TextView answerTD;
    protected RadioButton answerRD;
    protected TextView timeCount;
>>>>>>> origin/Branch_One

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        while(questions.isEmpty()){
            Question q = new Question();
            random(q);
<<<<<<< HEAD

=======
            printOption(q);
            timerCount();
>>>>>>> origin/Branch_One
        }
    }

    protected void timerCount(){

        timerCount();

    }

    protected void timerCount(){

        new CountDownTimer(15000, 1000){

            @Override
            public void onFinish() {

            }

            @Override
<<<<<<< HEAD
            public void onTick(long millisUntilFinished) {
                reciprocal = millisUntilFinished/1000;
=======
            public void onTick(long millisUntilFinished)
            {
                reciprocal = millisUntilFinished/1000;
                timeCount.setText(reciprocal + "");
>>>>>>> origin/Branch_One
            }
        }.start();

    }

    protected void random(Question q){

        firstNumber = ran.nextInt(questions.size());
        q = questions.get(firstNumber);
        questions.remove(firstNumber);

    }
<<<<<<< HEAD

=======
    protected void printOption(Question q){
        questionName.setText(q.question);
        answerTA.setText(q.A);
        answerTB.setText(q.B);
        answerTC.setText(q.C);
        answerTD.setText(q.D);
    }
>>>>>>> origin/Branch_One
}
class Question {

    String question;
    String A;
    String B;
    String C;
    String D;
    String correctAnswer;

}