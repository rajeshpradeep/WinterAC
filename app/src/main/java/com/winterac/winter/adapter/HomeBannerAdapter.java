package com.winterac.winter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.winterac.winter.R;

import java.util.List;

/**
 * Created by RajeshPradeep G on 07-Sep-18.
 */
public class HomeBannerAdapter extends PagerAdapter {

    private Context context;
    private List<Integer> color;
    private List<String> colorName;

    public HomeBannerAdapter(Context context, List<Integer> color) {
        this.context = context;
        this.color = color;
    }

    @Override
    public int getCount() {
        return color.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.banner_slider, container, false);
        ImageView bannerImage = itemView.findViewById(R.id.banner_img);
        bannerImage.setBackgroundResource(color.get(position));
        /*Glide.with(context).load(color)
                .into(bannerImage);*/

        container.addView(itemView);
        container.setTag(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
        notifyDataSetChanged();
    }
}