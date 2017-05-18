package com.example.leshka.schedule_2.Adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.leshka.schedule_2.fragment.AbstractTabFragment;
import com.example.leshka.schedule_2.fragment.Half;
import com.example.leshka.schedule_2.fragment.Today;
import com.example.leshka.schedule_2.fragment.Tomorrow;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map <Integer, AbstractTabFragment> tabs;
    private Context contex;

    public TabsFragmentAdapter(Context contex, FragmentManager fm) {
        super(fm);
        this.contex = contex;
        initTabMap(contex);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabMap(Context contex) {
        tabs = new HashMap<>();
        tabs.put(0, Half.getInstance(contex));
        tabs.put(1, Today.getInstance(contex));
        tabs.put(2, Tomorrow.getInstance(contex));
    }
}
