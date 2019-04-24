package com.millionaires.sms.Login.LoginFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Login.EmptyBottomFragment;
import com.millionaires.sms.Login.ForgotPasswordFragments.ForgotPasswordBottomFragment;
import com.millionaires.sms.Login.ForgotPasswordFragments.ForgotPasswordMidFragment;
import com.millionaires.sms.Login.LoginActivity;
import com.millionaires.sms.ChangePassword.SetPinFragments.SetPinMidFragment;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginBottomFragment extends BaseFragment implements View.OnClickListener {

    TextView mOpenAccountNowTextView;
    TextView mForgotPasswordTextView;

    public LoginBottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_bottom, container, false);

        mOpenAccountNowTextView = (TextView) view.findViewById(R.id.open_account_now_textview);
        mForgotPasswordTextView = (TextView) view.findViewById(R.id.forgot_password_textview);

        mOpenAccountNowTextView.setOnClickListener(this);
        mForgotPasswordTextView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_account_now_textview:
                LoginActivity.getINSTANCE().replaceFragments(new String[]{
                        Constants.SET_PIN_MID_FRAGMENT, Constants.EMPTY_BOTTOM_FRAGMENT}, new SetPinMidFragment(), new EmptyBottomFragment());
                break;
            case R.id.forgot_password_textview:
                LoginActivity.getINSTANCE().replaceFragments(new String[]{Constants.FORGOT_PASSWORD_MID_FRAGMENT, Constants.FORGOT_PASSWORD_BOTTOM_FRAGMENT}, new ForgotPasswordMidFragment(), new ForgotPasswordBottomFragment());
                break;
        }
    }
}
