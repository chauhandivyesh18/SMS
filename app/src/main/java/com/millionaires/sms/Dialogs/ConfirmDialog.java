package com.millionaires.sms.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.Login.LoginActivity;
import com.millionaires.sms.R;

public class ConfirmDialog extends Dialog {

    Context mContext;
    Button mOkButton;
    Button mCancelButton;
    TextView mTitleTextView;
    TextView mMsgTextView;
    ImageView mCloseImageView;
    String msg;
    SharedPrefHelper mSharedPrefHelper;
    boolean isCancelable;

    public ConfirmDialog(@NonNull Context context, String msg, boolean isCancelable) {
        super(context);
        mContext = context;
        this.msg = msg;
        this.isCancelable = isCancelable;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_confirm);
        setCancelable(false);

        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mOkButton = (Button) findViewById(R.id.ok_button);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
        mTitleTextView = (TextView) findViewById(R.id.title_textview);
        mMsgTextView = (TextView) findViewById(R.id.msg_textview);
        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);

        mCloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmDialog.this.dismiss();
            }
        });

        mTitleTextView.setText(mContext.getResources().getString(R.string.app_name));
        mMsgTextView.setText(msg);

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSharedPrefHelper.add(Constants.PASSWORD, "");
                mSharedPrefHelper.add(Constants.PIN, "");
                mSharedPrefHelper.add(Constants.IS_LOGGED_IN, false);
                mContext.startActivity(new Intent(mContext, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                ((Activity) mContext).finish();
            }
        });

        if (!isCancelable) mCancelButton.setVisibility(View.GONE);

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmDialog.this.dismiss();
            }
        });
    }
}
