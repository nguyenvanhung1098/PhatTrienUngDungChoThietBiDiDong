package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import  android.widget.Button;
import  android.widget.EditText;
import android.widget.AutoCompleteTextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<String> items;
    ArrayAdapter<String> adapter;
    String [] words = {"VND", "USD", "JPY", "KRW", "EUR", "CNY", "SGD", "RUB", "THB"};
    float [] tyGia = {1, 23339, 217 ,19 , 25380, 3300, 16416 , 315, 717};

    private Button btnConvert;
    private Button btnClear;
    private Button btnExit;
    private EditText edtInput;
    private  TextView tvResult;
    private AutoCompleteTextView autoCompleteTvFrom;
    private AutoCompleteTextView autoCompleteTvTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        items = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i ++ )
            items.add("Item" + (i +1));

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                words);

        AutoCompleteTextView autoCompleteTvFrom = findViewById(R.id.autoCompleteTvFrom);
        autoCompleteTvFrom.setAdapter(adapter);
        AutoCompleteTextView autoCompleteTvTo = findViewById(R.id.autoCompleteTvTo);
        autoCompleteTvTo.setAdapter(adapter);
        btnConvert.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    public void initWidget(){
        btnClear = (Button)findViewById(R.id.btnClear);
        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnExit = (Button)findViewById(R.id.btnExit);
        edtInput = (EditText)findViewById(R.id.edtInput);
        tvResult = (TextView)findViewById(R.id.tvResult);
        autoCompleteTvFrom = (AutoCompleteTextView)findViewById(R.id.autoCompleteTvFrom);
        autoCompleteTvTo = (AutoCompleteTextView)findViewById(R.id.autoCompleteTvTo);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnExit){
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if(v.getId() == R.id.btnClear){
            autoCompleteTvFrom.setText("");
            autoCompleteTvTo.setText("");
            edtInput.setText("");
            tvResult.setText("");
            edtInput.requestFocus();
        }
        else if(v.getId() == R.id.btnConvert){
            String textFrom = autoCompleteTvFrom.getText().toString();
            String textTo = autoCompleteTvTo.getText().toString();
            if(textFrom.equals("")){
                autoCompleteTvFrom.requestFocus();
            }
            if(textTo.equals("")){
                autoCompleteTvTo.requestFocus();
            }
            int indexFrom =0;
            int indexTo = 0;
            for(int i = 0 ;  i < words.length ; i++){
                if(words[i].equals(textFrom))
                    indexFrom = i;
                if(words[i].equals(textTo))
                    indexTo=i;
            }
            if(indexFrom == 0)
                autoCompleteTvFrom.requestFocus();
            else if(indexTo == 0)
                autoCompleteTvTo.requestFocus();
            try {
                float inputNumber = Float.parseFloat(edtInput.getText().toString());
                float kq = inputNumber * tyGia[indexFrom] / tyGia[indexTo];

                DecimalFormat result = new DecimalFormat("###,###,###,###,###.000000");
                tvResult.setText("");
                if(kq < 1)
                    tvResult.append("0");
                tvResult.append(result.format(kq)+ "");
                tvResult.append(" ");
                tvResult.append(textTo);
                edtInput.requestFocus();
            }catch (Exception e){
                edtInput.requestFocus();
            }
        }
    }
}
