package com.e_learning.login_activtiy;

import android.os.Parcel;
import android.os.Parcelable;

public class Materi implements Parcelable {
    private int photoMateri;
    private String nameMateri,descMateri;

    Materi(){

    }

    public static final Creator<Materi> CREATOR = new Creator<Materi>() {
        @Override
        public Materi createFromParcel(Parcel in) {
            return new Materi(in);
        }

        @Override
        public Materi[] newArray(int size) {
            return new Materi[size];
        }
    };

    public int getPhotoMateri() {
        return photoMateri;
    }

    public void setPhotoMateri(int photoMateri) {
        this.photoMateri = photoMateri;
    }

    public String getNameMateri() {
        return nameMateri;
    }

    public void setNameMateri(String nameMateri) {
        this.nameMateri = nameMateri;
    }

    public String getDescMateri() {
        return descMateri;
    }

    public void setDescMateri(String descMateri) {
        this.descMateri = descMateri;
    }
    public static Creator<Materi> getCREATOR() {
        return CREATOR;
    }

    protected Materi(Parcel in) {
        photoMateri = in.readInt();
        nameMateri = in.readString();
        descMateri = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoMateri);
        dest.writeString(nameMateri);
        dest.writeString(descMateri);
    }
}
