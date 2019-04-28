package com.millionaires.sms.Dashboard.GridNavigation.SecurityAccess.UserMode;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
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
import android.widget.TimePicker;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreApproveDeliveryFragment extends BaseFragment {

    Context mContext;
    EditText mDateEditText, mFromEditText, mToEditText;
    ImageView mDateImageView, mFromImageView, mToImageView;
    Spinner mCompanySpinner;

    private int mYear, mMonth, mDay, mHour, mMinute;

    public PreApproveDeliveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pre_approve_delivery, container, false);

        mContext = getActivity();

        mDateEditText = (EditText) view.findViewById(R.id.date_edittext);
        mDateImageView = (ImageView) view.findViewById(R.id.date_imageview);
        mFromEditText = (EditText) view.findViewById(R.id.from_edittext);
        mFromImageView = (ImageView) view.findViewById(R.id.from_imageview);
        mToEditText = (EditText) view.findViewById(R.id.to_edittext);
        mToImageView = (ImageView) view.findViewById(R.id.to_imageview);

        mCompanySpinner = (Spinner) view.findViewById(R.id.company_spinner);

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

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

        mFromImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        String time = selectedHour + ":" + selectedMinute;

                        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
                        Date date = null;
                        try {
                            date = fmt.parse(time );
                        } catch (ParseException e) {

                            e.printStackTrace();
                        }

                        SimpleDateFormat fmtOut = new SimpleDateFormat("hh:mm aa");
                        String formattedTime=fmtOut.format(date);
                        mFromEditText.setText(formattedTime);
                    }
                }, mHour, mMinute, false);//No 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        mToImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        String time = selectedHour + ":" + selectedMinute;

                        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
                        Date date = null;
                        try {
                            date = fmt.parse(time );
                        } catch (ParseException e) {

                            e.printStackTrace();
                        }

                        SimpleDateFormat fmtOut = new SimpleDateFormat("hh:mm aa");
                        String formattedTime=fmtOut.format(date);
                        mToEditText.setText(formattedTime);
                    }
                }, mHour, mMinute, false);//No 24 hour time
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        ArrayList<String> company = new ArrayList<>();
        company.add("Swiggy");
        company.add("Amazon");

        ArrayAdapter<String> companyAdapter = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, company);
        companyAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        mCompanySpinner.setAdapter(companyAdapter);

        return view;
    }

}
