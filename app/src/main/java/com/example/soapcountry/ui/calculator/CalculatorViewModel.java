package com.example.soapcountry.ui.calculator;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soapcountry.api.RetrofitCallBack;
import com.example.soapcountry.api.RetrofitInstance;
import com.example.soapcountry.model.calculator.request.RequestCalculatorAdd;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorAdd;
import com.example.soapcountry.util.ApiListener;

import retrofit2.Call;

public class CalculatorViewModel extends ViewModel {


    public Context context;


    private MutableLiveData<String> _msjError = new MutableLiveData<>();

    public LiveData<String> msjError() {
        return _msjError;
    }

    private MutableLiveData<String> _dollars = new MutableLiveData<>();

    public LiveData<String> dollars() {
        return _dollars;
    }

    private MutableLiveData<String> _errorNetwork = new MutableLiveData<>();

    public LiveData<String> errorNetwork() {
        return _errorNetwork;
    }

    private MutableLiveData<String> _resultAdd = new MutableLiveData<>();

    public LiveData<String> resultAdd() {
        return _resultAdd;
    }


    public void getAdd(Integer a, Integer b) {
        RequestCalculatorAdd request = new RequestCalculatorAdd();
        request.setBody(new RequestCalculatorAdd.Body());
        request.getBody().setAdd(new RequestCalculatorAdd.Add());
        request.getBody().getAdd().setA(a);
        request.getBody().getAdd().setB(b);

        Call<ResponseCalculatorAdd> call = RetrofitInstance.getCalculatorAddService().getAdd(request);
        RetrofitCallBack<ResponseCalculatorAdd> retrofitCallBack = new RetrofitCallBack<>();
        retrofitCallBack.callRetrofit(context, call, new ApiListener<ResponseCalculatorAdd>() {
            @Override
            public void onResponse(ResponseCalculatorAdd response) {
                _resultAdd.setValue(response.getBody().getAddResponse().getAddResult());
                _resultAdd.setValue(null);
            }

            @Override
            public void onFailure(String error) {
                _msjError.setValue(error);
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
