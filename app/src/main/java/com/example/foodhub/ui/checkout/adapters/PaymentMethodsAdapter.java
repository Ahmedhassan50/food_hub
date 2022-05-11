package com.example.foodhub.ui.checkout.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodhub.R;


public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodsViewHolder> {

    private int[] paymentImages;

    public PaymentMethodsAdapter(int[] paymentImages) {
        this.paymentImages = paymentImages;
    }

    private int selectedPosition = 0;

    @NonNull
    @Override
    public PaymentMethodsAdapter.PaymentMethodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.payment_item, parent, false);
        return new PaymentMethodsAdapter.PaymentMethodsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodsAdapter.PaymentMethodsViewHolder holder, int position) {
        int image = paymentImages[position];

        holder.paymentImage.setImageResource(image);

        if (position == selectedPosition) {
            holder.itemView.setBackgroundResource(R.drawable.payment_selected_shpe);

        } else {
            holder.itemView.setBackgroundResource(R.drawable.payment_unselected_shape);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                selectedPosition = holder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return paymentImages.length;
    }

    static class PaymentMethodsViewHolder extends RecyclerView.ViewHolder {
        ImageView paymentImage;

        public PaymentMethodsViewHolder(@NonNull View itemView) {
            super(itemView);
            paymentImage = itemView.findViewById(R.id.payment_image);

        }
    }
}
