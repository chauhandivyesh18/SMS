package com.millionaires.sms.Dashboard;

public class Nav_GridModel {
    public int id;
    public String Nav_Name;
    public int Nav_Image;

    public Nav_GridModel(int id, String Nav_Name, int Nav_Image) {
        this.id=id;
        this.Nav_Name=Nav_Name;
        this.Nav_Image=Nav_Image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNav_Name() {
        return Nav_Name;
    }

    public void setNav_Name(String nav_Name) {
        Nav_Name = nav_Name;
    }

    public int getNav_Image() {
        return Nav_Image;
    }

    public void setNav_Image(int nav_Image) {
        Nav_Image = nav_Image;
    }
}
