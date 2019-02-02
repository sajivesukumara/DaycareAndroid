package com.daycare.daycare1;/*
 * Copyright 2015 (C) Best Rankers
 *
 * Author   : Uday
 * Comments :
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.widget.Toast;


public class CheckInternetConnection {
    private final Context mContext;
    private final static Handler mHandler = new Handler();

    public CheckInternetConnection(Context context) {
        this.mContext = context;
    }

    public static boolean checkInternet(Context mContext) {
        if (mContext != null) {
            ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni == null) {
                Toast.makeText(mContext, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                return false;
            } else
                return true;
        }
        return false;
    }

    }
