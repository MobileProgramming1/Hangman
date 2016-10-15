package com;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by 도경 on 2016-10-15.
 */
public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE WORD_SET( _id INTEGER PRIMARY KEY AUTOINCREMENT, word TEXT, word_in_Korean TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public String getWord(int num) {
        SQLiteDatabase db = getReadableDatabase();
        String string = "";
        int i = 0;
        Cursor cursor = db.rawQuery("select * from WORD_SET", null);
        while (cursor.moveToNext()) {
            if (i == num) {
                string = cursor.getString(1);
                break;
            } else i++;
        }
        return string;
    }

    public String getWordInKorean(int num) {
        SQLiteDatabase db = getReadableDatabase();
        String string = "";
        int i = 0;
        Cursor cursor = db.rawQuery("select * from WORD_SET", null);
        while (cursor.moveToNext()) {
            if (i == num) {
                string = cursor.getString(2);
                break;
            } else i++;
        }
        return string;
    }
}
