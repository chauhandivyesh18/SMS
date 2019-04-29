package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingsFragment extends BaseFragment {

    Context mContext;
    RecyclerView mRecyclerView;
    UserBookingsAdapter mUserBookingsAdapter;
    ArrayList<UserBookingsModel> mList;

    public BookingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);

        mContext = getActivity();
        mList = new ArrayList<>();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        UserBookingsModel userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Swimming");
        userBookingsModel.setmDate("24-Apr-2019");
        userBookingsModel.setmSlot("3pm - 4pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Table Tennis");
        userBookingsModel.setmDate("25-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Squash");
        userBookingsModel.setmDate("26-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Swimming");
        userBookingsModel.setmDate("24-Apr-2019");
        userBookingsModel.setmSlot("3pm - 4pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Table Tennis");
        userBookingsModel.setmDate("25-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Squash");
        userBookingsModel.setmDate("26-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Swimming");
        userBookingsModel.setmDate("24-Apr-2019");
        userBookingsModel.setmSlot("3pm - 4pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Table Tennis");
        userBookingsModel.setmDate("25-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Squash");
        userBookingsModel.setmDate("26-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Swimming");
        userBookingsModel.setmDate("24-Apr-2019");
        userBookingsModel.setmSlot("3pm - 4pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Table Tennis");
        userBookingsModel.setmDate("25-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        userBookingsModel = new UserBookingsModel();
        userBookingsModel.setmActivity("Squash");
        userBookingsModel.setmDate("26-Apr-2019");
        userBookingsModel.setmSlot("4pm - 5pm");
        mList.add(userBookingsModel);

        mUserBookingsAdapter = new UserBookingsAdapter(mContext, mList);
        mRecyclerView.setAdapter(mUserBookingsAdapter);

        return view;
    }

}
