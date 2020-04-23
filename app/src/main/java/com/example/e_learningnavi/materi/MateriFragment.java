package com.example.e_learningnavi.materi;

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
import com.example.e_learningnavi.util.AppController;
import com.example.e_learningnavi.util.ServiceAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MateriFragment extends Fragment {
    private RecyclerView rvMateri;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    ProgressDialog pd;
    private ArrayList<Materi> listMateri;

    Button btnDownload;
    private TypedArray dataImgM;
    private String dataNameM[];
    private String dataDescM[];

//    private void prepare(){
//        dataNameM = getResources().getStringArray(R.array.materi);
//        dataDescM = getResources().getStringArray(R.array.desc_m);
//    }
//
//    private void addItem(){
//        listMateri = new ArrayList<>();
//        for (int i = 0; i<dataNameM.length; i++){
//            Materi materi = new Materi();
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
        View view = inflater.inflate(R.layout.fragment_materi, container, false);
        rvMateri = view.findViewById(R.id.rv_mat);
        rvMateri.setHasFixedSize(true);
        pd = new ProgressDialog(MateriFragment.this.getContext());
        listMateri = new ArrayList<>();

        loadJson();

//        prepare();
//        addItem();
        showRecyclerMateri();
        return view;
    }

    private void showRecyclerMateri() {
//        rvMateri.setLayoutManager(new LinearLayoutManager(this.getContext()));
//        MateriAdapter materiAdapter = new MateriAdapter(this.getContext());
//        materiAdapter.setMateri(listMateri);
//        rvMateri.setAdapter(materiAdapter);
        mManager = new LinearLayoutManager(MateriFragment.this.getContext(), LinearLayoutManager.VERTICAL, false);
        rvMateri.setLayoutManager(mManager);
        mAdapter = new MateriAdapter(MateriFragment.this.getContext(), listMateri);
        rvMateri.setAdapter(mAdapter);
    }

    private void loadJson(){
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, ServiceAPI.URL_DATA, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley", "response: " + response.toString());
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                Materi mt = new Materi();
                                mt.setNameM(data.getString("namaM"));
                                mt.setDescM(data.getString("descM"));
                                listMateri.add(mt);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
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
