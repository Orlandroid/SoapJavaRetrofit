package com.example.soapcountry.api;

import com.example.soapcountry.util.ApiListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallBack<T> {

    private final String ERROR_SERVIDOR = "Error en el servidor";

    public void callRetrofit(Call<T> call, ApiListener<T> listener) {
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
                listener.onFailure(t.getMessage());
            }
        });
    }

}
