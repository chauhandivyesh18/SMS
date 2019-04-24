package com.millionaires.sms.Search;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends BaseFragment {


    public AllFragment() {
        // Required empty public constructor
    }

    LinearLayout mEquitySearchLayout;
    LinearLayout mFuturesSearchLayout;
    LinearLayout mOptionsSearchLayout;
    LinearLayout mCurrencySearchLayout;

    RecyclerView mEquityRecyclerView;
    RecyclerView mFuturesRecyclerView;
    RecyclerView mOptionsRecyclerView;
    RecyclerView mCurrencyRecyclerView;

    ImageView mEquityForwardArrowImageView;
    ImageView mFuturesForwardArrowImageView;
    ImageView mOptionsForwardArrowImageView;
    ImageView mCurrencyForwardArrowImageView;

    TextView mNoDataFoundTextView;
    Context mContext;

    SearchAdapter mSearchEquityAdapter, mSearchFuturesAdapter, mSearchOptionsAdapter, mSearchCurrencyAdapter;
    ArrayList<String> mSearchEquityList, mSearchFuturesList, mSearchOptionsList, mSearchCurrencyList;
    ArrayList<String> mList;

    static AllFragment INSTANCE;

    public static AllFragment newInstance(String searchText) {

        Bundle args = new Bundle();
        args.putString("SearchText", searchText);
        AllFragment fragment = new AllFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);

        INSTANCE = this;
        mContext = getActivity();

        mList = new ArrayList<>();
        mSearchEquityList = new ArrayList<>();
        mSearchFuturesList = new ArrayList<>();
        mSearchOptionsList = new ArrayList<>();
        mSearchCurrencyList = new ArrayList<>();

        //mNoDataFoundTextView = (TextView) view.findViewById(R.id.no_data_found_textview);
        mEquitySearchLayout = (LinearLayout)  view.findViewById(R.id.equity_search_layout);
        mFuturesSearchLayout = (LinearLayout)  view.findViewById(R.id.futures_search_layout);
        mOptionsSearchLayout = (LinearLayout)  view.findViewById(R.id.options_search_layout);
        mCurrencySearchLayout = (LinearLayout) view.findViewById(R.id.currency_search_layout);

        mEquityRecyclerView = (RecyclerView) view.findViewById(R.id.equity_recyclerview);
        mFuturesRecyclerView = (RecyclerView) view.findViewById(R.id.futures_recyclerview);
        mOptionsRecyclerView = (RecyclerView) view.findViewById(R.id.options_recyclerview);
        mCurrencyRecyclerView = (RecyclerView) view.findViewById(R.id.currency_recyclerview);

        mEquityForwardArrowImageView = (ImageView) view.findViewById(R.id.equity_forward_arrow);
        mFuturesForwardArrowImageView = (ImageView) view.findViewById(R.id.futures_forward_arrow);
        mOptionsForwardArrowImageView = (ImageView) view.findViewById(R.id.options_forward_arrow);
        mCurrencyForwardArrowImageView = (ImageView) view.findViewById(R.id.currency_forward_arrow);

        mEquityRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mFuturesRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mOptionsRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mCurrencyRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        mEquityForwardArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment.getINSTANCE().mViewPager.setCurrentItem(1);
            }
        });
        mFuturesForwardArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment.getINSTANCE().mViewPager.setCurrentItem(2);
            }
        });
        mOptionsForwardArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment.getINSTANCE().mViewPager.setCurrentItem(3);
            }
        });
        mCurrencyForwardArrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment.getINSTANCE().mViewPager.setCurrentItem(4);
            }
        });

        displayList();

        return view;
    }

    public static AllFragment getINSTANCE() {
        return INSTANCE;
    }

    public void displayList() {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        if (list.size() > 0) {
            mSearchEquityList = list.get(0);
            mSearchFuturesList = list.get(1);
            mSearchOptionsList = list.get(2);
            mSearchCurrencyList = list.get(3);

            if (mSearchEquityList.size() == 0) {
                mEquitySearchLayout.setVisibility(View.GONE);
            } else {
                mEquitySearchLayout.setVisibility(View.VISIBLE);
                mSearchEquityAdapter = new SearchAdapter(mSearchEquityList, mContext, true);
                mEquityRecyclerView.setAdapter(mSearchEquityAdapter);
            }

            if (mSearchFuturesList.size() == 0) {
                mFuturesSearchLayout.setVisibility(View.GONE);
            } else {
                mFuturesSearchLayout.setVisibility(View.VISIBLE);
                mSearchFuturesAdapter =  new SearchAdapter(mSearchFuturesList, mContext, true);
                mFuturesRecyclerView.setAdapter(mSearchFuturesAdapter);
            }

            if (mSearchOptionsList.size() == 0) {
                mOptionsSearchLayout.setVisibility(View.GONE);
            } else {
                mOptionsSearchLayout.setVisibility(View.VISIBLE);
                mSearchOptionsAdapter =  new SearchAdapter(mSearchOptionsList, mContext, true);
                mOptionsRecyclerView.setAdapter(mSearchOptionsAdapter);
            }

            if (mSearchCurrencyList.size() == 0) {
                mCurrencySearchLayout.setVisibility(View.GONE);
            } else {
                mCurrencySearchLayout.setVisibility(View.VISIBLE);
                mSearchCurrencyAdapter =  new SearchAdapter(mSearchCurrencyList, mContext, true);
                mCurrencyRecyclerView.setAdapter(mSearchCurrencyAdapter);
            }
        }
    }

}
