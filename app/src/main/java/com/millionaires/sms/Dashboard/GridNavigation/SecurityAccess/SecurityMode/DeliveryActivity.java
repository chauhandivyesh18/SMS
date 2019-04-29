package com.millionaires.sms.Dashboard.GridNavigation.SecurityAccess.SecurityMode;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.millionaires.sms.Base.BaseActivity;
import com.millionaires.sms.Dialogs.SecurityGuestDialog;
import com.millionaires.sms.R;

import java.util.ArrayList;

public class DeliveryActivity extends BaseActivity {

    ImageView mActionBack;
    static DeliveryActivity INSTANCE;
    Toolbar mToolbar;
    Context mContext;
    Resources resources;
    Spinner mCompanySpinner ;
    EditText orderno_edittext;
    Button btn_getdetails;
    String companyname="",orderid="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        mActionBack = (ImageView) findViewById(R.id.action_back);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=DeliveryActivity.this;
        setSupportActionBar(mToolbar);
        INSTANCE = this;
        resources = getResources();
        mCompanySpinner = (Spinner) findViewById(R.id.company_spinner);
        mActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        orderno_edittext=(EditText) findViewById(R.id.orderno_edittext);
        btn_getdetails=(Button) findViewById(R.id.btn_getdetails);
        ArrayList<String> company = new ArrayList<>();
        company.add("Select Company");
        company.add("Swiggy");
        company.add("Amazon");
        company.add("Flipkart");
        company.add("UberEats");
        company.add("Food Panda");
        company.add("Grab");
        company.add("Zommato");
        company.add("Others");

        ArrayAdapter<String> companyAdapter = new ArrayAdapter<String>(mContext, R.layout.list_item_spinner, company);
        companyAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        mCompanySpinner.setAdapter(companyAdapter);

        btn_getdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companyname=mCompanySpinner.getSelectedItem().toString();
                orderid=orderno_edittext.getText().toString().trim();
                if(companyname.equals("Select Company") && orderid.equals(""))
                {
                    Toast.makeText(mContext,"Please Select company and Enter Orderid",Toast.LENGTH_LONG).show();
                }
                else if(companyname.equals("Select Company"))
                {
                    Toast.makeText(mContext,"Please Select Company ",Toast.LENGTH_LONG).show();
                }
                else if(orderid.equals(""))
                {
                    Toast.makeText(mContext,"Please Enter Orderid",Toast.LENGTH_LONG).show();
                }
                else
                {
                    SecurityGuestDialog confirmDialog = new SecurityGuestDialog(mContext,"0","A201","",companyname,orderid,"29 April 2019 8.00PM");
                    // AnnouncementDialog confirmDialog = new AnnouncementDialog(context, mAnnouncelist.get(position).getTitle(), false,mAnnouncelist.get(position).getDatetime(),mAnnouncelist.get(position).getDescription());
                    confirmDialog.show();
                }
            }
        });

    }
}
