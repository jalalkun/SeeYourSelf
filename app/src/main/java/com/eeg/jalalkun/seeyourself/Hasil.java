/*
 * Copyright (c) 2016. Dibuat oleh JalalKun
 * LEGG
 */

package com.eeg.jalalkun.seeyourself;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    private Button kembali;
    private Bundle bundle;
    private String d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,nama;
    private String dh1,dh2,dh3,dh4,dh5,dh6,dh7,dh8,dh9,dh10;
    private TextView hj1,hj2,hj3,hj4,hj5,hj6,hj7,hj8,hj9,hj10;
    private TextView h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,namaUser;
    private TextView jp, per;
    private TextView jawab1, jawab2, jawab3, jawab4, jawab5, jawab6, jawab7, jawab8, jawab9, jawab10;
    String hasil1, hasil2, hasil3, hasil4, hasil5, hasil6, hasil7, hasil8, hasil9, hasil10;
    private String tJp,tPer;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Toolbar toolbar = (Toolbar)findViewById(R.id.hasiltoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.hasil);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        jp = (TextView)findViewById(R.id.jperingatanH);
        per = (TextView)findViewById(R.id.yakinkeluarH);

        tJp = jp.getText().toString();
        tPer = per.getText().toString();


        bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        d1 = bundle.getString("jawab1");
        d2 = bundle.getString("jawab2");
        d3 = bundle.getString("jawab3");
        d4 = bundle.getString("jawab4");
        d5 = bundle.getString("jawab5");
        d6 = bundle.getString("jawab6");
        d7 = bundle.getString("jawab7");
        d8 = bundle.getString("jawab8");
        d9 = bundle.getString("jawab9");
        d10 = bundle.getString("jawab10");

        namaUser = (TextView)findViewById(R.id.namaUser);
        h1 = (TextView) findViewById(R.id.hasilno1);
        h2 = (TextView) findViewById(R.id.hasilno2);
        h3 = (TextView) findViewById(R.id.hasilno3);
        h4 = (TextView) findViewById(R.id.hasilno4);
        h5 = (TextView) findViewById(R.id.hasilno5);
        h6 = (TextView) findViewById(R.id.hasilno6);
        h7 = (TextView) findViewById(R.id.hasilno7);
        h8 = (TextView) findViewById(R.id.hasilno8);
        h9 = (TextView) findViewById(R.id.hasilno9);
        h10 = (TextView) findViewById(R.id.hasilno10);

        namaUser.setText(nama);
        SetHasil1(d1);
        SetHasil2(d2);
        SetHasil3(d3);
        SetHasil4(d4);
        SetHasil5(d5);
        SetHasil6(d6);
        SetHasil7(d7);
        SetHasil8(d8);
        SetHasil9(d9);
        SetHasil10(d10);


        jawab1 = (TextView)findViewById(R.id.jawabanno1);
        jawab2 = (TextView)findViewById(R.id.jawabanno2);
        jawab3 = (TextView)findViewById(R.id.jawabanno3);
        jawab4 = (TextView)findViewById(R.id.jawabanno4);
        jawab5 = (TextView)findViewById(R.id.jawabanno5);
        jawab6 = (TextView)findViewById(R.id.jawabanNo6);
        jawab7 = (TextView)findViewById(R.id.jawabanNo7);
        jawab8 = (TextView)findViewById(R.id.jawabanno8);
        jawab9 = (TextView)findViewById(R.id.jawabanno9);
        jawab10 = (TextView)findViewById(R.id.jawabanno10);

        jawab1.setText(d1);
        jawab2.setText(d2);
        jawab3.setText(d3);
        jawab4.setText(d4);
        jawab5.setText(d5);
        jawab6.setText(d6);
        jawab7.setText(d7);
        jawab8.setText(d8);
        jawab9.setText(d9);
        jawab10.setText(d10);

       /* Log.d("jawab1", d1);
        Log.d("jawab2", d2);
        Log.d("jawab3", d3);
        Log.d("jawab4", d4);
        Log.d("jawab5", d5);
        Log.d("jawab6", d6);
        Log.d("jawab7", d7);
        Log.d("jawab8", d8);
        Log.d("jawab9", d9);
        Log.d("jawab10", d10);

        Log.d("hasil1", hasil1);
        Log.d("hasil2", hasil2);
        Log.d("hasil3", hasil3);
        Log.d("hasil4", hasil4);
        Log.d("hasil5", hasil5);
        Log.d("hasil6", hasil6);
        Log.d("hasil7", hasil7);
        Log.d("hasil8", hasil8);
        Log.d("hasil9", hasil9);
        Log.d("hasil10", hasil10);*/

        mydb = new DBHelper(this);

        mydb.memasukanData(nama, hasil1, hasil2, hasil3, hasil4, hasil5, hasil6, hasil7, hasil8, hasil9, hasil10, null);

        kembali = (Button)findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hasil.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void SetHasil1(String j) {

        if(j.equals("Terbuka") ){

            hj1 = (TextView)findViewById(R.id.jawaban1no1);
            dh1 = hj1.getText().toString();
            hasil1 = dh1;
            h1.setText(dh1);
        }else if (j.equals("Tertutup") ){
            hj1 = (TextView)findViewById(R.id.jawaban2no1);
            dh1 = hj1.getText().toString();
            hasil1 = dh1;
            h1.setText(dh1);
        }
    }

    private void SetHasil2(String j){
        if (j.equals("Bulat") ){
            hj2 = (TextView)findViewById(R.id.jawaban1no2);
            dh2 = hj2.getText().toString();
            hasil2 = dh2;
            h2.setText(dh2);
        }else if (j.equals("Kotak")){
            hj2 = (TextView)findViewById(R.id.jawaban2no2);
            dh2 = hj2.getText().toString();
            hasil2 = dh2;
            h2.setText(dh2);
        }else if (j.equals("Segitiga")){
            hj2 = (TextView)findViewById(R.id.jawaban3no2);
            dh2 = hj2.getText().toString();
            hasil2 = dh2;
            h2.setText(dh2);
        }
    }

    private void SetHasil3(String j){
        if(j.equals("Keramik atau tanah liat")){
            hj3 =(TextView)findViewById(R.id.jawaban1no3);
            dh3 = hj3.getText().toString();
            hasil3 = dh3;
            h3.setText(dh3);
        }else if(j.equals("Plastik")){
            hj3 = (TextView)findViewById(R.id.jawaban2no3);
            dh3 = hj3.getText().toString();
            hasil3 = dh3;
            h3.setText(dh3);
        }else if(j.equals("Besi")){
            hj3 = (TextView)findViewById(R.id.jawaban3no3);
            dh3 = hj3.getText().toString();
            hasil3 = dh3;
            h3.setText(dh3);
        }
    }

    private void SetHasil4(String j){
        if (j.equals("Penuh")){
            hj4 = (TextView)findViewById(R.id.jawaban1no4);
            dh4 = hj4.getText().toString();
            hasil4 = dh4;
            h4.setText(dh4);
        }else if (j.equals("Setengah")){
            hj4 = (TextView)findViewById(R.id.jawaban2no4);
            dh4 = hj4.getText().toString();
            hasil4 = dh4;
            h4.setText(dh4);
        }else if (j.equals("Kosong")){
            hj4 = (TextView)findViewById(R.id.jawaban3no4);
            dh4 = hj4.getText().toString();
            hasil4 = dh4;
            h4.setText(dh4);
        }
    }

    private void SetHasil5(String j){
        if (j.equals("Emas")){
            hj5 = (TextView)findViewById(R.id.jawaban1no5);
            dh5 = hj5.getText().toString();
            hasil5 = dh5;
            h5.setText(dh5);
        }else if (j.equals("Perak")){
            hj5 = (TextView)findViewById(R.id.jawaban2no5);
            dh5 = hj5.getText().toString();
            hasil5 = dh5;
            h5.setText(dh5);
        }else if (j.equals("Besi")){
            hj5 = (TextView)findViewById(R.id.jawaban3no5);
            dh5 = hj5.getText().toString();
            hasil5 = dh5;
            h5.setText(dh5);
        }
    }

    private void SetHasil6(String j){
        hj6 = (TextView)findViewById(R.id.jawabanno6);
        dh6 = hj6.getText().toString();
        hasil6 = dh6;
        h6.setText(dh6);
    }

    private void SetHasil7(String j){
        hj7 = (TextView)findViewById(R.id.jawabanno7);
        dh7 = hj7.getText().toString();
        hasil7 = dh7;
        h7.setText(dh7);
    }

    private void SetHasil8(String j){
        if (j.equals("Mengambil koin emas pada kolam pertama")){
            hj8 = (TextView)findViewById(R.id.jawaban1no8);
            dh8 = hj8.getText().toString();
            hasil8 = dh8;
            h8.setText(dh8);
        }else if (j.equals("Mengambil koin perak pada kolam kedua")){
            hj8 = (TextView)findViewById(R.id.jawaban2no8);
            dh8 = hj8.getText().toString();
            hasil8 = dh8;
            h8.setText(dh8);
        }else if (j.equals("Tidak mengambil apa-apa")){
            hj8 = (TextView)findViewById(R.id.jawaban3no8);
            dh8 = hj8.getText().toString();
            hasil8 = dh8;
            h8.setText(dh8);
        }
    }

    private void SetHasil9(String j){
        if (j.equals("Besar")){
            hj9 = (TextView)findViewById(R.id.jawaban1no9);
            dh9 = hj9.getText().toString();
            hasil9 = dh9;
            h9.setText(dh9);
        }else if (j.equals("Sedang")){
            hj9 = (TextView)findViewById(R.id.jawaban2no9);
            dh9 = hj9.getText().toString();
            hasil9 = dh9;
            h9.setText(dh9);
        }else if (j.equals("Kecil")){
            hj9 = (TextView)findViewById(R.id.jawaban3no9);
            dh9 = hj9.getText().toString();
            hasil9 = dh9;
            h9.setText(dh9);
        }
    }

    private void SetHasil10(String j){
        if (j.equals("Berlari menggunakan kuda")){
            hj10 = (TextView)findViewById(R.id.jawaban1no10);
            dh10 = hj10.getText().toString();
            hasil10 = dh10;
            h10.setText(dh10);
        }else if (j.equals("Masuk ke dalam kota besar itu")){
            hj10 = (TextView)findViewById(R.id.jawaban2no10);
            dh10 = hj10.getText().toString();
            hasil10 = dh10;
            h10.setText(dh10);
        }else if (j.equals("Berlari ketempat yang lebih aman")){
            hj10 = (TextView)findViewById(R.id.jawaban3no10);
            dh10 = hj10.getText().toString();
            hasil10 = dh10;
            h10.setText(dh10);
        }
    }

    /*
    * membuat tombol kembali menjadi tombol keluar
    * */

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(tJp)
                .setMessage(tPer)
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        /*
                        * untuk keluar dari aplikasi
                        * */

                        Intent exit = new Intent(Intent.ACTION_MAIN);
                        exit.addCategory(Intent.CATEGORY_HOME);
                        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(exit);
                    }
                }).create().show();
    }
}
