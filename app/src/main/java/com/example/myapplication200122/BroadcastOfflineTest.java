package com.example.myapplication200122;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication200122.utils.BaseActivity;
import com.google.android.material.textfield.TextInputLayout;

/**
 * @author LiuSaiSai
 * @description:利用广播实现 强制下线功能
 * @date :2020/02/26 10:45
 */
public class BroadcastOfflineTest extends BaseActivity implements View.OnClickListener {

    private Button loginButton;
    private TextInputLayout passwordTIL;
    private TextInputLayout accountTIL;
    private CheckBox rememberMe;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_login);

        accountTIL = findViewById(R.id.account_til);
        passwordTIL = findViewById(R.id.password_til);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(this);

        rememberMe = findViewById(R.id.remember_checkbox);
        /**
         * 重新回到 登录页 时，要判断 是否填充文本
         */
        preferences = getSharedPreferences("RememberMe", MODE_PRIVATE);

        boolean isRemember = preferences.getBoolean("isRemember", false);
        if (isRemember) {
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            passwordTIL.getEditText().setText(password);
            accountTIL.getEditText().setText(account);
            rememberMe.setChecked(isRemember);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                String account = accountTIL.getEditText().getText().toString();
                String password = passwordTIL.getEditText().getText().toString();
                if (account.equals("admin") && password.equals("123456")) {
                    /**
                     * 设置 记住密码 的操作
                     */
                    SharedPreferences.Editor editor = preferences.edit();
                    if (rememberMe.isChecked()) {
                        editor.putString("account", account);
                        editor.putString("password", password);
                        editor.putBoolean("isRemember", rememberMe.isChecked());
                    } else {
                        editor.clear();
                    }
                    editor.apply();

                    passwordTIL.setErrorEnabled(false);
                    accountTIL.setErrorEnabled(false);
                    Toast.makeText(BroadcastOfflineTest.this, "登陆成功", Toast.LENGTH_SHORT).show();

                    Intent loginIntent = new Intent(BroadcastOfflineTest.this, BroadcastOfflineSend.class);
                    startActivity(loginIntent);
                } else {
                    //Toast.makeText(BroadcastOfflineTest.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                    passwordTIL.setErrorEnabled(true);
                    passwordTIL.setError("账号或密码错误");
                }
                break;
            default:
                break;
        }
    }
}
