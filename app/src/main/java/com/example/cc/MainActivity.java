package com.example.cc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        private EditText editTextNumber1, editTextNumber2;
        private TextView resultTextView;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            editTextNumber1 = findViewById(R.id.editTextNumber1);
            editTextNumber2 = findViewById(R.id.editTextNumber2);
            resultTextView = findViewById(R.id.resultTextView);

            Button buttonAdd = findViewById(R.id.buttonAdd);
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('+');
                }
            });

            Button buttonSubtract = findViewById(R.id.buttonSubtract);
            buttonSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('-');
                }
            });

            Button buttonMultiply = findViewById(R.id.buttonMultiply);
            buttonMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('*');
                }
            });

            Button buttonDivide = findViewById(R.id.buttonDivide);
            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('/');
                }
            });
        }

    private void calculateResult(char operation) {
        String number1Str = editTextNumber1.getText().toString();
        String number2Str = editTextNumber2.getText().toString();

        if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
            double number1 = Double.parseDouble(number1Str);
            double number2 = Double.parseDouble(number2Str);

            double result = 0;

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        resultTextView.setText("Tidak bisa dibagi dengan nol!");
                        return;
                    }
                    break;
            }

            resultTextView.setText("Hasil: " + result);
        } else {
            resultTextView.setText("Masukkan kedua angka!");
        }
    }
}