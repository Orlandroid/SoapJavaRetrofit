package com.example.soapcountry.api;

import android.content.Context;

import com.example.soapcountry.util.ApiListener;
import com.example.soapcountry.util.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallBack<T> {

    private final String ERROR_SERVIDOR = "Error en el servidor";
    private final String ERROR_CONECXION = "Error verifica tu conexion de internet";

    public void callRetrofit(Context context, Call<T> call, ApiListener<T> listener) {
        if (!Util.isNetworkConnected(context)) {
            listener.ErrorNetwork(ERROR_CONECXION);
        }
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    listener.onResponse(response.body());
                } else {
                    listener.onFailure(ERROR_SERVIDOR);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                listener.onFailure(ERROR_SERVIDOR);
            }
        });
    }

}
