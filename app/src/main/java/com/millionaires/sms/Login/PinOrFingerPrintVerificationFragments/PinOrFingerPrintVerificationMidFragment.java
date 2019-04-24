package com.millionaires.sms.Login.PinOrFingerPrintVerificationFragments;


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
public class PinOrFingerPrintVerificationMidFragment extends BaseFragment implements View.OnClickListener {

    Context mContext;
    TextView mUserName;
    EditText mEnterPinEditText;
    Button mLoginButton;

    public static String mClientId;
    public static String mDob;
    public static String mPassword;
    public static String mPin;

    SharedPrefHelper mSharedPrefHelper;

    public PinOrFingerPrintVerificationMidFragment() {
        // Required empty public constructor
    }

    public static PinOrFingerPrintVerificationMidFragment newInstance(String clientId, String dob, String password) {
        
        Bundle args = new Bundle();
        args.putString("clientId", clientId);
        args.putString("dob", dob);
        args.putString("password", password);
        PinOrFingerPrintVerificationMidFragment fragment = new PinOrFingerPrintVerificationMidFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pin_or_finger_print_verification_mid, container, false);

        mContext = getActivity();
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mUserName = (TextView) view.findViewById(R.id.username_textview);
        mEnterPinEditText = (EditText) view.findViewById(R.id.enter_pin_edittext);
        mLoginButton = (Button) view.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);

        mUserName.setText(mSharedPrefHelper.getString(Constants.CLIENT_ID, ""));

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                String pin = mEnterPinEditText.getText().toString();
                if (pin.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter a valid pin");
                    mEnterPinEditText.requestFocus();
                    mEnterPinEditText.setError("Enter Pin");
                    return;
                }

                mClientId = getArguments().getString("clientId");
                mDob = getArguments().getString("dob");
                mPassword = getArguments().getString("password");
                mPin = pin;
                break;
        }
    }

}
