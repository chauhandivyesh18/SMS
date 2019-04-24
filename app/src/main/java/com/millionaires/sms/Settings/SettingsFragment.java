package com.millionaires.sms.Settings;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.airbnb.paris.Paris;
import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.Common.Constants;
import com.millionaires.sms.Dashboard.DashboardActivity;
import com.millionaires.sms.Common.SharedPrefHelper;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends BaseFragment {


    public SettingsFragment() {
        // Required empty public constructor
    }

    Resources resources;
    Context mContext;

    Spinner mDefaultOrderTypeSpinner, mDefaultPriceSpinner;

    TextView mIndicesTickerYesTextView, mIndicesTickerNoTextView, mMarketCloseOnTextView, mMarketCloseOffTextView, mSensexChangeOnTextView, mSensexChangeOffTextView, mPortfolioValueAlertsOnTextView, mPortfolioValueAlertsOffTextView, mPriceAlertsOnTextView, mPriceAlertsOffTextView, mRMSOnTextView, mRMSOffTextview, mOrderExecutionOnTextView, mOrderExecutionOffTextView, mLaunchAppWithOnTextView, mLaunchAppWithOffTextView;

    Button mDarkBlueThemeButton, mBlackThemeButton, mWhiteThemeButton;

    SharedPrefHelper mSharedPrefHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        resources = getResources();
        mContext = getActivity();
        mSharedPrefHelper = SharedPrefHelper.getInstance(mContext);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mDefaultOrderTypeSpinner = (Spinner) view.findViewById(R.id.default_order_type_spinner);
        mDefaultPriceSpinner = (Spinner) view.findViewById(R.id.default_price_spinner);

        mIndicesTickerYesTextView = (TextView) view.findViewById(R.id.indices_ticker_yes_textview);
        mIndicesTickerNoTextView = (TextView) view.findViewById(R.id.indices_ticker_no_textview);
        mMarketCloseOnTextView = (TextView) view.findViewById(R.id.market_close_open_on_textview);
        mMarketCloseOffTextView = (TextView) view.findViewById(R.id.market_close_open_off_textview);
        mSensexChangeOnTextView = (TextView) view.findViewById(R.id.sensex_change_on_textview);
        mSensexChangeOffTextView = (TextView) view.findViewById(R.id.sensex_change_off_textview);
        mPortfolioValueAlertsOnTextView = (TextView) view.findViewById(R.id.portfolio_value_alerts_on_textview);
        mPortfolioValueAlertsOffTextView = (TextView) view.findViewById(R.id.portfolio_value_alerts_off_textview);
        mPriceAlertsOnTextView = (TextView) view.findViewById(R.id.price_alerts_on_textview);
        mPriceAlertsOffTextView = (TextView) view.findViewById(R.id.price_alerts_off_textview);
        mRMSOnTextView = (TextView) view.findViewById(R.id.rms_on_textview);
        mRMSOffTextview = (TextView) view.findViewById(R.id.rms_off_textview);
        mOrderExecutionOnTextView = (TextView) view.findViewById(R.id.order_execution_on_textview);
        mOrderExecutionOffTextView = (TextView) view.findViewById(R.id.order_execution_off_textview);
        mLaunchAppWithOnTextView = (TextView) view.findViewById(R.id.launch_app_with_on_textview);
        mLaunchAppWithOffTextView = (TextView) view.findViewById(R.id.launch_app_with_off_textview);

        mDarkBlueThemeButton = (Button) view.findViewById(R.id.darkblue_theme_button);
        mBlackThemeButton = (Button) view.findViewById(R.id.black_theme_button);
        mWhiteThemeButton = (Button) view.findViewById(R.id.white_theme_button);

        ArrayAdapter<String> orderType = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, resources.getStringArray(R.array.DefaultOrderType));
        orderType.setDropDownViewResource(R.layout.spinner_dropdown);
        mDefaultOrderTypeSpinner.setAdapter(orderType);

        ArrayAdapter<String> product = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, resources.getStringArray(R.array.DefaultPrice));
        product.setDropDownViewResource(R.layout.spinner_dropdown);
        mDefaultPriceSpinner.setAdapter(product);

        //Switches==================================================================================
        mIndicesTickerYesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mIndicesTickerYesTextView).apply(R.style.SwitchOn);
                Paris.style(mIndicesTickerNoTextView).apply(R.style.SwitchOff);
            }
        });

        mIndicesTickerNoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mIndicesTickerNoTextView).apply(R.style.SwitchOn);
                Paris.style(mIndicesTickerYesTextView).apply(R.style.SwitchOff);
            }
        });

        mMarketCloseOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mMarketCloseOnTextView).apply(R.style.SwitchOn);
                Paris.style(mMarketCloseOffTextView).apply(R.style.SwitchOff);
            }
        });

        mMarketCloseOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mMarketCloseOffTextView).apply(R.style.SwitchOn);
                Paris.style(mMarketCloseOnTextView).apply(R.style.SwitchOff);
            }
        });

        mSensexChangeOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mSensexChangeOnTextView).apply(R.style.SwitchOn);
                Paris.style(mSensexChangeOffTextView).apply(R.style.SwitchOff);
            }
        });

        mSensexChangeOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mSensexChangeOffTextView).apply(R.style.SwitchOn);
                Paris.style(mSensexChangeOnTextView).apply(R.style.SwitchOff);
            }
        });

        mPortfolioValueAlertsOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mPortfolioValueAlertsOnTextView).apply(R.style.SwitchOn);
                Paris.style(mPortfolioValueAlertsOffTextView).apply(R.style.SwitchOff);
            }
        });

        mPortfolioValueAlertsOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mPortfolioValueAlertsOffTextView).apply(R.style.SwitchOn);
                Paris.style(mPortfolioValueAlertsOnTextView).apply(R.style.SwitchOff);
            }
        });

        mPriceAlertsOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mPriceAlertsOnTextView).apply(R.style.SwitchOn);
                Paris.style(mPriceAlertsOffTextView).apply(R.style.SwitchOff);
            }
        });

        mPriceAlertsOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mPriceAlertsOffTextView).apply(R.style.SwitchOn);
                Paris.style(mPriceAlertsOnTextView).apply(R.style.SwitchOff);
            }
        });

        mRMSOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mRMSOnTextView).apply(R.style.SwitchOn);
                Paris.style(mRMSOffTextview).apply(R.style.SwitchOff);
            }
        });

        mRMSOffTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mRMSOffTextview).apply(R.style.SwitchOn);
                Paris.style(mRMSOnTextView).apply(R.style.SwitchOff);
            }
        });

        mOrderExecutionOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mOrderExecutionOnTextView).apply(R.style.SwitchOn);
                Paris.style(mOrderExecutionOffTextView).apply(R.style.SwitchOff);
            }
        });

        mOrderExecutionOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mOrderExecutionOffTextView).apply(R.style.SwitchOn);
                Paris.style(mOrderExecutionOnTextView).apply(R.style.SwitchOff);
            }
        });

        mLaunchAppWithOnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mLaunchAppWithOnTextView).apply(R.style.SwitchOn);
                Paris.style(mLaunchAppWithOffTextView).apply(R.style.SwitchOff);
            }
        });

        mLaunchAppWithOffTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paris.style(mLaunchAppWithOffTextView).apply(R.style.SwitchOn);
                Paris.style(mLaunchAppWithOnTextView).apply(R.style.SwitchOff);
            }
        });
        //==========================================================================================

        //Set Theme
        final String theme = mSharedPrefHelper.getString(Constants.THEME, Constants.WHITE_THEME);
        switch (theme) {
            case Constants.DARKBLUE_THEME:
                changeDarkBlueButtonColor();
                break;
            case Constants.BLACK_THEME:
                changeBlackButtonColor();
                break;
            case Constants.WHITE_THEME:
                changeWhiteButtonColor();
                break;
        }

        //Set DefaultTheme
        mDarkBlueThemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (theme.equals(Constants.DARKBLUE_THEME)) return;
                setNewTheme(R.style.DarkBlueTheme, Constants.DARKBLUE_THEME);
                changeDarkBlueButtonColor();
            }
        });

        //Set BlackTheme
        mBlackThemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (theme.equals(Constants.BLACK_THEME)) return;
                setNewTheme(R.style.BlackTheme, Constants.BLACK_THEME);
                changeBlackButtonColor();
            }
        });

        //Set WhiteTheme
        mWhiteThemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (theme.equals(Constants.WHITE_THEME)) return;
                setNewTheme(R.style.WhiteTheme, Constants.WHITE_THEME);
                changeWhiteButtonColor();
            }
        });

        return view;
    }

    private void setNewTheme(int theme, String themeName) {
        mContext.setTheme(theme);
        mSharedPrefHelper.add(Constants.THEME, themeName);
        /*TaskStackBuilder.create(mContext)
                .addNextIntent(new Intent(mContext, DashboardActivity.class))
                .addNextIntent(getActivity().getIntent())
                .startActivities();*/

        if (getActivity() != null) {
            getActivity().setResult(getActivity().RESULT_OK, null);
            startActivity(new Intent(mContext, DashboardActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            getActivity().finish();
        }
    }

    private void changeDarkBlueButtonColor() {
        mDarkBlueThemeButton.setBackgroundColor(resources.getColor(R.color.settingsThemeButtonSelectedThemeDarkBlue));
        mDarkBlueThemeButton.setTextColor(resources.getColor(R.color.colorWhite));

        mBlackThemeButton.setTextColor(resources.getColor(R.color.colorDark));
        mBlackThemeButton.setBackgroundColor(resources.getColor(R.color.colorLight));
        mWhiteThemeButton.setTextColor(resources.getColor(R.color.colorDark));
        mWhiteThemeButton.setBackgroundColor(resources.getColor(R.color.colorLight));
    }

    private void changeBlackButtonColor() {
        mBlackThemeButton.setBackgroundColor(resources.getColor(R.color.settingsThemeButtonSelectedThemeBlack));
        mBlackThemeButton.setTextColor(resources.getColor(R.color.colorWhite));

        mDarkBlueThemeButton.setTextColor(resources.getColor(R.color.otherBackgroundThemeBlack));
        mDarkBlueThemeButton.setBackgroundColor(resources.getColor(R.color.colorLight));
        mWhiteThemeButton.setTextColor(resources.getColor(R.color.otherBackgroundThemeBlack));
        mWhiteThemeButton.setBackgroundColor(resources.getColor(R.color.colorLight));
    }

    private void changeWhiteButtonColor() {
        mWhiteThemeButton.setBackgroundColor(resources.getColor(R.color.settingsThemeButtonSelectedThemeWhite));
        mWhiteThemeButton.setTextColor(resources.getColor(R.color.colorWhite));

        mDarkBlueThemeButton.setTextColor(resources.getColor(R.color.colorDark));
        mDarkBlueThemeButton.setBackgroundColor(resources.getColor(R.color.listItemLightBackgroundThemeWhite));
        mBlackThemeButton.setTextColor(resources.getColor(R.color.colorDark));
        mBlackThemeButton.setBackgroundColor(resources.getColor(R.color.listItemLightBackgroundThemeWhite));
    }

}
