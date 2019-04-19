package com.example.louise.personalfinancing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.louise.personalfinancing.model.UserOut;

import java.util.List;

/**
 * Created by Louise喵 on 2019/4/17.
 */

public class CListAdapter extends BaseAdapter{

    private static final String TAG = "CListAdapter";

    //需要显示的数据
    private List<UserOut> list;

    private LayoutInflater layoutInflater;

    public CListAdapter(List<UserOut> list,Context context){
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 每一行需要显示的view
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView() called with: position = [" + position + "], convertView = [" + convertView + "], parent = [" + parent + "]");

        if(convertView == null){
            //通过布局文件list_item来取它的View对象
            convertView = layoutInflater.inflate(R.layout.clist_item,null);
        }
        //从list_item取id是textView的组件
        TextView categoryTextView = (TextView)convertView.findViewById(R.id.textView5);
        TextView moneyTextView = (TextView)convertView.findViewById(R.id.textView6) ;
        TextView timeTextView = (TextView)convertView.findViewById(R.id.textView7);

        //取第一行需要显示的数据
        UserOut userOut = list.get(position);
        String category = userOut.getCategory();
        String money = userOut.getMoney();
        String time = userOut.getTime();

        //给每一个textview赋值(赋给需要显示的数据)
        categoryTextView.setText(category);
        moneyTextView.setText(money);
        timeTextView.setText(time);

        return convertView;
    }
}

