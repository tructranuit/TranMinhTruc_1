package com.example.tmt.tranminhtruc.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tmt.tranminhtruc.adapters.ViewPagerAdapter;
import com.example.tmt.tranminhtruc.fragments.EducationFragment;
import com.example.tmt.tranminhtruc.fragments.InterestsFragment;
import com.example.tmt.tranminhtruc.fragments.PersonalInformationFragment;
import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.fragments.QuestionFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PersonalInformationFragment(), "Thông tin cá nhân");
        adapter.addFragment(new EducationFragment(), "Học tập");
        adapter.addFragment(new InterestsFragment(), "Sở thích");
        adapter.addFragment(new QuestionFragment(), "Câu hỏi");
        viewPager.setAdapter(adapter);
    }
}
