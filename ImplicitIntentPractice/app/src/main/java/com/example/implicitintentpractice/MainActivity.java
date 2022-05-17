package com.example.implicitintentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void call_us(View v)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "03174458930"));
        startActivity(intent);
    }
    public void email_us(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "waleedmustafa50@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Application feedback");
        startActivity(intent);

    }
    public void locate_us(View v)
    {
        Uri geo = Uri.parse("geo:31.567207, 74.289705");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geo);
        startActivity(intent);
    }
    public void web_visit(View v)
    {
        Uri webpage = Uri.parse("http://waleedmustafa50.pythonanywhere.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

            startActivity(intent);

    }
}