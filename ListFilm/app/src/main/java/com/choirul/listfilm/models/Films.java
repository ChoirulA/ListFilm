package com.choirul.listfilm.models;

public class Films {
    private String Judul;
    private String Sutradara;
    private String Produser;
    private int harga;

    public Films(String judul, String sutradara, String produser, int harga) {
        this.Judul = judul;
        this.Sutradara = sutradara;
        this.Produser = produser;
        this.harga = harga;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getSutradara() {
        return Sutradara;
    }

    public void setSutradara(String sutradara) {
        Sutradara = sutradara;
    }

    public String getProduser() {
        return Produser;
    }

    public void setProduser(String produser) {
        Produser = produser;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
