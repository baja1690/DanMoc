package com.app.diy.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.diy.R;
import com.app.diy.models.DiyItem;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 3/16/17.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private List<DiyItem> mItems;
    private OnItemClickListener listener;
    private Context mContext;

    public ItemsAdapter(Context mContext, List<DiyItem> mItems, OnItemClickListener listener) {
        this.mItems = mItems;
        this.listener = listener;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.diy_item, parent, false);
        ItemsAdapter.ItemViewHolder vh = new ItemsAdapter.ItemViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        DiyItem item = mItems.get(position);
        if(null!=holder){
            holder.title.setText(item.getName());
            Glide.with(mContext).load(item.getImgUrl()).into(holder.imageView);
            holder.bind(item,listener);
        }
    }

    @Override
    public int getItemCount() {
        return (null != mItems) ? mItems.size() : 0;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView title;
        @BindView(R.id.itemImage)
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void bind(final DiyItem item, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(item);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(DiyItem diyItem);
    }
}
