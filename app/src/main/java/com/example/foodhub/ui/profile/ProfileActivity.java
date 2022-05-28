package com.example.foodhub.ui.profile;


import android.os.Bundle;
import com.example.foodhub.BaseActivity;
import com.example.foodhub.databinding.ActivityProfileBinding;
import com.example.foodhub.shared.components.UserCredential;

public class ProfileActivity extends BaseActivity {
    private ActivityProfileBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();
        UserCredential userCredential = UserCredential.getInstance();


        binding.backBtn.setOnClickListener(v->{
            finish();
        });

        binding.profileName.setText(userCredential.getUserData().getName());
        binding.profileNameEd.setText(userCredential.getUserData().getName());
        binding.profileEmailEd.setText(userCredential.getUserData().getEmail());
        binding.profilePhoneEd.setText(userCredential.getUserData().getMobile());


    }

}