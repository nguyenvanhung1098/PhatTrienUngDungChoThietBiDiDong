package com.example.calculater_project;

import android.graphics.Path;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import  android.widget.Button;
import  android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private TextView tvInput;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnNum0;

    private Button btnSub;
    private Button btnAdd;
    private Button btnMul;
    private Button btnDiv;
    private Button btnKq;
    private Button btnAdd_Sub;
    private  Button btnDot;
    private Button btnCE;
    private Button btnC;
    private Button btnBS;

    private  final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickView();
        Typeface tf = Typeface.createFromAsset(getAssets(), "digitalregular.ttf");
        tvResult.setTypeface(tf);
        tvInput.setTypeface(tf);
    }

    public void initWidget(){
        btnNum0 = (Button)findViewById(R.id.btnNum0);
        btnNum1 = (Button)findViewById(R.id.btnNum1);
        btnNum2 = (Button)findViewById(R.id.btnNum2);
        btnNum3 = (Button)findViewById(R.id.btnNum3);
        btnNum4 = (Button)findViewById(R.id.btnNum4);
        btnNum5 = (Button)findViewById(R.id.btnNum5);
        btnNum6 = (Button)findViewById(R.id.btnNum6);
        btnNum7 = (Button)findViewById(R.id.btnNum7);
        btnNum8 = (Button)findViewById(R.id.btnNum8);
        btnNum9 = (Button)findViewById(R.id.btnNum9);

        btnSub = (Button)findViewById(R.id.btnSub);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnKq = (Button)findViewById(R.id.btnKq);
        btnAdd_Sub = (Button)findViewById(R.id.btnAdd_Sub);

        btnCE = (Button)findViewById(R.id.btnCE);
        btnC = (Button)findViewById(R.id.btnC);
        btnBS = (Button)findViewById(R.id.btnBS);
        btnDot = (Button)findViewById(R.id.btnDot);
        tvResult = (TextView)findViewById(R.id.tvResult);
        tvInput = (TextView)findViewById(R.id.tvInput);
    }

    public void setEventClickView(){
        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);

        btnSub.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnAdd_Sub.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnKq.setOnClickListener(this);

    }
    @Override

    public void onClick(View v) {
        try {
            switch (v.getId()){
                case R.id.btnNum0:
                    tvInput.append("0");
                    break;
                case R.id.btnNum1:
                    tvInput.append("1");
                    break;
                case R.id.btnNum2:
                    tvInput.append("2");
                    break;
                case R.id.btnNum3:
                    tvInput.append("3");
                    break;
                case R.id.btnNum4:
                    tvInput.append("4");
                    break;
                case R.id.btnNum5:
                    tvInput.append("5");
                    break;
                case R.id.btnNum6:
                    tvInput.append("6");
                    break;
                case R.id.btnNum7:
                    tvInput.append("7");
                    break;
                case R.id.btnNum8:
                    tvInput.append("8");
                    break;
                case R.id.btnNum9:
                    tvInput.append("9");
                    break;

                case R.id.btnAdd:
                    String strAdd = addOperator(tvInput.getText().toString(),"+");
                    tvInput.setText(strAdd);
                    break;

                case R.id.btnSub:
                    String strSub = addOperator(tvInput.getText().toString(),"-");
                    tvInput.setText(strSub);
                    break;

                case R.id.btnMul:
                    String strMul = addOperator(tvInput.getText().toString(),"x");
                    tvInput.setText(strMul);
                    break;

                case R.id.btnDiv:
                    String strSDiv = addOperator(tvInput.getText().toString(),"/");
                    tvInput.setText(strSDiv);
                    break;

                case R.id.btnAdd_Sub:
                    tvInput.append("-");
                    break;
                case R.id.btnDot:
                    tvInput.append(".");
                    break;

                case R.id.btnKq:
                    addOperation(tvInput.getText().toString());
                    addNumber(tvInput.getText().toString());
                    double result = 0.0;

                        for ( int i = 0 ; i < (arrNumber.size() -1 ); i++){
                            switch (arrOperation.get(i)){
                                case "+":
                                    if(i == 0){
                                        result = arrNumber.get(i) + arrNumber.get( i + 1 );
                                    }
                                    else {
                                        result = result + arrNumber.get(i + 1);
                                    }
                                    break;
                                case "-":
                                    if(i == 0){
                                        result = arrNumber.get(i) - arrNumber.get( i + 1 );
                                    }
                                    else {
                                        result = result - arrNumber.get(i + 1);
                                    }
                                    break;
                                case "x":
                                    if(i == 0){
                                        result = arrNumber.get(i) * arrNumber.get( i + 1 );
                                    }
                                    else {
                                        result = result * arrNumber.get(i + 1);
                                    }
                                    break;
                                case "/":
                                    if(i == 0){
                                        result = arrNumber.get(i) / arrNumber.get( i + 1 );
                                    }
                                    else {
                                        result = result / arrNumber.get(i + 1);
                                    }
                                    break;
                            }
                        }
                    tvResult.setText("= " + Double.toString(result));
                    break;

                case R.id.btnCE:
                    tvInput.setText("");
                    tvResult.setText("");
                    break;
                case R.id.btnC:
                    String subStr = delleteNumber(tvInput.getText().toString());
                    tvInput.setText(subStr);
                    break;

                case R.id.btnBS:
                    String subStrBs = delleteNumber(tvInput.getText().toString());
                    tvInput.setText(subStrBs);
                    break;
            }
        } catch (Exception e) {
            Log.d(TAG, "onClick: " + e);
        }
    }

    public String delleteNumber(String number){
        int length = number.length();
        if(length == 0)
            return number;
        String subStr = number.substring(0,length-1);
        return subStr;
    }

    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;

    // lay tat ca cac phep tinh dua vao mang arrOperation
    public int addOperation(String input){
        arrOperation = new ArrayList<>();
        char[] arrInput = input.toCharArray();
        for (int i = 0 ; i < arrInput.length; i++){
            switch (arrInput[i]) {
                case '+':
                    arrOperation.add(arrInput[i] + "");
                    break;
                case '-':
                    arrOperation.add(arrInput[i] + "");
                    break;
                case 'x':
                    arrOperation.add(arrInput[i] + "");
                    break;
                case '/':
                    arrOperation.add(arrInput[i] + "");
                    break;
                default:
                    break;
            }
        }

        return 0;
    }

    // lay tat ca cac so dua vao mang arrNumber
    public  void addNumber(String input){
        arrNumber = new ArrayList<>();
        int start = 0 ;
        int length = input.length();
        char c;
        for(int i = 0 ; i < length ; i ++){
            c = input.charAt(i);
            if(c == '+' || c == '-' || c == 'x' || c == '/'){
                String number = input.substring(start, i);
                arrNumber.add(Double.parseDouble(number));
                start = i+ 1;
            }
        }
        String number = input.substring(start, length);
        arrNumber.add(Double.parseDouble(number));
    }

    public String addOperator(String str, String operator){
        int length = str.length();
        if(length == 0){
            String subStr = "0";
            subStr += operator;
            return subStr;
        }
        if(str.charAt(length -1 ) == '+' || str.charAt(length -1 ) == '-' ||
           str.charAt(length -1 ) == 'x' || str.charAt(length -1 ) == '/'  ){
            String subStr = str.substring(0,length-1) + operator;
            Log.d(TAG, "addOperator: " + subStr);
            return subStr;
        }
        else{
            String subStr = str + operator ;
            //Log.d(TAG, "addOperator: " + subStr);
            return subStr;
        }
    }
}




