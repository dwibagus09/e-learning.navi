package com.elearning.e_learningprojext.materi;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.elearning.e_learningprojext.R;

import com.elearning.e_learningprojext.Result;
import com.elearning.e_learningprojext.service.ApiClient;
import com.elearning.e_learningprojext.service.GetService;


import java.util.ArrayList;
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

    ProgressDialog pd;

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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi, container, false);
        pd = new ProgressDialog(getContext());
        pd.setMessage("Loading...");
        pd.show();
        GetService service = ApiClient.getRetrofitInstance().create(GetService.class);
        Call<List<Materi>> call =service.getMateri();
        call.enqueue(new Callback<List<Materi>>() {
            @Override
            public void onResponse(Call<List<Materi>> call, Response<List<Materi>> response) {
                pd.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Materi>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(getContext(), "Gagal Memuat", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void generateDataList(List<Materi> materiList){
        RecyclerView recyclerView = getView().findViewById(R.id.rv_materi);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.Adapter adapter = new MateriAdapter(getContext(),materiList);
        recyclerView.setAdapter(adapter);
    }
}
