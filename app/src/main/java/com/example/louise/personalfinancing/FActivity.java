package com.example.louise.personalfinancing;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.louise.personalfinancing.model.UserInfo;
import com.example.louise.personalfinancing.util.DBOpenHelper;

/**
 * Created by Louise喵 on 2019/4/17.
 */

public class FActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "FActivity";
    private Button button,button1;

    private EditText editText;

    private String note;

    private DBOpenHelper dbOpenHelper;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);
        Log.d(TAG, "onCreate() called ");

        editText = (EditText)findViewById(R.id.editText5);

        button = (Button)findViewById(R.id.button5);
        button1 = (Button)findViewById(R.id.button6);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        dbOpenHelper = new DBOpenHelper(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() called with: v = [" + v + "]");
        switch (v.getId()){
            case R.id.button5:
                note= editText.getText().toString();
                SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
                //创建ContentValues对象
                ContentValues contentValues = new ContentValues();
                //把想插入到表中的数据放入contentValues(key,value),key就是字段名
                contentValues.put("note",note);
                db.insert("user_info",null,contentValues);
                Toast.makeText(this,"新增成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                intent = getIntent();
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                intent.setClass(this,MenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
