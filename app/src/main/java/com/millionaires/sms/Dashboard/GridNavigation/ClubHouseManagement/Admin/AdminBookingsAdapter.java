package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.Admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User.UserBookingsAdapter;
import com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User.UserBookingsModel;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class AdminBookingsAdapter extends RecyclerView.Adapter<AdminBookingsAdapter.AdminBookingsViewHolder>{

    Context mContext;
    ArrayList<AdminBookingsModel> mList;

    public AdminBookingsAdapter(Context mContext, ArrayList<AdminBookingsModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == mList.size()) {

        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public AdminBookingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AdminBookingsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_clubhouse_admin_bookings, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdminBookingsViewHolder adminBookingsViewHolder, int i) {
        AdminBookingsModel adminBookingsModel = mList.get(i);
        adminBookingsViewHolder.mFlatNoTextView.setText(adminBookingsModel.getmFlatNo());
        adminBookingsViewHolder.mNameTextView.setText(adminBookingsModel.getmName());
        adminBookingsViewHolder.mAccompaniesTextView.setText(adminBookingsModel.getmAccompanies());
        adminBookingsViewHolder.mDateTextView.setText(adminBookingsModel.getmDate());
        adminBookingsViewHolder.mSlotTextView.setText(adminBookingsModel.getmSlot());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AdminBookingsViewHolder extends RecyclerView.ViewHolder {

        TextView mFlatNoTextView;
        TextView mNameTextView;
        TextView mAccompaniesTextView;
        TextView mDateTextView;
        TextView mSlotTextView;

        public AdminBookingsViewHolder(@NonNull View itemView) {
            super(itemView);
            mFlatNoTextView = itemView.findViewById(R.id.flatno_textview);
            mNameTextView = itemView.findViewById(R.id.name_textview);
            mAccompaniesTextView = itemView.findViewById(R.id.accompanies_textview);
            mDateTextView = itemView.findViewById(R.id.date_textview);
            mSlotTextView = itemView.findViewById(R.id.slot_textview);
        }
    }
}
