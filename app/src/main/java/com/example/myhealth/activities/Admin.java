package com.example.myhealth.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myhealth.R;

public class Admin extends AppCompatActivity {

private TextView adminn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);


        adminn = findViewById(R.id.aaaa);

}}
