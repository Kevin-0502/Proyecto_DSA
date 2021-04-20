package com.example.dentistapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class DisplayTipsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        ViewPager pager = findViewById(R.id.viewPagerTips);
        TabLayout tabLayout = findViewById(R.id.dot_indicator);
        pager.setAdapter(new ViewPagerAdapterTips(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));

        tabLayout.setupWithViewPager(pager);
    }

}