package com.example.soapcountry.api;

import com.example.soapcountry.model.numbers.request.numberstowords.RequestNumbersToWords;
import com.example.soapcountry.model.numbers.response.numberstowords.ResponseNumbersToWordsEnvelope;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NumbersService {

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("NumberConversion.wso")
    Call<ResponseNumbersToWordsEnvelope> numberToWords(@Body RequestNumbersToWords body);


}
