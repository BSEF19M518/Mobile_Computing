package com.example.learningapp_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lessons extends AppCompatActivity{

    ListView fruits_listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        Intent intent=getIntent();
        String[] fruit_names=intent.getStringArrayExtra("fruit_names");

        fruits_listview=findViewById(R.id.lessons_listview);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,fruit_names);

        fruits_listview.setAdapter(adapter);

        fruits_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent= new Intent(Lessons.this,FruitDetail.class);
                intent.putExtra("fruit",fruit_names[i]);
                startActivity(intent);
            }
        });


    }

}