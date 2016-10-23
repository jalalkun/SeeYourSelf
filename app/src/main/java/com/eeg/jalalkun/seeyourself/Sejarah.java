/*
 * Copyright (c) 2016. Dibuat oleh JalalKun
 * LEGG
 */

package com.eeg.jalalkun.seeyourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Sejarah extends AppCompatActivity {

    private ListView obj;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sejarah);
        mydb = new DBHelper(this);
        obj = (ListView) findViewById(R.id.listPemakai);

        Toolbar toolbar = (Toolbar)findViewById(R.id.sejarahtoolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.sejarah);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        BuatDaftar();

        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int id_to_show = position + 1;
                Bundle bundle = new Bundle();

                bundle.putInt("id", id_to_show);

                Intent intent = new Intent(getApplicationContext(), TampilkanPemakai.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sejarah, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuHapus:
                Bundle hapusBundle = new Bundle();

                if (mydb.ApakahKosong() == false) {
                    Toast.makeText(Sejarah.this, "Daftar sudah kosong", Toast.LENGTH_SHORT).show();
                } else {
                    mydb.hapusSemua();
                    BuatDaftar();
                    Toast.makeText(Sejarah.this, "Berhasil menghapus daftar", Toast.LENGTH_SHORT).show();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void BuatDaftar() {
        ArrayList arrayList = mydb.getAllSejarah();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        obj.setAdapter(arrayAdapter);

    }
}
