package com.app.diy.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Cuong Pham on 2/21/17.
 */
@IgnoreExtraProperties
public class DiyItem {
    private String id;
    private String name;
    private String imgUrl;

    public DiyItem() {
    }

    public DiyItem(String id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
