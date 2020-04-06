package com.e_learning.login_activtiy;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {
    private RecyclerView rvMateri;
    private ArrayList<Materi> listMateri;
    private TypedArray dataPhotoMateri;
    private String dataNameMateri[];
    private String dataDescMateri[];

    private void prepare(){
        dataPhotoMateri = getResources().obtainTypedArray(R.array.materi_photo);
        dataNameMateri = getResources().getStringArray(R.array.materi_name);
        dataDescMateri = getResources().getStringArray(R.array.materi_desc);
    }
    private void addItem(){
        listMateri = new ArrayList<>();
        for (int i=0; i<dataNameMateri.length; i++){
            Materi materi = new Materi();
            materi.setPhotoMateri(dataPhotoMateri.getResourceId(i,-1));
            materi.setNameMateri(dataNameMateri[i]);
            materi.setDescMateri(dataDescMateri[i]);
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
        View view =  inflater.inflate(R.layout.fragment_materi, container, false);
        rvMateri = view.findViewById(R.id.rv_fragment_materi);
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
