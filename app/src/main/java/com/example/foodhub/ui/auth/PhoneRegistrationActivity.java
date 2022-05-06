package com.example.foodhub.ui.auth;



import android.annotation.SuppressLint;
import android.os.Bundle;
import com.example.foodhub.BaseActivity;
import com.example.foodhub.databinding.ActivityPhoneRegistrationBinding;
import com.example.foodhub.ui.home.HomeActivity;
import com.hbb20.CountryCodePicker;

public class PhoneRegistrationActivity extends BaseActivity {

    private ActivityPhoneRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();

//        binding.countryPicker.registerCarrierNumberEditText(binding.phoneEditText);

        binding.countryPicker.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCountrySelected() {

                binding.phoneEditText.setText("("+binding.countryPicker.getSelectedCountryCode()+")");
            }
        });

        binding.phoneSendBackBtn.setOnClickListener(v->{
            finish();
        });

        binding.sendPhoneNumber.setOnClickListener(v->{
            goTo(HomeActivity.class);
        });
    }
}