package com.example.soapcountry.model.response.countryIntPhoneCode;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "CountryIntPhoneCodeResponse",strict = false)
public class ResponseCountryIntPhoneCodeResponse {
    @Element(name = "CountryIntPhoneCodeResult",required = false)
    private String countryIntPhoneCodeResult;

    public String getCountryIntPhoneCodeResult() {
        return countryIntPhoneCodeResult;
    }
}
