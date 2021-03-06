package com.example.soapcountry.ui.calculator;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soapcountry.api.RetrofitCallBack;
import com.example.soapcountry.api.RetrofitInstance;
import com.example.soapcountry.model.calculator.request.RequestCalculatorAdd;
import com.example.soapcountry.model.calculator.request.RequestCalculatorDivide;
import com.example.soapcountry.model.calculator.request.RequestCalculatorMultiply;
import com.example.soapcountry.model.calculator.request.RequestCalculatorSubtract;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorAdd;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorDivide;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorMultiply;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorSubtract;
import com.example.soapcountry.util.ApiListener;

import retrofit2.Call;

public class CalculatorViewModel extends ViewModel{


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

    private MutableLiveData<String> _resultSubtract = new MutableLiveData<>();

    public LiveData<String> resultSubtract() {
        return _resultSubtract;
    }

    private MutableLiveData<String> _resultMultiply = new MutableLiveData<>();

    public LiveData<String> resultMultiply() {
        return _resultMultiply;
    }


    private MutableLiveData<String> _resultDivide = new MutableLiveData<>();

    public LiveData<String> resultDivide() {
        return _resultDivide;
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

    public void getSubtract(Integer a, Integer b) {
        RequestCalculatorSubtract requestCalculatorSubtract = new RequestCalculatorSubtract();
        requestCalculatorSubtract.setBody(new RequestCalculatorSubtract.Body());
        requestCalculatorSubtract.getBody().setSubtract(new RequestCalculatorSubtract.Subtract());
        requestCalculatorSubtract.getBody().getSubtract().setA(a);
        requestCalculatorSubtract.getBody().getSubtract().setB(b);
        Call<ResponseCalculatorSubtract> call = RetrofitInstance.getCalculatorService().getSubtract(requestCalculatorSubtract);
        RetrofitCallBack<ResponseCalculatorSubtract> retrofitCallBack = new RetrofitCallBack<>();
        retrofitCallBack.callRetrofit(context, call, new ApiListener<ResponseCalculatorSubtract>() {
            @Override
            public void onResponse(ResponseCalculatorSubtract response) {
                _resultSubtract.setValue(response.getBody().getSubtractResponse().getSubtractResult());
                _resultSubtract.setValue(null);
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

    public void getMultiply(Integer a, Integer b) {
        RequestCalculatorMultiply requestCalculatorMultiply = new RequestCalculatorMultiply();
        requestCalculatorMultiply.setBody(new RequestCalculatorMultiply.Body());
        requestCalculatorMultiply.getBody().setMultiply(new RequestCalculatorMultiply.Multiply());
        requestCalculatorMultiply.getBody().getMultiply().setA(a);
        requestCalculatorMultiply.getBody().getMultiply().setB(b);
        Call<ResponseCalculatorMultiply> call = RetrofitInstance.getCalculatorService().getMultiply(requestCalculatorMultiply);
        RetrofitCallBack<ResponseCalculatorMultiply> retrofitCallBack = new RetrofitCallBack<>();
        retrofitCallBack.callRetrofit(context, call, new ApiListener<ResponseCalculatorMultiply>() {
            @Override
            public void onResponse(ResponseCalculatorMultiply response) {
                _resultMultiply.setValue(response.getBody().getMultiplyResponse().getMultiplyResult());
                _resultMultiply.setValue(null);
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

    public void getDivide(Integer a, Integer b) {
        RequestCalculatorDivide requestCalculatorDivide = new RequestCalculatorDivide();
        requestCalculatorDivide.setBody(new RequestCalculatorDivide.Body());
        requestCalculatorDivide.getBody().setDivide(new RequestCalculatorDivide.Divide());
        requestCalculatorDivide.getBody().getDivide().setA(a);
        requestCalculatorDivide.getBody().getDivide().setB(b);
        Call<ResponseCalculatorDivide> call = RetrofitInstance.getCalculatorService().getDivide(requestCalculatorDivide);
        RetrofitCallBack<ResponseCalculatorDivide> retrofitCallBack = new RetrofitCallBack<>();
        retrofitCallBack.callRetrofit(context, call, new ApiListener<ResponseCalculatorDivide>() {
            @Override
            public void onResponse(ResponseCalculatorDivide response) {
                _resultDivide.setValue(response.getBody().getDivideResponse().getMultiplyResult());
                _resultDivide.setValue(null);
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
