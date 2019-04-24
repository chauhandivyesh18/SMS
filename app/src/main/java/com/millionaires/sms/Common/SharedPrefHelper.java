package com.millionaires.sms.Common;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Use this class to access the shared prefs all over the app
 * To use the class just initilize the class object and store fetch and edit shared prefs values
 */
public class SharedPrefHelper {

    private Context mContext;
    private static SharedPrefHelper sharedPrefHelper;

    SharedPrefHelper(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Method is used to get single instance of SharedPrefHelper
     *
     * @param mContext
     * @return Instance of SharedPrefHelper
     */
    public static SharedPrefHelper getInstance(Context mContext) {
        if (sharedPrefHelper == null) {
            sharedPrefHelper = new SharedPrefHelper(mContext);
        }
        return sharedPrefHelper;
    }

    /**
     * Method to add new key and value in shared preferences
     *
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE).edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        }
        editor.commit();
    }

    /**
     * Method to get string value stored in shared preferences with specific key
     *
     * @param key
     * @param defValue
     * @return String value associated with key
     */
    public String getString(String key, String defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(key, defValue).equals("null")) {
            return defValue;
        }
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * Method to get Boolean value stored in shared preferences with specific key
     *
     * @param key
     * @return Boolean value associated with key
     */
    public Boolean getBoolean(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * Method to get Integer value stored in shared preferences with specific key
     *
     * @param key
     * @return Integer value associated with key
     */
    public Integer getInt(String key, int defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    public Long getLong(String key, Long defValue) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defValue);
    }

    public void remove(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();
    }


    public boolean hasKey(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

}
