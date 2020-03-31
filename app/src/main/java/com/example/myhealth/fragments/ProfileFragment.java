package com.example.myhealth.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myhealth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_profile, container, false);


        getUserDataDemo(parentView);


        return parentView;
    }

    private void getUserDataDemo(View parentView) {

        TextView tvUsername = parentView.findViewById(R.id.tv_username);
        TextView tvName = parentView.findViewById(R.id.tv_name);
        TextView tvAge = parentView.findViewById(R.id.tv_age);
        TextView tvGender = parentView.findViewById(R.id.tv_gender);

        TextView tvWeight = parentView.findViewById(R.id.tv_weight);
        TextView tvTall = parentView.findViewById(R.id.tv_tall);
        TextView tvHipWidth = parentView.findViewById(R.id.tv_hip_width);
        TextView HealthCenter = parentView.findViewById(R.id.tv_health_center);

        TextView tvResult = parentView.findViewById(R.id.tv_result);
        TextView tvBodyMass = parentView.findViewById(R.id.tv_mass);
        TextView tvCalories = parentView.findViewById(R.id.tv_calories);


        tvUsername.setText("zainab11");
        tvName.setText("زينب");
        tvAge.setText("25");
        tvGender.setText("انثى");
        tvWeight.setText("كم 56");
        tvTall.setText("154 سم");
        tvHipWidth.setText("25 سم");
        HealthCenter.setText("الحيل الجنوبية");
        tvResult.setText("منخفض");
        tvBodyMass.setText("23.6128");
        tvCalories.setText("1563.5");


    }
}
