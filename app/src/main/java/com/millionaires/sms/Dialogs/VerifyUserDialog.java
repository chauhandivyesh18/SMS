package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

public class VerifyUserDialog extends Dialog {

    Context mContext;
    ImageView mCloseDialog;
    EditText mPasswordEditText;
    EditText mPinEditText;
    Button mCancelButton;
    Button mVerifyButton;
    FrameLayout mPinFrame;
    SharedPrefHelper mSharedPrefHelper;

    public VerifyUserDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_verify_user);
        setCancelable(false);

        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mCloseDialog = (ImageView) findViewById(R.id.close_imageview);
        mPasswordEditText = (EditText) findViewById(R.id.password_edittext);
        mPinEditText = (EditText) findViewById(R.id.pin_edittext);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
        mVerifyButton = (Button) findViewById(R.id.verify_button);
        mPinFrame = (FrameLayout) findViewById(R.id.pin_frame);

    }
}
