package com.example.learningapp_v2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExamResult extends AppCompatActivity {

    TextView total_mcqs_textView;
    TextView correct_mcqs_textView;
    TextView score_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result);

        Intent intent=getIntent();
        int correct=intent.getIntExtra("correct_answers",0);
        int total=intent.getIntExtra("total_questions",0);

        display_result(correct,total);
    }

    private void display_result(int correct, int total) {
        total_mcqs_textView=findViewById(R.id.total_mcqs);
        correct_mcqs_textView=findViewById(R.id.correct_mcqs);
        score_textView=findViewById(R.id.exam_score);

        total_mcqs_textView.setText(String.valueOf(total));
        correct_mcqs_textView.setText(String.valueOf(correct));
        score_textView.setText(correct+"/"+total);
    }
}