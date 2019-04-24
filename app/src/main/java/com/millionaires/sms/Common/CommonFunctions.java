package com.millionaires.sms.Common;

import android.content.Context;
import android.widget.Toast;

public class CommonFunctions {

    static Toast mToast;
    static Toast mNoInternetConnectionToast;
    static Toast mDisconnectionToast;

    //end the current one
    public static void setToast(Context context, String messasge) {
        if (mToast != null) mToast.cancel();
        mToast =  Toast.makeText(context, messasge, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void setToastLong(Context context, String messasge) {
        if (mToast != null) mToast.cancel();
        mToast =  Toast.makeText(context, messasge, Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void setShortToast(Context context, String messasge) {
        Toast.makeText(context, messasge, Toast.LENGTH_SHORT).show();
    }

    public static void setLongToast(Context context, String messasge) {
        Toast.makeText(context, messasge, Toast.LENGTH_LONG).show();
    }

    public static void setToastNoInternet(Context context, String messasge) {
        if (mNoInternetConnectionToast != null) mNoInternetConnectionToast.cancel();
        mNoInternetConnectionToast =  Toast.makeText(context, messasge, Toast.LENGTH_SHORT);
        mNoInternetConnectionToast.show();
    }
}
