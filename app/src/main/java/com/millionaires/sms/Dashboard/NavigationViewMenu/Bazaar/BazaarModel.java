package com.millionaires.sms.Dashboard.NavigationViewMenu.Bazaar;

public class BazaarModel {

    public String id;
    public String profileimage;
    public String name;
    public String timestamp;
    public String title;
    public String description;
    public String images;

    public BazaarModel(String id, String profileimage, String name, String timestamp, String title, String description, String images) {
        this.id = id;
        this.profileimage = profileimage;
        this.name = name;
        this.timestamp = timestamp;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileimage() {
        return profileimage;
    }

    public void setProfileimage(String profileimage) {
        this.profileimage = profileimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
