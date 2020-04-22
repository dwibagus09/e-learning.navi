package com.elearning.navi;

import android.app.ProgressDialog;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
public class TugasFragment extends Fragment {
    private RecyclerView rvTugas;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager rLayoutmanager;
    private ArrayList<Tugas> listTugas;
    Button btnDownload;
    private TypedArray dataImgT;
    private String dataNameT[];
    private String dataDescT[];
    private ProgressDialog pd;

//    private void prepare(){
//        dataImgT = getResources().obtainTypedArray(R.array.tugas_img);
//        dataNameT = getResources().getStringArray(R.array.tugas_name);
//        dataDescT = getResources().getStringArray(R.array.tugas_desc);
//    }
//
//    private void addItem(){
//        listTugas = new ArrayList<>();
//        for (int i=0;i<dataNameT.length;i++){
//            Tugas tugas = new Tugas();
//            tugas.setImgT(dataImgT.getResourceId(i,-1));
//            tugas.setNamaT(dataNameT[i]);
//            tugas.setDescT(dataDescT[i]);
//
//            listTugas.add(tugas);
//        }
//    }

    public TugasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tugas, container, false);
        rvTugas = view.findViewById(R.id.rv_tugas);
        rvTugas.setHasFixedSize(true);
        btnDownload = view.findViewById(R.id.btn_T);
        pd = new ProgressDialog(TugasFragment.this.getContext());
        listTugas = new ArrayList<>();
//        prepare();
//        addItem();

        loadJson();

        showRecyclerTugas();
        //        btnDownload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
        return view;
    }

    private void showRecyclerTugas(){
//        rvTugas.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        TugasAdapter tugasAdapter = new TugasAdapter(this.getContext());
//        tugasAdapter.setTugas(listTugas);
//        rvTugas.setAdapter(tugasAdapter);
        rLayoutmanager = new LinearLayoutManager(TugasFragment.this.getContext(),LinearLayoutManager.VERTICAL,false);
        rvTugas.setLayoutManager(rLayoutmanager);
        rAdapter = new TugasAdapter(TugasFragment.this.getContext(),listTugas);
        rvTugas.setAdapter(rAdapter);
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
                                Tugas tugas = new Tugas();
                                tugas.setNamaT(data.getString("namaT"));
                                tugas.setDescT(data.getString("descT"));
                                listTugas.add(tugas);
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
