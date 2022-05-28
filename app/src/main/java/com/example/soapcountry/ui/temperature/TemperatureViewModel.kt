package com.example.soapcountry.ui.temperature

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soapcountry.api.RetrofitCallBack
import com.example.soapcountry.api.RetrofitInstance
import com.example.soapcountry.model.temperature.request.RequestCelsiustoFarenheit
import com.example.soapcountry.model.temperature.request.RequestFarenheittoCelsius
import com.example.soapcountry.model.temperature.response.ResponseCelsiustoFarenheit
import com.example.soapcountry.model.temperature.response.ResponseFarenheittoCelsius
import com.example.soapcountry.util.ApiListener

class TemperatureViewModel : ViewModel() {
    var context: Context? = null


    private val _celsiustoFarenheit = MutableLiveData<String?>()
    val celsiustoFarenheit: MutableLiveData<String?>
        get() = _celsiustoFarenheit

    private val _farenheittoCelsius = MutableLiveData<String?>()
    val farenheittoCelsius: MutableLiveData<String?>
        get() = _farenheittoCelsius

    private val _msjError = MutableLiveData<String?>()
    val msjError: MutableLiveData<String?>
        get() = _msjError

    private val _errorNetwork = MutableLiveData<String?>()
    val errorNetwork: MutableLiveData<String?>
        get() = _errorNetwork


    fun celsiustoFarenheit(celsius: String) {
        val requestCelsiustoFarenheit = RequestCelsiustoFarenheit()
        requestCelsiustoFarenheit.body = RequestCelsiustoFarenheit.Body()
        requestCelsiustoFarenheit.body.celsiusToFahrenheit =
            RequestCelsiustoFarenheit.CelsiusToFahrenheit()
        requestCelsiustoFarenheit.body.celsiusToFahrenheit.celsius = celsius
        val call =
            RetrofitInstance.getTemperatureService().celsiustoFarenheit(requestCelsiustoFarenheit)
        val retrofitCallBack = RetrofitCallBack<ResponseCelsiustoFarenheit>()
        retrofitCallBack.callRetrofit(
            context,
            call,
            object : ApiListener<ResponseCelsiustoFarenheit> {
                override fun onResponse(response: ResponseCelsiustoFarenheit) {
                    _celsiustoFarenheit.value =
                        response.body.celsiusToFahrenheitResponse.celsiusToFahrenheitResult
                    _celsiustoFarenheit.value = null
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


    fun farenheittoCelsius(farenheit: Int) {
        val requestFarenheittoCelsius = RequestFarenheittoCelsius()
        requestFarenheittoCelsius.body = RequestFarenheittoCelsius.Body()
        requestFarenheittoCelsius.body.fahrenheitToCelsius =
            RequestFarenheittoCelsius.FahrenheitToCelsius()
        requestFarenheittoCelsius.body.fahrenheitToCelsius.setfahrenheit(farenheit)
        val call =
            RetrofitInstance.getTemperatureService().farenheittoCelsius(requestFarenheittoCelsius)
        val retrofitCallBack = RetrofitCallBack<ResponseFarenheittoCelsius>()
        retrofitCallBack.callRetrofit(
            context,
            call,
            object : ApiListener<ResponseFarenheittoCelsius> {
                override fun onResponse(response: ResponseFarenheittoCelsius) {
                    _farenheittoCelsius.value = response.body.fahrenheitToCelsiusResponse.fahrenheitToCelsiusResult
                    _farenheittoCelsius.value = null
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