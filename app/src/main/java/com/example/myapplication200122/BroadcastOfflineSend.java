package com.example.myapplication200122;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.myapplication200122.utils.BaseActivity;

/**
 * @author LiuSaiSai
 * @description: .onCreate() 一定要用一个参数的
 * @date :2020/02/26 11:09
 */
public class BroadcastOfflineSend extends BaseActivity implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_offline_send);

        Button offlineSendButton = findViewById(R.id.offline_send_button);
        offlineSendButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.offline_send_button:
                //动态发送 下线 广播
                Intent intent = new Intent("com.example.myapplication200122.BroadcastOfflineTest.OFF_LINE");
                sendBroadcast(intent);
                break;
            default:
                break;
        }
    }
}
