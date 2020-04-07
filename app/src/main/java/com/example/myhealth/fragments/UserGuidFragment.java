package com.example.myhealth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myhealth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserGuidFragment extends Fragment {

    public UserGuidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_user_guid, container, false);

        TextView tv1 = parentView.findViewById(R.id.tv_1);
        TextView tv2 = parentView.findViewById(R.id.tv_2);
        TextView tv3 = parentView.findViewById(R.id.tv_3);
        TextView tv4 = parentView.findViewById(R.id.tv_4);
        TextView tv5 = parentView.findViewById(R.id.tv_5);
        TextView tv6 = parentView.findViewById(R.id.tv_6);
        TextView tv7 = parentView.findViewById(R.id.tv_7);
        TextView tv8 = parentView.findViewById(R.id.tv_8);
        TextView tv9 = parentView.findViewById(R.id.tv_9);
        TextView tv10 = parentView.findViewById(R.id.tv_10);

        tv1.setText("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        tv7.setText("");
        tv8.setText("");
        tv9.setText("");
        tv10.setText("");

        return parentView;
    }
}
