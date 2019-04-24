package com.millionaires.sms.Login.ForgotPasswordFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.ChangePassword.ChangePasswordFragments.ChangePasswordMidFragment;
import com.millionaires.sms.Login.EmptyBottomFragment;
import com.millionaires.sms.Login.LoginActivity;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPasswordMidFragment extends BaseFragment implements View.OnClickListener {

    Button mForgotPasswordButton;

    public ForgotPasswordMidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password_mid, container, false);

        mForgotPasswordButton = (Button) view.findViewById(R.id.forgot_password_button);

        mForgotPasswordButton.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgot_password_button:
                LoginActivity.getINSTANCE().replaceFragments(new String[]{
                        Constants.CHANGE_PASSWORD_MID_FRAGMENT, Constants.EMPTY_BOTTOM_FRAGMENT}, new ChangePasswordMidFragment(), new EmptyBottomFragment());
                break;
        }
    }
}
