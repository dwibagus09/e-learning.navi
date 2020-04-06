package com.syahdi.submissions2;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int photoFilm;
    private String nameFilm,descFilm,dateFilm,rateFilm,directorFilm;

    Film(){

    }

    public int getPhotoFilm() {
        return photoFilm;
    }

    public void setPhotoFilm(int photoFilm) {
        this.photoFilm = photoFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getDescFilm() {
        return descFilm;
    }

    public void setDescFilm(String descFilm) {
        this.descFilm = descFilm;
    }

    public String getDateFilm() {
        return dateFilm;
    }

    public void setDateFilm(String dateFilm) {
        this.dateFilm = dateFilm;
    }

    public String getRateFilm() {
        return rateFilm;
    }

    public void setRateFilm(String rateFilm) {
        this.rateFilm = rateFilm;
    }

    public String getDirectorFilm() {
        return directorFilm;
    }

    public void setDirectorFilm(String directorFilm) {
        this.directorFilm = directorFilm;
    }

    public static Creator<Film> getCREATOR() {
        return CREATOR;
    }


    protected Film(Parcel in) {
        photoFilm = in.readInt();
        nameFilm = in.readString();
        descFilm = in.readString();
        dateFilm = in.readString();
        rateFilm = in.readString();
        directorFilm = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoFilm);
        dest.writeString(nameFilm);
        dest.writeString(descFilm);
        dest.writeString(dateFilm);
        dest.writeString(rateFilm);
        dest.writeString(directorFilm);
    }
}
