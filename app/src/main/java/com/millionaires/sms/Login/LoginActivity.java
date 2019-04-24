package com.millionaires.sms.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.Login.ForgotPasswordFragments.ForgotPasswordBottomFragment;
import com.millionaires.sms.Login.ForgotPasswordFragments.ForgotPasswordMidFragment;
import com.millionaires.sms.Login.LoginFragments.LoginBottomFragment;
import com.millionaires.sms.Login.LoginFragments.LoginMidFragment;
import com.millionaires.sms.R;

public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    static LoginActivity INSTANCE;

    FragmentManager mFragmentManager;

    SharedPrefHelper mSharedPrefHelper;
    ImageView mPureLogoImageView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        INSTANCE = this;
        mContext = LoginActivity.this;

        mPureLogoImageView = (ImageView) findViewById(R.id.pure_logo_imageview);
        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.DARKBLUE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                mPureLogoImageView.setImageResource(R.drawable.loggo);
                break;
            case Constants.BLACK_THEME:
                mPureLogoImageView.setImageResource(R.drawable.loggo);
                break;
            case Constants.WHITE_THEME:
                mPureLogoImageView.setImageResource(R.drawable.loggo);
                break;
        }

        mFragmentManager = getSupportFragmentManager();
        replaceFragments(new String[]{Constants.LOGIN_MID_FRAGMENT, Constants.LOGIN_BOTTOM_FRAGMENT}, new LoginMidFragment(), new LoginBottomFragment());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    String[] tags;
    Fragment[] fragments;

    public void replaceFragments(String[] tags, Fragment... fragments) {
        this.tags = tags;
        this.fragments = fragments;
        if (fragments[0] != null) {
            mFragmentManager.beginTransaction().replace(R.id.mid_frame, fragments[0], tags[0]).addToBackStack(null).commit();
        } else {

        }
        if (fragments[1] != null) {
            mFragmentManager.beginTransaction().replace(R.id.bottom_frame, fragments[1], tags[1]).addToBackStack(null).commit();
        } else {

        }
    }

    public void navigateTo(Class className) {
        startActivity(new Intent(mContext, className));
        finish();
    }

    public static LoginActivity getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onBackPressed() {
        switch (tags[0]) {
            case Constants.LOGIN_AS_GUEST_MID_FRAGMENT:
                replaceFragments(new String[]{Constants.LOGIN_MID_FRAGMENT, Constants.LOGIN_BOTTOM_FRAGMENT}, new LoginMidFragment(), new LoginBottomFragment());
                break;
            case Constants.FORGOT_PASSWORD_MID_FRAGMENT:
                replaceFragments(new String[]{Constants.LOGIN_MID_FRAGMENT, Constants.LOGIN_BOTTOM_FRAGMENT}, new LoginMidFragment(), new LoginBottomFragment());
                break;
            case Constants.CHANGE_PASSWORD_MID_FRAGMENT:
                replaceFragments(new String[]{Constants.FORGOT_PASSWORD_MID_FRAGMENT, Constants.FORGOT_PASSWORD_BOTTOM_FRAGMENT}, new ForgotPasswordMidFragment(), new ForgotPasswordBottomFragment());
                break;
            case Constants.PIN_OR_FINGERPRINT_VERIFICATION_MID_FRAGMENT:
                replaceFragments(new String[]{Constants.LOGIN_MID_FRAGMENT, Constants.LOGIN_BOTTOM_FRAGMENT}, new LoginMidFragment(), new LoginBottomFragment());
                break;
            case Constants.SET_PIN_MID_FRAGMENT:
                replaceFragments(new String[]{Constants.LOGIN_MID_FRAGMENT, Constants.LOGIN_BOTTOM_FRAGMENT}, new LoginMidFragment(), new LoginBottomFragment());
                break;
            case Constants.LOGIN_MID_FRAGMENT:
                finish();
                break;
        }
    }

    /*public static void hideKeyboard(Activity activity) {
        try {
            View view = activity.getCurrentFocus();

            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof AppCompatEditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }*/
}
