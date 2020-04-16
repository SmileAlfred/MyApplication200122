package com.example.myapplication200122;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author LiuSaiSai
 * @description: URI 的格式：
 * "content://com.example.app.provider/table1"
 * "content://com.example.app.provider/table/1"
 * @date :2020/03/07 11:27
 */
public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;

    public static final int TABLE1_ITEM = 1;

    public static final int TABLE2_DIR = 2;

    public static final int TABLE2_ITEM = 3;

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.myapplication200122.provider", "table1", TABLE1_DIR);
        uriMatcher.addURI("com.example.myapplication200122.provider", "table1#", TABLE1_ITEM);
        uriMatcher.addURI("com.example.myapplication200122.provider", "table2", TABLE2_DIR);
        uriMatcher.addURI("com.example.myapplication200122.provider", "table2#", TABLE2_ITEM);
    }

    /**
     * 初始化时 调用；完成数据库的创建和升级
     *
     * @return true : 创建成功
     */
    @Override
    public boolean onCreate() {
        return false;
    }

    /**
     * 从内容提供器中查询数据
     *
     * @param uri           查询哪张表？
     * @param projection    哪些列？
     * @param selection     哪些行
     * @param selectionArgs 哪些行
     * @param sortOrder     对结果进行排序
     * @return 返回 Cursor 对象
     */
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                /**
                 * 查询 table1 表中的所有数据
                 */
                break;
            case TABLE1_ITEM:
                /**
                 * 查询 table1 表中的单条数据
                 */
                break;
            case TABLE2_DIR:
                /**
                 * 查询 table2 表中的所有数据
                 */
                break;
            case TABLE2_ITEM:
                /**
                 * 查询 table2 表中的单条数据
                 */
                break;
            default:
                break;
        }
        return null;
    }

    /**
     * 根据传入的 内容 URI 来返回 MIME 类型
     * MIME 有具体格式：见第一行代码Ⅱ P264下
     *
     * @param uri
     * @return
     */
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.myapplication200122.provider.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.myapplication200122.provider.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.myapplication200122.provider.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.myapplication200122.provider.table2";
            default:
                break;
        }
        return null;
    }

    /**
     * 向内容提供器中添加一条数据
     *
     * @param uri 表；带天际的数据保存在 values 参数中
     * @return 发挥一个 用于表示新记录的 URI
     */
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    /**
     * 从内容提供中 删除数据
     *
     * @param uri           那张表中的数据
     * @param selection     行
     * @param selectionArgs
     * @return 被删除的  行数  返回
     */
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    /**
     * 更新已有数据
     *
     * @param uri           表，
     * @param values        新数据保存在 values 中。
     * @param selection     行
     * @param selectionArgs
     * @return 受约束的 行数 将返回
     */
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
