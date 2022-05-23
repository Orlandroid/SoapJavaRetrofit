package com.example.soapcountry.api.services;

import com.example.soapcountry.model.calculator.request.RequestCalculatorAdd;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorAdd;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CalculatorService {

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx")
    Call<ResponseCalculatorAdd> getAdd(@Body RequestCalculatorAdd body);

}