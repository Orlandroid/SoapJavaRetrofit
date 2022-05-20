package com.example.soapcountry.ui.numbers;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soapcountry.api.RetrofitCallBack;
import com.example.soapcountry.api.RetrofitInstance;
import com.example.soapcountry.model.numbers.request.numberstodollars.RequestNumberToDollars;
import com.example.soapcountry.model.numbers.request.numberstowords.RequestNumbersToWords;
import com.example.soapcountry.model.numbers.response.numberstodollars.ResponseNumberToDollarsEnvelope;
import com.example.soapcountry.model.numbers.response.numberstowords.ResponseNumbersToWordsEnvelope;
import com.example.soapcountry.util.ApiListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NumbersViewModel extends ViewModel {


    private final String ERROR_SERVIDOR = "Error en el servidor";

    private MutableLiveData<String> _msjError = new MutableLiveData<>();

    public LiveData<String> msjError() {
        return _msjError;
    }


    private MutableLiveData<String> _words = new MutableLiveData<>();

    public LiveData<String> words() {
        return _words;
    }


    private MutableLiveData<String> _dollars = new MutableLiveData<>();

    public LiveData<String> dollars() {
        return _dollars;
    }


    public void numbersToWords(String number) {
        RequestNumbersToWords requestNumbersToWords = new RequestNumbersToWords();
        requestNumbersToWords.setBody(new RequestNumbersToWords.Body());
        requestNumbersToWords.getBody().setNumberToWordsResponse(new RequestNumbersToWords.NumberToWords());
        requestNumbersToWords.getBody().getNumberToWordsResponse().setUbiNum(number);
        RetrofitInstance.getNumbersService().numberToWords(requestNumbersToWords).enqueue(new Callback<ResponseNumbersToWordsEnvelope>() {
            @Override
            public void onResponse(Call<ResponseNumbersToWordsEnvelope> call, Response<ResponseNumbersToWordsEnvelope> response) {
                if (response.code() == 200) {
                    _words.setValue(response.body().getResponseNumbersToWordsBody().getNumberToWordsResponse().getNumberToWordsResult());
                    _words.setValue(null);
                } else {
                    _msjError.setValue(ERROR_SERVIDOR);
                    _msjError.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseNumbersToWordsEnvelope> call, Throwable t) {
                _msjError.setValue(ERROR_SERVIDOR);
                _msjError.setValue(null);
            }
        });
    }

    public void numberToDollars(String number) {
        RequestNumberToDollars requestNumbersToWords = new RequestNumberToDollars();
        requestNumbersToWords.setBody(new RequestNumberToDollars.Body());
        requestNumbersToWords.getBody().setNumberToDollars(new RequestNumberToDollars.NumberToDollars());
        requestNumbersToWords.getBody().getNumberToDollars().setdNum(number);

        Call<ResponseNumberToDollarsEnvelope> call = RetrofitInstance.getNumbersService().numberToDollars(requestNumbersToWords);
        RetrofitCallBack<ResponseNumberToDollarsEnvelope> retrofitCallBack = new RetrofitCallBack<>();
        retrofitCallBack.callRetrofit(call, new ApiListener<ResponseNumberToDollarsEnvelope>() {
            @Override
            public void onResponse(ResponseNumberToDollarsEnvelope response) {
                _dollars.setValue(response.getBody().getNumberToDollarsResponse().getNumberToDollarsResult());
                _dollars.setValue(null);
            }

            @Override
            public void onFailure(String error) {
                _msjError.setValue(ERROR_SERVIDOR);
                _msjError.setValue(null);
            }
        });
    }

}
