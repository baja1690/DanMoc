package com.app.diy.models;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class Category {
    private int id;
    private String name;
    private DiyItem items;

    public Category(String name, DiyItem items) {
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

    public DiyItem getItems() {
        return items;
    }

    public void setItems(DiyItem items) {
        this.items = items;
    }
}
