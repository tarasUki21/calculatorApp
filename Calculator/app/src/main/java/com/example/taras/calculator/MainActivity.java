package com.example.taras.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etValue, answerVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValue = (TextView) findViewById(R.id.textView);
        answerVal = (TextView) findViewById(R.id.textView2);
    }

    double operandA = 0;
    double operandB = 0;
    String operation = "";
    double product = 0;
    boolean toggle = false; //switch between populating operandA(false) and operandB(true)

    public void firstInput() {
        if (etValue.getText().equals("Input Required")) { // first input
            etValue.setText("");
        }

        if (etValue.length() % 6 == 0) {//if the box fills up adjust size of text
            if (etValue.getTextSize() > 100) {
                float sizeOfText = (etValue.getTextSize() - 20.0f) / 3;

                etValue.setTextSize(sizeOfText);
            }
        }

    }

    public void populate() { //populates the two variables for later calculations
        if (!toggle) {
            operandA = Double.parseDouble(etValue.getText().toString());
        } else {
            operandB = Double.parseDouble(etValue.getText().toString());
        }
    }

    public void genButtonPress(View v) {//number button press
        firstInput();
        etValue.append(((Button) v).getText());
        populate();

    }
    //TODO: make multiple operations possible with one = press eg.(5+6+3=14)
    //TODO: have history for equations
    //TODO: make everything display in top bar
    //TODO: delete button
    public void opButtonPress(View v) {//operation button
        operation = ((Button) v).getText().toString();
        etValue.setText("");
        toggle = true;

    }

    public void equButtonPress(View v) {
        if (operation.equals("+")) {
            product = operandA + operandB;
            answerVal.setText(Double.toString(product));
        } else if (operation.equals("-")) {
            product = operandA - operandB;
            answerVal.setText(Double.toString(product));
        } else if (operation.equals("*")) {
            product = operandA * operandB;
            answerVal.setText(Double.toString(product));
        } else if (operation.equals("/")) {
            product = operandA / operandB;
            answerVal.setText(Double.toString(product));
        }
        etValue.setText("");
        toggle = false;
    }
}
