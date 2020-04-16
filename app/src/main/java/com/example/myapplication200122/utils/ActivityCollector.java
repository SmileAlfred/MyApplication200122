package com.example.myapplication200122.utils;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/02/26 10:47
 */
public class ActivityCollector {
    public static List<AppCompatActivity> activities = new ArrayList<>();

    public static void addActivity(AppCompatActivity AppCompatActivity) {
        activities.add(AppCompatActivity);
    }

    public static void remove(AppCompatActivity AppCompatActivity) {
        activities.remove(AppCompatActivity);
    }

    public static void finishAll() {
        for (AppCompatActivity appCompatActivity : activities) {
            if (!appCompatActivity.isFinishing()) {
                appCompatActivity.finish();
            }
        }
    }
}
