package com.example.soapcountry.api.services

import com.example.soapcountry.model.webservices.helloname.HelloNameRequest
import com.example.soapcountry.model.webservices.helloname.HelloNameResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface WebServices {

    @Headers("Content-Type: text/xml", "Accept-Charset: utf-8")
    @POST("hello?wsdl")
    fun helloName(@Body request: HelloNameRequest): Call<HelloNameResponse>

}