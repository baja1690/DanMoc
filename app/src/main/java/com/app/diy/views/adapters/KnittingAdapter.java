package com.app.diy.views.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.diy.R;
import com.app.diy.activities.MainActivity;
import com.app.diy.models.test.ChartCategory;
import com.app.diy.models.test.ChartItem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 3/16/17.
 */

public class KnittingAdapter extends RecyclerView.Adapter<KnittingAdapter.KnittingChartViewHolder>{
    private Context mContext;
    private List<ChartCategory> mDiyCategories;
    List<ChartItem> mItems = new ArrayList<>();

    public KnittingAdapter(Context mContext, List<ChartCategory> mDiyCategories) {
        this.mContext = mContext;
        this.mDiyCategories = mDiyCategories;
    }

    @Override
    public KnittingChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_item_category, parent, false);
        KnittingAdapter.KnittingChartViewHolder vh = new KnittingAdapter.KnittingChartViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(KnittingChartViewHolder holder, int position) {
        ChartCategory obj = mDiyCategories.get(position);
        if(holder!=null){
            holder.title.setText(obj.getName());
            holder.btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)mContext).openWebActivity();
                }
            });
            getDataFromFireBase(obj.getId(),holder);
        }
    }

    public void getDataFromFireBase(final String chartId, final KnittingChartViewHolder holder){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("vi/chartmoc/");
        Query q = myRef.child("items");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<ChartItem> items= new ArrayList<ChartItem>();
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    ChartItem item = data.getValue(ChartItem.class);
                    if(item.getCategory().equalsIgnoreCase(chartId)) {
                        items.add(item);
                    }
                }
                ItemsAdapter adapter = new ItemsAdapter(mContext, items, new ItemsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClicked(ChartItem diyItem) {
                        ((MainActivity)mContext).openWebActivity(diyItem.getContent());
                    }
                });
                holder.rcListItem.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
                holder.rcListItem.setLayoutManager(layoutManager);
                holder.rcListItem.setAdapter(adapter);
                holder.rcListItem.setNestedScrollingEnabled(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getFireBaseData(String chartCtgName, final ItemsAdapter adapter){
        mItems = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/chartmoc/category/"+chartCtgName);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mItems.clear();
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    ChartItem item = data.getValue(ChartItem.class);
                    mItems.add(item);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != mDiyCategories ? mDiyCategories.size() : 0);
    }

    public static class KnittingChartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemTitle)
        TextView title;
        @BindView(R.id.btnMore)
        Button btnMore;
        @BindView(R.id.recycler_view_list)
        RecyclerView rcListItem;

        public KnittingChartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
