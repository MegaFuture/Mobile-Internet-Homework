package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.homework2.Exercise1.Exercise1;
import com.example.homework2.Exercise2.Exercise2;
import com.example.homework2.Exercise3.Exercise3;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_ex1).setOnClickListener(this);
        findViewById(R.id.btn_ex2).setOnClickListener(this);
        findViewById(R.id.btn_ex3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()) {
           case R.id.btn_ex1:
               startActivity(new Intent(this, Exercise1.class));
               break;
           case R.id.btn_ex2:
               startActivity(new Intent(this, Exercise2.class));
               break;
           case R.id.btn_ex3:
               startActivity(new Intent(this, Exercise3.class));
               break;
       }
    }
}
