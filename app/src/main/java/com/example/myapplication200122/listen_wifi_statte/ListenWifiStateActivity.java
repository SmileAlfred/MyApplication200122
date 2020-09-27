package com.example.myapplication200122.listen_wifi_statte;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication200122.R;

import java.security.PublicKey;

/**
 * @author: LiuSaiSai
 * @date: 2020/09/22 11:12
 * @description: 通过 广播 监听WiFi的连接状态
 */
public class ListenWifiStateActivity extends AppCompatActivity {

    private static final String TAG = ListenWifiStateActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_wifi_state);
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mwifiBroadcastReceiver, filter);
    }



    // 监听wifi状态广播
    private BroadcastReceiver mwifiBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                ConnectivityManager localConnectivityManager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo localNetworkInfo = (localConnectivityManager == null ? null
                        : localConnectivityManager.getActiveNetworkInfo());
                if (localNetworkInfo != null) {
                    if (localNetworkInfo.isConnected()) {
                        Log.i(TAG, "onReceive: 已连接");
                    } else {
                        Log.i(TAG, "onReceive: 断开连接");
                    }
                } else {
                    Log.i(TAG, "onReceive: WiFi 关闭" );
                }
            }
        }
    };
}
