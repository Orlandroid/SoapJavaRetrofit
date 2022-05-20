package com.example.soapcountry.util;

public interface ApiListener<T> {
    void onResponse(T response);

    void onFailure(String error);
}
