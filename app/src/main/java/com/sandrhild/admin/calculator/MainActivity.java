package com.sandrhild.admin.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends Activity implements OnClickListener{

    final int MenuResetId = 1;
    final int MenuQuitId = 2;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    //** Called when the activity is first created */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnSub = (Button) findViewById(R.id.btnSub);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(etNum1.getText().toString())
                ||TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (v.getId()){
        case R.id.btnAdd:
            oper = "+";
            result = num1 + num2;
            break;
        case R.id.btnSub:
            oper = "-";
            result = num1 - num2;
            break;
        case R.id.btnMult:
             oper = "*";
             result = num1 * num2;
             break;
        case R.id.btnDiv:
             oper = "/";
             result = num1 / num2;
             break;
        default:
             break;
            }
        tvResult.setText(num1 + " " + oper + " " + num2 + "" + " = " + result);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, MenuResetId, 0, "Reset");
        menu.add(0, MenuQuitId, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MenuResetId:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MenuQuitId:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    }