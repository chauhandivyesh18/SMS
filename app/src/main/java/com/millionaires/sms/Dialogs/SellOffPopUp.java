package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.millionaires.sms.R;

public class SellOffPopUp extends Dialog {

    RadioButton rb_nse, rb_bse;
    TextView tv_ok;
    RadioGroup toggleNseBse;
    public Boolean checked = false;
    Context mContext;
    ImageView mCloseImageView;
    HoldingsDetailsDialog mHoldingsDetailsDialog;

    public SellOffPopUp(@NonNull Context context, HoldingsDetailsDialog holdingsDetailsDialog) {
        super(context);
        mContext = context;
        mHoldingsDetailsDialog = holdingsDetailsDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_sell_off);
        setCancelable(true);

        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);
        rb_bse = (RadioButton) findViewById(R.id.rb_bse);
        rb_nse = (RadioButton) findViewById(R.id.rb_nse);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        toggleNseBse = (RadioGroup) findViewById(R.id.togglebsense);
        checked = false;
        rb_nse.setChecked(true);

    }
}
