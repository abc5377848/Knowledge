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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        while(!questions.isEmpty()){
//            Question q = new Question();
//            try{
//                random(q);
//                printOption(q);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            timerCount();
//        }
    }

    protected void timerCount(){

        new CountDownTimer(15000, 1000){

            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long millisUntilFinished)
            {
                reciprocal = millisUntilFinished/1000;
                timeCount.setText(reciprocal + "");
            }
        }.start();

    }

    protected void random(Question q){

        firstNumber = ran.nextInt(questions.size());
        q = questions.get(firstNumber);
        questions.remove(firstNumber);

    }
    protected void printOption(Question q){
        questionName.setText(q.question);
        answerTA.setText(q.A);
        answerTB.setText(q.B);
        answerTC.setText(q.C);
        answerTD.setText(q.D);
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