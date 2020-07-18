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
    {
        Intent i = new Intent(MainActivity.this, DashBoard.class);
        startActivity(i);
    }
}
