package com.example.foodhub.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;

import com.example.foodhub.databinding.FragmentCartBinding;
import com.example.foodhub.databinding.FragmentHomeBinding;

public class CartFragment extends Fragment {
    private FragmentCartBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentCartBinding.inflate(inflater);
        return binding.getRoot();
    }
}
