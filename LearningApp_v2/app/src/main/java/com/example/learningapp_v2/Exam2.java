package com.example.learningapp_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;

public class Exam2 extends AppCompatActivity {

    static int QUESTIONS_COUNT;
    final static int OPTION_COUNT=5;
    static HashMap map;

    String[] fruit_names;
    ListView questions_list_view;
    ArrayList<String> answers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        map=new HashMap();
        questions_list_view=findViewById(R.id.listView);
        answers=new ArrayList<>();

        Intent intent = getIntent();
        fruit_names=intent.getStringArrayExtra("fruit_names");
        QUESTIONS_COUNT=intent.getIntExtra("no_of_questions",5);

        ArrayList<MCQ> mcq_questions = new ArrayList<>();

        for(int i=0;i<QUESTIONS_COUNT;i++) {
            String fruit_name=getRandomFruitName();
            answers.add(fruit_name);
            String fruit_image_name=getRandomFruitImageName(fruit_name);

            ArrayList<String> options= generateOptions(fruit_name);
            int imageId = getFruitImageResourceId(fruit_image_name);

            mcq_questions.add(new MCQ(imageId, options.get(0), options.get(1), options.get(2), options.get(3), options.get(4)));
        }
        QuizAdapter adapter = new QuizAdapter(getApplicationContext(),mcq_questions);
        questions_list_view.setAdapter(adapter);

    }
    public void submit_btn(View v)
    {
        int exam_status=checkExam();

        if(exam_status<0)
        {
            Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent=new Intent(this, com.example.learningapp_v2.ExamResult.class);
        intent.putExtra("correct_answers",exam_status);
        intent.putExtra("total_questions",QUESTIONS_COUNT);
        map.clear();
        startActivity(intent);
    }

    private int checkExam()
    {

        boolean all_check=true;
        int correct=0;
        int index=0;

//        for(int i=0;i<QUESTIONS_COUNT;i++)
//        {
//            View v= questions_list_view.getChildAt(i - questions_list_view.getFirstVisiblePosition());
//            if(v==null)
//                continue;;
//            RadioGroup g= v.findViewById(R.id.options_radio_group);
//            RadioButton btn= findViewById(g.getCheckedRadioButtonId());
//            if(btn==null)
//            {
//                all_check=false;
//                break;
//            }
//            if(btn.getText().toString().equals(answers.get(i)))
//                correct++;
//        }


        for(int i=0;i<QUESTIONS_COUNT;i++)
        {
            String selected= (String)map.get(i);
            if(!map.containsKey(i))
            {
                all_check=false;
                break;
            }
            if(selected.equals(answers.get(i)))
                correct++;
        }

        if(all_check)
        {
            return correct;
        }
        else
            // return -1 if not all mcqs answered
            return -1;
    }

    private ArrayList<String> generateOptions(String fruitName)
    {
        Random random=new Random();

        HashSet<String> options_set = new HashSet<>();
        options_set.add(fruitName);

        while(options_set.size()<OPTION_COUNT)
        {
            options_set.add(getRandomFruitName());
        }

        ArrayList<String> option_list = new ArrayList<>();
        for(String option:options_set) {
            option_list.add(option);
        }
        return option_list;

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