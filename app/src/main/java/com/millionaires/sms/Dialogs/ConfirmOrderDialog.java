package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.R;

public class ConfirmOrderDialog extends Dialog {

    Context mContext;
    Dialog mDialog;
    String mOrderConstant;

    ImageView mCloseDialog;
    TextView mCompanyNameTextView;
    TextView mBuySellTextView;
    TextView mQtyTextView;
    TextView mPriceTextView;
    TextView mOrderTypeTextView;
    TextView mValidityTextView;
    TextView mProductTextView;
    TextView mDiscloseQtyTextView;
    TextView mTriggerPriceTextView;
    Button mConfirmButton;

    String SName;
    String stockRate;
    String orderType;
    String stopLossValue;
    String varIOC;
    String productType;
    String varddlBuySell;
    String tradeQty;
    String DisQty;
    String TriggerPrie;
    public ProgressDialog mProgressDialog;

    public ConfirmOrderDialog(@NonNull Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_confirm_order);
        setCancelable(false);

        mCloseDialog = (ImageView) findViewById(R.id.close_imageview);
        mCompanyNameTextView = (TextView) findViewById(R.id.cname_textview);
        mBuySellTextView = (TextView) findViewById(R.id.buy_sell_textview);
        mQtyTextView = (TextView) findViewById(R.id.qty_textview);
        mPriceTextView = (TextView) findViewById(R.id.price_textview);
        mOrderTypeTextView = (TextView) findViewById(R.id.order_type_textview);
        mValidityTextView = (TextView) findViewById(R.id.validity_textview);
        mProductTextView = (TextView) findViewById(R.id.product_textview);
        mDiscloseQtyTextView = (TextView) findViewById(R.id.disclose_textview);
        mTriggerPriceTextView = (TextView) findViewById(R.id.trigger_price_textview);
        mConfirmButton = (Button) findViewById(R.id.confirm_button);
        mProgressDialog = new ProgressDialog(mContext);

        mCloseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmOrderDialog.this.dismiss();
            }
        });

        //set company name
        mCompanyNameTextView.setText(SName);

        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
