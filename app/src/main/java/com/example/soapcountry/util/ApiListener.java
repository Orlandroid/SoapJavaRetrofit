package com.example.soapcountry.util;

import androidx.lifecycle.LiveData;

public interface ApiListener<T> {

    void onResponse(T response);

    void onFailure(String error);

    void ErrorNetwork(String mesage);

}
