package com.example.taras.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etValue = (TextView) findViewById(R.id.textView);
    }

    double operand = 0;
    double operator = 0;
    String operation = "";


    public void firstInput(){
        if (etValue.getText().equals("input required")){ // first input
            etValue.setText("");
        }
        if(etValue.length() % 9 == 0){//if the box fills up adjust size of text
            float sizeOfText = (etValue.getTextSize() - 5.0f) / 3;
            etValue.setTextSize(sizeOfText);
            //etValue.setText(Float.toString(sizeOfText - 20.0f));
        }
    }
    public void populate(){ //populates the two variables for later calculations
        if(operation.length() > 0){
            operator = Double.parseDouble(etValue.getText().toString());
        }
        else{
            operand = Double.parseDouble(etValue.getText().toString());
        }
    }
    public void oneButtonPress(View v){//seperate method for each button for easy changes
        firstInput();
        etValue.append("1");
        populate();

    }

    public void twoButtonPress(View v){
        firstInput();
        etValue.append("2");
        populate();

    }
    public void threeButtonPress(View v){
        firstInput();
        etValue.append("3");
        populate();

    }
    public void fourButtonPress(View v){
        firstInput();
        etValue.append("4");
        populate();

    }
    public void fiveButtonPress(View v){
        firstInput();
        etValue.append("5");
        populate();

    }
    public void sixButtonPress(View v){
        firstInput();
        etValue.append("6");
        populate();

    }
    public void sevenButtonPress(View v){
        firstInput();
        etValue.append("7");
        populate();

    }
    public void eightButtonPress(View v){
        firstInput();
        etValue.append("8");
        populate();

    }
    public void nineButtonPress(View v){
        firstInput();
        etValue.append("9");
        populate();

    }
    public void zeroButtonPress(View v){
        firstInput();
        etValue.append("0");
        populate();

    }
}
