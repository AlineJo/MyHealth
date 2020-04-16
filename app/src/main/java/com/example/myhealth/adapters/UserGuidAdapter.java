package com.example.myhealth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.myhealth.R;
import com.example.myhealth.model.UserGuid;

import java.util.ArrayList;

public class UserGuidAdapter extends BaseAdapter {

    private final Context mContext;
    private final ArrayList<UserGuid> mItems;

    public UserGuidAdapter(Context context, ArrayList<UserGuid> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView tvTitle;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_user_guid, viewGroup, false);
        }

        UserGuid userGuid = (UserGuid) getItem(i);

        ImageView ivCloud = view.findViewById(R.id.iv_cloud);
        ivCloud.setImageResource(userGuid.getCloudShape());

        tvTitle = view.findViewById(R.id.tv_titles);
        tvTitle.setText(userGuid.getTitle());
        tvTitle.setTextColor(ContextCompat.getColor(mContext, userGuid.getTextColor()));

        return view;
    }
}
