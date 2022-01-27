package com.naq.anhquan.app_market_kt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.foodViewHolder> {

    private List<Food> mListFood;

    public FoodAdapter(List<Food> mListFood) {
        this.mListFood = mListFood;
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new foodViewHolder(view);
    }

    //set data into item
    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position) {

        Food food = mListFood.get(position);

        if (food == null) {
            return;
        }

        holder.imgFood.setImageResource(food.getImage());
        holder.tvNameFood.setText(food.getName());
    }

    @Override
    public int getItemCount() {

        if (mListFood != null) {
            return mListFood.size();
        }

        return 0;
    }

    public class foodViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFood;
        private TextView tvNameFood;

        public foodViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFood = itemView.findViewById(R.id.img_hamburger);
            tvNameFood = itemView.findViewById(R.id.tv_hamburger);
        }
    }
}
