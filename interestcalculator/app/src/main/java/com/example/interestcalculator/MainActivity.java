package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrincipal, editTextRate, editTextTime;
    private Button btnCalculateSimpleInterest, btnCalculateCompoundInterest;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrincipal = findViewById(R.id.editTextPrincipal);
        editTextRate = findViewById(R.id.editTextRate);
        editTextTime = findViewById(R.id.editTextTime);
        btnCalculateSimpleInterest = findViewById(R.id.btnCalculateSimpleInterest);
        btnCalculateCompoundInterest = findViewById(R.id.btnCalculateCompoundInterest);
        textViewResult = findViewById(R.id.textViewResult);

        btnCalculateSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSimpleInterest();
            }
        });

        btnCalculateCompoundInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCompoundInterest();
            }
        });
    }

    private void calculateSimpleInterest() {
        double principal = Double.parseDouble(editTextPrincipal.getText().toString());
        double rate = Double.parseDouble(editTextRate.getText().toString());
        double time = Double.parseDouble(editTextTime.getText().toString());

        double simpleInterest = (principal * rate * time) / 100;
        textViewResult.setText("Simple Interest: " + simpleInterest);
    }

    private void calculateCompoundInterest() {
        double principal = Double.parseDouble(editTextPrincipal.getText().toString());
        double rate = Double.parseDouble(editTextRate.getText().toString());
        double time = Double.parseDouble(editTextTime.getText().toString());

        double compoundInterest = principal * Math.pow((1 + rate / 100), time) - principal;
        textViewResult.setText("Compound Interest: " + compoundInterest);
    }
}
