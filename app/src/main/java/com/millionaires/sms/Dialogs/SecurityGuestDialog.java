package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.millionaires.sms.R;


public class SecurityGuestDialog extends Dialog {

    Context mContext;
    Dialog mDialog;
    String FlatNo="",Name="",companyname="",orderid="",datetime="",type="";

    ImageView mCloseDialog;
    TextView mCompanyNameTextView,title_textview;
    TextView mFlatno;
    TextView mName;
    TextView mOrderId;
    TextView mDateTime;
    LinearLayout lnr_Guest,lnr_delivery;
    Button mConfirmButton;
    //SweetAlertDialog sd;
    public SecurityGuestDialog(Context mContext,String Type,String Flatno,String Name,String CompanyName,String orderid,String DateTime) {
        super(mContext);
        this.mContext = mContext;
        this.FlatNo=Flatno;
        this.Name=Name;
        this.companyname=CompanyName;
        this.orderid=orderid;
        this.datetime=DateTime;
        this.type=Type;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_securityguest);
        setCancelable(false);
        title_textview = (TextView) findViewById(R.id.tv_heading);
        mCloseDialog = (ImageView) findViewById(R.id.close_imageview);
        mCompanyNameTextView = (TextView) findViewById(R.id.cmp_name);
        mFlatno = (TextView) findViewById(R.id.tv_flatno);
        mName = (TextView) findViewById(R.id.tv_name);
        mOrderId = (TextView) findViewById(R.id.tv_orderid);
        mDateTime = (TextView) findViewById(R.id.tv_datetime);
        lnr_Guest = (LinearLayout) findViewById(R.id.lnr_Guest);
        lnr_delivery = (LinearLayout) findViewById(R.id.lnr_delivery);
        mConfirmButton = (Button) findViewById(R.id.confirm_button);
        mFlatno.setText(FlatNo);
        if(type.equals("1"))
        {
            lnr_delivery.setVisibility(View.GONE);
            mName.setText("Divyesh Chauhan");
        }
        else if(type.equals("0"))
        {
            lnr_Guest.setVisibility(View.GONE);
            mCompanyNameTextView.setText(companyname);
            mOrderId.setText(orderid);
            mDateTime.setText(datetime);

        }

        mCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecurityGuestDialog.this.dismiss();
            }
        });

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecurityGuestDialog.this.dismiss();
            /*    SecurityGuestDialog.this.dismiss();
                sd=new SweetAlertDialog(mContext,SweetAlertDialog.SUCCESS_TYPE);
                sd.setTitleText("Guest Verified Successfully!!!");
                // sd.setContentText("You clicked the button!");
                sd.setCancelable(false);
                sd.setConfirmButton("OK", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                    }
                });
                sd.show();*/
            }
        });
        //sd.dismiss();
    }

}
