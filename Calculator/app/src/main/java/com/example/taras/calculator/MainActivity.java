package com.example.taras.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
    String product;
    boolean swap = false;
    boolean toggle = false; //checks if there are two operations in a row(second invalid)
    String input = "";
    List<String> history = new ArrayList<String>();
    int inputCount= 0;

    public void firstInput() {
        if (etValue.getText().equals("Input Required")) { // first input
            etValue.setText("");
        }

        if (etValue.length() % 6 == 0 && etValue.getTextSize() > 100 ) {//if the box fills up adjust size of text
                float sizeOfText = (etValue.getTextSize() - 20.0f) / 3;

                etValue.setTextSize(sizeOfText);
        }

    }


    public void genButtonPress(View v) {
        firstInput();
        input = input + ((Button) v).getText();
        etValue.append(((Button) v).getText());
        toggle = false;//operation can be

    }
    public void delButtonPress(View v){
        if(etValue.length() > 0 && input.length() > 1) {
            if(input.charAt(input.length()-1) == ' '){ // operation consists of 3 characters
                input = input.substring(0, input.length() - 3);
                etValue.setText(etValue.getText().subSequence(0, etValue.length() - 3));
            }
            else {
                input = input.substring(0, input.length() - 1);//normal digit
                etValue.setText(etValue.getText().subSequence(0, etValue.length() - 1));
            }
        }
        else if(etValue.length() == 1 && input.length() == 1){//last character
            input = "";
            etValue.setText("");
        }
    }

    public void opButtonPress(View v) {
        if(!toggle) {
            operation = ((Button) v).getText().toString();
            etValue.append(" " + operation + " ");
            input = input + " " + operation + " ";
            toggle = true;//cannot have two operations in a row
        }
    }
    public String solve(String equation){
        char inputChar;
        String temp = "";
        if(equation.contains("+")){
            for(int i = 0; i < equation.length(); i++){
                inputChar = equation.charAt(i);
                if(inputChar == '('){// needs button
                    equation = equation.substring(0,i) + solve(equation.substring(i, equation.indexOf(")"))) + equation.substring(equation.indexOf(")"));
                }
                if(Character.isDigit(inputChar)|| inputChar == '.'){
                    temp = "" + inputChar;
                    while(Character.isDigit(equation.charAt(i)) && i<equation.length()-1 || equation.charAt(i) =='.'){ //get full digit
                        i++;
                        temp = temp + equation.charAt(i);
                    }
                    if(!swap){
                        operandA = Double.valueOf(temp);
                        temp = "";
                        Log.i("populated A", "" + operandA);
                    }
                    else{
                        swap = false;
                        operandB = Double.valueOf(temp);
                        temp = "";
                        Log.i("populated B", "" + operandB);
                        if (operation.contentEquals("+")) {
                            Log.i("reached", "");
                            return solve(Double.toString(operandA + operandB) + input.substring(i));
                        } else if (operation.contentEquals("-")) {
                            return solve(Double.toString(operandA - operandB) + input.substring(i));
                        } else if (operation.contentEquals("*")) {
                            return solve(Double.toString(operandA * operandB) + input.substring(i));
                        } else if (operation.contentEquals("/")) {
                            return solve(Double.toString(operandA / operandB) + input.substring(i));
                        }


                    }
                    Log.i("char at the end is",""+ equation.charAt(i));
                }
                else if (!Character.isDigit(inputChar) && equation.charAt(i) != ' '){
                    operation = "" + equation.charAt(i);
                    swap = true;
                    Log.i("populated op", "" + operation);
                }
            }
        }
    return equation;









    }
    public void equButtonPress(View v) {
        product = solve(input);
        history.add(answerVal.getText().toString());
        inputCount++;
        answerVal.setText(product);
        etValue.setText("");
        input = "";
        toggle = false;
    }
}
