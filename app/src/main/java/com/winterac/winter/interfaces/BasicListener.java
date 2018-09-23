package com.winterac.winter.interfaces;

import android.content.Context;

public interface BasicListener {
    void showProgressLoader(Context context, CharSequence message, boolean cancelable);
    void hideProgressLoader(Context context);

}
