package com.e_learning.login_activtiy;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TugasFragment extends Fragment {
    private RecyclerView rvTugas;
    private ArrayList<Tugas> listTugas;
    private TypedArray dataPhotoTugas;
    private String dataNameTugas[];
    private String dataDescTugas[];

    private void prepare(){
        dataPhotoTugas = getResources().obtainTypedArray(R.array.tugas_photo);
        dataNameTugas = getResources().getStringArray(R.array.tugas_name);
        dataDescTugas = getResources().getStringArray(R.array.tugas_desc);
    }
    private void addItem(){
        listTugas = new ArrayList<>();
        for (int i=0; i<dataNameTugas.length; i++){
            Tugas tugas = new Tugas();
            tugas.setPhotoTugas(dataPhotoTugas.getResourceId(i,-1));
            tugas.setNameTugas(dataNameTugas[i]);
            tugas.setDescTugas(dataDescTugas[i]);
            listTugas.add(tugas);
        }
    }
    public TugasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tugas, container, false);
        rvTugas = view.findViewById(R.id.rv_fragment_tugas);
        rvTugas.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerTugas();
        return view;
    }
    private void showRecyclerTugas(){
        rvTugas.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TugasAdapter tugasAdapter = new TugasAdapter(this.getContext());
        tugasAdapter.setTugas(listTugas);
        rvTugas.setAdapter(tugasAdapter);
    }

}
