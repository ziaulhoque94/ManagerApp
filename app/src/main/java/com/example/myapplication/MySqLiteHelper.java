package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MySqLiteHelper extends SQLiteOpenHelper {

    public MySqLiteHelper(Context context) {
        super(context, "MyMesManager.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table MesManager(Id INEGER PRIMARY KEY, Date varchar(20), Details varchar(200), Cost INTEGER(200))"
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
    public boolean isDeleted(String cost){

        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("select *from MesManager where Cost=?",new String[]{cost});

        if (cursor.getCount()>0){
            int result=database.delete("MesManager","Cost=?",new String[]{cost});

            if (result==1){
                return true;
            }else {
                return false;
            }

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

        Cursor cursor=database.rawQuery("select *from MesManager Where Date=?",new String[]{date});
        if (cursor.getCount()>0) {

//            Long result = database.update("Manager", contentValues, "Date=?", new String[]{date});
            int result= database.update("MesManager", contentValues, "Date=?", new String[]{date});

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
        Cursor cursor=database.rawQuery("select *from MesManager",null);

        ArrayList<InfoModal> modalArrayList=new ArrayList<>();
        int count=0; count=count+1;
        if (cursor.moveToFirst()){
            do {
                modalArrayList.add(new InfoModal(cursor.getString(1),cursor.getString(2),
                        cursor.getString(3)));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return modalArrayList;
    }

}

