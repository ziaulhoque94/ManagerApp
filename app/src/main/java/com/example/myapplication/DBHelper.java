package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "MyMesManager.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table MesManager(Id INEGER PRIMARY KEY AUTOINCREMENT, Date TEXT, Details TEXT, Cost INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists MesManager");
    }
    public boolean isInserted(String date, String Details, int total_cost){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Date", date);
        contentValues.put("Details", Details);
        contentValues.put("Cost", total_cost);

        Long result=database.insert("MesManager",null, contentValues);

        if (result==1){
            return true;
        }else {
            return false;
        }
    }

    public boolean isModified(String date, String Details, int total_cost){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Date", date);
        contentValues.put("Details", Details);
        contentValues.put("Cost", total_cost);

        Cursor cursor=database.rawQuery("select *from Manager Where Date=?",new String[]{date});
        if (cursor.getCount()>0) {

//            Long result = database.update("Manager", contentValues, "Date=?", new String[]{date});
            Long result= (long) database.update("Manager", contentValues, "Date=?", new String[]{date});

            if (result == 1) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    public ArrayList<InfoModal> ReadInfo(){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select *from Manager",null);

        ArrayList<InfoModal> modalArrayList=new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                modalArrayList.add(new InfoModal(cursor.getString(0),cursor.getString(2),
                        cursor.getString(3)));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return modalArrayList;
    }
}
