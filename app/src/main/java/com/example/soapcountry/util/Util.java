package com.example.soapcountry.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class Util {

    public static void closeKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

}
