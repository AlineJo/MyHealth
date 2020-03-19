package com.example.myhealth.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myhealth.R;
import com.example.myhealth.activities.login;
import com.example.myhealth.activities.regestration;


public class MainActivity extends AppCompatActivity {


    private Button btnr, btnl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnl = (Button) findViewById(R.id.button2);
        btnr = (Button) findViewById(R.id.button);
        btnr.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        openReistration();


        }
        });

        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        }

public void openReistration() {
        Intent intent = new Intent(this, regestration.class);
        startActivity(intent);
        }

    public void openLogin() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
        }





