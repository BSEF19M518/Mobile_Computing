package com.example.learningapp_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String[] fruit_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruit_names=new String[]{"apple","grapes","mango","pineapple","lychee","plum","pear","orange","peach","banana","cherry","avocado","kiwi","pomegranate","chikoo","strawberry","apricot","date","guava","fig","coconut","watermelon"};

    }

    public void repoBtnClick(View v)
    {
        Uri webpage = Uri.parse("https://github.com/BSEF19M518/Mobile_Computing");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

            startActivity(intent);

    }
    public void lessonBtnClick(View v)
    {
        Intent intent = new Intent(this,Lessons.class);
        intent.putExtra("fruit_names",fruit_names);
        startActivity(intent);

    }
    public void examBtnClick(View v)
    {
        Intent intent = new Intent(this,ExamSetting.class);
        intent.putExtra("fruit_names",fruit_names);
        startActivity(intent);

    }
}