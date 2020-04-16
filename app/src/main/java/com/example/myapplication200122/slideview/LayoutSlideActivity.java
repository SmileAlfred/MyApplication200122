package com.example.myapplication200122.slideview;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication200122.R;


/**
 * @author LiuSaiSai
 * @description: 实现 View 的滑动"
 * 1."layout()
 * 2. offsetLeftAndRight()+offsetTopAndBottom()
 * 3. LayoutParams(改变布局参数)
 * @date :2020/04/15 12:05
 */
public class LayoutSlideActivity extends AppCompatActivity implements View.OnClickListener {

    private LayoutSlideView mSlideViewAnimate;
    private TextView noteTitle;
    private TextView noteContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
    }

    private void findViews() {
        setContentView(R.layout.activity_layout_slide);

        mSlideViewAnimate = findViewById(R.id.slide_view_animate);
        mSlideViewAnimate.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));

        Button noteEdit = findViewById(R.id.title_edit_button);
        noteEdit.setOnClickListener(this);

        noteTitle = findViewById(R.id.layout_slide_note1);
        noteContent = findViewById(R.id.layout_slide_note2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_edit_button:
                if(noteTitle.getVisibility() == View.GONE || noteContent.getVisibility() == View.GONE){
                    noteTitle.setVisibility(View.VISIBLE);
                    noteContent.setVisibility(View.VISIBLE);
                }else{
                    noteTitle.setVisibility(View.GONE);
                    noteContent.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}
