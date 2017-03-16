package com.app.diy.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Cuong Pham on 3/14/17.
 */

public class Validate {
    public static boolean isNetworkOnline(Context mContext) {
        boolean status=false;
        try{
            ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
