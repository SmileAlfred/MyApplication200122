package com.example.myapplication200122;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/02/25 11:37
 */
public class BestRecyclerView extends AppCompatActivity {
    List<Fruit> mRecyclerFruits = new ArrayList<>();
    List<Fruit> mRecyclerRandomFruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initFruits(mRecyclerFruits);
        initFruits(mRecyclerRandomFruits);

        RecyclerView recyclerView = findViewById(R.id.best_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        FruitRecyclerAdapter adapter = new FruitRecyclerAdapter(mRecyclerFruits);
        recyclerView.setAdapter(adapter);

        RecyclerView waterfallView = findViewById(R.id.waterfall_view);
        StaggeredGridLayoutManager waterfallManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        waterfallView.setLayoutManager(waterfallManager);
        FruitRecyclerAdapter waterAdapter = new FruitRecyclerAdapter(mRecyclerRandomFruits);
        waterfallView.setAdapter(waterAdapter);
    }

    private void initFruits(List<Fruit> list) {
        if (list == mRecyclerFruits) {
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            for (int count = 0; count < 30; count++) {
                mRecyclerFruits.add(banana);
            }
        } else if (list == mRecyclerRandomFruits) {
            for (int count = 0; count < 30; count++) {
                Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
                banana.setFruitName(setRandomLengthName(banana));
                mRecyclerRandomFruits.add(banana);
            }
        }
    }


    private String setRandomLengthName(Fruit fruit) {
        String singleName = fruit.getFruitName();
        StringBuilder lengthName = new StringBuilder();
        int num = (int) (Math.random() * 15);
        for (int length = 0; length < num; length++) {
            lengthName.append(length + "." + singleName);
        }
        return lengthName.toString();
    }
}
