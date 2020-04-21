package com.elearning.navi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    public TugasAdapter(Context context){
        this.context = context;
        listTugas = new ArrayList<>();
    }

    void setTugas(ArrayList<Tugas> tugases){
        this.listTugas = tugases;
    }

    @NonNull
    @Override
    public TugasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_tugas,viewGroup,false);
        return new TugasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasViewHolder holder, int position) {
        final Tugas tugas = listTugas.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tugas.getImgT())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgViewT);
        holder.tvNameT.setText(tugas.getNamaT());
        holder.tvDescT.setText(tugas.getDescT());
        //button
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listTugas.size();
    }

    public class TugasViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewT;
        TextView tvNameT,tvDescT;
        Button btnDownload;
        public TugasViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewT = itemView.findViewById(R.id.image_T);
            tvNameT = itemView.findViewById(R.id.namaT);
            tvDescT = itemView.findViewById(R.id.descT);
            btnDownload = itemView.findViewById(R.id.btn_T);
        }
    }
}
