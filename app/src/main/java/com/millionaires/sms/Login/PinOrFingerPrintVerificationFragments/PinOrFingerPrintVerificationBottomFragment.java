package com.millionaires.sms.Login.PinOrFingerPrintVerificationFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Login.LoginActivity;
import com.millionaires.sms.Login.LoginFragments.LoginBottomFragment;
import com.millionaires.sms.Login.LoginFragments.LoginMidFragment;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PinOrFingerPrintVerificationBottomFragment extends BaseFragment implements View.OnClickListener {

    TextView mClickHereTextView;


    public PinOrFingerPrintVerificationBottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pin_or_finger_print_verification_bottom, container, false);

        mClickHereTextView = (TextView) view.findViewById(R.id.click_here_textview);

        mClickHereTextView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_here_textview:
                LoginActivity.getINSTANCE().replaceFragments(new String[]{Constants.LOGIN_MID_FRAGMENT, Constants.LOGIN_BOTTOM_FRAGMENT}, new LoginMidFragment(), new LoginBottomFragment());
                break;
        }
    }
}
