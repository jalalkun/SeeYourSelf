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
import android.text.InputType;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mulai;
    private TextView jp, per;
    private String tJp,tPer;
    private long backPressedTime = 0;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        Toolbar myToolbar = (Toolbar)findViewById(R.id.maintoolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        mydb = new DBHelper(this);

        jp = (TextView)findViewById(R.id.jperingatan);
        per = (TextView)findViewById(R.id.yakinkeluar);

        tJp = jp.getText().toString();
        tPer = per.getText().toString();


        mulai = (Button)findViewById(R.id.mulai);
        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masukanNama();
            }
        });
    }



    private void masukanNama(){

        final String[] nama = {""};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Masukan nama");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME );
        builder.setView(input);
// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nama[0] = input.getText().toString();
                String nm = input.getText().toString();

                boolean valid = validasiNama(input,nm);
                if (valid == false){
                    masukanNama();
                    Toast.makeText(MainActivity.this,"Masukan nama anda", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(MainActivity.this,SoalPertama.class);
                    i.putExtra("nama",nama[0]);
                    startActivity(i);
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    /*
   * untuk membuat tombol kembali menjadi tombol exit
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
                        * untuk menutup aplikasi
                        * */

                        Intent exit = new Intent(Intent.ACTION_MAIN);
                        exit.addCategory(Intent.CATEGORY_HOME);
                        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(exit);
                    }
                }).create().show();
    }

    public boolean validasiNama(EditText editText, String nama){
        if (TextUtils.isEmpty(nama)){
            return false;
        }else if (nama.length() < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.daftar:Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                Intent intent = new Intent(getApplicationContext(),Sejarah.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                return true;
            case R.id.tentang:
                startActivity(new Intent(this, Tentang.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
