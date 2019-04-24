package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.millionaires.sms.R;


public class OrderDetailsDialog extends Dialog {

    Context mContext;
    LinearLayout mButtonsLayout;
    Button mModifyButton;
    Button mCancelButton;
    public ProgressDialog mProgressDialog;

    public boolean hitTrade = false;
    public boolean hitTradeApi = true;

    TextView mOrderQuantityTextView;
    TextView mTradedQuantityTextView;
    TextView mBrokerOrderIdTextView;
    TextView mCurrentExchangeOrderIdTextView;
    TextView mDateAndTimeTextView;
    TextView mOrderTypeTextView;

    ImageView mCloseImageView;
    
    public OrderDetailsDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_order_details);

        mProgressDialog = new ProgressDialog(mContext);
        mOrderQuantityTextView = (TextView) findViewById(R.id.order_quantity_value);
        mTradedQuantityTextView = (TextView) findViewById(R.id.traded_quantity_value);
        mBrokerOrderIdTextView = (TextView) findViewById(R.id.br_order_id_value);
        mCurrentExchangeOrderIdTextView = (TextView) findViewById(R.id.current_ex_order_id_value);
        mDateAndTimeTextView = (TextView) findViewById(R.id.date_and_time_value);
        mOrderTypeTextView = (TextView) findViewById(R.id.order_type_value);
        mButtonsLayout = (LinearLayout) findViewById(R.id.buttons_layout);
        mModifyButton = (Button) findViewById(R.id.modify_button);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);
    }

}
