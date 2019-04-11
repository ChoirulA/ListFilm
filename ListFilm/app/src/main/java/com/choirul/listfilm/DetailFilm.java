package com.choirul.listfilm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.choirul.listfilm.database.Database;
import com.choirul.listfilm.models.Films;

import org.w3c.dom.Text;

public class DetailFilm extends AppCompatActivity {

    private String id;
    private String judul, sutradara, produser, harga;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        judul = intent.getStringExtra("judul");
        sutradara = intent.getStringExtra("Sutradara");
        produser = intent.getStringExtra("Produser");
        harga = intent.getStringExtra("harga");

        TextView Judul = (TextView) findViewById(R.id.text_judul);
        TextView Sutradara = (TextView) findViewById(R.id.text_sutradara);
        TextView Produser = (TextView) findViewById(R.id.text_produser);
        TextView Harga = (TextView) findViewById(R.id.text_harga);

        Judul.setText("Judul                 :   "+judul);
        Sutradara.setText("Sutradara         :   "+sutradara);
        Produser.setText("Produser          :   "+produser);
        Harga.setText("Harga                :   "+harga);

        db = new Database(this);
    }

}
