package com.example.authentication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_AUTH = "_authentication";


    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static  final String KEY_PASSWORD = "password";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query_Table = " CREATE TABLE " + TABLE_AUTH + "("
                + KEY_NAME + " TEXT, " + KEY_EMAIL + " TEXT, " + KEY_PASSWORD + " TEXT);";
        db.execSQL(Query_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_AUTH);
        onCreate(db);

    }
    public long insertData(String name, String email, String password) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        return db.insert(TABLE_AUTH, null, values);
    }
    public long insertData(String email, String password) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        return db.insert(TABLE_AUTH, null, values);
    }
//    public String getData() {
//        db = this.getReadableDatabase();
//        String[] columns = new String[]{KEY_NAME, KEY_EMAIL, KEY_PASSWORD};
//        Cursor cursor = db.query(TABLE_AUTH, columns, null, null, null, null, null);
//
//
//        int iName = cursor.getColumnIndex(KEY_NAME);
//        int iEmail = cursor.getColumnIndex(KEY_EMAIL);
//        int iPassword = cursor.getColumnIndex(KEY_PASSWORD);
//        String result = "";
//
//        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
//            result = result +
//                    "Name: " + cursor.getString(iName) + "\n" +
//                    "Email: " + cursor.getString(iEmail) + "\n" +
//                    "Password: " + cursor.getString(iPassword) + "\n\n";
//        }
//        db.close();
//        return result;
//    }
}
