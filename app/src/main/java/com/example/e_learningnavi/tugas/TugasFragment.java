package com.example.e_learningnavi.tugas;

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
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.e_learningnavi.R;
import com.example.e_learningnavi.materi.Materi;
import com.example.e_learningnavi.util.AppController;
import com.example.e_learningnavi.util.ServiceAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TugasFragment extends Fragment {
    private RecyclerView rvTugas;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    private ArrayList<Tugas> listTugas;
    ProgressDialog pd;

    Button btnDownload;
    private TypedArray dataImgT;
    private String dataNameT[];
    private String dataDescT[];

    private void prepare(){
        dataNameT = getResources().getStringArray(R.array.tugas);
        dataDescT = getResources().getStringArray(R.array.desc_t);
    }

    private void addItem(){
        listTugas = new ArrayList<>();
        for (int i=0;i<dataNameT.length;i++){
            Tugas tugas = new Tugas();
            tugas.setNamaT(dataNameT[i]);
            tugas.setDescT(dataDescT[i]);

            listTugas.add(tugas);
        }
    }

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
        pd = new ProgressDialog(TugasFragment.this.getContext());
        listTugas = new ArrayList<>();

//        loadJson();

        prepare();
        addItem();
        showRecyclerTugas();
        return view;
    }
    private void showRecyclerTugas() {
        rvTugas.setLayoutManager(new LinearLayoutManager(this.getContext()));
        TugasAdapter tugasAdapter = new TugasAdapter(this.getContext());
        tugasAdapter.setTugas(listTugas);
        rvTugas.setAdapter(tugasAdapter);
//        mManager = new LinearLayoutManager(TugasFragment.this.getContext(),LinearLayoutManager.VERTICAL,false);
//        rvTugas.setLayoutManager(mManager);
//        mAdapter = new TugasAdapter(TugasFragment.this.getContext(),listTugas);
//        rvTugas.setAdapter(mAdapter);
    }

//    private void loadJson(){
//        pd.setMessage("Mengambil Data");
//        pd.setCancelable(false);
//        pd.show();
//
//        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServiceAPI.URL_DATA, null,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        pd.cancel();
//                        Log.d("volley", "response: " + response.toString());
//                        for (int i=0; i < response.length(); i++) {
//                            try {
//                                JSONObject data = response.getJSONObject(i);
//                                Tugas tg = new Tugas();
//                                tg.setNamaT(data.getString("namaT"));
//                                tg.setDescT(data.getString("descT"));
//                                listTugas.add(tg);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        mAdapter.notifyDataSetChanged();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        pd.cancel();
//                        Log.d("volley", "error: "+error.getMessage());
//                    }
//                });
//        AppController.getInstance().addToRequestQueue(reqData);
//    }
}
