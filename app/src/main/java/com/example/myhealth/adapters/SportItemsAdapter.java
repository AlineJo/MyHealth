package com.example.myhealth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhealth.R;
import com.example.myhealth.model.SportActivityItem;

import java.util.ArrayList;

public class SportItemsAdapter extends BaseAdapter {

    private final Context mContext;
    private ArrayList<SportActivityItem> mItems;

    public SportItemsAdapter(Context context) {
        mContext = context;
        mItems = new ArrayList<SportActivityItem>();
    }


    public void update(ArrayList<SportActivityItem> newSportItems) {
        mItems = newSportItems;
        notifyDataSetChanged();
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

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_sport_activity, viewGroup, false);
        }

        SportActivityItem item = (SportActivityItem) getItem(i);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDesc = view.findViewById(R.id.tv_desc);
        ImageView ivImg = view.findViewById(R.id.iv_img);

        tvTitle.setText(item.getTitle());
        tvDesc.setText(item.getDescription());
        ivImg.setImageResource(item.getImg());

        return view;
    }
}
