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

public class SoalKelima extends AppCompatActivity {

    private Button selanjutnya;
    private Bundle bundle;
    private String d1,d2,d3,d4,d5,nama;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_kelima);

        bundle = getIntent().getExtras();

        nama = bundle.getString("nama");
        d1 = bundle.getString("jawab1");
        d2 = bundle.getString("jawab2");
        d3 = bundle.getString("jawab3");
        d4 = bundle.getString("jawab4");

        radioGroup = (RadioGroup)findViewById(R.id.radio5);

        selanjutnya = (Button)findViewById(R.id.selanjutnya);
        selanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoalKelima.this,SoalKeenam.class);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selectedId);
                d5 = radioButton.getText().toString();

                intent.putExtra("nama", nama);
                intent.putExtra("jawab1", d1);
                intent.putExtra("jawab2", d2);
                intent.putExtra("jawab3", d3);
                intent.putExtra("jawab4", d4);
                intent.putExtra("jawab5", d5);

                Log.d("jawab1", d1);
                Log.d("jawab2", d2);
                Log.d("jawab3", d3);
                Log.d("jawab4", d4);
                Log.d("jawab5", d5);

                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan semua soal", Toast.LENGTH_SHORT).show();
    }
}
