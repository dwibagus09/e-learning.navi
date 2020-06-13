package com.e_learning.navi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arvita.crudvolley.R;
import com.e_learning.navi.Detail.DetailTugasActivity;
import com.e_learning.navi.Model.ModelMateri;
import com.e_learning.navi.Model.ModelTugas;

import java.util.List;


public class DataTugasAdapter extends RecyclerView.Adapter<DataTugasAdapter.HolderData> {
    private List<ModelTugas> mItems ;
    private Context context;

    public DataTugasAdapter(Context context, List<ModelTugas> items){
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_tugas,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        final ModelTugas mt  = mItems.get(position);

        holder.tvKdTugas.setText(mt.getKdTugas());
        holder.tvDeskripsi.setText(mt.getDeskripsi());
        holder.tvStart.setText(mt.getStart());
        holder.tvEnd.setText(mt.getEnd());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tugasDetailIntent = new Intent(v.getContext(), DetailTugasActivity.class);
                tugasDetailIntent.putExtra(DetailTugasActivity.EXTRA_TUGAS, mt);
                v.getContext().startActivity(tugasDetailIntent);
            }
        });

        holder.mt = mt;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder{
        TextView tvKdTugas,tvDeskripsi,tvStart,tvEnd;
        ModelTugas mt;
        public  HolderData (View view) {
            super(view);
            tvKdTugas =  view.findViewById(R.id.kd_tugas);
            tvDeskripsi =  view.findViewById(R.id.deskripsi);
            tvStart = view.findViewById(R.id.start);
            tvEnd = view.findViewById(R.id.end);
        }
    }
}
