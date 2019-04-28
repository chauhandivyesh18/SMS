package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.Admin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.millionaires.sms.R;

import java.util.ArrayList;

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.AmenitiesViewHolder> {

    Context mContext;
    ArrayList<AmenitiesModel> mList;

    public AmenitiesAdapter(Context mContext, ArrayList<AmenitiesModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AmenitiesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AmenitiesViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_edit_amenities, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AmenitiesViewHolder amenitiesViewHolder, int i) {
        AmenitiesModel amenitiesModel = mList.get(i);
        amenitiesViewHolder.mAmenitiesTextView.setText(amenitiesModel.getmAmenity());
        if (amenitiesModel.ismSet()) amenitiesViewHolder.mCheckBox.setChecked(true);
        else amenitiesViewHolder.mCheckBox.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AmenitiesViewHolder extends RecyclerView.ViewHolder {

        TextView mAmenitiesTextView;
        CheckBox mCheckBox;

        public AmenitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            mAmenitiesTextView = (TextView) itemView.findViewById(R.id.amenity_textview);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
