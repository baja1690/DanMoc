package com.app.diy.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Cuong Pham on 2/21/17.
 */
@IgnoreExtraProperties
public class DiyItem {
    private String id;
    private String name;
    private String url;
    private String content;

    public DiyItem() {
    }

    public DiyItem(String id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.url = imgUrl;
    }

    public DiyItem(String id, String name, String imgUrl, String content) {
        this.id = id;
        this.name = name;
        this.url = imgUrl;
        this.content = content;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
