package com.millionaires.sms.Handlers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.Logit;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.Splash.SplashActivity;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * This custom class is used to handle exception.
 *
 * @author Vidya
 */
public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = DefaultExceptionHandler.class.getSimpleName();
    private static DefaultExceptionHandler exceptionHandler;
    BaseActivity activity;
    SharedPrefHelper mSharedPrefHelper;

    private DefaultExceptionHandler(BaseActivity activity) {
        this.activity = activity;
        mSharedPrefHelper = SharedPrefHelper.getInstance(activity);
    }

    public static DefaultExceptionHandler getInstance(BaseActivity mActivity) {
        if (exceptionHandler == null) {
            exceptionHandler = new DefaultExceptionHandler(mActivity);
        }
        return exceptionHandler;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);

            String log = "Error log: \n" + ex.getMessage() + "\n" + sw.toString();
            if (mSharedPrefHelper.getString(Constants.CLIENT_ID, "") != null && !mSharedPrefHelper.getString(Constants.CLIENT_ID, "").isEmpty()) {
                log = "User ID is " + mSharedPrefHelper.getString(Constants.CLIENT_ID, "") + "\n" + log;
                // stack trace as a string
            }
            if (Constants.APP_VER != null && !Constants.APP_VER.isEmpty()) {
                log = "App version is " + Constants.APP_VER + "\n" + log;
                // stack trace as a string
            }

            log = "Device Information : " + android.os.Build.DEVICE + ", Device Model : " + android.os.Build.MODEL + "\n" + log;

            SharedPreferences sharedPreferences = activity.getSharedPreferences(Constants.PREFS_NAME, activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Constants.ERROR_LOG_MSG, log);
            editor.commit();

            Intent intent = new Intent(activity, SplashActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_NEW_TASK);

            PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, Intent.FILL_IN_ACTION);

            //Following code will restart your application after 2 seconds
            AlarmManager mgr = (AlarmManager) activity.getApplicationContext().getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 50, pendingIntent);

            //This will finish your activity manually
            activity.finish();

            System.exit(2);// kill off the crashed app
            // sendLog(logMessage);


        } catch (Exception e) {
            Logit.e(TAG, e.getMessage(), e);
        }
    }

    public void sendLog(String logMessage) {
        if (logMessage == null)
            return;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"phone@millicent.in"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "KIFS app exception logs");
        intent.putExtra(Intent.EXTRA_TEXT, "The Exception in " + logMessage);
        activity.startActivity(intent);
    }

}
