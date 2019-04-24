package com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.millionaires.sms.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_spinner_item;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnnouncementsFragment extends Fragment {
    static AnnouncementsFragment INSTANCE;
    Context mContext;
    FloatingActionButton fab;
    RecyclerView rv_announcements;
    AnnouncementAdapter mAnnouncementAdapter;
    ArrayList<AnnouncementModel> arr_announce;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public AnnouncementsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcements, container, false);
        INSTANCE = this;
        mContext = getActivity();
        //final Spinner spinner = (Spinner) view.findViewById(R.id.announce_spinner);
        fab=(FloatingActionButton) view.findViewById(R.id.fab);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        rv_announcements=(RecyclerView) view.findViewById(R.id.recyclerview);
        rv_announcements.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        ((SimpleItemAnimator) rv_announcements.getItemAnimator()).setSupportsChangeAnimations(false);
        arr_announce=new ArrayList<AnnouncementModel>();
        LoadData();

        // Spinner click listener
       /* List<String> categories = new ArrayList<String>();
        categories.add("Item 1");
        categories.add("Item 2");
        categories.add("Item 3");
        categories.add("Item 4");
        categories.add("Item 5");
        categories.add("Item 6");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mContext, simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);*/
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddannouncementActivity.class));
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LoadData();

            }
        });
        return view;
    }

    private void LoadData() {
        if(arr_announce != null && arr_announce.size()<=0) {
            arr_announce.add(new AnnouncementModel("NOTICE 1","","As a ListView is instantiated and the rows are populated such that the full height of the list is filled. After that no new row items are created in the memory. As the user scrolls through","4.30PM"));
            arr_announce.add(new AnnouncementModel("NOTICE 2","","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter","2.30PM"));
            arr_announce.add(new AnnouncementModel("NOTICE 3","","In this tutorial we’ll use a CustomAdapter that populates the custom rows of the Android ListView with an ArrayList. Also to enhance the user experience, we’ll animate the ListView while scrolling.","Monday"));
            arr_announce.add(new AnnouncementModel("NOTICE 4","","As a ListView is instantiated and the rows are populated such that the full height of the list is filled.","4.30PM"));
            arr_announce.add(new AnnouncementModel("NOTICE 5","","After that no new row items are created in the memory. As the user scrolls through","4.30PM"));
            arr_announce.add(new AnnouncementModel("NOTICE 6","","After that no new row items are created in the memory.","4.30PM"));
            arr_announce.add(new AnnouncementModel("NOTICE 7","","As a ListView is instantiated and the rows are populated such that the full height of the list is filled.As the user scrolls through","Tuesday"));
            arr_announce.add(new AnnouncementModel("NOTICE 8","","As a ListView is instantiated and the rows are populated such that the full height of the list is filled. As the user scrolls through","8.00AM"));
            arr_announce.add(new AnnouncementModel("NOTICE 9","","As a ListView is instantiated and the rows are populated such that the full height of the list is filled.As the user scrolls through","10.30AM"));
            mAnnouncementAdapter = new AnnouncementAdapter(mContext, arr_announce);
            rv_announcements.setAdapter(mAnnouncementAdapter);
            rv_announcements.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setRefreshing(false);
        }
        else
        {
            mAnnouncementAdapter = new AnnouncementAdapter(mContext, arr_announce);
            rv_announcements.setAdapter(mAnnouncementAdapter);
            rv_announcements.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setRefreshing(false);
        }

    }

}
