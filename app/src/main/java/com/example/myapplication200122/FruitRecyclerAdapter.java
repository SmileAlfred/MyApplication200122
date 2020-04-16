package com.example.myapplication200122;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/02/25 12:04
 */
public class FruitRecyclerAdapter extends RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder> {

    private List<Fruit> recyclerFruits = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView recyclerFruitImage;
        TextView recyclerFruitName;

        public ViewHolder(View view) {  //该参数通常是 子项的最外层，以便于 .findViewById()
            super(view);
            recyclerFruitImage = view.findViewById(R.id.recycler_item_image_view);
            recyclerFruitName = view.findViewById(R.id.recycler_item_name_view);
        }
    }

    public FruitRecyclerAdapter(List<Fruit> fruits) {
        recyclerFruits = fruits;
    }

    /**
     * 用于创建 viewHolder实例
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 对 recyclerView 子项进行赋值
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = recyclerFruits.get(position);
        holder.recyclerFruitImage.setImageResource(fruit.getImageId());
        holder.recyclerFruitName.setText(fruit.getFruitName());
    }

    @Override
    public int getItemCount() {
        return recyclerFruits.size();
    }
}