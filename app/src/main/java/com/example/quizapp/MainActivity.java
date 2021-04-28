package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView mtextview;
    private Button btntrue;
    private Button btnfalse;
    private int questionIndex;
    private int mQuizQestion;
    private ProgressBar progressBar;
    private TextView score;
    private int userScore;

    private  QuizModel[] questionCollectiion = new QuizModel[] {

            new QuizModel(R.string.q1,true),
            new QuizModel(R.string.q2,false),
            new QuizModel(R.string.q3,true),
            new QuizModel(R.string.q4,false),
            new QuizModel(R.string.q5,true),
            new QuizModel(R.string.q6,false),
            new QuizModel(R.string.q7,false),
            new QuizModel(R.string.q8,false),
            new QuizModel(R.string.q9,false),
            new QuizModel(R.string.q10,false)

    };

    final int USER_PROGRESS = (int) Math.ceil(100.0 / questionCollectiion.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btntrue = findViewById(R.id.trueButton);
         btnfalse = findViewById(R.id.wrongButton);
         mtextview = findViewById(R.id.questionText);
         progressBar = findViewById(R.id.quizProgress);
         score = findViewById(R.id.quizStatus);

         QuizModel q1 = questionCollectiion[questionIndex];
         mQuizQestion = q1.getmQuestion();

         mtextview.setText(mQuizQestion);

         btntrue.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 evaluateUserAnswer(true);
                 chaneQuestion();
             }
         });

         btnfalse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 evaluateUserAnswer(false);
                 chaneQuestion();
             }
         });
    }

    private void chaneQuestion() {

        questionIndex = (questionIndex + 1) % 10;

        if(questionIndex == 0) {
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("The Quiz is Finished");
            quizAlert.setMessage("Your score is "+userScore);
            quizAlert.setPositiveButton("Finish the quiz!!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
        }

        mQuizQestion = questionCollectiion[questionIndex].getmQuestion();
        mtextview.setText(mQuizQestion);
        progressBar.incrementProgressBy(USER_PROGRESS);
        score.setText(userScore+"");
    }

    private void evaluateUserAnswer(boolean userAnswer) {

        boolean currentQuestionAnswer = questionCollectiion[questionIndex].isManswer();

        if(currentQuestionAnswer == userAnswer) {
            userScore = userScore + 1;
            Toast.makeText(this, R.string.correct_toast_message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.Incorrect_toast_message, Toast.LENGTH_SHORT).show();
        }
    }

}