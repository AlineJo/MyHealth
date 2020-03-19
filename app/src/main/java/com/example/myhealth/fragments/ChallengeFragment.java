package com.example.myhealth.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhealth.R;
import com.example.myhealth.adapters.ChatRecyclerViewAdapter;
import com.example.myhealth.model.MyMessage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengeFragment extends Fragment {


    private ArrayList<MyMessage> mMessages;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private ChatRecyclerViewAdapter mAdapter;

    public ChallengeFragment() {
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

        View parentView = inflater.inflate(R.layout.chat_dialog, container, false);
        mMessages = new ArrayList<MyMessage>();
        mRecyclerView = parentView.findViewById(R.id.rv_messages_view);
        setupRecyclerView();

        //this function should create demo chat
        createDemoChat();

        return parentView;
    }

    private void createDemoChat() {
        addMessage("Zainab", "اليوم مشيت 4 كيلو عالبحر", false);
        addMessage("najah", "جربت رجيم كيتو مدة أسبوع. وفي فرق في الوزن", false);
        addMessage("me", "ممتاز", true);

    }

    private void setupRecyclerView() {

        mAdapter = new ChatRecyclerViewAdapter(mContext, mMessages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        // linearLayoutManager.setStackFromEnd(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), ((LinearLayoutManager) linearLayoutManager).getOrientation());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //   mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        scrollToLast();
    }

    private void addMessage(String messageSender, String messageContent, boolean isBelongsToCurrentUser) {
        MyMessage m = new MyMessage(messageSender, messageContent, isBelongsToCurrentUser);
        mMessages.add(m);
        mRecyclerView.scrollToPosition(mRecyclerView.getAdapter().getItemCount() - 1);
        mAdapter.notifyItemChanged(mMessages.size() - 1, m);
    }


    private void scrollToLast() {
        mRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v,
                                       int left, int top, int right, int bottom,
                                       int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom < oldBottom) {
                    mRecyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (mMessages.size() > 0)
                                mRecyclerView.smoothScrollToPosition(mRecyclerView.getAdapter().getItemCount() - 1);
                        }
                    }, 100);
                }
            }
        });
    }

}
