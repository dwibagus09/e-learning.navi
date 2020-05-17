package com.elearning.e_learningprojext.materi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.elearning.e_learningprojext.R;

import com.elearning.e_learningprojext.Result;
import com.elearning.e_learningprojext.service.GetService;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {
    private RecyclerView mRecyclerView;
    public static final String BASE_URL = "http://192.168.43.60/E-learning/index.php/Page_guru/api/";
    private RecyclerView.LayoutManager mLayoutManager;
//    ProgressBar progressBar;
//    private ArrayList<Materi> listMateri;
//    private TypedArray dataImgM;
//    private String dataNameM[];
//    private String dataDescM[];

//        private void prepare(){
////        dataImgM = getResources().obtainTypedArray(R.array.film_photo);
////        dataNameM = getResources().getStringArray(R.array.film_name);
////        dataDescM = getResources().getStringArray(R.array.film_desc);
////    }
////
////    private void addItem(){
////        listMateri = new ArrayList<>();
////        for (int i = 0; i<dataNameM.length; i++){
////            Materi materi = new Materi();
////            materi.setImgM(dataImgM.getResourceId(i,-1));
////            materi.setNameM(dataNameM[i]);
////            materi.setDescM(dataDescM[i]);
////
////            listMateri.add(materi);
////        }
//    }

    public MateriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi, container, false);
        mRecyclerView = view.findViewById(R.id.rv_materi);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        getDataMateri();
        return view;
    }
    void getDataMateri(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetService service = retrofit.create(GetService.class);
        Call<Result> getMateri = service.getMateri();
       getMateri.enqueue(new Callback<Result>() {
           @Override
           public void onResponse(Call<Result> call, Response<Result> response) {
               MateriAdapter adapter = new MateriAdapter(getContext(),response.body().getResult());
               adapter.notifyDataSetChanged();
               mRecyclerView.setAdapter(adapter);
           }

           @Override
           public void onFailure(Call<Result> call, Throwable t) {
               t.printStackTrace();
           }
       });
    }
}
