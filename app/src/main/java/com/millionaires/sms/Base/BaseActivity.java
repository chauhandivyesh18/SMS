package com.millionaires.sms.Base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

/**
 * Created by macbookpro on 10/07/18.
 */

public class BaseActivity extends AppCompatActivity {

    SharedPrefHelper mSharedPrefHelper;
    static BaseActivity INSTANCE;
    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        INSTANCE = this;
        mContext = BaseActivity.this;
        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        //Set Themes
        String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.WHITE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                setTheme(R.style.DarkBlueTheme);
                break;
            case Constants.BLACK_THEME:
                setTheme(R.style.BlackTheme);
                break;
            case Constants.WHITE_THEME:
                setTheme(R.style.WhiteTheme);
                break;
        }

        /*Thread.setDefaultUncaughtExceptionHandler(DefaultExceptionHandler.getInstance(this));
        //Error - Exception Mail Handling - @kru - 31stAug2018
        String logMsg = mSharedPrefHelper.getString(UserConstants.ERROR_LOG_MSG, "");
        Logit.v("TAG", "EXCE " + logMsg);
        if (logMsg != null && !logMsg.isEmpty()) {
            Log.e(UserConstants.ERROR_LOG_MSG, logMsg);
            new EmailHandler().sendMail("phone@millicent.in", "PureTradeON Error Logs", logMsg);
            mSharedPrefHelper.add(UserConstants.ERROR_LOG_MSG, "");
        }*/


    }

    //Get Color according to the attr
    public int getColorAttr(int attr, Context context) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(attr, typedValue, true);
        @ColorInt int color = typedValue.data;
        return color;
    }

    public static BaseActivity getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
