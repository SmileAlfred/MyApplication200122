package com.example.myapplication200122;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description:水果的 list view 测试；.onCreate() 方法要用一个参数的！
 * listview 点击事件的 实现 .setOnItemClickListener()
 * @date :2020/02/25 9:39
 */
public class BestListView extends AppCompatActivity {
    private List<Fruit> fruitsList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        initFruitData();
        FruitArrayAdapter adapter = new FruitArrayAdapter(BestListView.this, R.layout.fruit_list_item, fruitsList);
        ListView fruitListView = findViewById(R.id.fruit_list_view);
        fruitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = fruitsList.get(position).getFruitName();
                Toast.makeText(BestListView.this, "这是第" + position +1 + "个" + name, Toast.LENGTH_SHORT).show();
            }
        });
        fruitListView.setAdapter(adapter);
    }

    private void initFruitData() {
        Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
        for (int count = 0; count < 20; count++) {
            fruitsList.add(apple);
        }
    }
}
