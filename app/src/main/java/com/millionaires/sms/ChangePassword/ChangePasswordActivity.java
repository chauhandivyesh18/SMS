package com.millionaires.sms.ChangePassword;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.ChangePassword.ChangePasswordFragments.ChangePasswordBottomFragment;
import com.millionaires.sms.ChangePassword.ChangePasswordFragments.ChangePasswordMidFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

public class ChangePasswordActivity extends BaseActivity {

    private static final String TAG = ChangePasswordActivity.class.getSimpleName();
    static ChangePasswordActivity INSTANCE;

    ImageView mPureLogoImageView;
    FragmentManager mFragmentManager;
    SharedPrefHelper mSharedPrefHelper;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        INSTANCE = this;
        mContext = ChangePasswordActivity.this;
        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        mFragmentManager = getSupportFragmentManager();
        mPureLogoImageView = (ImageView) findViewById(R.id.pure_logo_imageview);

        String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.WHITE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                mPureLogoImageView.setImageResource(R.drawable.ic_horizontal_logo_white_pure);
                break;
            case Constants.BLACK_THEME:
                mPureLogoImageView.setImageResource(R.drawable.ic_horizontal_logo_white_pure);
                break;
            case Constants.WHITE_THEME:
                mPureLogoImageView.setImageResource(R.drawable.ic_horizontal_logo_blue_pure);
                break;
        }

        ImageView action_back = (ImageView) findViewById(R.id.action_back);
        FrameLayout top_frame = (FrameLayout) findViewById(R.id.top_frame);
        if (getIntent().getStringExtra("FromDashboard").equals("YES")) {
            action_back.setVisibility(View.VISIBLE);
            top_frame.setPadding(0, 0, 0, 0);
        }

        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        replaceFragments(new String[]{Constants.CHANGE_PASSWORD_MID_FRAGMENT, Constants.CHANGE_PASSWORD_BOTTOM_FRAGMENT}, new ChangePasswordMidFragment(), new ChangePasswordBottomFragment());

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

    public static ChangePasswordActivity getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onBackPressed() {
        switch (tags[0]) {
            case Constants.CHANGE_PASSWORD_MID_FRAGMENT:
                NavUtils.navigateUpFromSameTask(ChangePasswordActivity.this);
                break;
            case Constants.SET_PIN_MID_FRAGMENT:
                replaceFragments(new String[]{Constants.CHANGE_PASSWORD_MID_FRAGMENT, Constants.CHANGE_PASSWORD_BOTTOM_FRAGMENT}, new ChangePasswordMidFragment(), new ChangePasswordBottomFragment());
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
