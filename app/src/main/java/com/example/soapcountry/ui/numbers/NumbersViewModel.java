package com.example.soapcountry.ui.numbers;


import android.content.Context;

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


public class NumbersViewModel extends ViewModel {

    public Context context;
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

    private MutableLiveData<String> _errorNetwork = new MutableLiveData<>();

    public LiveData<String> errorNetwork() {
        return _errorNetwork;
    }


    public void numbersToWords(String number) {
        RequestNumbersToWords requestNumbersToWords = new RequestNumbersToWords();
        requestNumbersToWords.setBody(new RequestNumbersToWords.Body());
        requestNumbersToWords.getBody().setNumberToWordsResponse(new RequestNumbersToWords.NumberToWords());
        requestNumbersToWords.getBody().getNumberToWordsResponse().setUbiNum(number);
        Call<ResponseNumbersToWordsEnvelope> call = RetrofitInstance.getNumbersService().numberToWords(requestNumbersToWords);
        RetrofitCallBack<ResponseNumbersToWordsEnvelope> retrofitCallBack = new RetrofitCallBack<>();

        retrofitCallBack.callRetrofit(context, call, new ApiListener<ResponseNumbersToWordsEnvelope>() {
            @Override
            public void onResponse(ResponseNumbersToWordsEnvelope response) {
                if (response != null) {
                    _words.setValue(response.getResponseNumbersToWordsBody().getNumberToWordsResponse().getNumberToWordsResult());
                    _words.setValue(null);
                } else {
                    _msjError.setValue(ERROR_SERVIDOR);
                    _msjError.setValue(null);
                }
            }

            @Override
            public void onFailure(String error) {
                _msjError.setValue(ERROR_SERVIDOR);
                _msjError.setValue(null);
            }

            @Override
            public void ErrorNetwork(String mesage) {
                _errorNetwork.setValue(mesage);
                _errorNetwork.setValue(null);
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
        retrofitCallBack.callRetrofit(context, call, new ApiListener<ResponseNumberToDollarsEnvelope>() {
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

            @Override
            public void ErrorNetwork(String mesage) {
                _errorNetwork.setValue(mesage);
                _errorNetwork.setValue(null);
            }
        });
    }

}
