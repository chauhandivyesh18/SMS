package com.millionaires.sms.Dashboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationViewHeaderLoginFragment extends BaseFragment {


    public NavigationViewHeaderLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_view_header_login, container, false);
    }

}
