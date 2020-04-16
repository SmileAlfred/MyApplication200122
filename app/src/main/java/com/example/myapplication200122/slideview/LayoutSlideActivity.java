package com.example.myapplication200122.slideview;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication200122.R;


/**
 * @author LiuSaiSai
 * @description:  实现 View 的滑动"
 * 1."layout()
 * 2. offsetLeftAndRight()+offsetTopAndBottom()
 * 3. LayoutParams(改变布局参数)
 * @date :2020/04/15 12:05
 */
public class LayoutSlideActivity extends AppCompatActivity {

    private LayoutSlideView mSlideViewAnimate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_slide);
        mSlideViewAnimate = findViewById(R.id.slide_view_animate);
        mSlideViewAnimate.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
    }
}
