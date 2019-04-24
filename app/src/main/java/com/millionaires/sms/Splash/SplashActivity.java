package com.millionaires.sms.Splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.Login.LoginActivity;
import com.millionaires.sms.R;

public class SplashActivity extends BaseActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    SharedPrefHelper mSharedPrefHelper;
    ImageView mPureLogoImageView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mContext = SplashActivity.this;

        mPureLogoImageView = (ImageView) findViewById(R.id.pure_logo_imageview);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        mPureLogoImageView.clearAnimation();
        mPureLogoImageView.startAnimation(anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 2000);

        mSharedPrefHelper = SharedPrefHelper.getInstance(this);
        //Set logo according to the theme
        String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.WHITE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                mPureLogoImageView.setImageResource(R.drawable.ic_splash_logo_white_pure);
                break;
            case Constants.BLACK_THEME:
                mPureLogoImageView.setImageResource(R.drawable.ic_splash_logo_white_pure);
                break;
            case Constants.WHITE_THEME:
                mPureLogoImageView.setImageResource(R.drawable.loggo);
                break;
        }

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, LoginActivity.class));
            }
        }, 2000);*/

    }

}
