package com.app.diy.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.diy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 3/21/17.
 */

public class SavedItemAdapter {
    public static class SavedItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemTitle)
        TextView title;
        @BindView(R.id.btnMore)
        Button btnMore;
        @BindView(R.id.recycler_view_list)
        RecyclerView rcListItem;

        public SavedItemViewHolder (View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
