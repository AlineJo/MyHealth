package com.example.myhealth.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myhealth.R;
import com.example.myhealth.adapters.UsersSearchAdapter;
import com.example.myhealth.model.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminSearchFragment extends Fragment {

    private Context mContext;
    private UsersSearchAdapter mAdapter;
    ArrayList<User> mItems;

    public AdminSearchFragment() {
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
        View parentView = inflater.inflate(R.layout.fragment_admin_search, container, false);
        mItems = new ArrayList<>();

        EditText etSearch = parentView.findViewById(R.id.et_search);

        ListView listView = parentView.findViewById(R.id.lv_search);

        mAdapter = new UsersSearchAdapter(mContext);
        listView.setAdapter(mAdapter);

        createDemoUser();//this function Will Create demo Users.

        //track text change on etSearch
        etSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                if (s != null) {
                    search(s.toString());
                } else {
                    mAdapter.update(mItems);
                }

            }
        });

        return parentView;
    }

    private void search(String key) {
        ArrayList<User> temp = new ArrayList<>();
        for (User u : mItems) {
            if (u.getName().toLowerCase().contains(key.toLowerCase())) {
                temp.add(u);
            }
        }

        mAdapter.update(temp);
    }

    private void createDemoUser() {


        mItems.add(new User(0, "Ahmed"));
        mItems.add(new User(1, "Yousuf"));
        mItems.add(new User(2, "Saud"));
        mItems.add(new User(3, "Ali"));
        mItems.add(new User(4, "Azza"));
        mItems.add(new User(5, "Said"));

        mAdapter.update(mItems);

    }
}
