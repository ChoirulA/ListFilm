package com.choirul.listfilm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "film.db";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;
    private String query;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query = "create table film(no integer primary key AUTOINCREMENT, Judul null, Sutradara null, Produser null, harga null);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void delete(String id){
        SQLiteDatabase database = getReadableDatabase();
        query = "DELETE FROM film WHERE no = "+id;
        SQLiteStatement statement = database.compileStatement(query);
        statement.execute();
    }
}
