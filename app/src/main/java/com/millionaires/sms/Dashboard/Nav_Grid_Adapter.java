package com.millionaires.sms.Dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.R;

import java.util.ArrayList;

public class Nav_Grid_Adapter extends BaseAdapter {

    private Context mContext;
   public ArrayList<Nav_GridModel> mList;

    public Nav_Grid_Adapter(Context mContext, ArrayList<Nav_GridModel> arrayList) {
        this.mContext = mContext;
        this.mList = arrayList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.item_grid_nav, null);
            TextView textViewAndroid = (TextView) gridViewAndroid.findViewById(R.id.gridview_text);
            ImageView imageViewAndroid = (ImageView) gridViewAndroid.findViewById(R.id.gridview_img);
            textViewAndroid.setText(mList.get(i).getNav_Name());
            imageViewAndroid.setImageResource(mList.get(i).getNav_Image());
        } else {
            gridViewAndroid = (View) convertView;
        }

        return gridViewAndroid;
    }
}
