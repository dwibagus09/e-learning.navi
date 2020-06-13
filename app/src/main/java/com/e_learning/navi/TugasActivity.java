package com.e_learning.navi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.arvita.crudvolley.R;
import com.e_learning.navi.Adapter.DataMateriAdapter;
import com.e_learning.navi.Adapter.DataTugasAdapter;
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

public class TugasActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    List<ModelTugas> mItems;
    ProgressDialog pd;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Halaman Tugas");
        }
        mRecyclerview = findViewById(R.id.rv_tugas);
        pd = new ProgressDialog(TugasActivity.this);
        mItems = new ArrayList<>();

        loadJson();

        mRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new DataTugasAdapter(TugasActivity.this, mItems);
        mRecyclerview.setAdapter(mAdapter);


    }


    private void loadJson() {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        username = sessionManager.getUSERNAME();
        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.GET, "http://192.168.43.60/E-Learning/Server_API/ApiTugas?username="+username, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley", "response : " + response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelTugas md = new ModelTugas();
                                md.setKdTugas(data.getString("kd_tugas"));
                                md.setDeskripsi(data.getString("deskripsi"));
                                md.setStart(data.getString("waktu_mulai"));
                                md.setEnd(data.getString("waktu_selesai"));
                                mItems.add(md);
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
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(reqData);
    }

}
