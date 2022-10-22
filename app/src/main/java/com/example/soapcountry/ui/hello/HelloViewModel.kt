package com.example.soapcountry.ui.hello

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soapcountry.api.RetrofitCallBack
import com.example.soapcountry.api.RetrofitInstance
import com.example.soapcountry.model.webservices.helloname.HelloNameRequest
import com.example.soapcountry.model.webservices.helloname.HelloNameResponse
import com.example.soapcountry.util.ApiListener

class HelloViewModel : ViewModel() {


    var context: Context? = null

    private val _msjError = MutableLiveData<String?>()
    val msjError: MutableLiveData<String?>
        get() = _msjError

    private val _errorNetwork = MutableLiveData<String?>()
    val errorNetwork: MutableLiveData<String?>
        get() = _errorNetwork

    private val _helloNameResponse = MutableLiveData<HelloNameResponse?>()
    val helloNameResponse: MutableLiveData<HelloNameResponse?>
        get() = _helloNameResponse


    fun helloName(name: String) {
        val helloRequest = HelloNameRequest()
        helloRequest.header = HelloNameRequest.Header()
        helloRequest.body = HelloNameRequest.Body()
        helloRequest.body!!.helloRequest = HelloNameRequest.HelloRequest()
        helloRequest.body!!.helloRequest?.name = name
        val call =
            RetrofitInstance.getWebServices().helloName(helloRequest)
        val retrofitCallBack = RetrofitCallBack<HelloNameResponse>()
        retrofitCallBack.callRetrofit(
            context,
            call,
            object : ApiListener<HelloNameResponse> {
                override fun onResponse(response: HelloNameResponse) {
                    _helloNameResponse.value = response
                    _helloNameResponse.value = null
                }

                override fun onFailure(error: String) {
                    _msjError.value = error
                    _msjError.value = null

                }

                override fun ErrorNetwork(mesage: String) {
                    _errorNetwork.value = mesage
                    _errorNetwork.value = null
                }

            })
    }
}