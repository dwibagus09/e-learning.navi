package com.elearning.e_learningprojext;

import com.elearning.e_learningprojext.materi.Materi;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    @SerializedName("result")
    ArrayList<Materi> result;

    public ArrayList<Materi> getResult(){
        return result;
    }
    public void setResult(ArrayList<Materi> result){
        this.result = result;
    }
}
