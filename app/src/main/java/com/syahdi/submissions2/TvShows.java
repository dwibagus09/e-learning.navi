package com.syahdi.submissions2;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShows implements Parcelable {
    private int photoTV;
    private String nameTV,descTV,dateTV,rateTV,directorTV;

    TvShows(){

    }

    public int getPhotoTV() {
        return photoTV;
    }

    public void setPhotoTV(int photoTV) {
        this.photoTV = photoTV;
    }

    public String getNameTV() {
        return nameTV;
    }

    public void setNameTV(String nameTV) {
        this.nameTV = nameTV;
    }

    public String getDescTV() {
        return descTV;
    }

    public void setDescTV(String descTV) {
        this.descTV = descTV;
    }

    public String getDateTV() {
        return dateTV;
    }

    public void setDateTV(String dateTV) {
        this.dateTV = dateTV;
    }

    public String getRateTV() {
        return rateTV;
    }

    public void setRateTV(String rateTV) {
        this.rateTV = rateTV;
    }

    public String getDirectorTV() {
        return directorTV;
    }

    public void setDirectorTV(String directorTV) {
        this.directorTV = directorTV;
    }

    public static Creator<TvShows> getCREATOR() {
        return CREATOR;
    }


    //add parcelables implementation
    protected TvShows(Parcel in) {
        photoTV = in.readInt();
        nameTV = in.readString();
        descTV = in.readString();
        dateTV = in.readString();
        rateTV = in.readString();
        directorTV = in.readString();
    }

    public static final Creator<TvShows> CREATOR = new Creator<TvShows>() {
        @Override
        public TvShows createFromParcel(Parcel in) {
            return new TvShows(in);
        }

        @Override
        public TvShows[] newArray(int size) {
            return new TvShows[size];
        }
    };
    // close add
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoTV);
        dest.writeString(nameTV);
        dest.writeString(descTV);
        dest.writeString(dateTV);
        dest.writeString(rateTV);
        dest.writeString(directorTV);
    }
}
