package com.example.myapplication200122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication200122.bestlaunchactivity.BestLaunchActivity;
import com.example.myapplication200122.provider_test.ProviderTest;
import com.example.myapplication200122.slideview.LayoutSlideActivity;
import com.example.myapplication200122.slideview.LayoutSlideView;
import com.example.myapplication200122.tablayout_test.TabLayoutTest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bestLaunchActivity;
    private Button listViewTest;
    private Button bestListView;
    private Button bestRecyclerView;
    private Button broadcastOfflineTest;
    private Button filePersistenceTest;
    private Button sharedPreferenceTest;
    private Button dataBaseTest;
    private Button litePalTest;
    private Button providerTest;
    private Button tabLayoutTest;
    private Button layoutViewSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
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
            default:
                break;
        }
        startActivity(intent);
    }
}
