package com.app.diy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.app.diy.manager.SharedPreference;
import com.app.diy.views.dialogs.SimpleLoadingDialog;

import java.util.Locale;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class BaseActivity extends AppCompatActivity {
    private SharedPreference mSharedPreference;
    private String mLanguage;
    protected SimpleLoadingDialog mProgress;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
        mSharedPreference = SharedPreference.getInstance(this);
        setLanguage();
        init();
    }
    private void init(){
        mProgress = new SimpleLoadingDialog(mContext);
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
