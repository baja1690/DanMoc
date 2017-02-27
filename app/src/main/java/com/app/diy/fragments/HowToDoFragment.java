package com.app.diy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.diy.R;
import com.app.diy.base.BaseFragment;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class HowToDoFragment extends BaseFragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.howtodo_fragment,container,false);
        return root;
    }
}
