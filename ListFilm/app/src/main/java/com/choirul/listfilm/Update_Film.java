package com.choirul.listfilm;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.choirul.listfilm.database.Database;

public class Update_Film extends AppCompatActivity {

    private EditText udt_judul, udt_sutradara, udt_produser, udt_harga;
    private Button update_save;
    private Database db;
    private String judul, sutradara, produser, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__film);

        Intent masukan = getIntent();
        judul = masukan.getStringExtra("judul");
        sutradara = masukan.getStringExtra("Sutradara");
        produser = masukan.getStringExtra("Produser");
        harga = masukan.getStringExtra("harga");

        udt_judul = findViewById(R.id.udt_judul);
        udt_sutradara = findViewById(R.id.udt_sutradara);
        udt_produser = findViewById(R.id.udt_produser);
        udt_harga = findViewById(R.id.udt_harga);
        update_save = findViewById(R.id.button_update_save);

        udt_judul.setText(judul);
        udt_sutradara.setText(sutradara);
        udt_produser.setText(produser);
        udt_harga.setText(harga);

        db = new Database(this);

        update_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase updatedb = db.getWritableDatabase();
                updatedb.execSQL("UPDATE film SET Judul='"+udt_judul.getText()+
                        "', Sutradara='"+udt_sutradara.getText()+
                        "', Produser='"+udt_produser.getText()+
                        "', harga='"+udt_harga.getText()+
                        "'WHERE Judul = '"+judul+"'");
                finish();
                Toast.makeText(Update_Film.this, "Update Success", Toast.LENGTH_LONG).show();
            }
        });

    }

}
