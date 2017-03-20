package com.app.diy.models.test;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Cuong Pham on 3/20/17.
 */
@IgnoreExtraProperties
public class ChartCategory {
    private String id;
    private String name;

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
}
