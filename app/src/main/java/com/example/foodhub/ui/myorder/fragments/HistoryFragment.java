package com.example.foodhub.ui.myorder.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.foodhub.databinding.FragmentFoodItemBinding;
import com.example.foodhub.databinding.FragmentHistoryBinding;
import com.example.foodhub.databinding.FragmentUpcomingBinding;
import com.example.foodhub.ui.search.adapter.FoodItemSearchAdapter;

public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentHistoryBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}

