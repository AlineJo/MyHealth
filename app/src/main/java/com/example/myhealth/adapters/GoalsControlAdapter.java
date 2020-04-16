package com.example.myhealth.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.myhealth.R;
import com.example.myhealth.fragments.GoalsControlFragment;

import java.util.ArrayList;

public class GoalsControlAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mItems;

    private GoalsControlInterface mListener;

    public GoalsControlAdapter(Context context, GoalsControlFragment fragment) {
        mContext = context;
        mItems = new ArrayList<>();

        mListener = (GoalsControlInterface) fragment;
    }



    public void update(ArrayList<String> items) {
        mItems = items;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_goals_control, parent, false);

        }

        TextView tvTitle = convertView.findViewById(R.id.tv_titles);
        ImageButton ibDelete = convertView.findViewById(R.id.ib_delete);

        tvTitle.setText(mItems.get(position));

        ibDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAlertDialog(mItems.get(position),position);
            }
        });


        return convertView;
    }

    private void displayAlertDialog(String title, final int position) {


        AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
        builder1.setMessage("هل تود حذف "+title);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "نعم",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        mListener.deleteItem(position);

                    }
                });

        builder1.setNegativeButton(
                "لا",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }


    public interface GoalsControlInterface{
      void   deleteItem(int position);
    }


}
