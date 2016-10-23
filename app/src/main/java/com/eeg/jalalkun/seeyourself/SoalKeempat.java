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

public class SoalKeempat extends AppCompatActivity {

    private Button selanjutnya;
    private Bundle extras;
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private String d1,d2,d3,nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_keempat);

        extras = getIntent().getExtras();
        nama =extras.getString("nama");
        d1 = extras.getString("jawab1");
        d2 = extras.getString("jawab2");
        d3 = extras.getString("jawab3");
        radioGroup = (RadioGroup)findViewById(R.id.radio4);
        selanjutnya = (Button)findViewById(R.id.selanjutnya);
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoalKeempat.this,SoalKelima.class);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(selectedId);
                String d4= (String)radioButton.getText().toString();

                intent.putExtra("nama",nama);
                intent.putExtra("jawab1",d1);
                intent.putExtra("jawab2",d2);
                intent.putExtra("jawab3",d3);
                intent.putExtra("jawab4",d4);

                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan semua soal", Toast.LENGTH_SHORT).show();
    }
}
