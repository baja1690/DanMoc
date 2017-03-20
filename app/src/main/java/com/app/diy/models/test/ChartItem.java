package com.app.diy.models.test;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Cuong Pham on 3/20/17.
 */

@IgnoreExtraProperties
public class ChartItem {
    private String id;
    private String title;
    private String content;
    private String url;
    private String category;

    public ChartItem() {
    }

    public ChartItem(String id, String title, String content, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public String getCategory() {
        return category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
