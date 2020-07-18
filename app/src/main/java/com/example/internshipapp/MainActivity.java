package com.example.internshipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void nextpage(View view)
    {/*
        Intent i = new Intent(MainActivity.this, DashBoard.class); //Dashboard
        startActivity(i);*/
        Intent i = new Intent(MainActivity.this, SaveToExcel.class); //save data to excel
        startActivity(i);
    }
}
