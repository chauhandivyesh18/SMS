package com.millionaires.sms.Dashboard.GridNavigation.ClubHouseManagement.User;


import android.app.DatePickerDialog;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends BaseFragment {

    Context mContext;
    Spinner mActivitySpinner, mSlotSpinner, mAccompaniesSpinner;
    EditText mDateEditText;
    ImageView mDateImageView;

    private int mYear, mMonth, mDay, mHour, mMinute;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        mContext = getActivity();

        mActivitySpinner = (Spinner) view.findViewById(R.id.activity_spinner);
        mSlotSpinner = (Spinner) view.findViewById(R.id.slot_spinner);
        mAccompaniesSpinner = (Spinner) view.findViewById(R.id.accompanies_spinner);

        mDateEditText = (EditText) view.findViewById(R.id.date_edittext);
        mDateImageView = (ImageView) view.findViewById(R.id.date_imageview);

        ArrayList<String> activities = new ArrayList<>();
        activities.add("Swimming");
        activities.add("TableTennis");

        ArrayAdapter<String> activityAdapter = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, activities);
        activityAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        mActivitySpinner.setAdapter(activityAdapter);

        ArrayList<String> slots = new ArrayList<>();
        slots.add("3pm - 4pm");
        slots.add("4pm - 5pm");

        ArrayAdapter<String> slotAdapter = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, slots);
        slotAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        mSlotSpinner.setAdapter(slotAdapter);

        ArrayList<String> acc = new ArrayList<>();
        acc.add("1");
        acc.add("2");

        ArrayAdapter<String> accompaniesAdapter = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, acc);
        accompaniesAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        mAccompaniesSpinner.setAdapter(accompaniesAdapter);

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        mDateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                mDateEditText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        return view;
    }

}
