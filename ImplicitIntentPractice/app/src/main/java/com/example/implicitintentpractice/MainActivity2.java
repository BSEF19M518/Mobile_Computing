package com.example.implicitintentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    TextView heading;
    String[] names;
    String[] details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        names=new String[4];
        names[1]="C++";
        names[2]="Java";
        names[3]="Python";

        details=new String[4];
        details[0]="";
        details[1]="C++ is a cross-platform language that can be used to create high-performance applications.\n" +
                "\n" +
                "C++ was developed by Bjarne Stroustrup, as an extension to the C language.\n" +
                "\n" +
                "C++ gives programmers a high level of control over system resources and memory.\n" +
                "\n" +
                "The language was updated 4 major times in 2011, 2014, 2017, and 2020 to C++11, C++14, C++17, C++20.\n" +
                "\n";
        details[2]="Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.";
        details[3]="What is Python?\n" +
                "Python is a popular programming language. It was created by Guido van Rossum, and released in 1991.\n" +
                "\n" +
                "It is used for:\n" +
                "\n" +
                "web development (server-side),\n" +
                "software development,\n" +
                "mathematics,\n" +
                "system scripting.\n" +
                "What can Python do?\n" +
                "Python can be used on a server to create web applications.\n" +
                "Python can be used alongside software to create workflows.\n" +
                "Python can connect to database systems. It can also read and modify files.\n" +
                "Python can be used to handle big data and perform complex mathematics.\n" +
                "Python can be used for rapid prototyping, or for production-ready software development.\n" +
                "Why Python?\n" +
                "Python works on different platforms (Windows, Mac, Linux, Raspberry Pi, etc).\n" +
                "Python has a simple syntax similar to the English language.\n" +
                "Python has syntax that allows developers to write programs with fewer lines than some other programming languages.\n" +
                "Python runs on an interpreter system, meaning that code can be executed as soon as it is written. This means that prototyping can be very quick.\n" +
                "Python can be treated in a procedural way, an object-oriented way or a functional way.\n" +
                "Good to know\n" +
                "The most recent major version of Python is Python 3, which we shall be using in this tutorial. However, Python 2, although not being updated with anything other than security updates, is still quite popular.\n" +
                "In this tutorial Python will be written in a text editor. It is possible to write Python in an Integrated Development Environment, such as Thonny, Pycharm, Netbeans or Eclipse which are particularly useful when managing larger collections of Python files.\n" +
                "Python Syntax compared to other programming languages\n" +
                "Python was designed for readability, and has some similarities to the English language with influence from mathematics.\n" +
                "Python uses new lines to complete a command, as opposed to other programming languages which often use semicolons or parentheses.\n" +
                "Python relies on indentation, using whitespace, to define scope; such as the scope of loops, functions and classes. Other programming languages often use curly-brackets for this purpose.";

        Intent intent=getIntent();
        int option= Integer.parseInt(intent.getStringExtra("option"));

        textView=findViewById(R.id.textView8);
        heading=findViewById(R.id.textView5);
        heading.setText("Welcome to "+names[option]+" detail:");
        textView.setText(details[option]);

    }
}