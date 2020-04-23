package com.example.e_learningnavi.tugas;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_learningnavi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TugasFragment extends Fragment {
    private RecyclerView rvTugas;
    private ArrayList<Tugas> listTugas;
    Button btnDownload;
    private TypedArray dataImgT;
    private String dataNameT[];
    private String dataDescT[];

    private void prepare(){
        dataNameT = getResources().getStringArray(R.array.tugas);
        dataDescT = getResources().getStringArray(R.array.desc_t);
    }

    private void addItem(){
        listTugas = new ArrayList<>();
        for (int i=0;i<dataNameT.length;i++){
            Tugas tugas = new Tugas();
            tugas.setNamaT(dataNameT[i]);
            tugas.setDescT(dataDescT[i]);

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
        View view = inflater.inflate(R.layout.fragment_tugas, container, false);
        rvTugas = view.findViewById(R.id.rv_tugas);
        rvTugas.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerTugas();
        return view;
    }
    private void showRecyclerTugas() {
        rvTugas.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TugasAdapter tugasAdapter = new TugasAdapter(this.getContext());
        tugasAdapter.setTugas(listTugas);
        rvTugas.setAdapter(tugasAdapter);
    }
}