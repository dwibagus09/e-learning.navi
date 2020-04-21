package com.elearning.navi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainSiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_siswa);
        ViewPager viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().setElevation(0);
    }

    public void setupViewPager(ViewPager viewPager){
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),2);
        sectionPagerAdapter.addFragment(new MateriFragment(),  "Materi Siswa !");
        sectionPagerAdapter.addFragment(new TugasFragment(), "Tugas Siswa !");

        viewPager.setAdapter(sectionPagerAdapter);
    }

    static class SectionPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> fragmentslist = new ArrayList<>();
        private final List<String> stringJudul = new ArrayList<>();

        public SectionPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentslist.get(position);
        }

        @Override
        public int getCount() {
            return fragmentslist.size();
        }
        public void addFragment(Fragment fragment, String judul){
            fragmentslist.add(fragment);
            stringJudul.add(judul);
        }
        @Override
        public CharSequence getPageTitle(int Position){
            return stringJudul.get(Position);
        }
    }
}
