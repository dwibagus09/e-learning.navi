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
public class TvShowsFragment extends Fragment {
    private RecyclerView rvTvShows;
    private ArrayList<TvShows> listTvShows;
    private TypedArray dataPhotoTV;
    private String dataNameTV[];
    private String dataDescTV[];

    private void prepare(){
        dataPhotoTV = getResources().obtainTypedArray(R.array.tv_show_photo);
        dataNameTV = getResources().getStringArray(R.array.tv_show_name);
        dataDescTV = getResources().getStringArray(R.array.tv_show_desc);
    }
    private void addItem(){
        listTvShows = new ArrayList<>();
        for (int i=0; i<dataNameTV.length; i++){
            TvShows tvShows = new TvShows();
            tvShows.setPhotoTV(dataPhotoTV.getResourceId(i,-1));
            tvShows.setNameTV(dataNameTV[i]);
            tvShows.setDescTV(dataDescTV[i]);

            listTvShows.add(tvShows);
        }
    }

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        rvTvShows = view.findViewById(R.id.rv_fragment_tv_shows);
        rvTvShows.setHasFixedSize(true);

        prepare();
        addItem();

        showRecyclerViewTvShows();
        return view;
    }

    private void showRecyclerViewTvShows(){
        rvTvShows.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TvShowsAdapter tvShowsAdapter = new TvShowsAdapter(this.getContext());
        tvShowsAdapter.setTvShows(listTvShows);
        rvTvShows.setAdapter(tvShowsAdapter);
    }
}
