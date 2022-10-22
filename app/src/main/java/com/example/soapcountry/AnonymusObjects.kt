package com.example.soapcountry

import android.text.Editable
import android.text.TextWatcher

fun getTextWatcher(checkMyForm: () -> Unit): TextWatcher {
    return object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            checkMyForm()
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            checkMyForm()
        }

        override fun afterTextChanged(s: Editable) {
            checkMyForm()
        }
    }
}