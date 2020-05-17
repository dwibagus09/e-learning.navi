package com.elearning.e_learningprojext;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.elearning.e_learningprojext.materi.MateriFragment;
import com.elearning.e_learningprojext.tugas.TugasFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private final Context konteks;

    public SectionPagerAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        konteks = context;
    }

    @StringRes
    private final int TAB_TITLES[] = new int[]{
            R.string.name_tugas,
            R.string.name_materi
    };

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new TugasFragment();
                break;
            case 1:
                fragment = new MateriFragment();
                break;
        }
        return fragment;
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){
        return konteks.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
