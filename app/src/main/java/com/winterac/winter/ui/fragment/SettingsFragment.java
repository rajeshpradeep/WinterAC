package com.winterac.winter.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.winterac.winter.BuildConfig;
import com.winterac.winter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends BaseFragment {

    private String TAG = getClass().getSimpleName();
    private View view;
    private TextView version_value;
    private Button logout_button;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        version_value = view.findViewById(R.id.version_value);
        logout_button = view.findViewById(R.id.logout_button);
        version_value.setText(BuildConfig.VERSION_NAME);

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMessage("Logout!");
            }
        });
        return view;
    }

}
