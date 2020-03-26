package com.example.myhealth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myhealth.R;
import com.example.myhealth.model.User;

import java.util.ArrayList;

public class UsersSearchAdapter extends BaseAdapter {

    private final Context mContext;
    private ArrayList<User> mItems;

    public UsersSearchAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_user, parent, false);
        }

        User u = (User) getItem(position);

        TextView tvName = convertView.findViewById(R.id.tv_name);

        tvName.setText(u.getName());

        return convertView;
    }

    public void update(ArrayList<User> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
