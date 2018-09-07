package com.winterac.winter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.winterac.winter.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by RajeshPradeep G on 06-Sep-18.
 */
public class SideMenuAdapter extends RecyclerView.Adapter<SideMenuAdapter.SidemenuViewHolder> {

    private String TAG = getClass().getSimpleName();
    private List<String> menuItem = new ArrayList<>();
    private Context context;

    public SideMenuAdapter(Context context, List<String> menuItem) {
        this.menuItem = menuItem;
        this.context = context;
    }

    @NonNull
    @Override
    public SidemenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.sliding_menu_item, parent, false);
        return new SidemenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SidemenuViewHolder holder, int position) {
        holder.sideMenuTitle.setText(menuItem.get(position));
        Log.i(TAG, "onBindViewHolder:menuItem "+menuItem.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return menuItem.size();
    }

    public class SidemenuViewHolder extends RecyclerView.ViewHolder {

        private ImageView sideMenuIcon;
        private TextView sideMenuTitle;

        public SidemenuViewHolder(View itemView) {
            super(itemView);
            sideMenuIcon = itemView.findViewById(R.id.sliding_menu_img);
            sideMenuTitle = itemView.findViewById(R.id.side_menu_tview);
        }
    }
}