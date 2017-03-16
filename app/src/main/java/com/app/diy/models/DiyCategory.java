package com.app.diy.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by uong Pham on 3/16/17.
 */
@IgnoreExtraProperties
public class DiyCategory {
    private int id;
    private String name;
    private List<DiyItem> items;

    public DiyCategory(int id, String name, List<DiyItem> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DiyItem> getItems() {
        return items;
    }

    public void setItems(List<DiyItem> items) {
        this.items = items;
    }
}
