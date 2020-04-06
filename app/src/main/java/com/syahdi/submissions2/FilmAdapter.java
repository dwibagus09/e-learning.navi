package com.syahdi.submissions2;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {
    private Context context;
    private ArrayList<Film> listFilms;

    public FilmAdapter(Context context){
        this.context = context;
        listFilms = new ArrayList<>();
    }
    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film,viewGroup,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        final Film film = listFilms.get(position);
        Glide.with(holder.itemView.getContext())
                .load(film.getPhotoFilm())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhotoFilm);
        holder.tvNameFilm.setText(film.getNameFilm());
        holder.tvDescFilm.setText(film.getDescFilm());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFilm = new Intent(v.getContext(), DetailFilmActivity.class);
                intentFilm.putExtra(DetailFilmActivity.EXTRA_FILM, film);
                v.getContext().startActivity(intentFilm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFilms.size();
    }
    void setFilm(ArrayList<Film> films){
        this.listFilms = films;
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotoFilm;
        TextView tvNameFilm,tvDescFilm,tvDateFilm,tvRateFilm,tvDirectorFilm;
        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhotoFilm = itemView.findViewById(R.id.img_film);
            tvNameFilm = itemView.findViewById(R.id.name_film);
            tvDescFilm = itemView.findViewById(R.id.desc_film);
        }
    }
}
