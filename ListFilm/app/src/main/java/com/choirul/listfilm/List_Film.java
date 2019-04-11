package com.choirul.listfilm;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.choirul.listfilm.database.Database;

public class List_Film extends AppCompatActivity {

    private String id;
    private String judul, sutradara, produser, harga;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__film);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        judul = intent.getStringExtra("judul");
        sutradara = intent.getStringExtra("Sutradara");
        produser = intent.getStringExtra("Produser");
        harga = intent.getStringExtra("harga");

        Button update = findViewById(R.id.button_update);
        Button delete = findViewById(R.id.button_delete);

//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase dbsql = db.getReadableDatabase();
//                dbsql.delete("film", "judul = '"+judul+"'",null);
//                Toast.makeText(v.getContext(),"Delete Success", Toast.LENGTH_LONG).show();
//                finish();
//            }
//        });

//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Delete Success", Toast.LENGTH_LONG).show();
//                Context context = List_Film.this;
//                Intent intent1 = new Intent(context,Update_Film.class);
//                intent1.putExtra("id", id);
//                intent1.putExtra("judul", judul);
//                intent1.putExtra("Sutradara", sutradara);
//                intent1.putExtra("Produser", produser);
//                intent1.putExtra("harga", harga);
//                context.startActivity(intent1);
//                finish();
//            }
//        });

    }

}
