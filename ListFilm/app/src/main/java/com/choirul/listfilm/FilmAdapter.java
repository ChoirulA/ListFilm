package com.choirul.listfilm;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.choirul.listfilm.database.Database;
import com.choirul.listfilm.models.Films;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmAdapterViewHolder> {

    private ArrayList<Films> films;
    private String id;
    private String judul, sutradara, produser, harga;
    private Database db;

    public FilmAdapter(ArrayList<Films> films) {
        this.films = films;
    }

    @NonNull
    @Override
    public FilmAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_list__film, viewGroup,false);
        return new FilmAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapterViewHolder filmAdapterViewHolder, final int i) {
        filmAdapterViewHolder.text_judul.setText(films.get(i).getJudul());
        filmAdapterViewHolder.text_harga.setText(Integer.toString(films.get(i).getHarga()));

        id = Integer.toString(i);
        judul = films.get(i).getJudul();
        sutradara = films.get(i).getSutradara();
        produser = films.get(i).getProduser();
        harga = Integer.toString(films.get(i).getHarga());


        filmAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Detail(i, v.getContext());
            }
        });
    }

    void Detail(int i, Context contexts){
        Context context = contexts;
        Intent intent = new Intent(context, DetailFilm.class);
        intent.putExtra("id", Integer.toString(i));
        intent.putExtra("judul", films.get(i).getJudul());
        intent.putExtra("Sutradara", films.get(i).getSutradara());
        intent.putExtra("Produser", films.get(i).getProduser());
        intent.putExtra("harga", Integer.toString(films.get(i).getHarga()));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return (films != null) ? films.size() : 0;
    }

    public class FilmAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView text_harga;
        private TextView text_judul;
        Button update, delete;

        public FilmAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            text_judul = itemView.findViewById(R.id.text_judul);
            text_harga = itemView.findViewById(R.id.text_harga);
            update = itemView.findViewById(R.id.button_update);
            delete = itemView.findViewById(R.id.button_delete);

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(v.getContext(),Update_Film.class);
                    intent1.putExtra("id", id);
                    intent1.putExtra("judul", judul);
                    intent1.putExtra("Sutradara", sutradara);
                    intent1.putExtra("Produser", produser);
                    intent1.putExtra("harga", harga);
                    v.getContext().startActivity(intent1);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Home.db.delete(id);
                    Toast.makeText(v.getContext(),"Delete Success", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
