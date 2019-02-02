package com.daycare.daycare1;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.daycare.daycare1.R;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Util {

    public static Dialog dLoader;
    public static ArrayList<Dialog> arrayLoaderDialog = new ArrayList<>();


    public static void showProgressBar(final Context mContext) {

        dLoader = new Dialog(mContext, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dLoader.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dLoader.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        dLoader.setContentView(R.layout.dialog_loader);
        dLoader.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dLoader.setCancelable(false);


        if (dLoader != null) {
            dLoader.show();
            arrayLoaderDialog.add(dLoader);


        }


    }

    public static String formatDate(String dateString) {

        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy");

        Date d = null;
        try {
            d = input.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = output.format(d);
        Log.i("DATE", "" + formatted);


        return formatted;
    }


    public static ProgressDialog ProgressBar;

    public static void initializeProgressBar(Activity parent)
    {
        final ProgressDialog progressDialog = new ProgressDialog(parent);
        progressDialog.setCancelable(false);
        ProgressBar = progressDialog;
        ProgressBar.show();
    }

    public static void closeProgressBar()
    {
        ProgressBar.hide();
    }



    /* public static

   void showProgressBar(Context context){
        Intent iProgressBar  = new Intent(context, ProgressBar.class);
        context.startActivity(iProgressBar);
    }*/

   /* public static void dismissProgressBar(){
        ProgressBar.activity.finish();
    }*/


    public static void dismissProgressBar(final Context mContext) {
        /*if(dLoader!=null && dLoader.isShowing()){
            dLoader.dismiss();startClockstartClockstartClock
        }*/

        for (int i = 0; i < arrayLoaderDialog.size(); i++) {
            if (arrayLoaderDialog.get(i).isShowing())
                arrayLoaderDialog.get(i).dismiss();


        }

        arrayLoaderDialog.clear();
    }

    public static boolean isProgressShowing() {
        return (arrayLoaderDialog == null) ? false : ((arrayLoaderDialog.isEmpty() || arrayLoaderDialog.size() == 0) ? false : true);
    }


    public static void clear(Context context){
        SharedPreferences settings = context.getSharedPreferences(context.getApplicationContext().getPackageName(), Context.MODE_PRIVATE);
        settings.edit().clear().commit();
    }

}
