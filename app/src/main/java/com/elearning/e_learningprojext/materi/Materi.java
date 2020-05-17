package com.elearning.e_learningprojext.materi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Materi {
    @SerializedName("id_materi")
    private int id_materi;
    @SerializedName("nama_materi")
    private String nama_materi;
    @SerializedName("file_materi")
    private String file_materi;
    @SerializedName("id_mengajar")
    private int id_mengajar;
    @SerializedName("id_kelas")
    private int id_kelas;

    Materi(){

    }

    public Materi(int id_materi, String nama_materi, String file_materi, int id_mengajar, int id_kelas) {
        this.id_materi = id_materi;
        this.nama_materi = nama_materi;
        this.file_materi = file_materi;
        this.id_mengajar = id_mengajar;
        this.id_kelas = id_kelas;
    }

    public int getId_materi() {
        return id_materi;
    }

    public void setId_materi(int id_materi) {
        this.id_materi = id_materi;
    }

    public String getNama_materi() {
        return nama_materi;
    }

    public void setNama_materi(String nama_materi) {
        this.nama_materi = nama_materi;
    }

    public String getFile_materi() {
        return file_materi;
    }

    public void setFile_materi(String file_materi) {
        this.file_materi = file_materi;
    }

    public int getId_mengajar() {
        return id_mengajar;
    }

    public void setId_mengajar(int id_mengajar) {
        this.id_mengajar = id_mengajar;
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
    }
}
