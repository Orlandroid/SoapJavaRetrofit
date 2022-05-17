package com.example.soapcountry.ui.country;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soapcountry.api.RetrofitInstance;
import com.example.soapcountry.model.request.capitalcity.RequestCapitalCity;
import com.example.soapcountry.model.request.countryCurrency.RequestCountryCurrency;
import com.example.soapcountry.model.request.countryFlag.RequestCountryFlag;
import com.example.soapcountry.model.request.countryIntPhoneCode.RequestCountryIntPhoneCode;
import com.example.soapcountry.model.request.listcountrys.RequestCountrysList;
import com.example.soapcountry.model.response.capitalcity.ResponseCapitalCityEnvelope;
import com.example.soapcountry.model.response.countryCurrency.ResponseCountryCurrencyEnvelope;
import com.example.soapcountry.model.response.countryCurrency.ResponseCountryCurrencyResult;
import com.example.soapcountry.model.response.countryFlag.ResponseCountryFlagResponse;
import com.example.soapcountry.model.response.countryFlag.ResponseEnvelopeCountryFlag;
import com.example.soapcountry.model.response.countryIntPhoneCode.ResponseCountryIntPhoneCodeEnvelope;
import com.example.soapcountry.model.response.listcountry.ResponseCountryListEnvelop;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CountryViewModel extends ViewModel {

    private static final String ERROR_SERVIDOR = "Error en el servidor";

    public MutableLiveData<ResponseCountryListEnvelop> _getListaCountry = new MutableLiveData<>();

    public LiveData<ResponseCountryListEnvelop> getListaCountry() {
        return _getListaCountry;
    }

    private MutableLiveData<String> _msjError = new MutableLiveData<>();

    public LiveData<String> msjError() {
        return _msjError;
    }

    private MutableLiveData<ResponseCountryFlagResponse> _countryFlag = new MutableLiveData<>();

    public LiveData<ResponseCountryFlagResponse> countryFlag() {
        return _countryFlag;
    }


    private MutableLiveData<String> _capitalCity = new MutableLiveData<>();

    public LiveData<String> capitalCity() {
        return _capitalCity;
    }


    private MutableLiveData<ResponseCountryCurrencyResult> _countryCurrency = new MutableLiveData<>();

    public LiveData<ResponseCountryCurrencyResult> countryCurrency() {
        return _countryCurrency;
    }

    private MutableLiveData<String> _countryIntPhoneCode = new MutableLiveData<>();

    public LiveData<String> countryIntPhoneCode() {
        return _countryIntPhoneCode;
    }


    public void getCountrList() {
        RequestCountrysList requestCountrysList = new RequestCountrysList();
        requestCountrysList.setbBody(new RequestCountrysList.ListaBody());
        requestCountrysList.getbBody().setListOfCountryNamesByName(new RequestCountrysList.ListOfCountryNamesByName());
        RetrofitInstance.getCountryService().getCountryList(requestCountrysList).enqueue(new Callback<ResponseCountryListEnvelop>() {
            @Override
            public void onResponse(Call<ResponseCountryListEnvelop> call, Response<ResponseCountryListEnvelop> response) {
                Log.w("ANDORID SUCCES", String.valueOf(response.code()));
                _getListaCountry.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseCountryListEnvelop> call, Throwable t) {
                _msjError.setValue(t.getMessage());
            }
        });
    }

    public void getCapitalCity(String code) {
        RequestCapitalCity requestCapitalCity = new RequestCapitalCity();
        requestCapitalCity.setSoapBody(new RequestCapitalCity.Body());
        requestCapitalCity.getSoapBody().setCapitalCity(new RequestCapitalCity.CapitalCity());
        requestCapitalCity.getSoapBody().getCapitalCity().setCountryISOCode(code);
        RetrofitInstance.getCountryService().getCapitalCity(requestCapitalCity).enqueue(new Callback<ResponseCapitalCityEnvelope>() {
            @Override
            public void onResponse(Call<ResponseCapitalCityEnvelope> call, Response<ResponseCapitalCityEnvelope> response) {
                Log.w("ANDORID SUCCES", String.valueOf(response.code()));
                String capitalCity = response.body().getResponseBody().getCapitalCityResult().getCapitalCityResult();
                _capitalCity.setValue(capitalCity);
            }

            @Override
            public void onFailure(Call<ResponseCapitalCityEnvelope> call, Throwable t) {
                Log.w("ANDORID ERROR", t.getMessage());
                _msjError.setValue(ERROR_SERVIDOR);
            }
        });
    }

    public void getCountryCurrency(String countryCode) {
        RequestCountryCurrency requestCountryCurrency = new RequestCountryCurrency();
        requestCountryCurrency.setSoapBody(new RequestCountryCurrency.Body());
        requestCountryCurrency.getSoapBody().setCountryCurrency(new RequestCountryCurrency.CountryCurrency());
        requestCountryCurrency.getSoapBody().getCountryCurrency().setCountryISOCode(countryCode);
        RetrofitInstance.getCountryService().getCountryCurrency(requestCountryCurrency).enqueue(new Callback<ResponseCountryCurrencyEnvelope>() {
            @Override
            public void onResponse(Call<ResponseCountryCurrencyEnvelope> call, Response<ResponseCountryCurrencyEnvelope> response) {
                Log.w("ANDORID SUCCES", String.valueOf(response.code()));
                _countryCurrency.setValue(response.body().getResponseBody().getCountryCurrencyResponse().getResponseCountryCurrencyResult());
            }

            @Override
            public void onFailure(Call<ResponseCountryCurrencyEnvelope> call, Throwable t) {
                _msjError.setValue(ERROR_SERVIDOR);
            }
        });
    }


    public void getCountryFlag(String countryCode) {
        RequestCountryFlag requestCountryFlag = new RequestCountryFlag();
        requestCountryFlag.setSoapBody(new RequestCountryFlag.Body());
        requestCountryFlag.getSoapBody().setCountryFlag(new RequestCountryFlag.CountryFlag());
        requestCountryFlag.getSoapBody().getCountryFlag().setCountryISOCode(countryCode);
        RetrofitInstance.getCountryService().getCountryFlag(requestCountryFlag).enqueue(new Callback<ResponseEnvelopeCountryFlag>() {
            @Override
            public void onResponse(Call<ResponseEnvelopeCountryFlag> call, Response<ResponseEnvelopeCountryFlag> response) {
                Log.w("FLAG",response.toString());
                Log.w("ANDOROID FLAG", response.body().getResponseBody().getResponseCountryFlagResponse().getCountryFlagResultUrl());
                _countryFlag.setValue(response.body().getResponseBody().getResponseCountryFlagResponse());
            }

            @Override
            public void onFailure(Call<ResponseEnvelopeCountryFlag> call, Throwable t) {
                _msjError.setValue("Error en el wey");
            }
        });
    }

    public void getCountryIntPhoneCode(String countryCode) {
        RequestCountryIntPhoneCode requestCountryIntPhoneCode = new RequestCountryIntPhoneCode();
        requestCountryIntPhoneCode.setSoapBody(new RequestCountryIntPhoneCode.Body());
        requestCountryIntPhoneCode.getSoapBody().setCountryIntPhoneCode(new RequestCountryIntPhoneCode.CountryIntPhoneCode());
        requestCountryIntPhoneCode.getSoapBody().getCountryIntPhoneCode().setCountryISOCode(countryCode);
        RetrofitInstance.getCountryService().getCountryPhoneCode(requestCountryIntPhoneCode).enqueue(new Callback<ResponseCountryIntPhoneCodeEnvelope>() {
            @Override
            public void onResponse(Call<ResponseCountryIntPhoneCodeEnvelope> call, Response<ResponseCountryIntPhoneCodeEnvelope> response) {
                Log.w("ANDORID SUCCES", String.valueOf(response.code()));
                _countryIntPhoneCode.setValue(response.body().getResponseBody().getCountryIntPhoneCodeResponse().getCountryIntPhoneCodeResult());
            }

            @Override
            public void onFailure(Call<ResponseCountryIntPhoneCodeEnvelope> call, Throwable t) {
                _msjError.setValue(ERROR_SERVIDOR);
            }
        });
    }

}
