package com.e_learning.login_activtiy;

import android.os.Parcel;
import android.os.Parcelable;

public class Tugas implements Parcelable {
    private int photoTugas;
    private String nameTugas,descTugas;

    Tugas(){

    }

    public int getPhotoTugas() {
        return photoTugas;
    }

    public void setPhotoTugas(int photoTugas) {
        this.photoTugas = photoTugas;
    }

    public String getNameTugas() {
        return nameTugas;
    }

    public void setNameTugas(String nameTugas) {
        this.nameTugas = nameTugas;
    }

    public String getDescTugas() {
        return descTugas;
    }

    public void setDescTugas(String descTugas) {
        this.descTugas = descTugas;
    }
    public static Creator<Tugas> getCREATOR() {
        return CREATOR;
    }


    protected Tugas(Parcel in) {
        photoTugas = in.readInt();
        nameTugas = in.readString();
        descTugas = in.readString();
    }

    public static final Creator<Tugas> CREATOR = new Creator<Tugas>() {
        @Override
        public Tugas createFromParcel(Parcel in) {
            return new Tugas(in);
        }

        @Override
        public Tugas[] newArray(int size) {
            return new Tugas[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoTugas);
        dest.writeString(nameTugas);
        dest.writeString(descTugas);
    }
}
