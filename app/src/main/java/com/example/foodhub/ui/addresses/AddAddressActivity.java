package com.example.foodhub.ui.addresses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityAddAddressBinding;
import com.example.foodhub.databinding.ActivityAddressesBinding;

public class AddAddressActivity extends AppCompatActivity {
    private ActivityAddAddressBinding binding;

    private String [] states={"Egypt","America","China"};
    private String [] cities={"Cairo","Giza","Benha"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> adapterStates =
                new ArrayAdapter<>(this, R.layout.dropdown_item, states);
        ArrayAdapter<String> adapterCities =
                new ArrayAdapter<>(this, R.layout.dropdown_item, cities);


        binding.selectStateDropdown.setAdapter(adapterStates);
        binding.selectCityDropdown.setAdapter(adapterCities);


        binding.backBtn.setOnClickListener(v->{
            finish();
        });

        binding.addAddressBtn.setOnClickListener(v->{

        });


    }
}