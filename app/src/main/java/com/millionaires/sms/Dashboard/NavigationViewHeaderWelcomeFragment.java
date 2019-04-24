package com.millionaires.sms.Dashboard;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationViewHeaderWelcomeFragment extends BaseFragment {

    Context mContext;
    TextView mUserNameTextView;
    public TextView mTotalTextView;
    SharedPrefHelper mSharedPrefHelper;
    public static NavigationViewHeaderWelcomeFragment INSTANCE;

    public NavigationViewHeaderWelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_view_header_welcome, container, false);

        INSTANCE = this;
        mContext = getActivity();
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);

        mUserNameTextView = (TextView) view.findViewById(R.id.username_textview);
        mTotalTextView = (TextView) view.findViewById(R.id.total_textview);
        ImageView settingsImageView = (ImageView) view.findViewById(R.id.settings_imageview);
        ImageView addIconImageView = (ImageView) view.findViewById(R.id.add_icon_imageview);

        mUserNameTextView.setText(mSharedPrefHelper.getString(Constants.CLIENT_ID, "") + " !");

        settingsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardActivity.getINSTANCE().setmNavigationView(Constants.SETTINGS);
                DashboardActivity.getINSTANCE().mDrawer.closeDrawer(Gravity.START);
            }
        });

        addIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    public static NavigationViewHeaderWelcomeFragment getINSTANCE() {
        return INSTANCE;
    }
}
