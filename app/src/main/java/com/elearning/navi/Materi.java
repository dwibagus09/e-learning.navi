package com.elearning.navi;

import android.os.Parcel;
import android.os.Parcelable;

public class Materi implements Parcelable {
    private String nameM,descM;


    Materi(){

    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    public String getNameM() {
        return nameM;
    }

    public void setDescM(String descM) {
        this.descM = descM;
    }

    public String getDescM() {
        return descM;
    }

    public static Creator<Materi> getCreator(){
        return CREATOR;
    }

    protected Materi(Parcel in) {
        nameM = in.readString();
        descM = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameM);
        dest.writeString(descM);
    }
}
