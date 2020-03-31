package com.example.myhealth.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.model.MyMessage;

import java.util.ArrayList;


public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.MyViewHolder> {


    private final Context mContext;
    private ArrayList<MyMessage> mMyMessages;


    //create adapter constructor
    public ChatRecyclerViewAdapter(Context context, ArrayList<MyMessage> itemsArrayList) {
        mContext = context;
        mMyMessages = itemsArrayList;
    }

    @NonNull
    @Override
    //retturn list item layout
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chat_message, viewGroup, false);

        return new MyViewHolder(itemView);

    }

    @Override
    //connect between viewHolder and data
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MyMessage MyMessage = mMyMessages.get(position);

        if (MyMessage.getIsBelongsToCurrentUser()) { // this MyMessage was sent by us so let's create a basic chat bubble on the right
            holder.vMyMyMessageView.setVisibility(View.VISIBLE);
            holder.vTheirMyMessageView.setVisibility(View.GONE);
            holder.tvMyMyMessageBody.setText(MyMessage.getContent());

        } else { // this MyMessage was sent by someone else so let's create an advanced chat bubble on the left
            holder.vTheirMyMessageView.setVisibility(View.VISIBLE);
            holder.vMyMyMessageView.setVisibility(View.GONE);
            holder.name.setText(MyMessage.getSender());
            holder.tvTheirMyMessageBody.setText(MyMessage.getContent());

        }
    }

    @Override
    public int getItemCount() {
        return mMyMessages.size();
    }


    public void addMyMessage(MyMessage massage) {
        mMyMessages.add(massage);
        notifyItemChanged(mMyMessages.size() - 1);

    }

    //declare all the views in the list item
    class MyViewHolder extends RecyclerView.ViewHolder {


        View vMyMyMessageView;
        View vTheirMyMessageView;

        TextView tvMyMyMessageBody;
        TextView tvTheirMyMessageBody;
        TextView name;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            vMyMyMessageView = itemView.findViewById(R.id.inc_my_message);
            vTheirMyMessageView = itemView.findViewById(R.id.inc_their_message);

            tvMyMyMessageBody = itemView.findViewById(R.id.message_body);
            tvTheirMyMessageBody = itemView.findViewById(R.id.their_message_body);
            name = itemView.findViewById(R.id.tv_username);
        }
    }


}
