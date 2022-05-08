package com.example.foodhub.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.databinding.FragmentCartBinding;
import com.example.foodhub.databinding.FragmentHomeBinding;
import com.example.foodhub.ui.home.adapters.CartAdapter;

public class CartFragment extends Fragment {
    private FragmentCartBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentCartBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CartAdapter adapter =new CartAdapter();

        binding.cartRv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.cartRv.setNestedScrollingEnabled(false);
        binding.cartRv.setAdapter(adapter);
    }
}
