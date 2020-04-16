package com.example.myapplication200122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author LiuSaiSai
 * @description: SharedPreference 存储的测试，
 * 1. SharedPreference 对象的 edit() 方法 获取一个 SharedPreference.Editor对象
 * 1.1 √ √ √ Context 类中的 getSharedPreference(name,MODE_PRIVATE);
 * 1.2 Activity 类中的 getPreference(MODE_PRIVATE);
 * 1.3 PreferenceManager 中的 getDefaultSharedPreference
 * 2. 向 Editor 对象中 添加数据，putString();
 * 3. 调用 apply() 方法 将添加的数据提交；
 * @date :2020/03/06 11:31
 */
public class SharedPreferenceTest extends AppCompatActivity {

    private TextView editSharedPreferencePersist;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_test);

        editSharedPreferencePersist = findViewById(R.id.edit_shared_Preference_persistence);
        Button savePreferenceButton = findViewById(R.id.save_preference_button);
        Button restorePreferenceButton = findViewById(R.id.restore_preference_button);

        savePreferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SharedPreferenceTest.this, "SharedPreference存储", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = getSharedPreferences("SharedPreferencePersist", MODE_PRIVATE).edit();
                editor.putString("name", "我是刘优秀");
                editor.putInt("age", 25);
                editor.putBoolean("isHandsome", true);
                editor.apply();
            }
        });

        restorePreferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("SharedPreferencePersist", MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "刘赛赛");
                int age = sharedPreferences.getInt("age", 0);
                boolean isHandsome = sharedPreferences.getBoolean("isHandsome", true);
                editSharedPreferencePersist.setText("Name:" + name + "\nAge:" + age + "\nisHandsome" + isHandsome);
            }
        });
    }
}
