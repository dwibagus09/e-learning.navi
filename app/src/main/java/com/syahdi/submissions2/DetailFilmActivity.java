package com.syahdi.submissions2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilmActivity extends AppCompatActivity {
    ImageView imgPhotoFilm;
    public TextView tvNameFilm,tvDescFilm,tvDateFilm,tvRateFilm,tvDirectorFilm;
    public static final String EXTRA_FILM = "extra_films";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        imgPhotoFilm = findViewById(R.id.img_detail_film);
        tvNameFilm = findViewById(R.id.detail_film_name);
        tvDescFilm = findViewById(R.id.detail_film_desc);

        Film films = getIntent().getParcelableExtra(EXTRA_FILM);
        int Pict = films.getPhotoFilm();
        imgPhotoFilm.setImageResource(Pict);
        String Title = films.getNameFilm();
        tvNameFilm.setText(Title);
        String Desc = films.getDescFilm();
        tvDescFilm.setText(Desc);
    }
}
