package com.syahdi.submissions2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailTvShowsActivity extends AppCompatActivity {
    ImageView imgPhotoTV;
    public TextView tvNameTV,tvDescTV,tvDateTV,tvRate,tvDirectorTV;
    public static final String EXTRA_TV = "extra_tvs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_shows);
        imgPhotoTV = findViewById(R.id.img_detail_tv);
        tvNameTV = findViewById(R.id.detail_tv_name);
        tvDescTV = findViewById(R.id.detail_tv_desc);

        TvShows tvShows = getIntent().getParcelableExtra(EXTRA_TV);
        int Pict = tvShows.getPhotoTV();
        imgPhotoTV.setImageResource(Pict);
        String Title = tvShows.getNameTV();
        tvNameTV.setText(Title);
        String Desc = tvShows.getDescTV();
        tvDescTV.setText(Desc);
    }
}
