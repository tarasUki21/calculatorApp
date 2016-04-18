package com.example.taras.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    TextView etValue = (TextView) findViewById(R.id.textView);
    double operand = 0;
    double operator = 0;
    String operation = "";


    public void firstInput(){
        if (etValue.getText().equals("input required")){
            etValue.setText("");
        }
    }
    public void populate(){
        if(operation.length() > 0){
            operator = Double.parseDouble(etValue.getText().toString());
        }
        else{
            operand = Double.parseDouble(etValue.getText().toString());
        }
    }
    public void oneButtonPress(){
        firstInput();
        etValue.append("1");
        populate();

    }

    public void twoButtonPress(){
        firstInput();
        etValue.append("2");
        populate();

    }
    public void threeButtonPress(){
        firstInput();
        etValue.append("3");
        populate();

    }
    public void fourButtonPress(){
        firstInput();
        etValue.append("4");
        populate();

    }
    public void fiveButtonPress(){
        firstInput();
        etValue.append("5");
        populate();

    }
    public void sixButtonPress(){
        firstInput();
        etValue.append("6");
        populate();

    }
    public void sevenButtonPress(){
        firstInput();
        etValue.append("7");
        populate();

    }
    public void eightButtonPress(){
        firstInput();
        etValue.append("8");
        populate();

    }
    public void nineButtonPress(){
        firstInput();
        etValue.append("9");
        populate();

    }
    public void zeroButtonPress(){
        firstInput();
        etValue.append("0");
        populate();

    }
}
