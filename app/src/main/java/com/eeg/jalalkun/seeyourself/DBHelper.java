/*
 * Copyright (c) 2016. Dibuat oleh JalalKun
 * LEGG
 */

package com.eeg.jalalkun.seeyourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JalalKun on 02/07/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SeeYourSelf.db";
    public static final String TABEL_NAMA = "sejarah";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_HASIL1 = "hasil1";
    public static final String COLUMN_HASIL2 = "hasil2";
    public static final String COLUMN_HASIL3 = "hasil3";
    public static final String COLUMN_HASIL4 = "hasil4";
    public static final String COLUMN_HASIL5 = "hasil5";
    public static final String COLUMN_HASIL6 = "hasil6";
    public static final String COLUMN_HASIL7 = "hasil7";
    public static final String COLUMN_HASIL8 = "hasil8";
    public static final String COLUMN_HASIL9 = "hasil9";
    public static final String COLUMN_HASIL10 = "hasil10";
    public static final String COLUMN_WAKTU = "waktu";
    private HashMap hp;


    public DBHelper (Context context){
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table sejarah "+
                        "(id integer primary key,nama text, hasil1 text, hasil2 text, hasil3 text, hasil4 text, hasil5 text, hasil6 text, hasil7 text, hasil8 text, hasil9 text, hasil10 text, waktu DATETIME DEFAULT CURRENT_TIMESTAMP);"
        );
        db.execSQL("create table sementara (nama text, satu integer, dua integer, tiga integer, empat integer, lima integer, enam integer, tujuh integer, delapan integer, sembilan integer, sepuluh integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sejarah");
        onCreate(db);
    }

    public boolean memasukanData(String nama, String hasil1, String hasil2, String hasil3, String hasil4, String hasil5, String hasil6, String hasil7, String hasil8, String hasil9, String hasil10, String s){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String wkt = "datetime()";
        contentValues.put("nama", nama);
        contentValues.put("hasil1", hasil1);
        contentValues.put("hasil2", hasil2);
        contentValues.put("hasil3", hasil3);
        contentValues.put("hasil4", hasil4);
        contentValues.put("hasil5", hasil5);
        contentValues.put("hasil6", hasil6);
        contentValues.put("hasil7", hasil7);
        contentValues.put("hasil8", hasil8);
        contentValues.put("hasil9", hasil9);
        contentValues.put("hasil10", hasil10);
        contentValues.put("waktu", wkt);
        db.insert("sejarah", null, contentValues);
        return true;
    }



    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from sejarah where id="+id+"",null);
        return res;
    }

    public int angkaDariBaris(){
        SQLiteDatabase db = this.getReadableDatabase();
        int angkaBaris = (int) DatabaseUtils.queryNumEntries(db, TABEL_NAMA);
        return angkaBaris;
    }

    public Integer hapusBaris (Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("sejarah",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public int hapusSemua(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("sejarah", null, null);
    }

    public ArrayList<String> getAllSejarah()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from sejarah", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAMA)));
            res.moveToNext();
        }
        return array_list;
    }

    public boolean ApakahKosong(){

        boolean isi;

        isi = getAllSejarah().isEmpty();

        if (isi == true){
            return false;
        }else {
            return true;
        }
    }


}
