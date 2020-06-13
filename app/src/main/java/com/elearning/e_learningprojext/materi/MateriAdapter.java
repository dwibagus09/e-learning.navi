package com.elearning.e_learningprojext.materi;

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
import com.elearning.e_learningprojext.R;

import java.util.ArrayList;
import java.util.List;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder> {
    private Context context;
    List<Materi> dataList;

    public MateriAdapter(Context context,List<Materi> dataList){
        this.context = context;
        this.dataList = dataList;
    }
//    void setMateri(ArrayList<Materi> materis){
//        this.dataList = materis;
//    }
    @NonNull
    @Override
    public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.layout_materi, viewGroup, false);
        return new MateriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
        final Materi materi = dataList.get(position);
        holder.mTextIdMateri.setText("Id : "+ materi.getId_kelas());
        holder.mTextNamaMateri.setText("Nama Materi : "+materi.getNama_materi());
        holder.mTextFileMateri.setText("File Materi : "+materi.getFile_materi());
        holder.mTextIdMengajar.setText("Id Mengaajr : "+materi.getId_mengajar());
        holder.mTextIdKelas.setText("Id kelas : "+materi.getId_kelas());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MateriViewHolder extends RecyclerView.ViewHolder {
        TextView mTextIdMateri,mTextNamaMateri,mTextFileMateri,mTextIdMengajar,mTextIdKelas;
//        Button btnDownload;
        public MateriViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextIdMateri = itemView.findViewById(R.id.id_materi);
            mTextNamaMateri = itemView.findViewById(R.id.nama_materi);
            mTextFileMateri = itemView.findViewById(R.id.file_materi);
            mTextIdMengajar = itemView.findViewById(R.id.id_mengajar);
            mTextIdKelas = itemView.findViewById(R.id.id_kelas);
//            btnDownload = itemView.findViewById(R.id.btn_M);
        }
    }
}
