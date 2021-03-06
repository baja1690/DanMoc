package com.app.diy.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.diy.R;
import com.app.diy.models.Tutorial;
import com.app.diy.repository.local.RealmDb;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Cuong Pham on 2/28/17.
 */
public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.HowToDoViewHolder>{
    private List<Tutorial> mItems;
    private Context mContext;
    private OnTutorialItemClickListener mOnTutorialItemClickListener;
    private RealmDb mRealmDb;

    public TutorialAdapter(Context context, List<Tutorial> items,OnTutorialItemClickListener listener) {
        this.mItems = items;
        this.mContext = context;
        this.mOnTutorialItemClickListener = listener;
        this.mRealmDb = RealmDb.getInstance();
    }

    @Override
    public HowToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tutorial_item, parent, false);
        HowToDoViewHolder vh = new HowToDoViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(HowToDoViewHolder holder, int position) {
        final Tutorial item = mItems.get(position);
        if (holder!=null){
            Glide.with(mContext).load(item.getImgUrl()).into(holder.imgIcon);
            holder.txtTitle.setText(item.getTitle());
        }
        holder.bind(item,mOnTutorialItemClickListener);
        holder.imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mRealmDb.saveTutorial(item);
                Toast.makeText(mContext,"Item was saved!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems!= null ? mItems.size():0;
    }


    public OnTutorialItemClickListener getOnTutorialItemClickListener() {
        return mOnTutorialItemClickListener;
    }

    public void setOnTutorialItemClickListener(OnTutorialItemClickListener onTutorialItemClickListener) {
        this.mOnTutorialItemClickListener = onTutorialItemClickListener;
    }

    public static class HowToDoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgIcon)
        ImageView imgIcon;
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.btnSave)
        ImageButton imgSave;

        public HowToDoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(final Tutorial item,final OnTutorialItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(item);
                }
            });
        }
    }
    public interface OnTutorialItemClickListener{
        void onItemClicked(Tutorial tutorial);
    }
}