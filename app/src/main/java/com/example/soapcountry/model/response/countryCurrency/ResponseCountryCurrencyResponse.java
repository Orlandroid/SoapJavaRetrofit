package com.example.soapcountry.model.response.countryCurrency;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CountryCurrencyResponse",strict = false)
public class ResponseCountryCurrencyResponse {
    @Element(name = "CountryCurrencyResult",required = false)
    private ResponseCountryCurrencyResult responseCountryCurrencyResult;

    public ResponseCountryCurrencyResult getResponseCountryCurrencyResult() {
        return responseCountryCurrencyResult;
    }
}
