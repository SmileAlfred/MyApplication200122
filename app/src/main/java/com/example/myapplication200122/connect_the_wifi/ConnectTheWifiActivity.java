package com.example.myapplication200122.connect_the_wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication200122.R;
import com.tj24.easywifi.wifi.WifiConnector;
import com.tj24.easywifi.wifi.WifiUtil;

import static com.example.myapplication200122.auto_connect_wifi.WifiAutoConnectManager.wifiManager;

/**
 * 给定 WiFi 名称和 WiFi 密码，连接的 WiFi
 */
public class ConnectTheWifiActivity extends AppCompatActivity {

    private String ssid, pwd;
    private EditText et_ssid, et_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_the_wifi);

        getConnectWifiSsid();
        et_ssid = findViewById(R.id.et_ssid);
        et_psw = findViewById(R.id.et_psw);
        ssid = et_ssid.getText().toString();
        pwd = et_psw.getText().toString();

        //2.调用其connectWifi () 方法，并在回调中写成功或者失败后的逻辑
        // WifiConnector connector = new WifiConnector(this);
        /*connector.connectWifi(ssid, pwd, WifiUtil.TYPE_WPA, new WifiConnector.WifiConnectCallBack() {
            @Override
            public void onConnectSucess() {
                Toast.makeText(ConnectTheWifiActivity.this,"连接成功！！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onConnectFail(String msg) {
                Toast.makeText(ConnectTheWifiActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });*/
    }


    private void getConnectWifiSsid() {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        Log.i(TAG, "wifiInfo.getSSID()) = " + wifiInfo.getSSID() + " ; wifiInfo.toString() = " + wifiInfo.toString());
        //return wifiInfo.getSSID();
    }


    private static final String TAG = ConnectTheWifiActivity.class.getSimpleName();

    class WifiBroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {

                case WifiManager.WIFI_STATE_CHANGED_ACTION:
                    int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_DISABLED);
                    switch (wifiState) {
                        case WifiManager.WIFI_STATE_DISABLED:
                            Log.i(TAG, "onReceive: WiFi状态 WIFI_STATE_DISABLED");
                            break;
                        case WifiManager.WIFI_STATE_ENABLED:
                            Log.i(TAG, "onReceive: WiFi状态 WIFI_STATE_ENABLED");
                            break;
                    }
                    break;
                case WifiManager.SCAN_RESULTS_AVAILABLE_ACTION:
                    break;
            }
        }
    }
}