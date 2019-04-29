package com.millionaires.sms.Dashboard.GridNavigation.SecurityAccess.UserMode;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.ViewPagerAdapter;
import com.millionaires.sms.R;

public class UserModeActivity extends BaseActivity {

    ImageView mActionBack;
    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mode);

        mActionBack = (ImageView) findViewById(R.id.action_back);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new InviteGuestFragment(), "Invite Guest");
        viewPagerAdapter.addFragment(new PreApproveDeliveryFragment(), "Pre-Approve Delivery");
        mViewPager.setAdapter(viewPagerAdapter);
    }
}
