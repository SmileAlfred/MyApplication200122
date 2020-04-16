package com.example.myapplication200122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author LiuSaiSai
 * @description: 适用于存储 大量 复杂关系型数据
 * @date :2020/03/06 12:44
 */
public class DataBaseTest extends AppCompatActivity implements View.OnClickListener {

    private MyDataBaseHelper dbHelper;
    private SQLiteDatabase db;
    private ContentValues contentValues;
    private TextView textDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_test);

        dbHelper = new MyDataBaseHelper(this, "BookStore.db", null, 2);
        Button crateDataButton = findViewById(R.id.create_data_button);
        Button addData = findViewById(R.id.add_data);
        Button updateData = findViewById(R.id.update_data);
        Button deleteData = findViewById(R.id.delete_data);
        Button queryData = findViewById(R.id.query_data);

        textDataBase = findViewById(R.id.text_data_base);
        crateDataButton.setOnClickListener(this);
        addData.setOnClickListener(this);
        updateData.setOnClickListener(this);
        deleteData.setOnClickListener(this);
        queryData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_data_button:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                db = dbHelper.getWritableDatabase();
                contentValues = new ContentValues();

                /**
                 * 使用 SQL 操作数据库
                 */
                db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)",
                        new String[]{"SQL添加", "liusaiai", "1", "66.6"});
                Toast.makeText(DataBaseTest.this, "SQL 操作数据库 >> 添加", Toast.LENGTH_SHORT).show();
                /**
                 * <添加> 第一条数据
                 */
                contentValues.put("author", "郭霖");
                contentValues.put("price", "71.3");
                contentValues.put("pages", "580");
                contentValues.put("name", "第一行代码");
                db.insert("Book", null, contentValues);
                contentValues.clear();
                /**
                 * <添加> 第二条数据
                 */
                contentValues.put("author", "塔拉·韦斯特弗");
                contentValues.put("price", "59");
                contentValues.put("pages", "286");
                contentValues.put("name", "你当像鸟飞往你的山");
                db.insert("Book", null, contentValues);
                contentValues.clear();

                contentValues.put("author", "蔡崇达");
                contentValues.put("price", "48.8");
                contentValues.put("pages", "199");
                contentValues.put("name", "皮囊");
                db.insert("Book", null, contentValues);
                contentValues.clear();

                contentValues.put("author", "梁晓声");
                contentValues.put("price", "142.8");
                contentValues.put("pages", "1500");
                contentValues.put("name", "人世间");
                db.insert("Book", null, contentValues);
                contentValues.clear();

                contentValues.put("author", "当年明月");
                contentValues.put("price", "282.2");
                contentValues.put("pages", "2664");
                contentValues.put("name", "明朝那些事儿");
                db.insert("Book", null, contentValues);
                contentValues.clear();

                contentValues.put("author", "加缪");
                contentValues.put("price", "45");
                contentValues.put("pages", "642");
                contentValues.put("name", "局外人");
                db.insert("Book", null, contentValues);
                contentValues.clear();

                contentValues.put("author", "霍斯特曼");
                contentValues.put("price", "95.2");
                contentValues.put("pages", "1500");
                contentValues.put("name", "Java核心技术");
                db.insert("Book", null, contentValues);
                break;
            case R.id.update_data:
                db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("price", 49.9);
                db.update("Book", values, "name = ?", new String[]{"第一行代码"});
                /**
                 * 使用 SQL 操作数据库
                 */
                db.execSQL("update Book set price = ? where name = ?", new String[]{"9.9", "SQL添加"});
                db.execSQL("update Book set pages = ? where name = ?", new String[]{"6", "SQL添加"});

                Toast.makeText(DataBaseTest.this, "SQL 更新数据 >> 更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_data:
                db = dbHelper.getWritableDatabase();
                int limitPages = 1500;
                db.delete("Book", "pages > ?", new String[]{"" + limitPages});
                /**
                 * 使用 SQL 操作数据库
                 */
                db.execSQL("delete from Book  where pages = ?", new String[]{"" + limitPages});

                Toast.makeText(DataBaseTest.this, "SQL 更新数据 >> 删除", Toast.LENGTH_SHORT).show();

                break;
            case R.id.query_data:
                db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        /**
                         * 遍历 Cursor 对象，
                         */
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));

                        textDataBase.append(name + "｜" + author + "｜" + pages + "｜" + price + "\n");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                /**
                 * SQL 操作数据库
                 */
                db.rawQuery("select * from Book",null);
                break;
            default:
                break;
        }
    }
}
