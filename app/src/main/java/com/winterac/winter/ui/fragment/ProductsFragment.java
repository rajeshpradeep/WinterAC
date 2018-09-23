package com.winterac.winter.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winterac.winter.R;
import com.winterac.winter.adapter.ProductListAdapter;
import com.winterac.winter.model.CategoryItemModel;
import com.winterac.winter.model.ProductItemModel;

import java.util.ArrayList;
import java.util.HashMap;


public class ProductsFragment extends BaseFragment {

    private View view;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_products, container, false);
        recyclerView = view.findViewById(R.id.product_recyclerview);

        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        final ProductListAdapter productAdapter = new ProductListAdapter(getContext(), productList());
        recyclerView.setAdapter(productAdapter);

    }

    private ArrayList<ProductItemModel> productList() {

        ArrayList<ProductItemModel> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ProductItemModel productItemModel = new ProductItemModel();

            ArrayList<CategoryItemModel> categoryItemModels = new ArrayList<>();
            HashMap<String, ArrayList<CategoryItemModel>> categoryHashMap = new HashMap<>();

            for (int j = 0; j < 4; j++) {
                CategoryItemModel categoryItemModel = new CategoryItemModel();
                categoryItemModel.setTitle("sample" + j);
                categoryItemModels.add(categoryItemModel);
                categoryHashMap.put("sample" + j, categoryItemModels);
                if(i ==0 && j ==1 ){
                    break;
                }
            }

            switch (i) {
                case 1:
                    productItemModel.setTitle("Bare compressors");
                    productItemModel.setTitle2("sample"+i);
                    break;
                case 2:
                    productItemModel.setTitle("Chillers Package");
                    productItemModel.setTitle2("sample"+i);
                    break;
                default:
                    productItemModel.setTitle("Bare compressors");
                    productItemModel.setTitle2("sample"+i);

            }
            productItemModel.setCategoryItems(categoryItemModels);
            productItemModel.setCategoryHashMap(categoryHashMap
            );
            list.add(productItemModel);
        }

        return list;
    }

}
