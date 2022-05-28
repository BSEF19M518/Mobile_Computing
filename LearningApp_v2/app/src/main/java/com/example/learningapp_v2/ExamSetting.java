package com.example.learningapp_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ExamSetting extends AppCompatActivity {

    Spinner dropdown1;
    Spinner dropdown2;
    int selected_no_questions;
    int selected_no_options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_setting);
        dropdown1 = findViewById(R.id.spinner1);
        dropdown2 = findViewById(R.id.spinner2);

        ArrayList<Integer> no_questions = new ArrayList<>();
        for (int i = 3; i <= 20; i++)
            no_questions.add(i);

        ArrayList<Integer> no_options = new ArrayList<>();
        for (int i = 3; i <= 8; i++)
            no_options.add(i);

        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, no_questions);
        dropdown1.setAdapter(adapter1);

        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, no_options);
        dropdown2.setAdapter(adapter2);

        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
               selected_no_questions= Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
               selected_no_options= Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void startExam(View v) {
        Intent intent=new Intent(this, com.example.learningapp_v2.Exam.class);
        intent.putExtra("no_of_questions",selected_no_questions);
        intent.putExtra("no_of_options",selected_no_options);
        intent.putExtra("fruit_names",getIntent().getStringArrayExtra("fruit_names"));
        startActivity(intent);
    }

}