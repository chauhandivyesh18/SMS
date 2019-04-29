package com.millionaires.sms.Dashboard;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User.ClubhouseUserActivity;
import com.millionaires.sms.Dashboard.GridNavigation.RaiseComplaint.RaisecomplaintActivity;
import com.millionaires.sms.Dashboard.GridNavigation.SecurityAccess.UserMode.UserModeActivity;
import com.millionaires.sms.Dashboard.NavigationViewMenu.SecurityAccessFragment;
import com.millionaires.sms.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends BaseFragment {

    Context mContext;
    Resources resources;
    static DashboardFragment INSTANCE;
    ArrayList<Nav_GridModel> arrGridModel;
    GridView androidGridView;
    DashboardFragment mDashboardFragment;
    Fragment fragment = null;
    ViewPager viewpager;
    PagerAdapter adapter;
    int[] img;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(int page) {

        Bundle args = new Bundle();
        args.putInt(Constants.PAGE, page);
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //mPage = getArguments().getInt(Constants.PAGE);
        INSTANCE = this;
        mContext = getActivity();
        resources = getResources();
        //image slider code
        img = new int[]{R.drawable.cosmos, R.drawable.cosmos, R.drawable.cosmos,
                R.drawable.cosmos};
        viewpager = (ViewPager) view.findViewById(R.id.pager);
        adapter = new SliderAdapter(mContext, img);
        viewpager.setAdapter(adapter);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(viewpager);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = img.length;
                    if (currentPage == 0) {
                        viewpager.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage == pageCount - 1) {
                        viewpager.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewpager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 2500, 2500);
        //image slider code


        //Grid code
        arrGridModel = new ArrayList<>();
        arrGridModel.add(new Nav_GridModel(1, "Club Management", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(2, "Expenditure Report", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(3, "Waste Management", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(4, "Raise Complaints", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(5, "Socity Memebers", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(6, "Service Provider", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(7, "Maintainance Charge", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(8, "Upload Expenditure", R.drawable.ic_portfolio));
        arrGridModel.add(new Nav_GridModel(9, "Security Access Management", R.drawable.ic_portfolio));
        Nav_Grid_Adapter adapterViewAndroid = new Nav_Grid_Adapter(mContext, arrGridModel);
        androidGridView = (GridView) view.findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        mDashboardFragment = new DashboardFragment();
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                String name = arrGridModel.get(i).getNav_Name();
                if (name.equals("Club Management")) {
                    startActivity(new Intent(mContext, ClubhouseUserActivity.class));
                } else if (name.equals("Expenditure Report")) {

                } else if (name.equals("Waste Management")) {
                    /*fragment = new WasteManagementFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.navigation_view_fragments_container, fragment);
                    ft.commit();*/
                } else if (name.equals("Raise Complaints")) {
                    startActivity(new Intent(mContext, RaisecomplaintActivity.class));

                } else if (name.equals("Socity Memebers")) {

                } else if (name.equals("Service Provider")) {

                } else if (name.equals("Upload Expenditure")) {

                } else if (name.equals("Maintainance Charge")) {

                } else if (name.equals("Security Access Management")) {
                    startActivity(new Intent(mContext, UserModeActivity.class));
                }

            }
        });
//Grid code
        return view;
    }

}
