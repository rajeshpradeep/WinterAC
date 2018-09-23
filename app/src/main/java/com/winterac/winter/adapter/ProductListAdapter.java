package com.winterac.winter.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winterac.winter.R;
import com.winterac.winter.model.CategoryItemModel;
import com.winterac.winter.model.ProductItemModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private Context mContext;
    private ArrayList<ProductItemModel> productItemModelList;


    public ProductListAdapter(Context mContext, ArrayList<ProductItemModel> ProductList) {
        this.mContext = mContext;
        this.productItemModelList = ProductList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.product_items, parent, false);
        return new ProductViewHolder(view);

    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public final TextView title;
        public RecyclerView category_recyclerview;
        public CategoryItemAdapter categoryItemAdapter;

        public ProductViewHolder(View view) {
            super(view);
            final Context context = itemView.getContext();
            title = (TextView) view.findViewById(R.id.product_textForHeader);
            category_recyclerview = (RecyclerView) itemView.findViewById(R.id.category_list);
            category_recyclerview.setLayoutManager(new GridLayoutManager(context, 2));
            category_recyclerview.setItemAnimator(new DefaultItemAnimator());
            category_recyclerview.setHasFixedSize(true);
            categoryItemAdapter = new CategoryItemAdapter(context);
            category_recyclerview.setNestedScrollingEnabled(false);
            category_recyclerview.setAdapter(categoryItemAdapter);

        }

    }


    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {


        HashMap<String, ArrayList<CategoryItemModel>> productItem = productItemModelList.get(position).getCategoryHashMap();


        holder.categoryItemAdapter.setData(productItem.get(productItemModelList.get(position).getTitle2()));
        holder.categoryItemAdapter.setRowIndex(position);
        holder.title.setText(productItemModelList.get(position).getTitle());


    }


    public int getItemCount() {
        return (null != productItemModelList ? productItemModelList.size() : 0);
    }


}
