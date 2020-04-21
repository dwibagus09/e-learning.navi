package com.elearning.navi;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.elearning.navi.utilities.ServerAPI;
import com.elearning.navi.utilities.AppController;
import com.elearning.navi.Materi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;
import static com.android.volley.VolleyLog.v;

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
    ProgressDialog pd;
//    private ProgressBar pb;
//    ImageView myImage;
//    private static final int progress_bar_type=0;
//    private static String URL = "https://wirasetiawan29.files.wordpress.com/2016/01/tentang-material-design1.png";

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_materi,container,false);
        rvMateri = view.findViewById(R.id.rv_materi);
        rvMateri.setHasFixedSize(true);
//        myImage = view.findViewById(R.id.image_M);
//
//        FloatingActionButton fab = view.findViewById(R.id.btn_M);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(view,"Replace your own action", Snackbar.LENGTH_LONG).setAction("Action",null).show();
//            }
//        });
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
                                materi.setNameM(data.getString("namaM"));
                                materi.setDescM(data.getString("descM"));
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
