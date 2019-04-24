package com.millionaires.sms.ChangePassword.ChangePasswordFragments;


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
import com.millionaires.sms.Utils.NetworkUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePasswordMidFragment extends BaseFragment implements View.OnClickListener {

    Context mContext;
    TextView mUserName;
    EditText mCurrentPasswordEditText;
    EditText mNewPasswordEditText;
    EditText mConfirmPasswordEditText;
    Button mSetNewPassword;

    SharedPrefHelper mSharedPrefHelper;
    public ProgressDialog mProgressDialog;

    public ChangePasswordMidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_password_mid, container, false);

        mContext = getActivity();
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mProgressDialog = new ProgressDialog(mContext);
        mUserName = (TextView) view.findViewById(R.id.username_textview);
        mCurrentPasswordEditText = (EditText) view.findViewById(R.id.current_password_edittext);
        mNewPasswordEditText = (EditText) view.findViewById(R.id.new_password_edittext);
        mConfirmPasswordEditText = (EditText) view.findViewById(R.id.confirm_new_password_edittext);
        mSetNewPassword = (Button) view.findViewById(R.id.set_new_password_button);

        mUserName.setText(mSharedPrefHelper.getString(Constants.CLIENT_ID, ""));
        mSetNewPassword.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_new_password_button:
                if (!NetworkUtility.getInstance(mContext).isNetworkAvailable()) {
                    CommonFunctions.setToastNoInternet(mContext, "Please check your internet connection.");
                    return;
                }
                String current_password = mCurrentPasswordEditText.getText().toString();
                String new_password = mNewPasswordEditText.getText().toString();
                String confirm_new_password = mConfirmPasswordEditText.getText().toString();

                if (current_password.equals("") && new_password.equals("") && confirm_new_password.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter all fields");
                    return;
                }

                if (current_password.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter your current password");
                    mCurrentPasswordEditText.requestFocus();
                    mCurrentPasswordEditText.setError("Enter current password");
                    return;
                } else if (!current_password.equals(mSharedPrefHelper.getString(Constants.PASSWORD, ""))) {
                    CommonFunctions.setToast(mContext, "Current password do not match");
                    mCurrentPasswordEditText.requestFocus();
                    mCurrentPasswordEditText.setError("Currrent password do not match");
                    return;
                }

                if (new_password.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter a new password");
                    mNewPasswordEditText.requestFocus();
                    mNewPasswordEditText.setError("Enter new password");
                    return;
                } else if (new_password.equals(current_password)) {
                    CommonFunctions.setToast(mContext, "New password and current password cannot be the same");
                    mNewPasswordEditText.requestFocus();
                    mNewPasswordEditText.setError("Enter new password");
                    return;
                }

                if (confirm_new_password.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter new password to confirm");
                    mConfirmPasswordEditText.requestFocus();
                    mConfirmPasswordEditText.setError("Enter new password again");
                    return;
                } else if (!confirm_new_password.equals(new_password)) {
                    CommonFunctions.setToast(mContext, "New passwords do not match");
                    mConfirmPasswordEditText.requestFocus();
                    mConfirmPasswordEditText.setError("New passwords do not match");
                    return;
                }

                break;
        }
    }

}
