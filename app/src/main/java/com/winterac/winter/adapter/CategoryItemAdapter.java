package com.winterac.winter.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.winterac.winter.R;
import com.winterac.winter.model.CategoryItemModel;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<CategoryItemModel> mCategoryList;
    private int mRowIndex = -1;

    public CategoryItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<CategoryItemModel> data) {
        if (mCategoryList != data) {
            mCategoryList = data;
            notifyDataSetChanged();
        }
    }

    public void setRowIndex(int index) {
        mRowIndex = index;
    }


    private class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView content;
        public final ImageView img_item;

        public ItemViewHolder(View view) {
            super(view);
            content = (TextView) view.findViewById(R.id.category_item_title);
            img_item = (ImageView) view.findViewById(R.id.category_item_imageView);

        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.category_items, parent, false);
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, final int position) {

        final ItemViewHolder holder = (ItemViewHolder) viewholder;

        holder.content.setText(mCategoryList.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
    public int getItemCount() {
        return (null != mCategoryList ? mCategoryList.size() : 0);
    }



}
