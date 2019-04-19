package com.example.louise.personalfinancing;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.louise.personalfinancing.model.UserInfo;
import com.example.louise.personalfinancing.util.DBOpenHelper;

import java.util.Calendar;

/**
 * Created by Louise喵 on 2019/4/18.
 */

public class DUpdateActivity  extends Activity implements View.OnClickListener{
    private static final String TAG = "DUpdateActivity";

    private EditText editText,editText1,editText2;

    private Button button,button1;

    private Spinner spinner;

    private String money,time,category,note;

    private int id;

    private DBOpenHelper dbOpenHelper;

    private UserInfo userInfo;

    private Intent intent;

    private Calendar calendar;

    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dupdate);

        editText = (EditText)findViewById(R.id.editText3);//money
        editText1 = (EditText)findViewById(R.id.editText4);//time(日历)
        editText2 = (EditText)findViewById(R.id.editText5);//note


        button = (Button)findViewById(R.id.button5);
        button1 = (Button)findViewById(R.id.button6);

        spinner = (Spinner)findViewById(R.id.spinner);//category（下拉框）


        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,R.array.category,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        editText1.setOnClickListener(this);

        calendar = Calendar.getInstance();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        userInfo = (UserInfo)bundle.get("userInfo");
        //Toast.makeText(this, studentInfo.toString(),Toast.LENGTH_SHORT).show();
        editText.setText( userInfo.getMoney());
        editText1.setText(String.valueOf(userInfo.getTime()));
        editText2.setText(String.valueOf( userInfo.getNote()));

        dbOpenHelper = new DBOpenHelper(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button5:
                //主键
                id = userInfo.getId();
                money = editText.getText().toString();
                time = editText1.getText().toString();
                category =spinner.toString();
                note = editText2.getText().toString();
                db = dbOpenHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("money",money);
                contentValues.put("time",time);
                contentValues.put("category",category);
                contentValues.put("note",note);
                String args[] = {String.valueOf(id)};
                //第一个参数:表名
                //第二个参数:需要修改的值
                //第三个参数：修改的条件
                //第四个参数:修改的条件的值的数组
                db.update("user_info",contentValues,"_id=?",args);
                Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6:
                id = userInfo.getId();
                db = dbOpenHelper.getWritableDatabase();
                db.delete("user_info","_id=?",new String[]{String.valueOf(id)});
                Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
