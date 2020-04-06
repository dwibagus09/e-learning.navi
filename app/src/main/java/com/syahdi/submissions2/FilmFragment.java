package com.syahdi.submissions2;

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
public class FilmFragment extends Fragment {
    private RecyclerView rvFilm;
    private ArrayList<Film> listFilm;
    private TypedArray dataPhotoFilm;
    private String dataNameFilm[];
    private String dataDescFilm[];

    private void prepare(){
        dataPhotoFilm = getResources().obtainTypedArray(R.array.film_photo);
        dataNameFilm = getResources().getStringArray(R.array.film_name);
        dataDescFilm = getResources().getStringArray(R.array.film_desc);
    }
    private void addItem(){
        listFilm = new ArrayList<>();
        for (int i=0; i<dataNameFilm.length; i++){
            Film films = new Film();
            films.setPhotoFilm(dataPhotoFilm.getResourceId(i,-1));
            films.setNameFilm(dataNameFilm[i]);
            films.setDescFilm(dataDescFilm[i]);

            listFilm.add(films);
        }
    }
    public FilmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_film, container, false);
        rvFilm = view.findViewById(R.id.rv_fragment_film);
        rvFilm.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerFilm();
        return view;
    }

    private void showRecyclerFilm(){
        rvFilm.setLayoutManager(new LinearLayoutManager(this.getContext()));
        FilmAdapter filmAdapter = new FilmAdapter(this.getContext());
        filmAdapter.setFilm(listFilm);
        rvFilm.setAdapter(filmAdapter);
    }
}
