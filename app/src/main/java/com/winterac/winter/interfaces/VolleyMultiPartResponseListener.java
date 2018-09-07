package com.winterac.winter.interfaces;

import com.android.volley.NetworkResponse;

/**
 * Created by RajeshPradeep G
 */
public interface VolleyMultiPartResponseListener {
    void onError(String message);

    void onResponse(NetworkResponse response);
}
