package com.example.bsef19m518_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc=new Calculator();
//        setContentView(R.layout.second_activity);
//        setContentView(R.layout.third_activity);
    }
    public void btnPress(View view)
    {

        TextView t= findViewById(R.id.calcScreen);
        calc.calculate(view,t);

    }
}