package com.winterac.winter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.winterac.winter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshPradeep G on 07-Sep-18.
 */
public class HomeProductsAdapter extends RecyclerView.Adapter<HomeProductsAdapter.HomeProductsViewHolder> {

    private String TAG = getClass().getSimpleName();
    private List<String> productItem = new ArrayList<>();
    private List<Integer> producImage = new ArrayList<>();
    private Context context;

    public HomeProductsAdapter(Context context, List<String> productItem, List<Integer> producImage) {
        this.productItem = productItem;
        this.producImage = producImage;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.products_item, parent, false);
        return new HomeProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProductsViewHolder holder, int position) {
//        holder.productImage.setBackgroundResource(producImage.get(position));
        holder.productName.setText(productItem.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class HomeProductsViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productName;

        public HomeProductsViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.category_item_title);
            productImage = itemView.findViewById(R.id.category_item_imageView);
        }
    }
}