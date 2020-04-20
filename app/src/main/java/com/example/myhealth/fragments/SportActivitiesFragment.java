package com.example.myhealth.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myhealth.R;
import com.example.myhealth.adapters.SportItemsAdapter;
import com.example.myhealth.model.SportActivityItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportActivitiesFragment extends Fragment {


    SportItemsAdapter mAdapter;
    private Context mContext;

    public SportActivitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_sport_activities, container, false);
        ListView listView = parentView.findViewById(R.id.list_view);
        mAdapter = new SportItemsAdapter(mContext);
        listView.setAdapter(mAdapter);


        //TODO : inorder to display list of Sport Activities Items call mAdapter.update();
        // TODO : mAdapter.update() needs ArrayList of SportActivityItem =>  ArrayList<SportActivityItem>

        //this is just a demo data!
        displayDemoData();

        return parentView;
    }

    private void displayDemoData() {
        ArrayList<SportActivityItem> items = new ArrayList<>();

        items.add(new SportActivityItem("أنشطة رياضية منزلية", "أنشطة رياضية تستطيع ممارستها في المنزل", R.drawable.hhh));//currently no img so we pass R.drawable.ic_launcher_foreground
        items.add(new SportActivityItem("أنشطة رياضية في العمل", "أنشطة رياضية تستطيع ممارستها في جهة العمل", R.drawable.of));//currently no img so we pass R.drawable.ic_launcher_foreground
        items.add(new SportActivityItem("أنشطة رياضية في النادي الرياضي", "أنشطة رياضية تستطيع ممارستها النادي الرياضي", R.drawable.gym));//currently no img so we pass R.drawable.ic_launcher_foreground

        mAdapter.update(items);

    }

}
