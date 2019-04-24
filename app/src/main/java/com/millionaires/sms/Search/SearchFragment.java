package com.millionaires.sms.Search;


import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;
import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.ViewPagerAdapter;
import com.millionaires.sms.Dashboard.DashboardActivity;
import com.millionaires.sms.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {

    TabLayout mTabLayout;
    public ViewPager mViewPager;
    Resources resources;
    Context mContext;

    ArrayList<String> mEquity, mFutures, mOptions, mCurrency;

    String searchText;

    public SearchFragment() {
        // Required empty public constructor
    }

    AllFragment mAllFragment;
    SearchEquityFragment mSearchEquityFragment;
    SearchFuturesFragment mSearchFuturesFragment;
    SearchOptionsFragment mSearchOptionsFragment;
    SearchCurrencyFragment mSearchCurrencyFragment;

    static SearchFragment INSTANCE;
    ArrayList<ArrayList<String>> list;

    private static final int DELAY = 500;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        INSTANCE = this;
        mEquity = new ArrayList<>();
        mFutures = new ArrayList<>();
        mOptions = new ArrayList<>();
        mCurrency = new ArrayList<>();
        list = new ArrayList<>();
        mContext = getActivity();
        resources = getResources();

        mAllFragment = new AllFragment();
        mSearchEquityFragment = new SearchEquityFragment();
        mSearchFuturesFragment = new SearchFuturesFragment();
        mSearchOptionsFragment = new SearchOptionsFragment();
        mSearchCurrencyFragment = new SearchCurrencyFragment();

        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setUpViewPager();
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);

        if (DashboardActivity.getINSTANCE() != null) {
            RxSearchView.queryTextChanges(DashboardActivity.getINSTANCE().mSearchView)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread(),false,100)
                    .subscribe(new Consumer<CharSequence>() {
                        @Override
                        public void accept(CharSequence charSequence) throws Exception {
                            searchText = charSequence + "";
                            if (searchText.equals("")) {
                                mEquity.clear();
                                mFutures.clear();
                                mOptions.clear();
                                mCurrency.clear();
                                list.clear();
                                list.add(mEquity);
                                list.add(mFutures);
                                list.add(mOptions);
                                list.add(mCurrency);
                                setData();
                            } else {
                                search(searchText);
                            }
                        }
                    });
        }

        return view;
    }

    public void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(mAllFragment, resources.getString(R.string.all));
        viewPagerAdapter.addFragment(mSearchEquityFragment, resources.getString(R.string.equity));
        viewPagerAdapter.addFragment(mSearchFuturesFragment, resources.getString(R.string.futures));
        viewPagerAdapter.addFragment(mSearchOptionsFragment, resources.getString(R.string.options));
        viewPagerAdapter.addFragment(mSearchCurrencyFragment, resources.getString(R.string.currency));
        mViewPager.setAdapter(viewPagerAdapter);
    }

    public static SearchFragment getINSTANCE() {
        return INSTANCE;
    }

    public void search(final String newText) {
        mEquity.clear();
        mFutures.clear();
        mOptions.clear();
        mCurrency.clear();
        list.clear();


        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //set list in this order, since same list is used on AllFragment fragment
                list.add(mEquity);
                list.add(mFutures);
                list.add(mOptions);
                list.add(mCurrency);
                setData();
            }
        }.execute();
    }

    public void setData() {
        mAllFragment.displayList();
        mSearchEquityFragment.displayList();
        mSearchFuturesFragment.displayList();
        mSearchOptionsFragment.displayList();
        mSearchCurrencyFragment.displayList();
    }

}
