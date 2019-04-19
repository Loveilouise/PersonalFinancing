package com.example.louise.personalfinancing;

import android.app.Activity;
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
 * Created by Louise喵 on 2019/4/18.
 */
public class LoginActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "LoginActivity";
    private Button button,button1;

    private EditText editText;

    private String password;

    private DBOpenHelper dbOpenHelper;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText = (EditText)findViewById(R.id.editText2);

        button = (Button)findViewById(R.id.button7);
        button1 = (Button)findViewById(R.id.button8);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        //取intent对象
        Intent intent = getIntent();
        //取bundle对象
        Bundle bundle = intent.getExtras();
        //从bundle对象中取数据
        String show = bundle.getString("show");
        Toast.makeText(this,show,Toast.LENGTH_SHORT).show();

        dbOpenHelper = new DBOpenHelper(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button7:
                intent = getIntent();

                password = editText.getText().toString();
                intent.setClass(this,MenuActivity.class);
                startActivity(intent);

                break;
            case R.id.button8:
                intent = getIntent();
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
