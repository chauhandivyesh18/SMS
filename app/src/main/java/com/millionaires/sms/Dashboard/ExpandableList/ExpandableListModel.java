package com.millionaires.sms.Dashboard.ExpandableList;

public class ExpandableListModel {

    private int icon;

    private String text;

    public ExpandableListModel(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }
}
