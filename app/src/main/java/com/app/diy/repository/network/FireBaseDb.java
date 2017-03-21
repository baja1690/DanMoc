package com.app.diy.repository.network;

import com.app.diy.models.DiyItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cuong Pham on 2/22/17.
 */

public class FireBaseDb {
    private DatabaseReference mDatabase;

    private static FireBaseDb mInstance;

    private FireBaseDb() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static FireBaseDb getInstance(){
        if(mInstance == null){
            mInstance = new FireBaseDb();
        }
        return mInstance;
    }

    public void writeNewItem(String itemId, String name, String imgUrl) {
        DiyItem item =new DiyItem(itemId,name,imgUrl);
        mDatabase.child("items").child(itemId).setValue(item);
    }
    public void updateItems(){
        Map<String,DiyItem> items = new HashMap<>();
        DiyItem item = new DiyItem("1","a","http");
        items.put("1",item);
        item = new DiyItem("2","a","http");
        items.put("2",item);
        item = new DiyItem("abc","a","http");
        items.put("abc",item);
    }
}
