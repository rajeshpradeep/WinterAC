package com.winterac.winter.utils;

/**
 * Created by Rajesh Pradeep G
 */
public class ApiUrlGenerator {

    public static boolean isInTestMode = false;
    public static String BASE_URL_TEST = "https://free-mg.metergenius.com/MeterGeniusAPI/";//FreeMG test
    public static String BASE_URL_PRODUCTION = "https://metergenius.com/MeterGeniusAPI/";//FreeMG Prod

    public static String getApiUrl(String endpoint) {

        if (endpoint == "") try {
            throw new Exception("endpoint can not be empty string!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isInTestMode) return BASE_URL_TEST + endpoint;
        else return BASE_URL_PRODUCTION + endpoint;
    }
}
