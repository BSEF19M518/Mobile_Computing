package com.example.learningapp_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class Exam extends AppCompatActivity {

    static int QUESTIONS_COUNT;
    static  int OPTION_COUNT;
    LinearLayout exam_linear_layout;
    String[] fruit_names;
    ArrayList<String> answers;
    ArrayList<RadioGroup> radioGroups;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        radioGroups=new ArrayList<>();
        answers=new ArrayList<>();

        Intent intent = getIntent();
        fruit_names=intent.getStringArrayExtra("fruit_names");
        QUESTIONS_COUNT=intent.getIntExtra("no_of_questions",5);
        OPTION_COUNT=intent.getIntExtra("no_of_options",4);

        exam_linear_layout=findViewById(R.id.exam_linear_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(600, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20,20,20,80);


        for(int i=0;i<QUESTIONS_COUNT;i++) {

            LinearLayout ll=new LinearLayout(this);
            ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.setOrientation(LinearLayout.VERTICAL);
            String fruit_name=getRandomFruitName();
            answers.add(fruit_name);
            String fruit_image_name=getRandomFruitImageName(fruit_name);
            RadioGroup radioGroup= generateOptions(fruit_name);
            radioGroups.add(radioGroup);
            //////

            int drawableResourceId = getFruitImageResourceId(fruit_image_name);
            ImageView imageView = new ImageView(Exam.this);
            Drawable res = getResources().getDrawable(drawableResourceId);
            imageView.setImageDrawable(res);
            imageView.setLayoutParams(params);
            imageView.setAdjustViewBounds(true);
            ll.addView(imageView);
            ll.addView(radioGroup);

            exam_linear_layout.addView(ll,radioGroups.size()-1);
        }

    }
    public void submit_btn(View v)
    {
        int exam_status=checkExam();

        if(exam_status<0)
        {
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent=new Intent(this,ExamResult.class);
        intent.putExtra("correct_answers",exam_status);
        intent.putExtra("total_questions",QUESTIONS_COUNT);
        startActivity(intent);
    }

    private int checkExam()
    {
        boolean all_check=true;
        int correct=0;
        int index=0;

        for(RadioGroup radioGroup: radioGroups) {
            int button_id=radioGroup.getCheckedRadioButtonId();

            if(button_id==-1) {
                all_check = false;
                break;
            }
            RadioButton btnChoosen = (RadioButton)findViewById(button_id);
            if(answers.get(index++).equals(btnChoosen.getText().toString().toLowerCase()))
            {
                correct++;
            }
        }
        if(all_check)
        {
            return correct;
        }
        else
            // return -1 if not all mcqs answered
            return -1;
    }

    private RadioGroup generateOptions(String fruitName)
    {
        Random random=new Random();
        RadioGroup option_group = new RadioGroup(this);

        HashSet<String> option_fruits = new HashSet<>();
        option_fruits.add(fruitName);
        while(option_fruits.size()<OPTION_COUNT)
        {
            option_fruits.add(getRandomFruitName());
        }
        // add radio buttons to radio groups
        for(String option:option_fruits) {
            RadioButton btn=new RadioButton(this);
            btn.setText(option.toUpperCase(Locale.ROOT));
            option_group.addView(btn);
        }
        return option_group;

    }
    private int getFruitImageResourceId(String str)
    {
        int drawableResourceId = this.getResources().getIdentifier(str, "drawable", this.getPackageName());
        return drawableResourceId;
    }
    private String getRandomFruitImageName(String fruit)
    {
        Random random=new Random();

        int counter=1;
        while(getResources().getIdentifier(fruit + counter++, "drawable", this.getPackageName())!=0);
        return fruit + (random.nextInt(counter-2)+1);
    }
    private String getRandomFruitName()
    {
        Random random=new Random();
        String fruit=fruit_names[random.nextInt(fruit_names.length)];
        return fruit;
    }
}