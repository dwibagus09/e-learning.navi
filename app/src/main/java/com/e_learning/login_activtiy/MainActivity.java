package com.e_learning.login_activtiy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().setElevation(0);
    }
    public void setupViewPager(ViewPager viewPager){
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(new TugasFragment(), "TUGAS");
        sectionPagerAdapter.addFragment(new MateriFragment(), "MATERI!");

        viewPager.setAdapter(sectionPagerAdapter);
    }
    static class SectionPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentlist = new ArrayList<>();
        private final List<String> stringTitleList = new ArrayList<>();

        public SectionPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return fragmentlist.size();
        }
        public void addFragment(Fragment fragment, String title){
            fragmentlist.add(fragment);
            stringTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return stringTitleList.get(position);
        }
    }
}
