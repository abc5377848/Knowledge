package com.example.mike.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

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

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                        TOPIC_NUM + " INTEGER PRIMARY KEY, " +
                        TOPIC + " TEXT NOT NULL, " +
                        OPTION_A + " TEXT NOT NULL, " +
                        OPTION_B + " TEXT NOT NULL, " +
                        OPTION_C + " TEXT NOT NULL, " +
                        OPTION_D + " TEXT NOT NULL, " +
                        ANSWER + " TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE);
        db.execSQL("insert into Exam values (1, '請問1+1=?', '1', '2', '3', '4', '2');");
        db.execSQL("insert into Exam values (2, '請問1+2=?', '1', '2', '3', '4', '3');");
        db.execSQL("insert into Exam values (3, '請問0+1=?', '1', '2', '3', '4', '1');");
        db.execSQL("insert into Exam values (4, '請問2+2=?', '1', '2', '3', '4', '4');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP);
        onCreate(db);
    }
}