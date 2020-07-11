package com.example.internshipapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Faqs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
    }
    public void prod(View view)
    {
        Intent i = new Intent(Faqs.this, Guildlines.class);
        startActivity(i);
    }
}
