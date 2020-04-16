package com.example.myapplication200122.tablayout_test;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication200122.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description: 实现滑动选项卡;
 * 设定标题内容;
 * 创建相应的 TabLayout 和 Fragment，
 * 设置 ViewPager 适配器和 TabLayout 适配器，
 * 将TabLayout和ViewPager关联起来
 * 不足：滑动页面时，字体颜色不随之改变；
 * @date :2020/04/14 11:06
 */
public class TabLayoutTest extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        mViewPager = findViewById(R.id.tab_viewpager);
        initViewPager();
    }

    private void initViewPager() {
        mTabLayout = findViewById(R.id.tabs);

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("要闻");
        titles.add("新思想");
        titles.add("北京");
        titles.add("综合");
        titles.add("直播中国");

        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListFragment());
        }
        /**
         * 自定义的 adapter
         */
        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);

        /**
         * 给 ViewPager 设置适配器
         */
        mViewPager.setAdapter(mFragmentAdapter);
        /**
         * 将 TabLayout 和 ViewPager 关联起来
         */
        mTabLayout.setupWithViewPager(mViewPager);
        /**
         * 给 TabLayout 设置适配器
         */
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);
    }
}
