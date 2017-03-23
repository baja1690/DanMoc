package com.app.diy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.diy.R;
import com.app.diy.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 2/27/17.
 */
public class SavedListFragment extends BaseFragment {
    @BindView(R.id.rcListSavedItemsTutorial)
    RecyclerView mRcSavedItemTutorial;
    @BindView(R.id.rcListSavedItemsKnitting)
    RecyclerView mRcSavedItemKnitting;
    @BindView(R.id.rcListSavedItemsCrochet)
    RecyclerView mRcSavedItemCrochet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.savedlist_fragment,container,false) ;
        ButterKnife.bind(this,rootView);
        initData();
        initView();
        return rootView;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
