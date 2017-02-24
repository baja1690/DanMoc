package com.app.diy.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.diy.utils.Constant;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class SharedPreference {
    public static final String PREFS_NAME = "PREFS";

    public static final String LANGUAGE = "language";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private static SharedPreference sharedPreference;

    public static SharedPreference getInstance(Context context) {
        if (sharedPreference == null)
            sharedPreference = new SharedPreference(context);
        return sharedPreference;
    }

    public SharedPreference(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
    private void saveString(String key, String text) {
        editor = settings.edit();
        editor.putString(key, text);
        editor.commit();
    }
    private String getStringValue(String key) {
        return settings.getString(key, Constant.BLANK);
    }

    public String getLanguage() {
        return getStringValue(LANGUAGE);
    }

    public void setLanguage(String value) {
        saveString(LANGUAGE, value);
    }

}
