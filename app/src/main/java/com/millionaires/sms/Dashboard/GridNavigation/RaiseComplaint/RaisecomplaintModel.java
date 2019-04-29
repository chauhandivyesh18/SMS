package com.millionaires.sms.Dashboard.GridNavigation.RaiseComplaint;

public class RaisecomplaintModel {
    public String id;
    public String Flatno;
    public String Title;
    public String Description;
    public String Images_path;
    public String Status;
    public String datetime;


    public RaisecomplaintModel(String id, String flatno, String title, String desc,String path,String status,String datetime) {
        this.id = id;
        this.Flatno = flatno;
        this.Title = title;
        this.Description = desc;
        this.Images_path = path;
        this.Status = status;
        this.datetime = datetime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlatno() {
        return Flatno;
    }

    public void setFlatno(String flatno) {
        Flatno = flatno;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImages_path() {
        return Images_path;
    }

    public void setImages_path(String images_path) {
        Images_path = images_path;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
