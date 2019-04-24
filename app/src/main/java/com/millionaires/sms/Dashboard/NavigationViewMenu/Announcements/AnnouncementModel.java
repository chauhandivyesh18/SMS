package com.millionaires.sms.Dashboard.NavigationViewMenu.Announcements;

public class AnnouncementModel {
    public String title;
    public String type;
    public String description;
    public String datetime;

    public AnnouncementModel(String title, String type, String description, String datetime) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.datetime = datetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
