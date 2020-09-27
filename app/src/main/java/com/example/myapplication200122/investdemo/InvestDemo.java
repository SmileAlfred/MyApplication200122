package com.example.myapplication200122.investdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication200122.R;

/**
 * @author LiuSaiSai
 * @description: 基金的demo
 * @date :2020/05/10 21:56
 */
public class InvestDemo extends AppCompatActivity {

    private TextView tv_invest;
    private Button bt_investt;
    private static final String TAG = InvestDemo.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);

        bt_investt = findViewById(R.id.bt_invest);
        tv_invest = findViewById(R.id.tv_invest);

        bt_investt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private double baseCapital = 10000.00;
    private double interest = 0.006;
    private int random = 0;

    private void calculate() {
        tv_invest.append("本金:" + baseCapital  + "\n");
        for (int i = 1; i <= 365; i++) {
            random = (int) (Math.random() * 2 + 1);
            if (random == 1) {
                baseCapital *= (1 + interest);
            } else if (random == 2) {
                baseCapital *= (1 - interest);
            } else {
                Log.i(TAG, "calculate:random = " + random);
            }
            if(baseCapital < 5000){
                tv_invest.setTextColor(Color.RED);
            }
            tv_invest.append("第" + i + "天" + "余额:" + baseCapital + "\n");
        }
    }
}
