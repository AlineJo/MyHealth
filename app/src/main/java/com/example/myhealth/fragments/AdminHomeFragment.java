package com.example.myhealth.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myhealth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminHomeFragment extends Fragment {

    public AdminHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_admin_home, container, false);

        ImageButton ibGoals = parentView.findViewById(R.id.ib_goals);
        TextView tvGoals = parentView.findViewById(R.id.tv_goals);

        ImageButton ibUsersList = parentView.findViewById(R.id.ib_users);
        TextView tvUsersList = parentView.findViewById(R.id.tv_users);


        return parentView;
    }
}
