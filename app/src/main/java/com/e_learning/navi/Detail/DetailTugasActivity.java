package com.e_learning.navi.Detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arvita.crudvolley.R;
import com.e_learning.navi.Model.ModelTugas;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class DetailTugasActivity extends AppCompatActivity{
    public TextView tvKdTugas,tvDesc,tvStart,tvEnd;
    public static final String EXTRA_TUGAS = "extra_tugas";
    public Button btnSelect,btnUpload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Deskripsi tugas");
        }
        tvKdTugas = findViewById(R.id.tv_kd_tugas);
        tvDesc = findViewById(R.id.tv_desc);
        tvStart = findViewById(R.id.tv_start);
        tvEnd = findViewById(R.id.tv_end);

        btnSelect = findViewById(R.id.btn_select);
        btnUpload = findViewById(R.id.btn_upload);
//========================================================================================================
        ModelTugas modelTugas = getIntent().getParcelableExtra(EXTRA_TUGAS);

        String kd_tugas = modelTugas.getKdTugas();
        tvKdTugas.setText(kd_tugas);

        String desc = modelTugas.getDeskripsi();
        tvDesc.setText(desc);

        String start = modelTugas.getStart();
        tvStart.setText(start);

        String end = modelTugas.getEnd();
        tvEnd.setText(end);
    }
}
