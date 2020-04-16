package com.example.myapplication200122.utils;

import android.app.Activity;
import android.content.Context;
import android.icu.lang.UCharacter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication200122.R;

/**
 * @author LiuSaiSai
 * @description:自定义控件 -->  标题栏;需要引用本自定义控件，就在 xml 文件中使用本类
 * @date :2020/02/25 9:45
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener {

    private final Button backButton;
    private final TextView titleText;
    private final Button editButton;

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        backButton = findViewById(R.id.back_button);
        titleText = findViewById(R.id.title_text);
        editButton = findViewById(R.id.title_edit_button);

        titleText.setText(context.getClass().getSimpleName());
        backButton.setOnClickListener(this);
        editButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                ((Activity) getContext()).finish();
                break;
            case R.id.title_edit_button:
                Toast.makeText(getContext(), "You clicked EditButton", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
