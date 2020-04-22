package com.elearning.navi;

import android.app.ProgressDialog;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.elearning.navi.utilities.AppController;
import com.elearning.navi.utilities.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {
    private RecyclerView rvMateri;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager rLayoutmanager;
    private ArrayList<Materi> listMateri;
    Button btnDownload;
    private TypedArray dataImgM;
    private String dataNameM[];
    private String dataDescM[];
    private ProgressDialog pd;

//    private void prepare(){
//        dataImgM = getResources().obtainTypedArray(R.array.materi_img);
//        dataNameM = getResources().getStringArray(R.array.materi_name);
//        dataDescM = getResources().getStringArray(R.array.materi_desc);
//    }
//
//    private void addItem(){
//        listMateri = new ArrayList<>();
//        for (int i = 0; i<dataNameM.length; i++){
//            Materi materi = new Materi();
//            materi.setImgM(dataImgM.getResourceId(i,-1));
//            materi.setNameM(dataNameM[i]);
//            materi.setDescM(dataDescM[i]);
//
//            listMateri.add(materi);
//        }
//    }

    public MateriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi,container,false);
        rvMateri = view.findViewById(R.id.rv_materi);
        rvMateri.setHasFixedSize(true);
        btnDownload = view.findViewById(R.id.btn_M);
        pd = new ProgressDialog(MateriFragment.this.getContext());
        listMateri = new ArrayList<>();
//        prepare();
//        addItem();

        loadJson();

        showRecyclerMateri();

//        btnDownload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
        return view;
    }

    private void showRecyclerMateri(){
//        rvMateri.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        MateriAdapter materiAdapter = new MateriAdapter(this.getContext());
//        materiAdapter.setMateri(listMateri);
//        rvMateri.setAdapter(materiAdapter);
        rLayoutmanager = new LinearLayoutManager(MateriFragment.this.getContext(),LinearLayoutManager.VERTICAL,false);
        rvMateri.setLayoutManager(rLayoutmanager);
        rAdapter = new MateriAdapter(MateriFragment.this.getContext(),listMateri);
        rvMateri.setAdapter(rAdapter);
    }

    private void loadJson(){
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServerAPI.URL_DATA,null,
        new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley", "response: "+response.toString());
                        for (int i=0;i<response.length();i++){
                            try {
                                JSONObject data = response.getJSONObject(i);
                                Materi materi = new Materi();
                                materi.setNameM(data.getString("Materi"));
                                materi.setDescM(data.getString("Deskripsi"));
                                listMateri.add(materi);
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                        rAdapter.notifyDataSetChanged();
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                pd.cancel();
                                Log.d("volley", "error: "+error.getMessage());
                            }
                        });
        AppController.getInstance().addToRequestQueue(reqData);
    }
}
