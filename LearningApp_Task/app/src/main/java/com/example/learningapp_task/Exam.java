package com.example.learningapp_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exam extends AppCompatActivity {

    LinearLayout exam_linear_layout;
    String[] fruit_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        Intent intent = getIntent();
        fruit_names=intent.getStringArrayExtra("fruit_names");

        exam_linear_layout=findViewById(R.id.exam_linear_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(600, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20,20,20,80);

        for(int i=0;i<1;i++)
        {
            int drawableResourceId=getRandomFruitImage();
            ImageView imageView = new ImageView(Exam.this);
            Drawable res = getResources().getDrawable(drawableResourceId);
            imageView.setImageDrawable(res);
            imageView.setLayoutParams(params);
            imageView.setAdjustViewBounds(true);
            exam_linear_layout.addView(imageView);
        }

    }
    private int getRandomFruitImage()
    {
        Random random=new Random();

        String fruit=fruit_names[random.nextInt(fruit_names.length)];

        int counter=1;
        while(true)
        {
            try {
                getResources().getDrawable(getResources().getIdentifier(fruit + counter++, "drawable", this.getPackageName()));
            }
            catch(Exception e)
            {
                break;
            }
        }

        int drawableResourceId = this.getResources().getIdentifier(fruit + (random.nextInt(counter-1)+1), "drawable", this.getPackageName());
        return drawableResourceId;
    }
}