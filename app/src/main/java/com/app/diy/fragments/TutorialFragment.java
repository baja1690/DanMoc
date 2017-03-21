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
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class TutorialFragment extends BaseFragment implements ValueEventListener, TutorialAdapter.OnTutorialItemClickListener {
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
        getFireBaseData();
        mTutorialAdapter = new TutorialAdapter(mContext,mTutorials,this);
    }

    public void getFireBaseData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(getLanguage());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mTutorials.clear();
                Log.d(TAG,"data: "+dataSnapshot);
                for(DataSnapshot snapshot : dataSnapshot.child("tutorial").getChildren()){
                    try {
                        Tutorial obj = snapshot.getValue(Tutorial.class);
                        mTutorials.add(obj);
                   }catch(DatabaseException e){
                        Log.d(TAG,"error: "+e);
                    }
                }
                mTutorialAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

    @Override
    public void onItemClicked(Tutorial tutorial) {
        if(mContext!=null){
            ((MainActivity)mContext).openWebActivity(tutorial.getContent());
        }
    }
}

