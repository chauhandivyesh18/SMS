package com.millionaires.sms.Dashboard.GridNavigation.SecurityAccess.UserMode;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.millionaires.sms.Base.BaseFragment;
import com.millionaires.sms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InviteGuestFragment extends BaseFragment {

    Context mContext;
    LinearLayout mcontact_linearlayout;
    LinearLayout mcontact_detail_linearlayout;
    TextView mDisplay_guestname_textview;
    TextView mDisplay_guestnumber_textview;
    private final int REQUEST_CODE=99;
    public static String num = "";
    public static  String name = "";

    public InviteGuestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invite_guest, container, false);

        mContext = getActivity();
        mcontact_linearlayout = (LinearLayout) view.findViewById(R.id.contact_linearlayout);
        mcontact_detail_linearlayout = (LinearLayout) view.findViewById(R.id.contact_detail_linearlayout);
        mDisplay_guestname_textview =(TextView) view.findViewById(R.id.display_guestname);
        mDisplay_guestnumber_textview =(TextView) view.findViewById(R.id.display_guestnumber);
        mcontact_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show a toast message.
                showContacts();
            }
        });

        return view;
    }

    private void showContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && mContext.checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
//            List<String> contacts = getContactNames();
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
//            lstNames.setAdapter(adapter);
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                showContacts();
            } else {
                Toast.makeText(mContext, "Until you grant the permission, we cannot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(reqCode, resultCode, data);
            switch (reqCode) {
                case (REQUEST_CODE):
                    if (resultCode == Activity.RESULT_OK) {
                        Uri contactData = data.getData();
                        Cursor c = mContext.getContentResolver().query(contactData, null, null, null, null);
                        if (c.moveToFirst()) {
                            String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                            String hasNumber = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                            num = "";
                            name = "";
                            if (Integer.valueOf(hasNumber) == 1) {
                                Cursor numbers = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                                while (numbers.moveToNext()) {
                                    num = numbers.getString(numbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                    name=numbers.getString(numbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                                    mDisplay_guestname_textview.setText("Guest Name : " +name);
                                    mDisplay_guestnumber_textview.setText("Guest Phone Number : "+num);
                                    // mcontact_detail_linearlayout.setVisibility(View.VISIBLE);
                                    Toast.makeText(mContext, "Number="+num +" "+ name, Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        break;
                    }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
