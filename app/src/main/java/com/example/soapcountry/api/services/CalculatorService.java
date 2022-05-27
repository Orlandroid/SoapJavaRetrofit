package com.example.soapcountry.api.services;

import com.example.soapcountry.model.calculator.request.RequestCalculatorAdd;
import com.example.soapcountry.model.calculator.request.RequestCalculatorDivide;
import com.example.soapcountry.model.calculator.request.RequestCalculatorMultiply;
import com.example.soapcountry.model.calculator.request.RequestCalculatorSubtract;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorAdd;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorDivide;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorMultiply;
import com.example.soapcountry.model.calculator.response.ResponseCalculatorSubtract;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CalculatorService {

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx")
    Call<ResponseCalculatorAdd> getAdd(@Body RequestCalculatorAdd body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("calculator.asmx")
    Call<ResponseCalculatorSubtract> getSubtract(@Body RequestCalculatorSubtract body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("calculator.asmx")
    Call<ResponseCalculatorMultiply> getMultiply(@Body RequestCalculatorMultiply body);

    @Headers({"Content-Type: text/xml", "Accept-Charset: utf-8"})
    @POST("calculator.asmx")
    Call<ResponseCalculatorDivide> getDivide(@Body RequestCalculatorDivide body);

}