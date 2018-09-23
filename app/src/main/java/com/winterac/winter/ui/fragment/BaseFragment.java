package com.winterac.winter.ui.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.winterac.winter.interfaces.BasicListener;
import com.winterac.winter.support.CustomProgressDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements BasicListener {


    public BaseFragment() {
        // Required empty public constructor
    }

    public void toastMessage(String tMessage) {
        Toast.makeText(getContext(),  tMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressLoader(Context context, CharSequence message, boolean cancelable) {
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(context);
        customProgressDialog.show(context, message, cancelable);
    }

    @Override
    public void hideProgressLoader(Context context) {
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(context);
        customProgressDialog.hide();
    }
}
