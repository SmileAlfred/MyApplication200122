package com.example.myapplication200122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LunchActivity extends AppCompatActivity {

    public static TextView passwordText;
    public static TextView nameText;
    private TextView codeText;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        nameText = (TextView) findViewById(R.id.name_text);
        passwordText = (TextView) findViewById(R.id.password_text);
        codeText = (TextView) findViewById(R.id.code_text);
        progressBar = findViewById(R.id.progress_horizontal);

        Button showButton = (Button) findViewById(R.id.show_button);
        showButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                nameText.append(intent.getStringExtra("name"));
                passwordText.append(intent.getStringExtra("password"));

                codeText.setText(
                        "public class BestLaunchActivity extends AppCompatActivity implements View.OnClickListener {\n                ......\n" +
                                "                name = nameEdit.getText().toString();\n" +
                                "                password = passwordEdit.getText().toString();\n" +
                                "                LunchActivity.actionStart(this, name, password);\n" +
                                "\npublic class LunchActivity extends AppCompatActivity {\n                ......\n" +
                                "                Intent intent = getIntent();\n" +
                                "                nameText.append(intent.getStringExtra(\"name\"));" +
                                "                passwordText.append(intent.getStringExtra(\"password\"));\n" +
                                "\npublic static void actionStart(Context context, String name, String password) {\n" +
                                "        Intent intent = new Intent(context, LunchActivity.class);\n" +
                                "        intent.putExtra(\"name\", name);\n" +
                                "        intent.putExtra(\"password\", password);\n" +
                                "        context.startActivity(intent);\n" +
                                "    }");
                // 循环操作为耗时操作，一定要新建线程，不然会ANR；
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i <= 1000; i++) {
                            progressBar.setProgress(i);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }

    public static void actionStart(Context context, String name, String password) {
        Intent intent = new Intent(context, LunchActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("password", password);
        context.startActivity(intent);
    }
}
