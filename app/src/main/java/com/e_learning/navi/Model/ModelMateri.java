package com.e_learning.navi.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelMateri implements Parcelable {
    String namaMateri, fileMateri;

    public ModelMateri(){}

    public ModelMateri(String namaMateri, String fileMateri) {

        this.namaMateri = namaMateri;
        this.fileMateri = fileMateri;

    }
    public String getNamaMateri() {
        return namaMateri;
    }

    public void setNamaMateri(String namaMateri) {
        this.namaMateri = namaMateri;
    }

    public String getFileMateri() {
        return fileMateri;
    }

    public void setFileMateri(String fileMateri) {
        this.fileMateri = fileMateri;
    }

    //=========================================================================

    protected ModelMateri(Parcel in) {
        namaMateri = in.readString();
        fileMateri = in.readString();
    }

    public static final Creator<ModelMateri> CREATOR = new Creator<ModelMateri>() {
        @Override
        public ModelMateri createFromParcel(Parcel in) {
            return new ModelMateri(in);
        }

        @Override
        public ModelMateri[] newArray(int size) {
            return new ModelMateri[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaMateri);
        dest.writeString(fileMateri);
    }
}
