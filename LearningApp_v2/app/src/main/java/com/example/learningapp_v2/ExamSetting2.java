package com.example.learningapp_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ExamSetting2 extends AppCompatActivity {

    Spinner dropdown;

    int selected_no_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_setting2);

        dropdown = findViewById(R.id.spinner);

        ArrayList<Integer> no_questions = new ArrayList<>();
        for (int i = 3; i <= 20; i++)
            no_questions.add(i);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, no_questions);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    }
    public void startExam(View v) {
        Intent intent=new Intent(this, com.example.learningapp_v2.Exam2.class);
        intent.putExtra("no_of_questions",selected_no_questions);
        intent.putExtra("fruit_names",getIntent().getStringArrayExtra("fruit_names"));
        startActivity(intent);
    }
}