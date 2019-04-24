
package com.millionaires.sms.Common;

import android.content.Context;
import android.util.Log;

/**
 * Class to print logs
 * Created by vidya on 30/5/16.
 */
public class Logit {

    private static Logit logit;
    private Context mContext;
    public static boolean showLogs = true;

    private Logit(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Initialize single instance of Logit
     *
     * @param context
     * @return Singleton for Logit class
     */
    public static Logit getInstance(Context context) {
        if (logit == null) {
            logit = new Logit(context);
        }
        return logit;
    }

    /**
     * Method to set whether to show logs or not
     *
     * @param mshowLogs
     */
    public void init(boolean mshowLogs) {
        Logit.showLogs = mshowLogs;
    }

    /**
     * Method to print error logs
     *
     * @param tag
     * @param e
     */
    public static void e(String tag, Exception e) {
        if (showLogs) {
            Log.e(tag, e.getMessage(), e);
        }
    }

    /**
     * Method to print error logs with user defined msg
     *
     * @param tag
     * @param e
     * @param msg
     */
    public static void e(String tag, String msg, Exception e) {
        if (showLogs) {
            Log.e(tag, e.getMessage(), e);
        }
    }

    /**
     * Method to print error logs with user defined msg
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (showLogs) {
            Log.e(tag, msg + "");
        }
    }

    /**
     * Method to print debug logs
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (showLogs) {
            Log.d(tag, msg);
        }
    }

    /**
     * Method to print warning logs
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        if (showLogs) {
            Log.w(tag, msg);
        }
    }

    /**
     * Method to print verbose logs
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (showLogs) {
            Log.v(tag, msg);
        }
    }

    /**
     * Method to print information logs
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (showLogs) {
            Log.i(tag, msg);
        }
    }

   /* public static void main(String args[]) {
        if (args[0].equals("true")) {

        }
    }*/
}
