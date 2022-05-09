package com.example.foodhub.ui.search.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class TapAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public TapAdapter( FragmentManager fragmentManager,  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }



    @Override
    public int getItemCount() {
        return fragments.size();
    }


    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }
}
