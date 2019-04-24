package com.millionaires.sms.Dashboard.NavigationViewMenu.Bazaar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AddannouncementActivity;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class BazaarFragment extends Fragment {

    static BazaarFragment INSTANCE;
    Context mContext;
    FloatingActionButton fab;
    public RecyclerView rv_bazaar;
    BazaarAdapter mBazaarAdapter;
    ArrayList<BazaarModel> arr_bazaar;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    LinearLayout lnr_createpost;
    public BazaarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bazaar, container, false);
        INSTANCE = this;
        mContext = getActivity();
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        lnr_createpost = (LinearLayout) view.findViewById(R.id.lnr_createpost);
        rv_bazaar = (RecyclerView) view.findViewById(R.id.recyclerview);
        /*rv_bazaar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));*/
        ((SimpleItemAnimator) rv_bazaar.getItemAnimator()).setSupportsChangeAnimations(false);
        arr_bazaar = new ArrayList<BazaarModel>();
        LoadData();
        rv_bazaar.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy <= 0 && fab.getVisibility() == View.VISIBLE) {
                    fab.hide();
                } else if (dy >= 0 && fab.getVisibility() != View.VISIBLE) {
                    fab.show();
                }
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddannouncementActivity.class));
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
        if (arr_bazaar != null && arr_bazaar.size() <= 0) {
            arr_bazaar.add(new BazaarModel("1", "", "National Discovery", "2 hours ago", "Cosmos Title", "The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter", ""));
            arr_bazaar.add(new BazaarModel("2", "", "National Discovery", "2 hours ago", "Cosmos Title", "The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter", ""));
            arr_bazaar.add(new BazaarModel("3", "", "National Discovery", "2 hours ago", "Cosmos Title", "The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter", ""));
            arr_bazaar.add(new BazaarModel("4", "", "National Discovery", "2 hours ago", "Cosmos Title", "The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter", ""));
            arr_bazaar.add(new BazaarModel("5", "", "National Discovery", "2 hours ago", "Cosmos Title", "The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter", ""));
            arr_bazaar.add(new BazaarModel("6", "", "National Discovery", "2 hours ago", "Cosmos Title", "The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well, such as the CursorAdapter", ""));
            rv_bazaar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            rv_bazaar.setHasFixedSize(true);
            mBazaarAdapter = new BazaarAdapter(mContext, arr_bazaar);
            rv_bazaar.setAdapter(mBazaarAdapter);
            rv_bazaar.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setRefreshing(false);
        } else {
            rv_bazaar.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            rv_bazaar.setHasFixedSize(true);
            mBazaarAdapter = new BazaarAdapter(mContext, arr_bazaar);
            rv_bazaar.setAdapter(mBazaarAdapter);
            rv_bazaar.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setRefreshing(false);
        }

    }

}
