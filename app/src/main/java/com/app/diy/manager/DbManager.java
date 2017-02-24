package com.app.diy.manager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Cuong Pham on 2/22/17.
 */

public class DbManager {
    private DatabaseReference mDatabase;

    private static DbManager mInstance;

    private DbManager() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static DbManager getInstance(){
        if(mInstance == null){
            mInstance = new DbManager();
        }
        return mInstance;
    }


}
