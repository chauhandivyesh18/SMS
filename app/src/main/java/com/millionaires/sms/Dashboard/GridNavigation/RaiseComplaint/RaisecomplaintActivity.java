package com.millionaires.sms.Dashboard.GridNavigation.RaiseComplaint;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AddannouncementActivity;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class RaisecomplaintActivity extends BaseActivity {
    ImageView mActionBack;
    static RaisecomplaintActivity INSTANCE;
    Toolbar mToolbar;
    Context mContext;
    Resources resources;
    RecyclerView rv_complaints;
    RaisecomplaintAdapter mRaisecomplaintAdapter;
    ArrayList<RaisecomplaintModel> arr_complaints;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raisecomplaint);
        mActionBack = (ImageView) findViewById(R.id.action_back);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=RaisecomplaintActivity.this;
        setSupportActionBar(mToolbar);
        INSTANCE = this;
        resources = getResources();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        rv_complaints=(RecyclerView) findViewById(R.id.recyclerview);
        rv_complaints.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        ((SimpleItemAnimator) rv_complaints.getItemAnimator()).setSupportsChangeAnimations(false);
        arr_complaints=new ArrayList<RaisecomplaintModel>();
        LoadData();
        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LoadData();

            }
        });
    }

    private void LoadData() {
        if(arr_complaints != null && arr_complaints.size()<=0) {
            arr_complaints.add(new RaisecomplaintModel("1","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("2","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("3","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("4","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("5","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("6","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("7","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("8","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("9","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("10","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));
            arr_complaints.add(new RaisecomplaintModel("11","A-201","Cleaning Issue","The simplest Adapter to populate a view from an ArrayList is the ArrayAdapter. That’s what we’ll implement in this tutorial. There are other adapters as well","","Resolved","28 April"));

            mRaisecomplaintAdapter = new RaisecomplaintAdapter(mContext, arr_complaints);
            rv_complaints.setAdapter(mRaisecomplaintAdapter);
            rv_complaints.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setRefreshing(false);
        }
        else
        {
            mRaisecomplaintAdapter = new RaisecomplaintAdapter(mContext, arr_complaints);
            rv_complaints.setAdapter(mRaisecomplaintAdapter);
            rv_complaints.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setRefreshing(false);
        }

    }
}
