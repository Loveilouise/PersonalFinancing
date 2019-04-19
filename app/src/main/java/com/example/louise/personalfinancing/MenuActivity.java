package com.example.louise.personalfinancing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Louise喵 on 2019/4/17.
 */

public class MenuActivity extends Activity implements AdapterView.OnItemClickListener{
    private static final String TAG = "MenuActivity";

    private GridView gridView;

    //定义菜单项的图标
    private int[] icons = {R.drawable.a,R.drawable.b,R.drawable.c,
                           R.drawable.d,R.drawable.e,R.drawable.f,
                           R.drawable.g,R.drawable.h};

    //定义菜单项的标题
    private String[] titles = {"新增支出","新增收入","我的支出","我的收入","数据管理","系统设置",
                                "收支便签","退出"};

    //定义一个适配器
    private SimpleAdapter simpleAdapter;

    //gridview需要显示的所有的菜单数据
    private List<Map<String,Object>> data;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        gridView = (GridView)findViewById(R.id.grid_view);
        init();

        simpleAdapter = new SimpleAdapter(this,data,R.layout.grid_item,
                new String[]{"icon","title"},new int[]{R.id.imageView2,R.id.textView3});


        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(this);
    }
    public void init(){
        data = new ArrayList<>();
        //遍历图标数组
        for(int i=0;i<icons.length;i++){
            //构造每一个菜单项的HashMap
            Map<String,Object> item = new HashMap<>();
            item.put("icon",icons[i]);
            item.put("title",titles[i]);
            data.add(item);
        }
        Log.d(TAG, data.toString());
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                intent = getIntent();
                intent.setClass(this,AActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = getIntent();
                intent.setClass(this,BActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = getIntent();
                intent.setClass(this,CActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = getIntent();
                intent.setClass(this,DActivity.class);
                startActivity(intent);
                break;
            case 4:
                break;
            case 5:
                intent = getIntent();
                intent.setClass(this,SetActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent = getIntent();
                intent.setClass(this,FActivity.class);
                startActivity(intent);
                break;
            case 7:
                intent = getIntent();
                intent.setClass(this,LoginActivity.class);
                startActivity(intent);
                break;

        }

    }


}
