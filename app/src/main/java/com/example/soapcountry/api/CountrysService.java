package com.example.soapcountry.api;

import com.example.soapcountry.model.request.capitalcity.RequestCapitalCity;
import com.example.soapcountry.model.request.countryCurrency.RequestCountryCurrency;
import com.example.soapcountry.model.request.countryFlag.RequestCountryFlag;
import com.example.soapcountry.model.request.countryIntPhoneCode.RequestCountryIntPhoneCode;
import com.example.soapcountry.model.request.listcountrys.RequestCountrysList;
import com.example.soapcountry.model.response.capitalcity.ResponseCapitalCityEnvelope;
import com.example.soapcountry.model.response.countryCurrency.ResponseCountryCurrencyEnvelope;
import com.example.soapcountry.model.response.countryFlag.ResponseEnvelopeCountryFlag;
import com.example.soapcountry.model.response.countryIntPhoneCode.ResponseCountryIntPhoneCodeEnvelope;
import com.example.soapcountry.model.response.listcountry.ResponseCountryListEnvelop;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CountrysService {

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("CountryInfoService.wso")
    Call<ResponseCountryListEnvelop> getCountryList(@Body RequestCountrysList body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("CountryInfoService.wso")
    Call<ResponseCapitalCityEnvelope> getCapitalCity(@Body RequestCapitalCity body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("CountryInfoService.wso")
    Call<ResponseCountryCurrencyEnvelope> getCountryCurrency(@Body RequestCountryCurrency body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("CountryInfoService.wso")
    Call<ResponseEnvelopeCountryFlag> getCountryFlag(@Body RequestCountryFlag body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("CountryInfoService.wso")
    Call<ResponseCountryIntPhoneCodeEnvelope> getCountryPhoneCode(@Body RequestCountryIntPhoneCode body);


}
