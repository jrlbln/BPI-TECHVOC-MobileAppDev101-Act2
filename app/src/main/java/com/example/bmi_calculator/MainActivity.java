package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout layoutWeight, layoutHeight;
    private TextInputEditText inputWeight, inputHeight;
    private ImageView imageView;
    private TextView result1, result2;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutWeight = findViewById(R.id.layoutWeight);
        layoutHeight = findViewById(R.id.layoutHeight);
        inputWeight = findViewById(R.id.inputWeight);
        inputHeight = findViewById(R.id.inputHeight);
        imageView = findViewById(R.id.imageView);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weightStr = inputWeight.getText().toString();
                String heightStr = inputHeight.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                    double weight = Double.parseDouble(weightStr);
                    double height = Double.parseDouble(heightStr) / 100; // Convert to meters
                    double bmi = weight / (height * height);

                    result1.setText(String.format("Your BMI: %.2f", bmi));

                    // Display BMI category
                    if (bmi < 18.5) {
                        result2.setText("Underweight");
                    } else if (bmi < 25) {
                        result2.setText("Normal Weight");
                    } else if (bmi < 30) {
                        result2.setText("Overweight");
                    } else {
                        result2.setText("Obese");
                    }
                }
            }
        });
    }
}
