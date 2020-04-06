package com.e_learning.login_activtiy;

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

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.TugasViewHolder> {
    private Context context;
    private ArrayList<Tugas> listTugas;

    public TugasAdapter (Context context){
        this.context = context;
        listTugas = new ArrayList<>();
    }
    void setTugas(ArrayList<Tugas> tugas){
        this.listTugas = tugas;
    }
    @NonNull
    @Override
    public TugasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tugas,viewGroup,false);
        return new TugasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasViewHolder holder, int position) {
        final Tugas tugas = listTugas.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tugas.getPhotoTugas())
                .apply(new RequestOptions().override(350,550))
                .into(holder.photoT);
        holder.nameT.setText(tugas.getNameTugas());
        holder.descT.setText(tugas.getDescTugas());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentTvShows = new Intent(v.getContext(), DetailTugasActivity.class);
//                intentTvShows.putExtra(DetailTugasActivity.EXTRA_TV, tvShows);
//                v.getContext().startActivity(intentTvShows);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TugasViewHolder extends RecyclerView.ViewHolder {
        ImageView photoT;
        TextView nameT,descT;
        public TugasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
