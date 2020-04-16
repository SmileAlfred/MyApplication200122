package com.example.myapplication200122.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication200122.BroadcastOfflineTest;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/02/26 10:46
 */
public class BaseActivity extends AppCompatActivity {

    private OfflineBroadcastReceiver myReceiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityCollector.addActivity(this);
    }

    /**
     * 广播接收器应该创建在  方法中，生命周期使然，只有在栈顶的界面才会有这个广播接收器；不是栈顶是要及时解除
     */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.myapplication200122.BroadcastOfflineTest.OFF_LINE");
        myReceiver = new OfflineBroadcastReceiver();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(this);
    }

    /**
     * 广播接收器 写在外面，并且在 .onReceive() 方法中写处理逻辑；
     * 注意！dialog 的 builder 最后要 .show()
     */
    class OfflineBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("你的账号在别处登录，请重新登录");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    Intent returnLoginIntent = new Intent(context, BroadcastOfflineTest.class);
                    context.startActivity(returnLoginIntent);
                }
            });
            builder.show();
        }
    }
}
