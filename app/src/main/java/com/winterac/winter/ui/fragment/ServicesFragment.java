package com.winterac.winter.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winterac.winter.R;
import com.winterac.winter.adapter.ServiceAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends BaseFragment {

    private String TAG = getClass().getSimpleName();
    private View view;
    private RecyclerView serviceRecyclerView;
    private Context context;

    private ServiceAdapter serviceAdapter;
    ArrayList<String> serviceArrayList;
    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_services, container, false);
        context = getContext();
        serviceRecyclerView = view.findViewById(R.id.services_recyclerview);
        initServiceList(serviceArrayList);
        return view;
    }
    private void initServiceList(ArrayList<String> serviceArrayList) {
        serviceAdapter = new ServiceAdapter(context, serviceArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        serviceRecyclerView.setLayoutManager(mLayoutManager);
        serviceRecyclerView.setItemAnimator(new DefaultItemAnimator());
        serviceRecyclerView.setAdapter(serviceAdapter);
        serviceRecyclerView.setNestedScrollingEnabled(false);
    }
}
