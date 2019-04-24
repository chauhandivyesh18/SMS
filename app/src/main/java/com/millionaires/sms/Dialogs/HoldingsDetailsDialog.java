package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.millionaires.sms.R;

public class HoldingsDetailsDialog extends Dialog {

    Context mContext;
    TextView mTotalQtyTextView;
    TextView mTradeQtyTextView;
    TextView mQtyToSellTextView;
    TextView mQtyToSellValueTextView;
    TextView mBookedPLLabelTextView;
    TextView mBookedPLTextView;
    TextView mMTMPLLabelTextView;
    TextView mMTMPLTextView;
    TextView mCurrentRateTextView;;
    Button mSellOffButton;

    LinearLayout mBPLLinearLayout;
    LinearLayout mMTMLinearLayout;

    ImageView mCloseImageView;
    
    public HoldingsDetailsDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_holdings_details);

        mTotalQtyTextView = (TextView) findViewById(R.id.total_qty_value);
        mTradeQtyTextView = (TextView) findViewById(R.id.trade_qty_value);
        mQtyToSellTextView = (TextView) findViewById(R.id.qty_to_sell_textview);
        mQtyToSellValueTextView = (TextView) findViewById(R.id.qty_to_sell_value);
        mBookedPLLabelTextView = (TextView) findViewById(R.id.booked_pl_textview);
        mBookedPLTextView = (TextView) findViewById(R.id.booked_pl_value);
        mMTMPLLabelTextView = (TextView) findViewById(R.id.mtm_pl_textview);
        mMTMPLTextView = (TextView) findViewById(R.id.mtm_pl_value);
        mCurrentRateTextView = (TextView) findViewById(R.id.current_rate_value);
        mSellOffButton = (Button) findViewById(R.id.sell_off_button);
        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);
        mBPLLinearLayout = (LinearLayout) findViewById(R.id.bpl_ll);
        mMTMLinearLayout = (LinearLayout) findViewById(R.id.mtm_ll);


    }

}
