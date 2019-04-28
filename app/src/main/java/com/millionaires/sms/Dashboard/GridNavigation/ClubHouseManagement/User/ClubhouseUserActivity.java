package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.ViewPagerAdapter;
import com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.Admin.ClubhouseAdminActivity;
import com.millionaires.sms.R;

public class ClubhouseUserActivity extends BaseActivity {

    ImageView mActionBack;
    static ClubhouseUserActivity INSTANCE;
    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubhouse_user);
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
        viewPagerAdapter.addFragment(new BookingsFragment(), "Bookings");
        viewPagerAdapter.addFragment(new ScheduleFragment(), "Schedule");
        mViewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_clubhouse_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_admin:
                startActivity(new Intent(this, ClubhouseAdminActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
