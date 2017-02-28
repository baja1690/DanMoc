package com.app.diy.models;

/**
 * Created by Cuong Pham on 2/28/17.
 */

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Tutorial {
    private String id;
    private String title;
    private String imgUrl;
    private String content;

    public Tutorial() {
    }

    public Tutorial(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Tutorial(String title, String content, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
