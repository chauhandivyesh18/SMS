package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User.UserBookingsAdapter;
import com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User.UserBookingsModel;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class ClubhouseAdminActivity extends BaseActivity {

    ImageView mActionBack;
    Toolbar mToolbar;
    Spinner mActivitySpinner;
    RecyclerView mRecyclerView;
    AdminBookingsAdapter mAdminBookingsAdapter;
    ArrayList<AdminBookingsModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubhouse_admin);

        mActionBack = (ImageView) findViewById(R.id.action_back);
        mActivitySpinner = (Spinner) findViewById(R.id.activity_spinner);

        mList = new ArrayList<>();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayList<String> activities = new ArrayList<>();
        activities.add("Swimming");
        activities.add("TableTennis");

        ArrayAdapter<String> activityAdapter = new ArrayAdapter<String>(this, R.layout.list_item_spinner, activities);
        activityAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        mActivitySpinner.setAdapter(activityAdapter);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        AdminBookingsModel adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-501, ");
        adminBookingsModel.setmName("Omkar Mahadik");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("24-Apr-2019");
        adminBookingsModel.setmSlot("3pm - 4pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-601, ");
        adminBookingsModel.setmName("Divyesh Chauhan");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("25-Apr-2019");
        adminBookingsModel.setmSlot("4pm - 5pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-701, ");
        adminBookingsModel.setmName("Abhishek Tankaria");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("26-Apr-2019");
        adminBookingsModel.setmSlot("4pm - 5pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-501, ");
        adminBookingsModel.setmName("Omkar Mahadik");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("24-Apr-2019");
        adminBookingsModel.setmSlot("3pm - 4pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-601, ");
        adminBookingsModel.setmName("Divyesh Chauhan");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("25-Apr-2019");
        adminBookingsModel.setmSlot("4pm - 5pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-701, ");
        adminBookingsModel.setmName("Abhishek Tankaria");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("26-Apr-2019");
        adminBookingsModel.setmSlot("4pm - 5pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-501, ");
        adminBookingsModel.setmName("Omkar Mahadik");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("24-Apr-2019");
        adminBookingsModel.setmSlot("3pm - 4pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-601, ");
        adminBookingsModel.setmName("Divyesh Chauhan");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("25-Apr-2019");
        adminBookingsModel.setmSlot("4pm - 5pm");
        mList.add(adminBookingsModel);

        adminBookingsModel = new AdminBookingsModel();
        adminBookingsModel.setmFlatNo("Flat-701, ");
        adminBookingsModel.setmName("Abhishek Tankaria");
        adminBookingsModel.setmAccompanies("Accompanies : 4");
        adminBookingsModel.setmDate("26-Apr-2019");
        adminBookingsModel.setmSlot("4pm - 5pm");
        mList.add(adminBookingsModel);

        mAdminBookingsAdapter = new AdminBookingsAdapter(this, mList);
        mRecyclerView.setAdapter(mAdminBookingsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_clubhouse_admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_edit:
                startActivity(new Intent(this, EditAmenitiesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
