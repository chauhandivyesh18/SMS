package com.millionaires.sms.Search;


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
public class SearchEquityFragment extends BaseFragment {


    public SearchEquityFragment() {
        // Required empty public constructor
    }

    ArrayList<String> mList;
    RecyclerView mRecyclerView;
    SearchAdapter mSearchEquityAdapter;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_equity, container, false);

        mContext = getActivity();
        mList = new ArrayList<>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        displayList();

        return view;
    }

    public void displayList() {
        ArrayList<String> list = new ArrayList<>();
        if (list.size() == 0) {
            mSearchEquityAdapter = new SearchAdapter(list, mContext, false);
        } else {
            mSearchEquityAdapter = new SearchAdapter(list, mContext, false);
        }
        mRecyclerView.setAdapter(mSearchEquityAdapter);
    }

}
