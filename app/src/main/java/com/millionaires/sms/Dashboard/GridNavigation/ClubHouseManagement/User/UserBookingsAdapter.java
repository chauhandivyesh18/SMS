package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.millionaires.sms.R;

import java.util.ArrayList;

public class UserBookingsAdapter extends RecyclerView.Adapter<UserBookingsAdapter.UserBookingsViewHolder>{

    Context mContext;
    ArrayList<UserBookingsModel> mList;

    public UserBookingsAdapter(Context mContext, ArrayList<UserBookingsModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public UserBookingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserBookingsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_clubhouse_user_bookings, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserBookingsViewHolder userBookingsViewHolder, int i) {
        UserBookingsModel userBookingsModel = mList.get(i);
        userBookingsViewHolder.mActivityTextView.setText(userBookingsModel.getmActivity());
        userBookingsViewHolder.mDateTextView.setText(userBookingsModel.getmDate());
        userBookingsViewHolder.mSlotTextView.setText(userBookingsModel.getmSlot());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class UserBookingsViewHolder extends RecyclerView.ViewHolder {

        TextView mActivityTextView;
        TextView mDateTextView;
        TextView mSlotTextView;

        public UserBookingsViewHolder(@NonNull View itemView) {
            super(itemView);
            mActivityTextView = itemView.findViewById(R.id.activity_textview);
            mDateTextView = itemView.findViewById(R.id.date_textview);
            mSlotTextView = itemView.findViewById(R.id.slot_textview);
        }
    }
}
