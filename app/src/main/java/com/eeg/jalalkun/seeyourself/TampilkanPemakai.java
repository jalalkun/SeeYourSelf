
/*
 * Copyright (c) 2016. Dibuat oleh JalalKun
 * LEGG
 */

package com.eeg.jalalkun.seeyourself;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class TampilkanPemakai extends AppCompatActivity {

    private TextView tNama, tH1, tH2, tH3, tH4, tH5, tH6, tH7, tH8, tH9, tH10;
    private String sTNama, sTH1, sTH2, sTH3, sTH4, sTH5, sTH6, sTH7, sTH8, sTH9, sTH10;
    private DBHelper mydb;
    private int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkan_pemakai);


        Toolbar toolbar = (Toolbar)findViewById(R.id.hasilseorangtoolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);



        tNama = (TextView) findViewById(R.id.tampilNama);
        tH1 = (TextView) findViewById(R.id.tampilHasil1);
        tH2 = (TextView) findViewById(R.id.tampilHasil2);
        tH3 = (TextView) findViewById(R.id.tampilHasil3);
        tH4 = (TextView) findViewById(R.id.tampilHasil4);
        tH5 = (TextView) findViewById(R.id.tampilHasil5);
        tH6 = (TextView) findViewById(R.id.tampilHasil6);
        tH7 = (TextView) findViewById(R.id.tampilHasil7);
        tH8 = (TextView) findViewById(R.id.tampilHasil8);
        tH9 = (TextView) findViewById(R.id.tampilHasil9);
        tH10 = (TextView) findViewById(R.id.tampilHasil10);

        mydb = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();

        try {
            if (bundle != null) {
                int value = bundle.getInt("id");
                if (value >= 0) {
                    Cursor cursor = mydb.getData(value);
                    id_To_Update = value;
                    cursor.moveToFirst();

                    sTNama = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAMA));
                    sTH1 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL1));
                    sTH2 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL2));
                    sTH3 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL3));
                    sTH4 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL4));
                    sTH5 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL5));
                    sTH6 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL6));
                    sTH7 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL7));
                    sTH8 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL8));
                    sTH9 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL9));
                    sTH10 = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_HASIL10));

                    tNama.setText(sTNama);
                    tH1.setText(sTH1);
                    tH2.setText(sTH2);
                    tH3.setText(sTH3);
                    tH4.setText(sTH4);
                    tH5.setText(sTH5);
                    tH6.setText(sTH6);
                    tH7.setText(sTH7);
                    tH8.setText(sTH8);
                    tH9.setText(sTH9);
                    tH10.setText(sTH10);

                    cursor.close();

                } else {
                    Toast.makeText(this, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException e) {
            Toast.makeText(this, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show();
        }


        getSupportActionBar().setTitle(R.string.hasil);


    }
}
