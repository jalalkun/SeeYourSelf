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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SoalPertama extends AppCompatActivity {

    private Bundle bundle;
    private RadioGroup radioGroup1;
    private RadioButton radioButton1;
    private Button selanjutnya1;
    private String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_pertama);

        radioGroup1 = (RadioGroup)findViewById(R.id.radio1);

        bundle = getIntent().getExtras();
        nama = bundle.getString("nama");

        Log.d("nama anda", nama);

        selanjutnya1 = (Button)findViewById(R.id.selanjutnya1);
        selanjutnya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup1.getCheckedRadioButtonId();
                radioButton1=(RadioButton)findViewById(selectedId);
                String jawab1 = "";

                jawab1 = radioButton1.getText().toString();
                Log.d("Jawaban pertama",jawab1);
                Log.d("id jawab1", String.valueOf(selectedId));
                Intent i = new Intent(SoalPertama.this,SoalKedua.class);

                i.putExtra("nama",nama);
                i.putExtra("jawab1",jawab1);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan semua soal", Toast.LENGTH_SHORT).show();
    }
}
