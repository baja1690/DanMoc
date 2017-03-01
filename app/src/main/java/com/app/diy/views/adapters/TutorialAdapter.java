package com.app.diy.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.diy.R;
import com.app.diy.models.Tutorial;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Cuong Pham on 2/28/17.
 */

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.HowToDoViewHolder>{
    private List<Tutorial> items;
    private Context mContext;

    public TutorialAdapter(Context context, List<Tutorial> items) {
        this.items = items;
        this.mContext = context;
    }

    @Override
    public HowToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tutorial_item, parent, false);
        HowToDoViewHolder vh = new HowToDoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HowToDoViewHolder holder, int position) {
        Tutorial item = items.get(position);
        if (holder!=null){
            Glide.with(mContext).load(item.getImgUrl()).into(holder.imgIcon);
            holder.txtTitle.setText(item.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class HowToDoViewHolder extends RecyclerView.ViewHolder{
        //@BindView(imageView)
        ImageView imgIcon;
        //@BindView(R.id.txtTitle)
        TextView txtTitle;
        public HowToDoViewHolder(View itemView) {
            super(itemView);
           // ButterKnife.bind(this,itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        }
    }
}
