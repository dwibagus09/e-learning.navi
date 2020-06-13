package com.e_learning.navi.Adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.e_learning.navi.Model.ModelMateri;
import com.arvita.crudvolley.R;

import java.util.List;


public class DataMateriAdapter extends RecyclerView.Adapter<DataMateriAdapter.HolderData> {
    private List<ModelMateri> mItems ;
    private Context context;

    public DataMateriAdapter(Context context, List<ModelMateri> items){
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row_materi,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelMateri md  = mItems.get(position);

        holder.tvNamaM.setText(md.getNamaMateri());
        holder.tvFileM.setText(md.getFileMateri());

        holder.md = md;


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder{
        TextView tvNamaM,tvFileM;
        ModelMateri md;
        Button download;

        public  HolderData (View view) {
            super(view);
            tvNamaM =  view.findViewById(R.id.nama_materi);
            tvFileM =  view.findViewById(R.id.file_materi);
            download = view.findViewById(R.id.download);
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent update = new Intent(context, InsertData.class);
//                    update.putExtra("update",1);
//                    update.putExtra("username",md.getUsername());
//                    update.putExtra("grup",md.getGrup());
//                    update.putExtra("nama",md.getNama());
//                    update.putExtra("password",md.getPassword());
//
//                    context.startActivity(update);
//                }
//            });
        }
    }
}
