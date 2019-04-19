package com.example.louise.personalfinancing.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Louise喵 on 2019/4/17.
 */

public class DBOpenHelper  extends SQLiteOpenHelper {
    private static final String TAG = "DBOpenHelper";

    private static final int VERSION = 1;

    private static final String DB_NAME = "user.db";

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: ");

        String user = "create table user_info(_id integer primary key autoincrement," +
                "category varchar(50),money varchar(50),time varchar(50),password varchar(50),note varchar(50))";
        db.execSQL(user);
        String userout = "create table user_out(_id integer primary key autoincrement," +
                "category varchar(50),money varchar(50),time varchar(50),password varchar(50),note varchar(50))";
        db.execSQL(userout);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
