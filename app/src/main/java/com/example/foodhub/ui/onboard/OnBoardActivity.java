package com.example.foodhub.ui.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.foodhub.BaseActivity;
import com.example.foodhub.R;
import com.example.foodhub.databinding.ActivityOnBoardBinding;
import com.example.foodhub.ui.welcome.WelcomeActivity;

public class OnBoardActivity extends BaseActivity {

    private ActivityOnBoardBinding binding;

    private String[] onBardTitles = {"Browse your menu and order directly",
            "Even to space with us! Together", "Pickup delivery at your door"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        OnBoardAdapter adapter = new OnBoardAdapter();
        binding.onboardSlider.setAdapter(adapter);
        binding.dotsIndicator.setViewPager2(binding.onboardSlider);

        binding.onboardSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.onboardTitleTv.setText(onBardTitles[position]);
            }

        });

        binding.onboardBtn.setOnClickListener(v -> {
            int currentItem = binding.onboardSlider.getCurrentItem();
            if (currentItem + 1 < adapter.getItemCount()) {
                binding.onboardSlider.setCurrentItem(currentItem + 1);
            } else {
                goTo(WelcomeActivity.class);
            }
        });


    }


}