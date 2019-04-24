package com.millionaires.sms.ChangePassword.SetPinFragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.CommonFunctions;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetPinMidFragment extends BaseFragment implements View.OnClickListener {

    Context mContext;
    TextView mUserName;
    EditText mPinEditText;
    EditText mVerifyPinEditText;
    Button mSetPinButton;

    SharedPrefHelper mSharedPrefHelper;
    public ProgressDialog mProgressDialog;

    public SetPinMidFragment() {
        // Required empty public constructor
    }

    public static SetPinMidFragment newInstance(String old_password, String new_password) {
        
        Bundle args = new Bundle();
        args.putString("OLD_PASSWORD", old_password);
        args.putString("NEW_PASSWORD", new_password);
        SetPinMidFragment fragment = new SetPinMidFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_pin_mid, container, false);

        mContext = getActivity();
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mProgressDialog = new ProgressDialog(mContext);
        mUserName = (TextView) view.findViewById(R.id.username_textview);
        mPinEditText = view.findViewById(R.id.pin_edittext);
        mVerifyPinEditText = view.findViewById(R.id.verify_pin_edittext);
        mSetPinButton = view.findViewById(R.id.set_pin_button);

        mUserName.setText(mSharedPrefHelper.getString(Constants.CLIENT_ID, ""));
        mSetPinButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_pin_button:
                String pin = mPinEditText.getText().toString();
                String verifyPin = mVerifyPinEditText.getText().toString();
                if (pin.equals("") && verifyPin.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter all fields");
                    return;
                }

                if (pin.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter a pin");
                    mPinEditText.requestFocus();
                    mPinEditText.setError("Enter Pin");
                    return;
                }

                if (verifyPin.equals("")) {
                    CommonFunctions.setToast(mContext, "Please verify your pin");
                    mVerifyPinEditText.requestFocus();
                    mVerifyPinEditText.setError("Verify Pin");
                    return;
                } else if (!verifyPin.equals(pin)) {
                    CommonFunctions.setToast(mContext, "Entered pins does not match");
                    mVerifyPinEditText.requestFocus();
                    return;
                }

                mProgressDialog.setMessage("Please wait while your password is being changed.");
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
                break;
        }
    }
}
