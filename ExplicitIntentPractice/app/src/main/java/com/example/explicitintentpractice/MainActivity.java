package com.example.explicitintentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText optionText;
    String[] correct_options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionText=findViewById(R.id.optionText);
                String option=optionText.getText().toString();

                correct_options=new String[] {"1","2","3"};

                if(inOptions(option)) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("option", option);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Please enter valid option", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private boolean inOptions(String option)
    {
        for(int i=0;i<correct_options.length;i++) {
            if (option.equals(correct_options[i]))
                return true;
        }
            return false;
    }

}