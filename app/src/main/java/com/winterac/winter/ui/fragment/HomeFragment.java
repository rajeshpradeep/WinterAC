package com.winterac.winter.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.winterac.winter.R;
import com.winterac.winter.adapter.HomeBannerAdapter;
import com.winterac.winter.adapter.HomeProductsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private String TAG = getClass().getSimpleName();
    private View view;
    private RecyclerView newProductRecyclerview;
    private Context context;
    List<Integer> color;
    List<String> colorName;
    HomeBannerAdapter homeBannerAdapter;
    ViewPager viewPager;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private HomeProductsAdapter homeProductsAdapter;

    List<String> productItem;
    List<Integer> producImage;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        context = getContext();
        viewPager=(ViewPager) view.findViewById(R.id.banner_viewpager);
        pager_indicator = view.findViewById(R.id.viewPagerCountDots);
        newProductRecyclerview = view.findViewById(R.id.newProduct_recyclerview);
        color = new ArrayList<>();
        color.add(R.drawable.jellyfish);
        color.add(R.drawable.koala);
        color.add(R.drawable.penguins);
        color.add(R.drawable.koala);
        color.add(R.drawable.penguins);

        producImage = new ArrayList<>();
        producImage.add(R.drawable.cogs_gear);
        producImage.add(R.drawable.koala);
        producImage.add(R.drawable.jellyfish);
        producImage.add(R.drawable.penguins);
        producImage.add(R.drawable.cogs_gear);
        producImage.add(R.drawable.koala);
        producImage.add(R.drawable.jellyfish);
        producImage.add(R.drawable.penguins);
        productItem = new ArrayList<>();
        productItem.add("Product 1");
        productItem.add("Product 2");
        productItem.add("Product 3");
        productItem.add("Product 4");
        productItem.add("Product 5");
        productItem.add("Product 6");
        productItem.add("Product 7");
        productItem.add("Product 8");

        initBannerSlider(context, color);
        initRecylerView(productItem, producImage);


        return view;
    }

    private void initBannerSlider(Context context, List<Integer> color) {
        homeBannerAdapter = new HomeBannerAdapter(context, color);
        viewPager.setAdapter(homeBannerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setClipToPadding(false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
                }
                dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setUiPageViewController();
    }

    private void setUiPageViewController() {
        dotsCount = color.size();
        pager_indicator.removeAllViews();

        if(dotsCount != 0) {
            dots = new ImageView[dotsCount];

            for (int i = 0; i < dotsCount; i++) {
                dots[i] = new ImageView(getActivity());
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(4, 0, 4, 0);
                pager_indicator.addView(dots[i], params);
            }
            dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
        } else {
            Log.i(TAG,"Banner is Empty");
        }
    }

    private void initRecylerView(List<String> productItem, List<Integer> producImage) {
        newProductRecyclerview.setHasFixedSize(true);
        GridLayoutManager llm = new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false);
        newProductRecyclerview.setLayoutManager(llm);
        newProductRecyclerview.setNestedScrollingEnabled(false);
        homeProductsAdapter= new HomeProductsAdapter(context, productItem, producImage);
        newProductRecyclerview.setAdapter(homeProductsAdapter);
    }

}
