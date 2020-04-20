package com.elearning.navi;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder> {
    private Context context;
    private ArrayList<Materi> listMateri;

    public MateriAdapter(Context context){
        this.context = context;
        listMateri = new ArrayList<>();
    }
    void setMateri(ArrayList<Materi> materis){
        this.listMateri = materis;
    }
    @NonNull
    @Override
    public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_materi,viewGroup,false);
        return new MateriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
        final Materi materi = listMateri.get(position);
        holder.tvNameM.setText(materi.getNameM());
        holder.tvDescM.setText(materi.getDescM());
        //button function
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listMateri.size();
    }

    public class MateriViewHolder extends RecyclerView.ViewHolder {
        ImageView imgViewM;
        TextView tvNameM,tvDescM;
        Button btnDownload;
        public MateriViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewM = itemView.findViewById(R.id.image_M);
            tvNameM = itemView.findViewById(R.id.namaM);
            tvDescM = itemView.findViewById(R.id.descM);
            btnDownload = itemView.findViewById(R.id.btn_M);
        }
    }
}
