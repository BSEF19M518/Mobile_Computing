package com.example.learningapp_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Lessons extends AppCompatActivity implements View.OnClickListener{

    LinearLayout fruit_linear_layout;
    String[] fruit_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        fruit_names=new String[]{"apple","grapes","mango","pineapple","lychee","plum","pear","orange","peach","banana","cherry","avocado","kiwi","pomegranate","chikoo","strawberry","apricot","date","guava","fig","coconut","watermelon"};
        fruit_linear_layout=findViewById(R.id.fruits_linear_layout);
        for(String fruit:fruit_names)
        {
            Button btn=new Button(this);
            btn.setText(fruit);
            btn.setOnClickListener(this);
            fruit_linear_layout.addView(btn); ;
        }

    }

    @Override
    public void onClick(View view) {
        Button btn= (Button)view;
        Intent intent= new Intent(this,FruitDetail.class);
        intent.putExtra("fruit",btn.getText());
        startActivity(intent);
    }
}