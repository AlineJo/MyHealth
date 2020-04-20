package com.example.myhealth.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.adapters.FoodGroupAdapter;
import com.example.myhealth.interfaces.MediatorInterface;
import com.example.myhealth.model.FoodGroup;
import com.example.myhealth.model.FoodSubGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodGroupFragment extends Fragment {

    private FoodGroupAdapter mAdapter;
    private Context mContext;
    private ArrayList<FoodGroup> mItems;
    private MediatorInterface mMediatorCallback;

    public FoodGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
        mMediatorCallback = (MediatorInterface) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_food_group, container, false);

        RecyclerView recyclerView = parentView.findViewById(R.id.recycler_view);
        mAdapter = new FoodGroupAdapter();
        setupRecyclerView(recyclerView);
        mItems = new ArrayList<>();
        CreateDemoFoodGroups();


        return parentView;
    }

    private void CreateDemoFoodGroups() {

        FoodGroup foodGroup;

        foodGroup = new FoodGroup();
        foodGroup.setTitle("مجموعة الحليب");
        foodGroup.setImage(R.drawable.milkg);
        foodGroup.setCardColor("#369BF0");
        addMilkSubGroup(foodGroup);// creating foodSubGroup for Milk
        mItems.add(foodGroup);


        foodGroup = new FoodGroup();
        foodGroup.setTitle("مجموعة الخضروات");
        foodGroup.setImage(R.drawable.vv);
        foodGroup.setCardColor("#4CAF50");
        addVegSubGroup(foodGroup);// Creating foodSub group for veg
        mItems.add(foodGroup);

        foodGroup = new FoodGroup();
        foodGroup.setTitle("مجموعة الفواكه");
        foodGroup.setImage(R.drawable.fruit);
        foodGroup.setCardColor("#FF0000");
        addMilkSubGroup(foodGroup);// creating foodSubGroup for Milk
        mItems.add(foodGroup);


        foodGroup = new FoodGroup();
        foodGroup.setTitle("مجموعة النشويات");
        foodGroup.setImage(R.drawable.ccarb);
        foodGroup.setCardColor("#B9A465");
        addMilkSubGroup(foodGroup);// creating foodSubGroup for Milk
        mItems.add(foodGroup);


        foodGroup = new FoodGroup();
        foodGroup.setTitle("مجموعة البروتين");
        foodGroup.setImage(R.drawable.protin);
        foodGroup.setCardColor("#F3C749");
        addMilkSubGroup(foodGroup);// creating foodSubGroup for Milk
        mItems.add(foodGroup);


        foodGroup = new FoodGroup();
        foodGroup.setTitle("مجموعة الدهون");
        foodGroup.setImage(R.drawable.fats);
        foodGroup.setCardColor("#4BE0E7");
        addMilkSubGroup(foodGroup);// creating foodSubGroup for Milk
        mItems.add(foodGroup);




        mAdapter.update(mItems);

    }

    private void addVegSubGroup(FoodGroup foodGroup) {
        ArrayList<FoodSubGroup> subGroupsArrayList;
        FoodSubGroup subGroup;
        //adding sub group details
        subGroupsArrayList = new ArrayList<>();

        subGroup = new FoodSubGroup();
        subGroup.setTitle("Potato");
        subGroup.setCalories(200);
        subGroup.setImage(R.drawable.pro);
        subGroup.setQuantity("1 Cup");
        subGroup.setSubTitle("");
        subGroup.setCardColor("#4CAF50");
        subGroup.setSelected(false);
        subGroupsArrayList.add(subGroup);

        subGroup = new FoodSubGroup();
        subGroup.setTitle("Egg");
        subGroup.setCardColor("#4CAF50");
        subGroup.setCalories(150);
        subGroup.setImage(R.drawable.pro);
        subGroup.setQuantity("2 peace");
        subGroup.setSubTitle("");
        subGroup.setSelected(false);
        subGroupsArrayList.add(subGroup);

        foodGroup.setFoodSubGroups(subGroupsArrayList);
    }

    private void addMilkSubGroup(FoodGroup foodGroup) {
        ArrayList<FoodSubGroup> subGroupsArrayList;
        FoodSubGroup subGroup;
        //adding sub group details
        subGroupsArrayList = new ArrayList<>();

        subGroup = new FoodSubGroup();
        subGroup.setTitle("Camel Milk");
        subGroup.setCalories(200);
        subGroup.setImage(R.drawable.pro);
        subGroup.setQuantity("1 Cup");
        subGroup.setSubTitle("");
        subGroup.setCardColor("#FF0000");
        subGroup.setSelected(false);
        subGroupsArrayList.add(subGroup);

        subGroup = new FoodSubGroup();
        subGroup.setTitle("Cow Milk");
        subGroup.setCalories(100);
        subGroup.setImage(R.drawable.pro);
        subGroup.setQuantity("1.5 Cup");
        subGroup.setCardColor("#FF0000");
        subGroup.setSubTitle("");
        subGroup.setSelected(false);
        subGroupsArrayList.add(subGroup);

        foodGroup.setFoodSubGroups(subGroupsArrayList);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setupFoodAdapterListener(new FoodGroupAdapter.FoodAdapterListener() {
            @Override
            public void onClick(FoodGroup foodGroup) {
                FoodSubGroupFragment fragment = new FoodSubGroupFragment();
                fragment.setFoodSubGroup(foodGroup.getFoodSubGroups(), foodGroup.getTitle());
                mMediatorCallback.changeFragmentTo(fragment, FoodSubGroupFragment.class.getSimpleName());
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

}
