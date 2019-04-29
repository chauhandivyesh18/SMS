package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

public class ComplaintsDialog extends Dialog {
    Context mContext;
    TextView mTitleTextView,mDescription,mStatus,tv_complaintno;
    ImageView mCloseImageView,Image1;
    String Title,description,Status;
    Button btn_resolved,btn_observation,btn_closed,btn_ResolvedComplaints;
    SharedPrefHelper mSharedPrefHelper;
    boolean isCancelable;


    public ComplaintsDialog(Context context, String title, boolean isCancelable, String DateTime, String desc,String status) {
        super(context);
        mContext = context;
        this.Title = title;
        this.description = desc;
        this.Status=status;
        this.isCancelable = isCancelable;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.complaintdialog);
        setCancelable(isCancelable);
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mDescription = (TextView) findViewById(R.id.decriptions);
        tv_complaintno= (TextView) findViewById(R.id.tv_complaintno);
        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);
        mStatus=(TextView) findViewById(R.id.tv_status);
        mCloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComplaintsDialog.this.dismiss();
            }
        });
        tv_complaintno.setText("002091");
        mTitleTextView.setText(Title);
        mStatus.setText(Status);
        //mDescription.setText(description.equals("")|| description==null ? "No data available!":description);
        mDescription.setText(description);
    }
}
