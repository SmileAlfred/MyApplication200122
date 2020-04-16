package com.example.myapplication200122;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/02/24 12:42
 */
public class ListViewTest extends AppCompatActivity {

    private List<Integer> randomList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.random_list_view);
        createRandom(randomList, 50);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, randomList);
        listView.setAdapter(adapter);

    }

    private void createRandom(List<Integer> randomList, int count) {
        Integer num;
        for (int nowCount = 0; nowCount < count; nowCount++) {
            num = (int) (Math.random() * 100);
            randomList.add(num);
        }
    }
}
