package com.e_learning.navi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arvita.crudvolley.R;
import com.e_learning.navi.Session.SessionManager;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity{
    private static final String TAG = HomeActivity.class.getSimpleName();
    GridLayout mainGrid;
    SessionManager sessionManager;
    String getId;
    private Button btn_logout;
    private TextView username,akses,nama,nis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mainGrid =  findViewById(R.id.mainGrid);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

//        username = findViewById(R.id.username);
//        akses = findViewById(R.id.akses);
        nama = findViewById(R.id.nama);
        nis = findViewById(R.id.nis);

        HashMap<String,String> user = sessionManager.getUserDetail();
//        getId = user.get(SessionManager.ID);
//        String mUsername = user.get(sessionManager.USERNAME);
//        String mAkses = user.get(sessionManager.AKSES);
        String mNama = user.get(sessionManager.NAMA);
        String mNis = user.get(sessionManager.NIS);

//        username.setText(mUsername);
//        akses.setText(mAkses);
        nama.setText(mNama);
        nis.setText(mNis);
        btn_logout = findViewById(R.id.btn_logout);



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }
    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(HomeActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(HomeActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0){
                        Intent intentM = new Intent(HomeActivity.this,ProfileActivity.class);
                        startActivity(intentM);
                    }
                    else if(finalI == 1){
                        Intent intentT = new Intent(HomeActivity.this,MateriActivity.class);
                        startActivity(intentT);
                    }
                    else if(finalI == 2){
                        Intent intentU = new Intent(HomeActivity.this,TugasActivity.class);
                        startActivity(intentU);
                    }
                    else {
                        Toast.makeText(HomeActivity.this,"Menu an Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
