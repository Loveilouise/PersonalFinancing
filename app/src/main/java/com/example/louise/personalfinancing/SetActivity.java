package com.example.louise.personalfinancing;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.louise.personalfinancing.model.UserInfo;
import com.example.louise.personalfinancing.util.DBOpenHelper;

import java.util.Calendar;

/**
 * Created by Louise喵 on 2019/4/18.
 */
public class SetActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SetActivity";
    private EditText editText;

    private Button button ;

    private String  password;

    private DBOpenHelper dbOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        Log.d(TAG, "onCreate() called ");

        editText = (EditText)findViewById(R.id.editText2);

        button = (Button)findViewById(R.id.button);



        //给button按钮设置单击事件的监听器
        button.setOnClickListener(this);


        //创建dbOpenHelper对象
        dbOpenHelper = new DBOpenHelper(this);


        editText.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() called with: v = [" + v + "]");
        switch (v.getId()){
            case R.id.button: //点击的是确认按钮
                password = editText.getText().toString();

                Log.d(TAG,password);
                //显示提示信息
                //第一个参数: 上下文，当前类
                //第二个参数: 显示的提示信息
                //第三个参数: 显示的时间长短
                //Toast.makeText(this,name+","+password+","+age,Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
                //创建ContentValues对象
                ContentValues contentValues = new ContentValues();
                //把想插入到表中的数据放入contentValues(key,value),key就是字段名
                contentValues.put("password",password);

                db.insert("user_info",null,contentValues);
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }

}