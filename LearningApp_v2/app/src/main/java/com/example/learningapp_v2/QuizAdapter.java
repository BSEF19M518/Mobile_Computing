package com.example.learningapp_v2;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends ArrayAdapter<MCQ> {
    public QuizAdapter(@NonNull Context context, @NonNull List<MCQ> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MCQ mcq = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.quiz_item,parent,false);

        ImageView imageView=convertView.findViewById(R.id.imageView);
        RadioButton option1 = convertView.findViewById(R.id.option1);
        RadioButton option2 = convertView.findViewById(R.id.option2);
        RadioButton option3 = convertView.findViewById(R.id.option3);
        RadioButton option4 = convertView.findViewById(R.id.option4);
        RadioButton option5 = convertView.findViewById(R.id.option5);

        imageView.setImageResource(mcq.getMCQImageID());
        option1.setText(mcq.getOption1());
        option2.setText(mcq.getOption2());
        option3.setText(mcq.getOption3());
        option4.setText(mcq.getOption4());
        option5.setText(mcq.getOption5());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exam2.map.put(position,option1.getText());
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exam2.map.put(position,option2.getText());
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exam2.map.put(position,option3.getText());
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exam2.map.put(position,option4.getText());
            }
        });
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exam2.map.put(position,option5.getText());
            }
        });


        return convertView;
    }

}
