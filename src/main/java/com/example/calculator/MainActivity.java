package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
    public void add(View view) {
        EditText firstNumEditText = findViewById(R.id.fistNumber);
        EditText secondNumEditText = findViewById(R.id.secondNumber);

        TextView exceptionView = findViewById(R.id.exceptionTextView);
        exceptionView.setText("");

        String firstValue = firstNumEditText.getText().toString();
        String secondValue = secondNumEditText.getText().toString();

        try {
            long firstNumber = Long.parseLong(firstValue);
            long secondNumber = Long.parseLong(secondValue);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("firstNumber", firstNumber);
            intent.putExtra("secondNumber", secondNumber);
            startActivity(intent);
        } catch (Exception exception) {
            exceptionView.setText("Ошибка:\nне-число");
        }
    }
}