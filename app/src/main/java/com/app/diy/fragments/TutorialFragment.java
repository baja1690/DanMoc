package com.app.diy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.diy.R;
import com.app.diy.activities.MainActivity;
import com.app.diy.base.BaseFragment;
import com.app.diy.models.Tutorial;
import com.app.diy.views.adapters.TutorialAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class TutorialFragment extends BaseFragment implements ValueEventListener{
    @BindView(R.id.rcViewTutorial)
    RecyclerView mRcListTutorials;
    private TutorialAdapter mTutorialAdapter;
    private List<Tutorial> mTutorials;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tutorial_fragment,container,false);
        ButterKnife.bind(this,root);
        initView();
        return root;
    }

    @Override
    protected void initView() {
        mRcListTutorials.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRcListTutorials.setLayoutManager(layoutManager);
        mRcListTutorials.setAdapter(mTutorialAdapter);
    }

    @Override
    protected void initData() {
        mTutorials = new ArrayList<>();
        dummyData();
        mTutorialAdapter = new TutorialAdapter(mContext,mTutorials);
        test();
    }
    public void test(){
        String lg = ((MainActivity)mContext).getLanguage();
        Log.d("MainActivity","current language: "+lg);
    }

    public void testInsertData(){

    }

    public void dummyData(){
        mTutorials.add(new Tutorial("Hoc cach dan","noi dung","http://img11.deviantart.net/1c6f/i/2012/143/1/b/tiny_flower_2_by_scooterthedog-d50w5h8.jpg"));
        mTutorials.add(new Tutorial("Hoc cach moc","noi dung","http://img11.deviantart.net/1c6f/i/2012/143/1/b/tiny_flower_2_by_scooterthedog-d50w5h8.jpg"));
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Tutorial tutorial = dataSnapshot.getValue(Tutorial.class);
        Log.d("TutorialFr", tutorial.getContent());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TutorialFragment.class.getSimpleName(),"error");
    }
}
