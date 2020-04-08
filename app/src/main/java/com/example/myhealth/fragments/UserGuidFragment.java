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
import com.example.myhealth.adapters.UserGuidAdapter;
import com.example.myhealth.model.UserGuid;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserGuidFragment extends Fragment {

    private Context mContext;

    public UserGuidFragment() {
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
        View parentView = inflater.inflate(R.layout.fragment_user_guid, container, false);

        ListView listView = parentView.findViewById(R.id.list_view);
        ArrayList<UserGuid> userGuidArrayList = new ArrayList<>();
        createDemoSteps(userGuidArrayList);

        UserGuidAdapter adapter = new UserGuidAdapter(mContext, userGuidArrayList);

        listView.setAdapter(adapter);


        return parentView;
    }

    private void createDemoSteps(ArrayList<UserGuid> userGuidArrayList) {

        UserGuid userGuid;

        //step 1
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorBlack);
        userGuid.setCloudShape(R.drawable.ic_cloud_1);
        userGuidArrayList.add(userGuid);

        //step 2
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorBlack);
        userGuid.setCloudShape(R.drawable.ic_cloud_2);
        userGuidArrayList.add(userGuid);

        //step 3
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorBlack);
        userGuid.setCloudShape(R.drawable.ic_cloud_3);

        userGuidArrayList.add(userGuid); //step 4
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorBlack);
        userGuid.setCloudShape(R.drawable.ic_cloud_3);
        userGuidArrayList.add(userGuid);

        //step 5
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorGreen);
        userGuid.setCloudShape(R.drawable.ic_cloud_4);
        userGuidArrayList.add(userGuid);

        //step 6
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorGreen);
        userGuid.setCloudShape(R.drawable.ic_cloud_4);
        userGuidArrayList.add(userGuid);

        //step 7
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorGreen);
        userGuid.setCloudShape(R.drawable.ic_cloud_4);
        userGuidArrayList.add(userGuid);

        //step 8
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorGreen);
        userGuid.setCloudShape(R.drawable.ic_cloud_4);
        userGuidArrayList.add(userGuid);

        //step 9
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorGreen);
        userGuid.setCloudShape(R.drawable.ic_cloud_4);
        userGuidArrayList.add(userGuid);

        //step 10
        userGuid = new UserGuid();
        userGuid.setTitle("ممتنين لك ، لانضمامك معنا من اجل صحة مثالية!");
        userGuid.setTextColor(R.color.colorGreen);
        userGuid.setCloudShape(R.drawable.ic_cloud_4);
        userGuidArrayList.add(userGuid);

    }
}
