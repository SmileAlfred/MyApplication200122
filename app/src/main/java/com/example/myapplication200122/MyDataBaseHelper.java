package com.example.myapplication200122;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @author LiuSaiSai
 * @description: SQL 的帮助类
 * @date :2020/03/06 12:47
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {
    /**
     * real 表示浮点型
     * blob 表示二进制类型
     * primary key 将 id 设置为主键
     * autoincrement 关键字表示 id 列是自增长的
     */
    public static final String CREATE_BOOK = "create table Book (" +
            "id     integer primary key autoincrement," +
            "author  text," +
            "price   real," +
            "pages   integer," +
            "name   text)";
    public static final String CREATE_CATEGORY = "create table Category(" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)";
    private Context mContext;

    public MyDataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * 建表语句
         */
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**
         * 升级数据库
         * drop 语句，当存在 这两张表时，就删除 而后重新创建
         */
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
