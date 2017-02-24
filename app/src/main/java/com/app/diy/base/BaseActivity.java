package com.app.diy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.diy.manager.SharedPreference;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class BaseActivity extends AppCompatActivity {
    private SharedPreference mSharedPreference;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreference = SharedPreference.getInstance(this);
        mContext = this;
    }
}
