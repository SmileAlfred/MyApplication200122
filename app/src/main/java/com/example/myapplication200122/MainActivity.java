package com.example.myapplication200122;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication200122.auto_connect_wifi.AutoConnectWifiActivity;
import com.example.myapplication200122.bestlaunchactivity.BestLaunchActivity;
import com.example.myapplication200122.connect_the_wifi.ConnectTheWifiActivity;
import com.example.myapplication200122.investdemo.InvestDemo;
import com.example.myapplication200122.listen_wifi_statte.ListenWifiStateActivity;
import com.example.myapplication200122.provider_test.ProviderTest;
import com.example.myapplication200122.slideview.LayoutSlideActivity;
import com.example.myapplication200122.tablayout_test.TabLayoutTest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bestLaunchActivity, listViewTest, bestListView, bestRecyclerView, broadcastOfflineTest, filePersistenceTest,
            sharedPreferenceTest, dataBaseTest, litePalTest, providerTest, tabLayoutTest, layoutViewSlide, auto_connect_wifi,
            connect_the_wifi,listen_wifi_state;
    private LinearLayout ll;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button invest_demo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        Log.i(TAG, "onCreate: ");
    }

    private void findViews() {
        setContentView(R.layout.activity_main);

        bestLaunchActivity = findViewById(R.id.best_launch_activity);
        listViewTest = findViewById(R.id.list_view_test);
        bestListView = findViewById(R.id.best_list_view);
        bestRecyclerView = findViewById(R.id.best_recycler_view);
        broadcastOfflineTest = findViewById(R.id.broadcast_offline_test);
        filePersistenceTest = findViewById(R.id.file_persistence_test);
        sharedPreferenceTest = findViewById(R.id.shared_preference_pers_test);
        dataBaseTest = findViewById(R.id.data_base_test);
        litePalTest = findViewById(R.id.lite_pal_test);
        providerTest = findViewById(R.id.provider_test);
        tabLayoutTest = findViewById(R.id.tab_layout_test);
        layoutViewSlide = findViewById(R.id.layout_view_slide);
        invest_demo = findViewById(R.id.invest_demo);
        auto_connect_wifi = findViewById(R.id.auto_connect_wifi);
        connect_the_wifi = findViewById(R.id.connect_the_wifi);
        listen_wifi_state = findViewById(R.id.listen_wifi_state);


        ll = findViewById(R.id.turn_ll);

        bestLaunchActivity.setOnClickListener(this);
        listViewTest.setOnClickListener(this);
        bestListView.setOnClickListener(this);
        bestRecyclerView.setOnClickListener(this);
        broadcastOfflineTest.setOnClickListener(this);
        filePersistenceTest.setOnClickListener(this);
        sharedPreferenceTest.setOnClickListener(this);
        dataBaseTest.setOnClickListener(this);
        litePalTest.setOnClickListener(this);
        providerTest.setOnClickListener(this);
        tabLayoutTest.setOnClickListener(this);
        layoutViewSlide.setOnClickListener(this);
        invest_demo.setOnClickListener(this);
        auto_connect_wifi.setOnClickListener(this);
        connect_the_wifi.setOnClickListener(this);
        listen_wifi_state.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.best_launch_activity:
                intent = new Intent(this, BestLaunchActivity.class);
                break;
            case R.id.list_view_test:
                intent = new Intent(this, ListViewTest.class);
                break;
            case R.id.best_list_view:
                intent = new Intent(this, BestListView.class);
                break;
            case R.id.best_recycler_view:
                intent = new Intent(this, BestRecyclerView.class);
                break;
            case R.id.broadcast_offline_test:
                intent = new Intent(this, BroadcastOfflineTest.class);
                break;
            case R.id.file_persistence_test:
                intent = new Intent(this, FilePersistenceTest.class);
                break;
            case R.id.shared_preference_pers_test:
                intent = new Intent(this, SharedPreferenceTest.class);
                break;
            case R.id.data_base_test:
                intent = new Intent(this, DataBaseTest.class);
                break;
            case R.id.lite_pal_test:
                intent = new Intent(this, LitePalTest.class);
                break;
            case R.id.provider_test:
                intent = new Intent(this, ProviderTest.class);
                break;
            case R.id.tab_layout_test:
                intent = new Intent(this, TabLayoutTest.class);
                break;
            case R.id.layout_view_slide:
                intent = new Intent(this, LayoutSlideActivity.class);
                break;
            case R.id.invest_demo:
                intent = new Intent(this, InvestDemo.class);
                break;
            case R.id.auto_connect_wifi:
                intent = new Intent(this, AutoConnectWifiActivity.class);
                break;
            case R.id.connect_the_wifi:
                intent = new Intent(this, ConnectTheWifiActivity.class);
                break;
            case R.id.listen_wifi_state:
                intent = new Intent(this, ListenWifiStateActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (ll.getOrientation() == LinearLayout.VERTICAL) {
                ll.setOrientation(LinearLayout.HORIZONTAL);
            }
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (ll.getOrientation() == LinearLayout.HORIZONTAL) {
                ll.setOrientation(LinearLayout.VERTICAL);
            }
        } else {
            Log.i(TAG, "onConfigurationChanged: 小朋友，你是否有很多问号？？？");
        }
    }
}
