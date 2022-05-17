package com.example.soapcountry.model.response.countryIntPhoneCode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Body",strict = false)
public class ResponseBody {
    @Element(name = "CountryIntPhoneCodeResponse",required = false)
    private ResponseCountryIntPhoneCodeResponse countryIntPhoneCodeResponse;

    public ResponseCountryIntPhoneCodeResponse getCountryIntPhoneCodeResponse() {
        return countryIntPhoneCodeResponse;
    }
}
