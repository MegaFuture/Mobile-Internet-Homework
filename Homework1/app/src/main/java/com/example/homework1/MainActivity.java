package com.example.homework1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Switch sw1 = findViewById(R.id.switch1);
        final CheckBox chbx = findViewById(R.id.chbx);
        final TextView tv1 = findViewById(R.id.tv1);
        final ImageView eu4 = findViewById(R.id.eu4);
        final ImageView icon = findViewById(R.id.icon);

        final AlertDialog ad1 = new AlertDialog.Builder(this)
                .setTitle("Switch your Rome")
                .setMessage("Byzantine")
                .setIcon(R.mipmap.logo)
                .create();

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (chbx.isChecked()) tv1.setText("Byzantine Strong!");
                    else tv1.setText("Ceddin Deden!");
                Log.d("MainActivity", "checkbox");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad1.show();
                Log.d("MainActivity", "dialog");
            }
        });

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) eu4.setVisibility(View.INVISIBLE);
                else eu4.setVisibility(View.VISIBLE);
                Log.d("MainActivity", "switch");
            }
        });

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon.setVisibility(v.INVISIBLE);
                Log.d("MainActivity", "invisible");
            }
        });

        Log.d("MainActivity", "end");
    }
}
