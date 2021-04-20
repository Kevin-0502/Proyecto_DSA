package com.example.dentistapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class ViewPagerAdapterTips extends FragmentPagerAdapter {

    public ViewPagerAdapterTips(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return (Fragment) new Tips1Fragment();
            case 1:
                return (Fragment) new Tips2Fragment();
            case 2:
                return (Fragment) new Tips3Fragment();
            case 3:
                return (Fragment) new Tips4Fragment();
            case 4:
                return (Fragment) new Tips5Fragment();
            case 5:
                return (Fragment) new Tips6Fragment();
            default:
                return (Fragment) new Tips2Fragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
