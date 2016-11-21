package com.example.mike.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.IDN;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDB";
    private static final  int DATABASE_VERSION = 1000;              //此次資料庫版本

    public MyDBHelper(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    public static final String TABLE_NAME = "Exam";
    public static final String TOPIC_NUM = "TopicNum";
    public static final String TOPIC = "Topic";
    public static final String OPTION_A = "A";
    public static final String OPTION_B = "B";
    public static final String OPTION_C = "C";
    public static final String OPTION_D = "D";
    public static final String ANSWER = "Answer";

    protected static final String TABLE_NAME_SECOND = "User";
    protected static final String USER_ID = "ID";
    protected static final String ACCOUNT = "Account";
    protected static final String PASSWORD = "Password";

    @Override
    public void onCreate(SQLiteDatabase db) {

        final int FIRST_DATABASE_VERSION = 1000;            //這為最初始資料庫版本不可更動

        final String CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        TOPIC_NUM + " INTEGER PRIMARY KEY, " +
                        TOPIC + " TEXT NOT NULL, " +
                        OPTION_A + " TEXT NOT NULL, " +
                        OPTION_B + " TEXT NOT NULL, " +
                        OPTION_C + " TEXT NOT NULL, " +
                        OPTION_D + " TEXT NOT NULL, " +
                        ANSWER + " TEXT NOT NULL)";

        final String CREATE_TABLE_SECOND =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SECOND + " (" +
                        USER_ID + " INTEGER PRIMARY KEY, " +
                        ACCOUNT + " TEXT NOT NULL, " +
                        PASSWORD + " TEXT NOT NULL)" ;

        db.execSQL(CREATE_TABLE_SECOND);
        db.execSQL("insert into User values (1, 'JANGJIN', 'heisdb2');");
        db.execSQL("insert into User values (2, 'YOUYING', 'db2also');");
        db.execSQL("insert into User values (3, 'WUNYI', '12345678');");

        db.execSQL(CREATE_TABLE);
        db.execSQL("insert into Exam values (1, '請問1+1=?', '1', '2', '3', '4', '2');");
        db.execSQL("insert into Exam values (2, '請問1+2=?', '1', '2', '3', '4', '3');");
        db.execSQL("insert into Exam values (3, '請問0+1=?', '1', '2', '3', '4', '1');");
        db.execSQL("insert into Exam values (4, '請問2+2=?', '1', '2', '3', '4', '4');");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {   // 需要再更改為資料庫自動更新情況
        final String DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP);
        onCreate(db);
    }
}