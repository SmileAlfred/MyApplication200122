package com.example.myapplication200122;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author LiuSaiSai
 * @description: 文件存储的测试，文件存储不适合用于保存一些复杂<有格式>的 文本数据
 * 适合保存 简单文本数据 或者 二进制数据
 * @date :2020/03/06 10:25
 */
public class FilePersistenceTest extends AppCompatActivity {

    private EditText editFilePersis;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_persistence);

        editFilePersis = findViewById(R.id.edit_file_persistence);

        String restoreText = load();
        if (!TextUtils.isEmpty(restoreText)) {
            editFilePersis.setText(restoreText);
            editFilePersis.setSelection(restoreText.length());
        }
    }

    @RequiresApi(api = 15)
    private String load() {
        InputStream inputStream = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            inputStream = openFileInput("filePersistence");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            do {
                if ((line = reader.readLine()) != null) {
                    content.append(line);
                } else {
                    reader.skip(1);
                }
            } while (reader.ready());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String text = editFilePersis.getText().toString();
        save(text);
    }

    private void save(String text) {
        OutputStream outputStream = null;
        BufferedWriter writer = null;

        try {
            outputStream = openFileOutput("filePersistence", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}