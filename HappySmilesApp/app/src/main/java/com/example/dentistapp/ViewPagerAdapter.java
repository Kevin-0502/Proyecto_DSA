package com.example.dentistapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return (Fragment) new Service1Fragment();
            case 1:  return (Fragment) new Service2Fragment();
            case 2:  return (Fragment) new Service3Fragment();
            case 3:  return (Fragment) new Service4Fragment();
            case 4:  return (Fragment) new Service5Fragment();
            case 5:  return (Fragment) new Service6Fragment();
            case 6:  return (Fragment) new Service7Fragment();
            case 7:  return (Fragment) new Service8Fragment();
            case 8:  return (Fragment) new Service9Fragment();
            default: return (Fragment) new Service1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 9;
    }
}
