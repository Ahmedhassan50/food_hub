package com.example.foodhub.ui.myorder.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.databinding.FragmentUpcomingBinding;
import com.example.foodhub.ui.myorder.adapters.HistoryAdapter;
import com.example.foodhub.ui.myorder.adapters.UpComingAdapter;

public class UpComingFragment extends Fragment {
    private FragmentUpcomingBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentUpcomingBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UpComingAdapter adapter =new UpComingAdapter();

        binding.upcomingOrdersRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.upcomingOrdersRv.setAdapter(adapter);

    }
}
