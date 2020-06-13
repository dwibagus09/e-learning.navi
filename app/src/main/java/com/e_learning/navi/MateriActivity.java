package com.e_learning.navi;

import android.app.DownloadManager;
import android.app.ProgressDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.arvita.crudvolley.R;
import com.e_learning.navi.Adapter.DataMateriAdapter;
import com.e_learning.navi.Model.ModelMateri;
import com.e_learning.navi.Model.ModelTugas;
import com.e_learning.navi.Session.SessionManager;
import com.e_learning.navi.Util.AppController;
import com.e_learning.navi.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MateriActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelMateri> mItems;
    Button btnInsert, btnDelete;
    ProgressDialog pd;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Halaman Materi");
        }
        mRecyclerview = findViewById(R.id.rv_materi);
        pd = new ProgressDialog(MateriActivity.this);
        mItems = new ArrayList<>();

        loadJson();

        mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new DataMateriAdapter(MateriActivity.this, mItems);
        mRecyclerview.setAdapter(mAdapter);

//        ModelMateri md = new ModelMateri();
//        SessionManager sessionManager = new SessionManager(getApplicationContext());
//        md.setNamaMateri(sessionManager.getNamaM());
//        md.setFileMateri(sessionManager.getFileM());
//        mItems.add(md);

    }


    private void loadJson() {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        username = sessionManager.getUSERNAME();
        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.GET, "http://192.168.43.60/E-Learning/Server_API/ApiMateri?username="+username, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley", "response : " + response.toString());
                            try {
                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject data = response.getJSONObject(i);
                                    ModelMateri md = new ModelMateri();
                                    md.setNamaMateri(data.getString("nama_materi"));
                                    md.setFileMateri(data.getString("file_materi"));
                                    mItems.add(md);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(MateriActivity.this,"error "+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(reqData);
    }
}

