package com.choirul.listfilm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.choirul.listfilm.database.Database;
import com.choirul.listfilm.models.Films;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    FilmAdapter filmAdapter;
    ArrayList<Films> films;
    public static Database db;
    Cursor cursor;
    TextView textView;
    FloatingActionButton add;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new Database(this);

        SharedPreferences users = Home.this.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        String userLogin = users.getString("Login", "OnLogin");

        TextView rvNote = findViewById(R.id.rvNote);

        recyclerView = findViewById(R.id.rvNote);
        add = findViewById(R.id.fab);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Add_Films.class);
                startActivity(intent);
                finish();
            }
        });

        addDataDummy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addDataDummy();
    }

    private void addDataDummy() {
        films = new ArrayList<>();
        SQLiteDatabase dbsql = db.getReadableDatabase();
        cursor = dbsql.rawQuery("SELECT * FROM film",null);
        cursor.moveToFirst();

        if(cursor.getCount() > 0){
            do {

                films.add(new Films(cursor.getString(cursor.getColumnIndex("Judul")),
                        cursor.getString(cursor.getColumnIndex("Sutradara")),
                        cursor.getString(cursor.getColumnIndex("Produser")),
                        cursor.getInt(cursor.getColumnIndex("harga"))));

            } while (cursor.moveToNext());
        }

        filmAdapter = new FilmAdapter(films);

        layoutManager = new LinearLayoutManager(Home.this);

        recyclerView.setAdapter(filmAdapter);

        recyclerView.setLayoutManager(layoutManager);
    }

}
