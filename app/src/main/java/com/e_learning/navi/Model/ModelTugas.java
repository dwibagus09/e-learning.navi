package com.e_learning.navi.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelTugas implements Parcelable {
    String kdTugas, deskripsi,start,end;

    public ModelTugas(){}

    public ModelTugas(String kdTugas, String deskripsi, String start, String end) {

        this.kdTugas = kdTugas;
        this.deskripsi = deskripsi;
        this.start = start;
        this.end = end;

    }

    public String getKdTugas() {
        return kdTugas;
    }

    public void setKdTugas(String kdTugas) {
        this.kdTugas = kdTugas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    protected ModelTugas(Parcel in) {
        kdTugas = in.readString();
        deskripsi = in.readString();
        start = in.readString();
        end = in.readString();
    }

    public static final Creator<ModelTugas> CREATOR = new Creator<ModelTugas>() {
        @Override
        public ModelTugas createFromParcel(Parcel in) {
            return new ModelTugas(in);
        }

        @Override
        public ModelTugas[] newArray(int size) {
            return new ModelTugas[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kdTugas);
        dest.writeString(deskripsi);
        dest.writeString(start);
        dest.writeString(end);
    }

}
