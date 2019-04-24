package com.millionaires.sms.Dashboard.ExpandableList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.millionaires.sms.R;

import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ExpandableListModel> expandableListTitle;
    private LinkedHashMap<ExpandableListModel, List<ExpandableListModel>> expandableListDetail;

    public ExpandableListAdapter(Context context, List<ExpandableListModel> expandableListTitle,
                                 LinkedHashMap<ExpandableListModel, List<ExpandableListModel>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final ExpandableListModel mExpandableListModel = (ExpandableListModel) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        ImageView expandedListIcon = (ImageView) convertView
                .findViewById(R.id.expandedListItemIcon);
        //listTitleTextView.setTypeface(null, Typeface.BOLD);
        expandedListIcon.setImageResource(mExpandableListModel.getIcon());

        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(mExpandableListModel.getText());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ExpandableListModel mExpandableListModel = (ExpandableListModel) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        ImageView listTitleIcon = (ImageView) convertView
                .findViewById(R.id.listTitleIcon);
        //listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleIcon.setImageResource(mExpandableListModel.getIcon());

        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        //listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(mExpandableListModel.getText());

        ImageView expandIcon = (ImageView) convertView.findViewById(R.id.expandIcon);
        if (isExpanded) {
            expandIcon.setImageResource(R.drawable.ic_up);
        } else {
            expandIcon.setImageResource(R.drawable.ic_down);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}