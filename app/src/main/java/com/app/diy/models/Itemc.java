package com.app.diy.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Cuong Pham on 3/17/17.
 */

@IgnoreExtraProperties
public class Itemc {
    private String id;
    private String title;
    private String url;
    private String content;

    public Itemc() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


