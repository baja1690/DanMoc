package com.app.diy.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by uong Pham on 3/16/17.
 */
@IgnoreExtraProperties
public class DiyCategory {
    private int id;
    private String name;
    private List<DiyItem> itemsss;
    private Map<String,Objects> items;

    public DiyCategory() {
    }

    public DiyCategory(int id, String name, List<DiyItem> items) {
        this.id = id;
        this.name = name;
        this.itemsss = items;
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

    public List<DiyItem> getItemsss() {
        return itemsss;
    }
    public void resetListItems(){
        if(items !=null){
            if(null==itemsss){
                itemsss.clear();
            }
            List<Map.Entry> entryList = new ArrayList<Map.Entry>(items.entrySet());

            for (Map.Entry s : entryList) {
                itemsss.add((DiyItem) s);
            }
        }
    }

    public void setItemsss(List<DiyItem> itemsss) {
        this.itemsss = itemsss;
    }
}
