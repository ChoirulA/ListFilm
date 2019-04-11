package com.choirul.listfilm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.choirul.listfilm.database.Database;

public class Add_Films extends AppCompatActivity {

    private EditText input_judul, input_sutradara, input_produser, input_harga;
    private AppCompatButton button_save;
    private Database db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__films);

        db = new Database(this);

        input_judul = (EditText) findViewById(R.id.input_judul);
        input_sutradara = (EditText) findViewById(R.id.input_sutradara);
        input_produser = (EditText) findViewById(R.id.input_produser);
        input_harga = (EditText) findViewById(R.id.input_harga);

        button_save = (AppCompatButton) findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = db.getWritableDatabase();

                database.execSQL("INSERT INTO film(Judul, Sutradara, Produser, harga) VALUES('" +
                        input_judul.getText().toString() + "','" +
                        input_sutradara.getText().toString() + "','" +
                        input_produser.getText().toString() + "','" +
                        input_harga.getText().toString() + "')");

                Intent intent = new Intent(Add_Films.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
