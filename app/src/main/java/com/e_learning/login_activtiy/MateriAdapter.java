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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder>{
    private Context context;
    private ArrayList<Materi> listMateri;

    public MateriAdapter(Context context){
        this.context = context;
        listMateri = new ArrayList<>();
    }
    @NonNull
    @Override
    public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_materi,viewGroup,false);
        return new MateriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
        final Materi materi = listMateri.get(position);
        Glide.with(holder.itemView.getContext())
                .load(materi.getPhotoMateri())
                .apply(new RequestOptions().override(350,550))
                .into(holder.photoM);
        holder.nameM.setText(materi.getNameMateri());
        holder.descM.setText(materi.getDescMateri());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentFilm = new Intent(v.getContext(), DetailMateriActivity.class);
//                intentFilm.putExtra(DetailMateriActivity.EXTRA_FILM, materi);
//                v.getContext().startActivity(intentFilm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    void setMateri(ArrayList<Materi> materi){
        this.listMateri = materi;
    }

    public class MateriViewHolder extends RecyclerView.ViewHolder {
        ImageView photoM;
        TextView nameM,descM;
        public MateriViewHolder(@NonNull View itemView) {
            super(itemView);
            photoM = itemView.findViewById(R.id.img_materi);
            nameM = itemView.findViewById(R.id.name_materi);
            descM = itemView.findViewById(R.id.desc_materi);
        }
    }
}
