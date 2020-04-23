package com.example.e_learningnavi.materi;

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
public class MateriFragment extends Fragment {
    private RecyclerView rvMateri;
    private ArrayList<Materi> listMateri;
    Button btnDownload;
    private TypedArray dataImgM;
    private String dataNameM[];
    private String dataDescM[];

    private void prepare(){
        dataNameM = getResources().getStringArray(R.array.materi);
        dataDescM = getResources().getStringArray(R.array.desc_m);
    }

    private void addItem(){
        listMateri = new ArrayList<>();
        for (int i = 0; i<dataNameM.length; i++){
            Materi materi = new Materi();
            materi.setNameM(dataNameM[i]);
            materi.setDescM(dataDescM[i]);

            listMateri.add(materi);
        }
    }

    public MateriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi,container,false);
        rvMateri = view.findViewById(R.id.rv_mat);
        rvMateri.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerMateri();
        return view;
    }
    private void showRecyclerMateri(){
        rvMateri.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MateriAdapter materiAdapter = new MateriAdapter(this.getContext());
        materiAdapter.setMateri(listMateri);
        rvMateri.setAdapter(materiAdapter);
    }
}
