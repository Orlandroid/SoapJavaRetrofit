package com.example.soapcountry.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Util {

    public static void closeKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public static void showToast(String message,Context context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
