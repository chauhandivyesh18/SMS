package com.millionaires.sms.Dashboard.NavigationViewMenu.ExpenditureReports;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.ViewPagerAdapter;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenditureReportsMainFragment extends BaseFragment {

    private static final String TAG = ExpenditureReportsMainFragment.class.getSimpleName();

    Context mContext;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    Resources resources;
    int mPage;

    ExpenditureReportsFragment mExpenditureReportsFragment;
    DefaultersListFragment mDefaultersListFragment;
    SocietyMembersListFragment mSocietyMembersListFragment;

    static ExpenditureReportsMainFragment INSTANCE;

    public ExpenditureReportsMainFragment() {
        // Required empty public constructor
    }

    public static ExpenditureReportsMainFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(Constants.PAGE, page);
        ExpenditureReportsMainFragment fragment = new ExpenditureReportsMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenditure_reports_main, container, false);
        mPage = getArguments().getInt(Constants.PAGE);

        INSTANCE = this;
        mContext = getActivity();
        resources = getResources();
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mExpenditureReportsFragment = new ExpenditureReportsFragment();
        mDefaultersListFragment = new DefaultersListFragment();
        mSocietyMembersListFragment = new SocietyMembersListFragment();
        setUpViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
        //mViewPager.setOffscreenPageLimit(3); //increase after adding any fragment
        mViewPager.setCurrentItem(mPage);

        return view;
    }

    public void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(mExpenditureReportsFragment, "Expenditure Reports");
        viewPagerAdapter.addFragment(mDefaultersListFragment, "Defaulters");
        viewPagerAdapter.addFragment(mSocietyMembersListFragment, "Society Members");
        mViewPager.setAdapter(viewPagerAdapter);
    }

    public static ExpenditureReportsMainFragment getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mExpenditureReportsFragment = null;
        mDefaultersListFragment = null;
        mSocietyMembersListFragment = null;
    }
}
