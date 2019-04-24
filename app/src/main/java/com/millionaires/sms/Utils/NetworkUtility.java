package com.millionaires.sms.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Vidya on 12/4/16.
 */
public class NetworkUtility {
    private static NetworkUtility mInstance;
    private static Context mContext;

    public static synchronized NetworkUtility getInstance(Context context) {
        mContext = context;
        if (mInstance == null) {
            mInstance = new NetworkUtility();
        }
        return mInstance;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
