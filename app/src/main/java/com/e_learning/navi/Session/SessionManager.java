package com.e_learning.navi.Session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.e_learning.navi.HomeActivity;
import com.e_learning.navi.LoginActivity;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences preferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    public static final String PREF_NAME = "LOGIN";
    public static final String LOGIN = "IS_LOGIN";
    public static final String USERNAME = " USERNAME";
    public static final String AKSES = "AKSES";
    public static final String NIS = "NIS";
    public static final String NAMA = "NAMA";
    public static final String NAMA_M = "NAMA_M";
    public static final String FILE_M = "FILE_M";
    public static final String ID = "ID";

    public SessionManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void createSession(String username, String akses, String id, String nis, String nama) {
        editor.putBoolean(LOGIN, true);
        editor.putString(USERNAME, username);
        editor.putString(AKSES, akses);
        editor.putString(ID, id);
        editor.putString(NIS, nis);
        editor.putString(NAMA, nama);
        editor.apply();
    }

    public boolean isLogin() {
        return preferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){
        if (!this.isLogin()){
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((HomeActivity)context).finish();
        }
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USERNAME, preferences.getString(USERNAME,null));
        user.put(AKSES, preferences.getString(AKSES, null));
        user.put(ID, preferences.getString(ID, null));
        user.put(NIS, preferences.getString(NIS, null));
        user.put(NAMA, preferences.getString(NAMA, null));
        return user;
    }

    public void logout(){

        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((HomeActivity) context).finish();

    }

    public String getUSERNAME() {
        return preferences.getString(USERNAME,null);
    }

    public String getAKSES() {
        return preferences.getString(AKSES,null);
    }

    public String getID() {
        return preferences.getString(ID,null);
    }

    public String getNIS() {
        return preferences.getString(NIS,null);
    }

    public String getNAMA() {
        return preferences.getString(NAMA,null);
    }

//    public String getNamaM() {
//        return preferences.getString(NAMA_M,null);
//    }
//
//    public String getFileM() {
//        return preferences.getString(FILE_M,null);
//    }
}
