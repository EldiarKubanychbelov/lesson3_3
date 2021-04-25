package com.example.lesson3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return BottomFragment.newInstance("Value 1","Value 2");
            case 1:
                return ProfileFragment.newInstance("Value 1","Value 2");
            case 2:
                return HomeFragment.newInstance("Value 1","Value 2");
            default:
                return BottomFragment.newInstance("Value 1","Value 2");

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
