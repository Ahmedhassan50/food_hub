package com.example.foodhub.ui.home.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.model.HomeModel;
import com.example.foodhub.data.model.Restaurant;
import com.example.foodhub.data.remote.RetrofitModule;
import com.example.foodhub.databinding.FragmentMapBinding;
import com.example.foodhub.ui.home.HomeViewModel;
import com.example.foodhub.ui.restaurantdetails.RestaurantDetailsActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private FragmentMapBinding binding;
    GoogleMap googleMap;
    private HomeViewModel homeViewModel;

    private List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater);
        SupportMapFragment map = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(this);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        );
        getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(getActivity()).get(HomeViewModel.class);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LatLng latLng = new LatLng(29.9853751, 31.2356337);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));

        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ImageView markerImage = (ImageView) inflater.inflate(R.layout.map_marker, null);


        homeViewModel.getHomeData();
        homeViewModel.homeData.observe(getActivity(), new Observer<HomeModel>() {
            @Override
            public void onChanged(HomeModel homeModel) {
                restaurantList = homeModel.getRestaurants();
                if (!restaurantList.isEmpty()) {

                    for (Restaurant restaurant : restaurantList) {

                        Picasso.get().load(RetrofitModule.BASE_URL + restaurant.getImage()).resize(100, 100)
                                .into(markerImage, new Callback() {
                                    @Override
                                    public void onSuccess() {
                                        googleMap.addMarker(new MarkerOptions().
                                                position(new LatLng(Double.parseDouble(restaurant.getLatitude()), Double.parseDouble(restaurant.getLongitude()))).
                                                icon(BitmapDescriptorFactory.fromBitmap(createBitmapFromLayout(markerImage)))

                                        ).setTag(restaurant.getId());
                                    }

                                    @Override
                                    public void onError(Exception e) {

                                    }
                                });

                    }

                }
            }
        });

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Restaurant selectedRestaurant = new Restaurant();
                for (Restaurant restaurant : restaurantList) {
                    if (marker.getTag().toString().equals(restaurant.getId())) {
                        selectedRestaurant = restaurant;
                        break;
                    }
                }
                Glide.with(binding.restaurantImage.getRootView()).load(RetrofitModule.BASE_URL + selectedRestaurant.getImage()).into(binding.restaurantImage);
                binding.restaurantName.setText(selectedRestaurant.getName());
                binding.restaurantAddress.setText(selectedRestaurant.getAddress());
                binding.restaurantDelivery.setText(selectedRestaurant.getDelivery());
                binding.restaurantDeliveryTime.setText(selectedRestaurant.getDeliveryTime());
                binding.restaurantRate.setText(selectedRestaurant.getRate() + "");
                binding.restaurantRateNumber.setText("(" + selectedRestaurant.getRateNumber() + "+" + ")");
                Restaurant finalSelectedRestaurant = selectedRestaurant;
                binding.restaurantDetailsBtn.setOnClickListener(v -> {
                    Intent i = new Intent(getContext(), RestaurantDetailsActivity.class);
                    i.putExtra("restaurant_id", finalSelectedRestaurant.getId());
                    getContext().startActivity(i);
                });

                binding.restaurantCard.setVisibility(View.VISIBLE);
                return false;
            }
        });


        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                if (binding.restaurantCard.getVisibility() == View.VISIBLE) {
                    binding.restaurantCard.setVisibility(View.GONE);
                }
            }
        });
    }

    private Bitmap createBitmapFromLayout(View tv) {
        int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        tv.measure(spec, spec);
//        Log.e("spec", tv.getMeasuredWidth() + "");
        tv.layout(0, 0, tv.getMeasuredWidth(), tv.getMeasuredHeight());

        Bitmap b = Bitmap.createBitmap(tv.getMeasuredWidth(), tv.getMeasuredWidth(),
                Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        tv.draw(c);
        return b;
    }


}
