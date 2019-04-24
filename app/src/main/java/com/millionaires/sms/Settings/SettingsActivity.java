package com.millionaires.sms.Settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;
import com.millionaires.sms.Search.SearchFragment;

public class SettingsActivity extends BaseActivity {

    ImageView mActionBack;
    public SearchView mSearchView;

    static SettingsActivity INSTANCE;
    FrameLayout mContainer;
    FragmentManager mFragmentManager;
    SettingsFragment mSettingsFragment;
    SearchFragment mSearchFragment;

    boolean switchFragment;
    LinearLayout MidLayout;
    Toolbar mToolbar;
    SharedPrefHelper mSharedPrefHelper;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        INSTANCE = this;
        mContext = SettingsActivity.this;
        mFragmentManager = getSupportFragmentManager();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBack = (ImageView) findViewById(R.id.action_back);
        mContainer = (FrameLayout) findViewById(R.id.container);

        setSupportActionBar(mToolbar);

        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        //Set logo on the action bar according to the theme
        String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.WHITE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                mActionBack.setImageResource(R.drawable.ic_icon_white_pure);
                break;
            case Constants.BLACK_THEME:
                mActionBack.setImageResource(R.drawable.ic_icon_white_pure);
                break;
            case Constants.WHITE_THEME:
                mActionBack.setImageResource(R.drawable.ic_icon_blue_pure);
                break;
        }

        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mSettingsFragment = new SettingsFragment();
        mSearchFragment = new SearchFragment();

        mFragmentManager.beginTransaction().add(R.id.container, mSettingsFragment).commit();

        MidLayout = (LinearLayout) findViewById(R.id.mid_layout);
        mSearchView = (SearchView) findViewById(R.id.searchview);
        ImageView closeIcon = (ImageView) mSearchView.findViewById(R.id.search_close_btn);
        EditText searchText = (EditText) mSearchView.findViewById(R.id.search_src_text);
        searchText.setTextColor(getColorAttr(R.attr.textColorWhite, this));

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MidLayout.setVisibility(View.GONE);
                mFragmentManager.beginTransaction().replace(R.id.container, mSearchFragment).commit();
                switchFragment = true;
            }
        });

        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                mFragmentManager.beginTransaction().replace(R.id.container, mSettingsFragment).commit();
                switchFragment = false;
                MidLayout.setVisibility(View.VISIBLE);
                return false;
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
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
    }

    @Override
    public void onBackPressed() {
        if (switchFragment) {
            mFragmentManager.beginTransaction().replace(R.id.container, mSettingsFragment).commit();
            switchFragment = false;
            if (!mSearchView.isIconified()) {
                mSearchView.setIconified(true);
                mSearchView.onActionViewCollapsed();
                //toolbar.onActionViewCollapsed();
            }
            MidLayout.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    public static SettingsActivity getINSTANCE() {
        return INSTANCE;
    }

}
