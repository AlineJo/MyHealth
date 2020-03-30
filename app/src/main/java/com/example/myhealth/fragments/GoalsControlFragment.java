package com.example.myhealth.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myhealth.R;
import com.example.myhealth.adapters.GoalsControlAdapter;
import com.example.myhealth.dialogs.AddGoalFragmentDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class GoalsControlFragment extends Fragment implements GoalsControlAdapter.GoalsControlInterface, AddGoalFragmentDialog.GoalsDialogInterface {


    private GoalsControlAdapter mAdapter;
    private Context mContext;
    private ArrayList<String> mItems;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_goals_control, container, false);

        mAdapter = new GoalsControlAdapter(mContext, this);
        mItems = new ArrayList<>();

        ListView listView = parentView.findViewById(R.id.list_view);
        FloatingActionButton fabAdd = parentView.findViewById(R.id.fab_add);
        Button btnSave = parentView.findViewById(R.id.btn_save);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAddDialog();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToSqlDatabase();

            }
        });

        listView.setAdapter(mAdapter);
        createDemoGoals();
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedGoal = (String) parent.getAdapter().getItem(position);
                Toast.makeText(mContext, clickedGoal, Toast.LENGTH_SHORT).show();

                displayEditDialog(position, clickedGoal);
            }
        });

        return parentView;
    }

    private void createDemoGoals() {


        mItems.add("تخفيف الوزن ٨ كيلو جرام");
        mItems.add("شرب ٨ اكواب ماء");
        mItems.add("الجري مسافة ٣ كم يوميا");
        mItems.add("النوم ٨ ساعات");

        mAdapter.update(mItems);

    }

    private void displayAddDialog() {
        AddGoalFragmentDialog dialog = AddGoalFragmentDialog.newInstance(false, "", -1);
        dialog.setGoalsListener(this);
        dialog.show(getFragmentManager(), AddGoalFragmentDialog.class.getSimpleName());


    }

    private void saveDataToSqlDatabase() {

        //all goals are stored in mItems arrayList you can use it to store the date to SQL DB

    }


    private void displayEditDialog(int index, String clickedGoal) {
        AddGoalFragmentDialog dialog = AddGoalFragmentDialog.newInstance(true, clickedGoal, index);
        dialog.setGoalsListener(this);
        dialog.show(getFragmentManager(), AddGoalFragmentDialog.class.getSimpleName());

    }


    @Override
    public void deleteItem(int position) {
        mItems.remove(position);
        mAdapter.update(mItems);
    }


    @Override
    public void addGoal(String goal) {
        mItems.add(0,goal);
        mAdapter.update(mItems);
    }

    @Override
    public void editGoal(int index, String goal) {
        mItems.set(index, goal);
        mAdapter.update(mItems);
    }
}
