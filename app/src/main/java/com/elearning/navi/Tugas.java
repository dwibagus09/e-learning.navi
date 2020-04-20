package com.elearning.navi;

import android.os.Parcel;
import android.os.Parcelable;

public class Tugas implements Parcelable {
    String namaT,descT;

    Tugas(){

    }

    public void setNamaT(String namaT) {
        this.namaT = namaT;
    }

    public String getNamaT() {
        return namaT;
    }

    public void setDescT(String descT) {
        this.descT = descT;
    }

    public String getDescT() {
        return descT;
    }

    protected Tugas(Parcel in) {
        namaT = in.readString();
        descT = in.readString();
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
        dest.writeString(namaT);
        dest.writeString(descT);
    }
}
