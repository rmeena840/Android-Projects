package com.example.ravindra.scrollable_tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ravindra on 2/25/2018.
 */

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentA();
        } else if (position == 1) {
            fragment = new FragmentB();
        } else if (position == 2) {
            fragment = new FragmentC();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
