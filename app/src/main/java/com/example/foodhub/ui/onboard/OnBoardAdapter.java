package com.example.foodhub.ui.onboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;

public class OnBoardAdapter extends RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>{

    int [] onBoardItems ={R.drawable.onboard1,R.drawable.onboard2,R.drawable.onboard3};


    @NonNull
    @Override
    public OnBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.onboard_item,parent,false);
        return new OnBoardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardViewHolder holder, int position) {
    holder.onBoardImage.setImageResource(onBoardItems[position]);
    }

    @Override
    public int getItemCount() {
        return onBoardItems.length;
    }

    static class  OnBoardViewHolder extends RecyclerView.ViewHolder {

        ImageView onBoardImage;


        public OnBoardViewHolder(@NonNull View itemView) {
            super(itemView);
            onBoardImage=itemView.findViewById(R.id.onboard_image);
        }
    }
}
