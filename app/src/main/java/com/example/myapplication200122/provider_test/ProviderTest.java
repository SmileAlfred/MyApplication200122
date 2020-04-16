package com.example.myapplication200122.provider_test;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication200122.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuSaiSai
 * @description: 内容提供器
 * 检查其 权限
 * if (ContextCompat.checkSelfPermission(ProviderTest.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
 * ActivityCompat.requestPermissions(ProviderTest.this,new String[]{Manifest.permission.CALL_PHONE},1);
 * }
 * × × × × × × 自定义内容提供器有点乱，没看明白！没做！
 * @date :2020/03/07 10:05
 */
public class ProviderTest extends   AppCompatActivity implements View.OnClickListener {

    private ListView listProvider;

    ArrayAdapter<String> adapter;

    List<String> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        Button callButton = findViewById(R.id.call_button_provider);
        listProvider = findViewById(R.id.list_provider);

        callButton.setOnClickListener(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList);

        listProvider.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            readContacts();

        }
    }

    /**
     * 通过 内容提供器 获取其他应用的数据
     */
    private void readContacts() {
        Cursor cursor = null;

        try {
            /**
             * 查询联系人数据
             */
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    /**
                     * 获取联系人姓名
                     */
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    /**
                     * 获取联系人电话
                     */
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    contactsList.add(displayName + "\n" + number);
                }
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call_button_provider:
                if (ContextCompat.checkSelfPermission(ProviderTest.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ProviderTest.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    call();
                }
                break;
        }
    }

    private void call() {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:10010"));
            startActivity(callIntent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(ProviderTest.this, "你拒绝了权限", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
