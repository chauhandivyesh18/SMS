package com.millionaires.sms.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.R;


public class OpenAndClosePositionsDetailsDialog extends Dialog {

    Context mContext;
    TextView mSoldTextView;
    TextView mBoughtTextView;
    TextView mNetQuantityTextView;
    TextView mBookedPLTextView;
    TextView mMTMPLTextView;
    TextView mCurrentRateTextView;
    TextView mExerciseTextView;
    TextView mDExerciseTextView;
    Button mSquareOffButton;

    ImageView mCloseImageView;
    
    public OpenAndClosePositionsDetailsDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_positions_details);

        mBoughtTextView = (TextView) findViewById(R.id.bought_value);
        mSoldTextView = (TextView) findViewById(R.id.sold_value);
        mNetQuantityTextView = (TextView) findViewById(R.id.net_quantity_value);
        mBookedPLTextView = (TextView) findViewById(R.id.booked_pl_value);
        mMTMPLTextView = (TextView) findViewById(R.id.mtm_pl_value);
        mCurrentRateTextView = (TextView) findViewById(R.id.current_rate_value);
        mExerciseTextView = (TextView) findViewById(R.id.exercise_value);
        mDExerciseTextView = (TextView) findViewById(R.id.dexercise_quantity_value);
        mSquareOffButton = (Button) findViewById(R.id.square_off_button);

        mCloseImageView = (ImageView) findViewById(R.id.close_imageview);

    }
}
