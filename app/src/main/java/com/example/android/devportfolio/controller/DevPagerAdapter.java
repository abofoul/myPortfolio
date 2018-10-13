package com.example.android.devportfolio.controller;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.devportfolio.views.AboutFragment;
import com.example.android.devportfolio.views.ContactFragment;
import com.example.android.devportfolio.views.SkillsFragment;
import com.example.android.devportfolio.views.WorkFragment;

public class DevPagerAdapter extends FragmentPagerAdapter {

    public DevPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new AboutFragment();
            case 1:
                return new WorkFragment();
            case 2:
                return new SkillsFragment();
            case 3:
                return new ContactFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "About";
            case 1:return "Work";
            case 2:return "Skills";
            case 3:return "Contact me ";
        }
        return null;
    }
}
