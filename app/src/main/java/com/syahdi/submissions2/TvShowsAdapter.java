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

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowsAdapterViewHolder> {
    private Context context;
    private ArrayList<TvShows> listTvShows;

    public TvShowsAdapter(Context context){
        this.context = context;
        listTvShows = new ArrayList<>();
    }
    @NonNull
    @Override
    public TvShowsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show,viewGroup,false);
        return new TvShowsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowsAdapterViewHolder holder, int position) {
        final TvShows tvShows = listTvShows.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tvShows.getPhotoTV())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhotoTV);
        holder.tvNameTV.setText(tvShows.getNameTV());
        holder.tvDescTV.setText(tvShows.getDescTV());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTvShows = new Intent(v.getContext(), DetailTvShowsActivity.class);
                intentTvShows.putExtra(DetailTvShowsActivity.EXTRA_TV, tvShows);
                v.getContext().startActivity(intentTvShows);
            }
        });
    }

    @Override
    public int getItemCount() {
       return listTvShows.size();
    }
    void setTvShows(ArrayList<TvShows> tvShows){
        this.listTvShows = tvShows;
    }

    public class TvShowsAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhotoTV;
        TextView tvNameTV,tvDescTV,tvDateTV,tvRateTV,tvDiectorTV;
        public TvShowsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhotoTV= itemView.findViewById(R.id.img_tv_show);
            tvNameTV = itemView.findViewById(R.id.name_tv_show);
            tvDescTV = itemView.findViewById(R.id.desc_tv_show);

        }
    }
}
