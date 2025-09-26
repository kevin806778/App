package com.example.myapplication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view){
        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);
    }
    public void button_Click2(View view){
        Intent intent = new Intent(this, water.class);
        startActivity(intent);
    }
    public void button_Click3(View view){
        Intent intent = new Intent(this, OpActivity.class);
        startActivity(intent);
    }
    public void button_Click4(View view){
        Intent intent = new Intent(this, compass.class);
        startActivity(intent);
    }
}