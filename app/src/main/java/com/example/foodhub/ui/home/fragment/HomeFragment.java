package com.example.foodhub.ui.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodhub.R;
import com.example.foodhub.data.model.Category;
import com.example.foodhub.data.model.HomeModel;
import com.example.foodhub.data.model.Meal;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.databinding.FragmentHomeBinding;
import com.example.foodhub.ui.home.HomeActivity;
import com.example.foodhub.ui.home.HomeViewModel;
import com.example.foodhub.ui.home.adapters.CategoryAdapter;
import com.example.foodhub.ui.home.adapters.MealAdapter;
import com.example.foodhub.ui.home.adapters.RestaurantAdapter;
import com.example.foodhub.ui.mealdetails.MealDetailsActivity;
import com.example.foodhub.ui.search.SearchActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    private HomeViewModel homeViewModel;
    private CategoryAdapter categoryAdapter;
     private MealAdapter mealAdapter;
   private RestaurantAdapter restaurantAdapter;





    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding =FragmentHomeBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        homeViewModel =new ViewModelProvider(getActivity()).get(HomeViewModel.class);
        categoryAdapter = new CategoryAdapter();
        mealAdapter =new MealAdapter();
        restaurantAdapter =new RestaurantAdapter();


        binding.drawerIcon.setOnClickListener(v->{
            HomeActivity.drawer.openMenu();
        });

        homeViewModel.getHomeData();



        homeViewModel.homeData.observe(getActivity(), new Observer<HomeModel>() {
            @Override
            public void onChanged(HomeModel homeModel) {
               if(homeModel.getRestaurants()!=null ){
                   restaurantAdapter.setData(homeModel.getRestaurants());
               }
                if(homeModel.getCategories()!=null ){
                    categoryAdapter.setData(homeModel.getCategories());
                }
                if (homeModel.getMeals()!=null){
                    mealAdapter.setData(homeModel.getMeals());
                }


            }
        });





        ArrayList<Category> categories =new ArrayList<>();
        /*categories.add(new Category(R.drawable.burger_image,"Burger"));
        categories.add(new Category(R.drawable.burger_image,"Donat"));
        categories.add(new Category(R.drawable.burger_image,"Pizza"));
        categories.add(new Category(R.drawable.burger_image,"Mexican"));
        categories.add(new Category(R.drawable.burger_image,"Asian"));*/

       /* ArrayList<Restaurant> restaurants =new ArrayList<>();
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.5,25,"McDonald’s",
                "free delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.7,99,"Starbuck",
                "$2 delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.5,25,"McDonald’s",
                "free delivery","10-15 mins"));
        restaurants.add(new Restaurant(R.drawable.restaurant_image,4.7,99,"Starbuck",
                "$2 delivery","10-15 mins"));*/

        ArrayList<Meal> meals =new ArrayList<>();
      /*  meals.add(new Meal(R.drawable.nuduls,4.5,5.50,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,8.25,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,5.50,25,"Salmon Salad"
                ,"Baked salmon fish"));
        meals.add(new Meal(R.drawable.nuduls,4.5,8.25,25,"Salmon Salad"
                ,"Baked salmon fish"));*/







        binding.categoryRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.categoryRv.setAdapter(categoryAdapter);

        binding.restaurantRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.restaurantRv.setAdapter(restaurantAdapter);

        binding.mealsRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.mealsRv.setAdapter(mealAdapter);


        binding.searchLayout.setOnClickListener(v->{
            Intent i =new Intent(getContext(), SearchActivity.class);
           getContext().startActivity(i);
        });



    }
}
