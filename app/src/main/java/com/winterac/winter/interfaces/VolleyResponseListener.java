package com.winterac.winter.interfaces;

/**
 * Created by RajeshPradeep G
 */
public interface VolleyResponseListener {
    void onError(String message);

    void onResponse(String response);
}
