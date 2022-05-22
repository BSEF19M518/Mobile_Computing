package com.example.learningapp_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Lessons extends AppCompatActivity implements View.OnClickListener{

    LinearLayout fruit_linear_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        Intent intent=getIntent();
        String[] fruit_names=intent.getStringArrayExtra("fruit_names");

        fruit_linear_layout=findViewById(R.id.fruits_linear_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(400, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,5,0,5);
        for(String fruit:fruit_names)
        {
            Button btn=new Button(this);
            btn.setText(fruit);
            btn.setOnClickListener(this);
            btn.setLayoutParams(params);
            fruit_linear_layout.addView(btn);
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