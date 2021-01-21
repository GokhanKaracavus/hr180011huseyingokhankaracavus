package com.hr180011_huseyin_gokhan_karacavus_final_proje.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {


    public  static  boolean internetControl(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && ((NetworkInfo) networkInfo).isAvailable() && networkInfo.isConnected()) {
            return true;
        }else {
            return false;
        }
    }

}
