package com.example.myapplication200122.bestlaunchactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication200122.LunchActivity;
import com.example.myapplication200122.R;

/**
 * @author LiuSaiSai
 * @description: 测试 Intent传递数据
 * EditText获取数据
 * 最佳启动方式
 * 进度条
 * @date :2020/02/24 8:40
 */
public class BestLaunchActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEdit;
    private EditText passwordEdit;
    private Button okButton;
    public String name;
    public String password;
    private TextView introduceText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_launch);

        introduceText = findViewById(R.id.introduce_text);
        nameEdit = findViewById(R.id.name_edit);
        passwordEdit = findViewById(R.id.password_edit);
        okButton = findViewById(R.id.ok_button);

        introduceText.setText("\t\tIntent传递数据\n" +
                "\t\tEditText获取数据\n" +
                "\t\t最佳启动方式");
        okButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_button:
                name = nameEdit.getText().toString();
                password = passwordEdit.getText().toString();
                LunchActivity.actionStart(this, name, password);
                break;
            default:
                break;
        }
    }

}
