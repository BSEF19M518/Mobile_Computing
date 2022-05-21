package com.example.learningapp_task;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class FruitDetail extends AppCompatActivity {

    LinearLayout fruit_detail;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail);

        fruit_detail=findViewById(R.id.fruit_detail_layout);
        Intent intent=getIntent();
        String fruit_name=intent.getStringExtra("fruit");

        textView=findViewById(R.id.textView3);
        textView.setText(fruit_name.toUpperCase(Locale.ROOT));
        int counter=1;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(600, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20,20,20,80);

        while(true) {
            try {
                ImageView imageView = new ImageView(FruitDetail.this);
                int drawableResourceId = this.getResources().getIdentifier(fruit_name + counter++, "drawable", this.getPackageName());
                Drawable res = getResources().getDrawable(drawableResourceId);
                imageView.setImageDrawable(res);
                imageView.setLayoutParams(params);
                imageView.setAdjustViewBounds(true);
                fruit_detail.addView(imageView);
            }
            catch(Exception e)
            {
                break;// Do NOTHING
            }
        }
    }

}