package com.millionaires.sms.Dashboard.GridNavigation.RaiseComplaint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements.AddannouncementActivity;
import com.millionaires.sms.R;

public class RaisecomplaintActivity extends BaseActivity {
    ImageView mActionBack;
    static RaisecomplaintActivity INSTANCE;
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raisecomplaint);
        mActionBack = (ImageView) findViewById(R.id.action_back);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
