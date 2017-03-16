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
import com.app.diy.models.DiyCategory;
import com.app.diy.models.DiyItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 3/16/17.
 */

public class KnittingAdapter extends RecyclerView.Adapter<KnittingAdapter.KnittingChartViewHolder>{
    private Context mContext;
    private List<DiyCategory> mDiyCategories;

    public KnittingAdapter(Context mContext, List<DiyCategory> mDiyCategories) {
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
        DiyCategory obj = mDiyCategories.get(position);
        if(holder!=null){
            holder.title.setText(obj.getName());
            holder.btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)mContext).openWebActivity();
                }
            });
            ItemsAdapter adapter = new ItemsAdapter(mContext, obj.getItems(), new ItemsAdapter.OnItemClickListener() {
                @Override
                public void onItemClicked(DiyItem diyItem) {
                    ((MainActivity)mContext).openWebActivity();
                }
            });
            holder.rcListItem.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
            holder.rcListItem.setLayoutManager(layoutManager);
            holder.rcListItem.setAdapter(adapter);
            holder.rcListItem.setNestedScrollingEnabled(false);
        }
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
