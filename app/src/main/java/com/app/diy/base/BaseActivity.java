package com.app.diy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.app.diy.manager.SharedPreference;

import java.util.Locale;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class BaseActivity extends AppCompatActivity {
    private SharedPreference mSharedPreference;
    private String mLanguage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreference = SharedPreference.getInstance(this);
        setLanguage();
    }
    public void setLanguage(){
        if(mSharedPreference == null){
            mSharedPreference = SharedPreference.getInstance(this);
        }
        if(TextUtils.isEmpty(mSharedPreference.getLanguage())){
            mLanguage = Locale.getDefault().getLanguage();
        }else {
            mLanguage = mSharedPreference.getLanguage();
        }
    }
    public String getLanguage(){
        if(TextUtils.isEmpty(mLanguage)){
          mLanguage = "vi";
        }
        return mLanguage;
    }
}
