package com.example.myapplication200122;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * @author LiuSaiSai
 * @description: .getView() 方法，当 item 从下面被划出来时，加载新出现的view
 * 该方法中 convertView 参数 用于缓存之前加载好的布局.——优化一
 * .getView() 方法每次运行都会 .findViewById() ;——优化二
 * @date :2020/02/25 10:20
 */
public class FruitArrayAdapter extends ArrayAdapter {
    private int resourceId;
    private FruitArrayAdapter.viewHolder viewHolder;

    public FruitArrayAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new viewHolder();
            viewHolder.FruitImageView = view.findViewById(R.id.item_list_image_view);
            viewHolder.FruitNameView = view.findViewById(R.id.item_list_name_view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (FruitArrayAdapter.viewHolder) view.getTag();
        }
        viewHolder.FruitImageView.setImageResource(fruit.getImageId());
        viewHolder.FruitNameView.setText(fruit.getFruitName());
        return view;
    }

    private class viewHolder {
        ImageView FruitImageView;
        TextView FruitNameView;
    }
}
