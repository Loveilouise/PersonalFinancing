package com.example.louise.personalfinancing;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.louise.personalfinancing.util.DBOpenHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    private Button button,button1;

    private EditText editText;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        setContentView(R.layout.activity_main);
        //登录
        button = (Button)findViewById(R.id.button2);
        //注册
        button1 = (Button)findViewById(R.id.button);

        editText = (EditText)findViewById(R.id.editText1);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);

    }





    @Override
    public void onClick(View v) {
        String show = editText.getEditableText().toString();
        //Intent：意图
        //取Intent对象
        //Intent intent = getIntent();
        switch (v.getId()){
            case R.id.button: //登录
                //设置需要跳转的activity
                intent = new Intent();
                intent.setClass(this,LoginActivity.class);
                //创建bundle对象
                Bundle bundle = new Bundle();
                //把需要传的数据放入bundle
                bundle.putString("show",show);
                //把bundle放入intent
                intent.putExtras(bundle);
                //跳转
                startActivity(intent);
                break;
            case R.id.button2://注册
                intent = new Intent();
                intent.setClass(this,SetActivity.class);
                startActivity(intent);
                break;
        }
    }
}
