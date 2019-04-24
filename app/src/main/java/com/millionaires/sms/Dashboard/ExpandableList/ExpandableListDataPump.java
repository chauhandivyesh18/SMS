package com.millionaires.sms.Dashboard.ExpandableList;

import android.content.Context;
import android.content.res.Resources;

import com.millionaires.sms.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {

    public LinkedHashMap<ExpandableListModel, List<ExpandableListModel>> getData(Context context) {
        LinkedHashMap<ExpandableListModel, List<ExpandableListModel>> expandableListDetail = new LinkedHashMap<>();
        Resources resources = context.getResources();

        List<ExpandableListModel> expendReports = new ArrayList<>();
        expendReports.add(new ExpandableListModel(R.drawable.ic_bell, "Expenditure Reports"));
        expendReports.add(new ExpandableListModel(R.drawable.ic_exchange_msgs, "Defaulters List"));
        expendReports.add(new ExpandableListModel(R.drawable.ic_broker_msgs, "Society Members List"));

        expandableListDetail.put(new ExpandableListModel(R.drawable.ic_bell, "Expenditure Reports"), expendReports);

        return expandableListDetail;
    }

}
