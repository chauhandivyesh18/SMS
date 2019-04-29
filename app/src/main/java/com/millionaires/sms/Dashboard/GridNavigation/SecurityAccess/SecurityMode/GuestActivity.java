package com.millionaires.sms.Dashboard.GridNavigation.SecurityAccess.SecurityMode;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Dialogs.SecurityGuestDialog;
import com.millionaires.sms.R;

public class GuestActivity extends BaseActivity {

    Pinview pinview;
    ImageView mActionBack;
    static GuestActivity INSTANCE;
    Toolbar mToolbar;
    Context mContext;
    Resources resources;
    String otp="",flatno="";
    Button btn_getdetails;
    EditText editText_flatno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        mActionBack = (ImageView) findViewById(R.id.action_back);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=GuestActivity.this;
        setSupportActionBar(mToolbar);
        INSTANCE = this;
        resources = getResources();
        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        pinview=(Pinview) findViewById(R.id.otp);
        btn_getdetails=(Button) findViewById(R.id.btn_getdetails);
        editText_flatno=(EditText) findViewById(R.id.flatno_edittext);

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                otp=pinview.getValue().toString();
            }
        });
        btn_getdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flatno=editText_flatno.getText().toString().trim();
                if(flatno.equals("") && otp.equals(""))
                {
                    Toast.makeText(GuestActivity.this,"Please Enter Flatno and OTP",Toast.LENGTH_LONG).show();
                }
                else if(flatno.equals(""))
                {
                    Toast.makeText(GuestActivity.this,"Please Enter Flatno ",Toast.LENGTH_LONG).show();
                }
                else if(otp.equals(""))
                {
                    Toast.makeText(GuestActivity.this,"Please Enter OTP",Toast.LENGTH_LONG).show();
                }
                else
                {
                    SecurityGuestDialog confirmDialog = new SecurityGuestDialog(mContext,"1",flatno,"","","","");
                    // AnnouncementDialog confirmDialog = new AnnouncementDialog(context, mAnnouncelist.get(position).getTitle(), false,mAnnouncelist.get(position).getDatetime(),mAnnouncelist.get(position).getDescription());
                    confirmDialog.show();
                }
            }
        });
    }
}
