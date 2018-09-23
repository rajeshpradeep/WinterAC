package com.winterac.winter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winterac.winter.R;

import java.util.ArrayList;

/**
 * Created by RajeshPradeep G on 06-Sep-18.
 */
public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private String TAG = getClass().getSimpleName();
    private Context context;
    private ArrayList<String> serviceArrayList;

    public ServiceAdapter(Context context, ArrayList<String> serviceArrayList) {
        this.context = context;
        this.serviceArrayList = serviceArrayList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.services_item, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {

        private TextView serviceTitle;
        private TextView serviceBody;
        public ServiceViewHolder(View itemView) {
            super(itemView);
            serviceTitle = itemView.findViewById(R.id.service_title);
            serviceBody = itemView.findViewById(R.id.service_body);
        }
    }
}
