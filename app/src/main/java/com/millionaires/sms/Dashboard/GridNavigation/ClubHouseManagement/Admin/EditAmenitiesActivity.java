package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class EditAmenitiesActivity extends BaseActivity {

    ImageView mActionBack;
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    AmenitiesAdapter mAmenitiesAdapter;
    ArrayList<AmenitiesModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_amenities);
        mList = new ArrayList<>();

        mActionBack = (ImageView) findViewById(R.id.action_back);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        AmenitiesModel amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("Swimming");
        amenitiesModel.setmSet(true);
        mList.add(amenitiesModel);

        amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("TableTennis");
        amenitiesModel.setmSet(true);
        mList.add(amenitiesModel);

        amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("Squash");
        amenitiesModel.setmSet(false);
        mList.add(amenitiesModel);

        amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("Carrom");
        amenitiesModel.setmSet(false);
        mList.add(amenitiesModel);

        amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("Chess");
        amenitiesModel.setmSet(true);
        mList.add(amenitiesModel);

        amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("FootBall");
        amenitiesModel.setmSet(false);
        mList.add(amenitiesModel);

        amenitiesModel = new AmenitiesModel();
        amenitiesModel.setmAmenity("BasketBall");
        amenitiesModel.setmSet(true);
        mList.add(amenitiesModel);

        mAmenitiesAdapter = new AmenitiesAdapter(this, mList);
        mRecyclerView.setAdapter(mAmenitiesAdapter);
    }
}
