package com.elearning.e_learningprojext.service;
import com.elearning.e_learningprojext.materi.Materi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetService {
    @GET("/api/")
    Call<List<Materi>> getMateri();
}
