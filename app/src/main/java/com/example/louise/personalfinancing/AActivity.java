package com.example.louise.personalfinancing;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.louise.personalfinancing.util.DBOpenHelper;

import java.util.Calendar;

/**
 * Created by Louise喵 on 2019/4/17.
 */

public class AActivity extends Activity implements View.OnClickListener{
    private static final String TAG="AActivity";
    private EditText editText,editText1,editText2;

    private Button button,button1;

    private Spinner spinner;

    private String money,time,category,note;


    private DBOpenHelper dbOpenHelper;

    private Intent intent;

    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d(TAG, "onCreate() called ");

        editText = (EditText)findViewById(R.id.editText3);//money
        editText1 = (EditText)findViewById(R.id.editText4);//time(日历)
        editText2 = (EditText)findViewById(R.id.editText5);//note

        spinner = (Spinner)findViewById(R.id.spinner);//category（下拉框）

        button = (Button)findViewById(R.id.button5);
        button1 = (Button)findViewById(R.id.button6);




        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        //创建dbOpenHelper对象
        dbOpenHelper = new DBOpenHelper(this);


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,R.array.category,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        editText1.setOnClickListener(this);

        calendar = Calendar.getInstance();
    }
    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() called with: v = [" + v + "]");
        switch (v.getId()){
            case R.id.button5: //点击的是确认按钮
                money = editText.getText().toString();
                time = editText1.getText().toString();
                category = spinner.getSelectedItem().toString();
                 note= editText2.getText().toString();

                Log.d(TAG,money+","+time+","+ category+","+note);

                 SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
                //创建ContentValues对象
                ContentValues contentValues = new ContentValues();
                //把想插入到表中的数据放入contentValues(key,value),key就是字段名
                contentValues.put("category",category);
                contentValues.put("money", money);
                contentValues.put("time", time);
                db.insert("user_out",null,contentValues);
                Toast.makeText(this,"新增成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button6: //点击的是返回按钮
                intent = getIntent();
                intent.setClass(this, MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.editText4:
                //取年月日
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                Log.d(TAG, month+"");
                //显示日历对话框
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    //选择日期触发
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.d(TAG, "选择了日期");
                        //把选择的日期赋值给edittext
                        editText1.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },year,month,day).show();
                break;
        }
    }

}
