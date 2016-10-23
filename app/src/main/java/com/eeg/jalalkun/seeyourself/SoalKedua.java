/*
 * Copyright (c) 2016. Dibuat oleh JalalKun
 * LEGG
 */

package com.eeg.jalalkun.seeyourself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SoalKedua extends AppCompatActivity {

    private Button selanjutnya;
    private String j1,nama;
    private Bundle extras;
    RadioGroup radioGroup2;
    RadioButton radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_kedua);

        radioGroup2=(RadioGroup)findViewById(R.id.radio2);

        extras = getIntent().getExtras();
        nama = extras.getString("nama");
        j1 = extras.getString("jawab1");

        selanjutnya = (Button)findViewById(R.id.selanjutnya);
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = (RadioButton)findViewById(selectedId);
                String jawab2 = (String)radioButton2.getText().toString();

                Intent intent = new Intent(SoalKedua.this,SoalKetiga.class);
                intent.putExtra("nama",nama);
                intent.putExtra("jawab1",j1);
                intent.putExtra("jawab2",jawab2);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan semua soal", Toast.LENGTH_SHORT).show();
    }
}
