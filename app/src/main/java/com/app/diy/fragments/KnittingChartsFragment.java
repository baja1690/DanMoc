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
import com.app.diy.base.BaseFragment;
import com.app.diy.models.DiyCategory;
import com.app.diy.models.DiyItem;
import com.app.diy.views.adapters.KnittingAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 2/21/17.
 */

public class KnittingChartsFragment extends BaseFragment {
    public static final String TAG = KnittingChartsFragment.class.getSimpleName();
    private List<DiyCategory> mDiyCategories;
    private KnittingAdapter mKnittingAdapter;
    @BindView(R.id.rcKnittingChart)
    RecyclerView mRecycleView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDummyData();
        getFireBaseData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.knittingchart_fragment,container,false) ;
        ButterKnife.bind(this,rootView);
        initData();
        initView();
        return rootView;
    }


    @Override
    protected void initView() {
        mRecycleView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        mRecycleView.setLayoutManager(layoutManager);
        mRecycleView.setAdapter(mKnittingAdapter);
    }

    @Override
    protected void initData() {
        mKnittingAdapter = new KnittingAdapter(mContext, mDiyCategories);
    }

    public void setDummyData(){
        mDiyCategories = new ArrayList<>();
        List<DiyItem> items = new ArrayList<>();
        DiyItem item = new DiyItem("1", "ao somi", "https://s-media-cache-ak0.pinimg.com/736x/50/9e/d7/509ed7c3954019b24cb2745dd65f8faa.jpg", "content");
        items.add(item);
        item = new DiyItem("1", "ao somi", "https://s-media-cache-ak0.pinimg.com/736x/50/9e/d7/509ed7c3954019b24cb2745dd65f8faa.jpg", "content");
        items.add(item);
        item = new DiyItem("2", "ao am", "https://s-media-cache-ak0.pinimg.com/736x/50/9e/d7/509ed7c3954019b24cb2745dd65f8faa.jpg", "content");
        items.add(item);
        item = new DiyItem("3", "ao am co co", "https://s-media-cache-ak0.pinimg.com/736x/50/9e/d7/509ed7c3954019b24cb2745dd65f8faa.jpg", "content");
        items.add(item);
        item = new DiyItem("4", "ao co trai tim", "https://s-media-cache-ak0.pinimg.com/736x/50/9e/d7/509ed7c3954019b24cb2745dd65f8faa.jpg", "content");
        items.add(item);
        DiyCategory v = new DiyCategory(1,"Chart Moc Ao",items);
        mDiyCategories.add(v);
        v = new DiyCategory(2,"Chart Moc Thu",items);
        mDiyCategories.add(v);
        v = new DiyCategory(3,"Chart Moc khan",items);
        mDiyCategories.add(v);
    }

    public void getFireBaseData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(getLanguage());
        String url = "chartmoc"+"itemid";
        Query q = myRef.child("chartmoc").equalTo("chartmoc");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mDiyCategories.clear();
                Log.d(TAG,"data: "+dataSnapshot);
                for(DataSnapshot snapshot : dataSnapshot.child("chartmoc").getChildren()){
                    try {
                        snapshot.getKey();
                        DiyCategory obj = snapshot.getValue(DiyCategory.class);
                        obj.resetListItems();
                        mDiyCategories.add(obj);
                    }catch(DatabaseException e){
                        Log.d(TAG,"error: "+e);
                    }
                }

                mKnittingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
