package com.app.diy.models;

import java.util.List;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class Category {
    private int id;
    private String name;
    private List<DiyItem> items;

    public Category(String name, List<DiyItem> items) {
        this.name = name;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DiyItem> getItems() {
        return items;
    }
}
