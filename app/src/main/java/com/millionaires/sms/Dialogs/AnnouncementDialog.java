package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

public class AnnouncementDialog extends Dialog {
    Context mContext;
    TextView mTitleTextView;
    TextView mMsgTextView;
    ImageView mCloseImageView;
    String Caption,date,heading;
    SharedPrefHelper mSharedPrefHelper;
    boolean isCancelable;

    public AnnouncementDialog(@NonNull Context context, String msg, boolean isCancelable, String DateTime, String Caption) {
        super(context);
        mContext = context;
        this.Caption = Caption;
        this.date = DateTime;
        this.heading=msg;
        this.isCancelable = isCancelable;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_details);
        setCancelable(isCancelable);

        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mTitleTextView = (TextView) findViewById(R.id.title_textview);
        mMsgTextView = (TextView) findViewById(R.id.msg_textview);
        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);

        mCloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnnouncementDialog.this.dismiss();
            }
        });
        mTitleTextView.setText(heading);
        mMsgTextView.setText(Caption.equals("")|| Caption==null ? "No data available!":Caption);

    }
}
