/*
 * Copyright (c) 2016. Dibuat oleh JalalKun
 * LEGG
 */

package com.eeg.jalalkun.seeyourself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoalKetujuh extends AppCompatActivity {

    private Button selanjutnya;
    private Bundle bundle;
    private int angka;
    private String d1,d2,d3,d4,d5,d6,d7,nama;
    private EditText jawab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_ketujuh);

        jawab = (EditText)findViewById(R.id.angkaSoal7);
        bundle = getIntent().getExtras();

        nama = bundle.getString("nama");
        d1 = bundle.getString("jawab1");
        d2 = bundle.getString("jawab2");
        d3 = bundle.getString("jawab3");
        d4 = bundle.getString("jawab4");
        d5 = bundle.getString("jawab5");
        d6 = bundle.getString("jawab6");

        selanjutnya = (Button)findViewById(R.id.selanjutnya);
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoalKetujuh.this,SoalKedelapan.class);

                d7 = jawab.getText().toString();

                try {
                    if (d7 != null){
                        angka = Integer.parseInt(jawab.getText().toString());
                        if (angka > 0 && angka < 11){
                            intent.putExtra("nama", nama);
                            intent.putExtra("jawab1",d1);
                            intent.putExtra("jawab2",d2);
                            intent.putExtra("jawab3",d3);
                            intent.putExtra("jawab4",d4);
                            intent.putExtra("jawab5",d5);
                            intent.putExtra("jawab6",d6);
                            intent.putExtra("jawab7",d7);
                            Log.d("jawab1", d1);
                            Log.d("jawab2", d2);
                            Log.d("jawab3", d3);
                            Log.d("jawab4", d4);
                            Log.d("jawab5", d5);
                            Log.d("jawab6", d6);
                            Log.d("jawab7", d7);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(),"Masukan angka antara 1 hingga 10",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Masukan angka antara 1 hingga 10",Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Masukan angka antara 1 hingga 10",Toast.LENGTH_SHORT).show();
                }





            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan semua soal", Toast.LENGTH_SHORT).show();
    }
}
