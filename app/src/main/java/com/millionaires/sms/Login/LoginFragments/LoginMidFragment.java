package com.millionaires.sms.Login.LoginFragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.millionaires.sms.Dashboard.DashboardActivity;
import com.millionaires.sms.Login.LoginActivity;
import com.millionaires.sms.Login.LoginAsGuestFragments.LoginAsGuestBottomFragment;
import com.millionaires.sms.Login.LoginAsGuestFragments.LoginAsGuestMidFragment;
import com.millionaires.sms.R;
import com.millionaires.sms.Utils.NetworkUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginMidFragment extends BaseFragment implements View.OnClickListener {

    Context mContext;

    EditText mClientIdEditText;
    EditText mDOBEditText;
    EditText mPasswordEditText;

    TextView mLoginAsGuestTextView;
    Button mLoginButton;

    public static String mClientId;
    public static String mDob;
    public static String mPassword;
    public static String mPin;
    SharedPrefHelper mSharedPrefHelper;
    public ProgressDialog mProgressDialog;

    static LoginMidFragment INSTANCE;

    public LoginMidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_mid, container, false);
        INSTANCE = this;
        mContext = getActivity();
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mProgressDialog = new ProgressDialog(mContext);
        mClientIdEditText = (EditText) view.findViewById(R.id.clientid_edittext);
        //mDOBEditText = (EditText) view.findViewById(R.id.dob_edittext);
        mPasswordEditText = (EditText) view.findViewById(R.id.password_edittext);
        mLoginButton = (Button) view.findViewById(R.id.login_button);
        mLoginAsGuestTextView = (TextView) view.findViewById(R.id.login_as_guest_textview);

        if (!mSharedPrefHelper.getString(Constants.CLIENT_ID, "").equals("") && !mSharedPrefHelper.getString(Constants.DOB, "").equals("")) {
            mClientIdEditText.setText(mSharedPrefHelper.getString(Constants.CLIENT_ID, ""));
           // mDOBEditText.setText(mSharedPrefHelper.getString(Constants.DOB, ""));
            mPasswordEditText.requestFocus();
        }

        mLoginAsGuestTextView.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);

      /*  mDOBEditText.addTextChangedListener(new TextWatcher() {
            int prevL = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prevL = mDOBEditText.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if ((prevL < length) && (length == 2 || length == 5)) {
                    editable.append("/");
                }
            }
        });*/


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                if (!NetworkUtility.getInstance(mContext).isNetworkAvailable()) {
                    CommonFunctions.setToastNoInternet(mContext, "Please check your internet connection.");
                    return;
                }

                /*String clientId = mClientIdEditText.getText().toString();
                String dob = mDOBEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if (clientId.equals("") && dob.equals("") && password.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter all fields");
                    return;
                }

                if (clientId.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter your Client Id");
                    mClientIdEditText.requestFocus();
                    mClientIdEditText.setError("Enter Client Id");
                    return;
                }

                if (dob.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter your Date of Birth");
                    mDOBEditText.requestFocus();
                    mDOBEditText.setError("Enter DOB");
                    return;
                } else if (!Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$").matcher(dob).matches()) {
                    CommonFunctions.setToast(mContext, "DOB must be in dd/mm/yyyy format");
                    mDOBEditText.requestFocus();
                    mDOBEditText.setError("Enter in dd/mm/yyyy format");
                    return;
                }

                if (password.equals("")) {
                    CommonFunctions.setToast(mContext, "Please enter a password");
                    mPasswordEditText.requestFocus();
                    mPasswordEditText.setError("Enter Password");
                    return;
                }

                mSharedPrefHelper.add(Constants.CLIENT_ID, clientId);
                mSharedPrefHelper.add(Constants.DOB, dob);*/

                startActivity(new Intent(mContext, DashboardActivity.class));

                break;
            case R.id.login_as_guest_textview:
                LoginActivity.getINSTANCE().replaceFragments(new String[]{Constants.LOGIN_AS_GUEST_MID_FRAGMENT, Constants.LOGIN_AS_GUEST_BOTTOM_FRAGMENT}, new LoginAsGuestMidFragment(), new LoginAsGuestBottomFragment());
                break;
        }
    }

    public static LoginMidFragment getINSTANCE() {
        return INSTANCE;
    }
}
