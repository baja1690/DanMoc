package com.app.diy.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.app.diy.activities.WebActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public abstract class BaseFragment extends Fragment {
    protected abstract void initView();
    protected abstract void initData();
    protected Context mContext;
    private DatabaseReference mDatabase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        initData();
    }

    public String getLanguage(){
        return ((BaseActivity)mContext).getLanguage();
    }

    public void goToWebView(){
        Intent intent = WebActivity.createIntent(mContext);
        startActivity(intent);
    }
}
