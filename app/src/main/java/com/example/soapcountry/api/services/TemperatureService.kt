package com.example.soapcountry.api.services


import com.example.soapcountry.model.temperature.request.RequestCelsiustoFarenheit
import com.example.soapcountry.model.temperature.request.RequestFarenheittoCelsius
import com.example.soapcountry.model.temperature.response.ResponseCelsiustoFarenheit
import com.example.soapcountry.model.temperature.response.ResponseFarenheittoCelsius
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TemperatureService {
    @Headers("Content-Type: text/xml", "Accept-Charset: utf-8")
    @POST("tempconvert.asmx")
    fun celsiustoFarenheit(@Body request: RequestCelsiustoFarenheit): Call<ResponseCelsiustoFarenheit>

    @Headers("Content-Type: text/xml", "Accept-Charset: utf-8")
    @POST("tempconvert.asmx")
    fun farenheittoCelsius(@Body request: RequestFarenheittoCelsius): Call<ResponseFarenheittoCelsius>


}