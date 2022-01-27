package com.naq.anhquan.app_market_kt.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naq.anhquan.app_market_kt.Food;
import com.naq.anhquan.app_market_kt.FoodAdapter;
import com.naq.anhquan.app_market_kt.MainActivity;
import com.naq.anhquan.app_market_kt.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private RecyclerView rcvFood;
    private Button btnFood, btnDrink;

    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_home, container, false);
        return mView;

        btnFood = mView.findViewById(R.id.btn_food);
        btnDrink = mView.findViewById(R.id.btn_drink);
        rcvFood = mView.findViewById(R.id.rcv_food);

        gridLayoutManager = new GridLayoutManager(this, 2);
        rcvFood.setLayoutManager(gridLayoutManager);

        FoodAdapter foodAdapter = new FoodAdapter(getListFood());
        rcvFood.setAdapter(foodAdapter);

        btnFood.setOnClickListener(this);
        btnDrink.setOnClickListener(this);
    }

    private List<Food> getListFood() {

        List<Food> foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));
        foodList.add(new Food(R.drawable.hambuger, "Hamburger", Food.TYPE_FOOD));

        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));
        foodList.add(new Food(R.drawable.coca2, "Coca", Food.TYPE_DRINK));

        return foodList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_food:
                scrollToItem(0);
                break;

            case R.id.btn_drink:
                scrollToItem(10);
                break;
        }
    }

    private void scrollToItem(int index) {

        if (gridLayoutManager == null) {
            return;
        }

        gridLayoutManager.scrollToPositionWithOffset(index, 0);
    }
}
